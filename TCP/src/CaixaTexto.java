import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;

public class CaixaTexto extends JTextField{

	private static final long serialVersionUID = 1L;

	CaixaTexto(){
		
		//template da caixa de texto
		this.setBounds(10,50,250,400);
		this.setFont(new Font("Comic Sans", Font.BOLD, 30));
		this.setForeground(Color.green);
		this.setBackground(Color.black);
		this.setCaretColor(Color.white);
		this.setCaretPosition(JTextField.CENTER);	
	}
}
