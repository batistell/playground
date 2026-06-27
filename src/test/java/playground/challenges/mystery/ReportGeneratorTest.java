package playground.challenges.mystery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("MC02 - Exportador de Relatórios")
public class ReportGeneratorTest {

    private final ReportGenerator generator = new ReportGenerator();

    @Test
    @DisplayName("Caso 1: Gerar relatório no formato PDF")
    public void testReport_Pdf() {
        ReportGenerator.Report report = generator.createReport(ReportGenerator.Format.PDF);
        assertNotNull(report);
        assertTrue(report instanceof ReportGenerator.PdfReport);
        assertEquals("[PDF Report] Title: Vendas | Content: Total R$ 100", report.generate("Vendas", "Total R$ 100"));
    }

    @Test
    @DisplayName("Caso 2: Gerar relatório no formato CSV")
    public void testReport_Csv() {
        ReportGenerator.Report report = generator.createReport(ReportGenerator.Format.CSV);
        assertNotNull(report);
        assertTrue(report instanceof ReportGenerator.CsvReport);
        assertEquals("[CSV Report] Title: Vendas | Content: Total R$ 100", report.generate("Vendas", "Total R$ 100"));
    }

    @Test
    @DisplayName("Caso 3: Gerar relatório no formato HTML")
    public void testReport_Html() {
        ReportGenerator.Report report = generator.createReport(ReportGenerator.Format.HTML);
        assertNotNull(report);
        assertTrue(report instanceof ReportGenerator.HtmlReport);
        assertEquals("[HTML Report] Title: Vendas | Content: Total R$ 100", report.generate("Vendas", "Total R$ 100"));
    }

    @Test
    @DisplayName("Caso 4: Lançar exceção para formato de relatório nulo")
    public void testReport_NullException() {
        assertThrows(IllegalArgumentException.class, () -> {
            generator.createReport(null);
        });
    }
}
