package diploma.tests.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddToBasketResponseModel {
    private boolean success;
    private String redirect;
    private Ecommerce ecommerce;
}
