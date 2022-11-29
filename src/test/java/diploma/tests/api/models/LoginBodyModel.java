package diploma.tests.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class LoginBodyModel {
    private String token,
            email,
            password;

    public Map<String, String> getFieldsAsMap() {
        Map<String, String> values = new HashMap<>();
        values.put("_token", this.getToken());
        values.put("email", this.getEmail());
        values.put("password", this.getPassword());
        return values;
    }
}
