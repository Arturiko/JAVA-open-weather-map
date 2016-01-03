package il.co.arturromovmichaelgorlik.finalproject.xmlclasses;

public class Wind
{
	private Speed speed;
	private Direction direction;

	public Speed getSpeed()
	{
		return speed;
	}

	public void setSpeed(Speed speed)
	{
		this.speed = speed;
	}

	public Direction getDirection()
	{
		return direction;
	}

	public void setDirection(Direction direction)
	{
		this.direction = direction;
	}

	@Override
	public String toString()
	{
		return speed + ",\n" + direction;
	}
}
