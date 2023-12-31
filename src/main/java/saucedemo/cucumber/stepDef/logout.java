package saucedemo.cucumber.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;
public class logout {
    WebDriver driver;

    String baseUrl = "https://www.saucedemo.com";

    @Given("User open saucedemo website 1")
    public void user_open_the_saucedemo_website_1() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions opt = new FirefoxOptions();
        opt.addArguments("--headless");

        driver = new FirefoxDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        String loginPage = driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]")).getText();
        Assert.assertEquals("Swag Labs", loginPage);
    }

    @When("User login success 1")
    public void user_login_success_1() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id='login-button']")).click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        String iventoryPage = driver.findElement(By.xpath("//*[@class='title']")).getText();
        Assert.assertEquals("Products", iventoryPage);
    }

    @When("User click menu button")
    public void user_click_menu_button() {

        driver.findElement(By.xpath("//*[@id='react-burger-menu-btn']")).click();

        WebElement element = driver.findElement(By.cssSelector("[aria-hidden='false']"));
        String ariaHiddenValue = element.getAttribute("aria-hidden");
        Assert.assertEquals("false", ariaHiddenValue);
    }

    @When("User click logout button")
    public void user_click_logout_button() {
        driver.findElement(By.xpath("//*[@id='logout_sidebar_link']")).click();
    }

    @Then("User verify logout result")
    public void user_verify_logout_result() {
        String loginPage = driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]")).getText();
        Assert.assertEquals("Swag Labs", loginPage);

        driver.quit();
    }
}
