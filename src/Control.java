import java.util.ArrayList;



public class Control
{
	private int dessin;
	private int ida;
	public static int movs = 0;
	AccueilMenu menu;
	ArrayList<Jeu> jeux;
	ArrayList<Interface> inters;
	
	public Control()
	{
		jeux = new ArrayList<Jeu>();
		inters = new ArrayList<Interface>();
		dessin = 0;
		ida = 0;
		menu = new AccueilMenu(this);
	}

	public void openOptionMenu()
	{
		new OptionMenu(this);
	}
	
	public void create8Puzzle()
	{
		Jeu8 jeu = new Jeu8(this, ida);
		Interface inter = new Interface(jeu, this, ida++, 3);
		jeux.add(jeu);
		inters.add(inter);
	}
	
	public void create15Puzzle()
	{
		Jeu15 jeu = new Jeu15(this, ida);
		Interface inter = new Interface(jeu, this, ida++, 4);
		jeux.add(jeu);
		inters.add(inter);
		movs = 0;
	}
	
	public int getDessin()
	{
		return dessin;
	}
	
	public void setDessin(int dessin)
	{
		this.dessin = dessin;
	}

	public Jeu searchJeu(int id)
	{
		for(int i=0; i<jeux.size(); i++)
		{
			if(jeux.get(i).getID() == id)
			{
				return jeux.get(i);
			}
		}
		return null;
	}
	
	public Interface searchInterface(int id)
	{
		for(int i=0; i<inters.size(); i++)
		{
			if(inters.get(i).getID() == id)
			{
				return inters.get(i);
			}
		}
		return null;
	}
	
	public int[] getPos0(int id)
	{
		int[] xy = new int[2];
		xy[0] = searchJeu(id).getPosX0();
		xy[1] = searchJeu(id).getPosY0();
		
		return xy;
	}
}
