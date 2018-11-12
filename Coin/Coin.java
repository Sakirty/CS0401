/*
	Coin.java THIS IS THE ONLY FILE YOU HAND IN
	THERE IS NO MAIN METHOD IN THIS CLASS!
*/
import java.util.Random;
public class Coin{
	private int heads;
	private int tails;
	private Random gen;
	


public Coin(int s){
	gen=new Random(s);
	heads=0;
	tails=0;
}	
public String flip(){
	
	boolean random=gen.nextBoolean(); 
	
	if(random == true){
		heads++;
		return "H";
	}
	else{
		tails++;
		return "T";
	}
	
}	

public int getNumHeads(){
	return heads;
}

public int getNumTails(){
	return tails;
}

public void reset(){
	setNumHeads(0);
	setNumTails(0);
}
public void setNumHeads(int h){
	heads=h;
}
public void setNumTails(int t){
	tails=t;
}
	
}