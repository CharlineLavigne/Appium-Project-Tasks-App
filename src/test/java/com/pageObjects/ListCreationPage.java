package com.pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class ListCreationPage extends BasePage{

    @AndroidFindBy(id = "org.dmfs.tasks:id/title")
    private WebElement displayedListBtn;

    @AndroidFindBy(accessibility = "Add List")
    private WebElement btnCreateList;

    @AndroidFindBy(id = "android:id/input")
    private WebElement listNameInput;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement validationListName;

    @AndroidFindBy(id = "android:id/button3")
    private WebElement listSaveBtn;

    @AndroidFindBy(id = "android:id/title")
    private List <WebElement> listSaved;

    public ListCreationPage() throws IOException {
        super();
    }

    public void clickDisplayedList(){
        interactions.click(displayedListBtn);
    }

    public void clickNewList(){
        interactions.click(btnCreateList);
    }

    public void setNameList(String listName){
        interactions.sendKeys(listNameInput, listName);
    }

    public void clickValidationListName(){
        interactions.click(validationListName);
    }

    public void clickSaveList(){
        interactions.click(listSaveBtn);
    }

    public String getTextListSaved(String listName){
        for(WebElement e:listSaved){
            if(e.getText().equals(listName)){
                return e.getText();
            }
        }
        return null;
    }
}
