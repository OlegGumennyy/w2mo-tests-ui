package com.logivations.w2mo.ui.pages.warehouse;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.logivations.w2mo.ui.interfaces.IPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

/*******************************************************************************
 * (C) Copyright
 * Logivations GmbH, Munich 2010-2016
 ******************************************************************************/

public class WH3DViewPage implements IPage {

    /**
     * public elements
     */

    public ElementsCollection stationsNumberInElementsPanel = $$(By.id(""));
    public ElementsCollection racksNumberInElementsPanel = $$(By.id(""));
    public ElementsCollection transportProcessesNumberInElementsPanel = $$(By.id(""));
    public ElementsCollection pathsNumberInElementsPanel = $$(By.id(""));
    public ElementsCollection processPointsNumberInElementsPanel = $$(By.id(""));
    public SelenideElement layoutNameFromElementsPanel = $(By.id(""));

    public SelenideElement layoutNameFromPropertiesPanel = $(By.id(""));
    public SelenideElement layoutDescriptionFromPropertiesPanel = $(By.id(""));
    public SelenideElement layoutSizeXFromPropertiesPanel = $(By.id(""));
    public SelenideElement layoutSizeYFromPropertiesPanel = $(By.id(""));
    public SelenideElement layoutSizeZFromPropertiesPanel = $(By.id(""));
    public SelenideElement layoutGridSizeXFromPropertiesPanel = $(By.id(""));
    public SelenideElement layoutGridSizeYFromPropertiesPanel = $(By.id(""));
    public ElementsCollection layoutDamagedZonesFromPropertiesPanel = $$(By.id(""));
    public SelenideElement layoutMaxEditingUsersFromPropertiesPanel = $(By.id(""));
    public SelenideElement layoutPublicOptionFromPropertiesPanel = $(By.id(""));
    public SelenideElement layoutDeleteDisablingOptionFromPropertiesPanel = $(By.id(""));
    public SelenideElement layoutRecalculateEstimateCacheFromPropertiesPanel = $(By.id(""));
    public SelenideElement layoutLockInfrastructureOptionFromPropertiesPanel = $(By.id(""));

    /**
     * private elements
     */

    private SelenideElement sidebarElementsPanelButton = $(By.id("sidebar-tab-elements"));
    private SelenideElement sidebarElementsPanelActive = $(By.cssSelector("[aria-selected='true']"));
    private SelenideElement layoutInformationInElementsPanelIsActive = $(By.xpath("//a[contains(text(),'Layout')] | //a[area-selected='true']"));
    private SelenideElement layoutInformationInElementsPanelButton = $(By.xpath("//a[contains(text(),'Layout')]"));
    private SelenideElement stationsListIsActive = $(By.xpath("//a[contains(text(),'Stations')] | //a[area-selected='true']"));
    private SelenideElement stationsListButton = $(By.xpath("//a[contains(text(),'Stations')]"));
    private SelenideElement racksListIsActive = $(By.xpath("//a[contains(text(),'Racks')] | //a[area-selected='true']"));
    private SelenideElement racksListButton = $(By.xpath("//a[contains(text(),'Racks')]"));
    private SelenideElement transportProcessListIsActive = $(By.xpath("//a[contains(text(),'Transport Processes')] | //a[area-selected='true']"));
    private SelenideElement transportProcessListButton = $(By.xpath("//a[contains(text(),'Transport Processes')]"));
    private SelenideElement pathListIsActive = $(By.xpath("//a[contains(text(),'Paths')] | //a[area-selected='true']"));
    private SelenideElement pathListButton = $(By.xpath("//a[contains(text(),'Paths')]"));
    private SelenideElement processPointsListIsActive = $(By.xpath("//a[contains(text(),'Process Points')] | //a[area-selected='true']"));
    private SelenideElement processPointsListButton = $(By.xpath("//a[contains(text(),'Process Points')]"));
    private SelenideElement layoutEditorButton = $(By.xpath("//a[contains(text(),'View Current Layout in 2D')]"));

    /**
     * methods
     */

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public SelenideElement getPopUpMessage() {
        return null;
    }

    @Override
    public Boolean isConsoleErrorsAppear() {
        return getJavascriptErrors().size() == 0;
    }

    private void checkIsElementIsEnabledAndOpenList(
            SelenideElement activeElement,
            SelenideElement buttonElement) {
        if (!activeElement.exists()) {
            buttonElement.click();
        }
    }

    public void openSidebarElementsPanel() {
        checkIsElementIsEnabledAndOpenList(
                sidebarElementsPanelActive,
                sidebarElementsPanelButton);
    }

    public void openLayoutInformationInElementsPanel(){
        checkIsElementIsEnabledAndOpenList(
                layoutInformationInElementsPanelIsActive,
                layoutInformationInElementsPanelButton
        );
    }

    public void openStationsList() {
        checkIsElementIsEnabledAndOpenList(
                stationsListIsActive,
                stationsListButton);
    }

    public void openRacksList() {
        checkIsElementIsEnabledAndOpenList(
                racksListIsActive,
                racksListButton
        );
    }

    public void openTransportProcessesList() {
        checkIsElementIsEnabledAndOpenList(
                transportProcessListIsActive,
                transportProcessListButton
        );
    }

    public void openPathsList() {
        checkIsElementIsEnabledAndOpenList(
                pathListIsActive,
                pathListButton
        );
    }

    public void openProcessPointsList() {
        checkIsElementIsEnabledAndOpenList(
                processPointsListIsActive,
                processPointsListButton
        );
    }

    public void backToLayoutEditor() {
        layoutEditorButton.click();
    }
}
