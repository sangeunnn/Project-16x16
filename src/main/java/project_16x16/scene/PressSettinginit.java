package project_16x16.scene;

import project_16x16.SideScroller;
import project_16x16.ui.Button;

public class PressSettinginit implements InitButtonStrategy {
	public Button pressSettings; // TODO add settings menu
	public SideScroller applet;

	@Override
	public void setinit() {
		
		pressSettings.setText("Settings");
		pressSettings.setPosition(applet.width / 2, applet.height / 2 + 80);
		pressSettings.setSize(300, 100);
		pressSettings.setTextSize(40);
		// TODO Auto-generated method stub

	}

}
