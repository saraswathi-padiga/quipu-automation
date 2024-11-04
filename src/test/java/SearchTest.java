import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SearchTest extends BaseTest {

    @Test
    public void testSearch() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.id("search_query_top")).sendKeys("t-shirts");
        driver.findElement(By.name("submit_search")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement item = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("lighter")));
        String resultText = item.getText().toLowerCase();
        Assert.assertTrue(resultText.contains("t-shirts"), "Search did not return expected results.");
    }
}
