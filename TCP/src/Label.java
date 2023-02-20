import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.Border;

public class Label extends JLabel{

	private static final long serialVersionUID = 1L;
	
	//construtor da label, com parâmetros variáveis
	Label(String texto, int x, int y, int width, int height,int fontSize){
		
		Border border = BorderFactory.createLineBorder(Color.white, 1);
		
		//template comum de todas as labels
		this.setText(texto);
		this.setBorder(border);
		this.setBounds(x,y,width,height);
		this.setOpaque(false);
		this.setBackground(Color.black);
		this.setForeground(Color.black);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setFont(new Font("Arial", Font.PLAIN, fontSize));
	}
}