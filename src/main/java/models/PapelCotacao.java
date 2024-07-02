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
    public String FII_PatrimonioLiquido = "";
   
    public String formatarValorDB(String sValor) {
        // Se o valor da variavel for null
        if (sValor == null) {
            return "";
        }

        // Retira espaços em branco
        String sRetorno = sValor.trim();

        // Retira caracteres de percentual
        sRetorno = sRetorno.replace("%", "").trim();

        // Retira caracteres de pontuação
        sRetorno = sRetorno.replace("R$", "").trim();

        // Substitui vírgulas por pontos
        sRetorno = sRetorno.replace(",", ".").trim();

        // Tratamento para multiplicação
        sRetorno = processarMultiplicadores(sRetorno, "BILHÕES", 1000000000);
        sRetorno = processarMultiplicadores(sRetorno, "Bilhões", 1000000000);
        sRetorno = processarMultiplicadores(sRetorno, "BILHÃO", 1000000000);
        sRetorno = processarMultiplicadores(sRetorno, "Bilhão", 1000000000);
        sRetorno = processarMultiplicadores(sRetorno, "MILHÕES", 1000000);
        sRetorno = processarMultiplicadores(sRetorno, "Milhões", 1000000);
        sRetorno = processarMultiplicadores(sRetorno, "Milhão", 1000000);
        sRetorno = processarMultiplicadores(sRetorno, "MIL", 1000);
        sRetorno = processarMultiplicadores(sRetorno, "Mil", 1000);
        sRetorno = processarMultiplicadores(sRetorno, "M", 1000000);
        sRetorno = processarMultiplicadores(sRetorno, "K", 1000);

        // Ainda não é um valor válido
        if (sRetorno.equals("-") || sRetorno.equals("")) {
            sRetorno = "0";
        }

        // Formatação final para garantir que o valor seja um número válido
        try {
            Double.parseDouble(sRetorno);
        } catch (NumberFormatException e) {
            sRetorno = "0";
        }

        return sRetorno;
    }

    private String processarMultiplicadores(String valor, String unidade, double multiplicador) {
        if (valor.contains(unidade)) {
            valor = valor.replace(unidade, "").trim();
            try {
                Double v = Double.parseDouble(valor) * multiplicador;
                valor = String.format("%.0f", v);  // Formata para remover casas decimais
            } catch (NumberFormatException e) {
                valor = "0";  // Define como 0 em caso de erro
            }
        }
        return valor;
    }
    
}
        
