package org.usfirst.frc3219.TREAD.commands.shooter;

import org.usfirst.frc3219.TREAD.Robot;
import org.usfirst.frc3219.TREAD.subsystems.Turntable;

import edu.wpi.first.wpilibj.command.Command;

public class TurntableTurnTo extends Command {
	private double goalAngle;
	
	public TurntableTurnTo(double angle) {
		goalAngle = angle;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.turntable.turnDirection(Turntable.TURNTABLE_BACKWARD);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.turntable.turnDirection(Turntable.TURNTABLE_BACKWARD);
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.turntable.turnDirection(0.0);
	}
	
	@Override
	protected boolean isFinished() {
		return Math.abs(Robot.turntable.getAngle()) > goalAngle;
	}

}
