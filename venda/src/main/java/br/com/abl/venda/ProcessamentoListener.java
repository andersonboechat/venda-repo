package br.com.abl.venda;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ProcessamentoListener implements ServletContextListener {
	
	private ScheduledExecutorService processa = null;
	
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		if ((processa == null) || (!processa.isTerminated())) {
			System.out.println("Iniciando thread de processamento");
		    processa = Executors.newSingleThreadScheduledExecutor();
		    processa.scheduleAtFixedRate(new ProcessamentoTask(), 0, 1, TimeUnit.MINUTES);
			System.out.println("Thread de processamento iniciada");
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		try {
			System.out.println("Scheduler shutting down successfully " + new Date());
			processa.shutdown();
		} catch (Exception ex) {
		}
 	}
}