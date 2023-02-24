package com.testCases;

import com.pageObjects.BasePage;
import com.pageObjects.TaskCreationPage;
import com.utilities.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TaskCreationTest extends BaseTest{

    public TaskCreationPage tcPage;
    public JsonReader jsonReader;
    public BasePage basePage;

    public TaskCreationTest() throws IOException {
        super();
        tcPage = new TaskCreationPage();
        jsonReader = new JsonReader();
        basePage = new BasePage();
    }

    @Test
    public void createNewTaskTest() throws IOException {
        tcPage.clickCreateTaskBtn();
        String taskTitle = jsonReader.getStringJsonObject("data" + File.separator + "taskSearchData.json", "validTasks", "taskName");
        tcPage.setTaskTitle(taskTitle);
        tcPage.clickStatusDropDown();
        String taskStatus = jsonReader.getStringJsonObject("data" + File.separator + "taskSearchData.json", "validTasks", "taskStatus");
        tcPage.selectStatusDropDownOptn(taskStatus);
        tcPage.scrollPage();
        tcPage.clickStartDate();
        tcPage.selectStartDate();
        tcPage.clickvalidationDate();
        tcPage.clickSaveTask();
        basePage.clickBackBtn();
        tcPage.clickMyTasksBtn();
        Assert.assertEquals(taskTitle, tcPage.getTaskNameDisplayed());
    }

}
