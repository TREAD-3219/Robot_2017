package org.usfirst.frc3219.TREAD.commands.ballTransport;

import org.usfirst.frc3219.TREAD.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class IntakeBalls extends Command {

	private int speed;
	public IntakeBalls(int i) {
		speed = i;
	}
	
	public IntakeBalls() {
		speed = 1;
	}

	@Override
	protected void end() {
		Robot.intake.flipperStop();
		Robot.intake.setSafety(true);
	}

	@Override
	protected void execute() {
		
		Robot.intake.flipperSpeed(speed);
		
	}

	@Override
	protected void initialize() {
		Robot.intake.setSafety(false);
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
