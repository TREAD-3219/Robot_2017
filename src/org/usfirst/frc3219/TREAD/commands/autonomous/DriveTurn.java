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
		Robot.drive.runMotors(0);

	}
	double previous = 0;
	double tempDegrees = 0;
	@Override
	protected void execute() {
		double speed = .7;
		if (Math.abs(previous - Robot.sensors.getAngle()) > 90) {
			tempDegrees = tempDegrees - (initialDegrees - previous);
			initialDegrees = Robot.sensors.getAngle();
		}
		if ((Robot.sensors.getAngle() - initialDegrees) < tempDegrees) {
			speed *= -1;
		}
		Robot.drive.arcadeDrive(0, speed, 1);
		previous = Robot.sensors.getAngle();
	}

	@Override
	protected void initialize() {
		Robot.drive.arcadeDrive(0, .5, 1);
		this.setTimeout(7);
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
