package ms.pix.application;

import jakarta.inject.Inject;
import ms.pix.adapters.PixGateway;
import ms.pix.core.PixUseCase;

import java.util.UUID;

public class PixService implements PixUseCase {
    private final PixGateway pixGateeway;

    public PixService(PixGateway pixGateeway) {
        this.pixGateeway = pixGateeway;
    }

    @Override
    public void createPix(UUID id) {
        this.pixGateeway.pixCreate(id);
    }
}
