package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
    WebDriver driver;
    // constructor of this page
    public SearchPage(WebDriver driver){
        this.driver=driver;
    }
    // locators
    By searchBox=By.xpath("//*[@id=\"header-big-screen-search-box\"]");
    By number1Product=By.xpath("//*[@id=\"platform_modernisation_product_summary_A90731\"]/div/div[1]/div[1]/a/img");

    // method

    // method to search box and click
    public void search_product(){
        WebElement search= driver.findElement(searchBox);
        search.sendKeys(Constants.search_dress);
        search.click();
    }
    // method to choose product
    public void choose_product(){
        driver.findElement(number1Product).click();
    }


}


