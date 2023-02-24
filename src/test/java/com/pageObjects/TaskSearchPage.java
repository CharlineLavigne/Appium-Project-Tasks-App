package com.pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class TaskSearchPage extends BasePage{

    @AndroidFindBy(className = "android.widget.ImageView")
    private List<WebElement> taskSearchBtn;

    @AndroidFindBy(id = "org.dmfs.tasks:id/search_src_text")
    private WebElement searchBox;

    @AndroidFindBy(id = "android:id/title")
    private List<WebElement> tasksDisplayed;

    public TaskSearchPage() throws IOException {
        super();
    }


    public void clickTaskHome(){
        interactions.click(taskSearchBtn.get(2));
    }

    public void clickSearchBtn(){
        interactions.click(taskSearchBtn.get(6));
    }

    public void addInputToSearchBox(String taskSearched){
        interactions.sendKeys(searchBox, taskSearched);
    }

    public boolean checkTasksDisplayed(){
        if(tasksDisplayed.size() > 1){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean checkIfTaskExists(String taskName){
        for(int i = 1; i<tasksDisplayed.size(); i++){
            if(tasksDisplayed.get(i).getText().equals(taskName)){
                return true;
            }
        }
        return false;
    }
}
