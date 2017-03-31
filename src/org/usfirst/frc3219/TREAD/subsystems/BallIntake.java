package org.usfirst.frc3219.TREAD.subsystems;

/*
 * This class contains methods useful to running the ball intake motor and the agitator motor.
 */

import org.usfirst.frc3219.TREAD.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BallIntake extends Subsystem {

	/*	
	 *	This subsystem lets devs use flipper start and stop for self explanatory stuff
	 *	also makes flipperSpeed available.
	 *	You can use the turnSpeed variable to set the speed the the from 0% to 100%.
	 *  It might make more sense to say "start/stop" then to say speed 1-0.
	 */
	
	public static final int INTAKE_DIRECTION = 1;
	
	public void setSafety(boolean enabled) {
		RobotMap.ballIntakeMotor.setSafetyEnabled(enabled);
	}
	
	//Sets the speed of the flipper motor, on a scale from 0-1
	public void runMotors(double speed) {
		RobotMap.ballIntakeMotor.set(speed * INTAKE_DIRECTION);
		RobotMap.Agitator.set(speed * Ballfeeder.AGITATOR_DIRECTION);
	}
	
	public void startMotors() {
		// Starts motor
		RobotMap.ballIntakeMotor.set(INTAKE_DIRECTION);
		RobotMap.Agitator.set(Ballfeeder.AGITATOR_DIRECTION);
	}
	
	public void stopMotors() {
		// Stops motor
		RobotMap.ballIntakeMotor.set(0);
		RobotMap.Agitator.set(0);
	}
	
	public static void initializeMotors() {
		RobotMap.ballIntakeMotor = new Talon(RobotMap.BALL_INTAKE_PWM_INDEX);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
