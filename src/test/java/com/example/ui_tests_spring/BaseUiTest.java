package com.example.ui_tests_spring;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class BaseUiTest {

    @BeforeAll
    void selenideSetup() {
        Configuration.browser = "chrome";
        Configuration.headless = Boolean.parseBoolean(System.getProperty("app.headless", "false"));
        Configuration.browserSize = "1200x800";
        Configuration.timeout = Long.parseLong(System.getProperty("app.timeoutMs", "8000"));
    }
}

