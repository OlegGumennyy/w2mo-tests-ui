package com.logivations.w2mo.ui.pages.dbe.tables;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.logivations.w2mo.ui.interfaces.ITable;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/*******************************************************************************
 * (C) Copyright
 * Logivations GmbH, Munich 2010-2016
 ******************************************************************************/

public abstract class TablePage implements ITable {

    public SelenideElement getValueFromCell(int row, int column){
        return $(By.xpath(cellLocatorGenerator(row, column)));
    }

    private String cellLocatorGenerator(int row, int column) {
        return "//tr[" + row + "]/td[" + column + "]";
    }

    public SelenideElement getPopUpMessage(){
        return $(By.cssSelector(".popupContent .gwt-Label"));
    }

    public String getSelectedRowCount() {
        return $(By.className("gwt-Label")).getText().substring(10);
    }

    public void selectAllVisibleRows() {
        $(By.className("gwt-toolbar-icon-select-all")).click();
    }

    public void refreshTable() {
        $(By.className("gwt-toolbar-icon-reload")).click();
    }

    public String getLinkOfSelectedRows() {
        $(By.className("gwt-toolbar-icon-get-link")).click();
        return $(By.cssSelector(".dialogMiddle .gwt-TextBox")).getText();
    }

    public void removeSelectedRows() {
        $(By.className("gwt-toolbar-icon-delete")).click();
        $(By.cssSelector(".dialogMiddleCenter button.gwt-Button")).click();
    }

    public void addCloneNewRow() {
        $(By.className("gwt-toolbar-icon-add-copy")).click();
    }

    public void switchBeetweenViews() {
        $(By.className("gwt-toolbar-icon-table-view")).click();
    }

    public void openFilterDialog() {
        $(By.className("gwt-toolbar-icon-filter")).click();
    }

    public void openHiddenColumnsFilter() {
        $(By.className("gwt-toolbar-icon-hide-columns")).click();
    }

    public void openTableSort() {
        $(By.className("gwt-toolbar-icon-sort")).click();
    }

    public ElementsCollection getChildrenRecords() {
        $(By.className("gwt-toolbar-icon-child-records")).click();
        return $$(By.className(".gwt-MenuBar .gwt-toolbar-menu-item-text"));
    }

    public ElementsCollection getParentsRecords() {
        $(By.className("gwt-toolbar-icon-parent-records")).click();
        return $$(By.className(".gwt-MenuBar .gwt-toolbar-menu-item-text"));
    }

    public void openMassUpdateDialog() {
        $(By.className("gwt-toolbar-icon-mass-update")).click();
    }

    public void openExportDialog() {
        $(By.className("gwt-toolbar-icon-export")).click();
    }

    public void openImportDialog() {
        $(By.className("gwt-toolbar-icon-import")).click();
    }

    public int getVisibleRowsNumber() {
        $(By.className("gwt-enhanced-custom-button-up")).click();
        String[] str = $(By.className("gwt-HTML"))
                .getText()
                .split(" ");
        if (str[str.length - 1] == null) {
            return Integer.parseInt(str[str.length - 1]);
        } else return 0;
    }

    public void getTableAction(String nameOfTableAction) {
        $(By.className("gwt-toolbar-icon-table-action")).click();
        $$(By.className(".gwt-MenuBar .gwt-toolbar-menu-item-text"))
                .find(Condition.text(nameOfTableAction))
                .click();
    }


}
