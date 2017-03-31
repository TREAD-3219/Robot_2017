package org.usfirst.frc3219.TREAD.commands.shooter;

/*
 * This command turns the turntable to a given position
 */

import org.usfirst.frc3219.TREAD.Robot;
import org.usfirst.frc3219.TREAD.subsystems.Turntable;

import edu.wpi.first.wpilibj.command.Command;

public class TurntableTurnTo extends Command {
	//angle to turn towards
	private double goalAngle;
	
	public TurntableTurnTo(double angle) {
		goalAngle = angle - (10 * angle / Math.abs(angle));
	}

	@Override
	protected void initialize() {
		if (goalAngle > 0) {
			Robot.turntable.turnDirection(Turntable.TURNTABLE_COUNTER_CLOCKWISE);
		} else {
			Robot.turntable.turnDirection(Turntable.TURNTABLE_CLOCKWISE);
		}
	}

	@Override
	protected void execute() {
		//set direction of motion based on current position
		if (goalAngle > 0) {
			Robot.turntable.turnDirection(Turntable.TURNTABLE_COUNTER_CLOCKWISE);
		} else {
			Robot.turntable.turnDirection(Turntable.TURNTABLE_CLOCKWISE);
		}
	}

	@Override
	protected void end() {
		Robot.turntable.turnDirection(0.0);
	}
	
	//stop if goalangle is reached
	@Override
	protected boolean isFinished() {
		if (goalAngle < 0) {
			return Robot.turntable.getAngle() < goalAngle;
		} else {
			return Math.abs(Robot.turntable.getAngle()) > goalAngle;
		}
		
	}

}
