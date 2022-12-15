package diploma.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/mobile/${environment}.properties"
})
public interface MobileConfig extends Config {
    String browserstackUser();
    String browserstackKey();
    String platformName();
    String appUrl();
    String device();
    String osVersion();
    String project();
    String build();
    String name();
    String remoteUrl();
    String appPackage();
    String appActivity();
}