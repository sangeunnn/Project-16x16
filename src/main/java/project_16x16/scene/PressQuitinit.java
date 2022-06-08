package project_16x16.scene;

import project_16x16.SideScroller;
import project_16x16.ui.Button;

public class PressQuitinit implements InitButtonStrategy {
	public Button pressQuit;
	public SideScroller applet;

	@Override
	public void setinit() {
		// TODO Auto-generated method stub
		pressQuit.setText("Quit Game");
		pressQuit.setPosition(applet.width / 2, applet.height / 2 + 240);
		pressQuit.setSize(300, 100);
		pressQuit.setTextSize(40);
	}

}
