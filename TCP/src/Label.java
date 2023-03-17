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
		Border border = BorderFactory.createLineBorder(Color.black, 2);
		
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
		Border border = BorderFactory.createLineBorder(Color.black, 2);
		
		this.setText("<html>"
					+ "Glossário de notas:<br><br>"
					+ "A = nota La<br>"
					+ "B = nota Si<br>"
					+ "C = nota Do<br>"
					+ "D = nota Re<br>"
					+ "E = nota Mi<br>"
					+ "F = nota Fa<br>"
					+ "G = nota Sol<br><br>"
					+ "Glossário de Instrumentos:<br><br>"
					+ "; = instrumento Pan Flute<br>"
					+ ", = instrumento Church Organ<br>"
					+ "NL = instrumento Tubular Bells<br><br>"
					+ "Outras opções:<br><br>"
					+ "?/. = aumenta oitava<br>"
					+ "consoantes/a/e = repete<br>"
					+ "&emsp;&emsp;&emsp;&ensp;&nbsp;nota ou silêncio<br>"
					+ "BACKSPACE = dobra volume</html>");
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