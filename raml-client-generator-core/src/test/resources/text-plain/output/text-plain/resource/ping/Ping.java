
package text-plain.resource.ping;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status.Family;
import text-plain.exceptions.TextplainException;

public class Ping {

    private String _baseUrl;
    private Client _client;

    public Ping(String baseUrl, Client _client) {
        _baseUrl = (baseUrl +"/ping");
        this._client = _client;
    }

    protected Client getClient() {
        return this._client;
    }

    private String getBaseUri() {
        return _baseUrl;
    }

    public String get() {
        WebTarget target = this._client.target(getBaseUri());
        final javax.ws.rs.client.Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON_TYPE);
        Response response = invocationBuilder.get();
        if (response.getStatusInfo().getFamily()!= Family.SUCCESSFUL) {
            Response.StatusType statusInfo = response.getStatusInfo();
            throw new TextplainException(statusInfo.getStatusCode(), statusInfo.getReasonPhrase());
        }
        return response.readEntity(String.class);
    }

}
