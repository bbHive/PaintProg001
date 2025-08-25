package com.gabriel.draw.model;

import com.gabriel.drawfx.model.Shape;
import com.gabriel.draw.service.RectangleShapeRendererService;
import lombok.Data;
import java.awt.*;

@Data
public class RectangleShape extends Shape {
    public RectangleShape(Point start, Point end) {
        super(start);
        this.setEnd(end);
        this.setColor(Color.GREEN); // default color
        this.setRendererService(new RectangleShapeRendererService());
    }
}