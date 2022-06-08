package project_16x16.particleSystem.events;

import project_16x16.particleSystem.Particle;
import project_16x16.particleSystem.ParticleSystem;

/**
 * Particle NoLoop Controller
 * <p>
 * Stops particleSystem after a number of particles spawns.
 *
 * @author petturtle
 */
public class ParticleNoLoopController implements ParticleEventListener {

	private ParticleSystem particleSystem;
	private int spawnAmount;
	private int totalSpawned;
	
	/**
	 * Stops particleSystem after a number of particles spawns
	 *
	 * @param spawnAmount    stop particleSystem after number of spawns
	 */
	public ParticleNoLoopController(int spawnAmount) {
		this.setSpawnAmount(spawnAmount);
		setTotalSpawned(0);
	}
	
	public void reset() {
		getParticleSystem().setSpawn(true);
		setTotalSpawned(0);
	}
	
	@Override
	public void onCreateEvent(ParticleSystem particleSystem) {
		this.setParticleSystem(particleSystem);
	}
	
	@Override
	public void onParticleSpawnEvent(Particle particle) {
		setTotalSpawned(getTotalSpawned() + 1);
		if (getTotalSpawned() >= getSpawnAmount())
			disableSpawn();
	}

	private void disableSpawn() {
		getParticleSystem().setSpawn(false);
	}
	
	@Override
	public ParticleEventListener copy() {
		return new ParticleNoLoopController(getSpawnAmount());
	}

	public int getSpawnAmount() {
		return spawnAmount;
	}

	public void setSpawnAmount(int spawnAmount) {
		this.spawnAmount = spawnAmount;
	}

	public int getTotalSpawned() {
		return totalSpawned;
	}

	public void setTotalSpawned(int totalSpawned) {
		this.totalSpawned = totalSpawned;
	}

	public ParticleSystem getParticleSystem() {
		return particleSystem;
	}

	public void setParticleSystem(ParticleSystem particleSystem) {
		this.particleSystem = particleSystem;
	}
}
