package diploma.tests.api.test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import diploma.tests.api.base.ApiTestBase;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Tag("Api")
@Tag("All")
@Epic("MegaZvet")
@Feature("Api tests")
@Owner("Geraniya")
public class AccountTests extends ApiTestBase {
    @Test
    @Tag("Api")
    @DisplayName("User name changing check")
    public void changeUserNameTest() {
        step("Open personal info edit page", () -> accountApi.openEditAccountPage());
        step("Check if name was changed", () -> {
            accountApi.changeUserName();
            assertThat(accountApi.getCurrentUserName()).doesNotContain(accountApi.getUserBodyModel().getFirstname());
        });
    }
}