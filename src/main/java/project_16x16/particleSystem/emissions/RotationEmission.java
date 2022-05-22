package project_16x16.particleSystem.emissions;

import processing.core.PVector;

/**
 * RotationEmission
 * <p>
 * A experimental emission (could change)
 * Emits particles in a direction which increase for each particle.
 * 0 is to the left, PI/2 is down.
 *
 * @author petturtle
 */
public class RotationEmission extends ParticleEmission {

	private float div;
	private float phi;
	
	
	/**
     * Create a new RotationEmission.

     * @param position 	   PVector position, set to a active entities PVector for the particle system to follow
     * @param velocity     Start velocity of particle in facing direction.
     * @param acceleration Start acceleration of particle in facing direction.
     * @param spread	   Deviation from spawn position
     * @param div		   Angle increase for each particle (radians)
     */
	public RotationEmission(PVector position, float velocity, float acceleration, float spread, float div) {
		super(position, velocity, acceleration, spread);
		this.div = div;
	}

	public void generateNew() {
		phi += div;
		newParameters(phi);
	}
	
	@Override
	public ParticleEmission copy() {
		return new RotationEmission(position, velocity, acceleration, spread, div);
	}
}
