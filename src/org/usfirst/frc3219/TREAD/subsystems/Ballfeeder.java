package org.usfirst.frc3219.TREAD.subsystems;

/*
 * This class contains methods used for running the ball feeder motor, as well as the agitator.
 */

import org.usfirst.frc3219.TREAD.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Ballfeeder extends Subsystem {
	
	//Directions for feeder motor and agitator motor forward
	public static final int FEEDER_DIRECTION = 1;
	public static final int AGITATOR_DIRECTION = -1;
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	public void startMotors() {
		RobotMap.FeederMotor.set(FEEDER_DIRECTION);
		RobotMap.Agitator.set(AGITATOR_DIRECTION);
	}

	public void stopMotors() {
		RobotMap.FeederMotor.set(0);
		RobotMap.Agitator.set(0);
	}
	
	public static void initializeMotors() {
		RobotMap.FeederMotor = new Talon(RobotMap.BALLFEED_PWM_INDEX);
		RobotMap.Agitator = new Talon(RobotMap.AGITATOR_PWM_INDEX);
	}
}
