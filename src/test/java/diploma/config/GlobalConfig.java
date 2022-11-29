package diploma.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/global.properties"
})
public interface GlobalConfig extends org.aeonbits.owner.Config {
    @Config.Key("baseURI")
    String getBaseURI();

    @Config.Key("userEmail")
    String getUserEmail();

    @Config.Key("userPassword")
    String getUserPassword();
}
