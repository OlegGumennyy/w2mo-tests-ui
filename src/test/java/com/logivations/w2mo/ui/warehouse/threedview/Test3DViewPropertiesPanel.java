package com.logivations.w2mo.ui.warehouse.threedview;

import com.logivations.w2mo.ui.pages.warehouse.WH3DViewPage;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Condition.text;

/*******************************************************************************
 * (C) Copyright
 * Logivations GmbH, Munich 2010-2016
 ******************************************************************************/

public class Test3DViewPropertiesPanel {

    WH3DViewPage wh3DViewPage;

    @BeforeGroups(groups = "layout")
    public void openLayoutInformation(){
        wh3DViewPage.openSidebarElementsPanel();
        wh3DViewPage.openLayoutInformationInElementsPanel();
        wh3DViewPage.layoutNameFromElementsPanel.click();
    }

    @Test(groups = "layout")
    public void changeLayoutName(){
        wh3DViewPage
                .layoutNameFromPropertiesPanel
                .setValue("ios_with_trains")
                .pressEnter()
                .shouldBe(text("ios_with_trains"));
    }

    @Test(groups = "layout")
    public void changeLayoutDescription(){
        wh3DViewPage
                .layoutDescriptionFromPropertiesPanel
                .setValue("Layout Description")
                .pressEnter()
                .shouldBe(text("Layout Description"));
    }

    @Test(groups = "layout")
    public void changeLayoutSizes(){
        wh3DViewPage
                .layoutSizeXFromPropertiesPanel
                .setValue("30")
                .pressEnter()
                .shouldBe(text("30"));
        wh3DViewPage
                .layoutSizeYFromPropertiesPanel
                .setValue("12")
                .pressEnter()
                .shouldBe(text("12"));
        wh3DViewPage
                .layoutSizeZFromPropertiesPanel
                .setValue("3")
                .pressEnter()
                .shouldBe(text("3"));
    }

    @Test(groups = "layout")
    public void changeLayoutGridSizes(){
        wh3DViewPage
                .layoutGridSizeXFromPropertiesPanel
                .setValue("1")
                .pressEnter()
                .shouldBe(text("1"));
        wh3DViewPage
                .layoutGridSizeYFromPropertiesPanel
                .setValue("1")
                .pressEnter()
                .shouldBe(text("1"));
    }

    @Test(groups = "layout")
    public void changeLayoutDamagedZone(){
        wh3DViewPage
                .layoutDamagedZonesFromPropertiesPanel
                .shouldHaveSize(3)
                .get(1)
                .click();
        wh3DViewPage
                .layoutDamagedZonesFromPropertiesPanel
                .get(0)
                .shouldBe(selected);
    }

    @Test(groups = "layout")
    public void changeLayoutMaxEditingUsers(){
        wh3DViewPage.layoutMaxEditingUsersFromPropertiesPanel
                .setValue("3")
                .pressEnter()
                .shouldBe(text("3"));
    }

    @Test(groups = "layout")
    public void makeLayoutPublic(){
        wh3DViewPage
                .layoutPublicOptionFromPropertiesPanel
                .click();
        wh3DViewPage
                .layoutPublicOptionFromPropertiesPanel
                .shouldBe(enabled);
    }

    @Test(groups = "layout")
    public void makeLayoutNotDeletable(){
        wh3DViewPage
                .layoutDeleteDisablingOptionFromPropertiesPanel
                .click();
        wh3DViewPage
                .layoutDeleteDisablingOptionFromPropertiesPanel
                .shouldBe(enabled);
    }

    @Test(groups = "layout")
    public void checkRecalculatingEstimateCache(){
        wh3DViewPage
                .layoutRecalculateEstimateCacheFromPropertiesPanel
                .setValue("600")
                .pressEnter()
                .shouldBe(text("600"));
    }

    @Test(groups = "layout")
    public void makeInfrastructureLocked(){
        wh3DViewPage
                .layoutLockInfrastructureOptionFromPropertiesPanel
                .click();
        wh3DViewPage
                .layoutLockInfrastructureOptionFromPropertiesPanel
                .shouldBe(enabled);
    }
}
