
package br.com.mariojp.figureeditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

class DrawingPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private static final int DEFAULT_SIZE = 60;
    private final List<Shape> shapes = new ArrayList<>();
    private Point startDrag = null;

    DrawingPanel() {
        
        setBackground(Color.WHITE);
        setOpaque(true);
        setDoubleBuffered(true);

        var mouse = new MouseAdapter() {
            @Override public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1 && startDrag == null) {
                    int size = Math.max(Math.min(DEFAULT_SIZE, DEFAULT_SIZE), 10);
                    Shape s =  new Ellipse2D.Double(e.getPoint().x, e.getPoint().y, size, size);
                    //return new Rectangle2D.Double(e.getPoint().x, e.getPoint().y, Math.max(DEFAULT_SIZE, 10), Math.max(DEFAULT_SIZE, 10));
                    shapes.add(s);
                    repaint();
                }
            }
        };
        addMouseListener(mouse);        
        addMouseMotionListener(mouse);

    }

    void clear() {
        shapes.clear();
        repaint();
    }

    @Override protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (Shape s : shapes) {
            g2.setColor(new Color(30,144,255));
            g2.fill(s);
            g2.setColor(new Color(0,0,0,70));
            g2.setStroke(new BasicStroke(1.2f));
            g2.draw(s);
        }

        g2.dispose();
    }

}
