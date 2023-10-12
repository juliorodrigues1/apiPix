package ms.pix.application;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import ms.pix.adapters.PixGateway;
import ms.pix.core.PixUseCase;
import ms.pix.infra.bb.BBPix;
import ms.pix.models.PixCreate;


@ApplicationScoped
public class PixService implements PixUseCase {

    private BBPix pixGateeway;

    public PixService(BBPix pixGateeway) {
        this.pixGateeway = pixGateeway;
    }


    @Override
    public Response createPix(PixCreate pixCreate) {
       return this.pixGateeway.pixCreate(pixCreate);
    }

    @Override
    public void generateToken() {
        this.pixGateeway.generateToken();
    }
}
