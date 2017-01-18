package subsystems;

import org.usfirst.frc3219.TREAD.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeFlipper extends Subsystem {

	/*	
	 *	This subsystem lets devs use flipper start and stop for self explanatory stuff
	 *	also makes flipperSpeed available.
	 *	You can use the turnSpeed variable to set the speed the the fipper
	 */
	
	// Variable setup
	double turnSpeed = 1;	
	
	@Override
	protected void initDefaultCommand() {

	}
	
	//probably won't need to use
	public void flipperSpeed(double speed) {
		// Goes from 0-1
		RobotMap.intakeTalon.set(speed);
	}
	
	public void flipperStart() {
		// Starts motor
		RobotMap.intakeTalon.set(turnSpeed);
	}
	
	public void flipperStop() {
		// Stops motor
		RobotMap.intakeTalon.set(0);
	}

}
