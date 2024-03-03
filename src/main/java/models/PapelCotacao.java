/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Mauricio
 */
public class PapelCotacao {
    
    
    public String Codigo = "";
    public String DividaSobreEbitda= "";    
    public String DividendYield= "";
    public String EvaluationSobreEbitda= "";    
    public String LiquidezDiaria= "";
    public String PatrimonioLiquido= "";    
    public String PatriminoSobreLucro= "";
    public String Payout= "";
    public String Preco= "";
    public String PVP= "";
    public String ROE= "";
    public String SiteOrigem= "";
    public String ValorMercado= "";
    
    //Especifico de Fundos de Investimentos
    public String FII_QuantidadeImoveis = "";
    public String FII_Vacancia = "";
    
    
 
    
    public String formatarValorDB(String sValor) {
        
        //Se o valor da variavel for null
        if (sValor == null)
            return "";

        //Retira espacos em branco
        String sRetorno = sValor.trim();
        
        //retira caracteres de percentual
        sRetorno = sRetorno.replace("%", "").trim();
        
        //retira caracteres pontuacao
        sRetorno = sRetorno.replace(".", "").trim();

        //retira caracteres pontuacao
        sRetorno = sRetorno.replace("R$", "").trim();

        //retira caracteres pontuacao
        sRetorno = sRetorno.replace(",", ".").trim();        
        
        if (sRetorno.contains("Milhões")) {
            sRetorno = sRetorno.replace("Milhões", "").trim();
            Double v = Double.parseDouble(sRetorno) * 1000000;
            sRetorno = String.format("%f", v);
        }

        if (sRetorno.contains("Bilhões")) {
            sRetorno = sRetorno.replace("Bilhões", "").trim();
            Double v = Double.parseDouble(sRetorno) * 1000000000;
            sRetorno = String.format("%f", v);
        }

        //retira caracteres pontuacao
        sRetorno = sRetorno.replace(",", ".").trim();
        
        
        //Ainda nao eh um valor valido
        if (sRetorno.equals("-") || sRetorno.equals(""))
            sRetorno = "";
        
        return sRetorno;
    }
}
        
