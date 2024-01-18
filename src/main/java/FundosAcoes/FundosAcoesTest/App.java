package FundosAcoes.FundosAcoesTest;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Iniciando Busca de Informações!" );
        
        
        //PrintarStatusInvest();
        //PrintarInvestidor10();
        
        //INicializa a navegação no StatusInvest
        
        
        
    }
    
    public static void PrintarStatusInvest() {
    	
    	boolean driverOk = StatusInvest.DriverInicializar();
        System.out.println("Statuinvest - Inicializando driver: " + driverOk);
        
        if (driverOk) {
        	
        	System.out.println("Preco Encontrado: " + StatusInvest.Codigo());
        	
	        System.out.println("Preco Encontrado: " + StatusInvest.Preco());
	        
	        System.out.println("P/VP Encontrado: " + StatusInvest.PVP());
	        
	        System.out.println("liquidezDiaria Encontrado: " + StatusInvest.LiquidezDiaria());
	        
	        System.out.println("DY Encontrado: " + StatusInvest.DY());
	        
	        System.out.println("ROE Encontrado: " + StatusInvest.ROE());
	        
	        System.out.println("Div_ebitida Encontrado: " + StatusInvest.Div_Ebitda());
	        
	        System.out.println("Div_ebitida Encontrado: " + StatusInvest.Ev_Ebitda());
	        
	        System.out.println("PL Encontrado: " + StatusInvest.PL());
	        
	        System.out.println("Patrimonio_Liq Encontrado: " + StatusInvest.Patrimonio_Liq());
	        
	        //System.out.println("VlrMercado Encontrado: " + StatusInvest.PAYOUT());
	        
	        System.out.println("VlrMercado Encontrado: " + StatusInvest.VlrMercado());

	        System.out.println("Statuinvest - Encerrando driver: " + StatusInvest.DriverEncerrar());
        }
    }
    
    public static void PrintarInvestidor10() {
    	
    	boolean driverOk = investidor10.DriverInicializarinvest10();
        System.out.println("Statuinvest - Inicializando driver: " + driverOk);
        
        if (driverOk) {
        	
	        System.out.println("Preco Encontrado: " + investidor10.Preco());
	        
	       
        }
    }
}
