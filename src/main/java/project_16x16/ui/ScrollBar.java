package project_16x16.ui;

import processing.event.MouseEvent;

public interface ScrollBar extends Ui {
	public void setAnchor(Anchor anchor);
	public void setBarRatio(float value);
	public void mouseWheel(MouseEvent event);
	
}
