package com.utilities;

import com.testCases.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class ElementInteractions {

    public BaseTest baseTest;
    public AppiumDriver driver;
    public long WAIT = 10;

    public ElementInteractions() throws IOException {
        baseTest = new BaseTest();
        this.driver = baseTest.getDriver();
    }

    public WebElement waitForElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void click(WebElement element){
        waitForElement(element).click();
    }

    public void sendKeys(WebElement element, String keyToSend){
        int attempts = 0;
        try{
            waitForElement(element).sendKeys(keyToSend);
        }catch(StaleElementReferenceException e){
            if(attempts <= 2){
                attempts++;
                sendKeys(element, keyToSend);
            }
            else{
                e.printStackTrace();
            }
        }
    }

    public WebElement selectDropDown(List<WebElement> element, String dropdownText){
        WebElement dropdownValue = null;
        for(WebElement e:element){
            String val=e.getText();
            if(val.equals(dropdownText)){
                dropdownValue = e;
                e.click();
                break;
            }
        }
        return dropdownValue;
    }

    public WebElement scrollToElement(String textLocator){
        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().textContains(\""+ textLocator +"\"))"));
    }
}
