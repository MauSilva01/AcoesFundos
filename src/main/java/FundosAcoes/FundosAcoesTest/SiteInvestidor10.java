/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FundosAcoes.FundosAcoesTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Felipe
 */
public class SiteInvestidor10 {
	
	private final WebDriver driver = new ChromeDriver();
	private PapelCotacao papel; 
	
	public boolean InicializarCotacao(String sPapel) {

		try {
			//Inicializando o Pàpel
			this.papel = new PapelCotacao();

			//Definindo valores
			this.papel.Codigo = sPapel;
			this.papel.SiteOrigem = "INVESTIDOR10";

			String url = "https://investidor10.com.br/acoes/" + sPapel;
			driver.get(url);

			//PegandoValores
			this.DividaSobreEbitda();
			this.DividendYield();
			this.Preco();
			this.EvaluationSobreEbitda();    
			this.LiquidezDiaria();
			this.PatrimonioLiquido();    
			this.PatriminoSobreLucro();
			this.Payout();
			this.Preco();
			this.PVP();
			this.ROE();
			this.ValorMercado();

			//Encerrando
			this.DriverEncerrar();

			//Salvando Dados em Banco de Dados
			ConexaoSqlite.SalvarPapelCotacao(papel);

		} catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}

		return true;
	}

	private void DriverEncerrar() {
		System.out.println("Site Investidor10 - Encerrando o Driver. ");
		try {
			driver.quit();
		} catch(Exception e) {
			System.out.println(e.toString());
		}
	}

	private void DividaSobreEbitda() {
		System.out.println("Site Investidor10 - Buscando Divida Sobre Ebitda. ");
		String vlrRetorno = "";
		try {
			WebElement e11 = driver.findElement(By.className("cell")); 
			WebElement e12 = e11.findElement(By.xpath("//span[text()='DÍVIDA LÍQUIDA / EBITDA ']"));
			WebElement e13 = e12.findElement(By.xpath(".."));
			WebElement e14 = e13.findElements(By.xpath("//div[@class='value d-flex justify-content-between align-items-center']")).get(23);
			vlrRetorno = e14.getText().trim();
			System.out.println(vlrRetorno);
		} catch(Exception e) {
			System.out.println(e.toString());
	}
	//Salva o preco
    this.papel.DividaSobreEbitda = papel.formatarValorDB(vlrRetorno);            
}

	private void DividendYield() {
		System.out.println("Site Investidor10 - Buscando DY ");
		String vlrRetorno = "";
		try {
			WebElement e11 = driver.findElement(By.xpath("//span[text()='DY']"));
			WebElement e12 = e11.findElement(By.xpath(".."));
			WebElement e13 = e12.findElement(By.xpath(".."));
			WebElement e14 = e13.findElement(By.xpath(".."));
			WebElement e15 = e14.findElements(By.xpath("//div[@class='_card-body']")).get(4);
			vlrRetorno = e15.getText().trim();
			System.out.println(vlrRetorno);
		} catch(Exception e) {
			System.out.println(e.toString());
		}
		//Salva o dado
		this.papel.DividendYield = papel.formatarValorDB(vlrRetorno);
	}

	private void EvaluationSobreEbitda() {
		System.out.println("Site Investidor10 - Buscando ev_ebitda ");
		String vlrRetorno = "";
		try {
			WebElement e11 = driver.findElement(By.className("cell")); 
			WebElement e12 = e11.findElement(By.xpath("//span[text()='EV/EBIT ']"));
			WebElement e13 = e12.findElement(By.xpath(".."));
			WebElement e14 = e13.findElements(By.xpath("//div[@class='value d-flex justify-content-between align-items-center']")).get(9);
			vlrRetorno = e14.getText().trim();
			System.out.println(vlrRetorno);
		} catch(Exception e) {
			System.out.println(e.toString());
		}
		//Salva o dado
		this.papel.EvaluationSobreEbitda = papel.formatarValorDB(vlrRetorno);
	}

	private void LiquidezDiaria() {
		System.out.println("Site Investidor10 - Buscando Liquidez Diaria.");
		String vlrRetorno = "";
		try {
			WebElement e11 = driver.findElement(By.className("cell")); 
			WebElement e12 = e11.findElement(By.xpath("//span[text()='Liquidez Média Diária']"));
			WebElement e13 = e12.findElement(By.xpath(".."));
			vlrRetorno = e13.findElement(By.className("value")).getText();
			System.out.println(vlrRetorno);
		} catch(Exception e) {
			System.out.println(e.toString());
		}
		//Salva o dado
		this.papel.LiquidezDiaria = papel.formatarValorDB(vlrRetorno);
	}

	private void PatrimonioLiquido() {
		System.out.println("Site Investidor10 - Buscando Patrimonio Liquido ");
		String vlrRetorno = "";
		try {
			WebElement e11 = driver.findElement(By.xpath("//span[text()='Patrimônio Líquido']"));
			vlrRetorno = e11.findElement(By.xpath("./following-sibling::span[@class='value']/div[@class='simple-value']")).getText().trim();
			System.out.println(vlrRetorno);
		} catch(Exception e) {
			System.out.println(e.toString());
		}
		//Salva 
		this.papel.PatrimonioLiquido = papel.formatarValorDB(vlrRetorno);
	}

	private void PatriminoSobreLucro() { //PL
		System.out.println("Site Investidor10 - Buscando Patrimonio Sobre Lucro - P/L.");
		String vlrRetorno = "";
		try {
			WebElement e11 = driver.findElement(By.className("cell")); 
			WebElement e12 = e11.findElement(By.xpath("//div[@class='value d-flex justify-content-between align-items-center']"));
			WebElement e13 = e12.findElement(By.xpath(".."));
			vlrRetorno = e13.findElement(By.className("value")).getText();		
			System.out.println(vlrRetorno);
		} catch(Exception e) {
			System.out.println(e.toString());
		}
		//Salva 
		this.papel.PatriminoSobreLucro = papel.formatarValorDB(vlrRetorno);
	}

	private void Payout() {
		System.out.println("Site Investidor10 - Buscando PAYOUT ");
		String vlrRetorno = "";
		try {			
			WebElement e11 = driver.findElement(By.className("cell")); 
			WebElement e12 = e11.findElement(By.xpath("//span[text()='PAYOUT ']"));
			WebElement e13 = e12.findElement(By.xpath(".."));
			WebElement e14 = e13.findElements(By.xpath("//div[@class='value d-flex justify-content-between align-items-center']")).get(4);
			vlrRetorno = e14.getText().trim();
			System.out.println(vlrRetorno);
		} catch(Exception e) {
			System.out.println(e.toString());
		}
		//Salva 
		this.papel.Payout = papel.formatarValorDB(vlrRetorno);
	}

	private void Preco() {
		System.out.println("Site Investidor10 - Buscando Preço ");
		String vlrRetorno = "";
		try {
			WebElement e11 = driver.findElement(By.xpath("//span[@class='value']"));
			vlrRetorno = e11.getText().trim();
			System.out.println(vlrRetorno);
		} catch(Exception e) {
			System.out.println(e.toString());
		}
		//Salva 
		this.papel.Preco = papel.formatarValorDB(vlrRetorno);
	}

	private void PVP() {
		System.out.println("Site Investidor10 - Buscando Preco Sobre Valor Patrimonial -  P/VP.");
		String vlrRetorno = "";
		try {
			WebElement e11 = driver.findElement(By.xpath("//span[text()='P/VP']"));
			WebElement e12 = e11.findElement(By.xpath(".."));
			WebElement e13 = e12.findElement(By.xpath(".."));
			WebElement e14 = e13.findElement(By.xpath(".."));
			WebElement e15 = e14.findElements(By.xpath("//div[@class='_card-body']")).get(3);
			vlrRetorno = e15.getText().trim();
			System.out.println(vlrRetorno);
		} catch(Exception e) {
			System.out.println(e.toString());
		}
		//Salva 
		this.papel.PVP = papel.formatarValorDB(vlrRetorno);
	}

	private void ROE() {
		System.out.println("Site Investidor10 - Buscando ROE ");
		String vlrRetorno = "";
		try {
			WebElement e11 = driver.findElement(By.className("cell")); 
			WebElement e12 = e11.findElement(By.xpath("//span[text()='ROE ']"));
			WebElement e13 = e12.findElement(By.xpath(".."));
			vlrRetorno = e13.findElement(By.className("value")).getText();		
		} catch(Exception e) {
			System.out.println(e.toString());
		}
		//Salva 
		this.papel.ROE = papel.formatarValorDB(vlrRetorno);
	}

	private void ValorMercado() {
		System.out.println("Site Investidor10 - Buscando Valor Mercado ");
		String vlrRetorno = "";
		try {
			WebElement e11 = driver.findElement(By.xpath("//span[text()='Valor de mercado']"));
			vlrRetorno = e11.findElement(By.xpath("./following-sibling::span[@class='value']/div[@class='simple-value']")).getText().trim();
			System.out.println(vlrRetorno);
		} catch(Exception e) {
			System.out.println(e.toString());
		}
		//Salva 
        this.papel.ValorMercado = papel.formatarValorDB(vlrRetorno);
    }
}
