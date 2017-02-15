package org.usfirst.frc3219.TREAD.commands.shooter;

import org.usfirst.frc3219.TREAD.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Shoot extends Command {

	@Override
	protected void end() {
		Robot.shooter.stopShooter();
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initialize() {
		Robot.shooter.startShooter();
		
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
