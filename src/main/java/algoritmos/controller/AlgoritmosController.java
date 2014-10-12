package algoritmos.controller;

import algoritmos.model.AlgoritmosModel;
import algoritmos.view.AlgoritmosView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by pablo on 12/10/14.
 */
public class AlgoritmosController {
    private AlgoritmosView theView;
    private AlgoritmosModel theModel;

    public AlgoritmosController(AlgoritmosView theView, AlgoritmosModel theModel)
    {
        this.theView = theView;
        this.theModel = theModel;
        //Decirle a view que cuando el botón generar se presione
        //ejecute actionPerformed de Generar Listener
        this.theView.addGenerarListener(new GenerarListener());
    }
    class GenerarListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            int cantidad = 0;
            try {
                cantidad = theView.getCantidad();
                theModel.generarElementos(cantidad);
                theView.setGraph();
            } catch (NumberFormatException exception) {
                System.out.println(exception);
                theView.displayErrorMessage("Inserte un Integer");
            }
        }
    }

}
