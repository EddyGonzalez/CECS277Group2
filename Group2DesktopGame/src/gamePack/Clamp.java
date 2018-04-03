package gamePack;

public class Clamp {

	public static float clamp(float var, float min, float max)
	{
		if(var >= max)
		{
			return max;
		}
		else if(var <= min)
		{
			return min;
		}
		else
		{
			return var;
		}
	}
}
