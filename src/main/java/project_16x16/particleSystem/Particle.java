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
	
	private PImage image;
	private PVector position;
	private PVector velocity;
	private PVector acceleration;
	
	private float size = 40; //TODO: create better way to control
	private boolean useCustomeSize = false;
	
	private float maxLifespan; // lifespan of particle when it was spawned
	private float lifespan;
	private int frameCount;
	private static final float deathLevel = (float) 0.0;
	private static final float updateStep = (float) 1.0;
	
	public Particle (SideScroller applet, PImage image) {
		this.applet = applet;
		this.setImage(image);
		setFrameCount(0);
	}
	
	public void spawn(Consumer<Particle> consumer, float lifespan) {
		consumer.accept(this);
		setLifespan(lifespan);
		setMaxLifespan(lifespan);
	}
	
	public boolean isDead() {
		return getLifespan() <= deathLevel;
	}
	
	public void run() {
		if (!isDead()) {
			update();
			draw();
		}
	}
	
	private void update() {
		updateVelocity(getAcceleration());
		updatePosition(getVelocity());
		decreaseLifespan(updateStep);
		setFrameCount(getFrameCount() + 1);
	}
	
	private void draw() {
		
		applet.pushMatrix();
		applet.translate(getPosition().x, getPosition().y);
		if (isUseCustomeSize())
			applet.scale(getSize(), getSize());
		
		applet.image(getImage(), 0, 0);
		applet.noTint();
		applet.popMatrix();
	}
	
	public void setLifespan(float lifespan) {
		this.lifespan = lifespan;
	}
	
	public void decreaseLifespan(float step) {
		this.lifespan -= step;
	}
	
	public float getLifespan() {
		return lifespan;
	}

	public PVector getVelocity() {
		return velocity;
	}

	public void setVelocity(PVector velocity) {
		this.velocity = velocity;
	}

	public void updateVelocity(PVector vector) {
		this.velocity.add(vector);
	}

	public PVector getPosition() {
		return position;
	}

	public void setPosition(PVector position) {
		this.position = position;
	}

	public void updatePosition(PVector vector) {
		this.position.add(vector);
	}

	public float getMaxLifespan() {
		return maxLifespan;
	}

	public void setMaxLifespan(float maxLifespan) {
		this.maxLifespan = maxLifespan;
	}

	public PVector getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(PVector acceleration) {
		this.acceleration = acceleration;
	}
	
	public void updateAcceleration(PVector vector) {
		this.acceleration.add(vector);
	}

	public int getFrameCount() {
		return frameCount;
	}

	public void setFrameCount(int frameCount) {
		this.frameCount = frameCount;
	}

	public boolean isUseCustomeSize() {
		return useCustomeSize;
	}

	public void setUseCustomeSize(boolean useCustomeSize) {
		this.useCustomeSize = useCustomeSize;
	}

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public PImage getImage() {
		return image;
	}

	public void setImage(PImage image) {
		this.image = image;
	}
}
