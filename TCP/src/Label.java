import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.Border;

public class Label extends JLabel{

	private static final long serialVersionUID = 1L;
	
	//construtor da label de texto
	Label(String texto){
		
		int x = 10;
		int y = 10;
		int width = 250;
		int height = 30;
		int fontSize = 20;
		Border border = BorderFactory.createLineBorder(Color.white, 1);
		
		this.setText(texto);
		this.setBorder(border);
		this.setBounds(x,y,width,height);
		this.setOpaque(false);
		this.setBackground(Color.black);
		this.setForeground(Color.black);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setVerticalAlignment(JLabel.TOP);
		this.setFont(new Font("Arial", Font.PLAIN, fontSize));
	}
	
	//Construtor da Label de glossário
	Label(){
		
		int x = 390;
		int y = 50;
		int width = 190;
		int height = 360;
		int fontSize = 13;
		Border border = BorderFactory.createLineBorder(Color.white, 1);
		
		this.setText("<html><br>"
					+ "Glossário de teclas:<br><br>"
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
		this.setBorder(border);
		this.setBounds(x,y,width,height);
		this.setOpaque(false);
		this.setBackground(Color.black);
		this.setForeground(Color.black);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setVerticalAlignment(JLabel.TOP);
		this.setFont(new Font("Arial", Font.PLAIN, fontSize));
	}
	
	//construtor da Label de imagem
	Label(ImageIcon imagem){
		int x = 435;
		int y = 460;
		int width = 100;
		int height = 100;
		
		this.setIcon(imagem);
		this.setBounds(x,y,width,height);
	}
}