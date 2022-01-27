package com.lews.patterns.command;

public class MeltingCommand extends Command {

	public MeltingCommand(ManufacturingUtils utils) {
		super(utils);
	}
	@Override
	public void execute() {
		getUtils().meltingProcessOn();
	}

}
