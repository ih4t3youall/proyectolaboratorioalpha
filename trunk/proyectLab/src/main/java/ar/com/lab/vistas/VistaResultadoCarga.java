package ar.com.lab.vistas;

import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ar.com.lab.listeners.ListenerGenerico;
import ar.com.objetos.ResultadoCarga;

public class VistaResultadoCarga extends JFrame {
	private static final long serialVersionUID = 1L;
	Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
	JTextField textfield = new JTextField("", 30);
	JButton portaPapeles = new JButton("Copiar portapapeles");
	JButton aceptar = new JButton("Aceptar");
	StringSelection aCopiar;
	JTextArea texto;

	public VistaResultadoCarga(ResultadoCarga resultado) {

		aceptar = new JButton("Aceptar");
		texto = new JTextArea(10, 45);

		setLayout(new FlowLayout());

		JScrollPane sbrText = new JScrollPane(texto);
		sbrText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sbrText.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		add(sbrText);
		add(aceptar);
		add(portaPapeles);
		texto.setText(resultado.getText());
		aCopiar = new StringSelection(texto.getText());
		aceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				dispose();

			}
		});

		setResizable(false);
		setLocation(200, 200);
		setSize(561, 245);
		setVisible(true);

		portaPapeles.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				cb.setContents(aCopiar, null);

			}
		});

	}

}
