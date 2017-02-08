package com.logivations.w2mo.ui.warehouse.dbe.tableactions.workforce;

import com.codeborne.selenide.Condition;
import com.logivations.w2mo.ui.TestBase;
import com.logivations.w2mo.ui.pages.dbe.tables.TableActionsInputParametersProcessStudy;
import com.logivations.w2mo.ui.pages.dbe.tables.TablePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by horuk.t on 08.02.2017.
 */
public class TestDBETableActionsProcessStudy extends TestBase {

    TablePage tablePage;
    TableActionsInputParametersProcessStudy inputParameters;

    private final String SUCCESS_TABLE_ACTION_RESULT_MESSAGE = "Action was successfully executed";

    @BeforeClass
    private void preConditions() {
        open(baseUrl + "/api/view/showLayoutEditor?warehouseId=" + getWarehouseId());
    }

    @BeforeGroups(groups = "MotionSpeedsAndTimesStudy")
    private void openMotionSpeedsAndTimesStudyTable() {
        open(baseUrl + "/dbe.jsp?warehouseId=" + getWarehouseId() + "&tableId=785&campaignId=1");
    }

    @Test(groups = "MotionSpeedsAndTimesStudy")
    private void testCalculateAverageResultsForMotionSpeedAndTimeStudy(){
        tablePage.getTableAction("Calculate average results");
        tablePage.getPopUpMessage()
                .shouldHave(Condition.text(SUCCESS_TABLE_ACTION_RESULT_MESSAGE));
    }

    @BeforeGroups(groups = "ProcessStudyResults", dependsOnGroups = "MotionSpeedsAndTimesStudy")
    private void openProcessStudyResultsTable() {
        open(baseUrl + "/dbe.jsp?warehouseId=" + getWarehouseId() + "&tableId=786&campaignId=1");
    }

    @Test(groups = "ProcessStudyResults")
    private void testCreateNewMTMSet(){
        tablePage.getTableAction("Create new Default motion speed and times set");
        inputParameters.fillCreateNewMTMSetInputs(1);
        tablePage.getPopUpMessage()
                .shouldHave(Condition.text(SUCCESS_TABLE_ACTION_RESULT_MESSAGE));
    }


}
