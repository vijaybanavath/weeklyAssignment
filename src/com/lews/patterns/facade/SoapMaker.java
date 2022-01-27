package com.lews.patterns.facade;

import com.lews.patterns.command.BlendingCommand;
import com.lews.patterns.command.CoolingCommand;
import com.lews.patterns.command.ManufacturingUtils;
import com.lews.patterns.command.MeltingCommand;
import com.lews.patterns.command.MixingCommand;
import com.lews.patterns.command.MouldingCommand;
import com.lews.patterns.command.ResetProcessesCommand;

public class SoapMaker {
	private BlendingCommand blendingCmd;
	private CoolingCommand coolingCmd;
	private MeltingCommand meltingCmd;
	private MixingCommand mixingCmd;
	private MouldingCommand mouldingCmd;
	private ResetProcessesCommand resetCmd;
	
	public SoapMaker(BlendingCommand blendingCmd, CoolingCommand coolingCmd, MeltingCommand meltingCmd, MixingCommand mixingCmd, MouldingCommand mouldingCmd, ResetProcessesCommand resetCmd) {
		this.blendingCmd = blendingCmd;
		this.coolingCmd = coolingCmd;
		this.meltingCmd = meltingCmd;
		this.mixingCmd = mixingCmd;
		this.mouldingCmd = mouldingCmd;
		this.resetCmd = resetCmd;
	}
	
	public boolean makeSoap() {
		System.out.println("Soap Manufacturing Started");
		SoapManufacturingProcessExecutor processExecutor = new SoapManufacturingProcessExecutor(mixingCmd);
		System.out.println("Step 1 : Mixing Water and Lye and cooling down");
		processExecutor.setProcess(mixingCmd);
		processExecutor.executeProcess();
		processExecutor.setProcess(resetCmd);
		processExecutor.executeProcess();
		processExecutor.setProcess(coolingCmd);
		processExecutor.executeProcess();
		
		System.out.println("Step 2 : Melting Oils");
		processExecutor.setProcess(resetCmd);
		processExecutor.executeProcess();
		processExecutor.setProcess(meltingCmd);
		processExecutor.executeProcess();
		processExecutor.setProcess(resetCmd);
		processExecutor.executeProcess();
		processExecutor.setProcess(coolingCmd);
		processExecutor.executeProcess();
		
		System.out.println("Step 3 : Blending melted Oils with Step 1 Mixure");
		processExecutor.setProcess(resetCmd);
		processExecutor.executeProcess();
		processExecutor.setProcess(blendingCmd);
		processExecutor.executeProcess();
		
		System.out.println("Step 4 : Pour the mixure from Step 3 to mould and harden for a day");
		processExecutor.setProcess(resetCmd);
		processExecutor.executeProcess();
		processExecutor.setProcess(mouldingCmd);
		processExecutor.executeProcess();
		
		System.out.println("Soap is ready to be packed");
		
		return true;
	}

	public BlendingCommand getBlendingCmd() {
		return blendingCmd;
	}

	public void setBlendingCmd(BlendingCommand blendingCmd) {
		this.blendingCmd = blendingCmd;
	}

	public CoolingCommand getCoolingCmd() {
		return coolingCmd;
	}

	public void setCoolingCmd(CoolingCommand coolingCmd) {
		this.coolingCmd = coolingCmd;
	}

	public MeltingCommand getMeltingCmd() {
		return meltingCmd;
	}

	public void setMeltingCmd(MeltingCommand meltingCmd) {
		this.meltingCmd = meltingCmd;
	}

	public MixingCommand getMixingCmd() {
		return mixingCmd;
	}

	public void setMixingCmd(MixingCommand mixingCmd) {
		this.mixingCmd = mixingCmd;
	}

	public MouldingCommand getMouldingCmd() {
		return mouldingCmd;
	}

	public void setMouldingCmd(MouldingCommand mouldingCmd) {
		this.mouldingCmd = mouldingCmd;
	}

	public ResetProcessesCommand getResetCmd() {
		return resetCmd;
	}

	public void setResetCmd(ResetProcessesCommand resetCmd) {
		this.resetCmd = resetCmd;
	}
	
	
	

}
