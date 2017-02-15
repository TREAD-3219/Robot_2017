package org.usfirst.frc3219.TREAD.subystem;

import org.usfirst.frc3219.TREAD.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

	public void TurnOnMotors() {
		RobotMap.Motor.set(1);
	}

	public void TurnOffMotors() {
		RobotMap.Motor.set(0);
	}
}
