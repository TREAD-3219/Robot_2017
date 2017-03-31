package org.usfirst.frc3219.TREAD.subsystems;

/*
 * This class contains methods used for running the shooter motor
 */

import org.usfirst.frc3219.TREAD.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {

	//default shooter power, currently 66%
	public static final double SHOOTER_DEFAULT_POWER = 0.66;
	
	//current power of the shooter
	private double shooterPower;
	
	@Override
	protected void initDefaultCommand() {
		shooterPower = SHOOTER_DEFAULT_POWER;
	}
	
	public void setSafety(boolean enabled) {
		RobotMap.shooterMotor.setSafetyEnabled(enabled);
	}
	
	//runs shooter at current power
	public void startMotors(){
		RobotMap.shooterMotor.set(-shooterPower);
	}

	public void stopMotors(){
		RobotMap.shooterMotor.set(0);
	}

	public void runMotors(double speed){
		RobotMap.shooterMotor.set(speed);
	}
	
	public static void initializeMotors() {
		RobotMap.shooterMotor = new CANTalon(RobotMap.SHOOTER_CAN_INDEX); 
	}
	
	//returns the current power of the shooter
	public double getCurrentPower() {
		return shooterPower;
	}
	
	//step size for incrementing/decrementing power.
	private final double step = 0.01;
	
	//increases the power of the shooter
	public void powerUp() {
		if (shooterPower <= 1 - step) {
			shooterPower += step;
		} else {
			shooterPower = 1;
		}
	}
	
	//decreases the power of the shooter
	public void powerDown() {
		if (shooterPower >= step) {
			shooterPower -= step;
		} else {
			shooterPower = 0;
		}
	}

	//sets the shooter power to default
	public void resetPower() {
		shooterPower = SHOOTER_DEFAULT_POWER;
	}
}