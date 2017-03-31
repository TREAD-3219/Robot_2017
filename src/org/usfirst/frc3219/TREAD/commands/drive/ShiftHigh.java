package org.usfirst.frc3219.TREAD.commands.drive;

/*
 * This command sets the current shifting position to high
 */

import org.usfirst.frc3219.TREAD.Robot;
import org.usfirst.frc3219.TREAD.subsystems.Drive;

import edu.wpi.first.wpilibj.command.Command;

public class ShiftHigh extends Command {
	
	public ShiftHigh() {
		requires(Robot.drive);
	}
	
	@Override
	protected void initialize() {
		this.setTimeout(Drive.SHIFT_SPEED_MS);
		Robot.drive.shift(Drive.HIGH_GEAR);
	}
	
	@Override
	protected void execute() {
		
	}
	
	@Override
	protected void end() {
		Robot.drive.endShift();
	}

	@Override
	protected boolean isFinished() {
		return this.isTimedOut();
	}
	
	@Override
	protected void interrupted() {
		end();
	}

}
