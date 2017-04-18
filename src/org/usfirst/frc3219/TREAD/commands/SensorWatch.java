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
		//SmartDashboard.putNumber("Distance Driven", Robot.sensors.getDriveDistance());
		SmartDashboard.putNumber("Right distance", RobotMap.rightDriveEncoder.getDistance());
		SmartDashboard.putNumber("Left distance", RobotMap.leftDriveEncoder.getDistance());
		SmartDashboard.putNumber("Shooter Power", Robot.shooter.getCurrentPower());
		SmartDashboard.putNumber("Turntable Position", Robot.turntable.getAngle());
		
		SmartDashboard.putBoolean("Gear Flaps", Robot.gearSlot.getPosition());
		SmartDashboard.putBoolean("Blocker", Robot.gearSlot.getBlockerPosition());
		if (Robot.turntable.atZeroIndex()) Robot.turntable.setZero();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

}
