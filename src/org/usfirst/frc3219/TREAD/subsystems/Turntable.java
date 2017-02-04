package org.usfirst.frc3219.TREAD.subsystems;

import org.usfirst.frc3219.TREAD.RobotMap;

import edu.wpi.first.wpilibj.CANSpeedController;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Turntable extends Subsystem {
	public static final Float TURNTABLE_FORWARD = 1.0f;
	CANSpeedController turntableMotor;
	Encoder turntableEncoder;
	DigitalInput turntableIndex;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public void setup() {
		this.turntableMotor = RobotMap.turntableMotor;
		this.turntableEncoder = RobotMap.turntableEncoder;
		this.turntableIndex = RobotMap.turntableIndex;
	}

	public void turnDirection(Float direction) {
		turntableMotor.set(direction);
	}

	public double getAngle() {
		double angle = turntableEncoder.getDistance();
		return angle;
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public boolean atIndex() {
		return turntableIndex.get();
	}

	public void setZero() {
		turntableEncoder.reset();
		
	}
}
