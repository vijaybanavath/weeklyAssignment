package com.lews.patterns.command;

public class CoolingCommand extends Command {

	public CoolingCommand(ManufacturingUtils utils) {
		super(utils);
	}
	@Override
	public void execute() {
		getUtils().coolingProcessOn();
	}

}
