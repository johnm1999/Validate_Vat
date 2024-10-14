package Service;

import Model.ValidateVatRequest;
import Model.ValidateVatResponse;
import org.eclipse.microprofile.rest.client.inject.RestClient;

public class ValidateVatService {

    @RestClient
    ValidateVatInterface validateVatService;

    public boolean checkValidateVat(ValidateVatRequest validateVatRequest) {
        ValidateVatResponse validateVatResponse = validateVatService.checkValidateVat(validateVatRequest);
        return validateVatResponse.isValid();
    }
}
