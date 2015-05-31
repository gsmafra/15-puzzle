public class Tile
{
	int posx;
	int posy;
	Jeu puzzle;

	public Tile(int posx, int posy, Jeu puzzle)
	{
        super();
        this.puzzle = puzzle;
        this.posx = posx;
        this.posy = posy;
    }

	boolean legalMove()
	{
		if(Math.abs(posx - puzzle.getPosX0()) + Math.abs(posy - puzzle.getPosY0()) < 2)
		{
			return true;
		}

		return false;
	}	

	public void deplacer()
	{
		int temp;
		
		temp = posx;
        posx = puzzle.getPosX0();
        puzzle.setPosX0(temp);

		temp = posy;
        posy = puzzle.getPosY0();
        puzzle.setPosY0(temp);
		
        puzzle.checkIfWon();
	}

	public int getPosX()
	{
		return posx;
	}
	
	public int getPosY()
	{
		return posy;
	}
	
	public void setPosX(int x)
	{
		posx = x;
	}
	
	public void setPosY(int y)
	{
		posy = y;
	}
}
