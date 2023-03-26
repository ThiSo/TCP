package Main;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

/* Classe responsável por criar a caixa de texto onde
 * deve ser digitado/carregado o texto do usuário */

public class TextBox extends JTextArea{

	private static final long serialVersionUID = 1L;

	/* Construtor da caixa de texto, com constantes para
	 * definição de seu tamanho e posição na interface*/
	
	TextBox(){
		
		//template da caixa de texto
		final int boxPosX = 10;
		final int boxPosY = 50;
		final int boxWidth = 375;
		final int boxHeight = 500;
		
		this.setBounds(boxPosX, boxPosY, boxWidth, boxHeight);
		this.setFont(new Font("FreeMono", Font.PLAIN, 20));
		this.setForeground(Color.white);
		this.setBackground(Color.black);
		this.setCaretColor(Color.white);
		this.setLineWrap(true);
		this.setWrapStyleWord(true);
		
	}
}
