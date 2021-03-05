import processing.core.PApplet;

public class strongEnemies 
{
	private int posX, posY, size, moveRate;
	boolean hitOnce, hitTwice;

	public strongEnemies(int posX, int posY, int size, PApplet app) 
	{
		this.posX = posX;
		this.posY = posY;
		this.size = size;
		
		hitOnce = false; 
		hitTwice = false;
		
		moveRate = 2;
	}
	
	public void mov()
	{
		posY += moveRate;
	}
	
	public void draw(PApplet app)
	{
		app.fill(0, 0, 255);
		app.square(posX, posY, size);
		mov();
	}
	
	public int getPosX()
	{
		return posX;
	}
	
	public void setPosX(int posX)
	{
		this.posX = posX;
	}

	public boolean hitOnce() 
	{
		return this.hitOnce;
	}
	
	public void setHitOnce(boolean active) 
	{
		this.hitOnce = active;
	}
	
	public boolean hitTwice() 
	{
		return this.hitTwice;
	}
	
	public void setHitTwo(boolean active) 
	{
		this.hitTwice = active;
	}
}
