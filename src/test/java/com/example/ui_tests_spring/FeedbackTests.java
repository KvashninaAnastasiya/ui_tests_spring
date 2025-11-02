package com.example.ui_tests_spring;

import com.example.pages.FeedbackPage;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

class FeedbackTests extends BaseUiTest {

    @Autowired FeedbackPage feedback;

    @Test @DisplayName("Feedback:valid email,submit")
    void feedbackPositive() throws InterruptedException {
        feedback.openPage()
                .fill("test","test@example.com","Hello")
                .submit();
        $("#output").shouldBe(visible);
        $("#name").shouldHave(text("Name:"), text("test"));
        $("#email").shouldHave(text("Email:"), text("test@example.com"));
    }

    @Test @DisplayName("Feedback: negative—invalid email")
    void feedbackInvalidEmail() {
        feedback.openPage()
                .fill("test","test.example.com","test")
                .submit()
                .emailValidation();
    }
}
