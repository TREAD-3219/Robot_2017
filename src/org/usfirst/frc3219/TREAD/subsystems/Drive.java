package org.usfirst.frc3219.TREAD.subsystems;

import org.usfirst.frc3219.TREAD.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drive extends Subsystem {

	private RobotDrive drive;
	private Solenoid shifter;
	private Encoder Encode;

	@Override
	protected void initDefaultCommand() {
		drive = new RobotDrive(RobotMap.driveTalonFL, RobotMap.driveTalonFR, RobotMap.driveTalonBL,
				RobotMap.driveTalonBR);
		shifter = RobotMap.shifter;
		highGear = false;
		Encode = RobotMap.driveEncoder;
		Encode.setMaxPeriod(0.1);
		Encode.setMinRate(10);
	Encode.setDistancePerPulse(Math.PI/90);}

	// TODO would throttle cause trouble? Do we need to say a specific axis?
	public void stickDrive(double forwardSpeed, double turnSpeed, double throttle) {
		drive.arcadeDrive(forwardSpeed * throttle, turnSpeed * throttle);
	}
public double GetDistance(){
	return Encode.getDistance();
}
	public void stopMotors() {
		drive.arcadeDrive(0, 0);
	}

	public void setMotors(double inchespersecond) {
		double Power = inchespersecond / 120;
		drive.arcadeDrive(Power, 0);
	}

	private boolean highGear;

	public void shift() {
		highGear = !highGear;
		shifter.set(highGear);
	}

	public void shift(boolean highGear) {
		shifter.set(highGear);
	}
}