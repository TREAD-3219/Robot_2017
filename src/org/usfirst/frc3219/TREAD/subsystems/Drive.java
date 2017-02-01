package org.usfirst.frc3219.TREAD.subsystems;

import org.usfirst.frc3219.TREAD.Robot;
import org.usfirst.frc3219.TREAD.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
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
	}
	
	public Drive() {
		drive = new RobotDrive(RobotMap.driveTalonFL, RobotMap.driveTalonBL, 
				RobotMap.driveTalonFR, RobotMap.driveTalonBR);
		shifter = RobotMap.shifter;
		highGear = false;
	}

	
	public void stickDrive(double forwardSpeed, double turnSpeed, double throttle) {
		//TODO find a better, more optimal way of doing this
		//if (shifting) {
			//drive.arcadeDrive((forwardSpeed * throttle) / SHIFTING_SCALE, (turnSpeed * throttle) / SHIFTING_SCALE);
		//} else {
			drive.arcadeDrive(forwardSpeed, turnSpeed);
		//}

	}

	public void stopMotors() {
		drive.arcadeDrive(0, 0);
	}

	public void setMotors(double inchespersecond) {
		double Power = inchespersecond / 120;
		drive.arcadeDrive(Power, 0);
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
}
