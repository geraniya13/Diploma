package diploma.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/web/${environment}.properties"
})
public interface ZvetConfig extends Config {
    String browserName();
    String browserVersion();
    String browserSize();
    String browserPosition();
    String remoteUrl();
}
