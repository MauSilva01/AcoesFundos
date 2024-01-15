package FundosAcoes.FundosAcoesTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Iniciando Busca de Informações!" );
        
        //INicializa a navegação no StatusInvest
        boolean driverOk = StatusInvest.DriverInicializar();
        System.out.println("Statuinvest - Inicializando driver: " + driverOk);
        
        if (driverOk) {
        	
	        System.out.println("Preco Encontrado: " + StatusInvest.Preco());
	        
	        System.out.println("P/VP Encontrado: " + StatusInvest.PVP());
	        
	        System.out.println("liquidezDiaria Encontrado: " + StatusInvest.LiquidezDiaria());
	        
	        System.out.println("DY Encontrado: " + StatusInvest.DY());
	        
	        System.out.println("ROE Encontrado: " + StatusInvest.ROE());
	        
	        System.out.println("Div_ebitida Encontrado: " + StatusInvest.Div_Ebitda());
	        
	        System.out.println("Div_ebitida Encontrado: " + StatusInvest.Ev_Ebitda());
	        
	        System.out.println("PL Encontrado: " + StatusInvest.PL());
	        
	        System.out.println("Patrimonio_Liq Encontrado: " + StatusInvest.Patrimonio_Liq());
	        
	        System.out.println("PAyout Encontrado: " + StatusInvest.PAYOUT());

	        System.out.println("Statuinvest - Encerrando driver: " + StatusInvest.DriverEncerrar());
        }
    }
}
