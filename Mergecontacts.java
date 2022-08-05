package week4.day1assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mergecontacts {

	public static void main(String[] args) throws InterruptedException {
		/* 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		 * 
		 * 2. Enter UserName and Password Using Id Locator
		 * 
		 * 3. Click on Login Button using Class Locator
		 * 
		 * 4. Click on CRM/SFA Link
		 * 
		 * 5. Click on contacts Button
		 * 	
		 * 6. Click on Merge Contacts using Xpath Locator
		 * 
		 * 7. Click on Widget of From Contact
		 * 
		 * 8. Click on First Resulting Contact
		 * 
		 * 9. Click on Widget of To Contact
		 * 
		 * 10. Click on Second Resulting Contact
		 * 
		 * 11. Click on Merge button using Xpath Locator
		 * 
		 * 12. Accept the Alert
		 * 
		 * 13. Verify the title of the page	*/
		//steps 1to 4

		//We have to call WDM for the browser driver !!
		WebDriverManager.chromedriver().setup(); // verify the version, download, set up !

		// Launch the browser (chrome)
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");

		// Maximize the browser 
		driver.manage().window().maximize();

		// Implicit Wait for whole browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Demosalesmanager
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();

		//to click contacts
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Merge Contacts")).click();
		driver.findElement(By.xpath("//span[text()='From Contact']/following::img[1]")).click();
		Thread.sleep(3000);

		//handling new window
		Set<String> windowHandlesofFromcontact = driver.getWindowHandles();
		ArrayList arrayListFromContact = new ArrayList(windowHandlesofFromcontact);
		String WindowSecond = (String) arrayListFromContact.get(1);
		String WindowParent = (String) arrayListFromContact.get(0);

		//move to the second new window
		driver.switchTo().window(WindowSecond);
		driver.findElement(By.className("linktext")).click();

		///to contact widget click move to main screen
		driver.switchTo().window(WindowParent);

		//to contact widget click move to main screen
		driver.findElement(By.xpath("//span[text()='To Contact']/following::img[1]")).click();
		Thread.sleep(3000);


		//handling new window of To contact
		Set<String> windowHandlesofTocontact = driver.getWindowHandles();
		ArrayList arrayListToContact = new ArrayList(windowHandlesofTocontact);
		String WindowSecond2= (String) arrayListToContact.get(1);
		driver.switchTo().window(WindowSecond2);

		//To click second resulting To contact
		driver.findElement(By.xpath("//a[text()='DemoLBCust']")).click();

		///to contact widget click move to main screen
		driver.switchTo().window(WindowParent);

		//merge link both contacts
		driver.findElement(By.linkText("Merge")).click();

		//handle the alert and accept it
		Alert acceptalert = driver.switchTo().alert();
		acceptalert.accept();
		
		//get the title of the page;
		System.out.println(driver.getTitle());

	}

}
