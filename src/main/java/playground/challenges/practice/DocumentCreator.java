package playground.challenges.practice;

/**
 * PT02: Criador de Documentos
 * 
 * Requisito:
 * Seu editor de textos precisa criar diferentes tipos de documentos (como PDF, Word ou Excel).
 * O cliente que solicita a criação de um documento não deve acoplar-se diretamente às classes
 * concretas (ex: "new PdfDocument()"), mas sim utilizar um ponto de entrada genérico, permitindo
 * que o processo de fabricação varie livremente ou que novos tipos de documentos sejam adicionados
 * sem alterar o solicitante.
 * 
 * Exercício:
 * Implemente as classes de documentos e a estrutura de fabricação necessária para criar e retornar os documentos corretos.
 */
public class DocumentCreator {
/**
 * response: Este desafio é um exemplo clássico do padrão **Factory Method**.
 * 
 */
    public interface Document {
        String write();
    }

    public enum Type {
        PDF, WORD, EXCEL
    }

    // TODO: Crie as classes para os tipos de documentos (PdfDocument, WordDocument, ExcelDocument) 
    // que implementam a interface Document:
    // - PDF deve retornar "Writing PDF"
    // - WORD deve retornar "Writing Word"
    // - EXCEL deve retornar "Writing Excel"

    class PdfDocument implements Document {
        @Override
        public String write() {
            return "Writing PDF";
        }
    }

    class WordDocument implements Document {
        @Override
        public String write() {
            return "Writing Word";
        }
    }

    class ExcelDocument implements Document {
        @Override
        public String write() {
            return "Writing Excel";
        }
    }
    // TODO: Implemente o método abaixo para retornar o documento correto com base no Type.
    // Se o tipo for nulo, lance uma IllegalArgumentException.
    public Document create(Type type) {
        if (type == null) {
            throw new IllegalArgumentException("Type cannot be null");
        }
        switch (type) {
            case PDF:
                return new PdfDocument();
            case WORD:
                return new WordDocument();
            case EXCEL:
                return new ExcelDocument();
            default:
                throw new IllegalArgumentException("Unsupported document type: " + type);
        }
    }
}
