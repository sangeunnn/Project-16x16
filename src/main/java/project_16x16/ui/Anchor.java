package project_16x16.ui;

import processing.core.PApplet;
import project_16x16.SideScroller;


public class Anchor {
	
	/**
	 * SeonU
	 * Refactoring
	 * 
	 * public to private
	**/
	// position respect to anchor type
	private int localX = 0; 
	private int localY = 0;

	private int localWidth = 0;
	private int localHeight = 0;
	
	private AnchorOrigin anchorOrigin = AnchorOrigin.TopLeft;
	private Stretch stretch = Stretch.None;
	
	private SideScroller applet;
	private Anchor frame = null;
	
	//TODO: add rectmode support
	
	public Anchor(Anchor anchor, int x, int y, int width, int height) {
		this(anchor.getPApplet(), x, y, width, height);
		this.frame = anchor;
	}
	
	public Anchor(SideScroller applet, int x, int y, int width, int height) {
		this.applet = applet;
		this.localX = x;
		this.localY = y;
		this.localWidth = width;
		this.localHeight = height;
	}
	
	public Anchor copy() {
		Anchor anchor = new Anchor(applet, localX, localY, localWidth, localHeight);
		
		return anchor;
	}
	
	// PApplet
	
	public SideScroller getPApplet(){
		if (hasContainer())	return frame.getPApplet();
		else				return applet;
	}
	
	public void setPApplet(SideScroller applet) {
		this.applet = applet;
	}
	
	
	// Container
	
	public boolean hasContainer() {
		return frame != null;
	}
	
	public Anchor getContainer() {
		if (hasContainer()) return frame;
		else 				return null;
	}
	
	public void setContainer(Anchor anchor) {
		frame = anchor;
		applet = anchor.getPApplet();
	}
	
	// Position
	
	public int X() {
		int value = 0;
		switch(anchorOrigin)
		{
			// case Left
			case Left:  case TopLeft:  case BottomLeft:
				value = getLocalX() + frameGlobalX();
				break;
			// case Right
			case Right: case TopRight: case BottomRight:
				value = (frameGlobalWidth() + getLocalX()) + frameGlobalX();
				break;
			// case Center
			case Center:
				value = (frameGlobalWidth()/2 + getLocalX()) + frameGlobalX();
				break;
			// case Top or Bottom
			default:
				value = getLocalX() + frameGlobalX();
				break;
		}
		return value;
	}
	
	public int Y() {
		int value = 0;
		switch(anchorOrigin)
		{
			// case TOP
			case Top:    case TopLeft:    case TopRight:
				value = getLocalY() + frameGlobalY();
				break;
			// case Bottom
			case Bottom: case BottomLeft: case BottomRight:
				value = (frameGlobalHeight() + getLocalY()) + frameGlobalY();
				break;
			// case Center
			case Center:
				value = (frameGlobalHeight()/2 + getLocalY()) + frameGlobalY();
				break;
			// case Left or Right
			default:
				value = getLocalY() + frameGlobalY();
				break;
		}
		return value;
	}
	
	// Stretch
	
	public int Width() {
		int value = 0;
		switch(stretch)
		{
			case Horizontal:
				value = frameGlobalWidth() - X();
				break;
			case InverseHorizontal:
				value = X() - frameGlobalWidth();;
				break;
			case Vertical: case InverseVertical:
				value = localWidth;
				break;
			case None:
				value = localWidth;
				break;
		}
		return value;
	}
	
	public int Height() {
		int value = 0;
		switch(stretch)
		{
			case Horizontal: case InverseHorizontal:
				value = localHeight;
				break;
			case Vertical:
				value = frameGlobalHeight() - Y();
				break;
			case InverseVertical:
				value = Y() - frameGlobalHeight();
				break;
			case None:
				value = localHeight;
				break;
		}
		return value;
	}
	
	// Container Variables
	
	public int frameGlobalX() {
		if (hasContainer()) return frame.X();
		else 				return 0;
	}
	
	public int frameGlobalY() {
		if (hasContainer()) return frame.Y();
		else 				return 0;
	}
	
	public int frameGlobalWidth() {
		if (hasContainer()) return frame.Width();
		else 				return applet.width;
	}
	
	public int frameGlobalHeight() {
		if (hasContainer()) return frame.Height();
		else				return applet.height;
	}
	
	// is mouse over anchor
	public boolean hover() {
		return(applet.mouseX > X() && applet.mouseX < X() + Width() 
		    && applet.mouseY > Y() && applet.mouseY < Y() + Height());
	}
	
	public void debugMode() {
		applet.stroke(255,0,0);
		applet.noFill();
		applet.rectMode(PApplet.CORNER);
		applet.rect(X(), Y(), Width(), Height());
		applet.rectMode(PApplet.CENTER);
	}
	
	public AnchorOrigin getAnchorOrigin() {
		return anchorOrigin;
	}

	public void setAnchorOrigin(AnchorOrigin anchorOrigin) {
		this.anchorOrigin = anchorOrigin;
	}
	
	public int getLocalHeight() {
		return localHeight;
	}

	public void setLocalHeight(int localHeight) {
		this.localHeight = localHeight;
	}

	public int getLocalWidth() {
		return localWidth;
	}

	public void setLocalWidth(int localWidth) {
		this.localWidth = localWidth;
	}

	public int getLocalX() {
		return localX;
	}

	public void setLocalX(int localX) {
		this.localX = localX;
	}

	public int getLocalY() {
		return localY;
	}

	public void setLocalY(int localY) {
		this.localY = localY;
	}

	public Stretch getStretch() {
		return stretch;
	}

	public void setStretch(Stretch stretch) {
		this.stretch = stretch;
	}

	
}