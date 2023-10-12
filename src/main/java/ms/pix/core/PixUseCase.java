package ms.pix.core;

import jakarta.ws.rs.core.Response;
import ms.pix.models.PixCreate;

import java.util.UUID;

public interface PixUseCase {

    Response createPix(PixCreate pixCreate);

    void generateToken();
}
