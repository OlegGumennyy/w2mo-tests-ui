package com.logivations.w2mo.ui.pages.dbe.tables;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by horuk.t on 08.02.2017.
 */
public abstract class TableActionsInputParametersProcessStudy extends TablePage {

    public void fillCreateNewMTMSetInputs(int index) {
        //choose pick mode (indexes: 1 - piece, 2 - case, 3 - pallet)
        $(By.cssSelector(".dialogMiddleCenter .gwt-valid-input")).selectOption(index);
    }


}
