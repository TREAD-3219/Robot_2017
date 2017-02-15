package org.usfirst.frc3219.TREAD.subsystems;

import org.usfirst.frc3219.TREAD.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem{

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public void setSafety(boolean enabled) {
		RobotMap.flyWheelMotor.setSafetyEnabled(enabled);
	}
	
	public void startShooter(){
		RobotMap.flyWheelMotor.set(1);
	}

	public void stopShooter(){
		RobotMap.flyWheelMotor.set(0);
	}

	public void shooter(double speed){
		RobotMap.flyWheelMotor.set(speed);
	}
}