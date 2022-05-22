package project_16x16.particleSystem.events;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;
import project_16x16.Tileset;
import project_16x16.particleSystem.Particle;

/**
 * Particle Animation Controller
 * <p>
 * Add animation to particle.
 *
 * @author petturtle
 */
public class ParticleAnimationController implements ParticleEventListener {

	private ArrayList<PImage> images;
	private int rate;
	
	/**
	 * Add animation to particle
	 *
	 * @param animationName animation name
	 * @param rate 			animation speed, high value = slow speed, -1 = match life span of particle
	 */
	public ParticleAnimationController(String animationName, int rate) {
		this(Tileset.getAnimation(animationName), rate);
	}
	
	/**
	 * Add animation to particle
	 * 
	 * @param images animation ArrayList
	 * @param rate   animation speed, high value = slow speed, -1 = match life span
	 *               of particle
	 */
	public ParticleAnimationController(ArrayList<PImage> images, int rate) {
		this.setImages(images);
		this.setRate(rate);
	}
	
	@Override
	public void onParticleSpawnEvent(Particle particle) {
		setParticle(particle);
	};
	
	@Override
	public void onParticleRunEvent(Particle particle) {
		setParticle(particle);
	}
	
	
	
	@Override
	public ParticleEventListener copy() {
		return new ParticleAnimationController(getImages(), getRate());
	}
	
	private void setParticle(Particle particle) {
		if (getRate() == -1) {
			particle.setImage(getImage(particle.getMaxLifespan(), particle.getLifespan()));
		} else {
			particle.setImage(getImage(particle.getFrameCount()));
		}
	}
	
	private PImage getImage(int frameCount) {
		int id = (frameCount/getRate()) % getImages().size();
		return getImages().get(id);
	}
	
	private PImage getImage(float maxLife, float currentLife) {
		int id = (int) PApplet.map(currentLife, maxLife, 0, 0, getImages().size()-1);
		return getImages().get(id);
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public ArrayList<PImage> getImages() {
		return images;
	}

	public void setImages(ArrayList<PImage> images) {
		this.images = images;
	}
}
