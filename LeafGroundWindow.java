package week4.day1assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundWindow {

	public static void main(String[] args) throws InterruptedException {

		// TODO Auto-generated method stub
		//chrome launch
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//Lauch Url		
		driver.get("https://leafground.com/window.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		//Work with windows
		//click button to open new windows
		driver.findElement(By.id("home")).click();
		//window handling to open multiple windows
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		//to handle 
		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> arrayListofnewwindow = new ArrayList<String>(windowHandles);
		System.out.println("The number of windows opened " + arrayListofnewwindow.size());
		
		//Do not close me:		
		driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		ArrayList<String> arrayListofnewwindow2 = new ArrayList<String>(windowHandles2);
		System.out.println("The number of windows opened  " + arrayListofnewwindow2.size());
		
		String parentwindow =  arrayListofnewwindow2.get(0);
		//Total existing windows are 6  including parent window 
		
		/*String window1 = arrayListofnewwindow2.get(1);
		driver.switchTo().window(window1).close();
		String window2 = arrayListofnewwindow2.get(2); 
		driver.switchTo().window(window2).close();
		String window3 = arrayListofnewwindow2.get(3); 
		driver.switchTo().window(window3).close();
		String window4 = arrayListofnewwindow2.get(4); 
		driver.switchTo().window(window4).close();
		String window5 = arrayListofnewwindow2.get(5); 
		driver.switchTo().window(window5).close();
		
		*/
		for (int i = 1; i < arrayListofnewwindow2.size(); i++) {
			String string = arrayListofnewwindow2.get(i);
			driver.switchTo().window(string).close();
		}
		{
			
		driver.switchTo().window(parentwindow);
		}
		//to wait until the number of clickable items are two
		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
		//Explicitly wait is used
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
				
		driver.close();	
		}
		
	}


