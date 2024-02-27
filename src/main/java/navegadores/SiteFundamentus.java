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

<<<<<<< HEAD
    private final WebDriver driver = new ChromeDriver();
    private PapelCotacao papel;

    public boolean InicializarCotacao(String sPapel){    
        return InicializarCotacao( sPapel,  0 );
    }
    
    public boolean InicializarCotacao(String sPapel, int sTipo) {
        try {

            System.out.println("Iniciando Cotacao do " + sPapel);

            this.papel = new PapelCotacao();		
            this.papel.Codigo = sPapel;
            this.papel.SiteOrigem = "Fundamentus";
            String url = "https://www.fundamentus.com.br/detalhes.php?papel=" + sPapel;
            driver.get(url);

            //buscando dados em comum
            
            this.Preco();
            this.ValorMercado();
            this.PVP(); 
                        
            //acoes
            if (sTipo == 0){
                this.EvaluationSobreEbitda();
                this.LiquidezDiaria();             
                this.PatriminoSobreLucro();                         
                this.ROE();
                this.PatrimonioLiquido();
                this.DividendYield();
            }

            //Fundos
            if (sTipo == 1){
                this.FII_QuantidadeImoveis();
                this.FII_Vacancia();
                this.FII_PatrimonioLiquido();
                this.FII_DividendYield();
            }
            
            ConexaoSqlite.SalvarPapelCotacao(papel);
		
	} catch(Exception e) {
            System.out.println(e.toString());
            return false;
	}		
            return true;
    }
=======
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
>>>>>>> 6d5ebf85242a2151c1a6635e8058061c8785d3de

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
<<<<<<< HEAD
                    WebElement e11 = driver.findElement(By.xpath("//span[text()='Cotação']"));
                    WebElement e12 = e11.findElement(By.xpath(".."));
                    WebElement e13 = e12.findElement(By.xpath(".."));
                    WebElement e14 = e13.findElements(By.xpath("//td")).get(3);
                    vlrRetorno = e14.getText().trim();
                    System.out.println(vlrRetorno);
=======
			WebElement e11 = driver.findElement(By.xpath("//span[text()='Cotação']"));
			WebElement e12 = e11.findElement(By.xpath(".."));
			WebElement e13 = e12.findElement(By.xpath(".."));
			WebElement e14 = e13.findElements(By.xpath("//td")).get(3);
			vlrRetorno = e14.getText().trim();
        
>>>>>>> 6d5ebf85242a2151c1a6635e8058061c8785d3de
		} catch(Exception e) {
			System.out.println(e.toString());
		}
		this.papel.Preco = papel.formatarValorDB(vlrRetorno);
	}

	private void PVP( ) {
		System.out.println("fundamentus - Buscando Preço ");
		String vlrRetorno = "null";
		try {
<<<<<<< HEAD

                    WebElement e11 = driver.findElement(By.xpath("//span[text()='P/VP']"));
                    WebElement e12 = e11.findElement(By.xpath(".."));
                    WebElement e13 = e12.findElement(By.xpath(".."));	 
                    WebElement e14 = e13.findElements(By.xpath("//td[@class='data w2']")).get(3);
                    vlrRetorno = e14.getText().trim();
                    System.out.println(vlrRetorno);
=======
	
			WebElement e11 = driver.findElement(By.xpath("//span[text()='P/VP']"));
			WebElement e12 = e11.findElement(By.xpath(".."));
			WebElement e13 = e12.findElement(By.xpath(".."));	 
			WebElement e14 = e13.findElements(By.xpath("//td[@class='data w2']")).get(3);
			vlrRetorno = e14.getText().trim();
			
>>>>>>> 6d5ebf85242a2151c1a6635e8058061c8785d3de
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
<<<<<<< HEAD
                        System.out.println(vlrRetorno);
=======
       
>>>>>>> 6d5ebf85242a2151c1a6635e8058061c8785d3de
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
<<<<<<< HEAD
                        System.out.println(vlrRetorno);
=======
>>>>>>> 6d5ebf85242a2151c1a6635e8058061c8785d3de
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
<<<<<<< HEAD
                        System.out.println(vlrRetorno);
=======
       
>>>>>>> 6d5ebf85242a2151c1a6635e8058061c8785d3de
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
<<<<<<< HEAD
                        vlrRetorno = e13.getText().trim();
                        System.out.println(vlrRetorno);
=======
	        vlrRetorno = e13.getText().trim();
>>>>>>> 6d5ebf85242a2151c1a6635e8058061c8785d3de
	       
		} catch(Exception e) {
			System.out.println(e.toString());	
		}

		this.papel.EvaluationSobreEbitda = papel.formatarValorDB(vlrRetorno);
	}

	private void PatriminoSobreLucro( ) {
<<<<<<< HEAD
		System.out.println("fundamentus - Buscando patrimonio sobre lucro ");
=======
		System.out.println("fundamentus - Buscando ebit ");
>>>>>>> 6d5ebf85242a2151c1a6635e8058061c8785d3de
		String vlrRetorno = "null";
		try {
	
			WebElement e11 = driver.findElement(By.xpath("//span[text()='P/L']"));
			WebElement e12 = e11.findElement(By.xpath("../../.."));		 
			WebElement e13 = e12.findElements(By.xpath(".//td[@class='data w2']")).get(0);
			vlrRetorno = e13.getText().trim();
<<<<<<< HEAD
                        System.out.println(vlrRetorno);
=======
>>>>>>> 6d5ebf85242a2151c1a6635e8058061c8785d3de
       
		} catch(Exception e) {
			System.out.println(e.toString());
	
		}

		this.papel.PatriminoSobreLucro = papel.formatarValorDB(vlrRetorno);
	}

	private void PatrimonioLiquido( ) {
<<<<<<< HEAD
		System.out.println("fundamentus - Buscando patrimonio liq ");
=======
		System.out.println("fundamentus - Buscando ebit ");
>>>>>>> 6d5ebf85242a2151c1a6635e8058061c8785d3de
		String vlrRetorno = "null";
		try {
	
			WebElement e11 = driver.findElement(By.xpath("//span[text()='Patrim. Líq']"));
			WebElement e12 = e11.findElement(By.xpath("../../.."));		 
			WebElement e13 = e12.findElements(By.xpath(".//td[@class='data']")).get(1);
			vlrRetorno = e13.getText().trim();
<<<<<<< HEAD
                        System.out.println(vlrRetorno);
=======
>>>>>>> 6d5ebf85242a2151c1a6635e8058061c8785d3de
       
		} catch(Exception e) {
			System.out.println(e.toString());
	
		}

		this.papel.PatrimonioLiquido = papel.formatarValorDB(vlrRetorno);
	}

	private void ValorMercado( ) {
<<<<<<< HEAD
		System.out.println("fundamentus - Buscando valor mercado  ");
=======
		System.out.println("fundamentus - Buscando ebit ");
>>>>>>> 6d5ebf85242a2151c1a6635e8058061c8785d3de
		String vlrRetorno = "null";
		try {
	
			WebElement e11 = driver.findElement(By.xpath("//span[text()='Valor de mercado']"));
			WebElement e12 = e11.findElement(By.xpath("../../.."));		 
			WebElement e13 = e12.findElements(By.xpath(".//td[@class='data w3']")).get(0);
	        vlrRetorno = e13.getText().trim();
<<<<<<< HEAD
                System.out.println(vlrRetorno);
=======
>>>>>>> 6d5ebf85242a2151c1a6635e8058061c8785d3de
	       
		} catch(Exception e) {
			System.out.println(e.toString());
		
		}		
		this.papel.ValorMercado = papel.formatarValorDB(vlrRetorno);
	}
