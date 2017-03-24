package org.usfirst.frc3219.TREAD.commands.shooter;

/*
 * This command turns the turntable right for as long as it is held
 */

import org.usfirst.frc3219.TREAD.Robot;
import org.usfirst.frc3219.TREAD.subsystems.Turntable;

import edu.wpi.first.wpilibj.command.Command;

public class AimRight extends Command {
	public AimRight() {
		requires(Robot.turntable);
	}
	
	private double initialDegrees;
	
	protected void initialize() {
		Robot.turntable.turnDirection(Turntable.TURNTABLE_CLOCKWISE);
		initialDegrees = Robot.turntable.getAngle();
	}

	protected void execute() {
		Robot.turntable.turnDirection(Turntable.TURNTABLE_CLOCKWISE);
	}

	protected void end() {
		Robot.turntable.turnDirection(0.0);
	}
	
	protected void interrupted() {
		end();
	}
	
	protected boolean isFinished() {
		return Robot.turntable.getAngle() - initialDegrees < -5;
	}
}
