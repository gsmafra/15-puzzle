import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class TileButton extends JLabel implements MouseListener
{
	private static final long serialVersionUID = 1L;
	int id;
	Interface inter;

	public TileButton(int id, int x, int y, Interface inter)
	{
        super();
        this.id = id;
        this.inter = inter;
        setBounds(x*78, y*78, 77, 77);
        addMouseListener(this);
    }

	public void deplacer(int x, int y)
	{
        this.setBounds(x*78, y*78, 77, 77);
	}
	
	public void mouseClicked(MouseEvent e)
	{
		inter.tileClicked(id);
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
