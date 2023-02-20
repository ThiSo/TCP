import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;


public class Janela extends JFrame{

	private static final long serialVersionUID = 1L;
	
	Janela() {
		int winWidth = 600;
		int winHeight = 600;
		int margin = 100;

		//características da janela principal
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setTitle("JMIDI");
		this.setSize(winWidth,winHeight);
		this.setResizable(false);
			
		//estanciamento das componentes visuais e devidas correções
		Label labelTexto = new Label("JMIDI - Texto para Sons",0,10,250,30, 20);

		Label labelInstruc = new Label("",385, 50, 200, 375, 13);
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

		ImageIcon imagem = new ImageIcon("inf.png");
		Label labelImagem = new Label("",winWidth-125, winWidth-125,100,100, 10);

		CaixaTexto caixaTexto = new CaixaTexto(10,50,375,500);
			
		Botão button = new Botão(caixaTexto);

		//Adição dos componentes visuais à janela
		this.add(labelImagem);
		this.add(labelTexto);
		this.add(labelInstruc);
		this.add(caixaTexto);
		this.add(button);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		labelImagem.setIcon(imagem);

	}
	

}