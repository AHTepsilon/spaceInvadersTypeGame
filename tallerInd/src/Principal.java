import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

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
	
	PImage startScreen; boolean hasStarted;
	PImage instructions; boolean instructionsPassed;
	
	boolean gameOver;
	
	PImage background;
	
	player newPlayer;
	laser weapon;
	
	private ArrayList<weakEnemies> weakEn;
	private ArrayList<strongEnemies> strongEn;
	
	int score, time;
	
	@Override
	public void setup() //void Start
	{
		newPlayer = new player(this);
		weapon = new laser();
		weakEn = new ArrayList<weakEnemies>();
		strongEn = new ArrayList<strongEnemies>();
		
		background = loadImage("background.png"); 
		startScreen = loadImage("startup.png"); hasStarted = false;
		instructions = loadImage("instructions_v3.png"); instructionsPassed = false;
		gameOver = false;
		
		score = 0;
		time = 0;
	}
	
	@Override
	public void draw() //void Update
	{		
		System.out.println(mouseX + "," + mouseY);

		initEnemies();
		
		noStroke();
		
		imageMode(CORNER);
		
		if(!hasStarted && !instructionsPassed && !gameOver)
		{
			image(startScreen, 0, 0);
		}
		else if(hasStarted && !instructionsPassed && !gameOver)
		{
			image(instructions, 0, 0);
		}
		
		else if(hasStarted && instructionsPassed && !gameOver) 
		{
			background(255);
			image(background, -10, -10);
		
			newPlayer.paint(this);
			newPlayer.move(this);
			newPlayer.walls(this);

			makeWeakEnemies();
			makeStrongEnemies();
			weakEnemiesKill();
			strongEnemiesKill();
		
			weapon.shoot(this);
			weapon.move(this);
			weapon.walls(this);
			
			noStroke();
			fill(255);
			textSize(18);
			text("score " + score, 398, 18);
			text("time " + time, 398, 38);
			timer();
			gameOver();
		}
		
		else if(hasStarted && instructionsPassed && gameOver)
		{
			textMode(CENTER);
			textSize(20);
			image(background, -10, -10);
			fill(255, 0, 0);
			text("GAME OVER", 250, 250);
			text("score " + score, 250, 280);
		}
	}
	
	private void initEnemies()
	{
		if(frameCount == 60) 
		{
			frameCount = 0;
			int xPos = (int) random(50, 450);
			int yPos = (int) random(-10, -50);
		
			weakEn.add(new weakEnemies(xPos, yPos, 30, this));
			
			float randomNum = (int)random(0, 10);
			
			if(time < 10)
			{
				if(randomNum == 1)
				{
					int xPos2 = (int) random(50, 450);
					int yPos2 = (int) random(-10, -50);
					
					strongEn.add(new strongEnemies(xPos2, yPos2, 40, this));
				}
			}
			
			else if(time >= 10)
			{
				if(randomNum == 1 || randomNum == 3 || randomNum == 5)
				{
					int xPos2 = (int) random(50, 450);
					int yPos2 = (int) random(-10, -50);
					
					strongEn.add(new strongEnemies(xPos2, yPos2, 40, this));
				}
			}
			
			else if(time >= 30)
			{
				if(randomNum == 1 || randomNum == 3 || randomNum == 5 || randomNum == 7 || randomNum == 9)
				{
					int xPos2 = (int) random(50, 450);
					int yPos2 = (int) random(-10, -50);
					
					strongEn.add(new strongEnemies(xPos2, yPos2, 40, this));
				}
			}
			
			else if(time >= 60)
			{
				if(randomNum == 1 || randomNum == 3 || randomNum == 5 || randomNum == 7 || randomNum == 9 || randomNum == 2 || randomNum == 4 || randomNum == 6)
				{
					int xPos2 = (int) random(50, 450);
					int yPos2 = (int) random(-10, -50);
					
					strongEn.add(new strongEnemies(xPos2, yPos2, 40, this));
				}
			}			
			
			if(hasStarted && instructionsPassed)
			{
				time++;
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
				score += 10;
			}
		}
	}
	
	public void strongEnemiesKill()
	{
		for(int i = 0; i < strongEn.size(); i++)
		{
			if(strongEn.get(i).getPosX() < weapon.getLaserX()+25 && strongEn.get(i).getPosX() > weapon.getLaserX()-15 && weapon.isActive)
			{
				strongEn.remove(i);
				score += 20;
			}
		}
	}
	
	public void gameOver()
	{
		for(int i = 0; i < strongEn.size(); i++)
		{
			if(strongEn.get(i).getPosY() > 490)
			{
				System.out.println("game over");
				gameOver = true;
			}
		}
		for(int i = 0; i < weakEn.size(); i++)
		{
			if(weakEn.get(i).getPosY() > 490)
			{
				System.out.println("game over");
				gameOver = true;
			}
		}
	}
	
	public void timer()
	{
		if(frameCount == 60)
		{
			time++;
		}
	}
	
	public void mousePressed()
	{
		if(!hasStarted && !instructionsPassed && dist(mouseX, mouseY, 226, 305) < 40)
		{
			hasStarted = true;
		}
		if(hasStarted && !instructionsPassed && dist(mouseX, mouseY, 259, 404) < 40)
		{
			instructionsPassed = true;
		}
	}
}
