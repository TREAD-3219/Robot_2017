package org.usfirst.frc3219.TREAD.commands.vision;

import org.usfirst.frc3219.TREAD.Robot;
import org.usfirst.frc3219.TREAD.subsystems.Sensors;
import org.usfirst.frc3219.TREAD.subsystems.Turntable;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class VisionAimSingle extends Command {
	private double goalAngle;

	public VisionAimSingle() {
		requires(Robot.sensors);
		requires(Robot.shooter);
		goalAngle = 0;
	}

	protected void initialize() {
		this.setTimeout(10);
		if (Robot.sensors.targetIsVisible()) {
			double temp = (Robot.sensors.getTargetX() - Sensors.CAMERA_WIDTH / 2.0) * Sensors.DEGREES_PER_PIXEL;
			temp *= .8;
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
			Robot.turntable.turnDirection(Turntable.TURNTABLE_BACKWARD);
		} else {
			Robot.turntable.turnDirection(Turntable.TURNTABLE_FORWARD);
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
