package org.usfirst.frc3219.TREAD.subsystems;

import org.usfirst.frc3219.TREAD.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem{
	
	private double shooterPower;
	
	@Override
	protected void initDefaultCommand() {
		shooterPower = 1;
	}
	
	public void setSafety(boolean enabled) {
		RobotMap.shooterMotor.setSafetyEnabled(enabled);
	}
	
	public void startShooter(){
		RobotMap.shooterMotor.set(-shooterPower);
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
	
	private final double step = 0.01;
	
	public void powerUp() {
		if (shooterPower <= 1 - step) {
			shooterPower += step;
		} else {
			shooterPower = 1;
		}
	}
	
	public void powerDown() {
		if (shooterPower >= step) {
			shooterPower -= step;
		} else {
			shooterPower = 0;
		}
	}
}