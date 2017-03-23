package org.usfirst.frc3219.TREAD.subsystems;

/*
 * This class contains methods useful to using the climber motor.
 */

import org.usfirst.frc3219.TREAD.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {
	
	public static final int CLIMBER_DIRECTION = 1;

	@Override
	protected void initDefaultCommand() {
		stopMotors();
	}
	
	public void runMotors(double speed) {
		RobotMap.climberMotor.set(speed * CLIMBER_DIRECTION);
	}

	public void startMotors() {
		RobotMap.climberMotor.set(CLIMBER_DIRECTION);
	}

	public void stopMotors() {
		RobotMap.climberMotor.set(0);
	}
	
	public static void initializeMotors() {
		RobotMap.climberMotor = new Victor(RobotMap.CLIMBER_PWM_INDEX);
	}
}
