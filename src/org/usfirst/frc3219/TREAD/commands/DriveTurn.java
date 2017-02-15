package org.usfirst.frc3219.TREAD.commands;

import org.usfirst.frc3219.TREAD.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveTurn extends Command {
	private int degrees;

	public DriveTurn(int degrees) {
		this.degrees = degrees;
	}

	@Override
	protected void end() {
		Robot.drive.setMotors(0);
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initialize() {
		Robot.drive.stickDrive(0, .5, 1);
		// TODO Auto-generated method stub
		this.setTimeout(degrees / 90);
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return this.isTimedOut();
	}
}
