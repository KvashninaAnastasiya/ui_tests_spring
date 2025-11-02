package com.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LoginPage {
    @Value("${app.loginBase}") private String base;

    private final SelenideElement username = Selenide.$("#username");
    private final SelenideElement password = Selenide.$("#password");
    private final SelenideElement signIn   = Selenide.$("button[type='submit']");
    private final SelenideElement flash    = Selenide.$("#flash");

    public LoginPage openPage() {
        Selenide.open(base + "/login");
        signIn.shouldBe(Condition.visible); return this; }
    public LoginPage typeUsername(String v){ username.setValue(v); return this; }
    public LoginPage typePassword(String v){ password.setValue(v); return this; }
    public LoginPage submit(){ signIn.click(); return this; }

    public String flashText(){ return flash.shouldBe(Condition.visible).getText().trim(); }
    public boolean isPasswordMasked(){ return "password".equalsIgnoreCase(password.getAttribute("type")); }
}
