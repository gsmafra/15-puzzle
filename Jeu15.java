public class Jeu15 extends Jeu
{

	public Jeu15(Control app, int id)
	{
		super(4, 4, app, id);
	}
	
	public short getX(int i)
	{
		switch (i)
		{
			case 1:	 return 0;
			case 2:	 return 1;
			case 3:	 return 2;
			case 4:	 return 3;
			case 5:	 return 0;
			case 6:	 return 1;
			case 7:	 return 2;
			case 8:	 return 3;
			case 9:	 return 0;
			case 10: return 1;
			case 11: return 2;
			case 12: return 3;
			case 13: return 0;
			case 14: return 1;
			case 15: return 2;
			case 16: return 3;
			default: return 0;
		}
	}

	public short getY(int i)
	{
		switch(i)
		{
			case 1:	 return 0;
			case 2:	 return 0;
			case 3:	 return 0;
			case 4:	 return 0;
			case 5:	 return 1;
			case 6:	 return 1;
			case 7:	 return 1;
			case 8:	 return 1;
			case 9:	 return 2;
			case 10: return 2;
			case 11: return 2;
			case 12: return 2;
			case 13: return 3;
			case 14: return 3;
			case 15: return 3;
			case 16: return 3;
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
		
		x = tiles[6].getPosX() - 1;
		y = tiles[6].getPosY() - 1;
		state[3*y + x] = 1;
		
		x = tiles[7].getPosX() - 1;
		y = tiles[7].getPosY() - 1;
		state[3*y + x] = 2;
		
		x = tiles[8].getPosX() - 1;
		y = tiles[8].getPosY() - 1;
		state[3*y + x] = 3;
		
		x = tiles[10].getPosX() - 1;
		y = tiles[10].getPosY() - 1;
		state[3*y + x] = 4;
		
		x = tiles[11].getPosX() - 1;
		y = tiles[11].getPosY() - 1;
		state[3*y + x] = 5;
		
		x = tiles[12].getPosX() - 1;
		y = tiles[12].getPosY() - 1;
		state[3*y + x] = 6;
		
		x = tiles[14].getPosX() - 1;
		y = tiles[14].getPosY() - 1;
		state[3*y + x] = 7;
		
		x = tiles[15].getPosX() - 1;
		y = tiles[15].getPosY() - 1;
		state[3*y + x] = 8;
		
		return state;
	}

	public int[] getState15()
	{
		int[] state = new int[16];
		int x, y;

		for(int i=0; i<16; i++)
		{
			state[i] = 0;
		}
		
		for(int i=1; i<16; i++)
		{
			x = tiles[i].getPosX();
			y = tiles[i].getPosY();
			state[4*y + x] = i;
		}
		
		return state;
	}
	
	public boolean checkIf3x3()
	{
		if(tiles[1].getPosX() != 0 || tiles[1].getPosY() != 0)
			return false;
		if(tiles[2].getPosX() != 1 || tiles[2].getPosY() != 0)
			return false;
		if(tiles[3].getPosX() != 2 || tiles[3].getPosY() != 0)
			return false;
		if(tiles[4].getPosX() != 3 || tiles[4].getPosY() != 0)
			return false;
		if(tiles[5].getPosX() != 0 || tiles[5].getPosY() != 1)
			return false;
		if(tiles[9].getPosX() != 0 || tiles[9].getPosY() != 2)
			return false;
		if(tiles[13].getPosX() != 0 || tiles[13].getPosY() != 3)
			return false;
		
		return true;
	}
}
