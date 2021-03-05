import processing.core.PApplet;

public class weakEnemies 
{
	private int posX, posY, size, moveRate;

	public weakEnemies(int posX, int posY, int size, PApplet app) 
	{
		this.posX = posX;
		this.posY = posY;
		this.size = size;
		
		moveRate = 1;
	}
	
	public void mov()
	{
		posY += moveRate;
	}
	
	public void draw(PApplet app)
	{
		app.fill(0, 255, 0);
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

}
