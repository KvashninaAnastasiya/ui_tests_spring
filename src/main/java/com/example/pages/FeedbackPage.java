package com.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

@Component
public class FeedbackPage {
    @Value("${app.feedbackBase}") private String base;
    private final SelenideElement name    = Selenide.$("#userName");
    private final SelenideElement email   = Selenide.$("#userEmail");
    private final SelenideElement message = Selenide.$("textarea#currentAddress");
    private final SelenideElement send    = Selenide.$("button#submit");
    private final SelenideElement outputBlock = $("#output");

    public FeedbackPage openPage(){ Selenide.open(base); Selenide.$("body").shouldBe(Condition.visible); return this; }

    public FeedbackPage fill(String n, String e, String m){
        name.shouldBe(Condition.visible).setValue(n);
        email.shouldBe(Condition.visible).setValue(e);
        message.shouldBe(Condition.visible).setValue(m);
        return this;
    }

    public FeedbackPage submit(){
        send.scrollTo().click(); return this;
    }
    public FeedbackPage emailValidation(){
        email.shouldHave(cssClass("field-error"));
        return this;
    }
}

