package com.lews.patterns.command;

public class BlendingCommand extends Command {

	public BlendingCommand(ManufacturingUtils utils) {
		super(utils);
	}
	@Override
	public void execute() {
		getUtils().blendingProcessOn();
	}

}
