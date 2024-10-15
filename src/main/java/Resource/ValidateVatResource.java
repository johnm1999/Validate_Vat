package Resource;

import Model.CountryCode;
import Model.ValidateVatRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import Service.ValidateVatInterface;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;

@Path("/checkVat")
public class ValidateVatResource {
    
    @RestClient
    ValidateVatInterface validateVatService;
    
    @GET
    @Path("/{countryCode}/{vatNumber}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkVat(@PathParam("countryCode") String countryCode,@PathParam("vatNumber") String vatNumber){
        
        CountryCode code;
        try {
            code = CountryCode.valueOf(countryCode.toUpperCase());
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid Country Code").build();
        }
        ValidateVatRequest vatRequest = new ValidateVatRequest();
        vatRequest.setCountryCode(code);
        vatRequest.setVatNumber(vatNumber);
        
        return Response.ok(validateVatService.checkValidateVat(vatRequest)).build();
    }
}
