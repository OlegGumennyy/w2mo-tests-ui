package com.logivations.w2mo.ui.utils;

import com.logivations.w2mo.ui.pages.general.LayoutSelectorPage;
import com.logivations.w2mo.ui.pages.general.LoginPage;

import static com.codeborne.selenide.Selenide.*;

/*******************************************************************************
 * (C) Copyright
 * Logivations GmbH, Munich 2010-2016
 ******************************************************************************/

public class PreConditions {

    private final String SERVER_URL = "https://w2mo-2.logivations.com/whapp/index.jsp";

    LoginPage loginPage;
    LayoutSelectorPage layoutSelectorPage;

    public void signIn(String user, String pass){
        open(SERVER_URL, LoginPage.class);
        loginPage.loginWithCorrectData(user, pass);
    }

    public void signInAndChooseWHLayout(String user, String pass, String layoutName){
        signInAndChooseANYLayout(user, pass, layoutName);
    }

    public void signInAndChooseCRMLayout(String user, String pass, String layoutName){
        signInAndChooseANYLayout(user, pass, layoutName);
    }

    public void signInAndChooseLNOLayout(String user, String pass, String layoutName){
        signInAndChooseANYLayout(user, pass, layoutName);
    }

    private void signInAndChooseANYLayout(String user, String pass, String layoutName) {
        loginPage = open(SERVER_URL, LoginPage.class);
        loginPage.loginWithCorrectData(user, pass);
        layoutSelectorPage.openSpecifiedWHLayout(layoutName);
    }

}
