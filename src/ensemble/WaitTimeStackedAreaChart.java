/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ensemble;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Sanjin
 */
public class WaitTimeStackedAreaChart extends Application {
    
    private NumberAxis xAxis;
    private NumberAxis yAxis;
    private StackedAreaChart chart;
    private final Timeline animation;
    private int seconds = 0;
    
    private XYChart.Series<Number, Number> cpuDataSeries;
    private XYChart.Series<Number, Number> schedulerDataSeries;
    private XYChart.Series<Number, Number> userIODataSeries;
    private XYChart.Series<Number, Number> systemIODataSeries;
    private XYChart.Series<Number, Number> concurrencyDataSeries;
    
    private XYChart.Series<Number, Number> applicationDataSeries;
    private XYChart.Series<Number, Number> commitDataSeries;
    private XYChart.Series<Number, Number> configurationDataSeries;
    private XYChart.Series<Number, Number> administrativeDataSeries;
    private XYChart.Series<Number, Number> networkDataSeries;
    private XYChart.Series<Number, Number> queueingDataSeries;
    private XYChart.Series<Number, Number> otherDataSeries;
    
    private XYChart.Data cpuData;
    private XYChart.Data schedulerData;
    private XYChart.Data userIOData;
    private XYChart.Data systemIOData;
    private XYChart.Data concurrencyData;
    
    private XYChart.Data applicationData;
    private XYChart.Data commitData;
    private XYChart.Data configurationData;
    private XYChart.Data administrativeData;
    private XYChart.Data networkData;
    private XYChart.Data queueingData;
    private XYChart.Data otherData;

    private Task task;
    private ScheduledExecutorService scheduler;
    
    private enum WaitClass{
        ON_CPU          (0,"Green"),
        SCHEDULER       (1,"Light Green"),
        USER_IO         (2,"Blue"),
        SYSTEM_IO       (3,"Cyan"),
        CONCURRENCY     (4,"Dark Red"),
        APPLICATION     (5,"Red"),
        COMMIT          (6,"Orange"),
        CONFIGURATION   (7,"BROWN"),
        ADMINISTRATIVE  (8,"Light Brown"),
        NETWORK         (9,"Gray Brown"),
        QUEUEING        (10,"Light Gray Brown"),
        OTHER           (11,"Pink");
        
        private final Integer waitClassId;
        private final String waitClassColor;
        
        private WaitClass(Integer waitClassId, String waitClassColor) {
            this.waitClassId = waitClassId;
            this.waitClassColor = waitClassColor;
        }
        
        public Integer getWaitClassId() {
            return waitClassId;
        }
 
        public String getWaitClassColor() {
            return waitClassColor;
        }
        
    }
    
    public WaitTimeStackedAreaChart(){
            
        animation = new Timeline();
        animation.getKeyFrames().add(new KeyFrame(Duration.millis(1000), (ActionEvent actionEvent) -> {
             nextTime();
             plotTime();      
        }));
        animation.setCycleCount(Animation.INDEFINITE);
    }

    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
        play();
        
        /*
            DRUGI NAČIN
        */
        task = new Task<Void>() {
            
            int counter = 0;
            @Override
            public void run() {
                counter++;
                Platform.runLater(new Runnable(){
                    @Override
                    public void run() {
                        System.out.println("isFxApplicationThread: "  + Platform.isFxApplicationThread() + "\n"  + "Counting: "  + String.valueOf(counter));
                    }
                });
            }

            @Override
            protected Void call() throws Exception {
                return null;
            }
        };
        
        scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleWithFixedDelay(task, 1, 1, TimeUnit.SECONDS);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private Parent createContent() {
        
        xAxis = new NumberAxis("X values",0.0d,15.0,1.0);
        yAxis = new NumberAxis(0, 10, 1);
        
        cpuData = new StackedAreaChart.Data(0,0);
        schedulerData = new StackedAreaChart.Data(0,0);
        userIOData = new StackedAreaChart.Data(0,0);
        systemIOData = new StackedAreaChart.Data(0,0);
        concurrencyData = new StackedAreaChart.Data(0,0);
        applicationData = new StackedAreaChart.Data(0,0);
        commitData = new StackedAreaChart.Data(0,0);
        configurationData = new StackedAreaChart.Data(0,0);
        administrativeData = new StackedAreaChart.Data(0,0);
        networkData = new StackedAreaChart.Data(0,0);
        queueingData = new StackedAreaChart.Data(0,0);
        otherData = new StackedAreaChart.Data(0,0);

        cpuDataSeries = new XYChart.Series<>();
        cpuDataSeries.setName("CPU");
        cpuDataSeries.getData().add(cpuData);
        
        schedulerDataSeries = new XYChart.Series<>();
        schedulerDataSeries.setName("Scheduler");
        schedulerDataSeries.getData().add(schedulerData);
        
        
        userIODataSeries = new XYChart.Series<>();
        userIODataSeries.setName("UserIO");
        userIODataSeries.getData().add(userIOData);
        
        systemIODataSeries = new XYChart.Series<>();
        systemIODataSeries.setName("SystemIO");
        systemIODataSeries.getData().add(systemIOData);
        
        concurrencyDataSeries = new XYChart.Series<>();
        concurrencyDataSeries.setName("Concurrency");
        concurrencyDataSeries.getData().add(concurrencyData);
        
        applicationDataSeries = new XYChart.Series<>();
        applicationDataSeries.setName("Application");
        applicationDataSeries.getData().add(applicationData);
        
        commitDataSeries = new XYChart.Series<>();
        commitDataSeries.setName("Commit");
        commitDataSeries.getData().add(commitData);
        
        configurationDataSeries = new XYChart.Series<>();
        configurationDataSeries.setName("Configuration");
        configurationDataSeries.getData().add(configurationData);
        
        administrativeDataSeries = new XYChart.Series<>();
        administrativeDataSeries.setName("Administrative");
        administrativeDataSeries.getData().add(administrativeData);
        
        networkDataSeries = new XYChart.Series<>();
        networkDataSeries.setName("Network");
        networkDataSeries.getData().add(networkData);
        
        queueingDataSeries = new XYChart.Series<>();
        queueingDataSeries.setName("Queueing");
        queueingDataSeries.getData().add(queueingData);
        
        otherDataSeries = new XYChart.Series<>();
        otherDataSeries.setName("Other");
        otherDataSeries.getData().add(otherData);
        
        chart = new StackedAreaChart(xAxis, yAxis);
        chart.setId("chart");
        chart.getStylesheets().add(WaitTimeStackedAreaChart.class.getResource("WaitTimeStackedAreaChart.css").toExternalForm());
        
        chart.getData().add(cpuDataSeries);
        chart.getData().add(schedulerDataSeries);
        chart.getData().add(userIODataSeries);
        chart.getData().add(systemIODataSeries);
        chart.getData().add(concurrencyDataSeries);
        
        chart.getData().add(applicationDataSeries);
        chart.getData().add(commitDataSeries);
        chart.getData().add(configurationDataSeries);
        chart.getData().add(administrativeDataSeries);
        chart.getData().add(networkDataSeries);
        chart.getData().add(queueingDataSeries);
        chart.getData().add(otherDataSeries);

        chart.setCreateSymbols(false);
        chart.setAnimated(false);
        chart.setLegendVisible(true);
        chart.setTitle("Wait times");
        xAxis.setLabel("Time");
        xAxis.setForceZeroInRange(false);
        yAxis.setLabel("Avg sessions");
        
        return chart;        
        
       /* chart.getStylesheets().add(StockLineChartApp.class.getResource("StockLineChart.css").toExternalForm());*/
       
    }
 
    private void plotTime() {
        cpuData         = new StackedAreaChart.Data(seconds,Math.random());
        schedulerData   = new StackedAreaChart.Data(seconds,Math.random());
        userIOData      = new StackedAreaChart.Data(seconds,Math.random());
        systemIOData    = new StackedAreaChart.Data(seconds,Math.random());
        concurrencyData = new StackedAreaChart.Data(seconds,Math.random());
        applicationData = new StackedAreaChart.Data(seconds,Math.random());
        commitData = new StackedAreaChart.Data(seconds,Math.random());
        configurationData = new StackedAreaChart.Data(seconds,Math.random());
        administrativeData = new StackedAreaChart.Data(seconds,Math.random());
        networkData = new StackedAreaChart.Data(seconds,Math.random());
        queueingData = new StackedAreaChart.Data(seconds,Math.random());
        otherData = new StackedAreaChart.Data(seconds,Math.random());
        
        cpuDataSeries.getData().add(cpuData);
        schedulerDataSeries.getData().add(schedulerData);
        userIODataSeries.getData().add(userIOData);
        systemIODataSeries.getData().add(systemIOData);
        concurrencyDataSeries.getData().add(concurrencyData);
        
        applicationDataSeries.getData().add(applicationData);
        commitDataSeries.getData().add(commitData);
        configurationDataSeries.getData().add(configurationData);
        administrativeDataSeries.getData().add(administrativeData);
        networkDataSeries.getData().add(networkData);
        queueingDataSeries.getData().add(queueingData);
        otherDataSeries.getData().add(otherData);
        
        if (seconds > 15) {
            
            cpuDataSeries.getData().remove(0);
            schedulerDataSeries.getData().remove(0);
            userIODataSeries.getData().remove(0);
            systemIODataSeries.getData().remove(0);
            concurrencyDataSeries.getData().remove(0);
            
            applicationDataSeries.getData().remove(0);
            commitDataSeries.getData().remove(0);
            configurationDataSeries.getData().remove(0);
            administrativeDataSeries.getData().remove(0);
            networkDataSeries.getData().remove(0);
            queueingDataSeries.getData().remove(0);
            otherDataSeries.getData().remove(0);
            
            xAxis.setLowerBound(xAxis.getLowerBound() + 1);
            xAxis.setUpperBound(xAxis.getUpperBound() + 1);
        }
        
    }
    
    private void nextTime() {
        seconds++;
    }
    
     public void play() {
        animation.play();
    }
 
    @Override
    public void stop() {
        animation.pause();
        scheduler.shutdown();
        
    }
    
}
