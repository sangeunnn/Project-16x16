package project_16x16.scene;
import project_16x16.SideScroller;
import project_16x16.ui.Button;

public class PressStartinit implements InitButtonStrategy {
	
	public Button pressStart;
	public SideScroller applet;
	
	
	public void setinit() {
		// TODO Auto-generated method stub
		pressStart.setText("Start Game");
		pressStart.setPosition(applet.width / 2, applet.height / 2 - 240);
		pressStart.setSize(300, 100);
		pressStart.setTextSize(40);

	}

}
