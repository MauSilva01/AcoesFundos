/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package navegadores;

import bancodados.ConexaoSqlite;
import models.PapelCotacao;
import models.SeleniumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Mauricio
 */
 
public class SiteStatusInvest {

    private WebDriver driver;
    private PapelCotacao papel;
    
    public boolean InicializarCotacao(String sPapel) {
        return InicializarCotacao( sPapel, 0);
    }
    
    public boolean InicializarCotacao(String sPapel, int sTipo) {
        
        String url = "";
	try {
            System.out.println("Iniciando Cotacao do " + sPapel);
            //Inicializando o papel
            this.papel = new PapelCotacao();			
            this.papel.Codigo = sPapel;
            this.papel.SiteOrigem = "statusinvest";
            
            //Inicializando o driver
            if (sTipo == 0)
                url = "https://statusinvest.com.br/acoes/" + sPapel;
            else
                url = "https://statusinvest.com.br/fundos-imobiliarios/" + sPapel;   
          
            driver = SeleniumDriver.DriverStart();
            driver.get(url);

            //Buscando os dados comuns
            this.Preco();
            this.DividendYield();
            this.LiquidezDiaria();
            this.PVP();         
            
            //Acoes
            if (sTipo == 0) {
                this.DividaSobreEbitda();          
                this.EvaluationSobreEbitda();    
                this.PatrimonioLiquido();    
                this.PatriminoSobreLucro();
                this.ROE();
                this.ValorMercado();               
            }         
            
            //fundos 
            if (sTipo == 1) {
                
                //Vancancia
                //Qtde de Imoveis
            }

            //Salvando papeis
            ConexaoSqlite.SalvarPapelCotacao(papel);

            //fechando o driver
            //driver.quit();
            
        } catch(Exception e) {
            System.out.println(e.toString());
            SeleniumDriver.DriverFinish();
        
            return false;
        }
        return true;
    }

    //Busca Preço da Açao no site Statusinvest
    private void Preco( ) {
    	System.out.println("StatusInvest - Buscando Preço ");
    	String vlrRetorno = "0";
    	try {
    		WebElement e11 = driver.findElement(By.xpath("//div[@title='Valor atual do ativo']"));
    		vlrRetorno = e11.findElement(By.className("value")).getText();
    		System.out.println(vlrRetorno);
    	} catch(Exception e) {
    		System.out.println(e.toString());
	
    	}
    	this.papel.Preco = papel.formatarValorDB(vlrRetorno);
    }

    //Busca P/VP da Açao no site Statusinvest
    private void PVP( ) {
    	System.out.println("StatusInvest - Buscando P/VP ");
    	String vlrRetorno = "0";
    	try {
    		WebElement e11 = driver.findElement(By.xpath("//h3[text()='P/VP']")); 
                WebElement e12 = e11.findElement(By.xpath("../../.."));
    		vlrRetorno = e12.findElement(By.className("value")).getText();
    		System.out.println(vlrRetorno);
    	} catch(Exception e) {
    		System.out.println(e.toString());	
    	}
    	this.papel.PVP = papel.formatarValorDB(vlrRetorno);
    }

    //Busca a Liquidez Diaria da Açao no site Statusinvest
    private void LiquidezDiaria( ) {
    	System.out.println("StatusInvest - Buscando LiquidezDiaria ");
    	String vlrRetorno = "0";
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
    	this.papel.LiquidezDiaria = papel.formatarValorDB(vlrRetorno);
    }

    //Busca o Dividend Yield da açao no site Status invest
    private void DividendYield( ) {
    	System.out.println("StatusInvest - Buscando DY ");
    	String vlrRetorno = "0";
    	try {
    		WebElement e11 = driver.findElement(By.xpath("//div[@title='Dividend Yield com base nos últimos 12 meses']"));
    		vlrRetorno = e11.findElement(By.className("value")).getText();
    		System.out.println(vlrRetorno);
    	} catch(Exception e) {
    		System.out.println(e.toString());
	
    	}
    	this.papel.DividendYield = papel.formatarValorDB(vlrRetorno);
    }

