package com.lews.patterns.command;

public class ResetProcessesCommand extends Command {

	public ResetProcessesCommand(ManufacturingUtils utils) {
		super(utils);
	}
	@Override
	public void execute() {
		getUtils().reset();
	}

}
