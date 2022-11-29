package diploma.tests.mobile.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class StepikMobileElements {
    public static SelenideElement
            closeOnboarding = $(AppiumBy.id("org.stepic.droid:id/closeOnboarding")),
            closeSignInForm = $(AppiumBy.id("org.stepic.droid:id/dismissButton")),
            signUpButton = $(AppiumBy.id("org.stepic.droid:id/launchSignUpButton")),
            firstNameInput = $(AppiumBy.id("org.stepic.droid:id/firstNameField")),
            emailInput = $(AppiumBy.id("org.stepic.droid:id/emailField")),
            passwordInput = $(AppiumBy.id("org.stepic.droid:id/passwordField")),
            submitSignUp = $(AppiumBy.id("org.stepic.droid:id/signUpButton")),
            laterButton = $(AppiumBy.id("android:id/button2")),
            profileIcon = $(AppiumBy.id("org.stepic.droid:id/profile")),
            profileName = $(AppiumBy.id("org.stepic.droid:id/profileName")),
            searchFilter = $(AppiumBy.id("org.stepic.droid:id/filterIcon")),
            searchLanguageAny = $(AppiumBy.id("org.stepic.droid:id/anyRadioButton")),
            applyFilter = $(AppiumBy.id("org.stepic.droid:id/applyFilterAction")),
            searchInput = $(AppiumBy.id("org.stepic.droid:id/search_src_text")),
            catalogIcon = $(AppiumBy.id("org.stepic.droid:id/catalog")),
            joinCourse = $(AppiumBy.id("org.stepic.droid:id/courseEnrollAction")),
            courseTitle = $(AppiumBy.id("org.stepic.droid:id/centeredToolbarTitle"));

    public static ElementsCollection searchResults = $$(AppiumBy.id("org.stepic.droid:id/courseItemName"));
}
