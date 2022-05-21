package project_16x16.particleSystem;

import java.util.function.Consumer;

import processing.core.PImage;
import processing.core.PVector;
import project_16x16.SideScroller;

/**
 * Particle
 * <p>
 * Can change any public variable on runtime.
 *
 * @author petturtle
 */
public class Particle {

	private SideScroller applet;
	
	public PImage image;
	public PVector position;
	public PVector velocity;
	public PVector acceleration;
	
	public float size = 40; //TODO: create better way to control
	public boolean useCustomeSize = false;
	
	public float maxLifespan; // lifespan of particle when it was spawned
	public float lifespan;
	public int frameCount;
	public static final double deathLevel = 0.0;
	public static final double updateStep = 1.0;
	
	public Particle (SideScroller applet, PImage image) {
		this.applet = applet;
		this.image = image;
		frameCount = 0;
	}
	
	public void spawn(Consumer<Particle> consumer, float lifespan) {
		consumer.accept(this);
		setLifespan(lifespan);
	}
	
	public boolean isDead() {
		return lifespan <= deathLevel;
	}
	
	public void run() {
		if (!isDead()) {
			update();
			draw();
		}
	}
	
	private void update() {
		velocity.add(acceleration);
		position.add(velocity);
		lifespan -= updateStep;
		frameCount++;
	}
	
	private void draw() {
		
		applet.pushMatrix();
		applet.translate(position.x, position.y);
		if (useCustomeSize)
			applet.scale(size, size);
		
		applet.image(image, 0, 0);
		applet.noTint();
		applet.popMatrix();
	}
	
	private void setLifespan(float lifespan) {
		maxLifespan = lifespan;
		this.lifespan = lifespan;
	}
}
