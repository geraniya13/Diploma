package diploma.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/web/credentials.properties"
})
public interface CredentialsConfig extends Config {
    String baseURI();
    String userEmail();
    String userPassword();
}
