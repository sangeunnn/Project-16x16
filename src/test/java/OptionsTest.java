import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import java.util.prefs.Preferences;
import project_16x16.Options;

public class OptionsTest {

    @Test
    public void CallingSaveWithIntShouldUpdateOptions() {
        int expected = 5;
        Preferences options = Preferences.userNodeForPackage(Options.class);

        Options.save(Options.Option.testKey, expected);

        assertEquals(expected, options.getInt(Options.Option.testKey.toString(), 0));
    }

    @Test
    public void CallingSaveWithFloatShouldUpdateOptions() {
        float expected = 5.5f;
        Preferences options = Preferences.userNodeForPackage(Options.class);

        Options.save(Options.Option.testKey, expected);

        assertEquals(expected, options.getFloat(Options.Option.testKey.toString(), 0));
    }

    @Test
    public void CallingSaveWithBooleanShouldUpdateOptions() {
        Preferences options = Preferences.userNodeForPackage(Options.class);

        Options.save(Options.Option.testKey, true);

        assertEquals(true, options.getBoolean(Options.Option.testKey.toString(), false));
    }

}
// package components;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import org.junit.jupiter.api.Test;
// import project_16x16.components.AnimationComponent;

// public class AnimationComponentTest {

// @Test
// public void assignAppletTest() {
// SideScroller applet;
// testComponent = new AnimationComponent();
// testComponent.assignApplet(applet);
// assertEquals(applet, testComponent.getApplete());
// }
// @Test
// public void setFramesTest() {
// array = []
// testComponent = new AnimationComponent();
// for(int i=0; i<4; i++) {
// array.add(new PImage());
// }
// testComponent.setFrames(array);
// assertSame(array,testComponent.getFrames());
// }

// @Test
// public voidsetFrameTest() {
// int expected = 2;
// testComponent = new AnimationComponent();
// array = []
// for(int i=0; i<4; i++) {
// array.add(new PImage());
// }
// testComponent.setFrames(array);
// assertEquals(expected,testComponent.getFrameId());
// }

// @Test
// public void animateTest() {
// testComponent = new AnimationComponent();
// testComponent.setFrame(2.0);

// }

// }
