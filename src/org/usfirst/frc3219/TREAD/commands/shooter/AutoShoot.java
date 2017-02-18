package org.usfirst.frc3219.TREAD.commands.shooter;

import org.usfirst.frc3219.TREAD.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoShoot extends Command {
	@Override
	protected void end() {
		Robot.shooter.stopShooter();
		Robot.ballfeeder.TurnOffMotors();
		Robot.climber.TurnOnMotors();
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initialize() {
		Robot.shooter.startShooter();
		Robot.ballfeeder.TurnOnMotors();
		Robot.climber.TurnOnMotors();
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