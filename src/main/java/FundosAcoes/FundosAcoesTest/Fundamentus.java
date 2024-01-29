package FundosAcoes.FundosAcoesTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Fundamentus {

private static WebDriver driver = new ChromeDriver();

	public static boolean DriverInicializar(String sPapel) {
		try {		
			String url = "https://www.fundamentus.com.br/detalhes.php?papel=ABCB4";
			driver.get(url);
		
		} catch(Exception e) {
			System.out.println(e.toString());
			return false;
			}
			
		return true;
	}

	public static boolean DriverEncerrar() {
		try {
			driver.quit();
		
		} catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}
		
		return true;
	}
	
	public static String Preco( ) {
		System.out.println("fundamentus - Buscando Preço ");
		String vlrRetorno = "null";
		try {
			
			WebElement e11 = driver.findElement(By.xpath("//td[@class='data destaque w3']"));
	        vlrRetorno = e11.getText().trim();
	        System.out.println(vlrRetorno);
		} catch(Exception e) {
			System.out.println(e.toString());
		
		}

		return vlrRetorno;
	}
	
	public static String PVP( ) {
		System.out.println("fundamentus - Buscando Preço ");
		String vlrRetorno = "null";
		try {
			
			WebElement e11 = driver.findElement(By.xpath("//td[@class='data w2']"));
	        vlrRetorno = e11.getText().trim();
	        System.out.println(vlrRetorno);
		} catch(Exception e) {
			System.out.println(e.toString());
		
		}

		return vlrRetorno;
	}
}
