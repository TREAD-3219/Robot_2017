package org.usfirst.frc3219.TREAD.subsystems;

import org.usfirst.frc3219.TREAD.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem{

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public void setSafety(boolean enabled) {
		RobotMap.shooterMotor.setSafetyEnabled(enabled);
	}
	
	public void startShooter(){
		RobotMap.shooterMotor.set(-1);
	}

	public void stopShooter(){
		RobotMap.shooterMotor.set(0);
	}

	public void shooter(double speed){
		RobotMap.shooterMotor.set(speed);
	}
	
	public static void initializeMotors() {
		RobotMap.shooterMotor = new CANTalon(RobotMap.SHOOTER_CAN_INDEX); 
	}
}