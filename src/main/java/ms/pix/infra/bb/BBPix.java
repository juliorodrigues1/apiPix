package ms.pix.infra.bb;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MultivaluedHashMap;
import jakarta.ws.rs.core.MultivaluedMap;

import ms.pix.adapters.PixGateway;
import ms.pix.adapters.RestPix;
import ms.pix.adapters.TokenBB;
import ms.pix.core.exceptions.TokenNotFoundException;
import ms.pix.models.PixCreate;
import ms.pix.models.ResponseToken;
import ms.pix.profile.Token;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import jakarta.ws.rs.core.Response;
import java.util.UUID;

@ApplicationScoped
public class BBPix  {

    @Inject
    @RestClient
    TokenBB restApiBB;

    @Inject
    @RestClient
    RestPix restPix;

    @ConfigProperty(name = "bb.basic")
    private String basic;

    @ConfigProperty(name = "bb.gw-dev-app-key")
    private String appKey;

//    @Override
    public Response pixCreate(PixCreate pixCreate) {
        String txid = UUID.randomUUID().toString().replace("-", "");

        try {
             Response response = this.restPix.createPix(txid, this.appKey, Token.token, pixCreate);
            String responseBody = response.readEntity(String.class);
            System.out.println("Corpo da Resposta: " + responseBody);
        }catch (WebApplicationException e) {
            this.generateToken();
           return this.restPix.createPix(txid, this.appKey, Token.token, pixCreate);
        }

        return null;

    }

//    @Override
    public void generateToken() {
        String authorizationHeader = "Basic " + this.basic;
        MultivaluedMap<String, String> formData = new MultivaluedHashMap<>();
        formData.add("grant_type", "client_credentials");
        // Faça a chamada para obter o token
        Response response = restApiBB.generateToken(authorizationHeader, formData);
        // Verifique a resposta e trate de acordo
        if (response.getStatus() == Response.Status.CREATED.getStatusCode()) {


            ResponseToken responseToken = response.readEntity(ResponseToken.class);

            Token.token = "Bearer "+responseToken.getAccess_token();

        }else throw new TokenNotFoundException("Token not found.");


    }
}
