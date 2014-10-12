package algoritmos.view;

import java.awt.event.ActionListener;
import javax.swing.*;
import javax.media.jai.Histogram;

/**
 * Created by pablo on 12/10/14.
 */
public class AlgoritmosView extends JFrame {
    private JLabel cantidadLabel = new JLabel("Cantidad de Elementos : ");
    private JTextField cantidad = new JTextField(10);
    private JButton generarButton = new JButton("Generar");
    public AlgoritmosView()
    {
        JPanel mainPanel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 700);
        mainPanel.add(cantidadLabel);
        mainPanel.add(cantidad);
        mainPanel.add(generarButton);

        this.add(mainPanel);
    }
    public void addGenerarListener(ActionListener listenForResolverButton){
        generarButton.addActionListener(listenForResolverButton);
    }


    public void displayErrorMessage(String errorMessage){
        JOptionPane.showMessageDialog(this, errorMessage);
    }

    public int getCantidad() {
        return Integer.parseInt(cantidad.getText());
    }
}
