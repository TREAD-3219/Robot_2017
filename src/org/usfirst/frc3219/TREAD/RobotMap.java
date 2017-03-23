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

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc3219.TREAD.subsystems.*;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */

public class RobotMap {
	//PORT NUMBER CONSTANTS
	//ENCODERS
	public static final int LEFT_DRIVE_ENCODER_A = 0;
	public static final int LEFT_DRIVE_ENCODER_B = 1;
	public static final int RIGHT_DRIVE_ENCODER_A = 2;
	public static final int RIGHT_DRIVE_ENCODER_B = 3;

	public static final int TURNTABLE_ENCODER_A = 4;
	public static final int TURNTABLE_ENCODER_B = 5;
	public static final int TURNTABLE_LIMIT_SWITCH_INDEX = 6;
	
	//PWM MOTORS
	public static final int BALL_INTAKE_PWM_INDEX = 0;
	public static final int CLIMBER_PWM_INDEX = 1;
	public static final int BALLFEED_PWM_INDEX = 2;
	public static final int TURNTABLE_PWM_INDEX = 3;
	public static final int AGITATOR_PWM_INDEX = 4;
	
	//CAN MOTORS
	public static final int LEFT_DRIVE_1_CAN_INDEX = 1;
	public static final int LEFT_DRIVE_2_CAN_INDEX = 2;
	public static final int RIGHT_DRIVE_1_CAN_INDEX = 3;
	public static final int RIGHT_DRIVE_2_CAN_INDEX = 4;
	public static final int SHOOTER_CAN_INDEX = 5;

	public static final int DRIVE_SHIFTER_INDEX = 0;
	public static final int GEAR_SOLENOID_INDEX = 1;

	// HARDWARE DECLARATIONS
	
	// Drive subsystem
	public static CANTalon leftDriveTalon1;
	public static CANTalon rightDriveTalon1;
	public static CANTalon leftDriveTalon2;
	public static CANTalon rightDriveTalon2;
	public static Solenoid shifter;
	public static Encoder rightDriveEncoder;
	public static Encoder leftDriveEncoder;
	public static RobotDrive robotDrive;

	// Turntable subsystem
	public static Spark turntableMotor;
	public static Encoder turntableEncoder;
	public static DigitalInput turntableIndexSetter;
	
	// Intake subsystem
	public static Victor ballIntakeMotor;
	
	// BallFeed subsystem
	public static Spark FeederMotor;
	
	// GearSlot subsytem
	public static Solenoid gearPiston;
	
	// Climber subsystem
	public static Victor climberMotor;
	
	// Shooter subsystem
	public static CANTalon shooterMotor;
	public static Victor Agitator;
	
	/*
	 * When the code is initialized, all motors are initialized
	 */
	public static void init() {
		//Initialize motors for each subsystem
		Drive.initializeMotors();
		
		Turntable.intializeMotors();
		
		BallIntake.initializeMotors();
		
		Ballfeeder.initializeMotors();
		
		GearSlot.initializeMotors();
		
		Climber.initializeMotors();
		
		Shooter.initializeMotors();
		
		Sensors.initializeSensors();
	}
}
