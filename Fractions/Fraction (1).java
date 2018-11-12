public class Fraction implements Comparable<Fraction> // IMPLEMENT THe COMPARABLE INTERFACE 
{
	public int numer;
	public int denom;

	public int compareTo( Fraction other )
	{
		if(this.denom == other.denom)
		{
			if(this.numer == other.numer)
			{
				return 0;
			} 
			else if (this.numer > other.numer)
			{
				return 1; 
			} 
			else
			{
				return -1;
			}
		}
		else
		{
			int i = this.numer * other.denom;
			int k = other.numer * this.denom;
			if(i == k)
			{
				return 0;
			} 
			else if(i > k)
			{
				return 1;
			}
			else
			{
				return -1;
			}
		}
	}
	public String toString()
	{
		return Double.toString((double)this.numer/(double)this.denom);
	}
}