/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package navegadores;

import bancodados.ConexaoSqlite;
import models.PapelCotacao;
import models.SeleniumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 *
 * @author Mauricio
 */

public class SiteInvestidor10 {

    private static WebDriver driver;
    private PapelCotacao papel; 

    public boolean InicializarCotacao(String sPapel) {
        return InicializarCotacao(sPapel , 0);
    }

    public boolean InicializarCotacao(String sPapel, int sTipo) {
        String url = "";

        try {         
            System.out.println("Iniciando Cotacao do " + sPapel);
            
            //Inicializando o Pàpel
            this.papel = new PapelCotacao();
            //Definindo valores
            this.papel.Codigo = sPapel;
            this.papel.SiteOrigem = "INVESTIDOR10";

            //Definindo qual pesquisa fazer
            if (sTipo == 0){
                 url = "https://investidor10.com.br/acoes/" + sPapel;
            }else {
                 url = "https://investidor10.com.br/fiis/" + sPapel;
            }
            
            driver = SeleniumDriver.DriverStart();
            driver.get(url);
            
            //buscando valores em comum
            this.Preco();
            this.PVP();

            //buscando açoes
            if (sTipo == 0){
                this.EvaluationSobreEbitda();  
                this.PatriminoSobreLucro();
                this.Payout();		
                this.ROE();
                this.ValorMercado();
                this.DividendYield();
                this.LiquidezDiaria();
                this.PatrimonioLiquido(); 
            }

            //buscando fundos
            if (sTipo == 1){
                //this.FII_QuantidadeImoveis();
                this.FII_Vacancia();
                this.FII_DividendYield();
                this.FII_LiquidezDiaria();
                this.FII_PatrimonioLiquido();
            }

            //Salvando Dados em Banco de Dados
            ConexaoSqlite.SalvarPapelCotacao(papel);
            
            //driver.quit();

        }catch(Exception e) {
            System.out.println(e.toString());
            SeleniumDriver.DriverFinish();
            return false;
        }
        return true;
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
        }catch(Exception e) {
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
            WebElement e11 = driver.findElement(By.xpath("//span[@title='P/VP']"));
            WebElement e12 = e11.findElement(By.xpath("../../.."));
            WebElement e13 = e12.findElement(By.xpath(".//div[@class='_card-body']"));
            vlrRetorno = e13.getText().trim();
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
            System.out.println(vlrRetorno);
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

    private void FII_Vacancia() {
        System.out.println("Site Investidor10 - Buscando vacancia ");
        String vlrRetorno = "";
        try {
            WebElement e13 = driver.findElements(By.xpath("//div[@class='value']")).get(9);
            vlrRetorno = e13.getText().trim();
            System.out.println(vlrRetorno);
        } catch(Exception e) {
            System.out.println(e.toString());
        }
        //Salva 
        this.papel.FII_Vacancia = papel.formatarValorDB(vlrRetorno);
    }

    private void FII_DividendYield() {
        System.out.println("Site Investidor10 - Buscando FII dy ");
        String vlrRetorno = "";
        try {
            WebElement e11 = driver.findElement(By.xpath("//span[@title='Dividend Yield']"));
            WebElement e12 = e11.findElement(By.xpath("../../.."));
            vlrRetorno = e12.findElement(By.xpath(".//div[@class='_card-body']")).getText().trim();
            System.out.println(vlrRetorno);
        } catch(Exception e) {
            System.out.println(e.toString());
        }
        //Salva 
        this.papel.DividendYield = papel.formatarValorDB(vlrRetorno);
    }

    private void FII_LiquidezDiaria() {
        System.out.println("Site Investidor10 - Buscando FII liquidez diaria");
        String vlrRetorno = "";
        try {
            WebElement e11 = driver.findElement(By.xpath("//span[@title='Liquidez Diária']"));
            WebElement e12 = e11.findElement(By.xpath("../../.."));
            vlrRetorno = e12.findElement(By.xpath(".//div[@class='_card-body']")).getText().trim();
            System.out.println(vlrRetorno);
        } catch(Exception e) {
          System.out.println(e.toString());
        }
        //Salva 
        this.papel.LiquidezDiaria = papel.formatarValorDB(vlrRetorno);
    }
    
    private void FII_PatrimonioLiquido() {
        System.out.println("Site Investidor10 - Buscando FII patrimonio liquido");
        String vlrRetorno = "";
        try {   
            WebElement e11 = driver.findElement(By.xpath("//span[text()='VALOR PATRIMONIAL']"));
            WebElement e12 = e11.findElement(By.xpath("../../.."));
            WebElement e13 = e12.findElements(By.xpath("//div[@class='value']")).get(13);
            vlrRetorno = e13.getText().trim();
            System.out.println(vlrRetorno);
        } catch(NoSuchElementException e) {
            System.out.println(e.toString());
        }catch(Exception e) {
            System.out.println("Exceção ao buscar o valor patrimonial: " + e.toString());
        }
        //Salva 
        this.papel.PatrimonioLiquido = papel.formatarValorDB(vlrRetorno);
    }
}
