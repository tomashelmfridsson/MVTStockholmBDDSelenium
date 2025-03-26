package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PetShopStepdefs {
    private WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("I am at petshop page")
    public void iAmAtPetshopPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.petnecessity.co.uk/");
        driver.findElement(By.cssSelector(".accept")).click();
        wait.until(ExpectedConditions.
                elementToBeClickable(driver.findElement(By.cssSelector("a.sqs-popup-overlay-close")))).click();
        driver.findElement(By.linkText("Pets Shop!")).click();
    }

    @When("I add item {string}")
    public void iAddItem(String name) {
        // KONG Pull-A-Partz Pinata
        // thumb-kong-pull-a-partz-pinata
        String Id = "#thumb-"+name.toLowerCase().replaceAll(" ","-");
        System.out.println(Id);
        wait.until(ExpectedConditions.
                elementToBeClickable(driver.findElement(By.cssSelector(Id)))).click();
        WebElement addButton =  wait.until(ExpectedConditions.
                elementToBeClickable(driver.findElement(
                        By.linkText("Add To Cart"))));
                        //By.cssSelector(".ProductItem-details-checkout .sqs-add-to-cart-button-wrapper .sqs-add-to-cart-button"))));
        addButton.click();
    }

    @Then("The cart includes {int} {string}")
    public void theCartIncludes(int arg0, String arg1) {
    }
}
