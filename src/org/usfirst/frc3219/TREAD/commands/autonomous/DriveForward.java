package org.usfirst.frc3219.TREAD.commands.autonomous;

import org.usfirst.frc3219.TREAD.Robot;
import org.usfirst.frc3219.TREAD.subsystems.Drive;

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
		double deltaTheta = Robot.sensors.getAngle();
		double turnSpeed = deltaTheta / 3.0;
		Robot.drive.stickDrive(.8, turnSpeed, 1.0);

	}

	@Override
	protected void initialize() {
		//Robot.drive.setMotors(100);
		// TODO Auto-generated method stub
		this.setTimeout(2.5);
		initDist = Robot.sensors.getDriveDistance();
		Robot.drive.shift(!Drive.HIGH_GEAR);
		Robot.drive.endShift();
		Robot.sensors.NAVX.reset();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		end();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return (Robot.sensors.getDriveDistance() - initDist) > inches || this.isTimedOut();
	}
}
