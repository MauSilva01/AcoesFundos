package FundosAcoes.FundosAcoesTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        WebDriver driver = new ChromeDriver();
        driver.get("https://statusinvest.com.br/acoes/petr3");
        
        
        WebElement e1 = driver.findElement(By.xpath("//div[@title='Valor atual do ativo']"));
        System.out.println(e1.findElement(By.className("value")).getText() );
        
  
        driver.quit();
    }
}
