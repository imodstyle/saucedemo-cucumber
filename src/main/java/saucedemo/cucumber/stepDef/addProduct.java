package saucedemo.cucumber.stepDef;

import io.cucumber.java.en.And;
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

public class addProduct {
    WebDriver driver;

    String baseUrl = "https://www.saucedemo.com";

    @Given("User open saucedemo website 3")
    public void user_open_the_saucedemo_website_3() {
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

    @When("User login success 3")
    public void user_login_success_3() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id='login-button']")).click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        String iventoryPage = driver.findElement(By.xpath("//*[@class='title']")).getText();
        Assert.assertEquals("Products", iventoryPage);
    }

    @Then("User is on saucedemo product page 3")
    public void user_is_on_product_page_saucedemo_3() {
        driver.findElement(By.xpath("//*[contains(text(), 'Products')]"));
    }

    @When("User click add to cart button 3")
    public void user_click_add_to_cart_button_3() {
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
    }

    @And("User click cart icon 3")
    public void user_click_cart_icon_3() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @Then("Product show at cart list 3")
    public void product_show_at_cart_list_3() {
        driver.findElement(By.className("inventory_item_name"));
    }

    @Then("Product not show at cart list 3")
    public void product_not_show_at_cart_list_3() {
        driver.findElement(By.className("inventory_item_name"));
    }
}
