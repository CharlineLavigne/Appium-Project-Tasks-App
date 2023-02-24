package com.testCases;

import com.pageObjects.BasePage;
import com.pageObjects.ListCreationPage;
import com.utilities.JsonReader;
import com.utilities.StringsReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ListCreationTest extends BaseTest{

    public StringsReader stringsReader;
    public ListCreationPage lcPage;
    public BasePage basePage;
    public JsonReader jsonReader;

    public ListCreationTest() throws IOException {
        super();
        lcPage = new ListCreationPage();
        basePage = new BasePage();
        jsonReader = new JsonReader();
        stringsReader = new StringsReader();
    }

    @Test
    public void createNewListTest() throws Exception {
        String listName = stringsReader.readStringsXML("listName");
        basePage.clickSettingsBtn();
        lcPage.clickDisplayedList();
        lcPage.clickNewList();
        lcPage.setNameList(listName);
        lcPage.clickValidationListName();
        lcPage.clickSaveList();
        basePage.clickBackBtn();
        Assert.assertEquals(lcPage.getTextListSaved(listName), listName);
    }
}
