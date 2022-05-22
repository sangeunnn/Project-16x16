package project_16x16.particleSystem.emissions;

import java.util.Random;
import java.util.function.Consumer;

import processing.core.PVector;
import project_16x16.particleSystem.Particle;

public abstract class ParticleEmission {
	protected PVector position;
	protected float velocity;
	protected float acceleration;
	protected float spread;
	protected float angle;
	
	protected PVector newPosition;
	protected PVector newVelocity;
	protected PVector newAcceleration;
	
	protected ParticleEmission(PVector position, float velocity, float acceleration, float spread) {
		this.position = position;
		this.velocity = velocity;
		this.acceleration = acceleration;
		this.spread = spread;
	}
	
	public void setPosition(PVector position) {
		this.position = position;
	}
	
	public abstract ParticleEmission copy();

	public abstract void generateNew();
	
	public void newVelocity(float phi) {
		newVelocity = new PVector();
		newVelocity.x = (float) (velocity*Math.cos(phi));
		newVelocity.y = (float) (velocity*Math.sin(phi));
	}

	public void newAcceleration(float phi) {
		newAcceleration = new PVector();
		newAcceleration.x = (float) (acceleration*Math.cos(phi));
		newAcceleration.y = (float) (acceleration*Math.sin(phi));
	}

	public void newPosition() {
		PVector p = position.copy();
		Random ran = new Random();
		p.x += (ran.nextFloat()*spread*2f)-spread;
		p.y += (ran.nextFloat()*spread*2f)-spread;
		newPosition = p;
	}
	
	public Consumer<Particle> getConsumer() {
		return p -> {
			generateNew();
			p.setPosition(newPosition);
			p.setVelocity(newVelocity);
			p.setAcceleration(newAcceleration);
		};
	}

	public void newParameters(float phi) {
		newPosition();
		newVelocity(phi);
		newAcceleration(phi);
	}
}
