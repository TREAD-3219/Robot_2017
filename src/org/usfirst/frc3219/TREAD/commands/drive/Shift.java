package org.usfirst.frc3219.TREAD.commands.drive;

import org.usfirst.frc3219.TREAD.Robot;
import org.usfirst.frc3219.TREAD.subsystems.Drive;

import edu.wpi.first.wpilibj.command.Command;

public class Shift extends Command {
	
	public Shift() {
		requires(Robot.drive);
	}
	
	@Override
	protected void initialize() {
		this.setTimeout(Drive.SHIFT_SPEED_MS);
		Robot.drive.shift();
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
		// TODO Auto-generated method stub
		return this.isTimedOut();
	}
	
	@Override
	protected void interrupted() {
		end();
	}

}
