import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame implements MouseListener, KeyListener
{
    private static int width = 800;
    private static int height = 900;

    private static int playWidth = 800;
    private static int playHeight = 800;

    private static int extentsWidth = width - playWidth;
    private static int extentsHeight = height - playHeight;

    private Screen screen;
    private World world;
    private Font font;

    private int insetLeft;
    private int insetTop;

    public Frame()
    {
        super("MineSweeper");

        world = new World();

        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addMouseListener(this);
        addKeyListener(this);
        
        Container c = this.getContentPane();
        c.setBackground(Color.red); 
        
        screen = new Screen();
        add(screen);

        pack();
        insetLeft = getInsets().left;
        insetTop = getInsets().top;
        setSize(width + insetLeft + getInsets().right, height + getInsets().bottom + insetTop);
        setLocationRelativeTo(null);
        setVisible(true);

        font = new Font("SansSerif", 0, 12);
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {

    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }

    @Override
    public void mousePressed(MouseEvent e)
    {

    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        if(e.getButton() == 1) world.clickedLeft(e.getX() - insetLeft, e.getY() - insetTop);
        if(e.getButton() == 3) world.clickedRight(e.getX() - insetLeft, e.getY() - insetTop);
        screen.repaint();
    }

    @Override
    public void keyPressed(KeyEvent e)
    {

    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_R)
        {
            world.reset();
            screen.repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    public class Screen extends JPanel
    {
        @Override
        public void paintComponent(Graphics g)
        {
            g.setFont(font);
            world.draw(g);
        }
    }

    public static int getScreenWidth()
    {
        return width;
    }

    public static int getScreenHeight()
    {
        return height;
    }

    public static int getPlayWidth()
    {
        return playWidth;
    }

    public static int getPlayHeight()
    {
        return playHeight;
    }

    public static int getExtentsWidth()
    {
        return extentsWidth;
    }

    public static int getExtentsHeight()
    {
        return extentsHeight;
    }
}