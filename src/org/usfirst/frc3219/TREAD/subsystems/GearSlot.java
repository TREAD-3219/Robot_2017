package org.usfirst.frc3219.TREAD.subsystems;

/*
 * This class contains methods for using the gear flap solenoids
 */

import org.usfirst.frc3219.TREAD.RobotMap;
import org.usfirst.frc3219.TREAD.commands.GearPiston;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearSlot extends Subsystem {
	//solenoid for changing position of gear flaps
	private Solenoid piston;
	
	//solenoid for changing position of gear blocker
	private Solenoid blocker;
	
	//Defaults for solenoid
	public static final boolean GEAR_OPEN = true;
	
	//current position of solenoids
	private boolean position = false;
	
	private boolean blockPosition = false;
	
	@Override
	protected void initDefaultCommand() {
		piston = RobotMap.gearPiston;
		blocker = RobotMap.blockerPiston;
		position = piston.get();
		blockPosition = blocker.get();
	}
	
	//toggles the position of the gear flaps
	public void changePosition() {
		position = !position;
		piston.set(position);
	}
	
	//toggles the position of the gear blocker
	public void changeBlockPosition() {
		blockPosition = !blockPosition;
		blocker.set(blockPosition);
	}
	
	//sets the position of the gearflaps
	public void setPosition(boolean pos) {
		if (position != pos) {
			piston.set(pos);
			position = pos;
		}
	}
	
	//sets the position of the gear blocker
	public void setBlockerPosition(boolean pos) {
		if (blockPosition != pos) {
			blocker.set(pos);
			blockPosition = pos;
		}
	}
	
	public boolean getPosition() {
		return position;
	}
	
	public boolean getBlockerPosition() {
		return blockPosition;
	}
	
	public static void initializeMotors() {
		RobotMap.gearPiston = new Solenoid(RobotMap.GEAR_SOLENOID_INDEX);
		RobotMap.blockerPiston = new Solenoid(RobotMap.BLOCKER_SOLENOID_INDEX);
	}

}
