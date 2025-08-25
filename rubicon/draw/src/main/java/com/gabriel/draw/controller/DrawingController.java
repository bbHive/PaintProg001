package com.gabriel.draw.controller;

import com.gabriel.draw.model.*;
import com.gabriel.drawfx.DrawMode;
import com.gabriel.drawfx.ShapeMode;
import com.gabriel.draw.view.DrawingView;
import com.gabriel.drawfx.service.AppService;
import com.gabriel.drawfx.model.Shape;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DrawingController  implements MouseListener, MouseMotionListener {
    private Point end;
    private final DrawingView drawingView;
    private Shape currentShape;
    private final AppService appService;

    public DrawingController(AppService appService, DrawingView drawingView){
         this.appService = appService;
         this.drawingView = drawingView;
         drawingView.addMouseListener(this);
         drawingView.addMouseMotionListener(this);
         appService.setDrawMode(DrawMode.Idle);
         appService.setShapeMode(ShapeMode.Rectangle);
     }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point start;
        if(appService.getDrawMode() == DrawMode.Idle) {
            start = e.getPoint();
            switch (appService.getShapeMode()) {
                case Line:
                    currentShape = new Line(start, start);
                    break;
                case Rectangle:
                    currentShape = new RectangleShape(start, start);
                    break;
                case Ellipse:
                    currentShape = new Ellipse(start, start);
                    break;
                default:
                    currentShape = null;
                    break;
            }
            if (currentShape != null) {
                currentShape.getRendererService().render(drawingView.getGraphics(), currentShape, false);
                appService.setDrawMode(DrawMode.MousePressed);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
         if(appService.getDrawMode() == DrawMode.MousePressed){
             if(appService.getShapeMode() != null) {
                 // Final render to ensure the shape is drawn correctly
                 end = e.getPoint();
                 // Clear the previous rendering
                 appService.create(currentShape);
                 // Final render
                 appService.setDrawMode(DrawMode.Idle);
             }
         }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(appService.getDrawMode() == DrawMode.MousePressed) {
            if (appService.getShapeMode() != null) {
                end = e.getPoint();
                currentShape.getRendererService().render(drawingView.getGraphics(), currentShape,true );
                appService.scale(currentShape,end);
                currentShape.getRendererService().render(drawingView.getGraphics(), currentShape,true );
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
