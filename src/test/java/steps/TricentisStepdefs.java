package steps;

import io.cucumber.java.After;
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

import static org.junit.jupiter.api.Assertions.*;

public class TricentisStepdefs {
    private WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("I am at tricentis page")
    public void iAmOnPage() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
    }

    @When("I go to menu {string}")
    public void iGoToMenu(String name) {
        String cssSel= ".top-menu [href='/" + name
                .toLowerCase()
                .replace(' ', '-') + "']";
        System.out.println("css " +cssSel);
        driver.findElement(By.cssSelector(cssSel))
                .click();
    }

    @Then("I see the book {string}")
    public void iSeeTheBook(String name) {
//        String linkname = name
//                .toLowerCase()
//                .replace("&","")
//                .replaceAll("\\s+","-");
//        System.out.println("Linkname "+linkname);
//        WebElement product = driver.findElement(By
//                .cssSelector(".product-item .details [href='/" + linkname + "']"));
//        assertEquals(name, product.getText());

        assertTrue(driver.findElement(By
                .xpath("//a[text()='"+name+"']")).isDisplayed() );
    }
}
