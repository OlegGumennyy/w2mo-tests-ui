package com.logivations.w2mo.ui.pages.general;

import com.codeborne.selenide.SelenideElement;
import com.logivations.w2mo.ui.interfaces.IPage;
import com.sun.istack.internal.NotNull;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.getJavascriptErrors;

/*******************************************************************************
 * (C) Copyright
 * Logivations GmbH, Munich 2010-2016
 ******************************************************************************/

public class SignUpPage implements IPage {

    private SelenideElement username = $(By.id(""));
    private SelenideElement email = $(By.id(""));
    private SelenideElement password = $(By.id(""));
    private SelenideElement confirmPassword = $(By.id(""));
    private SelenideElement firstName = $(By.id(""));
    private SelenideElement lastName = $(By.id(""));
    private SelenideElement company = $(By.id(""));
    private SelenideElement vatId = $(By.id(""));
    private SelenideElement billingAddress = $(By.id(""));
    private SelenideElement phoneNumberCountryCode = $(By.id(""));
    private SelenideElement phoneBumberBody = $(By.id(""));
    private SelenideElement sequrityQuestion = $(By.id(""));
    private SelenideElement sequrityAnswer = $(By.id(""));
    private SelenideElement submitButton = $(By.id(""));

    public String getTitle() {
        return null;
    }

    public SelenideElement getPopUpMessage() {
        return null;
    }

    @Override
    public Boolean isConsoleErrorsAppear() {
        return getJavascriptErrors().size() == 0;
    }

    public boolean sendUsername(String query){
        username.setValue(query);
        return isQueryValid(username);
    }

    public boolean sendEmail(String query){
        email.setValue(query);
        return isQueryValid(email);
    }

    @NotNull
    private boolean isQueryValid(SelenideElement selenideElement) {
        //TODO catch true / false is query is valid
        return false;
    }
}
