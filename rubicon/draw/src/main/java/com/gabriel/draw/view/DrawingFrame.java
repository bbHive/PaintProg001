package com.gabriel.draw.view;

import com.gabriel.draw.controller.*;
import com.gabriel.drawfx.model.Drawing;
import com.gabriel.drawfx.service.AppService;

import javax.swing.*;
import java.awt.*;

public class DrawingFrame extends JFrame {


    public DrawingFrame(AppService appService){
        DrawingWindowController drawingWindowController = new DrawingWindowController(appService);
        this.addWindowListener(drawingWindowController);
        this.addWindowFocusListener(drawingWindowController);
        this.addWindowStateListener(drawingWindowController);

        DrawingView drawingView = new DrawingView(appService);
        this.getContentPane().add(drawingView);

        RibbonPanel ribbon = new RibbonPanel(appService);
        this.add(ribbon, BorderLayout.NORTH);
    }
}
