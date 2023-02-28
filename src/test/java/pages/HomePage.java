package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
WebDriver driver;

    // constructor of this page
    public HomePage (WebDriver driver){
    this.driver=driver;
    }

    // locators
    By linkLeft= By.linkText("Living Room");
    By banner=By.xpath("//*[@id=\"meganav-link-5\"]/div");
    By category=By.linkText("Garden");
    By languageBTN= By.xpath("//*[@id=\"platform_modernisation_header\"]/header/div[1]/nav/div[8]/div/button/img");
    By hebrewBTN=By.xpath("//*[@id=\"platform_modernisation_header\"]/header/div[1]/nav/div[9]/div/div[3]/div/div[4]/div/button[1]");
    By shopNowBTN=By.xpath("//*[@id=\"platform_modernisation_header\"]/header/div[1]/nav/div[9]/div/div[3]/div/div[5]/button/span");
    By search=By.xpath("//*[@id=\"header-big-screen-search-box\"]");

    // method
    // method to link in left side
    public void link_left_side(){
    driver.findElement(linkLeft).click();
    driver.navigate().back();
    }
    // method to link in category
    public void link_category(){
        driver.findElement(category).click();
        driver.navigate().back();
    }
    // method to link in banner
    public void link_banner(){
        driver.findElement(banner).click();
      //  driver.navigate().back();
    }
    // method to change language
    public void change_language() throws InterruptedException {
       driver.findElement(languageBTN).click();
       driver.findElement(hebrewBTN).click();
       driver.findElement(shopNowBTN).click();
    }
    // method to search an item
    public void search_item(){
        driver.findElement(search).sendKeys(Constants.search_dress);
    }



}
