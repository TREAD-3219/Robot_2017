package org.usfirst.frc3219.TREAD.commands;

import org.usfirst.frc3219.TREAD.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class BlockerPiston extends Command {
	private boolean on;
	public BlockerPiston(boolean on) {
		requires(Robot.gearSlot);
		this.on = on;
	}
	
	@Override
	protected void initialize() {
		Robot.gearSlot.setBlockerPosition(on);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}
}
