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
        
     //   ConexaoSqlite.adicionarDados("ABCB4");
        	//ConexaoSqlite.adicionarDados("AERI3");
//        ConexaoSqlite.adicionarDados("B3SA3");
//        ConexaoSqlite.adicionarDados("BBDC3");
//        ConexaoSqlite.adicionarDados("BBSE3");
//        ConexaoSqlite.adicionarDados("BEES3");
//        ConexaoSqlite.adicionarDados("BHIA3");
//        ConexaoSqlite.adicionarDados("BMGB4");
//        ConexaoSqlite.adicionarDados("BRAP3");
//        ConexaoSqlite.adicionarDados("CIEL3");
//        ConexaoSqlite.adicionarDados("CMIG4");
//        ConexaoSqlite.adicionarDados("CSMG3");
//        ConexaoSqlite.adicionarDados("CXSE3");
//        ConexaoSqlite.adicionarDados("ITSA3");
//        ConexaoSqlite.adicionarDados("ITSA4");
//        ConexaoSqlite.adicionarDados("ITUB3");
//        ConexaoSqlite.adicionarDados("KLBN4");
//        ConexaoSqlite.adicionarDados("MGLU3");
//        ConexaoSqlite.adicionarDados("NGRD3");
//        ConexaoSqlite.adicionarDados("OIBR3");
//        ConexaoSqlite.adicionarDados("PETR3");
//        ConexaoSqlite.adicionarDados("PETR4");
//        ConexaoSqlite.adicionarDados("SANB4");
//        ConexaoSqlite.adicionarDados("SAPR4");
//        ConexaoSqlite.adicionarDados("TAEE4");
//        ConexaoSqlite.adicionarDados("TRPL4");
//        ConexaoSqlite.adicionarDados("XINA11");
//        
        
        //PrintarStatusInvest();
        //PrintarInvestidor10(); 
        PrintarFundamentus();
        
    }
    
    //Printar os valores retornados do site status invest
    public static void PrintarStatusInvest() {
    	
    	boolean driverOk = StatusInvest.DriverInicializar("");
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
	        
	        //System.out.println("VlrMercado Encontrado: " + StatusInvest.PAYOUT());
	        
	        System.out.println("VlrMercado Encontrado: " + StatusInvest.VlrMercado());

	        System.out.println("Statuinvest - Encerrando driver: " + StatusInvest.DriverEncerrar());
        }
    }
    
    //Printar valores retornados do site investidor10
    public static void PrintarInvestidor10() {
    	
    	boolean driverOk = investidor10.DriverInicializar("");
        System.out.println("investidor10 - Inicializando driver: " + driverOk);
        
        if (driverOk) {
        	
	        System.out.println("Preco Encontrado: " + investidor10.Preco());
	        
	        System.out.println("PVP Encontrado: " + investidor10.PVP());
	        
	        System.out.println("LiquidezDiaria Encontrado: " + investidor10.LiquidezDiaria());
	       
	        System.out.println("DY Encontrado: " + investidor10.DY());
	        
	        System.out.println("ROE Encontrado: " + investidor10.ROE());
	        
	        System.out.println("PL Encontrado: " + investidor10.PL());
	        
	        System.out.println("Patrimonio_Liq Encontrado: " + investidor10.Patrimonio_Liq());
	        
	        System.out.println("PAYOUT Encontrado: " + investidor10.PAYOUT());
	        
	        System.out.println("VlrMercado Encontrado: " + investidor10.VlrMercado());
	        
	        
	        
	        System.out.println("Statuinvest - Encerrando driver: " + investidor10.DriverEncerrar());
		       
        }
    }
    
    public static void PrintarFundamentus() {
    	
    	boolean driverOk = Fundamentus.DriverInicializar();
        System.out.println("Fundamentus - Inicializando driver: " + driverOk);
        
        if (driverOk) {
        	
	        System.out.println("Preco Encontrado: " + Fundamentus.Preco());
	        
	        System.out.println("Preco Encontrado: " + Fundamentus.PVP());
//	        
//	        System.out.println("Preco Encontrado: " + Fundamentus.LiquidezDiaria());
//	       
//            System.out.println("Preco Encontrado: " + Fundamentus.DY());
////	        
//	        System.out.println("Preco Encontrado: " + Fundamentus.ROE());
////	        
//	        System.out.println("Preco Encontrado: " + Fundamentus.Ev_Ebitda());
//	        
//	        System.out.println("Preco Encontrado: " + Fundamentus.PL());
//	        
//	        System.out.println("Preco Encontrado: " + Fundamentus.Patrimonio_Liq());
//	        
//	        //System.out.println("Preco Encontrado: " + investidor10.PAYOUT());
//	        
//	        System.out.println("Preco Encontrado: " + Fundamentus.VlrMercado());

	        System.out.println("Statuinvest - Encerrando driver: " + Fundamentus.DriverEncerrar());
		       
        }
    }
}
