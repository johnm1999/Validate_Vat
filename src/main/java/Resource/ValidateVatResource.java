package Resource;

import Model.ValidateVatRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import Service.ValidateVatInterface;

@Path("/checkVat")
public class ValidateVatResource {
    
    @RestClient
    ValidateVatInterface validateVatService;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkVat(ValidateVatRequest vatRequest){
        return Response.ok(validateVatService.checkValidateVat(vatRequest)).build();
    }
}
