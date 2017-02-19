package org.usfirst.frc3219.TREAD.commands.drive;

import org.usfirst.frc3219.TREAD.OI;
import org.usfirst.frc3219.TREAD.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
		SmartDashboard.putNumber("Angle", Robot.sensors.getAngle());
		SmartDashboard.putNumber("Right Drive Dist", Robot.sensors.rightDriveDistance());
		SmartDashboard.putNumber("Left Drive Dist", Robot.sensors.leftDriveDistance());
		SmartDashboard.putNumber("Turntable", Robot.turntable.getAngle());
		SmartDashboard.putNumber("Zero", Robot.turntable.atZeroIndex() ? 1 : 0);
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
