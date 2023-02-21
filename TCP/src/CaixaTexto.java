import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class CaixaTexto extends JTextArea{

	private static final long serialVersionUID = 1L;

	
	CaixaTexto(){
		
		//template da caixa de texto
		int x = 10;
		int y = 50;
		int width = 375;
		int height = 500;
		
		this.setBounds(x,y,width,height);
		this.setFont(new Font("FreeMono", Font.PLAIN, 20));
		this.setForeground(Color.white);
		this.setBackground(Color.black);
		this.setCaretColor(Color.white);
		this.setLineWrap(true);
		this.setWrapStyleWord(true);
		
	}
}
