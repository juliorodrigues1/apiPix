package ms.pix.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import ms.pix.infra.bb.BBPix;

@Path("/pix")
public class PixController {

    @Inject
    BBPix bbPix;

    @GET
    public void token(){
        System.out.println(this.bbPix.generateToken());
    }
}
