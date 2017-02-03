// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc3219.TREAD;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */

public class RobotMap {

	// MOTOR DELCARATIONS
	public static CANTalon driveTalonFL;
	public static CANTalon driveTalonFR;
	public static CANTalon driveTalonBL;
	public static CANTalon driveTalonBR;
	public static Solenoid shifter;
	public static Encoder driveEncoder;

    public static void init() {
    	driveTalonFL = new CANTalon(1);
    	driveTalonFR = new CANTalon(3);
    	driveTalonBL = new CANTalon(2);
    	driveTalonBR = new CANTalon(4);
    	shifter = new Solenoid(0);
		driveEncoder = new Encoder(0,1,false);
    	/*
    	driveTalonFL.disable();
    	driveTalonFR.disable();
    	driveTalonBL.disable();
    	driveTalonBR.disable();
    	*/
    }
}
