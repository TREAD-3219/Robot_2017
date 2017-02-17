package org.usfirst.frc3219.TREAD.subsystems;

import org.usfirst.frc3219.TREAD.RobotMap;
import org.usfirst.frc3219.TREAD.commands.drive.StickDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drive extends Subsystem {

	private RobotDrive drive;
	private Solenoid shifter;
	private boolean shifting;
	private static final double SHIFTING_SCALE = 10;
	public static final double SHIFT_SPEED_MS = 100 / 1000.0;

	@Override
	protected void initDefaultCommand() {
		drive = RobotMap.robotDrive;
		shifter = RobotMap.shifter;
		highGear = false;
		this.setDefaultCommand(new StickDrive());
	}

	public void stickDrive(double forwardSpeed, double turnSpeed, double throttle) {
		// TODO find a better, more optimal way of doing this
		if (shifting) {
			drive.arcadeDrive((forwardSpeed * throttle) / SHIFTING_SCALE, (turnSpeed * throttle) / SHIFTING_SCALE);
		} else {
			drive.arcadeDrive(forwardSpeed, turnSpeed);
		}

	}

	public void stopMotors() {
		drive.arcadeDrive(0, 0);
	}

	public void setMotors(double inchespersecond) {
		double Power = inchespersecond / 120.0;
		stickDrive(Power, 0, 0);
	}

	// Inverts boolean highGear for button presses
	private boolean highGear;

	public void shift() {
		shifting = true;
		highGear = !highGear;
		shifter.set(highGear);
	}

	// Sets highGear as true or false
	public void shift(boolean highGear) {
		shifting = true;
		shifter.set(highGear);
		SmartDashboard.putBoolean("High Gear", highGear);
	}

	public void endShift() {
		shifting = false;
	}

	public static void initializeMotors() {
		RobotMap.leftDriveTalon1 = new CANTalon(RobotMap.LEFT_DRIVE_1_CAN_INDEX);
		RobotMap.leftDriveTalon2 = new CANTalon(RobotMap.LEFT_DRIVE_2_CAN_INDEX);
		RobotMap.rightDriveTalon1 = new CANTalon(RobotMap.RIGHT_DRIVE_1_CAN_INDEX);
		RobotMap.rightDriveTalon2 = new CANTalon(RobotMap.RIGHT_DRIVE_2_CAN_INDEX);
		RobotMap.robotDrive = new RobotDrive(RobotMap.leftDriveTalon1, RobotMap.leftDriveTalon2, RobotMap.rightDriveTalon1,
				RobotMap.rightDriveTalon2);
		
		RobotMap.shifter = new Solenoid(RobotMap.DRIVE_SHIFTER_INDEX);
	}
}
