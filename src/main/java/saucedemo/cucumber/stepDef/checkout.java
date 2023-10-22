package saucedemo.cucumber.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;
public class checkout {
    WebDriver driver;

    String baseUrl = "https://www.saucedemo.com";

    @Given("User open saucedemo website 2")
    public void user_open_the_saucedemo_website_2() {
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

    @When("User login success 2")
    public void user_login_success_2() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id='login-button']")).click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        String iventoryPage = driver.findElement(By.xpath("//*[@class='title']")).getText();
        Assert.assertEquals("Products", iventoryPage);
    }

    @Then("User is on saucedemo product page 2")
    public void user_is_on_product_page_saucedemo_2() {
        driver.findElement(By.xpath("//*[contains(text(), 'Products')]"));
    }

    @And("User click cart icon 2")
    public void user_click_cart_icon_2() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @Then("Product show at cart list 2")
    public void product_show_at_cart_list_2() {
        driver.findElement(By.className("inventory_item_name"));
    }

    @When("User click checkout button 2")
    public void user_click_checkout_button_2() {
        driver.findElement(By.id("checkout")).click();
    }

    @And("User input Firstname")
    public void user_input_Firstname(){
        driver.findElement(By.id("last-name")).sendKeys("Simple");
    }

    @And("User input Lastname")
    public void user_input_Lastname(){
        driver.findElement(By.id("first-name")).sendKeys("User");
    }

    @And("User input postal")
    public void user_input_postal(){
        driver.findElement(By.id("postal-code")).sendKeys("12121");
    }

    @And("User click continue")
    public void user_click_continue() {
        driver.findElement(By.id("continue")).click();
    }

    @Then("Checkout step two page displayed")
    public void checkout_step_two_page_displayed() {
        driver.findElement(By.id("finish")).click();
    }
}
