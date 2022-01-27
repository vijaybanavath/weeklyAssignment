package com.lews.patterns.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.lews.patterns.command.BlendingCommand;
import com.lews.patterns.command.CoolingCommand;
import com.lews.patterns.command.ManufacturingUtils;
import com.lews.patterns.command.MeltingCommand;
import com.lews.patterns.command.MixingCommand;
import com.lews.patterns.command.MouldingCommand;
import com.lews.patterns.command.ResetProcessesCommand;
import com.lews.patterns.facade.SoapMaker;
import com.lews.patterns.facade.SoapManufacturingProcessExecutor;

@TestInstance(Lifecycle.PER_CLASS)
class SoapManufacturingTest {
	
	private ManufacturingUtils utils;
	private BlendingCommand blendingCmd;
	private CoolingCommand coolingCmd;
	private MeltingCommand meltingCmd;
	private MixingCommand mixingCmd;
	private MouldingCommand mouldingCmd;
	private ResetProcessesCommand resetCmd;
	
	private SoapManufacturingProcessExecutor processExecutor;
	
	private SoapMaker soapMaker;
	
	@BeforeAll
	public void setUp() {
		utils = new ManufacturingUtils();
		blendingCmd = new BlendingCommand(utils);
		coolingCmd = new CoolingCommand(utils);
		meltingCmd = new MeltingCommand(utils);
		mixingCmd = new MixingCommand(utils);
		mouldingCmd = new MouldingCommand(utils);
		resetCmd = new ResetProcessesCommand(utils);
		processExecutor = new SoapManufacturingProcessExecutor(null);
	}
	
	@BeforeEach
	public void startUp() {
		soapMaker = new SoapMaker(blendingCmd, coolingCmd, meltingCmd, mixingCmd, mouldingCmd, resetCmd);
	}
	
	@AfterEach
	public void tearDown() {
		utils.reset();
	}

	@Test
	void testBlendingProcess() {
		assertNotNull(blendingCmd);
		assertNotNull(processExecutor);
		//checking blender status is "false"
		assertFalse(utils.getBlenderStatus());
		
		//turning on blender
		processExecutor.setProcess(blendingCmd);
		assertEquals(blendingCmd, processExecutor.getProcess());
		processExecutor.executeProcess();
		assertTrue(utils.getBlenderStatus());
	}
	
	@Test
	void testCoolingProcess() {
		assertNotNull(coolingCmd);
		assertNotNull(processExecutor);
		//checking cooler status is "false"
		assertFalse(utils.getCoolerStatus());
		
		//turning on cooler
		processExecutor.setProcess(coolingCmd);
		assertEquals(coolingCmd, processExecutor.getProcess());
		processExecutor.executeProcess();
		assertTrue(utils.getCoolerStatus());
	}
	
	@Test
	void testMixingProcess() {
		assertNotNull(mixingCmd);
		assertNotNull(processExecutor);
		assertFalse(utils.getMixerStatus());
		
		processExecutor.setProcess(mixingCmd);
		assertEquals(mixingCmd, processExecutor.getProcess());
		processExecutor.executeProcess();
		assertTrue(utils.getMixerStatus());
	}
	
	@Test
	void testMeltingProcess() {
		assertNotNull(meltingCmd);
		assertNotNull(processExecutor);
		assertFalse(utils.getMelterStatus());
		
		processExecutor.setProcess(meltingCmd);
		assertEquals(meltingCmd, processExecutor.getProcess());
		processExecutor.executeProcess();
		assertTrue(utils.getMelterStatus());
	}
	
	@Test
	void testMouldingProcess() {
		assertNotNull(mouldingCmd);
		assertNotNull(processExecutor);
		assertFalse(utils.getMouldingStatus());
		
		processExecutor.setProcess(mouldingCmd);
		assertEquals(mouldingCmd, processExecutor.getProcess());
		processExecutor.executeProcess();
		assertTrue(utils.getMouldingStatus());
	}
	
	@Test
	void testResetProcess() {
		assertNotNull(resetCmd);
		assertNotNull(processExecutor);
		utils.setBlenderStatus(true);
		utils.setCoolerStatus(true);
		utils.setMelterStatus(true);
		utils.setMixerStatus(true);
		utils.setMouldingStatus(true);
		assertTrue(utils.getBlenderStatus());
		assertTrue(utils.getCoolerStatus());
		assertTrue(utils.getMelterStatus());
		assertTrue(utils.getMixerStatus());
		assertTrue(utils.getMouldingStatus());
		
		processExecutor.setProcess(resetCmd);
		assertEquals(resetCmd, processExecutor.getProcess());
		processExecutor.executeProcess();
		assertFalse(utils.getBlenderStatus());
		assertFalse(utils.getCoolerStatus());
		assertFalse(utils.getMelterStatus());
		assertFalse(utils.getMixerStatus());
		assertFalse(utils.getMouldingStatus());
		
	}
	
	@Test
	public void testSoapMaker() {
		assertNotNull(blendingCmd);
		assertNotNull(coolingCmd);
		assertNotNull(meltingCmd);
		assertNotNull(mixingCmd);
		assertNotNull(mouldingCmd);
		assertNotNull(resetCmd);
		assertNotNull(soapMaker);
		
		assertTrue(soapMaker.makeSoap());
		
		
	}

}
