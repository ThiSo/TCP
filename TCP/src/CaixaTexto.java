import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;

public class CaixaTexto extends JTextField{

	private static final long serialVersionUID = 1L;

	CaixaTexto(int x, int y, int w, int h){
		
		//template da caixa de texto
		this.setBounds(x,y,w,h);
		this.setFont(new Font("FreeMono", Font.PLAIN, 20));
		this.setForeground(Color.white);
		this.setBackground(Color.black);
		this.setCaretColor(Color.white);
		this.setCaretPosition(JTextField.CENTER);

	}
}
