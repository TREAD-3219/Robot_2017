package org.usfirst.frc3219.TREAD.commands.autonomous;

import org.usfirst.frc3219.TREAD.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

public class DriveForward extends Command {
	private int inches;
	private double initDist;
	public DriveForward(int inches) {
		this.inches = inches;

	}

	@Override
	protected void end() {
		Robot.drive.setMotors(0);
	}

	@Override
	protected void execute() { 
		Robot.drive.setMotors(100);

	}

	@Override
	protected void initialize() {
		//Robot.drive.setMotors(100);
		// TODO Auto-generated method stub
		//this.setTimeout(inches / 120);
		initDist = Robot.sensors.getDriveDistance();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		end();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return (Robot.sensors.getDriveDistance() - initDist) > inches;
	}
}
