package org.usfirst.frc3219.TREAD.commands.vision;

import org.usfirst.frc3219.TREAD.Robot;
import org.usfirst.frc3219.TREAD.commands.autonomous.DriveTurn;
import org.usfirst.frc3219.TREAD.subsystems.Sensors;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GearAim extends Command {
	private static final double DIST_FROM_TARGET = 95;
	private static final double OFFSET_INCHES = 6;
	private static final double OFFSET_DEGREES = Math.atan(OFFSET_INCHES / DIST_FROM_TARGET) / (Math.PI / 180.0);

	private double goalDegrees;
	private double initialDegrees;

	public GearAim() {
		
	}

	@Override
	protected void end() {
		Robot.drive.setMotors(0);

	}
	double previous = 0;
	double tempDegrees = 0;
	@Override
	protected void execute() {
		double speed = .6;
		if (Math.abs(previous - Robot.sensors.getAngle()) > 90) {
			tempDegrees = tempDegrees - (initialDegrees - previous);
			initialDegrees = Robot.sensors.getAngle();
		}
		if ((Robot.sensors.getAngle() - initialDegrees) < tempDegrees) {
			speed *= -1;
		}
		Robot.drive.stickDrive(0, speed, 1);
		previous = Robot.sensors.getAngle();
	}

	@Override
	protected void initialize() {
		double temp = 0;
		if (Robot.sensors.gearTargetIsVisible()) {
			double x = Robot.sensors.getGearTargetX();
			temp = (x - Sensors.CAMERA_WIDTH / 2.0) * Sensors.DEGREES_PER_PIXEL;
			//temp -= OFFSET_DEGREES;
			if (Math.abs(temp) > 50) {
				temp = 0;
			}
		}
		goalDegrees = -temp;
		initialDegrees = 0;
		
		Robot.drive.stickDrive(0, .5, 1);
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
