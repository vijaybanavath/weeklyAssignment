package com.lews.patterns.command;

public class ManufacturingUtils {
	
	private boolean coolerStatus;
	private boolean blenderStatus;
	private boolean mixerStatus;
	private boolean melterStatus;
	private boolean mouldingStatus;
	
	public boolean getCoolerStatus() {
		return coolerStatus;
	}
	public void setCoolerStatus(boolean coolerStatus) {
		this.coolerStatus = coolerStatus;
	}
	public boolean getBlenderStatus() {
		return blenderStatus;
	}
	public void setBlenderStatus(boolean blenderStatus) {
		this.blenderStatus = blenderStatus;
	}
	public boolean getMixerStatus() {
		return mixerStatus;
	}
	public void setMixerStatus(boolean mixerStatus) {
		this.mixerStatus = mixerStatus;
	}
	public boolean getMelterStatus() {
		return melterStatus;
	}
	public void setMelterStatus(boolean melterStatus) {
		this.melterStatus = melterStatus;
	}
	
	public void coolingProcessOn() {
		this.coolerStatus = true;
		System.out.println("Cooling Process Turned On");
	}
	
	public void mixingProcessOn() {
		this.mixerStatus = true;
		System.out.println("Mixing Process Turned On");
	}
	
	public void blendingProcessOn() {
		this.blenderStatus = true;
		System.out.println("Blending Process Turned On");
	}
	
	public void meltingProcessOn() {
		this.melterStatus = true;
		System.out.println("Melting Process Turned On");
	}
	
	public void mouldingProcessOn() {
		this.mouldingStatus = true;
		System.out.println("Moulding Process Turned On");
	}
	
	public void reset() {
		this.coolerStatus = false;
		this.blenderStatus = false;
		this.melterStatus = false;
		this.mixerStatus = false;
		this.mouldingStatus = false;
	}
	
	public boolean getMouldingStatus() {
		return mouldingStatus;
	}
	public void setMouldingStatus(boolean mouldingStatus) {
		this.mouldingStatus = mouldingStatus;
	}

}
