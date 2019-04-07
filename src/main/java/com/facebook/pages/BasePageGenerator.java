package com.facebook.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageGenerator {
	
	public WebDriver driver;
	public WebDriverWait wait;
	 
    //Constructor
    public BasePageGenerator(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }
 
    //JAVA Generics to Create and return a New Page
    public  <TPage extends BasePage> TPage GetInstance (Class<TPage> pageClass) {
        try {
            //Initialize the Page with its elements and return it.
            return PageFactory.initElements(driver,  pageClass);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
