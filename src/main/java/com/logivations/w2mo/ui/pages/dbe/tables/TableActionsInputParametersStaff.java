package com.logivations.w2mo.ui.pages.dbe.tables;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by horuk.t on 08.02.2017.
 */
public abstract class TableActionsInputParametersStaff extends TablePage{
    public void fillAddWorkingDaysForShiftInputs(int row,
                                                 int column,
                                                 String startDate,
                                                 String endDate,
                                                 String hours,
                                                 boolean flagIncludeWeekends,
                                                 boolean flagOverrideExisting) {
        ElementsCollection params = getSpecifiedInputParameter();
        //choose Capacity Group
        params.get(1).click();
        getSpecifiedCell(row, column).click();
        $(By.cssSelector(".dialogMiddleCenter .gwt-toolbar-icon-save-foreign-key")).click();
        //set Start Date
        params.get(2).setValue(startDate);
        //set End Date
        params.get(3).setValue(endDate);
        //set Hours
        params.get(4).setValue(hours);
        //set Include Weekends as true
        if (!params.get(6).is(Condition.checked) || flagIncludeWeekends) {
            params.get(6).click();
        }
        //set Override Existing... as true
        if (!params.get(7).is(Condition.checked) || flagOverrideExisting) {
            params.get(7).click();
        }
        //Submit
        $(By.cssSelector(".dialogMiddleCenter .gwt-Button")).click();
    }

    public void fillFillCalendarWithPlannedCapacityInputs(String startDate,
                                                          String endDate,
                                                          String shiftsAssignmentReferenceDay,
                                                          boolean flagIncludeWeekends) {
        ElementsCollection params = getSpecifiedInputParameter();
        //set Start Date
        params.get(1).setValue(startDate);
        //set End Date
        params.get(2).setValue(endDate);
        //set Shifts Assignment Reference Day
        params.get(3).setValue(shiftsAssignmentReferenceDay);
        //set Include Weekends as true
        if (!params.get(4).is(Condition.checked) || flagIncludeWeekends) {
            params.get(4).click();
        }
        //Submit
        $(By.cssSelector(".dialogMiddleCenter .gwt-Button")).click();
    }

    public void fillCreateDisturbancesInputs(int row,
                                             int column,
                                             String duration,
                                             String availability,
                                             String startDate,
                                             String startTime,
                                             String endDate,
                                             String endTime) {
        ElementsCollection params = getSpecifiedInputParameter();
        //choose Capacity Group
        params.get(1).click();
        getSpecifiedCell(row, column).click();
        $(By.cssSelector(".dialogMiddleCenter .gwt-toolbar-icon-save-foreign-key")).click();
        //set Duration
        params.get(2).setValue(duration);
        //set Availability
        params.get(3).setValue(availability);
        //set Set Start
        params.get(4).setValue(startDate);
        params.get(5).setValue(startTime);
        //set Set End
        params.get(6).setValue(endDate);
        params.get(7).setValue(endTime);
        //Submit
        $(By.cssSelector(".dialogMiddleCenter .gwt-Button")).click();
    }

    public void fillAConsiderHolidays(int row,
                                      int column) {
        ElementsCollection params = getSpecifiedInputParameter();
        //choose Absence Reason
        params.get(1).click();
        getSpecifiedCell(row, column).click();
        $(By.cssSelector(".dialogMiddleCenter .gwt-toolbar-icon-save-foreign-key")).click();
        //Submit
        $(By.cssSelector(".dialogMiddleCenter .gwt-Button")).click();
    }
}
