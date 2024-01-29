package FundosAcoes.FundosAcoesTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class investidor10 {
	
	private static WebDriver driver = new ChromeDriver();
	
	public static boolean DriverInicializar(String sPapel) {
		

		try {
			
			String url = "https://investidor10.com.br/acoes/" + sPapel;
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
		System.out.println("investidor10 - Buscando Preço ");
		String vlrRetorno = "null";
		try {
			
	        WebElement e11 = driver.findElement(By.xpath("//span[@class='value']"));
	        vlrRetorno = e11.getText().trim();
	        System.out.println(vlrRetorno);
		} catch(Exception e) {
			System.out.println(e.toString());
		
		}

		return vlrRetorno;
	}
	
	public static String PVP( ) {
		System.out.println("investidor10 - Buscando P/VP ");
		String vlrRetorno = "null";
		try {
			WebElement e11 = driver.findElement(By.xpath("//div[@class='_card vp']"));          
            vlrRetorno = e11.getText().trim();
	        System.out.println(vlrRetorno);
		} catch(Exception e) {
			System.out.println(e.toString());
		
		}

		return vlrRetorno;
	}
	
	public static String LiquidezDiaria( ) {
		System.out.println("investidor10 - Buscando LiquidezDiaria ");
		String vlrRetorno = "null";
		try {
			WebElement e11 = driver.findElement(By.className("cell")); 
	        WebElement e12 = e11.findElement(By.xpath("//span[text()='Liquidez Média Diária']"));
	        WebElement e13 = e12.findElement(By.xpath(".."));
	        vlrRetorno = e13.findElement(By.className("value")).getText();
	        System.out.println(vlrRetorno);
		} catch(Exception e) {
			System.out.println(e.toString());
		
		}

		return vlrRetorno;
	}
	
	public static String DY( ) {
		System.out.println("investidor10 - Buscando DY ");
		String vlrRetorno = "null";
		try {
			WebElement e11 = driver.findElement(By.xpath("//div[@class='_card dy']"));
			vlrRetorno = e11.getText().trim();
	        System.out.println(vlrRetorno);
		} catch(Exception e) {
			System.out.println(e.toString());
		
		}

		return vlrRetorno;
	}

	public static String ROE( ) {
		System.out.println("StatusInvest - Buscando ROE ");
		String vlrRetorno = "null";
		try {
			WebElement e11 = driver.findElement(By.className("cell")); 
	        WebElement e12 = e11.findElement(By.xpath("//div[@class='value d-flex justify-content-between align-items-center']"));
	        WebElement e13 = e12.findElement(By.xpath(".."));
	        vlrRetorno = e13.findElement(By.className("value")).getText();		
	        } catch(Exception e) {
			System.out.println(e.toString());
		
		}

		return vlrRetorno;
	}
	
	public static String Div_Ebitda( ) {
		System.out.println("investidor10 - Buscando div_ebitda ");
		String vlrRetorno = "null";
		try {
	        WebElement e11 = driver.findElement(By.xpath("//div[@title='Indica quanto tempo seria necessário para pagar a dívida líquida da empresa considerando o EBITDA atual. Indica também o grau de endividamento da companhia.']"));
	        vlrRetorno = e11.findElement(By.className("value")).getText();
	        System.out.println(vlrRetorno);
		} catch(Exception e) {
			System.out.println(e.toString());
		
		}

		return vlrRetorno;
	}
	
	public static String Ev_Ebitda( ) {
		System.out.println("investidor10 - Buscando ev_ebitda ");
		String vlrRetorno = "null";
		try {
	        WebElement e11 = driver.findElement(By.xpath("//div[@title='O EV (Enterprise Value ou Valor da Firma), indica quanto custaria para comprar todos os ativos da companhia, descontando o caixa. Este indicador mostra quanto tempo levaria para o valor calculado no EBITDA pagar o investimento feito para compra-la.']"));
	        vlrRetorno = e11.findElement(By.className("value")).getText();
	        System.out.println(vlrRetorno);
		} catch(Exception e) {
			System.out.println(e.toString());
		
		}

		return vlrRetorno;
	}
	
	public static String PL( ) {
		System.out.println("investidor10 - Buscando Patrimonio ");
		String vlrRetorno = "null";
		try {
			
			 WebElement e11 = driver.findElement(By.className("cell")); 
		        WebElement e12 = e11.findElement(By.xpath("//div[@class='value d-flex justify-content-between align-items-center']"));
		        WebElement e13 = e12.findElement(By.xpath(".."));
		        vlrRetorno = e13.findElement(By.className("value")).getText();		
	        System.out.println(vlrRetorno);
		} catch(Exception e) {
			System.out.println(e.toString());
		
		}

		return vlrRetorno;
	}
	
	public static String Patrimonio_Liq( ) {
		System.out.println("investidor10 - Buscando Patrimonio_Liq ");
		String vlrRetorno = "null";
		try {
			 WebElement e11 = driver.findElement(By.xpath("//span[text()='Patrimônio Líquido']"));
			 vlrRetorno = e11.findElement(By.xpath("./following-sibling::span[@class='value']/div[@class='simple-value']")).getText().trim();
	        System.out.println(vlrRetorno);
		} catch(Exception e) {
			System.out.println(e.toString());
		
		}

		return vlrRetorno;
	}
	
//	public static String PAYOUT( ) {
//		System.out.println("investidor10 - Buscando PAYOUT ");
//		String vlrRetorno = "null";
//		try {			
//			 WebElement e11 = driver.findElement(By.xpath("//span[text()='PAYOUT']/following-sibling::div/span"));
//
//	            // Obter o texto interno do elemento de valor
//	            vlrRetorno = e11.getText().trim();
//	        System.out.println(vlrRetorno);
//		} catch(Exception e) {
//			System.out.println(e.toString());
//		
//		}
//
//		return vlrRetorno;
//	}
	
	public static String VlrMercado( ) {
		System.out.println("investidor10 - Buscando Valor Mercado ");
		String vlrRetorno = "null";
		try {
			WebElement e11 = driver.findElement(By.xpath("//span[text()='Valor de mercado']"));

            // Obter o valor diretamente do próximo elemento <div> com a classe "simple-value"
			vlrRetorno = e11.findElement(By.xpath("./following-sibling::span[@class='value']/div[@class='simple-value']")).getText().trim();
		     System.out.println(vlrRetorno);
		} catch(Exception e) {
			System.out.println(e.toString());
		
		}

		return vlrRetorno;
	}
}
