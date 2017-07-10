package br.com.abl.venda;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class CapturaListener implements ServletContextListener {
	
	private ScheduledExecutorService captura1 = null;

	private ScheduledExecutorService captura2 = null;	
	
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		if ((captura1 == null) || (!captura1.isTerminated())) {
			System.out.println("Iniciando thread de captura 1");
		    captura1 = Executors.newSingleThreadScheduledExecutor();
		    captura1.scheduleAtFixedRate(new CapturaTask(), 0, 1, TimeUnit.MINUTES);
			System.out.println("Thread de captura 1 iniciada");
		}

		if ((captura2 == null) || (!captura2.isTerminated())) {
			System.out.println("Iniciando thread de captura 2");
		    captura2 = Executors.newSingleThreadScheduledExecutor();
		    captura2.scheduleAtFixedRate(new CapturaTask(), 0, 1, TimeUnit.MINUTES);
			System.out.println("Thread de captura 2 iniciada");
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		try {
			System.out.println("Scheduler shutting down successfully " + new Date());
			captura1.shutdown();
			captura2.shutdown();
		} catch (Exception ex) {
		}
 	}
}