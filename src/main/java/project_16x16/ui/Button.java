package project_16x16.ui;

import project_16x16.PClass;
import project_16x16.SideScroller;
import project_16x16.Utility;

/**
 * The Press Class extends PClass A button for the player to click
 */
public class Button extends PClass implements ButtonUi{

	/**
	 * SeonU
	 * Refactoring
	 * public to private
	**/
	private int width;
	private int height;
	private int x;
	private int y;
	
	private boolean focus;
	private boolean press;
	
	private int textSize = 20;
	private String text;
	
	private boolean blocked;

	private int colorValues[];

	/**
	 * Constructor for Press
	 * 
	 * @param a Reference to Game
	 */
	public Button(SideScroller a) {
		super(a);
		text = "Press me";
		width = 0;
		height = 0;
		x = 0;
		y = 0;
		colorValues = new int[6];
		defaultColors();
	}

	/**
	 * Determins what to display for the button
	 */
	
	/**
	 * SeonU
	 * Refactoring
	 * Remove duplicate code
	 * call manDisplay -> intW(),intH()
	**/
	public void display() {
		manDisplay();
		intW();
		intH();
	}
	
	//Display with custom size
	
	public void manDisplay() { 
		applet.strokeWeight(4);
		displayColors();
		
		applet.pushMatrix();
		
		displayTextColors();
		applet.popMatrix();
	}
	
	//Only works with manDisplay
	
	public void setSize(int w, int h) {
		width = w;
		height = h;
	}

	/**
	 * Updates the button
	 */
	/**
	 * SeonU
	 * todo
	**/
	public void update() {
		press = false;
		if (applet.mousePressEvent) {
			focus = hover();
		}
		if (applet.mouseReleaseEvent) {
			if (hover()) {
				press = true;
			}
			focus = false;
		}
	}

	public void updateOnPress() {
		press = false;
		if (applet.mousePressEvent) {
			focus = hover();
		} else if (applet.mouseReleaseEvent && hover()) {
			press = true;
		}
	}

	/**
	 * SEONU
	 * todo
	 * Refactoring OR Design Pattern
	 * integrate display
	 */
	private void displayColors() {
		if (hover()) {
			applet.stroke(colorValues[2]);
			applet.fill(colorValues[3]);
		} else {
			applet.stroke(colorValues[0]);
			applet.fill(colorValues[1]);
		}
		applet.rect(x, y, width, height);
	}

	public void displayTextColors() {
		if (focus) {
			applet.fill(colorValues[5]);
		} else {
			applet.fill(colorValues[4]);
		}
		applet.textAlign(CENTER, CENTER);
		applet.textSize(textSize);
		applet.text(text, x, y);
	}

	private void  defaultColors() {
		colorValues[0] = applet.color(74, 81, 99);// When not pressed stroke
		colorValues[1] = applet.color(47, 54, 73);// When not pressed fill
		colorValues[2] = applet.color(47, 54, 73);// When pressed stroke
		colorValues[3] = applet.color(74, 81, 99);// When pressed fill
		colorValues[4] = applet.color(255);// Text color
		colorValues[5] = applet.color(255);
	}

	public void setColorsNotPress(int colorValue1, int colorValue2) {
		colorValues[0] = applet.color(colorValue1);
		colorValues[1] = applet.color(colorValue2);
	}

	public void setColorsPress(int colorValue1, int colorValue2) {
		colorValues[2] = applet.color(colorValue1);
		colorValues[3] = applet.color(colorValue2);
	}

	public void setTextColorNotPressed(int colorValue) {
		colorValues[4] = applet.color(colorValue);
	}

	public void setTextColorPressed(int colorValue) {
		colorValues[5] = applet.color(colorValue);
	}

	/**
	 * Determines if the mouse is over the button
	 * 
	 * @return response as a boolean
	 */
	public boolean hover() {
		return Utility.hoverScreen(x, y, width, height);
	}

	/**
	 * Sets the text for the button
	 * 
	 * @param txt the new text for the button
	 */
	public void setText(String txt) {
		text = txt;
	}

	public String getText() {
		return text;
	}

	// Sets size of text
	public void setTextSize(int size) {
		textSize = size;
	}
	
	/**
	 * Sets the position for the button
	 */
	public void intW() {
		width = (int) applet.textWidth(text) + 40;
	}

	public void intH() {
		height = 30;
	}

	
	/**
	 *	getter setter 
	 * 
	 */
	public void setPosition(int _x, int _y) {
		x = _x;
		y = _y;
	}
	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getW() {
		return width;
	}

	public int getH() {
		return height;
	}

	/**
	 * Determin if the button is pressed
	 * 
	 * @return response as a boolean
	 */
	public boolean event() {
		return press;
	}

	protected int getWidth() {
		return width;
	}

	protected void setWidth(int width) {
		this.width = width;
	}

	protected int getHeight() {
		return height;
	}

	protected void setHeight(int height) {
		this.height = height;
	}

	protected boolean isFocus() {
		return focus;
	}

	protected void setFocus(boolean focus) {
		this.focus = focus;
	}

	protected boolean isPress() {
		return press;
	}

	protected void setPress(boolean press) {
		this.press = press;
	}

	protected void setX(int x) {
		this.x = x;
	}

	protected void setY(int y) {
		this.y = y;
	}

	public boolean isBlocked() {
		return blocked;
	}
	
	
}