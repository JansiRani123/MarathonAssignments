package marathon.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.sukgu.Shadow;

public class Architect {
	
public static void main(String[] args)
{
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--disable-notifications");
    ChromeDriver driver=new ChromeDriver(options);
    driver.get("https://login.salesforce.com/");
	driver.manage().window().maximize();
	Shadow dom=new Shadow(driver);
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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
	
	driver.findElement(By.xpath("(//div[@class='roleMenu-item_text'])[2]")).click();
	
	WebElement summary = driver.findElement(By.xpath("//h1[@class='cert-site_title slds-p-vertical--large']/following::div"));
	System.out.println(summary.getText());
	
	List<WebElement> listOfCertificate = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
	for(int i=0;i<listOfCertificate.size();i++)
	{
		WebElement certificateName = listOfCertificate.get(i);
		String name = certificateName.getText();
	    System.out.println(name);
	}
	
	System.out.println("List of Certifications for Application Architect");
	
	driver.findElement(By.xpath("//div[@class='credentials-card_title']/a")).click();
	List<WebElement> certificateListAppl = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
	for(int i=0;i<certificateListAppl.size();i++)
	{
		WebElement certificateName = certificateListAppl.get(i);
		String name = certificateName.getText();
	    System.out.println(name);
	}
	
	
	/*List<WebElement> role = driver.findElements(By.xpath("//div[@class='roleMenu-item_text']"));
	for(int i=0;i<role.size();i++)
	{
		WebElement element = role.get(i);
		String text = element.getText();
	
	if(text.equalsIgnoreCase("Salesforce  Architect")) 		
	    {
		   element.click();
	    }
     */}
}
