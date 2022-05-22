package project_16x16.particleSystem;

import java.util.ArrayList;
import java.util.function.Consumer;

import processing.core.PImage;
import processing.core.PVector;
import project_16x16.SideScroller;
import project_16x16.Tileset;
import project_16x16.particleSystem.emissions.*;
import project_16x16.particleSystem.events.*;

/**
 * Particle System
 * <p>
 * To create a custom emission {@link ParticleEmission} can the position, velocity and acceleration for each particle.
 * To create a custom Controller {@link ParticleEventListener} can control almost any part of the particle.
 *
 * @author petturtle
 */
public class ParticleSystem {

	public static final int FRAMERATE = 60;
	
	private SideScroller applet;
	private PImage image;
	private ParticleEmission emission;
	private ParticlesHandler particles;
	
	private ArrayList<ParticleEventListener> listeners = new ArrayList<ParticleEventListener>();
	
	private int spawnRate;
	private int spawnAmount;
	private float lifespan;
	private boolean spawn = true;

	/**
     * Create a new particle system.
     * Set emission with setEmission() for a different effect, default provided
     * 
     * @param applet 	   SideScroller
     * @param imageName    particles image name
     * @param spawnRate    How many times a second will particles be spawned
     * @param spawnAmount  How many particles will be spawned
     * @param lifespan     How long will the particle be displayed (seconds)
     */
	public ParticleSystem(SideScroller applet, String imageName, int spawnRate, int spawnAmount, float lifespan) {
		this(applet, Tileset.getTile(imageName), spawnRate, spawnAmount, lifespan);
	}
	
	/**
     * Create a new particle system.
     * Set emission with setEmission() for a different effect, default provided
     * 
     * @param applet 	   SideScroller
     * @param image        image of particle
     * @param spawnRate    How many times a second will particles be spawned
     * @param spawnAmount  How many particles will be spawned
     * @param lifespan     How long will the particle be displayed (seconds)
     */
	public ParticleSystem(SideScroller applet, PImage image, int spawnRate, int spawnAmount, float lifespan) {
		this.applet = applet;
		this.setSpawnRate(spawnRate);
		this.setSpawnAmount(spawnAmount);
		this.setLifespan(lifespan);
		this.setImage(image);
		
		setEmission(new AreaEmission(new PVector(0,0), 1, 1, 0));
		setParticles(new ParticlesHandler(this, applet));
	}
	
	public void run() {
		getParticles().run();
	}
	
	public void preLoad() {
		for(int i = 0; i < getLifespan()*FRAMERATE; i+=FRAMERATE/getSpawnRate())
			for(int k = 0; k < getSpawnAmount(); k++)
					ParticlePreloadSystem.preload(i).accept(getParticles().newParticle());
	}
	
	public ParticleSystem copy() {
		ParticleSystem copy = new ParticleSystem(applet, getImage(), getSpawnRate(), getSpawnAmount(), getLifespan());
		copy.setEmission(emission.copy());
		for(ParticleEventListener mod : listeners)
			copy.addEventListener(mod.copy());
		return copy;
	}
	
	public void setEmission(ParticleEmission emission) {
		this.emission = emission;
	}
	public ParticleEmission getEmission(){ return emission; }
	
	public Consumer<Particle> getEmissionConsumer() {
		return emission.getConsumer();
	}
	
	public void addEventListener(ParticleEventListener modifier) {
		modifier.onCreateEvent(this);
		listeners.add(modifier);
	}

	public boolean removeEventListener(ParticleEventListener modifier) {
		return listeners.remove(modifier);
	}
	
	public void onUpdateEvent() {
		listeners.forEach(l -> l.onUpdateEvent());
	}
	
	public void onParticleRunEvent(Particle particle) {
		listeners.forEach(l -> l.onParticleRunEvent(particle));
	}
	
	public void onParticleSpawnEvent(Particle particle) {
		listeners.forEach(l -> l.onParticleSpawnEvent(particle));
	}
	
	public void onParticleDeathEvent(Particle particle) {
		listeners.forEach(l -> l.onParticleDeathEvent(particle));
	}

	public float getLifespan() {
		return lifespan;
	}

	public void setLifespan(float lifespan) {
		this.lifespan = lifespan;
	}

	public boolean isSpawn() {
		return spawn;
	}

	public void setSpawn(boolean spawn) {
		this.spawn = spawn;
	}

	public int getSpawnRate() {
		return spawnRate;
	}

	public void setSpawnRate(int spawnRate) {
		this.spawnRate = spawnRate;
	}

	public PImage getImage() {
		return image;
	}

	public void setImage(PImage image) {
		this.image = image;
	}

	public int getSpawnAmount() {
		return spawnAmount;
	}

	public void setSpawnAmount(int spawnAmount) {
		this.spawnAmount = spawnAmount;
	}

	public ParticlesHandler getParticles() {
		return particles;
	}

	public void setParticles(ParticlesHandler particles) {
		this.particles = particles;
	}

	public void updateEmission(Particle p) {
		this.emission.setPosition(p.getPosition());
	}
}
