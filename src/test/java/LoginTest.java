import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("login")));
        signInButton.click();

        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        emailField.sendKeys("padiga.sarswathi@gmail.com");

        WebElement passwordField = driver.findElement(By.id("passwd"));
        passwordField.sendKeys("MyPassword@123");

        WebElement submitButton = driver.findElement(By.id("SubmitLogin"));
        submitButton.click();

        WebElement myAccountHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("page-heading")));

        if (myAccountHeader.getText().equals("Authentication")) {
            System.out.println("Login is successful!");
        } else {
            System.out.println("Login is failed!");
        }
    }
}
