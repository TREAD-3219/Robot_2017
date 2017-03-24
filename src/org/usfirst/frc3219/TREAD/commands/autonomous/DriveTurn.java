package org.usfirst.frc3219.TREAD.commands.autonomous;

/*
 * This command turns a set number of degrees using a gyro
 */

import org.usfirst.frc3219.TREAD.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTurn extends Command {
	private double goalDegrees;
	private double initialDegrees;

	public DriveTurn(int degrees) {
		goalDegrees = degrees;
		initialDegrees = 0;
	}

	@Override
	protected void end() {
		Robot.drive.runMotors(0);

	}
	
	//the math in this method is to ensure that if the robot goes from 180 to -180 it continues the same number of degrees
	double previous = 0;
	double tempDegrees = 0;
	
	@Override
	protected void execute() {
		//maximum speed
		double speed = .7;
		//check if the angle has suddenly changed drastically
		if (Math.abs(previous - Robot.sensors.getAngle()) > 90) {
			//reset the degrees to be based on the new angle
			tempDegrees = tempDegrees - (initialDegrees - previous);
			initialDegrees = Robot.sensors.getAngle();
		}
		//choose direction of turn
		if ((Robot.sensors.getAngle() - initialDegrees) < tempDegrees) {
			speed *= -1;
		}
		
		Robot.drive.arcadeDrive(0, speed);
		previous = Robot.sensors.getAngle();
	}

	@Override
	protected void initialize() {
		Robot.drive.arcadeDrive(0, .5);
		this.setTimeout(2.5);
		initialDegrees = Robot.sensors.getAngle();
		previous = Robot.sensors.getAngle();
		tempDegrees = goalDegrees;
	}

	@Override
	protected void interrupted() {
		end();

	}

	@Override
	protected boolean isFinished() {
		return Math.abs(Robot.sensors.getAngle() - initialDegrees) > Math.abs(tempDegrees) || this.isTimedOut();
	}
}
