package algoritmos.view;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.event.ActionListener;
import javax.swing.*;
import javax.media.jai.Histogram;

/**
 * Created by pablo on 12/10/14.
 */
public class AlgoritmosView extends JFrame {
    private JPanel mainPanel;
    private ChartPanel chartPanel ;
    private JLabel cantidadLabel = new JLabel("Cantidad de Elementos : ");
    private JTextField cantidad = new JTextField(10);
    private JButton generarButton = new JButton("Generar");

    int[] bins = {256, 256, 256};             // The number of bins.
    double[] low = {0.0D, 0.0D, 0.0D};        // The low value.
    double[] high = {256.0D, 256.0D, 256.0D}; // The high value.

    public AlgoritmosView()
    {

        mainPanel = new JPanel();
        chartPanel = new ChartPanel(null);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 560));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 700);
        mainPanel.add(cantidadLabel);
        mainPanel.add(cantidad);
        mainPanel.add(generarButton);
        mainPanel.add(chartPanel);
        this.add(mainPanel);
    }
    public void addGenerarListener(ActionListener listenForResolverButton){
        generarButton.addActionListener(listenForResolverButton);
    }


    public void setGraph()
    {
        Histogram histogram = new Histogram(bins,low,high);
        XYSeriesCollection data = createDataSet(histogram);
        JFreeChart chart = createChart(data);
        chartPanel.setChart(chart);


    }

    private XYSeriesCollection createDataSet(Histogram histogram) {
        final XYSeries series = new XYSeries("a");
        final XYSeries series1 = new XYSeries("b");
        final XYSeries series2 = new XYSeries("c");
        // Print 3-band histogram.
        for (int i = 0; i < histogram.getNumBins(0)-1; i++) {
            series.add(i,histogram.getBinSize(0,i));
            series1.add(i,histogram.getBinSize(1,i));
            series2.add(i,histogram.getBinSize(2,i));
        }
        XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
        xySeriesCollection.addSeries(series);
        xySeriesCollection.addSeries(series1);
        xySeriesCollection.addSeries(series2);
        return xySeriesCollection;
    }


    private JFreeChart createChart(XYSeriesCollection data) {
        return ChartFactory.createXYLineChart(
                "Quicksort",
                "Tiempo Busqueda",
                "Elementos",
                data,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);
    }

    public void displayErrorMessage(String errorMessage){
        JOptionPane.showMessageDialog(this, errorMessage);
    }

    public int getCantidad() {
        return Integer.parseInt(cantidad.getText());
    }}
