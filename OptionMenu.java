import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OptionMenu extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JFrame frameMenu;
	private OptionButton okButton;
	private JComboBox dessinList;
    private JLabel picture;
    private Control app;
	
	public void close()
	{
		app.setDessin(dessinList.getSelectedIndex());
		frameMenu.dispose();
	}
	
	public OptionMenu(Control app)
	{
		super(new BorderLayout());
		
		this.app = app;

		picture = new JLabel();
		picture.setBounds(20, 70, 308, 308);
        picture.setIcon(new ImageIcon("ok.png"));
		add(picture);
		
		frameMenu = new JFrame("Options");
		frameMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameMenu.setContentPane(this);
		/*************/
		
		String[] petStrings = {"Beige", "Gris", "Supelec", "Terre"};
		dessinList = new JComboBox(petStrings);
		dessinList.addActionListener(this);
		dessinList.setSelectedIndex(0);
		dessinList.setLocation(42+57, 20);
		dessinList.setSize(150, 30);
		add(dessinList);
		
		okButton = new OptionButton(6, 92+57, 398, 50, 40, this);
		okButton.setIcon(new ImageIcon("ok.png"));
        add(okButton);

        JLabel labelx = new JLabel();  
        add(labelx);

		/*************/
		setOpaque(true);
        frameMenu.setContentPane(this);
		frameMenu.setSize(250+113,380+113);
		frameMenu.setResizable(false);
        frameMenu.setLocationRelativeTo(null);
		frameMenu.setVisible(true);
	}
    
	@Override
	public void actionPerformed(ActionEvent e)
	{
        JComboBox cb = (JComboBox)e.getSource();
        int petName = cb.getSelectedIndex();
        switch(petName)
        {
        case 0:		picture.setIcon(new ImageIcon("splitbeige.png")); break;
        case 1:		picture.setIcon(new ImageIcon("splitcinza.png")); break;
        case 2:		picture.setIcon(new ImageIcon("supelec.png")); break;
        case 3:		picture.setIcon(new ImageIcon("earth.png")); break;
        default:	picture.setIcon(new ImageIcon("ok.png"));
        }
	}
}
