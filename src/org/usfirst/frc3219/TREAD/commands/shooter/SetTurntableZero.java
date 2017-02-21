package org.usfirst.frc3219.TREAD.commands.shooter;

import org.usfirst.frc3219.TREAD.Robot;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc3219.TREAD.subsystems.Turntable;

/**
 *
 */
public class SetTurntableZero extends Command {

	public SetTurntableZero() {
		requires(Robot.turntable);
	}

	protected void initialize() {
		halfChecked = false;
		count = 0;
	}
	private boolean halfChecked;
	private int count;
	protected void execute() {
		if (halfChecked) {
			Robot.turntable.turnDirection(Turntable.TURNTABLE_FORWARD);
		} else {
			Robot.turntable.turnDirection(Turntable.TURNTABLE_BACKWARD);
		}
		count++;
		if (count > 30) {
			halfChecked = true;
		}
	}

	protected boolean isFinished() {
		return Robot.turntable.atZeroIndex();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.turntable.turnDirection(0.0f);
		Robot.turntable.setZero();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
