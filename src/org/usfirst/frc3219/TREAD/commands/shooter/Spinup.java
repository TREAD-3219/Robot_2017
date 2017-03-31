package org.usfirst.frc3219.TREAD.commands.shooter;

/*
 * This command spins up the shooter motors without feeding balls
 */

import org.usfirst.frc3219.TREAD.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Spinup extends Command {
	private double seconds;
	public Spinup(double seconds) {
		this.seconds = seconds;
	}
	
	@Override
	protected void initialize() {
		this.setTimeout(seconds);
	}
	
	@Override
	protected void execute() {
		Robot.shooter.startMotors();
	}
	
	@Override
	protected void interrupted() {
		end();
	}
	
	@Override
	protected void end() {
		//Robot.shooter.stopShooter();
	}

	@Override
	protected boolean isFinished() {
		return this.isTimedOut();
	}
}
