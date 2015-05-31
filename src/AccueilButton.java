import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class AccueilButton extends JLabel implements MouseListener
{
	private static final long serialVersionUID = 1L;
	int id;
	AccueilMenu aMenu;
	
	public AccueilButton(int id, int x, int y, int w, int h, AccueilMenu aMenu)
	{
        super();
        this.aMenu = aMenu;
        this.id = id;
        setBounds(x, y, w, h);
        addMouseListener(this);
    }

	public void mouseClicked(MouseEvent e)
	{
		switch(id)
		{
			case 0:
			{
				aMenu.create8Puzzle();
				break;
			}
			case 1:
			{
				aMenu.create15Puzzle();
				break;
			}
			case 5:
			{
				aMenu.openOptionMenu();
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