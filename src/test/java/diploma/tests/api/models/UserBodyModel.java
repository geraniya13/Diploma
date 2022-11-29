package diploma.tests.api.models;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Data
public class UserBodyModel {
    private String token,
            firstname,
            lastname,
            email,
            telephone,
            fax;

    public Map<String, String> getFieldsAsMap() {
        Map<String, String> values = new HashMap<>();
        values.put("_token", this.getToken());
        values.put("firstname", this.getEmail());
        values.put("lastname", this.getLastname());
        values.put("email", this.getEmail());
        values.put("telephone", this.getTelephone());
        values.put("fax", this.getFax());
        return values;
    }

    public Map<String, String> getFieldsAsMap(String newName) {
        Map<String, String> values = new HashMap<>();
        values.put("_token", this.getToken());
        values.put("firstname", newName);
        values.put("lastname", this.getLastname());
        values.put("email", this.getEmail());
        values.put("telephone", this.getTelephone());
        values.put("fax", this.getFax());
        return values;
    }

    public String getInfoFromBody(String info, String body) {
        String extInfo = "";
        String[] contents = body.split("\n");
        for (String line : contents) {
            if (line.contains("name=\"" + info +"\"")) {
                extInfo = StringUtils.substringBetween(line, "value=\"", "\"");
                break;
            }
        }
        return extInfo;
    }
}
