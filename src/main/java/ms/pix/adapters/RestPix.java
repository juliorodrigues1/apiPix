package ms.pix.adapters;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ms.pix.models.PixCreate;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "https://api.sandbox.bb.com.br/pix/v2/")
public interface RestPix {
    @PUT
    @Path("cobv/{txid}")
    @Produces(MediaType.APPLICATION_JSON)
    Response createPix(@PathParam("txid") String txid, @QueryParam("gw-dev-app-key") String appKey, @HeaderParam("Authorization") String token, PixCreate pixCreate);
}
