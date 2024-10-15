package Model;

import lombok.Data;

@Data
public class ValidateVatRequest {

    public CountryCode countryCode;
    public String vatNumber;
    
    
}