    //Busca o ROE da açao fornecida pelo driver no site Status invest
    private void ROE( ) {
    	System.out.println("StatusInvest - Buscando ROE ");
    	String vlrRetorno = "0";
    	try {
    		WebElement e11 = driver.findElement(By.xpath("//div[@title='Mede a capacidade de agregar valor de uma empresa a partir de seus próprios recursos e do dinheiro de investidores.']"));
    		vlrRetorno = e11.findElement(By.className("value")).getText();
    		System.out.println(vlrRetorno);
    	} catch(Exception e) {
    		System.out.println(e.toString());
	
    	}
    	this.papel.ROE = papel.formatarValorDB(vlrRetorno);
    }

    //Busca o Div_Ebitda da açao fornecida pelo driver no site Status invest
    private void DividaSobreEbitda( ) {
    	System.out.println("StatusInvest - Buscando div_ebitda ");
    	String vlrRetorno = "0";
    	try {
    		WebElement e11 = driver.findElement(By.xpath("//div[@title='Indica quanto tempo seria necessário para pagar a dívida líquida da empresa considerando o EBITDA atual. Indica também o grau de endividamento da companhia.']"));
    		vlrRetorno = e11.findElement(By.className("value")).getText();
    		System.out.println(vlrRetorno);
    	} catch(Exception e) {
    		System.out.println(e.toString());	
    	}
    	this.papel.DividaSobreEbitda = papel.formatarValorDB(vlrRetorno);
    }

    //Busca o Ev_Ebitda da açao fornecida pelo driver no site Status invest
    private void EvaluationSobreEbitda( ) {
    	System.out.println("StatusInvest - Buscando ev_ebitda ");
    	String vlrRetorno = "0";
    	try {
    		WebElement e11 = driver.findElement(By.xpath("//div[@title='O EV (Enterprise Value ou Valor da Firma), indica quanto custaria para comprar todos os ativos da companhia, descontando o caixa. Este indicador mostra quanto tempo levaria para o valor calculado no EBITDA pagar o investimento feito para compra-la.']"));
    		vlrRetorno = e11.findElement(By.className("value")).getText();
    		System.out.println(vlrRetorno);
    	} catch(Exception e) {
    		System.out.println(e.toString());	
    	}
    	this.papel.EvaluationSobreEbitda = papel.formatarValorDB(vlrRetorno);
    }

    //Busca o Patrimonio Liquido da açao fornecida pelo driver no site Status inves
    private void PatriminoSobreLucro( ) {
    	System.out.println("StatusInvest - Buscando Patrimonio ");
    	String vlrRetorno = "0";
    	try {
    		WebElement e11 = driver.findElement(By.xpath("//div[@title='Dá uma ideia do quanto o mercado está disposto a pagar pelos lucros da empresa.']"));
    		vlrRetorno = e11.findElement(By.className("value")).getText();
                System.out.println(vlrRetorno);
    	} catch(Exception e) {
    		System.out.println(e.toString());
	
    	}
    	this.papel.PatriminoSobreLucro = papel.formatarValorDB(vlrRetorno);
    }

    //Busca o PL da açao fornecida pelo driver no site Status inves
    private void PatrimonioLiquido( ) {
    	System.out.println("StatusInvest - Buscando Patrimonio_Liq ");
    	String vlrRetorno = "0";
    	try {
    		WebElement e11 = driver.findElement(By.xpath("//div[@title='É uma referência aos bens e direitos que podem ser convertidos em dinheiro em curto prazo.']"));
    		vlrRetorno = e11.findElement(By.className("value")).getText();
    		System.out.println(vlrRetorno);
    	} catch(Exception e) {
    		System.out.println(e.toString());
	
    	}
    	this.papel.PatrimonioLiquido = papel.formatarValorDB(vlrRetorno);
    }


    private void ValorMercado( ) {
    	System.out.println("StatusInvest - Buscando Valor Mercado ");
    	String vlrRetorno = "0";
    	try {
            WebElement e11 = driver.findElement(By.xpath("//div[@title='O valor da ação multiplicado pelo número de ações existentes']"));
            vlrRetorno = e11.findElement(By.className("value")).getText();
            System.out.println(vlrRetorno);
        } catch(Exception e) {
            System.out.println(e.toString());
        }
	this.papel.ValorMercado = papel.formatarValorDB(vlrRetorno);
    }
}
