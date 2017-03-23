package org.usfirst.frc3219.TREAD.commands;

import org.usfirst.frc3219.TREAD.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Climb extends Command {

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.climber.stopMotors();
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.climber.startMotors();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		end();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
