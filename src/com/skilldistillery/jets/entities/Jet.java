package com.skilldistillery.jets.entities;

public abstract class Jet {
	private String model;
	private double speed;
	private int range;
	private long price;

	public Jet(String model, double speed, int range, long price) {
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Jet: model = " + model + ", speed = " + speed + "mph, range = " + range + ", price = " + price + "]";
	}


	public double getSpeedInMPH() {
		return speed;
	}
	
	public void fly() {
		System.out.println(this.toString());
		String time = String.format("%.2f", (double) this.range / this.speed);
		System.out.println("Your jet can fly for " + time + " hour(s), before it runs out of fuel.");
	}
	
	public double range() {
		return (double) this.range / this.speed;
	}
	
	public String getModel() {
		return model;
	}

}
