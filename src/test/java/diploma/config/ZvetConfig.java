package diploma.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/web/${environment}.properties"
})
public interface ZvetConfig extends org.aeonbits.owner.Config {

    @Key("browserName")
    String getBrowserName();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("browserSize")
    String getBrowserSize();

    @Key("browserPosition")
    String getBrowserPosition();

    @Key("selenoidRemoteUrl")
    String getRemoteUrl();
}
