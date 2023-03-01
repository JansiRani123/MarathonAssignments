package marathon.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class OrderingMobile {

	public static void main(String[] args) throws InterruptedException 
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
	    ChromeDriver driver=new ChromeDriver(options);
	    driver.get("https://dev86669.service-now.com/");
		driver.manage().window().maximize();
		Shadow dom=new Shadow(driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Testleaf@123");
		driver.findElement(By.id("sysverb_login")).click();
		
		Thread.sleep(3000);
		
		dom.setImplicitWait(30);
		WebElement menu = dom.findElementByXPath(("//div[contains(text(),'All')]"));
		menu.click();
		//dom.setImplicitWait(20);
		WebElement service = dom.findElementByXPath(("//span[contains(text(),'Service Catalog')]"));
		service.click();
		
		WebElement domFrame = dom.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(domFrame);
		
		WebElement mobiles = dom.findElementByXPath(("//div[contains(text(),'Mobiles')]"));
		mobiles.click();
		
		WebElement iphone = dom.findElementByXPath(("//h2[contains(text(),'iPhone 13 pro')]"));
		iphone.click();
		
		driver.findElement(By.xpath("(//span[@class='input-group-radio']/label)[2]")).click();
		
		WebElement dd = driver.findElement(By.xpath("//select[contains(@class,'form-control cat_item_option')]"));
		Select dropDown=new Select(dd);
		dropDown.selectByIndex(1);
		//dropdown.selectByValue("Unlimited [add $4.00]");
		
		driver.findElement(By.xpath("//span[@class='input-group-radio']/following::label[contains(text(),'Gold')]")).click();
		driver.findElement(By.xpath("//span[@class='input-group-radio']/following::label[contains(text(),'256 GB')]")).click();
		
		driver.findElement(By.id("oi_order_now_button")).click();
		WebElement msg = driver.findElement(By.xpath("//div[@class='notification notification-success']/span"));
	    String text = msg.getText();
	    System.out.println(text);
	    
	    WebElement refEle = driver.findElement(By.xpath("//*[@id='requesturl']"));
	    String refNum = refEle.getText();
	    System.out.println(refNum);
	    
	    driver.close();
	}

}
