package principal;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AgendadorDeTarefas {
    public static void main(String[] args) {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime start = LocalTime.parse("09:00", formatter);
        LocalTime end = LocalTime.parse("17:00", formatter);

   //     ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        while (true) {
            LocalTime now = LocalTime.now();
            System.out.println("Verificando execucao: " + now +  " - Inicio: " + now.isBefore(start) + " - Fim:" +now.isAfter(end));
            
            if (now.isBefore(start) || now.isAfter(end)) {
                System.out.println("Fora do horário de execução. Aguardando...");
                try {
                    Thread.sleep(TimeUnit.MINUTES.toMillis(30));
                    continue;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Aplicação - Iniciando coleta de dados...");
            FundosAcoes fundosAcoes = new FundosAcoes();
            fundosAcoes.run();
            // Agenda a tarefa para executar inicialmente após 0 segundos e depois a cada 2 minutos
            //scheduler.scheduleAtFixedRate(fundosAcoes, 0, 1, TimeUnit.HOURS);

            // Aguarda até o horário final
            try {
                Thread.sleep(TimeUnit.MINUTES.toMillis(30));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
   }
}
