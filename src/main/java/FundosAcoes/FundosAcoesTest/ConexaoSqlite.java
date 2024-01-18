package FundosAcoes.FundosAcoesTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoSqlite {

	public static void main(String[] args) {
		
		
	 }
	
	public static void adicionarDados() {
		Connection conn = ObterConexaoBanco();
		
		boolean driverOk = StatusInvest.DriverInicializar();
        System.out.println("Statuinvest - Inicializando driver: " + driverOk);
			
        if (driverOk) { 
		String codigo = StatusInvest.Codigo();
		System.out.println("Preco Encontrado: " + StatusInvest.Codigo());
		String preco = StatusInvest.Preco();
		String pvp = StatusInvest.PVP();
		String liquidezDiaria = StatusInvest.LiquidezDiaria();   
		String dy = StatusInvest.DY();
		String roe = StatusInvest.ROE();
		String div_ebitda = StatusInvest.Div_Ebitda();
		String ev_ebitda = StatusInvest.Ev_Ebitda();
		String pl = StatusInvest.PL();
		String patrimonio_liq = StatusInvest.Patrimonio_Liq();
		String vlrMercado = StatusInvest.VlrMercado();
			 
		inserirNoBanco(conn , codigo,  preco, pvp, liquidezDiaria, dy, roe, div_ebitda, ev_ebitda, pl, patrimonio_liq, vlrMercado);
		
		System.out.println("Statuinvest - Encerrando driver: " + StatusInvest.DriverEncerrar());
        }
	}
	 
	 
	 public static Connection ObterConexaoBanco() {
		 Connection conn = null;
		    try {
		      // Cria a conexão com o banco de dados
		      conn = DriverManager.getConnection("jdbc:sqlite:C:/PROGRAMAS/fundosAcoes/fundosAcoes1/Cotacoes.db");
		      
		      System.out.println("Conexão com o banco de dados SQL Server estabelecida com sucesso!");
		  
		    } catch(SQLException e) {
		      System.err.println(e.getMessage());
		      System.out.println("Erro ao estabelecer conexão com o banco de dados Access: " + e.toString());
		    }
			return conn;
	 }
	 
	 private static void inserirNoBanco(Connection conn, String codigo, String preco, String pvp, String liquidezDiaria, String dy, String roe, String div_ebitda, String ev_ebitda, String pl, String patrimonio_liq, String vlrMercado) {
	        try {
     
	            String query = "INSERT INTO Cotacoes_acoes (DATA, CODIGO, PRECO, P_VP, LIQUIDEZ_DIARIA, DY_MED_PERC, ROE, DIV_EBITIDA, EV_EBITIDA, PATRIMONIO_LUCRO, PL, VALOR_MERCADO) VALUES ( DATETIME('now' , 'localtime'),?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	            PreparedStatement preparedStatement = conn.prepareStatement(query);
	            preparedStatement.setString(1, codigo);
	            preparedStatement.setString(2, preco);
	            preparedStatement.setString(3, pvp);
	            preparedStatement.setString(4, liquidezDiaria);
	            preparedStatement.setString(5, dy);
	            preparedStatement.setString(6, roe);
	            preparedStatement.setString(7, div_ebitda);
	            preparedStatement.setString(8, ev_ebitda);
	            preparedStatement.setString(9, pl);
	            preparedStatement.setString(10, patrimonio_liq);
	            preparedStatement.setString(11, vlrMercado);
	            
	            // Adicione os demais campos e valores...

	            preparedStatement.executeUpdate();
	        
	            System.out.println("Dados inseridos com Sucesso!!");
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("Erro ao tentar Inserir dados ");
	        }
	    }
}

