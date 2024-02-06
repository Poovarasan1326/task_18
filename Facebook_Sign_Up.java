package task_18;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook_Sign_Up {

	public static void main(String[] args) {
		// Initialize the ChromeDriver
		WebDriver driver = new ChromeDriver();

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Maximize the browser window
		driver.manage().window().maximize();

		// navigate to Facebook website
		driver.get("https://www.facebook.com/");

		// Verify the website redirection to the Facebook homepage
		String expectedTitle = "Facebook – log in or sign up";
		String actualTitle = driver.getTitle();
		if (!actualTitle.equals(expectedTitle)) {
			System.out.println("Not on Facebook homepage.");
			driver.quit();
			return;
		}

		// Click on the "Create new account" button
		WebElement createAccountButton = driver.findElement(By.xpath("//a[text()='Create new account']"));
		createAccountButton.click();

		// Fill out the sign-up form
		driver.findElement(By.name("firstname")).sendKeys("Test");
		driver.findElement(By.name("lastname")).sendKeys("User");
		driver.findElement(By.name("reg_email__")).sendKeys("testuser@test.com");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("testuser@test.com");
		driver.findElement(By.name("reg_passwd__")).sendKeys("fvliasbv2542@");

		// Selecting date of birth
		driver.findElement(By.name("birthday_day")).sendKeys("11");
		driver.findElement(By.name("birthday_month")).sendKeys("May");
		driver.findElement(By.name("birthday_year")).sendKeys("1985");

		// Selecting gender
		WebElement genderRadioButton = driver.findElement(By.xpath("//input[@type='radio' and @value='2']"));
		genderRadioButton.click();

		// Click on the "Sign Up" button
		WebElement signUpButton = driver.findElement(By.name("websubmit"));
		signUpButton.click();

		// Verify successful registration and redirection to Facebook homepage
		String expectedHomepageTitle = "Facebook";
		String actualHomepageTitle = driver.getTitle();
		if (!actualHomepageTitle.equals(expectedHomepageTitle)) {
			System.out.println("Sign up unsuccessful.");
		} else {
			System.out.println("User is registered and redirected to Facebook homepage.");
		}

		// Close the browser
		driver.quit();
	}
}