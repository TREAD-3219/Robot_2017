package org.usfirst.frc3219.TREAD.subsystems;

import org.usfirst.frc3219.TREAD.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeFlipper extends Subsystem {

	/*	
	 *	This subsystem lets devs use flipper start and stop for self explanatory stuff
	 *	also makes flipperSpeed available.
	 *	You can use the turnSpeed variable to set the speed the the from 0% to 100%.
	 *  It might make more sense to say "start/stop" then to say speed 1-0.
	 */
	
	// Variable setup
	private int turnSpeed = 100;	// In percent
	
	@Override
	protected void initDefaultCommand() {

	}
	
	public void setSafety(boolean enabled) {
		RobotMap.intakeTalon.setSafetyEnabled(enabled);
	}
	
	//Sets the speed of the flipper motor, on a scale from 0-1
	public void flipperSpeed(double speed) {
		RobotMap.intakeTalon.set(speed);
	}
	
	public void flipperStart() {
		// Starts motor
		RobotMap.intakeTalon.set(turnSpeed / 100);
	}
	
	public void flipperStop() {
		// Stops motor
		RobotMap.intakeTalon.set(0);
	}

}
