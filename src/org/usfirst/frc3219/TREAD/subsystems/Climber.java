package org.usfirst.frc3219.TREAD.subsystems;

import org.usfirst.frc3219.TREAD.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		TurnOffMotors();
	}

	public void TurnOnMotors() {
		RobotMap.climberMotor.set(-1);
	}

	public void TurnOffMotors() {
		RobotMap.climberMotor.set(0);
	}
	
	public static void initializeMotors() {
		RobotMap.climberMotor = new Talon(RobotMap.CLIMBER_PWM_INDEX);
	}
}
