package marathon.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssRedBus {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver =new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//input[@class='db']")).sendKeys("Chenn");
		driver.findElement(By.xpath("//li[@class='sub-city'][1]")).click();
		driver.findElement(By.id("dest")).sendKeys("Bangalo");
		driver.findElement(By.xpath("//li[@class='sub-city'][1]")).click();
		driver.findElement(By.id("onward_cal")).click();
		driver.findElement(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr[5]/td[5]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Search Buses')]")).click();
		Thread.sleep(1000);
		String noOfBuses = driver.findElement(By.xpath("//div[@class='sort-sec clearfix onward ']//span")).getText();
		System.out.println(noOfBuses);
		
		driver.findElement(By.xpath("//label[contains(text(),'SLEEPER')]")).click();
		String nameOfSecBus = driver.findElement(By.xpath("(//div[@class='clearfix row-one'])[2]/div")).getText();
		System.out.println(nameOfSecBus);
		
		String title = driver.getTitle();
		System.out.println("Title of the Page is :" + title);
		
		
	}

}
