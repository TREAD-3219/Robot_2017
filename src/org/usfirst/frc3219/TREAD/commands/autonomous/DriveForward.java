package org.usfirst.frc3219.TREAD.commands.autonomous;

import org.usfirst.frc3219.TREAD.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveForward extends Command {
	private int inches;

	public DriveForward(int inches) {
		this.inches = inches;

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
		Robot.drive.setMotors(40);
		// TODO Auto-generated method stub
		this.setTimeout(inches / 40);
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		end();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return this.isTimedOut();
	}
}
