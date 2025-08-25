package com.gabriel.draw.service;

import com.gabriel.draw.model.RectangleShape;
import com.gabriel.drawfx.service.RendererService;
import com.gabriel.drawfx.model.Shape;
import java.awt.*;

public class RectangleShapeRendererService implements RendererService {
    @Override
    public void render(Graphics g, Shape shape, boolean xor) {
        RectangleShape rect = (RectangleShape) shape;
        Point start = rect.getLocation();
        Point end = rect.getEnd();

        int x = Math.min(start.x, end.x);
        int y = Math.min(start.y, end.y);
        int width = Math.abs(end.x - start.x);
        int height = Math.abs(end.y - start.y);

        if (xor) {
            g.setXORMode(shape.getColor());
        } else {
            g.setColor(shape.getColor());
        }
        g.drawRect(x, y, width, height);
    }
}
