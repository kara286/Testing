package compra;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class TestBeloved {
	
	
	private static By Producto = By.xpath ("//*[@id=\"bodyContent\"]/div/div[2]/table/tbody/tr[3]/td[3]/a[1]/img");
	private static By Carrito  = By.xpath ("//*[@id=\"tdb4\"]/span[2]");
	
	private static String CantidadComprar = "3";
	private static String CantidadChecar = "3";
	
	private static By Update   = By.xpath ("//*[@id=\"tdb4\"]/span[2]");
	private static By CheckOut = By.xpath("//*[@id=\"tdb5\"]/span[2]");
	
	private static By Correo     = By.name("email_address");
	private static By Password   = By.name("password");
	private static By SignIn     = By.xpath("//*[@id=\"tdb1\"]/span[2]");
	private static By Continuar  = By.xpath("//*[@id=\"tdb6\"]/span[2]");
	private static By MetodoPago = By.ByXPath.xpath("//table[6]//tbody[1]//tr[1]//td[1]");
	private static By Pagar      = By.xpath("//*[@id=\"tdb5\"]/span");
	
	private static By Cantidad    = By.name("cart_quantity[]");
	private static By Encabezado  = By.tagName("h1");
	private static String TextoEsperado="Your Order Has Been Processed!";
	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// Create a new instance of the driver
			
			String service = "C:\\Users\\Administrador\\Documents\\Programas\\chromedriver.exe";
			System.setProperty("webdriver.ie.driver", service);							
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();				
			
	
	driver.get("https://demo.oscommerce.com/");
	WebElement SeleccionarProducto=driver.findElement (Producto);
	SeleccionarProducto.click();		
	WebElement AgregarCarrito=driver.findElement (Carrito);
	AgregarCarrito.click();
	Thread.sleep(1000);
				
	WebElement MeterCantidad=driver.findElement(Cantidad);
	MeterCantidad.clear();
	MeterCantidad.sendKeys(CantidadComprar);
	assertEquals(MeterCantidad.getAttribute("value"),CantidadChecar);
	WebElement Actualizar=driver.findElement (Update);
	Actualizar.click();
	driver.findElement(CheckOut).click();		
	Thread.sleep(1000);
	
	driver.findElement(Correo).sendKeys("hiran.testlio@gmail.com");
	driver.findElement(Password).sendKeys("12345");	
	driver.findElement(SignIn).click();
	Thread.sleep(2000);
	
	
	driver.findElement(Continuar).click();	
	Thread.sleep(2000);
	
	driver.findElement(MetodoPago).click();		
	driver.findElement(Continuar).click();
	
	Thread.sleep(2000);

	driver.findElement(Pagar).click();				
	WebElement BuscarTexto = driver.findElement(Encabezado);
	assertEquals(BuscarTexto.getText(), TextoEsperado);
	System.out.println("Successfully");	
	

}
}

