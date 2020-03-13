package compra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;



public class CasosDePrueba {

	private static By producto  = By.xpath ("//*[@id=\"bodyContent\"]/div/div[2]/table/tbody/tr[1]/td[1]/a[1]/img");
	private static By producto2 = By.xpath ("//*[@id=\"bodyContent\"]/div/div[2]/table/tbody/tr[3]/td[3]/a[1]/img");
	private static By carrito   = By.xpath ("//*[@id=\"tdb4\"]/span[2]");
	
	private static String cantidadcomprar  = "2";
	private static String cantidadchecar   = "2";
	private static String cantidadcomprar3 = "3";
	private static String cantidadchecar3  = "3";
	
	private static By update   = By.xpath ("//*[@id=\"tdb4\"]/span[2]");
	private static By checkout = By.xpath("//*[@id=\"tdb5\"]/span[2]");
	
	private static By correo     = By.name("email_address");
	private static By password   = By.name("password");
	private static By signin     = By.xpath("//*[@id=\"tdb1\"]/span[2]");
	private static By logoff    = By.xpath("//*[@id=\"tdb4\"]/span");
	private static By continuar  = By.xpath("//*[@id=\"tdb6\"]/span[2]");
	private static By continuar2  = By.xpath("//*[@id=\"tdb4\"]/span[2]");
	
	
	private static By metodopago = By.ByXPath.xpath("//table[6]//tbody[1]//tr[1]//td[1]");
	private static By pagar      = By.xpath("//*[@id=\"tdb5\"]/span");
	
	private static By cantidad    = By.name("cart_quantity[]");
	private static By encabezado  = By.tagName("h1");
	private static String textoesperado="Your Order Has Been Processed!";
	
	private static void esperarTiempo (int tiempo) throws InterruptedException{
		Thread.sleep(tiempo);		
	}
	
					
	public static void main(String[] args) throws InterruptedException {
					
			String service = "C:\\Users\\Administrador\\Documents\\Programas\\chromedriver.exe";
			System.setProperty("webdriver.ie.driver", service);							
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();	
	
	
	driver.get("https://demo.oscommerce.com/");
	
	//Samsung
	WebElement seleccionarproducto=driver.findElement (producto);
	seleccionarproducto.click();
	WebElement agregarcarrito=driver.findElement (carrito);
	agregarcarrito.click();
	
	esperarTiempo (1000);
				
	WebElement metercantidad=driver.findElement(cantidad);
	metercantidad.clear();
	metercantidad.sendKeys(cantidadcomprar);
	assertEquals(metercantidad.getAttribute("value"),cantidadchecar);
	WebElement actualizar=driver.findElement (update);
	actualizar.click();
	driver.findElement(checkout).click();		
	
	esperarTiempo (1000);
	
	driver.findElement(correo).sendKeys("hiran.testlio@gmail.com");
	driver.findElement(password).sendKeys("12345");	
	driver.findElement(signin).click();
	
	esperarTiempo (1000);
	
	driver.findElement(continuar).click();	
	esperarTiempo (1000);
		
	driver.findElement(metodopago).click();		
	driver.findElement(continuar).click();
	esperarTiempo (1000);

	driver.findElement(pagar).click();				
	WebElement buscartexto = driver.findElement(encabezado);
	assertEquals(buscartexto.getText(), textoesperado);
	System.out.println("Compra Samsung Satisfactoria");
	
	driver.findElement(logoff).click();
	esperarTiempo (1000);
	driver.findElement(continuar2).click();
	
	
	//Beloved

	WebElement seleccionarproducto2=driver.findElement (producto2);
	seleccionarproducto2.click();	
	
	WebElement agregarcarrito2=driver.findElement (carrito);
	agregarcarrito2.click();
	esperarTiempo (1000);
				
	WebElement metercantidad3=driver.findElement(cantidad);
	metercantidad3.clear();
	metercantidad3.sendKeys(cantidadcomprar3);
	assertEquals(metercantidad3.getAttribute("value"),cantidadchecar3);
	WebElement actualizar2=driver.findElement (update);
	actualizar2.click();
	driver.findElement(checkout).click();		
	esperarTiempo (1000);
	
	driver.findElement(correo).sendKeys("hiran.testlio@gmail.com");
	driver.findElement(password).sendKeys("12345");	
	driver.findElement(signin).click();
	esperarTiempo (1000);
	
	driver.findElement(continuar).click();	
	esperarTiempo (1000);
	
	driver.findElement(metodopago).click();		
	driver.findElement(continuar).click();
	
	esperarTiempo (1000);

	driver.findElement(pagar).click();				
	WebElement buscartexto2 = driver.findElement(encabezado);
	assertEquals(buscartexto2.getText(), textoesperado);
	System.out.println("Successfully");	

	System.out.println("Compra Beloved Satisfactoria");

}
	
}
	


