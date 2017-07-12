import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile
{
    private BufferedImage normal;
    private BufferedImage openedImage;
    private BufferedImage flagImage;
    private BufferedImage bombImage;
    private BufferedImage oneImage;
    private BufferedImage twoImage;
    private BufferedImage threeImage;
    private BufferedImage fourImage;
    private BufferedImage fiveImage;
    private BufferedImage sixImage;
    private BufferedImage sevenImage;
    private BufferedImage eightImage;

    private int x;
    private int y;
    private boolean bomb;
    private boolean opened;
    private boolean flag;
    private int amountOfNearBombs;

    private static int width = Frame.getScreenWidth()/World.getWidth(); 
    private static int height = Frame.getScreenHeight()/World.getHeight(); 

    public Tile(int x, int y, BufferedImage normal, BufferedImage bomb, BufferedImage openedImage, BufferedImage flag, BufferedImage oneImage, BufferedImage twoImage, BufferedImage threeImage, BufferedImage fourImage, BufferedImage fiveImage, BufferedImage sixImage, BufferedImage sevenImage, BufferedImage eightImage)
    {
        this.x = x;
        this.y = y;
        this.normal = normal;
        this.bombImage = bomb;
        this.openedImage = openedImage;
        this.flagImage = flag;
        this.oneImage = oneImage;
        this.twoImage = twoImage;
        this.threeImage = threeImage;
        this.fourImage = fourImage;
        this.fiveImage = fiveImage;
        this.sixImage = sixImage;
        this.sevenImage = sevenImage;
        this.eightImage = eightImage;
    }

    public void setOpenedImage(BufferedImage openedImage)
    {
        this.openedImage = openedImage;
    }

    public void setOpened(boolean opened)
    {
        this.opened = opened;
    }

    public boolean isOpened()
    {
        return opened;
    }

    public void setBomb(boolean bomb)
    {
        this.bomb = bomb;
    }

    public boolean isBomb()
    {
        return bomb;
    }

    public void setAmountOfNearBombs(int amountOfNearBombs)
    {
        this.amountOfNearBombs = amountOfNearBombs;
        System.out.println("Amount of Bombs: " + amountOfNearBombs);
    }

    public int getAmountOfNearBombs()
    {
        return amountOfNearBombs;
    }

    public boolean canOpen()
    {
        return !opened&&!bomb&&amountOfNearBombs >= 0;
    }

    public void placeFlag()
    {
        if(flag) flag = false;
        else
        {
            if(!opened) flag = true;
        }
    }

    public boolean isFlag()
    {
        return flag;
    }

    public void reset()
    {
        flag = false;
        bomb = false;
        opened = false;
    }

    public void draw(Graphics g)
    {
        if(!opened) 
        {
            if(!flag) g.drawImage(normal, x * width, y * height, null);
            else g.drawImage(flagImage, x * width, y * height, null);
        }
        else
        {
            if(bomb) g.drawImage(bombImage, x * width, y * height, null);
            else
            {
                g.drawImage(openedImage, x * width, y * height, null);
                if(amountOfNearBombs > 0)
                {
                    //g.setColor(Color.WHITE);
                    //g.drawString("" + amountOfNearBombs, x * width, y * height);
                    //TODO Ordne Zahlen richtig an
                    switch (amountOfNearBombs) {
                        case 1:
                        g.drawImage(oneImage, x * width, y * height, null);
                        break;
                        case 2:
                        g.drawImage(twoImage, x * width, y * height, null);
                        break;
                        case 3:
                        g.drawImage(threeImage, x * width, y * height, null);
                        break;
                        case 4:
                        g.drawImage(fourImage, x * width, y * height, null);
                        break;
                        case 5:
                        g.drawImage(fiveImage, x * width, y * height, null);
                        break;
                        case 6:
                        g.drawImage(sixImage, x * width, y * height, null);
                        break;
                        case 7:
                        g.drawImage(sevenImage, x * width, y * height, null);
                        break;
                        case 8:
                        g.drawImage(eightImage, x * width, y * height, null);
                        break;
                    }
                }
            }
        }

        //TODO Ersetze Zahlenstrings durch Zahlenbilder
    }

    public static int getWidth()
    {
        return width;
    }

    public static int getHeight()
    {
        return height;
    }
}