<<<<<<< HEAD
        
        private void FII_QuantidadeImoveis( ) {
		System.out.println("fundamentus - Buscando quantidade de imoveis ");
		String vlrRetorno = "null";
		try {
                    WebElement e11 = driver.findElement(By.xpath("//span[text()='Qtd imóveis']"));
                    WebElement e12 = e11.findElement(By.xpath("../../.."));		 
                    WebElement e13 = e12.findElements(By.xpath(".//td[@class='data w1']")).get(0);
                    vlrRetorno = e13.getText().trim();
                    System.out.println(vlrRetorno);
		} catch(Exception e) {
			System.out.println(e.toString());
		
		}		
		this.papel.FII_QuantidadeImoveis = papel.formatarValorDB(vlrRetorno);
	}
        
        private void FII_PatrimonioLiquido( ) {
		System.out.println("fundamentus - Buscando patrimonio liq ");
		String vlrRetorno = "null";
		try {
	
			WebElement e11 = driver.findElement(By.xpath("//span[text()='Patrim Líquido']"));
			WebElement e12 = e11.findElement(By.xpath(".."));
			WebElement e13 = e12.findElement(By.xpath(".."));		 
			WebElement e14 = e13.findElements(By.xpath(".//td[@class='data w1']")).get(1);
			vlrRetorno = e14.getText().trim();
                        System.out.println(vlrRetorno);
       
		} catch(Exception e) {
			System.out.println(e.toString());
	
		}

		this.papel.PatrimonioLiquido = papel.formatarValorDB(vlrRetorno);
	}
        
        private void FII_DividendYield( ) {
		System.out.println("fundamentus - Buscando DY ");
		String vlrRetorno = "null";
		try {
	
			WebElement e11 = driver.findElement(By.xpath("//span[text()='Div. Yield']"));
			WebElement e12 = e11.findElement(By.xpath("../../..")); // Ajuste a quantidade de ".." conforme a hierarquia da sua estrutura HTML
			WebElement e15 = e12.findElements(By.xpath(".//td[@class='data']")).get(0); // Subtraia 1 do índice para obter o quinto elemento
			vlrRetorno = e15.getText().trim();
                        System.out.println(vlrRetorno);
		} catch(Exception e) {
			System.out.println(e.toString());	
		}
		this.papel.DividendYield = papel.formatarValorDB(vlrRetorno);
	}
        
         private void FII_Vacancia( ) {
		System.out.println("fundamentus - Buscando vacancia ");
		String vlrRetorno = "null";
		try {
	
			WebElement e11 = driver.findElement(By.xpath("//span[text()='Vacância Média']"));
			WebElement e12 = e11.findElement(By.xpath(".."));
			WebElement e13 = e12.findElement(By.xpath(".."));
			WebElement e14 = e13.findElements(By.xpath(".//td[@class='data w1']")).get(2); // Subtraia 1 do índice para obter o quinto elemento
			vlrRetorno = e14.getText().trim();
                        System.out.println(vlrRetorno);
		} catch(Exception e) {
			System.out.println(e.toString());	
		}
		this.papel.FII_Vacancia = papel.formatarValorDB(vlrRetorno);
	}
        
=======
>>>>>>> 6d5ebf85242a2151c1a6635e8058061c8785d3de
}
