package marathon.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.sukgu.Shadow;

public class Administrator {

	public static void main(String[] args) {
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
	    ChromeDriver driver=new ChromeDriver(options);
	    driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		Shadow dom=new Shadow(driver);
		 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@123");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Learn More')]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list1=new ArrayList<String>(windowHandles);
		String parent = list1.get(0);
		String child = list1.get(1);
		
		driver.switchTo().window(child);
		driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
		
		WebElement learningEle = dom.findElementByXPath(("//span[contains(text(),'Learning')]"));
		learningEle.click();
		
		Actions a =new Actions(driver);
		WebElement trailHeadele = dom.findElementByXPath(("//span[contains(text(),'Learning on Trailhead')]"));
		a.moveToElement(trailHeadele).perform();
		
		WebElement certificateEle = dom.findElementByXPath(("//a[contains(text(),'Salesforce Certification')]"));
		driver.executeScript("arguments[0].click();", certificateEle);
		
		driver.findElement(By.xpath("//a[contains(text(),'Administrator')]")).click();
		String currentPage = driver.getTitle();
		
		List<WebElement> listOfCertificate = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		for(int i=0;i<listOfCertificate.size();i++)
		{
			WebElement certificateName = listOfCertificate.get(i);
			String name = certificateName.getText();
		    System.out.println(name);
		}
		
		
		
		
	}
}
