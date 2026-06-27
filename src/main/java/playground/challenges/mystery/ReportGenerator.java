package playground.challenges.mystery;

/**
 * MC02: Exportador de Relatórios
 * 
 * Requisito:
 * Sua aplicação precisa gerar relatórios corporativos em diferentes formatos (PDF, CSV, HTML).
 * O código do cliente que solicita o relatório não deve se preocupar com os detalhes de instanciação
 * das classes de formato específico nem usar a palavra-chave "new" para cada formato de relatório de maneira acoplada.
 * A criação do relatório correto deve ser decidida dinamicamente com base em um tipo enum de formato de saída.
 * 
 * Exercício:
 * Desenhe a estrutura de instanciação encapsulada adequada para criar e retornar os relatórios corretos.
 */
public class ReportGenerator {

    public enum Format {
        PDF, CSV, HTML
    }

    public interface Report {
        String generate(String title, String content);
    }

    // TODO: Implemente os formatos de relatórios abaixo:
    // 1. PdfReport: Deve retornar "[PDF Report] Title: " + title + " | Content: " + content
    // 2. CsvReport: Deve retornar "[CSV Report] Title: " + title + " | Content: " + content
    // 3. HtmlReport: Deve retornar "[HTML Report] Title: " + title + " | Content: " + content

    public static class PdfReport implements Report {
        @Override
        public String generate(String title, String content) {
            // TODO: Lógica do relatório PDF.
            return null;
        }
    }

    public static class CsvReport implements Report {
        @Override
        public String generate(String title, String content) {
            // TODO: Lógica do relatório CSV.
            return null;
        }
    }

    public static class HtmlReport implements Report {
        @Override
        public String generate(String title, String content) {
            // TODO: Lógica do relatório HTML.
            return null;
        }
    }

    public Report createReport(Format format) {
        // TODO: Implemente o mecanismo que retorna a instância de Report correta de acordo com o Format informado.
        // Lance uma IllegalArgumentException caso o formato fornecido seja nulo.
        
        return null;
    }
}
