import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AccueilMenu extends JFrame
{
	private static final long serialVersionUID = 1L;
	private Control app;
	
	public AccueilMenu(Control app)
	{
		super("Taquin");

		this.app = app;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = (JPanel)getContentPane();

        AccueilButton newGame8 = new AccueilButton(0, 0, 0, 200, 64, this);
        newGame8.setIcon(new ImageIcon("images/8puzzle.png"));
        panel.add(newGame8);
        
        AccueilButton newGame15 = new AccueilButton(1, 0, 65, 200, 64, this);
        newGame15.setIcon(new ImageIcon("images/15puzzle.png"));
        panel.add(newGame15);
        
        AccueilButton options = new AccueilButton(5, 0, 130, 200, 64, this);
        options.setIcon(new ImageIcon("images/options.png"));
        panel.add(options);

        JLabel labelx = new JLabel();
        panel.add(labelx);
        
        setLocationRelativeTo(null);
        setSize(205, 222);
        setResizable(false);
        setVisible(true);
	}

	public void openOptionMenu()
	{
		app.openOptionMenu();
	}
	
	public void create8Puzzle()
	{
		app.create8Puzzle();
	}
	
	public void create15Puzzle()
	{
		app.create15Puzzle();
	}
}
