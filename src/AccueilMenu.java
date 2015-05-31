import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GraphicsEnvironment;
import java.awt.GraphicsDevice;

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

        panel.add(new AccueilButton(0, 0, 0, 200, 64, this, "8-Puzzle"));
        panel.add(new AccueilButton(1, 0, 65, 200, 64, this, "15-Puzzle"));
        panel.add(new AccueilButton(5, 0, 130, 200, 64, this, "Options"));

        JLabel labelx = new JLabel();
        panel.add(labelx);
        
        setSize(200, 195);
        setResizable(false);
        setLocation(500, this.getY());
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
