package playground.challenges.mystery;

import java.util.HashMap;
import java.util.Map;

/**
 * MC08: Construção de Requisições HTTP
 * 
 * Requisito:
 * Você precisa criar uma representação para requisições HTTP (`HttpRequest`). 
 * Uma requisição pode ter parâmetros obrigatórios (URL, Método HTTP) e diversos opcionais (headers, query parameters, body).
 * Criar construtores com múltiplos parâmetros opcionais geraria construtores sobrecarregados confusos (telescópicos).
 * O objetivo é fornecer uma forma elegante, legível e passo-a-passo de montar o objeto final de forma fluente.
 * 
 * Exercício:
 * Implemente a estrutura adequada para a construção passo-a-passo do objeto HttpRequest.
 */
public class HttpRequestBuilder {

    public static class HttpRequest {
        private final String url;
        private final String method;
        private final Map<String, String> headers;
        private final String body;

        private HttpRequest(String url, String method, Map<String, String> headers, String body) {
            this.url = url;
            this.method = method;
            this.headers = headers;
            this.body = body;
        }

        public String getUrl() { return url; }
        public String getMethod() { return method; }
        public Map<String, String> getHeaders() { return headers; }
        public String getBody() { return body; }
    }

    // TODO: Implemente a estrutura fluente do montador abaixo.
    public static class Builder {
        private String url;
        private String method = "GET"; // Método padrão
        private final Map<String, String> headers = new HashMap<>();
        private String body;

        public Builder url(String url) {
            // TODO: Configure a URL.
            return this;
        }

        public Builder method(String method) {
            // TODO: Configure o método (ex: GET, POST).
            return this;
        }

        public Builder header(String key, String value) {
            // TODO: Adicione um cabeçalho.
            return this;
        }

        public Builder body(String body) {
            // TODO: Configure o corpo da requisição.
            return this;
        }

        public HttpRequest build() {
            // TODO: Instancie e retorne a requisição final.
            // Lance um IllegalStateException se a URL não for fornecida (nula ou vazia).
            return null;
        }
    }
}
