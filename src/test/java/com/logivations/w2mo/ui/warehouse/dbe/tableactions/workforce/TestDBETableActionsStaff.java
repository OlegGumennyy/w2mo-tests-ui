package com.logivations.w2mo.ui.warehouse.dbe.tableactions.workforce;

import com.codeborne.selenide.Condition;
import com.logivations.w2mo.ui.TestBase;
import com.logivations.w2mo.ui.pages.dbe.tables.TablePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import utilities.PropertyReader;

import java.io.FileNotFoundException;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;

/*******************************************************************************
 * (C) Copyright
 * Logivations GmbH, Munich 2010-2016
 ******************************************************************************/

public class TestDBETableActionsStaff extends TestBase{

    TablePage tablePage;

    private final String SUCCESS_TABLE_ACTION_RESULT_MESSAGE = "Action was successfully executed";

    @BeforeClass
    private void preConditions() {
        open(baseUrl + "/api/view/showLayoutEditor?warehouseId=" + getWarehouseId());
    }

    @BeforeGroups(groups = "Staff")
    private void openStaffTable() {
        open(baseUrl + "/dbe.jsp?warehouseId=" + getWarehouseId() + "&tableId=517&campaignId=1");
    }

    @Test(groups = "Staff")
    private void testUpdateStaffNumber(){
        tablePage.getTableAction("Update Staff Number");
        tablePage.getPopUpMessage()
                .shouldHave(Condition.text(SUCCESS_TABLE_ACTION_RESULT_MESSAGE));
        tablePage.getValueFromCell(3, 6)
                .shouldBe(Condition.text("33"));
    }

    @Test(groups = "Staff")
    private void testUpdateUserID(){
        tablePage.getTableAction("Update User ID");
        tablePage.getPopUpMessage()
                .shouldHave(Condition.text(SUCCESS_TABLE_ACTION_RESULT_MESSAGE));
        tablePage.getValueFromCell(3, 7)
                .shouldBe(Condition.text("3"));
    }

    //TODO try to add data provider
    @Test(groups = "Staff")
    private void testUpdateWorkforce(){
        tablePage.getTableAction("Update User Workforce");
        tablePage.getPopUpMessage()
                .shouldHave(Condition.text(SUCCESS_TABLE_ACTION_RESULT_MESSAGE));
        tablePage.getValueFromCell(3, 12)
                .shouldBe(Condition.text("3"));
    }

    private String getWarehouseId() {
        String warehouseID = null;
        try {
            warehouseID = PropertyReader
                    .loadTestData("warehouse.id.dbe.staff");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return warehouseID;
    }

}
