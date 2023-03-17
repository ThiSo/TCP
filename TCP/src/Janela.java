import javax.swing.*;


public class Janela extends JFrame{

	private static final long serialVersionUID = 1L;
	
	Janela() {
		int winWidth = 600;
		int winHeight = 620;
		//int margin = 100;

		//características da janela principal
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setTitle("JMIDI");
		this.setSize(winWidth,winHeight);
		this.setResizable(false);
			
		//estanciamento das componentes visuais
		//labels
		Label labelTexto = new Label("JMIDI - Texto para Sons");
		Label labelInstruc = new Label();

		ImageIcon imagem = new ImageIcon("inf.png");
		Label labelImagem = new Label(imagem);
		
		//campo de texto
		CaixaTexto caixaTexto = new CaixaTexto();
		
		//botão
		Botão button = new Botão(caixaTexto);
		
		//barra lateral e correções
		JScrollPane barraLateral = new JScrollPane(caixaTexto);
		barraLateral.setBounds(caixaTexto.getBounds());
		barraLateral.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		Arquivo barraArquivos = new Arquivo(caixaTexto);
		
		//Adição dos componentes visuais à janela
		
		this.setJMenuBar(barraArquivos);
		this.add(labelImagem);
		this.add(labelTexto);
		this.add(labelInstruc);
		this.add(button);
		this.add(barraLateral);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}
	

}