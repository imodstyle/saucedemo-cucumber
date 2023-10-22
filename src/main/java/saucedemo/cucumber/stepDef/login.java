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
public class login {
    WebDriver driver;

    String baseUrl = "https://www.saucedemo.com";

    @Given("User open the saucedemo website")
    public void user_open_the_saucedemo_website() {
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

    @When("User enter {string} as username")
    public void user_enter_standard_user_as_username(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);
    }

    @When("User enter {string} as password")
    public void user_enter_secret_sauce_as_password(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("User click the login button")
    public void user_click_the_login_button() {
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
    }

    @Then("User verify {string} login result")
    public void user_verify_success_login_result(String status) {
        if (status.equals("success")) {
            String dashboardPage = driver.findElement(By.xpath("//*[@class='title']")).getText();
            Assert.assertEquals("Products", dashboardPage);
        } else {
            WebElement errorElement = driver.findElement(By.cssSelector(".error-message-container.error"));
            Assert.assertEquals(errorElement.isDisplayed(), true);
        }
        driver.quit();
    }
}
