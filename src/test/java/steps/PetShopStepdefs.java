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
import java.util.Objects;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class PetShopStepdefs {
    private final WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("I am at petshop page")
    public void iAmAtPetshopPage() {
        driver.manage().window().maximize();
        driver.get("https://www.petnecessity.co.uk/");
        driver.findElement(By.cssSelector(".accept")).click();
        wait.until(ExpectedConditions.
                elementToBeClickable(driver.findElement(By.cssSelector("a.sqs-popup-overlay-close")))).click();
        driver.findElement(By.linkText("Pets Shop!")).click();
    }

    @When("I add item {string} to cart")
    public void iAddItem(String name) {
        String Id = "#thumb-" + name.toLowerCase().replaceAll(" ", "-");
        wait.until(ExpectedConditions.
                elementToBeClickable(driver.findElement(By.cssSelector(Id)))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector
                        (".ProductItem-details-checkout .sqs-add-to-cart-button-wrapper .sqs-add-to-cart-button-inner")))
                .click();
    }

    @Then("The cart includes {int} {string}")
    public void theCartIncludes(int quantity, String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".slide-out-container"))).isDisplayed();
        wait.until((ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("cartFrame"))));
        String title = wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .cssSelector("[data-testid='cart-table-row'] .cart-row-title"))).getText();
        assertEquals(name, title);
        String cartQuantityString = wait.until(ExpectedConditions.visibilityOfElementLocated(By
                        .cssSelector("[data-testid='cart-table-row'] .cart-row-qty-input")))
                .getDomAttribute("value");
        int cartQuantityInt = Integer.parseInt(Objects.requireNonNull(cartQuantityString));
        assertEquals(quantity, cartQuantityInt);
    }

    public void unikEpost() {
        String epost = "tomastestgubbe+" + System.currentTimeMillis() + "@gmail.com";
        String epost2 = UUID.randomUUID()+"@mailnesia.com";
    }
}
