package org.usfirst.frc3219.TREAD.commands.shooter;

/*
 * This command runs the shooter and ballfeeder motors
 */

import org.usfirst.frc3219.TREAD.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoShoot extends Command {
	@Override
	protected void end() {
		Robot.shooter.stopMotors();
		Robot.ballfeeder.stopMotors();
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.shooter.startMotors();
		Robot.ballfeeder.startMotors();
	}

	@Override
	protected void initialize() {
		Robot.shooter.startMotors();
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
