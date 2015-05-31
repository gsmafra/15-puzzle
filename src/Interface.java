import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.*;

import javax.swing.*;
import javax.swing.Timer;

public class Interface
{
    private int dessin;
    private int id;
    private int dim;
    private boolean resoudre;
    private Timer print;
    private Control app;
    private TileButton[] tiles;
    private JFrame frame;
    
    public Interface(Jeu puzzle, Control app, int id, int dim)
    {
        this.id = id;
        this.app = app;
        this.dim = dim;
        int nx = puzzle.getNX();
        int ny = puzzle.getNY();
        resoudre = false;
        
        this.dessin = app.getDessin();

        frame = new JFrame("Taquin " + nx + "x" + ny);

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        WindowListener exitListener = new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                stopTimer();
                frame.dispose();
            }
        };
        frame.addWindowListener(exitListener);

        JPanel panel = (JPanel)frame.getContentPane();
        tiles = new TileButton[nx*ny];
        List<Integer> listPos = puzzle.randPerm(nx*ny - 1);
        Iterator<Integer> itr = listPos.iterator();
        
        for (int i=1; i<nx*ny; i++)
        {
            int tilePos = itr.next();
            tiles[i] = new TileButton(i, puzzle.getX(tilePos), puzzle.getY(tilePos), this);
            puzzle.consTile(i, tilePos);
            
            tiles[i].setIcon(new ImageIcon(getFileDessin(i)));
            panel.add(tiles[i]);
        }
        
        PuzzleButton restart = new PuzzleButton(2, 78*nx + 25, 10, 76, 31, this, "Restart");
        panel.add(restart);
        
        PuzzleButton tip = new PuzzleButton(3, 78*nx + 25, 50, 76, 31, this, "Tip");
        panel.add(tip);
        
        PuzzleButton solve = new PuzzleButton(4, 78*nx + 25, 90, 76, 31, this, "Solve");
        panel.add(solve);

        JLabel labelx = new JLabel();  
        panel.add(labelx);

        frame.setLocation(500, frame.getY());

        frame.setResizable(false);
        if (nx == 3)
        {
            frame.setSize(357, 232);
        }
        else
        {
            frame.setSize(434, 310);
        }

        print = new Timer(400, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                askForTip();
            }
        });

        frame.setVisible(true);
    }
    
    public int getID()
    {
        return id;
    }
    
    public void stopTimer()
    {
        if(resoudre)
        {
            print.stop();
            resoudre = false;
        }
    }
    
    public void tileClicked(int i)
    {
        int[] xy = app.getPos0(id);
        if(app.searchJeu(id).moveTile(i))
        {
            tiles[i].deplacer(xy[0], xy[1]);
        }
    }
    
    public void won()
    {
        stopTimer();
        showMessage("Congratulations !");
    }
    
    public void restart()
    {
        stopTimer();
        app.searchJeu(id).restart();
    }

    public void showMessage(String msg)
    {
        JOptionPane.showMessageDialog(frame, msg);
    }
    
    public void moveTile(int mov, int x, int y)
    {
        tiles[mov].deplacer(x, y);
    }
    
    public void askForTip()
    {
        Solver.tip(app.searchJeu(id), this);
    }

    public void solve() throws InterruptedException
    {
        print.start();
        resoudre = true;
    }
    
    public String getFileDessin(int i)
    {
        if (dessin == 0)
        {
            return "images/b (" + i + ").png";
        }
        if (dessin == 1)
        {
            return "images/c (" + i + ").png";
        }
        if (dessin == 2)
        {
            if(dim == 3)
            {
                return "images/s3 (" + i + ").png";
            }
            else
            {
                return "images/s4 (" + i + ").png";
            }
        }
        else
        {
            if(dim == 3)
            {
                return "images/e1 (" + i + ").png";
            }
            else
            {
                return "images/e2 (" + i + ").png";
            }
        }
    }
    
}
