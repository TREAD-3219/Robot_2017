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

	}

	@Override
	protected boolean isFinished() {
		return false;
	}

}
