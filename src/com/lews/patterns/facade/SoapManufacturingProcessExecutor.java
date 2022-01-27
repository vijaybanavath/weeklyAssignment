package com.lews.patterns.facade;

import com.lews.patterns.command.Command;

public class SoapManufacturingProcessExecutor {
	private Command manufactoringProcess;
	public SoapManufacturingProcessExecutor(Command process) {
		this.manufactoringProcess = process;
	}
	public void executeProcess() {
		this.manufactoringProcess.execute();
	}
	public void setProcess(Command process) {
		this.manufactoringProcess = process;
	}
	public Command getProcess() {
		return this.manufactoringProcess;
	}

}
