package org.usfirst.frc3219.TREAD.commands.shooter;

/*
 * This command runs the shooter motors for as long as it is pressed
 */

import org.usfirst.frc3219.TREAD.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Shoot extends Command {

	@Override
	protected void end() {
		Robot.shooter.stopMotors();
	}

	@Override
	protected void execute() {
		Robot.shooter.startMotors();
		
	}

	@Override
	protected void initialize() {
		Robot.shooter.startMotors();
		
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
