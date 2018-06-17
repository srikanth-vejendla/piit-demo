package us.piit;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class StepDefs {

    WebDriver driver;

    @Given("User has navigated to forum login page")
    public void user_has_navigated_to_forum_login_page() {
        System.setProperty("webdriver.chrome.driver","libs/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.get("https://forum.piit.us/");
    }

    @When("User has entered invalid username and password")
    public void user_has_entered_invalid_username_and_password(){
        driver.findElement(By.xpath("//*[@id=\"frmLogin\"]/div/div[3]/dl/dd[1]/input")).sendKeys("testuser");
        driver.findElement(By.xpath("//*[@id=\"frmLogin\"]/div/div[3]/dl/dd[2]/input")).sendKeys("test1234");
    }

    @When("User has clicked on login button")
    public void user_has_clicked_on_login_button() {
        driver.findElement(By.xpath("//*[@id=\"frmLogin\"]/div/div[3]/p/input")).click();
    }

    @Then("User has to be shown with error message")
    public void user_has_to_be_shown_with_error_message() {
        ////*[@id="frmLogin"]/div/div[2]/p[1]
        // That username does not exist.
        Assert.assertEquals("That username does not exist.",driver.findElement(By.xpath("//*[@id=\"frmLogin\"]/div/div[2]/p[1]")).getText());
    }

    @When("User has entered blank username and password")
    public void user_has_entered_blank_username_and_password() {
        driver.findElement(By.xpath("//*[@id=\"frmLogin\"]/div/div[3]/dl/dd[1]/input")).sendKeys(" ");
        driver.findElement(By.xpath("//*[@id=\"frmLogin\"]/div/div[3]/dl/dd[2]/input")).sendKeys(" ");
    }
}
