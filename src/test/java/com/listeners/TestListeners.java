package com.listeners;

import com.testCases.BaseTest;
import com.utilities.Utilities;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class TestListeners implements ITestListener {

    Utilities utils;
    BaseTest baseTest;

    //This method prints stackTrace to each test case individually
    //This method takes screenshot of any failed test case
    public void onTestFailure(ITestResult result){
        if(result.getThrowable() != null){
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            result.getThrowable().printStackTrace(pw);
        }
        try {
            baseTest = new BaseTest();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = null;
        try {
            file = baseTest.getDriver().getScreenshotAs(OutputType.FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        utils = new Utilities();

        try {
            String imagePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "java" + File.separator + "com" + File.separator + "screenshots" + File.separator + result.getName() + "_" + utils.getDateTime() + "_" + "screenshot.png";
            FileUtils.copyFile(file, new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
