import processing.core.PApplet;

public class laser
{
	int laserX;
	int laserY1, laserY2;
	boolean isActive;

	public laser() 
	{
		this.laserX = player.x;
		this.laserY1 = 0;
		this.laserY2 = 395;
		
		isActive = false;
	}
	
	public void shoot(PApplet app)
	{
		if(app.keyPressed)
		{
			if(app.key == 'z' || app.key == 'Z')
			{
				isActive = true;
			}
			
			else
			{
				isActive = false;
			}
		}
		
		app.stroke(255, 0, 0);
		app.strokeWeight(7);
		
		if(isActive)
		{
			app.line(laserX, laserY1, laserX, laserY2);
		}
	}
	
	public void move(PApplet app)
	{	
		if(app.keyPressed)
		{
			switch(app.key)
			{
			case 'a':
				laserX -= 4;
				break;
			case 'A':
				laserX -= 4;
				break;
			case 'd':
				laserX += 4;
				break;
			case 'D':
				laserX += 4;
				break;
			default:
				
				break;
			}
		}
	}
	
	public void walls(PApplet app)
	{
		if(laserX > 475)
		{
			laserX = 474;
		}
		if(laserX < 25) 
		{
			laserX = 26;
		}
	}
	
	public int getLaserX() 
	{
		return laserX;
	}
	
	public void setLaserX(int laserX) 
	{
		this.laserX = laserX;
	}
	
	public boolean isActive() 
	{
		return this.isActive;
	}
	
	public void setActive(boolean active) 
	{
		this.isActive = active;
	}

}
