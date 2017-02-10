package org.usfirst.frc3219.TREAD.subsystems;

import org.usfirst.frc3219.TREAD.RobotMap;
import org.usfirst.frc3219.TREAD.commands.SetTurntableZero;

import edu.wpi.first.wpilibj.CANSpeedController;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Turntable extends Subsystem {
	public static final Float TURNTABLE_FORWARD = 1.0f;
	public static final Float TURNTABLE_BACKWARD = -1.0f;
	private static final double DISTANCE_PER_PULSE = 1.0 / 7200;
	CANSpeedController turntableMotor;
	Encoder turntableEncoder;
	DigitalInput turntableIndex;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public void setup() {
		this.turntableMotor = RobotMap.turntableMotor;
		this.turntableEncoder = RobotMap.turntableEncoder;
		this.turntableIndex = RobotMap.turntableIndex;
		turntableEncoder.setDistancePerPulse(DISTANCE_PER_PULSE);
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
		setDefaultCommand(new SetTurntableZero());
	}

	public boolean atZeroIndex() {
		return turntableIndex.get();
	}

	public void setZero() {
		turntableEncoder.reset();
		
	}
}
