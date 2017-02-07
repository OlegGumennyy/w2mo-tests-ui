package com.logivations.w2mo.ui;

import com.logivations.w2mo.ui.pages.general.LoginPage;
import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import utilities.PropertyReader;

import java.io.FileNotFoundException;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;

/*******************************************************************************
 * (C) Copyright
 * Logivations GmbH, Munich 2010-2016
 ******************************************************************************/

public class TestBase {

    @BeforeSuite
    @Parameters({"serverUrl"})
    public static void openBrowser(String serverUrl) {
        baseUrl = serverUrl;
        timeout = 10000;
        startMaximized = true;

        open(baseUrl + "/login.jsp");
        login();
    }

    @AfterSuite
    public static void closeBrowser() {
        logout();
        close();
    }

    private static void login() {
        try {
            LoginPage loginPage = new LoginPage();
            String user = PropertyReader.loadProperty("user.name");
            String pass = PropertyReader.loadProperty("user.pass");
            loginPage.fillAndSubmitCredentials(user, pass);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void logout() {
        $(By.id("w2mo-logout-link")).click();
    }
}

