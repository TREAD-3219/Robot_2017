package org.usfirst.frc3219.TREAD.commands;

import org.usfirst.frc3219.TREAD.Robot;
import org.usfirst.frc3219.TREAD.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SensorWatch extends Command {

	public SensorWatch() {
		requires(Robot.sensors);
	}

	@Override
	protected void initialize() {
		RobotMap.rightDriveEncoder.reset();
		RobotMap.leftDriveEncoder.reset();
	}

	@Override
	protected void execute() {
		SmartDashboard.putBoolean("SHOOTER TARGET VISIBLE", Robot.sensors.shooterTargetIsVisible());
		SmartDashboard.putBoolean("GEAR TARGET VISIBLE", Robot.sensors.gearTargetIsVisible());
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

}
