package org.usfirst.frc3219.TREAD.subsystems;

/*
 * This class contains methods useful to using the drive motors and shifting
 */

import org.usfirst.frc3219.TREAD.RobotMap;
import org.usfirst.frc3219.TREAD.commands.drive.StickDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drive extends Subsystem {
	
	//scale to lower power by when shifting
	private static final double SHIFTING_SCALE = 10;
	//ms to wait while shifting
	public static final double SHIFT_SPEED_MS = 100 / 1000.0;
	//boolean to note which gear is 'high' gear
	public static final boolean HIGH_GEAR = false;
	//distance from wall set as default 'shooting' position
	public static final int SHOOTING_POSITION = -38;
	
	//hardware declarations
	private RobotDrive drive;
	private Solenoid shifter;
	private boolean shifting;

	@Override
	protected void initDefaultCommand() {
		drive = RobotMap.robotDrive;
		shifter = RobotMap.shifter;
		highGear = !HIGH_GEAR;
		this.setDefaultCommand(new StickDrive());
	}
	
	//drives the robot based on forward/turnspeed
	public void arcadeDrive(double forwardSpeed, double turnSpeed) {
		if (shifting) {
			drive.arcadeDrive((forwardSpeed) / SHIFTING_SCALE, (turnSpeed) / SHIFTING_SCALE);
		} else {
			drive.arcadeDrive(forwardSpeed, turnSpeed);
		}

	}
	
	//drives the robot based on left and right speed
	public void tankDrive(double leftPower, double rightPower) {
		if (shifting) {
			drive.tankDrive(leftPower / SHIFTING_SCALE, rightPower / SHIFTING_SCALE);
		} else {
			drive.tankDrive(leftPower, rightPower);
		}
	}

	public void stopMotors() {
		drive.arcadeDrive(0, 0);
	}

	public void runMotors(double speed) {
		arcadeDrive(speed, 0);
	}

	// Inverts boolean highGear for button presses
	private boolean highGear;

	//toggles the current shifted state
	public void shift() {
		shifting = true;
		highGear = !highGear;
		shifter.set(highGear);
	}

	// Sets highGear as true or false, based on given value
	public void shift(boolean highGear) {
		shifting = true;
		shifter.set(highGear);
	}
	
	//notifies the robot that it is no longer shifting
	public void endShift() {
		shifting = false;
	}

	//initializes drive motors, robotDrive, and shifter
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
