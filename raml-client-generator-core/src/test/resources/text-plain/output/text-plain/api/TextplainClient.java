
package text-plain.api;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import text-plain.resource.ping.Ping;

public class TextplainClient {

    private String _baseUrl;
    public final Ping ping;

    public TextplainClient(String baseUrl) {
        _baseUrl = baseUrl;
        ping = new Ping(getBaseUri(), getClient());
    }

    protected Client getClient() {
        return ClientBuilder.newClient();
    }

    protected String getBaseUri() {
        return _baseUrl;
    }

    public static TextplainClient create(String baseUrl) {
        return new TextplainClient(baseUrl);
    }

}
