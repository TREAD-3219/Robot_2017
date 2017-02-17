package org.usfirst.frc3219.TREAD.commands.autonomous;

import org.usfirst.frc3219.TREAD.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveTurn extends Command {
	private double goalDegrees;
	private double initialDegrees;

	public DriveTurn(int degrees) {
		goalDegrees = degrees;
	}

	@Override
	protected void end() {
		Robot.drive.setMotors(0);

	}
	double previous = 0;
	@Override
	protected void execute() {
		double speed = .7;
		if (Math.abs(previous - Robot.sensors.getAngle()) > 90) {
			goalDegrees = goalDegrees - (previous - initialDegrees);
			initialDegrees = Robot.sensors.getAngle();
		}
		if ((Robot.sensors.getAngle() - initialDegrees) > goalDegrees) {
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
	}

	@Override
	protected void interrupted() {
		end();

	}

	@Override
	protected boolean isFinished() {
		return Math.abs(Robot.sensors.getAngle() - initialDegrees) > Math.abs(goalDegrees) || this.isTimedOut();
	}
}
