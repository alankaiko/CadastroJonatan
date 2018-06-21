package br.com.jonatan.bean;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.itextpdf.text.DocumentException;

import br.com.gsv.relatorios.AbstractRelatorios;
import br.com.gsv.relatorios.RelatorioCliente;

@ManagedBean
@ViewScoped
public class RelatoriosBean {
	private AbstractRelatorios relatorios;
	private String tipoRelatorio;


	public void GerarRelatorio(){
		if(this.tipoRelatorio.equals("cliente")){
			GerarRelatorioCliente();
		}
	}
	
	private void GerarRelatorioCliente(){
		this.relatorios = new RelatorioCliente();
		
		try {
			this.relatorios.Iniciar();
		} catch (IOException | DocumentException e) {
			System.out.println("ERRO");
			e.printStackTrace();
		}
	}
	
	private void GerarRelatorioCidade(){
		
	}
	
	private void GerarRelatorioEstado(){
		
	}
	
	
	public String getTipoRelatorio() {
		return tipoRelatorio;
	}
	
	public void setTipoRelatorio(String tipoRelatorio) {
		this.tipoRelatorio = tipoRelatorio;
	}
	
}
