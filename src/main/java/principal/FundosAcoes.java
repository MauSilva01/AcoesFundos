/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package principal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import navegadores.SiteFundamentus;
import navegadores.SiteInvestidor10;
import navegadores.SiteStatusInvest;

/**
 *
 * @author Mauricio
 */
public class FundosAcoes {

    public static void main(String[] args) {
        
        SiteStatusInvest sitestatusinvest = new SiteStatusInvest();   
        SiteFundamentus sitefundamentus = new SiteFundamentus();
        SiteInvestidor10 siteinvestidor10 =new SiteInvestidor10();
        List<String> papeis = Arrays.asList("ABCB4");
        
        //Lista de papeis
        papeis.add("PETR3");
        papeis.add("PETR4");
        papeis.add("");
        
        
        for (String papel : papeis) {        
            try{
                sitestatusinvest.InicializarCotacao(papel);
                sitefundamentus.InicializarCotacao(papel);
                siteinvestidor10.InicializarCotacao(papel);
                   
            }catch(Exception e){
                System.out.println(e.toString());
            }
                  
        }
       
          
    
      
    }
}
