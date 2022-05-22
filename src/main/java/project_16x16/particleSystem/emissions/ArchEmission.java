package project_16x16.particleSystem.emissions;

import java.util.Random;
import processing.core.PVector;

/**
 * Arch Emission
 * <p>
 * Emits particles in an arch given min and max angles (radians).
 * 0 is to the left, PI/2 is down.
 *
 * @author petturtle
 */
public class ArchEmission extends ParticleEmission {

	private float minAngle;
	private float maxAngle;
	
	/**
     * Create a new ArchEmission.

     * @param position 	   PVector position, set to a active entities PVector for the particle system to follow
     * @param velocity     Start velocity of particle in the arch direction;
     * @param acceleration Start acceleration of particle in the arch direction;
     * @param spread	   Deviation from spawn position
     * @param minAngle	   minAngle (radians)
     * @param maxAngle	   maxAngle (radians)
     */
	public ArchEmission(PVector position, float velocity, float acceleration, float spread, float minAngle, float maxAngle) {
		super(position, velocity, acceleration, spread);
		this.minAngle = minAngle;
		this.maxAngle = maxAngle;
	}
	
	public void generateNew() {
		Random ran = new Random();
		float phi = ran.nextFloat()*(maxAngle-minAngle)+minAngle;
		newParameters(phi);
	}

	@Override
	public ParticleEmission copy() {
		return new ArchEmission(position, velocity, acceleration, spread, minAngle, maxAngle);
	}
}
