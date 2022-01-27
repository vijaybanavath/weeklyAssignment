package com.lews.patterns.command;

public class MixingCommand extends Command {

	public MixingCommand(ManufacturingUtils utils) {
		super(utils);
	}
	@Override
	public void execute() {
		getUtils().mixingProcessOn();
	}

}
