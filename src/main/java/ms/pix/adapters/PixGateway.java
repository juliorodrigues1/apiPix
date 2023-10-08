package ms.pix.adapters;

import java.util.UUID;

public interface PixGateway {

    void pixCreate(UUID id);

    String generateToken();
}
