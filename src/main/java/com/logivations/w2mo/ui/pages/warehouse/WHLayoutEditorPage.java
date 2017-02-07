package com.logivations.w2mo.ui.pages.warehouse;

import com.codeborne.selenide.SelenideElement;
import com.logivations.w2mo.ui.interfaces.IPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.getJavascriptErrors;
import static com.codeborne.selenide.Selenide.page;

/*******************************************************************************
 * (C) Copyright
 * Logivations GmbH, Munich 2010-2016
 ******************************************************************************/

public class WHLayoutEditorPage implements IPage {

    private SelenideElement new3DButton = $(By.id(""));

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

    public WH3DViewPage goTo3DView(){
        new3DButton.click();
        return page(WH3DViewPage.class);
    }
}
