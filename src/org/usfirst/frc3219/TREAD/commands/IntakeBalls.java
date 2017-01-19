package org.usfirst.frc3219.TREAD.commands;

import org.usfirst.frc3219.TREAD.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class IntakeBalls extends Command {

	@Override
	protected void end() {
		Robot.intake.flipperStop();
		
	}

	@Override
	protected void execute() {
		//TODO might cause lag
		Robot.intake.flipperStart();		
		
	}

	@Override
	protected void initialize() {

 
	}

	@Override
	protected void interrupted() {
		end();
		
	}

	@Override
	protected boolean isFinished() {

		return false;
	}

}
