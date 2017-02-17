package org.usfirst.frc3219.TREAD.commands;

import org.usfirst.frc3219.TREAD.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class GearPiston extends Command {
	private boolean on;
	public GearPiston(boolean on) {
		requires(Robot.gearSlot);
		this.on = on;
	}
	
	@Override
	protected void initialize() {
		Robot.gearSlot.setPosition(on);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

}
