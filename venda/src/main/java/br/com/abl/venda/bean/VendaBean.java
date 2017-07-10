package br.com.abl.venda.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.abl.venda.persistence.Processamento;
import br.com.abl.venda.service.ProcessamentoService;

@ManagedBean
@ViewScoped
public class VendaBean {

	@ManagedProperty(value="#{processamentoServiceImpl}")
	private ProcessamentoService pService;

	private List<Processamento> processamentos;

	@PostConstruct
	public void init() {
		onSearch();
	}
	
	public void onSearch() {
		processamentos = pService.getProcessamentos();
	}

	public ProcessamentoService getpService() {
		return pService;
	}

	public void setpService(ProcessamentoService pService) {
		this.pService = pService;
	}

	public List<Processamento> getProcessamentos() {
		return processamentos;
	}

	public void setProcessamentos(List<Processamento> processamentos) {
		this.processamentos = processamentos;
	}
}
