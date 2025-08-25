package com.gabriel.draw.model;

import com.gabriel.drawfx.model.Shape;
import com.gabriel.draw.service.EllipseRendererService;
import lombok.Data;
import java.awt.*;

@Data
public class Ellipse extends Shape {
    public Ellipse(Point start, Point end) {
        super(start);
        this.setEnd(end);
        this.setColor(Color.BLUE); // default color
        this.setRendererService(new EllipseRendererService());
    }
}