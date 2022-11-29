package diploma.tests.mobile.page;

import io.qameta.allure.Step;


import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static diploma.tests.mobile.elements.StepikMobileElements.closeOnboarding;
import static diploma.tests.mobile.elements.StepikMobileElements.signUpButton;


public class StepikMobilePage {

    @Step("Переход к окну регистрации")
    public void goToRegistration(){
        closeOnboarding.click();
        signUpButton.click();
    }

//    @Step("Заполнение формы и регистрация")
//    public void fillRegistrationForm(StepikData data){
//        firstNameInput.click();
//        firstNameInput.sendKeys(data.firstName);
//        emailInput.click();
//        emailInput.sendKeys(data.email);
//        passwordInput.click();
//        passwordInput.sendKeys(data.password);
//        submitSignUp.click();
//    }
//
//    @Step("Проверка успешной регистрации")
//    public void checkRegistration(StepikData data){
//        laterButton.click();
//        profileIcon.click();
//        profileName.shouldHave(text(data.firstName));
//    }
//
//    @Step("Пропуск регистрации")
//    public void skipRegistration(){
//        closeOnboarding.click();
//        closeSignInForm.click();
//    }
//
//    @Step("Поиск курса")
//    public void findCourse(String courseName){
//        searchInput.sendKeys(courseName);
//        searchFilter.click();
//        searchLanguageAny.click();
//        applyFilter.click();
//        searchResults.first().shouldHave(text(courseName), Duration.ofSeconds(8));
//    }
//
//    @Step("Запись на курс")
//    public void joinCourse(String courseName, String expectedCourseContent){
//        laterButton.click();
//        catalogIcon.click();
//        findCourse(courseName);
//        searchResults.first().click();
//        joinCourse.click();
//        courseTitle.shouldHave(text(expectedCourseContent), Duration.ofSeconds(8));
//    }
}
