package com.logivations.w2mo.ui.pages.general;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.logivations.w2mo.ui.interfaces.IPage;
import com.logivations.w2mo.ui.pages.crm.CRMLayoutEditorPage;
import com.logivations.w2mo.ui.pages.lno.LNOLayoutEditorPage;
import com.logivations.w2mo.ui.pages.warehouse.WHLayoutEditorPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;


/*******************************************************************************
 * (C) Copyright
 * Logivations GmbH, Munich 2010-2016
 ******************************************************************************/

public class LayoutSelectorPage implements IPage {

    private ElementsCollection layoutIDs = $$(By.id(""));
    private SelenideElement openLayout = $(By.id(""));
    private SelenideElement filterByLayoutName = $(By.id(""));


    private void getLayoutEditor(String layoutName) {
        getFilteredLayouts(layoutName);
        openLayout.doubleClick();
    }

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

    public LayoutSelectorPage getFilteredLayouts(String layoutName){
        filterByLayoutName.setValue(layoutName);
        return page(LayoutSelectorPage.class);
    }

    public WHLayoutEditorPage openSpecifiedWHLayout(String layoutName) {
        getLayoutEditor(layoutName);
        return page(WHLayoutEditorPage.class);
    }

    public CRMLayoutEditorPage openSpecifiedCRMLayout(String layoutName) {
        getLayoutEditor(layoutName);
        return page(CRMLayoutEditorPage.class);
    }

    public LNOLayoutEditorPage openSpecifiedLNOLayout(String layoutName) {
        getLayoutEditor(layoutName);
        return page(LNOLayoutEditorPage.class);
    }
}
