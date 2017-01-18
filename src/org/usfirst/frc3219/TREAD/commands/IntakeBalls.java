package org.usfirst.frc3219.TREAD.commands;

import org.usfirst.frc3219.TREAD.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class IntakeBalls extends Command {

	@Override
	protected void end() {
		
		
	}

	@Override
	protected void execute() {
		
		
	}

	@Override
	protected void initialize() {
		Robot.intake.flipperStart();
		//TODO make sure 
	}

	@Override
	protected void interrupted() {
		
		
	}

	@Override
	protected boolean isFinished() {
		
		return true;
	}

}
