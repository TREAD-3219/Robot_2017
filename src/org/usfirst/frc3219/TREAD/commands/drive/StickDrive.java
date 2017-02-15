package org.usfirst.frc3219.TREAD.commands.drive;

import org.usfirst.frc3219.TREAD.OI;
import org.usfirst.frc3219.TREAD.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class StickDrive extends Command {
	
	Joystick driveStick = Robot.oi.stick;
	
	public StickDrive() {
		requires(Robot.drive);
	}
	
	@Override
	protected void end() {
		Robot.drive.stopMotors();
		
	}
	
	@Override
	protected void execute() {
		Robot.drive.stickDrive(driveStick.getY(), driveStick.getX(), driveStick.getThrottle());
	}

	@Override
	protected void initialize() {
		
		
	}

	@Override
	protected void interrupted() {
		
		
	}

	@Override
	protected boolean isFinished() {
		
		return false;
	}

}
