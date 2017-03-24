package org.usfirst.frc3219.TREAD.commands.shooter;

/*
 * This command finds the zero index of the turntable
 */

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
	
	//Turns right for a distance, then goes back if it has not found the sensor yet
	private boolean halfChecked;
	private int count;
	protected void execute() {
		if (halfChecked) {
			Robot.turntable.turnDirection(Turntable.TURNTABLE_CLOCKWISE);
		} else {
			Robot.turntable.turnDirection(Turntable.TURNTABLE_COUNTER_CLOCKWISE);
		}
		count++;
		if (count > 30) {
			halfChecked = true;
		}
	}

	protected boolean isFinished() {
		return Robot.turntable.atZeroIndex();
	}

	protected void end() {
		Robot.turntable.turnDirection(0.0f);
		Robot.turntable.setZero();
	}

	protected void interrupted() {
		end();
	}
}
