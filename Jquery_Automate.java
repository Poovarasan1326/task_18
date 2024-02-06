package task_18;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Jquery_Automate {

	public static void main(String[] args) {
		// Initialize the ChromeDriver
		WebDriver driver = new ChromeDriver();

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Maximize the browser window
		driver.manage().window().maximize();

		// Navigate to the jQueryUI droppable website
		driver.get("https://jqueryui.com/droppable/");

		// Switch to the iframe containing the draggable elements
		driver.switchTo().frame(0);

		// Find the source element with the text "Drag me to my target"
		WebElement sourceElement = driver.findElement(By.id("draggable"));

		// Find the target element with the text "Drop here"
		WebElement targetElement = driver.findElement(By.id("droppable"));

		// Create Actions class object
		Actions actions = new Actions(driver);

		// Perform drag and drop
		actions.dragAndDrop(sourceElement, targetElement).build().perform();

		// Switch back to the main content
		driver.switchTo().defaultContent();

		// Verify that the drag and drop operation is successful by checking the color
		// property of the target element's CSS
		String targetElementColor = targetElement.getCssValue("background");

		System.out.println(targetElementColor);

		if (targetElementColor.equals("#fffa90")) {
			System.out.println("Drag and drop successful");
		} else {
			System.out.println("Drag and drop failed");
		}

		// Verify that the text of the target element has changed to "Dropped!"
		String droppedText = targetElement.getText();
		System.out.println(droppedText);
		if (droppedText.equals("Dropped!")) {
			System.out.println("Text verification successful'");
		} else {
			System.out.println("Text verification failed");
		}

		// Close the browser
		driver.quit();
	}
}
