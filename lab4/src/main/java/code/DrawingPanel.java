package code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DrawingPanel extends JPanel {
    private Color penColor = Color.BLACK;
    private float penThickness = 2.0f;
    private ArrayList<Drawable> allDrawings = new ArrayList<>();

    private static class Drawable {
        ArrayList<Point> points;
        Color color;
        float thickness;

        Drawable(ArrayList<Point> points, Color color, float thickness) {
            this.points = points;
            this.color = color;
            this.thickness = thickness;
        }
    }

    public DrawingPanel() {
        setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                ArrayList<Point> points = new ArrayList<>();
                points.add(e.getPoint());
                allDrawings.add(new Drawable(points, penColor, penThickness));
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Drawable currentDrawing = allDrawings.get(allDrawings.size() - 1);
                currentDrawing.points.add(e.getPoint());
                repaint();
            }
        });
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        Graphics2D g2d = (Graphics2D) g;


        for (Drawable drawing : allDrawings) {
            g2d.setColor(drawing.color);
            g2d.setStroke(new BasicStroke(drawing.thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

            for (int i = 1; i < drawing.points.size(); i++) {
                Point p1 = drawing.points.get(i - 1);
                Point p2 = drawing.points.get(i);
                g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }
    }

    public void clear() {
        allDrawings.clear();
        repaint();
    }

    public void setPenColor(Color color) {
        this.penColor = color;
    }

    public void setPenThickness(float thickness) {
        this.penThickness = thickness;
    }
}
