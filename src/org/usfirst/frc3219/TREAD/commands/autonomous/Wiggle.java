package org.usfirst.frc3219.TREAD.commands.autonomous;

import org.usfirst.frc3219.TREAD.Robot;
import org.usfirst.frc3219.TREAD.subsystems.Drive;

import edu.wpi.first.wpilibj.command.Command;

public class Wiggle extends Command {
	private double count;
	public Wiggle() {
		requires(Robot.drive);
	}
	
	@Override
	protected void initialize() {
		this.setTimeout(3);
		count = 0;
	}
	
	@Override
	protected void execute() {
		count += 30;
		Robot.drive.arcadeDrive(0, Math.sin(count * Math.PI / 180), 1);
	}
	
	@Override
	protected void end() {
		Robot.drive.stopMotors();
	}

	@Override
	protected boolean isFinished() {
		return this.isTimedOut();
	}
	
	@Override
	protected void interrupted() {
		end();
	}
}
