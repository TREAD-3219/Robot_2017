package org.usfirst.frc3219.TREAD.commands.ballTransport;

import org.usfirst.frc3219.TREAD.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Ballfeed extends Command {

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.ballfeeder.stopMotors();
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.ballfeeder.startMotors();
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
