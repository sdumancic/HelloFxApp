/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ensemble;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Sanjin
 */
public class StockLineChartApp extends Application {
    
    private LineChart<Number,Number> chart;
    private XYChart.Series<Number, Number> hourDataSeries;
    private XYChart.Series<Number, Number> minuteDataSeries;
    private NumberAxis xAxis;
    private double timeInHours = 0;
    private double prevY = 10;
    private double y = 10;
    private Timeline animation;
    private double hours = 0;
    private double minutes = 0;
    
    public StockLineChartApp(){
        animation = new Timeline();
        animation.getKeyFrames().add(new KeyFrame(Duration.millis(1000 / 60), (ActionEvent actionEvent) -> {
                    
            for (int count = 0; count < 6; count++) {
                nextTime();
                plotTime();
            }
        }));
        animation.setCycleCount(Animation.INDEFINITE);
    }
    
    @Override
    public void start(Stage primaryStage) {
       
        
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
        play();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private Parent createContent() {
        
        xAxis = new NumberAxis(0,24,3); // od 0 do 24, svakih 20 minuta
        final NumberAxis yAxis = new NumberAxis(0, 100, 10);
        chart = new LineChart<>(xAxis, yAxis);
        chart.getStylesheets().add(StockLineChartApp.class.getResource("StockLineChart.css").toExternalForm());
        chart.setCreateSymbols(false);
        chart.setAnimated(false);
        chart.setLegendVisible(false);
        chart.setTitle("ACME Company Stock");
        xAxis.setLabel("Time");
        xAxis.setForceZeroInRange(false);
        yAxis.setLabel("Share Price");
        yAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(yAxis, "$", null));
        hourDataSeries = new XYChart.Series<>();
        hourDataSeries.setName("Hourly Data");
        minuteDataSeries = new XYChart.Series<>();
        minuteDataSeries.setName("Minute Data");
        hourDataSeries.getData().add(new XYChart.Data<>(timeInHours, prevY));
        minuteDataSeries.getData().add(new XYChart.Data<>(timeInHours, prevY));
        chart.getData().add(minuteDataSeries);
        chart.getData().add(hourDataSeries);
        return chart;
    }
    
    private void plotTime() {
        if ((timeInHours % 1) == 0) {
            // change of hour
            double oldY = y;
            y = prevY - 10 + (Math.random() * 20);
            prevY = oldY;
            while (y < 10 || y > 90) {
                y = y - 10 + (Math.random() * 20);
            }
            hourDataSeries.getData().add(new XYChart.Data<Number, Number>(timeInHours, prevY));
            // after 25hours delete old data
            if (timeInHours > 25) {
                hourDataSeries.getData().remove(0);
            }
            // every hour after 24 move range 1 hour
            if (timeInHours > 24) {
                xAxis.setLowerBound(xAxis.getLowerBound() + 1);
                xAxis.setUpperBound(xAxis.getUpperBound() + 1);
            }
        }
        double min = (timeInHours % 1);
        double randomPickVariance = Math.random();
        if (randomPickVariance < 0.3) {
            double minY = prevY + ((y - prevY) * min) - 4 + (Math.random() * 8);
            minuteDataSeries.getData().add(new XYChart.Data<Number, Number>(timeInHours, minY));
        } else if (randomPickVariance < 0.7) {
            double minY = prevY + ((y - prevY) * min) - 6 + (Math.random() * 12);
            minuteDataSeries.getData().add(new XYChart.Data<Number, Number>(timeInHours, minY));
        } else if (randomPickVariance < 0.95) {
            double minY = prevY + ((y - prevY) * min) - 10 + (Math.random() * 20);
            minuteDataSeries.getData().add(new XYChart.Data<Number, Number>(timeInHours, minY));
        } else {
            double minY = prevY + ((y - prevY) * min) - 15 + (Math.random() * 30);
            minuteDataSeries.getData().add(new XYChart.Data<Number, Number>(timeInHours, minY));
        }
        // after 25hours delete old data
        if (timeInHours > 25) {
            minuteDataSeries.getData().remove(0);
        }
    }
    
    private void nextTime() {
        if (minutes == 59) {
            hours++;
            minutes = 0;
        } else {
            minutes++;
        }
        timeInHours = hours + ((1d / 60d) * minutes);
    }
    
    public void play() {
        animation.play();
    }
 
    @Override
    public void stop() {
        animation.pause();
    }
    
}
