import java.util.*;

public class Jeu
{
    private int posx0;
    private int posy0;
    private int nx;
    private int ny;
    private int id;
    private Control app;
    protected Tile[] tiles;

    public Jeu(int nx, int ny, Control app, int id)
    {
        this.id = id;
        this.app = app;
        this.nx = nx;
        this.ny = ny;
        posx0 = nx - 1;
        posy0 = ny - 1;
        tiles = new Tile[nx*ny];
    }

    public int getID()
    {
        return id;
    }
    
    public void restart()
    {
        Control.movs = 0;
        List<Integer> listPos = randPerm(nx*ny - 1);
        Iterator<Integer> itr = listPos.iterator();
        int x, y, tilePos;
        setPosX0(nx - 1);
        setPosY0(ny - 1);
        
        for (int i=1; i<nx*ny; i++)
        {
            tilePos = itr.next();
            x = getX(tilePos);
            y = getY(tilePos);
            placeTile(i, x, y);
            app.searchInterface(id).moveTile(i, x, y);
        }
    }
    
    public boolean moveTile(int id)
    {
        if(tiles[id].legalMove())
        {
            Control.movs++;
            System.out.println(Control.movs);
            tiles[id].deplacer();
            return true;
        }
        return false;
    }

    public int posToTile(int pos)
    {
        int posx = getX(pos);
        int posy = getY(pos);
        for(int i=1; i<16; i++)
        {
            if(tiles[i].getPosX() == posx & tiles[i].getPosY() == posy)
            {
                return i;
            }
        }
        return 0;
    }
    
    public List<Integer> randPerm(int n)
    {
        boolean valid = false;
        List<Integer> list = new ArrayList<Integer>();
        
        for (int i=1; i<=n; i++)
        {
            list.add(i);
        }
        while(!valid)
        {
            java.util.Collections.shuffle(list);
            valid = checkIfValid(list);
        }
        return list;
    }
    
    public void placeTile(int i, int x, int y)
    {
        tiles[i].setPosX(x);
        tiles[i].setPosY(y);
    }
    
     public short getX(int i)
    {
         return 0;
    }
    
    public short getY(int i)
    {
        return 0;
    }

    public void consTile(int i, int tilePos)
    {
        tiles[i] = new Tile(getX(tilePos), getY(tilePos), this);
    }
    
    public int getPosX0()
    {
        return posx0;
    }
    
    public int getPosY0()
    {
        return posy0;
    }

    public int getPosXN(int n)
    {
        return tiles[n].getPosX();
    }
    
    public int getPosYN(int n)
    {
        return tiles[n].getPosY();
    }
    
    public void setPosX0(int x)
    {
        posx0 = x;
    }
    
    public void setPosY0(int y)
    {
        posy0 = y;
    }

    public int getNX()
    {
        return nx;
    }
    
    public int getNY()
    {
        return ny;
    }
    
    public boolean checkIfValid(List<Integer> list)
    {
        Iterator<Integer> itr = list.iterator();
        int[] pos = new int[nx*ny];
        int perm = 0;
        
        for(int i=1; i<nx*ny; i++)
        {
            pos[i] = itr.next();
        }
        
        for(int i=1; i<nx*ny; i++)
        {
            for(int j=i; j<nx*ny; j++)
            {
                if(pos[i] > pos[j])
                {
                    perm++;
                }
            }
        }
        
        if(perm % 2 == 1)
        {
            return false;
        }
        return true;
    }

    public void checkIfWon()
    {
        boolean won = true;
        for(int i=1; i<nx*ny; i++)
        {
            if(getX(i) != tiles[i].posx)
            {
                won = false;
                break;
            }
            if(getY(i) != tiles[i].posy)
            {
                won = false;
                break;
            }
        }
        if(won)
        {
            app.searchInterface(id).won();
        }
    }

    public int[] getState()
    {
        return null;
    }

    public int[] getState15()
    {
        return null;
    }
}
