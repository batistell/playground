package playground.challenges.patterns;

/**
 * DP04: Adapter (XML para JSON Reader)
 * 
 * O padrão Adapter permite que classes com interfaces incompatíveis trabalhem juntas,
 * traduzindo a interface de uma classe na interface esperada pelos clientes.
 * 
 * Exercício:
 * Implemente um adaptador `XmlToJsonAdapter` que faz com que a classe legada `XmlReader`
 * seja compatível com a nova interface de cliente `JsonParser`.
 */
public class AdapterPattern {

    // Nova interface que o cliente espera usar
    public interface JsonParser {
        String parseJson(String json);
    }

    // Classe de serviço existente (legada) com interface incompatível
    public static class XmlReader {
        public String readXml(String xml) {
            // Retorna o conteúdo encapsulado em uma representação simples de XML
            return "<xml>" + xml + "</xml>";
        }
    }

    // Adaptador que torna XmlReader compatível com JsonParser
    public static class XmlToJsonAdapter implements JsonParser {
        
        private final XmlReader xmlReader;

        public XmlToJsonAdapter(XmlReader xmlReader) {
            this.xmlReader = xmlReader;
        }

        @Override
        public String parseJson(String json) {
            // TODO: Implemente a adaptação.
            // 1. Converta o formato de entrada JSON (ex: {"data": "conteudo"}) para o dado que o XmlReader espera.
            //    Para este exercício simples, assuma que você extrairá o valor de "data" (ex: "conteudo").
            // 2. Chame o método readXml da classe XmlReader com esse valor extraído.
            // 3. Simule a conversão do resultado XML retornado pelo XmlReader de volta para um formato JSON (ex: {"xmlData": "<xml>conteudo</xml>"}) e retorne-o.
            
            return null;
        }
    }
}
