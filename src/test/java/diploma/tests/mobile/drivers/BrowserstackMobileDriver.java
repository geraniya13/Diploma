package diploma.tests.mobile.drivers;

import com.codeborne.selenide.WebDriverProvider;
import diploma.config.MobileConfig;
import diploma.tests.GlobalTestBase;
import lombok.SneakyThrows;
import org.aeonbits.owner.ConfigFactory;
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
        // Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", mobileConfig.getBrowserstackUser());
        mutableCapabilities.setCapability("browserstack.key", mobileConfig.getBrowserstackKey());

        // Set URL of the application under test
        mutableCapabilities.setCapability("app", mobileConfig.getAppUrl());

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", mobileConfig.getDevice());
        mutableCapabilities.setCapability("os_version", mobileConfig.getOsVersion());

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", mobileConfig.getProject());
        mutableCapabilities.setCapability("build", mobileConfig.getBuild());
        mutableCapabilities.setCapability("name", mobileConfig.getName());

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        return new RemoteWebDriver(new URL(mobileConfig.getRemoteUrl()), mutableCapabilities);
    }
}
