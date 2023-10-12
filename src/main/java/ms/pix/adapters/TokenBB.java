package ms.pix.adapters;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "https://oauth.sandbox.bb.com.br/")
public interface TokenBB {

    @POST
    @Path("oauth/token")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    Response generateToken(@HeaderParam("Authorization") String authorizationHeader,
                           MultivaluedMap<String, String> formParameters);
}
