package org.usfirst.frc3219.TREAD.subsystems;

import org.usfirst.frc3219.TREAD.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {
	
	public static final int CLIMBER_DIRECTION = -1;

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		TurnOffMotors();
	}
	
	public void setMotors(double speed) {
		RobotMap.climberMotor.set(CLIMBER_DIRECTION * speed);
	}

	public void TurnOnMotors() {
		RobotMap.climberMotor.set(CLIMBER_DIRECTION);
	}

	public void TurnOffMotors() {
		RobotMap.climberMotor.set(0);
	}
	
	public static void initializeMotors() {
		RobotMap.climberMotor = new Talon(RobotMap.CLIMBER_PWM_INDEX);
	}
}
