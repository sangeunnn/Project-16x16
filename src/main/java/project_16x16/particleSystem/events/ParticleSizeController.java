package project_16x16.particleSystem.events;

import project_16x16.particleSystem.Particle;

/**
 * Particle Size Controller
 * <p>
 * Change particle size over time.
 *
 * @author petturtle
 */
public class ParticleSizeController implements ParticleEventListener {

	private float startSize;
	private float endSize;
	
	/**
	 * @param startSize particle start size
	 * @param endSize   particle end size
	 */
	public ParticleSizeController(float startSize, float endSize) {
		this.setStartSize(startSize);
		this.setEndSize(endSize);
	}
	
	@Override
	public void onParticleSpawnEvent(Particle p) {
		p.setUseCustomeSize(true);
	};
	
	@Override
	public void onParticleRunEvent(Particle p) {	
		float size = p.getLifespan()/p.getMaxLifespan()*(getStartSize()-getEndSize())+getEndSize();
		p.setSize(size);
	}
	
	@Override
	public ParticleEventListener copy() {
		return new ParticleSizeController(getStartSize(), getEndSize());
	}

	public float getStartSize() {
		return startSize;
	}

	public void setStartSize(float startSize) {
		this.startSize = startSize;
	}

	public float getEndSize() {
		return endSize;
	}

	public void setEndSize(float endSize) {
		this.endSize = endSize;
	}
}
