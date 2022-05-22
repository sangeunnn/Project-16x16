package project_16x16.particleSystem;

import java.util.function.Consumer;

import processing.core.PVector;

/**
 * Particle Preload System
 * <p>
 * Preloads the particles position, velocity, lifespan and frameCount.
 * It only takes into account the particles spawn position, velocity and acceleration.
 * Runtime changes like collision and outside forces will not be taken into affect.
 *
 * @author petturtle
 */
public class ParticlePreloadSystem {

	public static Consumer<Particle> preload(int frames) {
		return p -> {
			p.decreaseLifespan(frames);
			p.setFrameCount(frames);
			if (!p.isDead()) {
				p.updatePosition(positionDeltaIntegral(p, frames));
				p.updateVelocity(p.getAcceleration().copy().mult(frames));
			}
		};
	}
	
	private static PVector positionDeltaIntegral(Particle p, int frames) {
		float deltaX = (float) (p.getPosition().x + p.getVelocity().x*frames + 0.5*p.getAcceleration().x*frames*frames);
		float deltaY = (float) (p.getPosition().y + p.getVelocity().y*frames + 0.5*p.getAcceleration().y*frames*frames);
		return new PVector(deltaX, deltaY);
	}
}
