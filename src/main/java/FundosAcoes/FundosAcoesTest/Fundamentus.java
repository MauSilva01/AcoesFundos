package FundosAcoes.FundosAcoesTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Fundamentus {

private static WebDriver driver = new ChromeDriver();

	public static boolean DriverInicializar(String sPapel) {
		try {		
			String url = "https://www.fundamentus.com.br/detalhes.php?papel=" + sPapel;
			driver.get(url);
			System.out.println("Driver Fundamentus inicializado.");			
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
			
			 WebElement e11 = driver.findElement(By.xpath("//span[text()='Cotação']"));
			 WebElement e12 = e11.findElement(By.xpath(".."));
			 WebElement e13 = e12.findElement(By.xpath(".."));
			 WebElement e14 = e13.findElements(By.xpath("//td")).get(3);
	        vlrRetorno = e14.getText().trim();
	        
		} catch(Exception e) {
			System.out.println(e.toString());
		
		}

		return vlrRetorno;
	}
	
	public static String PVP( ) {
		System.out.println("fundamentus - Buscando Preço ");
		String vlrRetorno = "null";
		try {
			
			 WebElement e11 = driver.findElement(By.xpath("//span[text()='P/VP']"));
			 WebElement e12 = e11.findElement(By.xpath(".."));
			 WebElement e13 = e12.findElement(By.xpath(".."));	 
			 WebElement e14 = e13.findElements(By.xpath("//td[@class='data w2']")).get(3);
	        vlrRetorno = e14.getText().trim();
	       
		} catch(Exception e) {
			System.out.println(e.toString());
		
		}

		return vlrRetorno;
	}
	
	public static String LiquidezDiaria( ) {
		System.out.println("fundamentus - Buscando Preço ");
		String vlrRetorno = "null";
		try {
			
			 WebElement e11 = driver.findElement(By.xpath("//span[text()='Vol $ méd (2m)']"));
			 WebElement e12 = e11.findElement(By.xpath(".."));
			 WebElement e13 = e12.findElement(By.xpath(".."));
			 WebElement e14 = e13.findElements(By.xpath("//td[@class='data']")).get(7);
	        vlrRetorno = e14.getText().trim();
	       
		} catch(Exception e) {
			System.out.println(e.toString());
		
		}

		return vlrRetorno;
	}
	
	public static String DY( ) {
		System.out.println("fundamentus - Buscando DY ");
		String vlrRetorno = "null";
		try {
			
			WebElement e11 = driver.findElement(By.xpath("//span[text()='Div. Yield']"));
			WebElement e12 = e11.findElement(By.xpath("../../..")); // Ajuste a quantidade de ".." conforme a hierarquia da sua estrutura HTML
			WebElement e15 = e12.findElements(By.xpath(".//td[@class='data']")).get(6); // Subtraia 1 do índice para obter o quinto elemento
			 vlrRetorno = e15.getText().trim();
		} catch(Exception e) {
			System.out.println(e.toString());
		
		}

		return vlrRetorno;
	}
	
	public static String ROE( ) {
		System.out.println("fundamentus - Buscando roe ");
		String vlrRetorno = "null";
		try {
			
			 WebElement e11 = driver.findElement(By.xpath("//span[text()='ROE']"));
			 WebElement e12 = e11.findElement(By.xpath("../../.."));			 
			 WebElement e13 = e12.findElements(By.xpath(".//td[@class='data']")).get(7);
	        vlrRetorno = e13.getText().trim();
	       
		} catch(Exception e) {
			System.out.println(e.toString());
		
		}

		return vlrRetorno;
	}
	
	public static String Ev_Ebitda( ) {
		System.out.println("fundamentus - Buscando ebit ");
		String vlrRetorno = "null";
		try {
			
			 WebElement e11 = driver.findElement(By.xpath("//span[text()='EV / EBITDA']"));
			 WebElement e12 = e11.findElement(By.xpath("../../.."));			
			 WebElement e13 = e12.findElements(By.xpath(".//td[@class='data']")).get(9);
	        vlrRetorno = e13.getText().trim();
	       
		} catch(Exception e) {
			System.out.println(e.toString());
		
		}

		return vlrRetorno;
	}
	
	public static String PL( ) {
		System.out.println("fundamentus - Buscando ebit ");
		String vlrRetorno = "null";
		try {
			
			 WebElement e11 = driver.findElement(By.xpath("//span[text()='P/L']"));
			 WebElement e12 = e11.findElement(By.xpath("../../.."));		 
			 WebElement e13 = e12.findElements(By.xpath(".//td[@class='data w2']")).get(0);
	        vlrRetorno = e13.getText().trim();
	       
		} catch(Exception e) {
			System.out.println(e.toString());
		
		}

		return vlrRetorno;
	}
	
	public static String Patrimonio_Liq( ) {
		System.out.println("fundamentus - Buscando ebit ");
		String vlrRetorno = "null";
		try {
			
			 WebElement e11 = driver.findElement(By.xpath("//span[text()='Patrim. Líq']"));
			 WebElement e12 = e11.findElement(By.xpath("../../.."));		 
			 WebElement e13 = e12.findElements(By.xpath(".//td[@class='data']")).get(1);
	        vlrRetorno = e13.getText().trim();
	       
		} catch(Exception e) {
			System.out.println(e.toString());
		
		}

		return vlrRetorno;
	}
	
	public static String VlrMercado( ) {
		System.out.println("fundamentus - Buscando ebit ");
		String vlrRetorno = "null";
		try {
			
			 WebElement e11 = driver.findElement(By.xpath("//span[text()='Valor de mercado']"));
			 WebElement e12 = e11.findElement(By.xpath("../../.."));		 
			 WebElement e13 = e12.findElements(By.xpath(".//td[@class='data w3']")).get(0);
	        vlrRetorno = e13.getText().trim();
	       
		} catch(Exception e) {
			System.out.println(e.toString());
		
		}

		return vlrRetorno;
	}
}
