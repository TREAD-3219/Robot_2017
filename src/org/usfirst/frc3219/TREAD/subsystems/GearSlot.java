package org.usfirst.frc3219.TREAD.subsystems;

/*
 * This class contains methods for using the gear flap solenoids
 */

import org.usfirst.frc3219.TREAD.RobotMap;
import org.usfirst.frc3219.TREAD.commands.GearPiston;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearSlot extends Subsystem {
	//solenoid for changing position
	private Solenoid piston;
	//current position of flaps
	private boolean position = false;
	
	@Override
	protected void initDefaultCommand() {
		piston = RobotMap.gearPiston;
		position = piston.get();
		//this.setDefaultCommand(new GearPiston(false));
	}
	
	//toggles the position of the gear flaps
	public void changePosition() {
		position = !position;
		piston.set(position);
	}
	
	//sets the position of the gearflaps
	public void setPosition(boolean pos) {
		if (position != pos) {
			piston.set(pos);
			position = pos;
		}
	}
	
	public static void initializeMotors() {
		RobotMap.gearPiston = new Solenoid(RobotMap.GEAR_SOLENOID_INDEX);
	}

}
