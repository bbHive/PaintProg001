package com.gabriel.draw.view;

import com.gabriel.drawfx.ShapeMode;
import com.gabriel.drawfx.service.AppService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RibbonPanel extends JPanel {
    public RibbonPanel(AppService appService) {
        setLayout(new FlowLayout(FlowLayout.LEFT));

        // Shape selection
        ButtonGroup group = new ButtonGroup();
        JToggleButton lineBtn = new JToggleButton("Line");
        JToggleButton rectBtn = new JToggleButton("Rectangle");
        JToggleButton ellipseBtn = new JToggleButton("Ellipse");
        lineBtn.setSelected(appService.getShapeMode() == ShapeMode.Line);
        rectBtn.setSelected(appService.getShapeMode() == ShapeMode.Rectangle);
        ellipseBtn.setSelected(appService.getShapeMode() == ShapeMode.Ellipse);

        group.add(lineBtn);
        group.add(rectBtn);
        group.add(ellipseBtn);

        add(lineBtn);
        add(rectBtn);
        add(ellipseBtn);

        lineBtn.addActionListener(e -> appService.setShapeMode(ShapeMode.Line));
        rectBtn.addActionListener(e -> appService.setShapeMode(ShapeMode.Rectangle));
        ellipseBtn.addActionListener(e -> appService.setShapeMode(ShapeMode.Ellipse));

        // Line color picker
        JButton colorBtn = new JButton("Line Color");
        colorBtn.addActionListener((ActionEvent e) -> {
            Color c = JColorChooser.showDialog(this, "Choose Line Color", appService.getColor());
            if (c != null) appService.setColor(c);
        });
        add(colorBtn);

        // Fill color picker
        JButton fillBtn = new JButton("Fill Color");
        fillBtn.addActionListener((ActionEvent e) -> {
            Color c = JColorChooser.showDialog(this, "Choose Fill Color", appService.getFill());
            if (c != null) appService.setFill(c);
        });
        add(fillBtn);
    }
}