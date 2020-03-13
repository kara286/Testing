package compraAllianz;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestCreditCard {
	
	    @Test 
	    public static void main(String[] args) throws InterruptedException {
		
		// Create a new instance of the chrome driver
		String service = "D:\\PROGRAMAS\\Browser driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", service);
		ChromeDriver driver = new ChromeDriver();	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//open url  
		driver.get("https://b2c-es.uat.booking.allianz-assistance.com/iframe.html?angularparams=/TRAVEL/B2C/ES/es_ES/step-1");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		int size =driver.findElements(By.tagName("iframe")).size();
		System.out.println("Total frames in page= "+size );
		
		//select iframe		
		driver.switchTo().frame("booking-iframe-id");
		
		//select "Tus opciones"
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div/div/div/form/div[1]/div[2]/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div/div/div/form/div[1]/div[2]/div/ul/li[5]/a")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		//Select tipo de viaje
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div/div/div/form/div[2]/div/div[2]/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div/div/div/form/div[2]/div/div[2]/div/ul/li[5]/a")).click();
				
		//Select Destino
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div/div/div/form/div[8]/div/div[2]/button")).click();	
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div/div/div/form/div[8]/div/div[2]/div[1]/ul/li[4]/a")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div/div/div/form/div[8]/div/div[2]/button")).click();
		
		//select date from-to
		driver.findElement(By.xpath ("//*[@id='travelDatesFrom']")).sendKeys("01/11/2019");
		driver.findElement(By.xpath ("//*[@id='travelDatesTo']")).sendKeys("03/11/2019");
		
		
		//select viajeros
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div/div/div/form/div[12]/div[1]/div[2]/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div/div/div/form/div[12]/div[1]/div[2]/div/ul/li[4]/a")).click();
		
		//Wait
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		//Enter Edad and Precio del viaje
		driver.findElement(By.xpath("//*[@id='ageAtDeparture1']")).click();
		driver.findElement(By.xpath("//*[@id='ageAtDeparture1']")).sendKeys("39");
		
		driver.findElement(By.xpath("//*[@id='pricePerPerson1']")).click();
		driver.findElement(By.xpath("//*[@id='pricePerPerson1']")).sendKeys("1000");
		
		//Click submit
		driver.findElement(By.id("submit")).click();
		
		//Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
		
		//Step Importe
	       
	    driver.findElement(By.xpath("//*[@id='step-2']/ng-include[1]/div/span/div[1]/ng-include/div/ng-include[2]/div/button")).click();
	    							
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //Step Datos del viaje
	    //enter Fecha de Nacimiento
	    driver.findElement(By.xpath("//*[@id='dateOfBirth1']")).click();	  
	    driver.findElement(By.xpath("/html/body/div[4]/div[3]/table/tbody/tr/td/span[11]")).click();
	    driver.findElement(By.xpath("/html/body/div[4]/div[2]/table/tbody/tr/td/span[11]")).click();
	    driver.findElement(By.xpath("/html/body/div[4]/div[3]/table/tbody/tr/td/span[11]")).click();
	    //driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr[4]/td[7]")).click();
	    //driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr[4]/td[6]")).click();
	    		
	    //Enter name
	    driver.findElement(By.xpath("//*[@id='billingFirstName']")).sendKeys("Hiran");
	    driver.findElement(By.xpath("//*[@id='billingLastName']")).sendKeys("pena");
	  
	    //enter identificacion
	    driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div/div/div/form/div[5]/div[4]/div[1]/div[1]/button")).click();
	    driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div/div/div/form/div[5]/div[4]/div[1]/div[1]/div/ul/li[2]/a")).click();
	    driver.findElement(By.xpath("//*[@id='billingVat']")).sendKeys("Y6466925Y");
	   
	    //enter Direccion 
	    driver.findElement(By.xpath("//*[@id='billingAddress']")).sendKeys("Antoni Torrella");
	    
	    //scroll down
	    	    
	    js.executeScript("window.scrollBy(0,1000)");
	 
	    
	    //Enter codigo postal
	    driver.findElement(By.xpath("//*[@id='billingZipCode']")).sendKeys("08224");
	    
	    //Enter ciudad
	    driver.findElement(By.xpath("//*[@id='billingCity']")).sendKeys("Terrassa");
	    
	    //Enter provincia
	    driver.findElement(By.xpath("//*[@id='billingProvince']")).sendKeys("Barcelona");
	    
	    //Enter Telefono
	    driver.findElement(By.xpath("//*[@id='billingPhoneNumber']")).sendKeys("123456789");
	    
	    //Enter email
	    driver.findElement(By.xpath("//*[@id='billingEmail']")).sendKeys("mail@hotmail.com");
	    
	    //Click Confirmar
	    driver.findElement(By.id("submit")).click();
	    
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    //Close the driver
		//driver.quit();
	    
		}
		
	}
	    

