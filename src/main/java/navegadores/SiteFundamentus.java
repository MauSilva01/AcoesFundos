/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package navegadores;
import bancodados.ConexaoSqlite;
import models.PapelCotacao;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Mauricio
 */
public class SiteFundamentus {

	private final WebDriver driver = new ChromeDriver();
	private PapelCotacao papel;

	public boolean InicializarCotacao(String sPapel) {
		try {
			
			this.papel = new PapelCotacao();		
			this.papel.Codigo = sPapel;
			this.papel.SiteOrigem = "Fundamentus";
			String url = "https://www.fundamentus.com.br/detalhes.php?papel=" + sPapel;
			driver.get(url);
         
			this.DividendYield();
			this.Preco();
			this.EvaluationSobreEbitda();    
			this.LiquidezDiaria();
			this.PatrimonioLiquido();    
			this.PatriminoSobreLucro();
			this.Preco();
			this.PVP();
			this.ROE();
			this.ValorMercado();
           
          
           
           ConexaoSqlite.SalvarPapelCotacao(papel);
		
		} catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}		
		return true;
	}

	public  boolean DriverEncerrar() {
		try {
			driver.quit();
			
		} catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}	
		return true;
	}

	private void  Preco( ) {
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
		this.papel.Preco = papel.formatarValorDB(vlrRetorno);
	}

	private void PVP( ) {
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
		
		this.papel.PVP = papel.formatarValorDB(vlrRetorno);
	}

	private void LiquidezDiaria() {
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

		this.papel.LiquidezDiaria = papel.formatarValorDB(vlrRetorno);
	}

	private void DividendYield( ) {
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
		this.papel.DividendYield = papel.formatarValorDB(vlrRetorno);
	}

	private void ROE( ) {
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

		this.papel.ROE = papel.formatarValorDB(vlrRetorno);
	}

	private void EvaluationSobreEbitda( ) {
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

		this.papel.EvaluationSobreEbitda = papel.formatarValorDB(vlrRetorno);
	}

	private void PatriminoSobreLucro( ) {
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

		this.papel.PatriminoSobreLucro = papel.formatarValorDB(vlrRetorno);
	}

	private void PatrimonioLiquido( ) {
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

		this.papel.PatrimonioLiquido = papel.formatarValorDB(vlrRetorno);
	}

	private void ValorMercado( ) {
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
		this.papel.ValorMercado = papel.formatarValorDB(vlrRetorno);
	}
}
