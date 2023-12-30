package lab.pkgfinal.demo; 


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LabFinalDemo {

    public static void main(String[] args) {
        // Set the path of the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/home/student_user/hasanul/chromedriver-linux64/chromedriver");

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        // Navigate to the login page
        driver.get("https://www.saucedemo.com/");

        // Valid login test
        login(driver, "validusername", "validpassword");

        // Invalid login test
        login(driver, "invalidusername", "invalidpassword");

        // Close the browser
        driver.quit();
    }

    private static void login(WebDriver driver, String username, String password) {
        // Locate the username and password fields
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        // Enter the username and password
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        // Click the login button
        loginButton.click();

        // Check if login was successful or not
        if (isLoginSuccessful(driver)) {
            System.out.println("Login successful for user: " + username);
        } else {
            System.out.println("Login failed for user: " + username);
        }

        // Clear the fields for the next test
        usernameField.clear();
        passwordField.clear();
    }

    private static boolean isLoginSuccessful(WebDriver driver) {
        // Check for a success message or any element indicating a successful login
        try {
            WebElement successMessage = driver.findElement(By.id("successMessage"));
            return successMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

