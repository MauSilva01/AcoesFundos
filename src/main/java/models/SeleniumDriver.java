/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Mauricio
 */
public class SeleniumDriver {
    
    private static WebDriver localDriver ;
    

    
    public static void DriverFinish() {

        try {
            localDriver.close();
        } catch (Exception e) {}
        
        try {
            localDriver.quit();
        } catch (Exception ex) {} 
        
        localDriver = null;
    }
    
    public static WebDriver DriverStart() {
        try {
              if (localDriver != null) 
                  return localDriver;
                
              localDriver = new ChromeDriver();
              localDriver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
              return localDriver;
                      
            } catch (Exception e) {
               System.out.println(e.toString()); 
               DriverFinish();
               return null;
            }
    }
           
    
}
