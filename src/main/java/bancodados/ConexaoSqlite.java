/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bancodados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.PapelCotacao;

/**
 *
 * @author Mauricio
 */
public class ConexaoSqlite {
	
	
	 private static Connection ObterConexaoBanco() {
		 Connection conn = null;
		    try {
		      // Cria a conexão com o banco de dados
		      conn = DriverManager.getConnection("jdbc:sqlite:C:\\PROGRAMAS\\BancoDados\\Cotacoes.db");
		      
		      System.out.println("Conexão com o banco de dados SQL Server estabelecida com sucesso!");
		  
		    } catch(SQLException e) {
		      System.err.println(e.getMessage());
		      System.out.println("Erro ao estabelecer conexão com o banco de dados Access: " + e.toString());
		    }
			return conn;
	 }
	 
	 private static void inserirNoBanco( String codigo, String origem,  String preco, String pvp, String liquidezDiaria, String dy, String roe, String div_ebitda, String ev_ebitda, String pl, String payout,String patrimonio_liq, String vlrMercado) {
	        try {
     
	        	Connection conn = ConexaoSqlite.ObterConexaoBanco();
	        	
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
	            
	            
	        } catch (SQLException e) {
	            System.out.println("Erro ao tentar Inserir dados " + e.toString());
	        }
	    }
	 
	 public static void SalvarPapelCotacao(PapelCotacao papel) {
		 
	 ConexaoSqlite.inserirNoBanco(
		papel.Codigo,
		papel.SiteOrigem,
		papel.Preco,
		papel.PVP,
		papel.LiquidezDiaria,
		papel.DividendYield,
		papel.ROE,
		papel.DividaSobreEbitda,
		papel.EvaluationSobreEbitda,
		papel.PatriminoSobreLucro,
		papel.Payout,
		papel.PatrimonioLiquido,
		papel.ValorMercado);
 
	 }
}
