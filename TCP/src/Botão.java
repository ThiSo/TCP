import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Botão extends JButton implements ActionListener {

	private static final long serialVersionUID = 1L;


	JTextField caixaTexto;
	
	Botão(JTextField caixaTexto){
		
		//template comum dos botões
		this.caixaTexto = caixaTexto; 	//caixaTexto tem que ser re-instanciada para ser usada no actionListener
		this.setText("Tocar texto");
		this.setBounds(400,425,150,40);
		this.addActionListener(this);
		this.setFocusable(false);
		
	}
	
	//Ações a serem tomadas quando o botão é clicado
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==this) {
			System.out.println("Input: "+caixaTexto.getText());
			caixaTexto.setEditable(false);
			this.setEnabled(false);

			String textInput = caixaTexto.getText();

			Translator tradutor = new Translator();
			tradutor.translate(textInput);

		}

		caixaTexto.setEditable(true);
		this.setEnabled(true);

	}

}
