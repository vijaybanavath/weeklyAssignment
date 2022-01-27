package com.lews.patterns.command;

public class MouldingCommand extends Command {

	public MouldingCommand(ManufacturingUtils utils) {
		super(utils);
	}
	@Override
	public void execute() {
		getUtils().mouldingProcessOn();
	}

}
