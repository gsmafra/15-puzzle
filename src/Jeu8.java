public class Jeu8 extends Jeu
{

	public Jeu8(Control app, int id)
	{
		super(3, 3, app, id);
	}

	public short getX(int i)
	{
		switch (i)
		{
			case 1:	 return 0;
			case 2:	 return 1;
			case 3:	 return 2;
			case 4:	 return 0;
			case 5:	 return 1;
			case 6:	 return 2;
			case 7:	 return 0;
			case 8:	 return 1;
			case 9:	 return 2;
			default: return 0;
		}
	}

	public short getY(int i)
	{
		switch (i)
		{
			case 1:	 return 0;
			case 2:	 return 0;
			case 3:	 return 0;
			case 4:	 return 1;
			case 5:	 return 1;
			case 6:	 return 1;
			case 7:	 return 2;
			case 8:	 return 2;
			case 9:	 return 2;
			default: return 0;
		}
	}

	public int[] getState()
	{
		int[] state = new int[9];
		int x, y;

		for(int i=0; i<9; i++)
		{
			state[i] = 0;
		}
		
		for(int i=1; i<9; i++)
		{
			x = tiles[i].getPosX();
			y = tiles[i].getPosY();
			state[3*y + x] = i;
		}
		
		return state;
	}
}
