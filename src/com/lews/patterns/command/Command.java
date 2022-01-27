package com.lews.patterns.command;

public abstract class Command {
	private ManufacturingUtils utils;
	
	public Command(ManufacturingUtils utils) {
		this.utils = utils;
	}

	public ManufacturingUtils getUtils() {
		return utils;
	}

	public abstract void execute();
	
}
