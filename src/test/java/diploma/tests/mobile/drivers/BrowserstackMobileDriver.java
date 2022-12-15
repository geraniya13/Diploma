package diploma.tests.mobile.drivers;

import com.codeborne.selenide.WebDriverProvider;
import diploma.tests.GlobalTestBase;
import lombok.SneakyThrows;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class BrowserstackMobileDriver extends GlobalTestBase implements WebDriverProvider {
    @SneakyThrows
    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        mutableCapabilities.setCapability("browserstack.user", mobileConfig.browserstackUser());
        mutableCapabilities.setCapability("browserstack.key", mobileConfig.browserstackKey());
        mutableCapabilities.setCapability("app", mobileConfig.appUrl());
        mutableCapabilities.setCapability("device", mobileConfig.device());
        mutableCapabilities.setCapability("os_version", mobileConfig.osVersion());
        mutableCapabilities.setCapability("project", mobileConfig.project());
        mutableCapabilities.setCapability("build", mobileConfig.build());
        mutableCapabilities.setCapability("name", mobileConfig.name());

        return new RemoteWebDriver(new URL(mobileConfig.remoteUrl()), mutableCapabilities);
    }
}
