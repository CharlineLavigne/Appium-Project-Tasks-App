package com.pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class TaskCreationPage extends BasePage {

    @AndroidFindBy(id = "org.dmfs.tasks:id/floating_action_button")
    private WebElement creationTaskBtn;

    @AndroidFindBy(id = "android:id/text1")
    private WebElement taskTitleInput;

    @AndroidFindBy(id = "org.dmfs.tasks:id/integer_choices_spinner")
    private WebElement statusDropDown;

    @AndroidFindBy(id = "org.dmfs.tasks:id/integer_choice_item_text")
    private List<WebElement> choicesStatusDropDown;

    @AndroidFindBy(id = "org.dmfs.tasks:id/task_date_picker")
    private WebElement dateCreationBtn;

    @AndroidFindBy(accessibility = "22 February 2023")
    private WebElement dateSelected;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement validationDateBtn;

    @AndroidFindBy(id = "org.dmfs.tasks:id/editor_action_save")
    private WebElement btnSave;

    @AndroidFindBy(id = "android:id/title")
    private WebElement myTasksBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='task 1']")
    private WebElement taskVerified;

    public TaskCreationPage() throws IOException {
        super();
    }

    public void clickCreateTaskBtn(){
        interactions.click(creationTaskBtn);
    }

    public void setTaskTitle(String taskTitle){
        interactions.sendKeys(taskTitleInput, taskTitle);
    }

    public void clickStatusDropDown(){
        interactions.click(statusDropDown);
    }

    public void selectStatusDropDownOptn(String dropdrownText){
        interactions.selectDropDown(choicesStatusDropDown, dropdrownText);
    }

    public void scrollPage(){
        interactions.scrollToElement("PRIVACY");
    }

    public void clickStartDate(){
        interactions.click(dateCreationBtn);
    }

    public void selectStartDate(){
        interactions.click(dateSelected);
    }

    public void clickvalidationDate(){
        interactions.click(validationDateBtn);
    }

    public void clickSaveTask(){
        interactions.click(btnSave);
    }

    public void clickMyTasksBtn(){
        interactions.click(myTasksBtn);
    }

    public String getTaskNameDisplayed(){
        return taskVerified.getText();
    }
}
