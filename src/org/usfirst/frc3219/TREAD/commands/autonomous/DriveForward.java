package org.usfirst.frc3219.TREAD.commands.autonomous;

/*
 * This command drives the robot forward a given distance
 * uses a gyro to maintain direction
 */

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
		Robot.drive.runMotors(0);
	}

	@Override
	protected void execute() {
		double deltaTheta = Robot.sensors.getAngle();
		double turnSpeed = deltaTheta / 3.0;
		Robot.drive.arcadeDrive(.8, turnSpeed);

	}

	@Override
	protected void initialize() {
		this.setTimeout(2.5);
		initDist = Robot.sensors.getDriveDistance();
		Robot.drive.shift(!Drive.HIGH_GEAR);
		Robot.drive.endShift();
		Robot.sensors.NAVX.reset();
	}

	@Override
	protected void interrupted() {
		end();
	}

	@Override
	protected boolean isFinished() {
		return (Robot.sensors.getDriveDistance() - initDist) > inches || this.isTimedOut();
	}
}
