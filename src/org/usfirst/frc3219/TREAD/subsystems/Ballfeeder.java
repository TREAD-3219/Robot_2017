package org.usfirst.frc3219.TREAD.subsystems;

import org.usfirst.frc3219.TREAD.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Ballfeeder extends Subsystem{

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	public void TurnOnMotors() {
		RobotMap.FeederMotor.set(-1);
	}

	public void TurnOffMotors() {
		RobotMap.FeederMotor.set(0);
	}
}
