package org.usfirst.frc3219.TREAD.commands;

import org.usfirst.frc3219.TREAD.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SensorWatch extends Command {
	
	public SensorWatch() {
		requires(Robot.sensors);
	}
	
	@Override
	protected void initialize() {
		
	}
	
	@Override
	protected void execute() {
		SmartDashboard.putNumber("Angle", Robot.sensors.getAngle());
		SmartDashboard.putNumber("Right Drive Dist", Robot.sensors.rightDriveDistance());
		SmartDashboard.putNumber("Left Drive Dist", Robot.sensors.leftDriveDistance());
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

}
