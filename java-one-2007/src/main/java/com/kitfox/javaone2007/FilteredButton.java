/*
 * FilteredPanel.java
 *
 * Created on April 23, 2007, 8:39 AM
 */

package com.kitfox.javaone2007;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.LineMetrics;
import java.awt.geom.RectangularShape;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.swing.JComponent;

/**
 *
 * @author  kitfox
 */
public class FilteredButton extends JComponent implements GLEventListener
{
    private GLCanvas canvas;
    ShaderBuffer shader;

    BufferedImage backBuf;
    private String text;
    private float radius;
    
//    static enum BnState {UP, DOWN, OVER};
//    BnState bnState = BnState.UP;
    boolean mouseOver;
    boolean bnPressed;
    
    /** Creates new form FilteredPanel */
    public FilteredButton()
    {
        initComponents();
  
        canvas = new GLCanvas(new GLCapabilities());
        canvas.addGLEventListener(this);
        
        add(canvas);
//        add(canvas, BorderLayout.CENTER);
//        canvas.createOffscreenDrawable();
//        JButton but;
//        but.paint(null);
//        but.paintComponent(null);
        //but.paint
    }

    public void addNotify()
    {
        super.addNotify();
        
        canvas.display();
    }
    
//    protected void paintBorder(Graphics g) 
//    {
//    }
    
    protected void paintComponent(Graphics gg) 
    {
        Graphics2D g = (Graphics2D)gg;
        
        Color bgColor = getBackground();
        if (mouseOver)
        {
            bgColor = Color.GREEN;
        }
        if (bnPressed)
        {
            bgColor = Color.BLUE;
        }
        g.setColor(bgColor);
        
        RectangularShape rect;
        
        if (radius == 0)
        {
            rect = new Rectangle(0, 0, getWidth(), getHeight());
        }
        else
        {
            float maxRad = Math.min(getWidth() / 2f, getHeight() / 2f);
            float calcRad = Math.min(radius, maxRad);
            rect = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), calcRad, calcRad);
        }
        g.fillRect(0, 0, getWidth(), getHeight());
        
        if (text != null)
        {
            Font font = getFont();
            g.setFont(font);
            FontMetrics fm = g.getFontMetrics();

            int baseline = getHeight() / 2 + (fm.getAscent() - (fm.getAscent() + fm.getDescent()) / 2);
            LineMetrics lm = font.getLineMetrics(text, g.getFontRenderContext());
            int xpos = (getWidth() - fm.stringWidth(text)) / 2;
            
            g.setColor(getForeground());
            g.drawString(text, xpos, baseline);
        }
        
//        super.paintComponent(g);
        /*
        if (backBuf == null)
        {
            backBuf = getGraphicsConfiguration().createCompatibleImage(getWidth(), getHeight());
        }
        
        Graphics2D gg = backBuf.createGraphics();
        super.paintComponent(gg);
        gg.dispose();
        
        g.drawImage(backBuf, 0, 0, null);
        */
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public float getRadius()
    {
        return radius;
    }

    public void setRadius(float radius)
    {
        this.radius = radius;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        setLayout(null);

        addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                formMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt)
            {
                formMouseReleased(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter()
        {
            public void componentResized(java.awt.event.ComponentEvent evt)
            {
                formComponentResized(evt);
            }
        });

    }// </editor-fold>//GEN-END:initComponents

    private void formMouseReleased(java.awt.event.MouseEvent evt)//GEN-FIRST:event_formMouseReleased
    {//GEN-HEADEREND:event_formMouseReleased
        bnPressed = false;
        repaint();
    }//GEN-LAST:event_formMouseReleased

    private void formMousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_formMousePressed
    {//GEN-HEADEREND:event_formMousePressed
//        canvas.display();

        bnPressed = true;
        repaint();

    }//GEN-LAST:event_formMousePressed

    private void formMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_formMouseExited
    {//GEN-HEADEREND:event_formMouseExited
        mouseOver = false;
        repaint();

    }//GEN-LAST:event_formMouseExited

    private void formMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_formMouseEntered
    {//GEN-HEADEREND:event_formMouseEntered
        mouseOver = true;
        repaint();
        
    }//GEN-LAST:event_formMouseEntered

    private void formComponentResized(java.awt.event.ComponentEvent evt)//GEN-FIRST:event_formComponentResized
    {//GEN-HEADEREND:event_formComponentResized
        backBuf = null;
    }//GEN-LAST:event_formComponentResized
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public void init(GLAutoDrawable drawable)
    {
        System.err.println("Button init called");
        shader = new ShaderBuffer(drawable);
                
        canvas.display();
    }

    public void display(GLAutoDrawable gLAutoDrawable)
    {
    }

    public void reshape(GLAutoDrawable gLAutoDrawable, int i, int i0, int i1, int i2)
    {
    }

    public void displayChanged(GLAutoDrawable gLAutoDrawable, boolean b, boolean b0)
    {
    }
    
}
