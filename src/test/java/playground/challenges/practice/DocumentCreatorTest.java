package playground.challenges.practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("PT02 - Criador de Documentos")
public class DocumentCreatorTest {

    @Test
    @DisplayName("Caso 1: Criar documentos corretos")
    public void testDocumentCreation() {
        DocumentCreator creator = new DocumentCreator();

        DocumentCreator.Document pdf = creator.create(DocumentCreator.Type.PDF);
        DocumentCreator.Document word = creator.create(DocumentCreator.Type.WORD);
        DocumentCreator.Document excel = creator.create(DocumentCreator.Type.EXCEL);

        assertNotNull(pdf);
        assertEquals("Writing PDF", pdf.write());

        assertNotNull(word);
        assertEquals("Writing Word", word.write());

        assertNotNull(excel);
        assertEquals("Writing Excel", excel.write());
    }

    @Test
    @DisplayName("Caso 2: Tipo nulo deve lançar exceção")
    public void testNullType() {
        DocumentCreator creator = new DocumentCreator();
        assertThrows(IllegalArgumentException.class, () -> creator.create(null));
    }
}
