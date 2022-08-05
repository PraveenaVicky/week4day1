package week4.day1assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Salesforce {
	/*
	 * 2.Load the url as " https://login.salesforce.com/ "
	3..Enter the username as " ramkumar.ramaiah@testleaf. com 
	4. Enter the password as " Password$123 " //id- password
	5.click on the login button--// id Login
	6.click on the learn more option in the Mobile publisher- //span[text()='Learn More']
	7.Switch to the next window using Windowhandles. 
	8.click on the confirm button in the redirecting page"" //button[text()='Confirm']
	9.Get the title
	10.Get back to the parent window	
	11.close the browser

	 * 
	 */

	public static void main(String[] args) throws InterruptedException {

		//We have to call WDM for the browser driver !!
		WebDriverManager.chromedriver().setup(); // verify the version, download, set up !

		//to handle 
		// Launch the browser (chrome)
		
		ChromeOptions options = new ChromeOptions();
		ChromeDriver driver = new ChromeDriver();
		options.addArguments("--disablenotifications");
		
		
		//get salesforce login
		driver.get("https://login.salesforce.com");

		// Maximize the browser 
		driver.manage().window().maximize();

		// Implicit Wait for whole browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Enter the username as " ramkumar.ramaiah@testleaf. com 
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");

		//Enter the password as " Password$123 " //id- password
		driver.findElement(By.id("password")).sendKeys("Password$123");	

		//click on the login button--// id Login
		driver.findElement(By.id("Login")).click();
		
		//handle browser notifications
		

		//click on the learn more option in the Mobile publisher
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		
		Thread.sleep(5000);

		//to the next window using Windowhandles
		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> arrayListofwindows = new ArrayList<String>(windowHandles);
		String newwindow = arrayListofwindows.get(1);
		System.out.println("The number of windows opened" +arrayListofwindows.size() );
		//naviagate to the next window
		driver.switchTo().window(newwindow);

		//confirm button
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		
		//get the title of the page
		System.out.println("Title of the page:: " + driver.getTitle());
		
		driver.close();
		


	}

}
