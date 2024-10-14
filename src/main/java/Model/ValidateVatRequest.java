package Model;

import lombok.Data;

@Data
public class ValidateVatRequest {

    public String countryCode = "EL";
    public String vatNumber;
    
    
}
