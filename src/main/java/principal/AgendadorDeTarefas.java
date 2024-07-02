package principal;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AgendadorDeTarefas {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        FundosAcoes FundosAcoes = new FundosAcoes();

        // Agenda a tarefa para executar inicialmente após 0 segundos e depois a cada 1 hora (3600 segundos)
        scheduler.scheduleAtFixedRate(FundosAcoes, 0, 1, TimeUnit.HOURS);
    }
}