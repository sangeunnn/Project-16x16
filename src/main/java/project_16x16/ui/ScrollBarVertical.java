package project_16x16.ui;

import project_16x16.ui.Anchor;
import processing.core.*;
import processing.event.MouseEvent;
import project_16x16.PClass;
import project_16x16.Utility;

/**
 * Horizontal ScrollBar
 */
public class ScrollBarVertical extends PClass {

	public float barLocation = 0f; // between 0-1
	
	protected Anchor container;
	protected Anchor barAnchor;
	protected boolean barSelected = false;
	
	
	public ScrollBarVertical(Anchor anchor) {
		super(anchor.getPApplet());
		setAnchor(anchor);
	}
	
	public void setAnchor(Anchor anchor){
		container = anchor;
		barAnchor = new Anchor(anchor, 0, 0, container.getLocalWidth(), container.Height()/5);
		barAnchor.setAnchorOrigin(AnchorOrigin.TopLeft);
	}
	
	public void display() {
		//Display ScrollBar
		applet.noStroke();
		applet.fill(100, 100);
		applet.rectMode(PApplet.CORNER);
		applet.rect(container.X(), container.Y(), container.Width(), container.Height());
		
		// DisplayLocationBar
		applet.fill(100);
		barAnchor.setLocalY((int) PApplet.map(barLocation, 0, 1, 0, container.Height() - barAnchor.getLocalHeight()));
		applet.rect(barAnchor.X(), barAnchor.Y(), barAnchor.Width(), barAnchor.Height());
	}
	
	public void update() {
		if (applet.mousePressEvent && container.hover()) {
			barSelected = true;
		}
		if (applet.mouseReleaseEvent) {
			barSelected = false;
		}
		if (barSelected)
		{
			barLocation = (float) PApplet.map(applet.mouseY, container.Y() + container.Height() - (barAnchor.getLocalHeight()/2), container.Y() + (barAnchor.getLocalHeight()/2), 1, 0);
			barLocation = Utility.clamp(barLocation, 0, 1);
		}
	}
	
	public void setBarRatio(float value) {
		barAnchor.setLocalHeight((int) (value * container.Height()));
	}
	
	public void mouseWheel(MouseEvent event) {
		barLocation += event.getCount() * (container.getLocalHeight() * 0.0005f); //0.1f
		barLocation = Utility.clamp(barLocation, 0, 1);
	}
}