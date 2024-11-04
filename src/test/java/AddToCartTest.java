import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class AddToCartTest extends BaseTest {

    @Test
    public void testAddToCart() {

        driver.findElement(By.xpath("//a[@title='Women']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement item = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@title='Blouse']")));
        item.click();

        WebElement itemColour = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("color_8")));
        js.executeScript("arguments[0].scrollIntoView(true);", itemColour);
        itemColour = wait.until(ExpectedConditions.elementToBeClickable(itemColour));
        itemColour.click();

        driver.findElement(By.xpath("//span[text()='Add to cart']")).click();

        WebElement checkOut = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Proceed to checkout']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkOut);

        checkOut = wait.until(ExpectedConditions.elementToBeClickable(checkOut));
        checkOut.click();

        WebElement checkOutItemPresent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product_2_8_0_0\"]/td[2]/p/a")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkOutItemPresent);

        Assert.assertTrue(checkOutItemPresent.isDisplayed(), "Item was not added to the cart.");
    }
}
