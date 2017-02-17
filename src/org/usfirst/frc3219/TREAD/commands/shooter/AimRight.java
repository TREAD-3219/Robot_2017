package org.usfirst.frc3219.TREAD.commands.shooter;

import org.usfirst.frc3219.TREAD.Robot;
import org.usfirst.frc3219.TREAD.subsystems.Turntable;

import edu.wpi.first.wpilibj.command.Command;

public class AimRight extends Command {
	
	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.turntable.turnDirection(Turntable.TURNTABLE_BACKWARD);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.turntable.turnDirection(0.0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}
}
