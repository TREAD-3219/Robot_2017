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
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.turntable.turnDirection(Turntable.TURNTABLE_FORWARD);
		startAngle = Robot.turntable.getAngle();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (Math.abs(Robot.turntable.getAngle() - startAngle) > 180) {
			Robot.turntable.turnDirection(Turntable.TURNTABLE_BACKWARD);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
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
