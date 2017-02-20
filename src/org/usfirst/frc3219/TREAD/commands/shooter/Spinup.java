package org.usfirst.frc3219.TREAD.commands.shooter;

import org.usfirst.frc3219.TREAD.Robot;
import org.usfirst.frc3219.TREAD.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
		Robot.shooter.startShooter();
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
