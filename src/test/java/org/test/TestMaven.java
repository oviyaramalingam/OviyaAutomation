package org.test;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMaven {
	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement search = driver.findElement(By.xpath("//input[@title = 'Search for Products, Brands and More']"));
		search.sendKeys("iphone 16 pro");
		//Thread.sleep(3000);
		//System.out.println("Flower ");
		WebElement submit = driver.findElement(By.xpath("//button[@type ='submit']"));
		System.out.println("search click");
		submit.click();
		List<WebElement> prices = driver.findElements(By.xpath("//div[contains(text(),'₹1')]"));
		Set<String> a = new TreeSet();
		for(int i=0;i<prices.size();i++)
		{		
			WebElement e = prices.get(i);
		a.add(e.getText());
		}
		System.out.println(prices.size());
		System.out.println(a);
		driver.quit();
		System.out.println("Success");
	}

}
