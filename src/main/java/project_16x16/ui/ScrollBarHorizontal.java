package project_16x16.ui;

import project_16x16.ui.Anchor;
import processing.core.*;
import processing.event.MouseEvent;
import project_16x16.PClass;
import project_16x16.Utility;

/**
 * Horizontal ScrollBar
 */
public class ScrollBarHorizontal extends PClass {

	private float barLocation = 0f; // between 0-1
	
	protected Anchor container;
	protected Anchor barAnchor;
	protected boolean barSelected = false;
	
	
	public ScrollBarHorizontal(Anchor anchor) {
		super(anchor.getPApplet());
		setAnchor(anchor);
	}
	
	public void setAnchor(Anchor anchor)
	{
		container = anchor;
		
		barAnchor = new Anchor(anchor, 0, 0, container.Width()/5, container.getLocalHeight());
		barAnchor.setAnchorOrigin(AnchorOrigin.TopLeft);
	}
	/**
	 * SEONU
	 * Refactoring
	 * extract Method
	 */
	public void display()
	{
		//Display ScrollBar
		displayScrollBar();
		
		// DisplayLocationBar
		displayLocationBar();
	}

	/**
	 * SEONU
	 * todo
	 * Refactoring OR Design Pattern
	 */
	private void displayLocationBar() {
		applet.fill(100);
		barAnchor.setLocalX((int) PApplet.map(barLocation, 0, 1, 0, container.Width() - barAnchor.getLocalWidth()));
		applet.rect(barAnchor.X(), barAnchor.Y(), barAnchor.Width(), barAnchor.Height());
	}

	private void displayScrollBar() {
		applet.noStroke();
		applet.fill(100, 100);
		applet.rectMode(PApplet.CORNER);
		applet.rect(container.X(), container.Y(), container.Width(), container.Height());
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
			barLocation = (float) PApplet.map(applet.mouseX, container.X() + container.Width() - (barAnchor.getLocalWidth()/2), container.X() + (barAnchor.getLocalWidth()/2), 1, 0);
			barLocation = Utility.clamp(barLocation, 0, 1);
		}
	}
	
	public void setBarRatio(float value) {
		barAnchor.setLocalWidth((int) (value * container.Width()));
	}
	
	public void mouseWheel(MouseEvent event) {
		barLocation += event.getCount() * 0.1f;
		barLocation = Utility.clamp(barLocation, 0, 1);
	}
}