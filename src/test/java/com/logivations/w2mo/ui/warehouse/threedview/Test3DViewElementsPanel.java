package com.logivations.w2mo.ui.warehouse.threedview;

import com.codeborne.selenide.Condition;
import com.logivations.w2mo.ui.TestBase;
import com.logivations.w2mo.ui.pages.warehouse.WH3DViewPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.PropertyReader;

import java.io.FileNotFoundException;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;

/*******************************************************************************
 * (C) Copyright
 * Logivations GmbH, Munich 2010-2016
 ******************************************************************************/

public class Test3DViewElementsPanel extends TestBase{

    WH3DViewPage wh3DViewPage = new WH3DViewPage();

    @BeforeClass
    private void preConditions() throws FileNotFoundException {
        String warehouseID = PropertyReader
                .loadTestData("warehouse.id.3d");
        open(baseUrl + "/api/view/showLayoutInThreeD?warehouseId=" + warehouseID);
    }

    @AfterClass
    private void backToLayoutEditor(){
        wh3DViewPage.backToLayoutEditor();
    }

    @Test
    public void checkLayoutName() {
        wh3DViewPage.openSidebarElementsPanel();
        wh3DViewPage.openLayoutInformationInElementsPanel();
        wh3DViewPage.layoutNameFromElementsPanel
                .shouldBe(Condition.text("layoutName"));
    }

    @Test
    public void checkStationsNumber() {
        wh3DViewPage.openSidebarElementsPanel();
        wh3DViewPage.openStationsList();
        wh3DViewPage.stationsNumberInElementsPanel.shouldHaveSize(2);
    }

    @Test
    public void checkRacksNumber() {
        wh3DViewPage.openSidebarElementsPanel();
        wh3DViewPage.openRacksList();
        wh3DViewPage.racksNumberInElementsPanel.shouldHaveSize(99);
    }

    @Test
    public void checkTransportProcessesNumber() {
        wh3DViewPage.openSidebarElementsPanel();
        wh3DViewPage.openTransportProcessesList();
        wh3DViewPage.transportProcessesNumberInElementsPanel.shouldHaveSize(2);
    }

    @Test
    public void checkPathsNumber() {
        wh3DViewPage.openSidebarElementsPanel();
        wh3DViewPage.openPathsList();
        wh3DViewPage.pathsNumberInElementsPanel.shouldHaveSize(99);
    }

    @Test
    public void checkProcessPointsNumber() {
        wh3DViewPage.openSidebarElementsPanel();
        wh3DViewPage.openProcessPointsList();
        wh3DViewPage.processPointsNumberInElementsPanel.shouldHaveSize(99);
    }
}
