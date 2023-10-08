package ms.pix.infra.bb;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MultivaluedHashMap;
import jakarta.ws.rs.core.MultivaluedMap;

import ms.pix.adapters.PixGateway;
import ms.pix.adapters.RestApiBB;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.UUID;

@ApplicationScoped
public class BBPix implements PixGateway {

    @Inject
    @RestClient
    RestApiBB restApiBB;

    @Override
    public void pixCreate(UUID id) {

    }

    @Override
    public String generateToken() {
        MultivaluedMap<String, String> formData = new MultivaluedHashMap<>();
        formData.add("grant_type", "client_credentials");
        formData.add("client_id", "");
        formData.add("client_secret", "");
        return this.restApiBB.generateToken(formData);
    }
}
