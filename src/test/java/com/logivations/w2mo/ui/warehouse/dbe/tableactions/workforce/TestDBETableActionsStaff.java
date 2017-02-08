package com.logivations.w2mo.ui.warehouse.dbe.tableactions.workforce;

import com.codeborne.selenide.Condition;
import com.logivations.w2mo.ui.TestBase;
import com.logivations.w2mo.ui.pages.dbe.tables.TableActionsInputParametersStaff;
import com.logivations.w2mo.ui.pages.dbe.tables.TablePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;

/*******************************************************************************
 * (C) Copyright
 * Logivations GmbH, Munich 2010-2016
 ******************************************************************************/

public class TestDBETableActionsStaff extends TestBase {

    TablePage tablePage;
    TableActionsInputParametersStaff inputParameters;

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
    private void testUpdateStaffNumber() {
        tablePage.getTableAction("Update Staff Number");
        tablePage.getPopUpMessage()
                .shouldHave(Condition.text(SUCCESS_TABLE_ACTION_RESULT_MESSAGE));
        tablePage.getSpecifiedCell(3, 6)
                .shouldBe(Condition.text("33"));
    }

    @Test(groups = "Staff")
    private void testUpdateUserID() {
        tablePage.getTableAction("Update User ID");
        tablePage.getPopUpMessage()
                .shouldHave(Condition.text(SUCCESS_TABLE_ACTION_RESULT_MESSAGE));
        tablePage.getSpecifiedCell(3, 7)
                .shouldBe(Condition.text("3"));
    }

    //TODO try to add data provider
    @Test(groups = "Staff")
    private void testUpdateWorkforce() {
        tablePage.getTableAction("Update User Workforce");
        tablePage.getPopUpMessage()
                .shouldHave(Condition.text(SUCCESS_TABLE_ACTION_RESULT_MESSAGE));
        tablePage.getSpecifiedCell(3, 12)
                .shouldBe(Condition.text("3"));
    }

    @BeforeGroups(groups = "CapacityGroups")
    private void openCapacityGroupsTable() {
        open(baseUrl + "/dbe.jsp?warehouseId=" + getWarehouseId() + "&tableId=520&campaignId=1");
    }

    @Test(groups = "CapacityGroups")
    private void testCalculateHourlyRateInCapacityGroups() {
        tablePage.getTableAction("Calculate Hourly Rate");
        tablePage.getPopUpMessage()
                .shouldHave(Condition.text(SUCCESS_TABLE_ACTION_RESULT_MESSAGE));
        tablePage.getSpecifiedCell(3, 12)
                .shouldBe(Condition.text("3"));
    }

    @BeforeGroups(groups = "Shifts")
    private void openShiftsTable() {
        open(baseUrl + "/dbe.jsp?warehouseId=" + getWarehouseId() + "&tableId=522&campaignId=1");
    }

    @Test(groups = "Shifts")
    private void testAddWorkingDays() {
        tablePage.getTableAction("Add Working Days for Shift");
        inputParameters.fillAddWorkingDaysForShiftInputs(0, 0, "2017-02-08", "2017-02-20", "8", false, false);
        tablePage.getPopUpMessage()
                .shouldHave(Condition.text(SUCCESS_TABLE_ACTION_RESULT_MESSAGE));
    }

    @Test(groups = "Shifts")
    private void testCalculateHourlyRateForShift() {
        tablePage.getTableAction("Calculate Hourly Rate");
        tablePage.getPopUpMessage()
                .shouldHave(Condition.text(SUCCESS_TABLE_ACTION_RESULT_MESSAGE));
    }

    @Test(groups = "Shifts")
    private void testFillCalendarWithPlannedCapacity() {
        tablePage.getTableAction("Fill Calendar with Planned Capacity");
        inputParameters.fillFillCalendarWithPlannedCapacityInputs("2017-02-08", "2017-02-08", "2017-02-08", false);
        tablePage.getPopUpMessage()
                .shouldHave(Condition.text(SUCCESS_TABLE_ACTION_RESULT_MESSAGE));
    }

    @BeforeGroups(groups = "CapacityGroupBreaks")
    private void openCapacityGroupBreaksTable() {
        open(baseUrl + "/dbe.jsp?warehouseId=" + getWarehouseId() + "&tableId=523&campaignId=1");
    }

    @Test(groups = "CapacityGroupBreaks")
    private void testCreateDisturbances() {
        tablePage.getTableAction("Create Disturbances");
        inputParameters.fillCreateDisturbancesInputs(0, 0, "15", "99", "2017-02-08", "08:00:00", "2017-02-20", "18:00:00");
        tablePage.getPopUpMessage()
                .shouldHave(Condition.text(SUCCESS_TABLE_ACTION_RESULT_MESSAGE));
    }

    @BeforeGroups(groups = "PublicHolidays")
    private void openPublicHolidaysTable() {
        open(baseUrl + "/dbe.jsp?warehouseId=" + getWarehouseId() + "&tableId=592&campaignId=1");
    }

    @Test(groups = "PublicHolidays")
    private void testConsiderHolidays() {
        tablePage.getTableAction("Consider Holidays for All Workers");
        inputParameters.fillAConsiderHolidays(11, 2);
        tablePage.getPopUpMessage()
                .shouldHave(Condition.text(SUCCESS_TABLE_ACTION_RESULT_MESSAGE));
    }
}
