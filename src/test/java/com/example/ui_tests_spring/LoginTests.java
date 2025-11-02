package com.example.ui_tests_spring;

import com.example.pages.LoginPage;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import static com.codeborne.selenide.WebDriverRunner.url;
import static org.assertj.core.api.Assertions.assertThat;

class LoginTests extends BaseUiTest {

    @Autowired LoginPage login;

    @Test @DisplayName("Login: happy path (tomsmith / SuperSecretPassword!)")
    void validLogin() throws InterruptedException {
        login.openPage()
                .typeUsername("tomsmith")
                .typePassword("SuperSecretPassword!")
                .submit();
        Thread.sleep(3000);
        assertThat(url()).contains("/secure");
    }

    @Test @DisplayName("Login: invalid creds")
    void invalidCreds() {
        login.openPage()
                .typeUsername("user")
                .typePassword("wrong")
                .submit();

        assertThat(login.flashText()).containsIgnoringCase("invalid");
    }

    @Test @DisplayName("Login: password is masked")
    void passwordMasked() {
        login.openPage();
        assertThat(login.isPasswordMasked()).isTrue();
    }
}
