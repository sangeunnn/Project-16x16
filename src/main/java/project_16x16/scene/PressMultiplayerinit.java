package project_16x16.scene;

import project_16x16.SideScroller;
import project_16x16.ui.Button;

public class PressMultiplayerinit implements InitButtonStrategy {
	public Button pressMultiplayer; // TODO add settings menu
	public SideScroller applet;
	@Override
	public void setinit() {
		// TODO Auto-generated method stub
		
		pressMultiplayer.setText("Multiplayer");
		pressMultiplayer.setPosition(applet.width / 2, applet.height / 2 - 80);
		pressMultiplayer.setSize(300, 100);
		pressMultiplayer.setTextSize(40);
	}

}
