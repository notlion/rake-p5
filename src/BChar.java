import java.util.*;
import processing.core.*;

public class BChar
{
	public BChar parent;
	public ArrayList<BChar> children;
	
	public float rot;
	public float kerning = 0.8f;
	
	public String txt;
	public float txtSize = 100;
	
	
	public BChar(String txt, float rot)
	{
		children = new ArrayList<BChar>();
		
		this.setText(txt);
		this.rot = rot;
	}
	
	public void setText(String txt)
	{
		this.txt = txt;
	}
	
	
	public void render(PGraphics g)
	{
		if(parent != null)
			rot = PApplet.lerp(rot, parent.rot, 0.25f);
		
		g.rotate(rot);
		g.textSize(txtSize);
		g.text(txt, 0,0);
		g.translate(g.textWidth(txt) * kerning, 0);
		
		for(int i = 0; i < children.size(); i++)
			children.get(i).render(g);
	}
	
	
	public void addChild(BChar childNode)
	{
		children.add(childNode);
		childNode.parent = this;
	}
	
	public void removeChild(BChar childNode)
	{
		children.remove(childNode);
	}
	
	
	public static ArrayList<BChar> buildString(PApplet app, String str, float wander)
	{
		ArrayList<BChar> bchars = new ArrayList<BChar>(str.length());
		
		for(int i = 0, n = str.length(); i < n; i++)
		{
			bchars.add(new BChar(str.substring(i,i+1), app.random(-wander,wander)));
			if(i > 0)
				bchars.get(i-1).addChild(bchars.get(i));
		}
		
		return bchars;
	}
}