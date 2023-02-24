package com.testCases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.io.*;
import java.net.URL;

import java.util.Properties;

public class BaseTest {

    private static AppiumDriver driver;
    protected Properties props;
    public InputStream inputStream;

    public BaseTest() throws IOException {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);

    }

    public AppiumDriver getDriver() throws IOException {
        if (this.driver == null)
        {
            setup();
        }
        return this.driver;
    }

    public AppiumDriver setup() throws IOException {
        props = new Properties();
        String propFileName = "config.properties";
        inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        props.load(inputStream);

        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("android")
                .setAutomationName(props.getProperty("androidAutomationName"))
                .setAppPackage(props.getProperty("androidAppPackage"))
                .setAppActivity(props.getProperty("androidAppActivity"))
                .setApp(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                + File.separator + "resources" + File.separator + "app/tasks.apk");

        URL url = new URL("http://0.0.0.0:4723");
        return this.driver = new AppiumDriver(url, options);
    }

    @AfterSuite
    public void teardown(){
        driver.quit();
    }
}
