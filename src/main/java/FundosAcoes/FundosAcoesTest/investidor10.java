package FundosAcoes.FundosAcoesTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class investidor10 {
	
	private static WebDriver driver = new ChromeDriver();
	
	public static boolean DriverInicializarinvest10() {
		
		try {
			driver.get("https://investidor10.com.br/acoes/petr3/");
	
		} catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}
		
		return true;		
	}
	
	public static boolean DriverEncerrarinvest10() {
		try {
			driver.quit();
		
		} catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}
		
		return true;
	}
	
	public static String Preco( ) {
		System.out.println("investidor10 - Buscando Preço ");
		String vlrRetorno = "null";
		try {
			WebElement e11 = driver.findElement(By.className("container")); 
	        WebElement e12 = e11.findElement(By.xpath("//span[text()='Cotação']"));
	       
	        vlrRetorno = e12.findElement(By.className("value")).getText();
	        System.out.println(vlrRetorno);
		} catch(Exception e) {
			System.out.println(e.toString());
		
		}

		return vlrRetorno;
	}
}
