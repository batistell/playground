package playground.challenges.patterns;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("DP04 - Adapter (XML para JSON Reader)")
public class AdapterPatternTest {

    @Test
    @DisplayName("Caso 1: Adaptar leitura XML legada para a nova interface JSON")
    public void testXmlToJsonAdapter() {
        AdapterPattern.XmlReader xmlReader = new AdapterPattern.XmlReader();
        AdapterPattern.JsonParser parser = new AdapterPattern.XmlToJsonAdapter(xmlReader);

        // Entrada fictícia do cliente em JSON
        String clientJsonInput = "{\"data\": \"desafio_adapter\"}";

        // O adaptador deve processar o JSON, obter o XML correspondente e gerar um retorno formatado
        String adapterResult = parser.parseJson(clientJsonInput);

        assertNotNull(adapterResult, "O resultado retornado pelo adaptador não deve ser nulo");
        
        // Verifica se o XML foi encapsulado e se o retorno simula um JSON contendo o XML
        assertTrue(adapterResult.contains("<xml>desafio_adapter</xml>"), "O resultado deve conter o XML gerado");
        assertTrue(adapterResult.startsWith("{") && adapterResult.endsWith("}"), "O resultado deve simular um formato JSON");
        assertTrue(adapterResult.contains("\"xmlData\""), "O resultado deve conter a chave xmlData");
    }
}
