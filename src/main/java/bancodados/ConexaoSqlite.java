/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bancodados;

import java.math.BigDecimal;
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
   public static Connection ObterConexaoBanco() {
        String url = "jdbc:mysql://177.153.63.26:3306/mercadofinanc";
        String nome = "mercadofinanc";
        String senha = "M@202406#01b";
        Connection conn = null;
        try {
            // Explicitly load the MySQL JDBC driver (optional with JDBC 4.0 and later)
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(url, nome, senha);
            System.out.println("Conexão com o banco de dados MySQL estabelecida com sucesso!");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC MySQL não encontrado: " + e.toString());
        } catch (SQLException e) {
            System.out.println("Erro ao estabelecer conexão com o banco de dados MySQL: " + e.toString());
        }
        return conn;
    }
   

    private static void inserirNoBanco( String codigo, String origem,  String preco, String pvp, String liquidezDiaria, String dy, String roe, String div_ebitda, String ev_ebitda, String pl, String payout,String patrimonio_liq, String vlrMercado, String FII_QuantidadeImoveis , String FII_Vacancia) {
        try {
            
            Connection conn = ConexaoSqlite.ObterConexaoBanco();

            String query = "INSERT INTO Cotacoes_acoes (DATA, CODIGO, ORIGEM, PRECO, P_VP, LIQUIDEZ_DIARIA, DY_MED_PERC, ROE, DIV_EBITIDA, EV_EBITIDA, PATRIMONIO_LUCRO, PL, PAYOUT, VALOR_MERCADO, FII_QTDE_IMOVEIS, FII_VACANCIA) "
                             + "VALUES (NOW(), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
              preparedStatement.setString(1, codigo);
              preparedStatement.setString(2, origem);
              preparedStatement.setBigDecimal(3, preco.isEmpty() ? null : new BigDecimal(preco));
              preparedStatement.setBigDecimal(4, pvp.isEmpty() ? null : new BigDecimal(pvp));
              preparedStatement.setBigDecimal(5, liquidezDiaria.isEmpty() ? null : new BigDecimal(liquidezDiaria));
              preparedStatement.setBigDecimal(6, liquidezDiaria.isEmpty() ? null : new BigDecimal(dy));
              preparedStatement.setBigDecimal(7, roe.isEmpty() ? null : new BigDecimal(roe));
              preparedStatement.setBigDecimal(8, div_ebitda.isEmpty() ? null : new BigDecimal(div_ebitda));
              preparedStatement.setBigDecimal(9, ev_ebitda.isEmpty() ? null : new BigDecimal(ev_ebitda));
              preparedStatement.setBigDecimal(10, pl.isEmpty() ? null : new BigDecimal(pl));
              preparedStatement.setBigDecimal(11, patrimonio_liq.isEmpty() ? null : new BigDecimal(patrimonio_liq));
              preparedStatement.setBigDecimal(12, payout.isEmpty() ? null : new BigDecimal(payout));
              preparedStatement.setBigDecimal(13, vlrMercado.isEmpty() ? null : new BigDecimal(vlrMercado));
              preparedStatement.setBigDecimal(14, FII_QuantidadeImoveis.isEmpty() ? null : new BigDecimal(FII_QuantidadeImoveis));
              preparedStatement.setBigDecimal(15, FII_Vacancia.isEmpty() ? null : new BigDecimal(FII_Vacancia));
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
        papel.ValorMercado,
        papel.FII_QuantidadeImoveis,
        papel.FII_Vacancia
        );
     }
    
}
