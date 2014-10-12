package algoritmos;

import algoritmos.controller.AlgoritmosController;
import algoritmos.model.AlgoritmosModel;
import algoritmos.view.AlgoritmosView;

/**
 * Created by pablo on 12/10/14.
 */
public class App {
    public static void main(String[] args) {
        AlgoritmosView myView = new AlgoritmosView();
        AlgoritmosModel myModel = new AlgoritmosModel();
        AlgoritmosController myController = new AlgoritmosController(myView, myModel);

        myView.setVisible(true);
    }
}
