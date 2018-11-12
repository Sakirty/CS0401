/*
	Coin.java THIS IS THE ONLY FILE YOU HAND IN
	THERE IS NO MAIN METHOD IN THIS CLASS!
*/
import java.util.Random;
public class Coin
{	
	private int Heads;
	private int Tails;
	private Random generator;
	public Coin(int n){
		generator = new Random(n);
		Heads = 0;
		Tails = 0;
	}

	public String flip(){
		boolean random = generator.nextBoolean();

		if (random == true){
			Heads++;
			return "H";
		}	else	{
			Tails++;
			return "T";
		}
	}

	public int getNumHeads(){
		return Heads;
	}
	public int getNumTails(){
		return Tails;
	}

	public void setNumHeads(int h){
		Heads = h;
	}

	public void setNumTails(int t){
		Tails = t;
	}
	
	public void reset(){
		setNumHeads(0);
		setNumTails(0);
	}
} // END COIN CLASS