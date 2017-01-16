package org.usfirst.frc3219.TREAD.subsystems;

import org.usfirst.frc3219.TREAD.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drive extends Subsystem {
	
	
	private RobotDrive driveSystem;
	
	
	@Override
	protected void initDefaultCommand() {
		driveSystem = new RobotDrive(RobotMap.driveTalonBL, RobotMap.driveTalonBR, RobotMap.driveTalonFL, RobotMap.driveTalonFR);		
	}
	
	
	public void driveRawValues(double forwardSpeed, double turnSpeed) {
		driveSystem.arcadeDrive(forwardSpeed, turnSpeed);		
	}
	
	public void driveStop() {
		driveSystem.arcadeDrive(0,0);
		
	}
	
	//TODO after the robot is all cadded out, do the math to tell the robot to turn in inches per second (IPS) and degrees per second (DPS)
	/*
	public void driveAdjusted(double forwardSpeed, double turnSpeed) {
		driveSystem.arcadeDrive(forwardSpeed, turnSpeedS);		
	}
	*/
	
	
	
	
}
