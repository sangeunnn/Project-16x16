package project_16x16.particleSystem.events;

import java.util.ArrayList;

import project_16x16.particleSystem.Particle;
import project_16x16.particleSystem.ParticleSystem;

/**
 * Particle Child Controller
 * <p>
 * A experimental Controller (could change)
 * Spawns and runs particle system when particle lives for given time or dies.
 *
 * @author petturtle
 */
public class ParticleChildController implements ParticleEventListener {
	
	private boolean hasDelay;
	private boolean spawnOnDeath;
	private int delay;
	
	private ParticleSystem copySystem;
	private ArrayList<ParticleSystem> particleSystems;
	
	/**
	 * @param particleSystem particle system need to have a no loop controller
	 * @param delay how many frames till active
	 */
	public ParticleChildController(ParticleSystem particleSystem, int delay) {
		this.setDelay(delay);
		setHasDelay(true);
		setSpawnOnDeath(false);
		setCopySystem(particleSystem);
		setParticleSystems(new ArrayList<ParticleSystem>());
	}
	
	/**
	 * @param particleSystem particle system need to have a no loop controller
	 * @param delay how many frames till active
	 * @param spawnOnDeath active when particle dies
	 */
	public ParticleChildController(ParticleSystem particleSystem, int delay, boolean spawnOnDeath) {
		this.setDelay(delay);
		this.setSpawnOnDeath(spawnOnDeath);
		setHasDelay(true);
		setCopySystem(particleSystem);
		setParticleSystems(new ArrayList<ParticleSystem>());
	}
	
	/**
	 * @param particleSystem particle system need to have a no loop controller
	 * @param spawnOnDeath active when particle dies
	 */
	public ParticleChildController(ParticleSystem particleSystem, boolean spawnOnDeath) {
		this.setSpawnOnDeath(spawnOnDeath);
		setHasDelay(false);
		setDelay(0);
		setCopySystem(particleSystem);
		setParticleSystems(new ArrayList<ParticleSystem>());
	}
	
	@Override
	public void onUpdateEvent() {
		ArrayList<ParticleSystem> temp = new ArrayList<ParticleSystem>();
		for(ParticleSystem particleSystem : getParticleSystems()) {
			particleSystem.run();
			if (!particleSystem.isSpawn() && !particleSystem.getParticles().hasActiveParticles())
				temp.add(particleSystem);
		}
		getParticleSystems().removeAll(temp);
	}
	
	@Override
	public void onParticleRunEvent(Particle particle) {
		if (hasDelay() && particle.getFrameCount() == getDelay())
			newChild(particle);
	}
	
	@Override
	public void onParticleDeathEvent(Particle particle) {
		if (isSpawnOnDeath())
			newChild(particle);
	}
	
	@Override
	public ParticleEventListener copy() {
		return new ParticleChildController(getCopySystem().copy(), getDelay());
	}
	
	private void newChild(Particle p) {
		ParticleSystem newSystem = getCopySystem().copy();
		newSystem.updateEmission(p);
		getParticleSystems().add(newSystem);
	}

	public boolean hasDelay() {
		return hasDelay;
	}

	public void setHasDelay(boolean hasDelay) {
		this.hasDelay = hasDelay;
	}

	public boolean isSpawnOnDeath() {
		return spawnOnDeath;
	}

	public void setSpawnOnDeath(boolean spawnOnDeath) {
		this.spawnOnDeath = spawnOnDeath;
	}

	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	public ParticleSystem getCopySystem() {
		return copySystem;
	}

	public void setCopySystem(ParticleSystem copySystem) {
		this.copySystem = copySystem;
	}

	public ArrayList<ParticleSystem> getParticleSystems() {
		return particleSystems;
	}

	public void setParticleSystems(ArrayList<ParticleSystem> particleSystems) {
		this.particleSystems = particleSystems;
	}
}
