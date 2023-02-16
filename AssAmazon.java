package marathon.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class AssAmazon {

	public static void main(String[] args) throws InterruptedException {
		

		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bags");
		driver.findElement(By.xpath("//div[@class='s-suggestion-container']//span[contains(text(),'for boys')]")).click();
		String msg = driver.findElement(By.xpath("(//div[contains(@class,'a-section a-spacing-small')]/span)[1]")).getText();
		System.out.println(msg);
		
		driver.findElement(By.xpath("//span[@class='a-label a-checkbox-label']/following::span[contains(text(),'Safari')]")).click();
		//DZert
		driver.navigate().back();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class='a-label a-checkbox-label']/following::span[contains(text(),'DZert')]")).click();
		Thread.sleep(500);
        driver.findElement(By.className("a-button-inner")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Newest Arrivals')]")).click();
        String detailsOfbag = driver.findElement(By.xpath("//span[contains(@class,'a-size-base-plus a-color-base a-text-normal')]")).getText();
        String brandName = driver.findElement(By.xpath("//h5[@class='s-line-clamp-1']/span")).getText();
        String discount = driver.findElement(By.xpath("(//div[@class='a-row a-size-base a-color-base']/span)[2]")).getText();
        System.out.println("The Brand name of the bag is :"+ brandName +" and discount today is" + discount);
        
        String titleOfPage = driver.getTitle();
        System.out.println(titleOfPage);
	}

}
