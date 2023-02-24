package com.testCases;

import com.pageObjects.BasePage;
import com.pageObjects.TaskCreationPage;
import com.pageObjects.TaskSearchPage;
import com.utilities.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TaskSearchTest extends BaseTest{

    public TaskSearchPage tsTask;
    public JsonReader jsonReader;
    public TaskCreationPage tcPage;
    public BasePage basePage;

    public TaskSearchTest() throws IOException {
        super();
        tsTask = new TaskSearchPage();
        jsonReader = new JsonReader();
        tcPage = new TaskCreationPage();
        basePage = new BasePage();
    }

    public void createTask() throws IOException {
        tcPage.clickCreateTaskBtn();
        String taskTitle = jsonReader.getStringJsonObject("data" + File.separator + "taskSearchData.json", "validTasks", "taskName");
        tcPage.setTaskTitle(taskTitle);
        tcPage.clickSaveTask();
        basePage.clickBackBtn();
    }

    @Test
    public void searchTasksNotInAppTest() throws IOException {
        tsTask.clickSearchBtn();
        String invalidData = jsonReader.getStringJsonObject("data" + File.separator + "taskSearchData.json", "invalidTasks", "taskName");
        tsTask.addInputToSearchBox(invalidData);
        tsTask.checkTasksDisplayed();
        Assert.assertFalse(tsTask.checkIfTaskExists(invalidData));
    }

    @Test
    public void searchTasksInAppTest() throws IOException, InterruptedException {
        createTask();
        Thread.sleep(2000);
        tsTask.clickSearchBtn();
        String validData = jsonReader.getStringJsonObject("data" + File.separator + "taskSearchData.json", "validTasks", "taskName");
        tsTask.addInputToSearchBox(validData);
        tsTask.checkTasksDisplayed();
        Assert.assertTrue(tsTask.checkIfTaskExists(validData));
        tsTask.clickTaskHome();
    }
}
