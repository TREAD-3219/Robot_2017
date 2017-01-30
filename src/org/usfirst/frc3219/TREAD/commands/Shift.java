package org.usfirst.frc3219.TREAD.commands;

import org.usfirst.frc3219.TREAD.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Shift extends Command {
	
	public Shift() {
		requires(Robot.drive);
	}
	
	@Override
	protected void initialize() {
		Robot.drive.shift();
	}
	
	@Override
	protected void execute() {
		
	}
	
	@Override
	protected void end() {
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	protected void interrupted() {
		end();
	}

}
