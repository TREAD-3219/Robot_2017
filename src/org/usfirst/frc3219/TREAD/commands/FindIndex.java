package org.usfirst.frc3219.TREAD.commands;

import org.usfirst.frc3219.TREAD.Robot;

import edu.wpi.first.wpilibj.command.Command;
import subsystems.Turntable;

/**
 *
 */
public class FindIndex extends Command {

	public FindIndex() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.turntable.turnDirection(Turntable.TURNTABLE_FORWARD);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Robot.turntable.atIndex();
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
