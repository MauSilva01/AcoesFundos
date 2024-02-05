package FundosAcoes.FundosAcoesTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoSqlite {

	public static void adicionarDados(String sPapel) {

		DadosStatusinvest(sPapel);
		
		Dadosinvestidor10(sPapel);
		
		DadosFundamentus(sPapel);
		
	}
	 
	
	 public static Connection ObterConexaoBanco() {
		 Connection conn = null;
		    try {
		      // Cria a conexão com o banco de dados
		      conn = DriverManager.getConnection("jdbc:sqlite:C:\\Programas\\FundosAçoes\\fundosAcoes\\BD\\Cotacoes.db");
		      
		      System.out.println("Conexão com o banco de dados SQL Server estabelecida com sucesso!");
		  
		    } catch(SQLException e) {
		      System.err.println(e.getMessage());
		      System.out.println("Erro ao estabelecer conexão com o banco de dados Access: " + e.toString());
		    }
			return conn;
	 }
	 
	 private static void inserirNoBanco(Connection conn, String codigo, String origem,  String preco, String pvp, String liquidezDiaria, String dy, String roe, String div_ebitda, String ev_ebitda, String pl, String payout,String patrimonio_liq, String vlrMercado) {
	        try {
     
	            String query = "INSERT INTO Cotacoes_acoes (DATA, CODIGO, ORIGEM, PRECO, P_VP, LIQUIDEZ_DIARIA, DY_MED_PERC, ROE, DIV_EBITIDA, EV_EBITIDA, PATRIMONIO_LUCRO, PL,PAYOUT, VALOR_MERCADO) VALUES ( DATETIME('now' , 'localtime'),?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	            PreparedStatement preparedStatement = conn.prepareStatement(query);
	            preparedStatement.setString(1, codigo);
	            preparedStatement.setString(2, origem);
	            preparedStatement.setString(3, preco);
	            preparedStatement.setString(4, pvp);
	            preparedStatement.setString(5, liquidezDiaria);
	            preparedStatement.setString(6, dy);
	            preparedStatement.setString(7, roe);
	            preparedStatement.setString(8, div_ebitda);
	            preparedStatement.setString(9, ev_ebitda);
	            preparedStatement.setString(10, pl);
	            preparedStatement.setString(11, patrimonio_liq);
	            preparedStatement.setString(12, payout);
	            preparedStatement.setString(13, vlrMercado);
	            
	            // Adicione os demais campos e valores...

	            preparedStatement.executeUpdate();
	        
	            System.out.println("Dados inseridos com Sucesso!!");
	            
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("Erro ao tentar Inserir dados ");
	        }
	    }
	 
	 public static void DadosStatusinvest(String sPapel) {
		 
		 Connection conn = ObterConexaoBanco();
		 
		 boolean driverOk1 = StatusInvest.DriverInicializar(sPapel);
		 
		 if (driverOk1) { 
				String codigo = sPapel;
				String origem = "statusinvest";
				String preco = StatusInvest.Preco();
				String pvp = StatusInvest.PVP();
				String liquidezDiaria = StatusInvest.LiquidezDiaria();   
				String dy = StatusInvest.DY();
				String roe = StatusInvest.ROE();
				String div_ebitda = StatusInvest.Div_Ebitda();
				String ev_ebitda = StatusInvest.Ev_Ebitda();
				String pl = StatusInvest.PL();				
				String patrimonio_liq = StatusInvest.Patrimonio_Liq();
				String payout = "nulo";
				String vlrMercado = StatusInvest.VlrMercado();
					 
				inserirNoBanco(conn , codigo, origem, preco, pvp, liquidezDiaria, dy, roe, div_ebitda, ev_ebitda, pl, payout, patrimonio_liq,  vlrMercado);
				
				
	        }
	        
	 }
	 
 public static void Dadosinvestidor10(String sPapel) {
		 
		 Connection conn = ObterConexaoBanco();
		 
		 boolean driverOk1 = investidor10.DriverInicializar(sPapel);
	        
			
	        
	        if (driverOk1) { 
				String codigo = sPapel;
				String origem = "investidor10";
				String preco = investidor10.Preco().replace("R$","");
				String pvp = investidor10.PVP();
				String liquidezDiaria = investidor10.LiquidezDiaria();   
				String dy = investidor10.DY();
				String roe = investidor10.ROE();
				String div_ebitda = "nulo";
				String ev_ebitda = investidor10.Ev_Ebitda();
				String pl = investidor10.PL().replace("R$","");
				String payout = investidor10.PAYOUT();
				String patrimonio_liq = investidor10.Patrimonio_Liq().replace("R$","");;
				String vlrMercado = investidor10.VlrMercado().replace("R$","");;
					 
				inserirNoBanco(conn , codigo, origem, preco, pvp, liquidezDiaria, dy, roe, div_ebitda, ev_ebitda, pl, payout, patrimonio_liq, vlrMercado);
				
				
	        }
	        
	 }
 
 
public static void DadosFundamentus(String sPapel) {
	 
	 Connection conn = ObterConexaoBanco();
	 
	 boolean driverOk1 = Fundamentus.DriverInicializar(sPapel);
        
		
        
        if (driverOk1) { 
			String codigo = sPapel;
			String origem = "Fundamentus";
			String preco = Fundamentus.Preco().replace("R$","");
			String pvp = Fundamentus.PVP();
			String liquidezDiaria = Fundamentus.LiquidezDiaria();   
			String dy = Fundamentus.DY();
			String roe = Fundamentus.ROE();
			String div_ebitda = "-";
			String ev_ebitda = Fundamentus.Ev_Ebitda();
			String pl = Fundamentus.PL();
			String payout = "-";
			String patrimonio_liq = Fundamentus.Patrimonio_Liq();
			String vlrMercado = Fundamentus.VlrMercado();
				 
			inserirNoBanco(conn , codigo, origem, preco, pvp, liquidezDiaria, dy, roe, div_ebitda, ev_ebitda, pl, payout, patrimonio_liq, vlrMercado);
			
			
        }
        
 }
}

