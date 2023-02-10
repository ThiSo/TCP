import javax.swing.*;

public class Janela extends JFrame{

	private static final long serialVersionUID = 1L;
	
	Janela() {
		
		//características da janela principal
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setTitle("Tocador de Textos");
		this.setSize(500,550);
		this.setResizable(false);
			
		//estanciamento das componentes visuais e devidas correções
		Label labelTexto = new Label("Digite seu texto abaixo",10,10,250,30, 20);
			
		Label labelImagem = new Label("",350,455,50,50, 0);
		
		Label labelInstruc = new Label("",270, 50, 200, 400, 13);
		labelInstruc.setVerticalAlignment(JLabel.TOP);
		labelInstruc.setText("<html>Glossário de teclas:<br><br>"
							+ "+ = dobrar volume<br>"
							+ "- = dividir volume por 2<br>"
							+ "R+ = aumenta uma oitava<br>"
							+ "R- = diminui uma oitava<br>"
							+ "? = toca nota aleatória<br>"
							+ "NL = mudar instrumento<br>"
							+ "; = BPM aleatório<br>"
							+ "BPM+ = BPM aumenta 80<br>"
							+ "BACKSPACE = pause<br><br>"
							+ "Glossário de notas:<br><br>"
							+ "A/a = nota La<br>"
							+ "B/b = nota Si<br>"
							+ "C/c = nota Do<br>"
							+ "D/d = nota Re<br>"
							+ "E/e = nota Mi<br>"
							+ "F/f = nota Fa<br>"
							+ "G/g = nota Sol</html>");
		
		CaixaTexto caixaTexto = new CaixaTexto();
			
		Botão button = new Botão(caixaTexto);
		
		
		//Adição dos componentes visuais á janela
		this.add(labelImagem);
		this.add(labelTexto);
		this.add(labelInstruc);
		this.add(caixaTexto);
		this.add(button);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	

}