package com.logivations.w2mo.ui.pages.general;

import com.codeborne.selenide.SelenideElement;
import com.logivations.w2mo.ui.interfaces.IPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;


/*******************************************************************************
 * (C) Copyright
 * Logivations GmbH, Munich 2010-2016
 ******************************************************************************/

public class LoginPage implements IPage {

    private SelenideElement changeLanguageButton = $(By.id(""));
    private SelenideElement loginField = $(By.id(""));
    private SelenideElement passwordField = $(By.id(""));
    private SelenideElement popUpText = $(By.id(""));

    public String getTitle() {
        return null;
    }

    public String getPopUpMessage() {
        return null;
    }

    public LanguagesPage changeLanguage(){
        changeLanguageButton.click();
        return page(LanguagesPage.class);
    }

    public LayoutSelectorPage loginWithCorrectData(String user, String password){
        loginField.setValue(user);
        passwordField.setValue(password).pressEnter();
        return page(LayoutSelectorPage.class);
    }

    public String loginWithWrongData(String user, String password){
        loginField.setValue(user);
        passwordField.setValue(password).pressEnter();
        return popUpText.getText();
    }
}
