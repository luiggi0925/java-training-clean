package edu.globant.day1.designpatterns;

abstract class Texture {
	public abstract void draw();
}

class DesertTexture extends Texture {
	@Override
	public void draw() {
		System.out.println("This is a desert texture.");
	}
}

class MoonTexture extends Texture {
	@Override
	public void draw() {
		System.out.println("This is a moon texture.");
	}
}

abstract class Animal {
	public abstract void growl();
}

class Camel extends Animal {
	@Override
	public void growl() {
		System.out.println("Hey! I'm a camel.");
	}
}

class MoonWolf extends Animal {
	@Override
	public void growl() {
		System.out.println("I growwwwwwwl when looking at the Earth.");
	}
}

abstract class Plant {
	abstract public void throwSpores();
}

class Cactus extends Plant {
	@Override
	public void throwSpores() {
		System.out.println("Take my needles instead!");
	}
}

class SpatialMungus extends Plant {
	@Override
	public void throwSpores() {
		System.out.println("Galactic spores going to you");
	}
}

interface TerrainFactory {
	Texture createTexture();

	Animal createAnimal();

	Plant createPlant();
}

class DesertTerrainFactory implements TerrainFactory {
	@Override
	public Texture createTexture() {
		return new DesertTexture();
	}
	@Override
	public Animal createAnimal() {
		return new Camel();
	}
	@Override
	public Plant createPlant() {
		return new Cactus();
	}
}

class MoonTerrainFactory implements TerrainFactory {
	@Override
	public Texture createTexture() {
		return new MoonTexture();
	}
	@Override
	public Animal createAnimal() {
		return new MoonWolf();
	}
	@Override
	public Plant createPlant() {
		return new SpatialMungus();
	}
}

public class AbstractFactoryPattern {

	public static void main(String[] args) {
		playWithTerrain(new DesertTerrainFactory());
		System.out.println("------------------------------------------");
		playWithTerrain(new MoonTerrainFactory());
	}

	static void playWithTerrain(TerrainFactory factory) {
		Texture terrain = factory.createTexture();
		Animal animal = factory.createAnimal();
		Plant plant = factory.createPlant();
		terrain.draw();
		animal.growl();
		plant.throwSpores();
	}
}
