import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solver
{
    public static int[] prox = new int[181441];
    public static int[] state = new int[181441];

    public static int[] prox_up = new int[524161];
    public static int[] pos1_up = new int[524161];
    public static int[] pos2_up = new int[524161];
    public static int[] pos3_up = new int[524161];
    public static int[] pos4_up = new int[524161];
    public static int[] posz_up = new int[524161];
    
    public static int[] pos5_left = new int[11881];
    public static int[] pos9_left = new int[11881];
    public static int[] pos13_left = new int[11881];
    public static int[] posz_left = new int[11881];
    public static int[] prox_left = new int[11881];

    public static int[] getPosAdj15(int pos)
    {
    	switch (pos)
    	{
	    case 1:
	    	int[] adj1 = {2,5};
		    return adj1;
		case 2:
		    int[] adj2 = {1,3,6};
		    return adj2;
		case 3:
		    int[] adj3 = {2,4,7};
		    return adj3;
		case 4:
		    int[] adj4 = {3,8};
		    return adj4;
		case 5:
		    int[] adj5 = {1,6,9};
		    return adj5;
		case 6:
		    int[] adj6 = {2,5,7,10};
		    return adj6;
		case 7:
		    int[] adj7 = {3,6,8,11};
		    return adj7;
		case 8:
		    int[] adj8 = {4,7,12};
		    return adj8;
		case 9:
		    int[] adj9 = {5,10,13};
		    return adj9;
		case 10:
		    int[] adj10 = {6,9,11,14};
		    return adj10;
		case 11:
		    int[] adj11 = {7,10,12,15};
		    return adj11;
		case 12:
		    int[] adj12 = {8,11,16};
		    return adj12;
		case 13:
		    int[] adj13 = {9,14};
		    return adj13;
		case 14:
		    int[] adj14 = {10,13,15};
		    return adj14;
		case 15:
		    int[] adj15 = {11,14,16};
		    return adj15;
		case 16:
		    int[] adj16 = {12,15};
		    return adj16;
	    default:
	    	return null;
    	}
    }
    
    public static int[][] adjStates(int[] adj, int[] st)
    {
    	int[][] adjSt = new int[adj.length][16];
    	for(int i=0; i<adj.length; i++)
    	{
    		for(int j=0; j<16; j++)
    		{
    			if(st[j] == 0)
    			{
    				adjSt[i][j] = st[adj[i] - 1];
    			}
    			else if(st[j] == st[adj[i] - 1])
    			{
    				adjSt[i][j] = 0;
    			}
    			else
    			{
    				adjSt[i][j] = st[j];
    			}
    		}
    	}
    	return adjSt;
    }
    
    public static int manDistance(int[] st)
    {
		int dist = 0;
		int posx1, posx2, posx3, posx4, posx5, posx9, posx13;
		posx1 = posx2 = posx3 = posx4 = posx5 = posx9 = posx13 = 0;
		int posy1, posy2, posy3, posy4, posy5, posy9, posy13;
		posy1 = posy2 = posy3 = posy4 = posy5 = posy9 = posy13 = 0;

    	for(int i=0; i<4; i++)
    	{
    		for(int j=0; j<4; j++)
    		{
    			if(st[4*i + j] == 1)
    			{
    				posx1 = j;
    				posy1 = i;
    			}
    			if(st[4*i + j] == 2)
    			{
    				posx2 = j;
    				posy2 = i;
    			}
    			if(st[4*i + j] == 3)
    			{
    				posx3 = j;
    				posy3 = i;
    			}
    			if(st[4*i + j] == 4)
    			{
    				posx4 = j;
    				posy4 = i;
    			}
    			if(st[4*i + j] == 5)
    			{
    				posx5 = j;
    				posy5 = i;
    			}
    			if(st[4*i + j] == 9)
    			{
    				posx9 = j;
    				posy9 = i;
    			}
    			if(st[4*i + j] == 13)
    			{
    				posx13 = j;
    				posy13 = i;
    			}
    		}
    	}
    	
		dist += Math.abs(posx1 - 0);
		dist += Math.abs(posy1 - 0);
		
		dist += Math.abs(posx2 - 1);
		dist += Math.abs(posy2 - 0);
		
		dist += Math.abs(posx3 - 2);
		dist += Math.abs(posy3 - 0);
		
		dist += Math.abs(posx4 - 3);
		dist += Math.abs(posy4 - 0);
		
		dist += Math.abs(posx5 - 0);
		dist += Math.abs(posy5 - 1);
		
		dist += Math.abs(posx9 - 0);
		dist += Math.abs(posy9 - 2);
		
		dist += Math.abs(posx13 - 0);
		dist += Math.abs(posy13 - 3);
		
		return dist;
		
    }
    
    public static int manDistance(Jeu puzzle)
	{
		int dist = 0;
		
		dist += Math.abs(puzzle.getPosXN(1) - 0);
		dist += Math.abs(puzzle.getPosYN(1) - 0);
		
		dist += Math.abs(puzzle.getPosXN(2) - 1);
		dist += Math.abs(puzzle.getPosYN(2) - 0);
		
		dist += Math.abs(puzzle.getPosXN(3) - 2);
		dist += Math.abs(puzzle.getPosYN(3) - 0);
		
		dist += Math.abs(puzzle.getPosXN(4) - 3);
		dist += Math.abs(puzzle.getPosYN(4) - 0);
		
		dist += Math.abs(puzzle.getPosXN(5) - 0);
		dist += Math.abs(puzzle.getPosYN(5) - 1);
		
		dist += Math.abs(puzzle.getPosXN(9) - 0);
		dist += Math.abs(puzzle.getPosYN(9) - 2);
		
		dist += Math.abs(puzzle.getPosXN(13) - 0);
		dist += Math.abs(puzzle.getPosYN(13) - 3);
		
		
		
		return dist;
	}

    public static void readData() throws NumberFormatException, IOException
    {
        int i=1;
        /***************************************************/
    	BufferedReader in = new BufferedReader(new FileReader("./text/prox.txt"));
    	String line;
    	while((line = in.readLine()) != null)
    	{
    	    Solver.prox[i++] = Integer.parseInt(line);
    	}
    	in.close();
        /***************************************************/
    	i = 1;
    	in = new BufferedReader(new FileReader("text/state.txt"));
    	while((line = in.readLine()) != null)
    	{
    		Solver.state[i++] = Integer.parseInt(line);
    	}
    	in.close();
        /***************************************************/
        /***************************************************/
        /***************************************************/
    	i = 1;
    	in = new BufferedReader(new FileReader("text/pos1_up.txt"));
    	while((line = in.readLine()) != null)
    	{
    		Solver.pos1_up[i++] = Integer.parseInt(line);
    	}
    	in.close();
        /***************************************************/
    	i = 1;
    	in = new BufferedReader(new FileReader("text/pos2_up.txt"));
    	while((line = in.readLine()) != null)
    	{
    		Solver.pos2_up[i++] = Integer.parseInt(line);
    	}
    	in.close();
        /***************************************************/
    	i = 1;
    	in = new BufferedReader(new FileReader("text/pos3_up.txt"));
    	while((line = in.readLine()) != null)
    	{
    		Solver.pos3_up[i++] = Integer.parseInt(line);
    	}
    	in.close();
        /***************************************************/
    	i = 1;
    	in = new BufferedReader(new FileReader("text/pos4_up.txt"));
    	while((line = in.readLine()) != null)
    	{
    		Solver.pos4_up[i++] = Integer.parseInt(line);
    	}
    	in.close();
        /***************************************************/
    	i = 1;
    	in = new BufferedReader(new FileReader("text/posz_up.txt"));
    	while((line = in.readLine()) != null)
    	{
    		Solver.posz_up[i++] = Integer.parseInt(line);
    	}
    	in.close();
        /***************************************************/
    	i = 1;
    	in = new BufferedReader(new FileReader("text/prox_up.txt"));
    	while((line = in.readLine()) != null)
    	{
    		Solver.prox_up[i++] = Integer.parseInt(line);
    	}
    	in.close();
        /***************************************************/
        /***************************************************/
        /***************************************************/
    	i = 1;
    	in = new BufferedReader(new FileReader("text/pos5_left.txt"));
    	while((line = in.readLine()) != null)
    	{
    		Solver.pos5_left[i++] = Integer.parseInt(line);
    	}
    	in.close();
        /***************************************************/
    	i = 1;
    	in = new BufferedReader(new FileReader("text/pos9_left.txt"));
    	while((line = in.readLine()) != null)
    	{
    		Solver.pos9_left[i++] = Integer.parseInt(line);
    	}
    	in.close();
        /***************************************************/
    	i = 1;
    	in = new BufferedReader(new FileReader("text/pos13_left.txt"));
    	while((line = in.readLine()) != null)
    	{
    		Solver.pos13_left[i++] = Integer.parseInt(line);
    	}
    	in.close();
        /***************************************************/
    	i = 1;
    	in = new BufferedReader(new FileReader("text/posz_left.txt"));
    	while((line = in.readLine()) != null)
    	{
    		Solver.posz_left[i++] = Integer.parseInt(line);
    	}
    	in.close();
        /***************************************************/
    	i = 1;
    	in = new BufferedReader(new FileReader("text/prox_left.txt"));
    	while((line = in.readLine()) != null)
    	{
    		Solver.prox_left[i++] = Integer.parseInt(line);
    	}
    	in.close();
        /***************************************************/
        /***************************************************/
        /***************************************************/
    }
    
	public static int svToInt(int[] stateVec)
	{
		int stateInt = 0;
		int n = 9;
		
		for(int i=0; i<n; i++)
		{
			stateInt += Math.pow(10, n-1-i)*stateVec[i];
		}
		
		return stateInt;
	}

	public static int[] intToSV(int stateInt)
	{
		int n = 9;
		int[] stateVec = new int[n];
		int dig;

		for(int i=0; i<n; i++)
		{
			stateVec[i] = 0;
		}

		for(int i=0; i<n; i++)
		{
			dig = stateInt/(int)Math.pow(10,n-1-i);
			stateInt = stateInt - dig*(int)Math.pow(10,n-1-i);
			stateVec[i] = dig;
		}
		
		return stateVec;
	}

	public static int searchIndex(int stateInt)
	{
		for(int i=0; i<181440; i++)
		{
			if(state[i] == stateInt)
			{
				return i;
			}
		}
		return -1;
	}

	public static int trans34(int mov)
	{
		if (mov == 1)
			return 6;
		if (mov == 2)
			return 7;
		if (mov == 3)
			return 8;
		if (mov == 4)
			return 10;
		if (mov == 5)
			return 11;
		if (mov == 6)
			return 12;
		if (mov == 7)
			return 14;
		if (mov == 8)
			return 15;
		return -1;
	}

	public static void tip(Jeu15 puzzle, Interface inter)
	{
		int x, y;
		int toMove = 0;
		
		if(puzzle.checkIf3x3())
		{
			int csv[] = puzzle.getState();
			int currState = Solver.svToInt(csv);
			int currIndex = Solver.searchIndex(currState);
			int proxIndex = prox[currIndex];
			int proxState = state[proxIndex];
			
			int psv[] = Solver.intToSV(proxState);
			
			int mov = 0;
			
			for(int i=0; i<9; i++)
			{
				if(csv[i] != psv[i])
				{
					mov = Math.abs(csv[i] - psv[i]);
				}
			}
			
			if(mov != 0)
			{
				mov = Solver.trans34(mov);
				x = puzzle.getPosX0();
				y = puzzle.getPosY0();
				inter.moveTile(mov, x, y);
				puzzle.moveTile(mov);
			}
		}
		else
		{
			if(puzzle.posToTile(1) != 1 | puzzle.posToTile(2) != 2 | 
			   puzzle.posToTile(3) != 3 | puzzle.posToTile(4) != 4)
			{
				int pos0 = 4*puzzle.getPosY0() + puzzle.getPosX0() + 1;
				int pos1 = 4*puzzle.getPosYN(1) + puzzle.getPosXN(1) + 1;
				int pos2 = 4*puzzle.getPosYN(2) + puzzle.getPosXN(2) + 1;
				int pos3 = 4*puzzle.getPosYN(3) + puzzle.getPosXN(3) + 1;
				int pos4 = 4*puzzle.getPosYN(4) + puzzle.getPosXN(4) + 1;
				
				for(int i=0; i<524161; i++)
				{
					if(pos0 == Solver.posz_up[i] & pos1 == Solver.pos1_up[i] &
					   pos2 == Solver.pos2_up[i] & pos3 == Solver.pos3_up[i] &
					   pos4 == Solver.pos4_up[i])
					{
						toMove = puzzle.posToTile(Solver.posz_up[Solver.prox_up[i]]);
						break;
					}
				}
			}
			else if(puzzle.posToTile(5) != 5 | puzzle.posToTile(9) != 9 | 
					puzzle.posToTile(13) != 13)
			{
				int pos0 = 4*puzzle.getPosY0() + puzzle.getPosX0() + 1;
				int pos5 = 4*puzzle.getPosYN(5) + puzzle.getPosXN(5) + 1;
				int pos9 = 4*puzzle.getPosYN(9) + puzzle.getPosXN(9) + 1;
				int pos13 = 4*puzzle.getPosYN(13) + puzzle.getPosXN(13) + 1;
				
				for(int i=0; i<11881; i++)
				{
					if(pos0 == Solver.posz_left[i] & pos5 == Solver.pos5_left[i] & 
					   pos9 == Solver.pos9_left[i] & pos13 == Solver.pos13_left[i])
					{
						toMove = puzzle.posToTile(Solver.posz_left[Solver.prox_left[i]]);
						break;
					}
				}
			}

			inter.moveTile(toMove, puzzle.getPosX0(), puzzle.getPosY0());
			puzzle.moveTile(toMove);
		}
	}
	
	public static void tip(Jeu8 puzzle, Interface inter)
	{
		int x, y;
		int csv[] = puzzle.getState();
		int currState = Solver.svToInt(csv);
		int currIndex = Solver.searchIndex(currState);
		int proxIndex = prox[currIndex];
		int proxState = state[proxIndex];
		
		int psv[] = Solver.intToSV(proxState);
		
		int mov = 0;
		
		for(int i=0; i<9; i++)
		{
			if(csv[i] != psv[i])
			{
				mov = Math.abs(csv[i] - psv[i]);
			}
		}
		
		if(mov != 0)
		{
			x = puzzle.getPosX0();
			y = puzzle.getPosY0();
			inter.moveTile(mov, x, y);
			puzzle.moveTile(mov);
		}
	}
	
	public static void tip(Jeu puzzle, Interface inter)
	{
		if(puzzle.getNX() == 4)
		{
			tip((Jeu15)puzzle, inter);
		}
		else
		{
			tip((Jeu8)puzzle, inter);
		}
	}

}
