package org.usfirst.frc3219.TREAD.commands.autonomous;

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
		Robot.drive.setMotors(0);

	}
	double previous = 0;
	double tempDegrees = 0;
	@Override
	protected void execute() {
		double speed = .7;
		if (Math.abs(previous - Robot.sensors.getAngle()) > 90) {
			SmartDashboard.putNumber("diff", previous - initialDegrees);
			tempDegrees = tempDegrees - (initialDegrees - previous);
			initialDegrees = Robot.sensors.getAngle();
		}
		SmartDashboard.putNumber("Goal Degrees", tempDegrees);
		SmartDashboard.putNumber("initial Degrees", initialDegrees);
		SmartDashboard.putNumber("Distance", Robot.sensors.getAngle() - initialDegrees);
		if ((Robot.sensors.getAngle() - initialDegrees) < tempDegrees) {
			speed *= -1;
		}
		Robot.drive.stickDrive(0, speed, 1);
		previous = Robot.sensors.getAngle();
	}

	@Override
	protected void initialize() {
		Robot.drive.stickDrive(0, .5, 1);
		this.setTimeout(7);
		initialDegrees = Robot.sensors.getAngle();
		previous = Robot.sensors.getAngle();
		SmartDashboard.putNumber("Goal Degrees", goalDegrees);
		SmartDashboard.putNumber("initial Degrees", initialDegrees);
		SmartDashboard.putNumber("Distance", Robot.sensors.getAngle() - initialDegrees);
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
