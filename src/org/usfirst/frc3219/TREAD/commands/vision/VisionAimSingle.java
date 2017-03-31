package org.usfirst.frc3219.TREAD.commands.vision;

/*
 * This command aims the turntable at the shooting target based off of vision tracking
 */

import org.usfirst.frc3219.TREAD.Robot;
import org.usfirst.frc3219.TREAD.subsystems.Sensors;
import org.usfirst.frc3219.TREAD.subsystems.Turntable;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class VisionAimSingle extends Command {
	private double goalAngle;

	public VisionAimSingle() {
		requires(Robot.shooter);
		goalAngle = 0;
	}

	protected void initialize() {
		this.setTimeout(1.5);
		if (Robot.sensors.shooterTargetIsVisible()) {
			double temp = (Robot.sensors.getShooterTargetY() - Sensors.CAMERA_HEIGHT / 2.0) * Sensors.DEGREES_PER_PIXEL_Y;
			temp *= .5;
			if (Math.abs(temp) > 50) {
				temp = 0;
			}
			goalAngle = Robot.turntable.getAngle() + temp;
		} else {
			goalAngle = Robot.turntable.getAngle();
		}
		SmartDashboard.putNumber("dist left", Robot.turntable.getAngle() - goalAngle);
	}

	protected void execute() {
		if (Robot.turntable.getAngle() - goalAngle < 0) {
			Robot.turntable.turnDirection(Turntable.TURNTABLE_COUNTER_CLOCKWISE);
		} else {
			Robot.turntable.turnDirection(Turntable.TURNTABLE_CLOCKWISE);
		}
	}

	protected boolean isFinished() {
		return this.isTimedOut() || Math.abs(Robot.turntable.getAngle() - goalAngle) < 1;
	}

	protected void end() {
		Robot.turntable.turnDirection(0.0);
	}

	protected void interrupted() {
		end();
	}
}
