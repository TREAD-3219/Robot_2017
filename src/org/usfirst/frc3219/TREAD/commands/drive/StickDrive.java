package org.usfirst.frc3219.TREAD.commands.drive;

/*
 * This command continuously sets the joystick outputs to drive power
 */

import org.usfirst.frc3219.TREAD.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class StickDrive extends Command {
	
	Joystick driveStick = Robot.oi.leftStick;
	
	public StickDrive() {
		requires(Robot.drive);
	}
	
	@Override
	protected void end() {
		Robot.drive.stopMotors();
		
	}
	
	@Override
	protected void execute() {
		Robot.drive.tankDrive(-Robot.oi.leftStick.getY(), -Robot.oi.rightStick.getY());
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
