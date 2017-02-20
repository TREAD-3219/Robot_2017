package org.usfirst.frc3219.TREAD.commands.shooter;

import org.usfirst.frc3219.TREAD.Robot;
import org.usfirst.frc3219.TREAD.subsystems.Turntable;

import edu.wpi.first.wpilibj.command.Command;

public class ClearMove extends Command {
	protected void initialize() {
		Robot.turntable.setZero();
	}

	protected void execute() {
		Robot.turntable.turnDirection(Turntable.TURNTABLE_FORWARD);
	}

	protected boolean isFinished() {
		return Math.abs(Robot.turntable.getAngle()) >= 1000;
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
}
