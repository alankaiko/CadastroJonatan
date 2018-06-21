package br.com.gsv.relatorios;

import java.io.IOException;
import java.util.List;

import br.com.jonatan.domain.Cliente;
import br.com.jonatan.service.ClienteService;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;

public class RelatorioCliente extends AbstractRelatorios{
	private ClienteService controller;
	private List<Cliente> lista;
	private String tituloCliente= "Relatório Geral de Clientes";
	private PdfPCell celulaCodigo, celulaNome, celulaTelefone, celulaCelular, celulaCidade;
	private float [ ] colunaLargura = { 1.50f , 5.50f , 3, 4, 4 };
	

	public RelatorioCliente(){
		controller = new ClienteService();
		this.lista = controller.pegandoListaCompleta();		
	}
	
	
	@Override
	public void Iniciar() throws IOException, DocumentException {
		this.NomeArquivo("relClient");
		this.NomeColunas(tituloCliente);
		this.CriarTabela(colunaLargura);
		this.CriaTitulos();
		PopularTabela();
		this.CriaDocumento();		
	}
	
	
	@Override
	protected void CriaTitulos() {
		celulaCodigo = new PdfPCell(new Paragraph("CÓDIGO", fonteCabecalho));
		celulaCodigo.setBorder(PdfPCell.NO_BORDER);
		
		celulaNome = new PdfPCell(new Paragraph("NOME", fonteCabecalho));
		celulaNome.setBorder(PdfPCell.NO_BORDER);
		
		celulaTelefone = new PdfPCell(new Paragraph("TELEFONE", fonteCabecalho));
		celulaTelefone.setBorder(PdfPCell.NO_BORDER);
		
		celulaCelular = new PdfPCell(new Paragraph("CELULAR", fonteCabecalho));
		celulaCelular.setBorder(PdfPCell.NO_BORDER);
		
		celulaCidade = new PdfPCell(new Paragraph("CIDADE", fonteCabecalho));
		celulaCidade.setBorder(PdfPCell.NO_BORDER);
		
		PdfPCell espaco = new PdfPCell();
		espaco.setColspan(5);
		
		
		tabela.addCell(celulaCodigo);
		tabela.addCell(celulaNome);
		tabela.addCell(celulaTelefone);
		tabela.addCell(celulaCelular);
		tabela.addCell(celulaCidade);
		tabela.addCell(espaco);		
	}


	@Override
	protected void PopularTabela() {
		for(Cliente cliente : lista){
			celulaCodigo = new PdfPCell(new Paragraph(cliente.getId()+"", fonte));				
			celulaNome = new PdfPCell(new Paragraph(cliente.getNome(), fonte));
			celulaTelefone = new PdfPCell(new Paragraph(cliente.getContato().getFixo(), fonte));
			celulaCelular = new PdfPCell(new Paragraph(cliente.getContato().getCelular(), fonte));
			celulaCidade = new PdfPCell(new Paragraph(cliente.getEndereco().getCidade(), fonte));
		
			celulaCodigo.setHorizontalAlignment(Element.ALIGN_LEFT);
			celulaCodigo.setBorder(PdfPCell.NO_BORDER);
			celulaNome.setBorder(PdfPCell.NO_BORDER);
			celulaTelefone.setBorder(PdfPCell.NO_BORDER);
			celulaCelular.setBorder(PdfPCell.NO_BORDER);
			celulaCidade.setBorder(PdfPCell.NO_BORDER);
			
			this.tabela.addCell(celulaCodigo);
			this.tabela.addCell(celulaNome);
			this.tabela.addCell(celulaTelefone);
			this.tabela.addCell(celulaCelular);
			this.tabela.addCell(celulaCidade);
		}		
	}

	
}
