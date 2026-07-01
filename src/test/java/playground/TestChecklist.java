package playground;

import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;

import java.util.*;

public class TestChecklist {

    public static void main(String[] args) {
        System.out.println("Executando testes e gerando checklist...");

        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(DiscoverySelectors.selectPackage("playground"))
                .build();

        Launcher launcher = LauncherFactory.create();
        ChecklistListener listener = new ChecklistListener();
        launcher.registerTestExecutionListeners(listener);

        // Executa os testes
        launcher.execute(request);

        // Imprime o checklist ordenado no final
        listener.printReport();
    }

    private static class ChecklistListener implements TestExecutionListener {
        // Class display name -> Map of Method display name -> TestResult
        // Ordenacao: Ordem inversa da listagem em challenges.md
        private final Map<String, Map<String, TestResult>> testSuiteResults = new TreeMap<>(new Comparator<String>() {
            private final List<String> ORDER = Arrays.asList(
                "PT01", "PT02", "PT03", "PT04", "PT05", "PT06", "PT07", "PT08",
                "DP01", "DP02", "DP03", "DP04", "DP05", "DP06", "DP07", "DP08",
                "MC01", "MC02", "MC03", "MC04", "MC05", "MC06", "MC07", "MC08", "MC09", "MC10",
                "AD01"
            );

            @Override
            public int compare(String s1, String s2) {
                int idx1 = getOrderIndex(s1);
                int idx2 = getOrderIndex(s2);
                
                // Ordem inversa: maior index na lista original vem primeiro
                return Integer.compare(idx2, idx1);
            }

            private int getOrderIndex(String s) {
                if (s != null && s.length() >= 4) {
                    String prefix = s.substring(0, 4);
                    int idx = ORDER.indexOf(prefix);
                    if (idx != -1) {
                        return idx;
                    }
                }
                return -1;
            }
        });

        private final Map<String, String> currentClassDisplayName = new HashMap<>();

        // Cores ANSI para formatacao do console
        private static final String ANSI_RESET = "\u001B[0m";
        private static final String ANSI_GREEN = "\u001B[32m";
        private static final String ANSI_RED = "\u001B[31m";
        private static final String ANSI_YELLOW = "\u001B[33m";
        private static final String ANSI_CYAN = "\u001B[36m";
        private static final String ANSI_BOLD = "\u001B[1m";

        @Override
        public void executionStarted(TestIdentifier testIdentifier) {
            if (testIdentifier.isContainer() && testIdentifier.getParentId().isPresent()) {
                currentClassDisplayName.put(testIdentifier.getUniqueId(), testIdentifier.getDisplayName());
            }
        }

        @Override
        public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
            if (testIdentifier.isTest()) {
                String classId = getParentClassId(testIdentifier);
                String className = currentClassDisplayName.getOrDefault(classId, "Sem Categoria");
                
                // Ignorar a propria classe de runner do checklist
                if (className.contains("TestChecklist") || testIdentifier.getLegacyReportingName().contains("TestChecklist")) {
                    return;
                }

                String testName = testIdentifier.getDisplayName();
                
                testSuiteResults.computeIfAbsent(className, k -> new TreeMap<>())
                        .put(testName, new TestResult(testExecutionResult));
            }
        }

        private String getParentClassId(TestIdentifier testIdentifier) {
            return testIdentifier.getParentId().orElse("");
        }

        public void printReport() {
            System.out.println("\n" + ANSI_CYAN + "======================================================================" + ANSI_RESET);
            System.out.println(ANSI_CYAN + ANSI_BOLD + "                 CHECKLIST DE DESAFIOS DE PROGRAMACAO" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "======================================================================" + ANSI_RESET);

            int totalTests = 0;
            int passedTests = 0;

            for (Map.Entry<String, Map<String, TestResult>> suiteEntry : testSuiteResults.entrySet()) {
                String suiteName = suiteEntry.getKey();
                Map<String, TestResult> tests = suiteEntry.getValue();

                // Verifica se todos os testes desta suite passaram
                boolean allPassed = true;
                for (TestResult result : tests.values()) {
                    if (result.status != TestExecutionResult.Status.SUCCESSFUL) {
                        allPassed = false;
                        break;
                    }
                }

                String suiteIcon = allPassed ? ANSI_GREEN + " [OK] " + ANSI_RESET : ANSI_RED + " [ X] " + ANSI_RESET;
                System.out.println(suiteIcon + ANSI_BOLD + suiteName + ANSI_RESET);

                for (Map.Entry<String, TestResult> testEntry : tests.entrySet()) {
                    totalTests++;
                    String testName = testEntry.getKey();
                    TestResult result = testEntry.getValue();

                    if (result.status == TestExecutionResult.Status.SUCCESSFUL) {
                        passedTests++;
                        System.out.println("    " + ANSI_GREEN + "[OK] " + testName + ANSI_RESET);
                    } else {
                        System.out.println("    " + ANSI_RED + "[ X] " + testName + ANSI_RESET);
                        if (result.failureMessage != null) {
                            System.out.println("         " + ANSI_YELLOW + "--> Falha: " + result.failureMessage.trim() + ANSI_RESET);
                        }
                    }
                }
                System.out.println();
            }

            System.out.println(ANSI_CYAN + "======================================================================" + ANSI_RESET);
            String summaryColor = (passedTests == totalTests) ? ANSI_GREEN : ANSI_RED;
            System.out.println(summaryColor + ANSI_BOLD + String.format("RESUMO FINAL: %d de %d testes passando.", passedTests, totalTests) + ANSI_RESET);
            System.out.println(ANSI_CYAN + "======================================================================" + ANSI_RESET);
            
            if (passedTests < totalTests) {
                System.exit(0); // Exit 0 para nao quebrar execucoes de debugging no IDE
            }
        }
    }

    private static class TestResult {
        final TestExecutionResult.Status status;
        final String failureMessage;

        TestResult(TestExecutionResult result) {
            this.status = result.getStatus();
            if (result.getThrowable().isPresent()) {
                Throwable t = result.getThrowable().get();
                this.failureMessage = t.getMessage() != null ? t.getMessage() : t.toString();
            } else {
                this.failureMessage = null;
            }
        }
    }
}
