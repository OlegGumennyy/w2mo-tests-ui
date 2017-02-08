package com.logivations.w2mo.ui.interfaces;

import com.codeborne.selenide.SelenideElement;

/*******************************************************************************
 * (C) Copyright
 * Logivations GmbH, Munich 2010-2016
 ******************************************************************************/

public interface IPage {
    String getTitle();
    SelenideElement getPopUpMessage();
    Boolean isConsoleErrorsAppear();
}
