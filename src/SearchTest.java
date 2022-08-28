import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class SearchTest {

	@Test
	void testSearchByKeyword() throws InterruptedException  {
		WebDriver browser = null;
		String bw = "chome";
		if(bw.equalsIgnoreCase("chome")) {
     		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			 browser = new ChromeDriver();
		}else {
			System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
			 browser = new FirefoxDriver();
		}
		
		browser.get("http://google.com");
		browser.findElement(By.name("q")).sendKeys("NPRU");
		browser.findElement(By.name("q")).sendKeys(Keys.ENTER);
		//browser.findElement(By.name("btnK")).click();
		//System.out.print("Page Title : "+browser.getTitle());
		String result = browser.findElement(By.xpath("/html/body/div[7]/div/div[10]/div[2]/div/div/div[2]/div/div[1]/div[2]/div[1]/div/div[2]/h2/span")).getText();
		assertEquals("มหาวิทยาลัยราชภัฏนครปฐม", result);
		Thread.sleep(500);
		browser.close();
	}

}
