package project_16x16.particleSystem.emissions;

import processing.core.PVector;

/**
 * AreaEmission
 * <p>
 * Emits particles in a random direction
 *
 * @author petturtle
 */
public class AreaEmission extends ParticleEmission {
	/**
     * Create a new AreaEmission.

     * @param position 	   PVector position, set to a active entities PVector for the particle system to follow
     * @param velocity     Start velocity of particle in random direction;
     * @param acceleration Start acceleration of particle in random direction;
     * @param spread	   Deviation from spawn position
     */
	public AreaEmission(PVector position, float velocity, float acceleration, float spread) {
		super(position, velocity, acceleration, spread);
	}
	
	public void generateNew() {
		float phi = (float) (2*Math.PI*Math.random());
		newParameters(phi);
	}
	

	@Override
	public ParticleEmission copy() {
		return new AreaEmission(position, velocity, acceleration, spread);
	}
} 
