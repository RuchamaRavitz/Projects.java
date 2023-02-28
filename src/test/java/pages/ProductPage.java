package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
    WebDriver driver;
    // constructor of this page
    public ProductPage(WebDriver driver){
        this.driver=driver;
    }
    //
    // locator

    By select_measure=By.xpath("//*[@id=\"dk_container_Size-U12-317\"]/a");
    By choose_measure1=By.xpath("//*[@id=\"dk_container_Size-U12-317\"]/div/ul/li[2]/a");
    By choose_measure2=By.xpath("//*[@id=\"dk_container_Size-U12-317\"]/div/ul/li[3]/a");
    By select_color=By.xpath("//*[@id=\"dk_container_Colour-928851\"]/a");
    By choose_color1=By.xpath("//*[@id=\"dk_container_Colour-928851\"]/div/ul/li[1]/a");
    By BTN_Add_to_the_basket=By.xpath("//*[@id=\"Style928851\"]/section/div[4]/div[4]/div[4]/div/a[1]");
    By BTN_basket=By.xpath("//*[@id=\"platform_modernisation_header\"]/header/div[1]/nav/div[6]/div[1]/div/a/span");
    By see_basket=By.xpath("//*[@id=\"platform_modernisation_header\"]/header/div[1]/nav/div[6]/div[2]/div[2]/div/div[2]/div/div[3]/div[1]/a/span");
    By BTNto_cash=By.xpath("//*[@id=\"title\"]/a[1]");
    By BM=By.xpath("//*[@id=\"dk_container_Size-A90-731\"]/a");

    // method

    // method to choose measure-1
    public void choose_measure1(){
       driver.findElement(select_measure).click();
       driver.findElement(choose_measure1).click();
       // Select value_36=new Select(driver.findElement(select_measure));
       // value_36.selectByValue("13");
    }
    // method to choose color-1
    public void fun_choose_color(){
        driver.findElement(select_color).click();
        driver.findElement(choose_color1).click();
    }
    // method to choose measure-2
    public void choose_measure2(){
        driver.findElement(select_measure).click();
        driver.findElement(choose_measure2).click();
      //  Select value_48=new Select(driver.findElement(select_measure));
      //  value_48.selectByValue("19");
    }

    //  method to add to the basket
    public void add_basket(){
        driver.findElement(BTN_Add_to_the_basket).click();
    }

    // method to see basket
    public void basket(){
      driver.findElement(BTN_basket).click();
        // driver.findElement(see_basket).click();
    }
    // method to go to cash
    public void go_cash(){
        driver.findElement(BTNto_cash);
    }
}
