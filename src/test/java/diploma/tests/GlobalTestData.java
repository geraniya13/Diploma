package diploma.tests;

import io.restassured.http.Cookies;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class GlobalTestData {
    private static volatile GlobalTestData instance;
    private String authorizeButtonToken;
    private Cookies allDetailedCookies;

    public static GlobalTestData getInstance() {
        GlobalTestData localInstance = instance;
        if (localInstance == null) {
            synchronized (GlobalTestData.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new GlobalTestData();
                }
            }
        }
        return localInstance;
    }

    public String getInfoFromBody(String info, String body) {
        String token = "";
        String[] contents = body.split("\n");
        for (String line : contents) {
            if (line.contains("name=\"" + info +"\"")) {
                token = StringUtils.substringBetween(line, "value=\"", "\"/>");
            }
        }
        return token;
    }

    public String getCorrectXsrfToken() {
        String xsfrToken = this.getAllDetailedCookies().getValue("XSRF-TOKEN");
        if (xsfrToken.contains("%")) {
            xsfrToken = xsfrToken.replace("%3D", "=");
        }
        return xsfrToken;
    }
}
