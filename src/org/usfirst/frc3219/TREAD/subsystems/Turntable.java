package org.usfirst.frc3219.TREAD.subsystems;

import org.usfirst.frc3219.TREAD.RobotMap;
import org.usfirst.frc3219.TREAD.commands.POV.DPad;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Turntable extends Subsystem {
	public static final double TURNTABLE_FORWARD = .3;
	public static final double TURNTABLE_BACKWARD = -.3;
	private Spark turntableMotor;
	private Encoder turntableEncoder;
	private DigitalInput turntableIndexSensor;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public void setup() {
		turntableMotor = RobotMap.turntableMotor;
		turntableEncoder = RobotMap.turntableEncoder;
		turntableEncoder.setMaxPeriod(.1);
		turntableEncoder.setMinRate(10);
		turntableIndexSensor = RobotMap.turntableIndexSetter;
	}

	public void turnDirection(double direction) {
		turntableMotor.set(direction);
	}

	public double getAngle() {
		double angle = turntableEncoder.getRaw();//turntableEncoder.getDistance();
		return angle;
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new DPad());
		setup();
	}

	public boolean atZeroIndex() {
		return !turntableIndexSensor.get();
	}

	public void setZero() {
		turntableEncoder.reset();
	}
	
	public static void intializeMotors() {
		RobotMap.turntableMotor = new Spark(RobotMap.TURNTABLE_PWM_INDEX);
		RobotMap.turntableEncoder = new Encoder(RobotMap.TURNTABLE_ENCODER_A, RobotMap.TURNTABLE_ENCODER_B, false, Encoder.EncodingType.k4X);
		RobotMap.turntableIndexSetter = new DigitalInput(RobotMap.TURNTABLE_DIO_INDEX);
		RobotMap.turntableEncoder.setDistancePerPulse(12.0 / 240.0);
	}
}
