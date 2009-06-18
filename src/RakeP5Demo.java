import processing.core.*;
import processing.opengl.*;

import java.util.*;


public class RakeP5Demo extends PApplet
{
	private PFont helvetica;
	
	private ArrayList<BChar> roots;
	

	public void setup()
	{
		size(800,600, OPENGL);
		frameRate(60);
		
		hint(DISABLE_DEPTH_TEST);
		
		helvetica = loadFont("Helvetica-Bold-128.vlw");
		textFont(helvetica);
		
		roots = new ArrayList<BChar>();
		roots.add(BChar.buildString(this, "....cool!", 0.2f).get(0));
		roots.add(BChar.buildString(this, "..so..now..", 0.2f).get(0));
		roots.add(BChar.buildString(this, "...you..can...", 0.2f).get(0));
		roots.add(BChar.buildString(this, "....compile...", 0.2f).get(0));
		roots.add(BChar.buildString(this, "...sketches", 0.2f).get(0));
		roots.add(BChar.buildString(this, "....without..", 0.2f).get(0));
		roots.add(BChar.buildString(this, "...processing...", 0.2f).get(0));
	}

	public void draw()
	{
		background(0);
		
		fill(255);
		noStroke();
		
		translate(width / 2.0f, height / 2.0f);
		for(int i = 0, n = roots.size(); i < n; i++)
		{
			BChar root = roots.get(i);
			pushMatrix();
			rotateX(0.5f);
			rotate((float)i / n * TWO_PI);
			root.rot = (mouseX - width/2.0f) / width * TWO_PI / 5.0f;
			root.render(g);
			popMatrix();
		}
	}
}