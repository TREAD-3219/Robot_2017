package org.usfirst.frc3219.TREAD.commands.shooter;

import org.usfirst.frc3219.TREAD.Robot;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc3219.TREAD.subsystems.Turntable;

/**
 *
 */
public class SetTurntableZero extends Command {

	private double startAngle;
	public SetTurntableZero() {
		requires(Robot.turntable);
	}

	protected void initialize() {
		startAngle = Robot.turntable.getAngle();
		halfChecked = false;
	}

	boolean halfChecked;
	protected void execute() {
		double direction;
		if (Robot.turntable.getAngle() > 0) {
			direction = Turntable.TURNTABLE_FORWARD;
		} else {
			direction = Turntable.TURNTABLE_BACKWARD;
		}
		
		if (Math.abs(Robot.turntable.getAngle() - startAngle) > 180 || halfChecked){
			direction *= -1;
			halfChecked = true;
		}
		Robot.turntable.turnDirection(direction);
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
	}
}
