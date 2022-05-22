package project_16x16.particleSystem;

import java.util.ArrayList;

import project_16x16.SideScroller;

/**
 * Particles
 * <p>
 * Keeps take of and runs all active and dead particles.
 * Instead of create new particles first checks if it can bring back dead particles;
 *
 * @author petturtle
 */
public class ParticlesHandler {

	private SideScroller applet;
	private ParticleSystem particleSystem;
	
	private ArrayList<Particle> activeParticles;
	private ArrayList<Particle> inactiveParticles;
	
	public ParticlesHandler(ParticleSystem particleSystem, SideScroller applet) {
		this.applet = applet;
		this.particleSystem = particleSystem;
		
		setActiveParticles(new ArrayList<Particle>());
		setInactiveParticles(new ArrayList<Particle>());
	}
	
	public void run() {
		runParticles();
		
		if (nextTick())
			spawnParticles(particleSystem.getSpawnAmount());
		
		particleSystem.onUpdateEvent();
	}
	
	public boolean hasActiveParticles() {
		return getActiveParticles().size() >= 1;
	}
	
	public Particle newParticle() {
		Particle p = new Particle(applet, particleSystem.getImage());
		p.spawn(particleSystem.getEmissionConsumer(), particleSystem.getLifespan()*ParticleSystem.FRAMERATE);
		particleSystem.onParticleSpawnEvent(p);
		getActiveParticles().add(p);
		return p;
	}
	
	private void runParticles() {
		ArrayList<Particle> deadParticles = new ArrayList<Particle>();
		for(Particle p : getActiveParticles()) {
			p.run();
			particleSystem.onParticleRunEvent(p);
			if (p.isDead()) {
				deadParticles.add(p);
				particleSystem.onParticleDeathEvent(p);
			}
		}
		getActiveParticles().removeAll(deadParticles);
		getInactiveParticles().addAll(deadParticles);
	}
	
	private void spawnParticles(int spawnAmount) {
		int amount = spawnAmount;
		amount -= loopParticles(amount);
		for(int i = 0; i < amount; i++)
			newParticle();
	}
	
	private int loopParticles(int amount) {
		ArrayList<Particle> particles = new ArrayList<Particle>();
		for(Particle particle : getInactiveParticles()) {
			if (particle.isDead()) {
				respawnParticle(particle);
				particles.add(particle);
			}
			if (particles.size() >= amount) break;
		}
		getInactiveParticles().removeAll(particles);
		getActiveParticles().addAll(particles);
		return particles.size();
	}
	
	private void respawnParticle(Particle p) {
		p.spawn(particleSystem.getEmissionConsumer(), particleSystem.getLifespan()*ParticleSystem.FRAMERATE);
		particleSystem.onParticleSpawnEvent(p);
	}
	
	private boolean nextTick() {
		return particleSystem.isSpawn() && applet.frameCount % (ParticleSystem.FRAMERATE/particleSystem.getSpawnRate()) == 0;
	}

	public ArrayList<Particle> getActiveParticles() {
		return activeParticles;
	}

	public void setActiveParticles(ArrayList<Particle> activeParticles) {
		this.activeParticles = activeParticles;
	}

	public ArrayList<Particle> getInactiveParticles() {
		return inactiveParticles;
	}

	public void setInactiveParticles(ArrayList<Particle> inactiveParticles) {
		this.inactiveParticles = inactiveParticles;
	}
}
