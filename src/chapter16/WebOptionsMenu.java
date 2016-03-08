/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter16;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.web.WebView;

/**
 *
 * @author Sanjin
 */
public class WebOptionsMenu extends MenuButton {
    
    public WebOptionsMenu(WebView webView){
        this.setText("Options");
        CheckMenuItem ctxMenu = new CheckMenuItem("Enable context menu");
        ctxMenu.setSelected(true);
        webView.contextMenuEnabledProperty().bind(ctxMenu.selectedProperty());
        Menu scalingMenu = new Menu("Font Scale");
        scalingMenu.textProperty().bind(new SimpleStringProperty("Font scale").concat(webView.fontScaleProperty().multiply(100.0)).concat("%"));
        MenuItem normalFontMenu = new MenuItem("Normal");
        MenuItem biggerFontMenu = new MenuItem("10% bigger");
        MenuItem smallerFontMenu = new MenuItem("10% smaller");
        normalFontMenu.setOnAction(e->webView.setFontScale(1.0));
        biggerFontMenu.setOnAction(e->webView.setFontScale(webView.getFontScale() + 0.10));
        smallerFontMenu.setOnAction(e->webView.setFontScale(webView.getFontScale() - 0.10));
        scalingMenu.getItems().addAll(normalFontMenu,biggerFontMenu,smallerFontMenu);
        
        Menu smoothingMenu = new Menu("Font Smoothing");
        RadioMenuItem grayMenu = new RadioMenuItem("Gray");
        grayMenu.setSelected(true);
        RadioMenuItem lcdMenu = new RadioMenuItem("LCD");
        grayMenu.setOnAction(e->webView.setFontSmoothingType(FontSmoothingType.GRAY));
        lcdMenu.setOnAction(e->webView.setFontSmoothingType(FontSmoothingType.LCD));
        new ToggleGroup().getToggles().addAll(grayMenu, lcdMenu);
        smoothingMenu.getItems().addAll(grayMenu, lcdMenu);
        
        Menu zoomMenu = new Menu("Zoom");
        zoomMenu.textProperty().bind(new SimpleStringProperty("Zoom ").concat(webView.zoomProperty().multiply(100.0)).concat("%"));
        MenuItem normalZoomMenu = new MenuItem("Normal");
        MenuItem biggerZoomMenu = new MenuItem("10% Bigger");
        MenuItem smallerZoomMenu = new MenuItem("10% Smaller");
        normalZoomMenu.setOnAction(e->webView.setZoom(1.0));
        biggerZoomMenu.setOnAction(e->webView.setZoom(webView.getZoom()+0.10));
        smallerZoomMenu.setOnAction(e->webView.setZoom(webView.getZoom()-0.10));
        zoomMenu.getItems().addAll(normalZoomMenu,biggerZoomMenu,smallerZoomMenu);
        
        CheckMenuItem scriptMenu = new CheckMenuItem("Enable Javascript");
        scriptMenu.setSelected(true);
        webView.getEngine().javaScriptEnabledProperty().bind(scriptMenu.selectedProperty());
        
        this.getItems().addAll(ctxMenu, scalingMenu, smoothingMenu, zoomMenu, new SeparatorMenuItem(), scriptMenu);
                
        
        
    }
    
}
