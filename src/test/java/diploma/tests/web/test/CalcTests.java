package diploma.tests.web.test;

import diploma.tests.web.base.WebTestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

@Tag("Web")
@Tag("All")
@Epic("MegaZvet")
@Feature("Web tests")
@Owner("Geraniya")
public class CalcTests extends WebTestBase {
    @ParameterizedTest(name = "Calculate total sum for {0} {1} with price {2} for {3} pieces")
    @Tag("Web")
    @DisplayName("Calculator counts correctly")
    @MethodSource("diploma.tests.web.pages.MainPage#calculatorTest")
    void calculatorTest(String flower, String color, int price, int pack) {
        mainPage.openPage();
        mainPage.calculateFlowerPrice(flower, color, price, pack);
    }
}
