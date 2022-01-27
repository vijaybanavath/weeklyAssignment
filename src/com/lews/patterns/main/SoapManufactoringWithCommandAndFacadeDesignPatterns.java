package com.lews.patterns.main;

import com.lews.patterns.command.BlendingCommand;
import com.lews.patterns.command.CoolingCommand;
import com.lews.patterns.command.ManufacturingUtils;
import com.lews.patterns.command.MeltingCommand;
import com.lews.patterns.command.MixingCommand;
import com.lews.patterns.command.MouldingCommand;
import com.lews.patterns.command.ResetProcessesCommand;
import com.lews.patterns.facade.SoapMaker;

public class SoapManufactoringWithCommandAndFacadeDesignPatterns {
	
	public static void main(String[] args) {
		ManufacturingUtils utils = new ManufacturingUtils();
		BlendingCommand blendingCmd = new BlendingCommand(utils);
		CoolingCommand coolingCmd = new CoolingCommand(utils);
		MeltingCommand meltingCmd = new MeltingCommand(utils);
		MixingCommand mixingCmd = new MixingCommand(utils);
		MouldingCommand mouldingCmd = new MouldingCommand(utils);
		ResetProcessesCommand resetCmd = new ResetProcessesCommand(utils);
		
		SoapMaker soapMaker = new SoapMaker(blendingCmd, coolingCmd, meltingCmd, mixingCmd, mouldingCmd, resetCmd);
		
		
		soapMaker.makeSoap();
	}

}
