package FundosAcoes.FundosAcoesTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StatusInvest {


    private static  WebDriver driver = new ChromeDriver();
	
	public static boolean DriverInicializar() {

		try {
			driver.get("https://statusinvest.com.br/acoes/petr3");
	
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
		System.out.println("StatusInvest - Buscando Preço ");
		String vlrRetorno = "null";
		try {
	        WebElement e1 = driver.findElement(By.xpath("//div[@title='Valor atual do ativo']"));
	        vlrRetorno = e1.findElement(By.className("value")).getText();
	        System.out.println(vlrRetorno);
		} catch(Exception e) {
			System.out.println(e.toString());
		
		}

		return vlrRetorno;
	}
	
	public static String PVP( ) {
		System.out.println("StatusInvest - Buscando P/VP ");
		String vlrRetorno = "null";
		try {
	        WebElement e1 = driver.findElement(By.xpath("//div[@title='Facilita a análise e comparação da relação do preço de negociação de um ativo com seu VPA.']"));       
	        
	        vlrRetorno = e1.findElement(By.className("value")).getText();
	        System.out.println(vlrRetorno);
		} catch(Exception e) {
			System.out.println(e.toString());
		
		}

		return vlrRetorno;
	}
	
	public static String LiquidezDiaria( ) {
		System.out.println("StatusInvest - Buscando LiquidezDiaria ");
		String vlrRetorno = "null";
		try {
			WebElement e11 = driver.findElement(By.className("info")); 
	        WebElement e12 = e11.findElement(By.xpath("//span[text()='Liquidez média diária']"));
	        WebElement e13 = e12.findElement(By.xpath(".."));
	        WebElement e14 = e13.findElement(By.xpath(".."));
	        vlrRetorno = e14.findElement(By.className("value")).getText();
	        System.out.println(vlrRetorno);
		} catch(Exception e) {
			System.out.println(e.toString());
		
		}

		return vlrRetorno;
	}
	
	public static String DY( ) {
		System.out.println("StatusInvest - Buscando DY ");
		String vlrRetorno = "null";
		try {
			WebElement e11 = driver.findElement(By.xpath("//div[@title='Dividend Yield com base nos últimos 12 meses']"));
	        vlrRetorno = e11.findElement(By.className("value")).getText();
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
	        WebElement e11 = driver.findElement(By.xpath("//div[@title='Mede a capacidade de agregar valor de uma empresa a partir de seus próprios recursos e do dinheiro de investidores.']"));
	        vlrRetorno = e11.findElement(By.className("value")).getText();
	        System.out.println(vlrRetorno);
		} catch(Exception e) {
			System.out.println(e.toString());
		
		}

		return vlrRetorno;
	}
	
	public static String Div_Ebitda( ) {
		System.out.println("StatusInvest - Buscando div_ebitda ");
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
		System.out.println("StatusInvest - Buscando ev_ebitda ");
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
		System.out.println("StatusInvest - Buscando Patrimonio ");
		String vlrRetorno = "null";
		try {
	        WebElement e11 = driver.findElement(By.xpath("//div[@title='Dá uma ideia do quanto o mercado está disposto a pagar pelos lucros da empresa.']"));
	        vlrRetorno = e11.findElement(By.className("value")).getText();
	        System.out.println(vlrRetorno);
		} catch(Exception e) {
			System.out.println(e.toString());
		
		}

		return vlrRetorno;
	}
	
	public static String Patrimonio_Liq( ) {
		System.out.println("StatusInvest - Buscando Patrimonio_Liq ");
		String vlrRetorno = "null";
		try {
	        WebElement e11 = driver.findElement(By.xpath("//div[@title='É uma referência aos bens e direitos que podem ser convertidos em dinheiro em curto prazo.']"));
	        vlrRetorno = e11.findElement(By.className("value")).getText();
	        System.out.println(vlrRetorno);
		} catch(Exception e) {
			System.out.println(e.toString());
		
		}

		return vlrRetorno;
	}
	
	public static String PAYOUT( ) {
		System.out.println("StatusInvest - Buscando PAYOUT ");
		String vlrRetorno = "null";
		try {
			WebElement e11 = driver.findElement(By.className("card chart-and-list rounded pt-3 pb-3 mb-5 show-empty-callback")); 
	        WebElement e12 = e11.findElement(By.xpath("//span[text()='ATUAL']"));
	        WebElement e13 = e12.findElement(By.xpath(".."));
	        WebElement e14 = e13.findElement(By.xpath(".."));
	        vlrRetorno = e14.findElement(By.className("value")).getText();
	        System.out.println(vlrRetorno);
		} catch(Exception e) {
			System.out.println(e.toString());
		
		}

		return vlrRetorno;
	}
}
