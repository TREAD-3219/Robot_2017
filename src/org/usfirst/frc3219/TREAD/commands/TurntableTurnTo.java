package org.usfirst.frc3219.TREAD.commands;

import org.usfirst.frc3219.TREAD.Robot;
import org.usfirst.frc3219.TREAD.subsystems.Turntable;

import edu.wpi.first.wpilibj.command.Command;

public class TurntableTurnTo extends Command {
	private double goalAngle;
	
	public TurntableTurnTo(double angle) {
		goalAngle = angle;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		if (Robot.turntable.getAngle() > goalAngle) {
			Robot.turntable.turnDirection(Turntable.TURNTABLE_FORWARD);
		} else {
			Robot.turntable.turnDirection(Turntable.TURNTABLE_BACKWARD);
		}
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (Robot.turntable.getAngle() > goalAngle) {
			Robot.turntable.turnDirection(Turntable.TURNTABLE_FORWARD);
		} else {
			Robot.turntable.turnDirection(Turntable.TURNTABLE_BACKWARD);
		}
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.turntable.turnDirection(0.0f);
	}
	
	@Override
	protected boolean isFinished() {
		return Math.abs(goalAngle - Robot.turntable.getAngle()) < 20;
	}

}
