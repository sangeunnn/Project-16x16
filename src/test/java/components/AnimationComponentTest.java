import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import processing.core.PImage;
import project_16x16.SideScroller;
import project_16x16.components.AnimationComponent;

public class AnimationComponentTest {
    @Test
    public void assignAppletTest() {
        SideScroller applet;
        AnimationComponent testComponent = new AnimationComponent();
        testComponent.assignApplet(applet);
        assertEquals(applet, testComponent.getApplete());
    }

    @Test
    public void setFramesTest() {
        ArrayList<PImage> array[];
        AnimationComponent testComponent = new AnimationComponent();
        for (int i 0; i <4 ;i++){ 
            array.add(new PImage());
        }
        testComponent.setFrames(array);
        assertSame(array, testComponent.getFrames());

    }

    @Test
    public void setFrameNotIfTest() {
        ArrayList<PImage> array[];
        AnimationComponent testComponent = new AnimationComponent();
        for (int i 0; i <4 ;i++){ 
            array.add(new PImage());
        }
        testComponent.setFrames(array);
        int prev = testComponent.getFrameID();
        testComponent.setFrame(5);
        assertEquals(prev,testComponent.getFrameId());

    }

    @Test
    public void setFrameTest() {
        int expected = 2;
        AnimationComponent testComponent = new AnimationComponent();
        ArrayList<PImage> array[];
        for (int i 0; i <4 ;i++){ 
            array.add(new PImage());
        }
        testComponent.setFrames(array);
        assertEquals(expected,testComponent.getFrameId());
    }

    @Test
    public void getFrame() {
        AnimationComponent testComponent = new AnimationComponent();
        int expected = 2;
        ArrayList<PImage> array[];
        for (int i 0; i <4 ;i++){ 
            array.add(new PImage());
        }
        testComponent.setFrames(array);
        testComponent.setFrame(2.0);
        
        assertEquals(array.get(expected),testComponent.getFrameID());
    }

    @Test
    public void testGetFrameID() {
        AnimationComponent testComponent = new AnimationComponent();
        int expected = 2;
        testComponent.setFrame(2.0);
        assertEquals(expected, testComponent.getFrameID());
    }
}
