package Service;

import Model.ValidateVatRequest;
import Model.ValidateVatResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/check-vat-number")
@RegisterRestClient(configKey = "vat-api")
public interface ValidateVatInterface {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    ValidateVatResponse checkValidateVat(ValidateVatRequest validateVatRequest);
    
}
