package com.logivations.w2mo.ui.pages.general;

import com.codeborne.selenide.SelenideElement;
import com.logivations.w2mo.ui.interfaces.IPage;

import static com.codeborne.selenide.Selenide.getJavascriptErrors;

/*******************************************************************************
 * (C) Copyright
 * Logivations GmbH, Munich 2010-2016
 ******************************************************************************/

public class LanguagesPage implements IPage {
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
}
