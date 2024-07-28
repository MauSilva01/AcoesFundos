/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package principal;

import java.util.ArrayList;
import java.util.List;
import navegadores.SiteFundamentus;
import navegadores.SiteInvestidor10;
import navegadores.SiteStatusInvest;

/**
 *
 * @author Mauricio
 */
 
public class FundosAcoes implements Runnable {

    public static void main(String[] args) {
        SiteInvestidor10 siteinvestidor10 =new SiteInvestidor10();
    	SiteStatusInvest sitestatusinvest = new SiteStatusInvest();   
    	SiteFundamentus sitefundamentus = new SiteFundamentus();
    	
        List<String> papeis = new ArrayList<>();
        List<String> fundos = new ArrayList<>();
        
        System.out.println("Executando a classe principal... " + new java.util.Date());
        
        //Lista de papeis
        
        
        papeis.add("ABCB4");             
        //papeis.add("AERI3");  
        papeis.add("B3SA3");        
        papeis.add("BBDC3");
        papeis.add("BBSE3");
        papeis.add("BEES3");
        papeis.add("BMGB4");
        papeis.add("BRAP3");
        papeis.add("CIEL3");
        papeis.add("CMIG4");
        papeis.add("CSMG3");
        papeis.add("CXSE3");
        papeis.add("ITSA4");
        papeis.add("ITUB3");
        papeis.add("KLBN4");
        papeis.add("MGLU3");
        papeis.add("NGRD3");
        papeis.add("OIBR3");
        papeis.add("PETR4");
        papeis.add("PETR3");
        papeis.add("SANB4");
        papeis.add("SAPR4");
        papeis.add("TAEE4");
        papeis.add("TRPL4");    
        
        //LISTA DE FUNDOS 
        fundos.add("GARE11");        
        fundos.add("HOFC11");
        fundos.add("IRDM11");
        fundos.add("LIFE11");
        fundos.add("MXRF11");     
        fundos.add("OURE11");
        fundos.add("RECT11");  
        fundos.add("SEQR11");
            
        //fundos.add("TORD11");
        //fundos.add("VINO11");
        //fundos.add("VIUR11");
        //fundos.add("VSLH11"); 
      
        
      
        
      
        
        for (String papel : papeis) {        
            try{
               sitestatusinvest.InicializarCotacao(papel);
               Thread.sleep(1000);
               sitefundamentus.InicializarCotacao(papel);
               Thread.sleep(3000); 
               siteinvestidor10.InicializarCotacao(papel) ;
            }catch(InterruptedException e){
                System.out.println(e.toString());
            }
                  
        }
       
        for (String papel : fundos) {        
            try{
               sitestatusinvest.InicializarCotacao(papel, 1);
               Thread.sleep(3000);
               sitefundamentus.InicializarCotacao(papel, 1);
               Thread.sleep(3000); 
               siteinvestidor10.InicializarCotacao(papel, 1);
            }catch(Exception e){
                System.out.println(e.toString());
            }
                  
        }
 
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		 main(new String[0]);
		
	}
    
    
}

