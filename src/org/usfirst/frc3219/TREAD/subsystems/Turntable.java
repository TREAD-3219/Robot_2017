package org.usfirst.frc3219.TREAD.subsystems;

/*
 * This class contains methods used for moving and using the turntable of the shooter
 */

import org.usfirst.frc3219.TREAD.RobotMap;
import org.usfirst.frc3219.TREAD.commands.POV.DPad;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Turntable extends Subsystem {
	//max power of turntable, and directions
	public static final double TURNTABLE_CLOCKWISE = -.3;
	public static final double TURNTABLE_COUNTER_CLOCKWISE = .3;
	
	//encoder ratio for turntable
	public static final double DISTANCE_PER_PULSE = 12.0/240.0;
	public static final double DISTANCE_FIX_VAR = 9.0/7.0;
	
	//previously set positions for when the robot is at the airship
	public static final int RED_LEFT_POSITION = 50;
	public static final int RED_MID_POSITION = -40;
	public static final int BLUE_MID_POSITION = 45;
	public static final int BLUE_RIGHT_POSITION = -20;
	//position for the robot directly in front of the boiler
	public static final int FORWARD_POSITION = -41;
	//hardware declarations
	private Talon turntableMotor;
	private Encoder turntableEncoder;
	private DigitalInput turntableIndexSensor;

	//sets up encoders
	public void setup() {
		turntableMotor = RobotMap.turntableMotor;
		turntableEncoder = RobotMap.turntableEncoder;
		turntableEncoder.setMaxPeriod(.1);
		turntableEncoder.setMinRate(10);
		turntableEncoder.setDistancePerPulse(DISTANCE_PER_PULSE);
		turntableIndexSensor = RobotMap.turntableIndexSetter;
	}

	//turns the turntable in a given direction
	public void turnDirection(double direction) {
		turntableMotor.set(direction);
	}

	//returns the current angle of the motor
	public double getAngle() {
		double angle = turntableEncoder.getDistance();
		return angle;
	}

	//sets default command to dpad, for control of turntable
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new DPad());
		setup();
	}

	//checks if the turntable is currently at the zero index
	public boolean atZeroIndex() {
		return !turntableIndexSensor.get();
	}

	//sets the encoder's current position to zero
	public void setZero() {
		turntableEncoder.reset();
	}
	
	public static void intializeMotors() {
		RobotMap.turntableMotor = new Talon(RobotMap.TURNTABLE_PWM_INDEX);
		RobotMap.turntableEncoder = new Encoder(RobotMap.TURNTABLE_ENCODER_A, RobotMap.TURNTABLE_ENCODER_B, false, Encoder.EncodingType.k4X);
		RobotMap.turntableIndexSetter = new DigitalInput(RobotMap.TURNTABLE_LIMIT_SWITCH_INDEX);
		RobotMap.turntableEncoder.setDistancePerPulse(12.0 / 240.0);
	}
}
