package diploma.tests.mobile.test;

import diploma.tests.mobile.base.MobileTestBase;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;


@Tag("Mobile")
@Tag("All")
@Epic("Coinkeeper")
@Feature("Mobile tests")
@Owner("Geraniya")
public class StepikTests extends MobileTestBase {

//    StepikMobilePage mobilePage = new StepikMobilePage();
//
    @Test
    @DisplayName("Регистрация в мобильном приложении")
    void mobileRegistrationTest() {
        $(AppiumBy.id("com.disrapp.coinkeeper.material:id/textAmount")).click();

//        StepikData data = new StepikData();
//        mobilePage.goToRegistration();
//        mobilePage.fillRegistrationForm(data);
//        mobilePage.checkRegistration(data);
    }
//
//    @Test
//    @DisplayName("Поиск курса в мобильном приложении")
//    void mobileSearchTest() {
//        mobilePage.skipRegistration();
//        mobilePage.findCourse("Вселенная тестирования");
//    }
//
//    @Test
//    @DisplayName("Запись на курс в мобильном приложении")
//    void mobileJoinCourseTest() {
//        StepikData data = new StepikData();
//        mobilePage.goToRegistration();
//        mobilePage.fillRegistrationForm(data);
//        mobilePage.joinCourse("Вселенная тестирования", "1.1 Давай знакомиться!");
//    }
}
