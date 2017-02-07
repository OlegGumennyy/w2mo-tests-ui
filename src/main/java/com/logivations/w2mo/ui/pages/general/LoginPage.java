package com.logivations.w2mo.ui.pages.general;

import com.codeborne.selenide.SelenideElement;
import com.logivations.w2mo.ui.interfaces.IPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;


/*******************************************************************************
 * (C) Copyright
 * Logivations GmbH, Munich 2010-2016
 ******************************************************************************/

public class LoginPage implements IPage {

    private SelenideElement changeLanguageButton = $(By.cssSelector("//a[contains(text(),'Change language')]"));
    private SelenideElement loginField = $(By.id("j_username"));
    private SelenideElement passwordField = $(By.id("j_password"));
    //private SelenideElement popUpText = $(By.id(""));

    public String getTitle() {
        return null;
    }

    public String getPopUpMessage() {
        return null;
    }

    @Override
    public Boolean isConsoleErrorsAppear() {
        return getJavascriptErrors().size() == 0;
    }

    public LanguagesPage changeLanguage(){
        changeLanguageButton.click();
        return page(LanguagesPage.class);
    }

    public LayoutSelectorPage loginWithCorrectData(String user, String pass){
        fillAndSubmitCredentials(user, pass);
        return page(LayoutSelectorPage.class);
    }
/*
    public String loginWithWrongData(String user, String pass){
        fillAndSubmitCredentials(user, pass);
        return popUpText.getText();
    }*/

    public void fillAndSubmitCredentials(String user, String pass) {
        loginField.setValue(user);
        passwordField.setValue(pass).pressEnter();
    }
}
