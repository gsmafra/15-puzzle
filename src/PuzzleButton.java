import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import javax.swing.*;

public class PuzzleButton extends JLabel implements MouseListener
{
    private static final long serialVersionUID = 1L;
    int id;
    Interface puzzle;
    
    public PuzzleButton(int id, int x, int y, int w, int h, Interface puzzle)
    {
        super();
        this.id = id;
        this.puzzle = puzzle;
        setBounds(x, y, w, h);
        addMouseListener(this);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }
    
    public void mouseClicked(MouseEvent e)
    {
        switch(id)
        {
            case 2:
            {
                puzzle.restart();
                break;
            }
            case 3:
            {
                puzzle.askForTip();
                break;
            }
            case 4:
            {
                try
                {
                    puzzle.solve();
                }
                catch (InterruptedException e1)
                {
                    e1.printStackTrace();
                }
                break;
            }
        }
    }

    public void mouseEntered(MouseEvent e)
    {
    }

    public void mouseExited(MouseEvent e)
    {
    }

    public void mousePressed(MouseEvent e)
    {
    }

    public void mouseReleased(MouseEvent e)
    {
    }
}
