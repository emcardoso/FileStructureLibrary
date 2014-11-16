package graphics;

import java.awt.*;
import java.awt.event.*;


public interface Drawable {

    public void draw(Graphics g);
    
    public void mouseClicked(MouseEvent e);
    public void mouseEnter();
    public void mouseExit();
    public void mouseDrag(int x, int y, int x1, int y1);
    public boolean inBounds(int x, int y);
}