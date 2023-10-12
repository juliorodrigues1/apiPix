package ms.pix.adapters;

import jakarta.ws.rs.core.Response;
import ms.pix.models.PixCreate;
public interface PixGateway {

    Response pixCreate(PixCreate pixCreate);

    void generateToken();
}
