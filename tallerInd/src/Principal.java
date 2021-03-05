import java.util.ArrayList;

import processing.core.PApplet;

public class Principal extends PApplet
{

	public static void main(String[] args) 
	{
		PApplet.main("Principal");
	}
	
	@Override
	public void settings() //void Awake
	{
		size(500, 500);
	}
	
	player newPlayer;
	laser weapon;
	
	private ArrayList<weakEnemies> weakEn;
	private ArrayList<strongEnemies> strongEn;
	
	@Override
	public void setup() //void Start
	{
		newPlayer = new player();
		weapon = new laser();
		weakEn = new ArrayList<weakEnemies>();
		strongEn = new ArrayList<strongEnemies>();
	}
	
	@Override
	public void draw() //void Update
	{		
		noStroke();
		
		background(255);
		newPlayer.paint(this);
		newPlayer.move(this);
		newPlayer.walls(this);

		initEnemies();
		makeWeakEnemies();
		makeStrongEnemies();
		weakEnemiesKill();
		strongEnemiesKill();
		
		System.out.println(mouseX + "," + mouseY);
		
		weapon.shoot(this);
		weapon.move(this);
		weapon.walls(this);
	}
	
	private void initEnemies()
	{
		if(frameCount == 60) 
		{
			frameCount = 0;
			int xPos = (int) random(0, 450);
			int yPos = (int) random(-10, -50);
		
			weakEn.add(new weakEnemies(xPos, yPos, 30, this));
			
			float randomNum = (int)random(0, 10);
			
			if(randomNum == 1)
			{
				int xPos2 = (int) random(0, 450);
				int yPos2 = (int) random(-10, -50);
	
				strongEn.add(new strongEnemies(xPos2, yPos2, 40, this));
			}
		}
	}
	
	private void makeWeakEnemies()
	{
		for(int i = 0; i < weakEn.size(); i++)
		{
			weakEn.get(i).draw(this);
		}
	}
	
	private void makeStrongEnemies()
	{
		for(int i = 0; i < strongEn.size(); i++)
		{
			strongEn.get(i).draw(this);
		}
	}
	
	public void weakEnemiesKill()
	{
		for(int i = 0; i < weakEn.size(); i++)
		{
			if(weakEn.get(i).getPosX() < weapon.getLaserX()+15 && weakEn.get(i).getPosX() > weapon.getLaserX()-15 && weapon.isActive)
			{
				weakEn.remove(i);
			}
		}
	}
	
	public void strongEnemiesKill()
	{
		for(int i = 0; i < strongEn.size(); i++)
		{
			if(strongEn.get(i).getPosX() < weapon.getLaserX()+25 && strongEn.get(i).getPosX() > 20 && keyPressed && !strongEn.get(i).hitOnce)
			{
				if(key == 'z' || key == 'Z')
				{
					strongEn.get(i).hitOnce = true;
				}
			}
			if(strongEn.get(i).getPosX() < weapon.getLaserX()+25 && strongEn.get(i).getPosX() > 20 && keyPressed && strongEn.get(i).hitOnce)
			{	
				if(key == 'z' || key == 'Z')
				{
					strongEn.get(i).hitTwice = true;
					strongEn.remove(i);
				}
			}
		}
	}

}
