package subsystems;

import org.usfirst.frc3219.TREAD.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drive extends Subsystem {
	
	public RobotDrive drive;
	
	@Override
	protected void initDefaultCommand() {
		drive = new RobotDrive(RobotMap.driveTalonBL, RobotMap.driveTalonBR, RobotMap.driveTalonFL, RobotMap.driveTalonFR);
	}
	
	//TODO would throttle cause trouble? Do we need to say a specific axis?
	public void stickDrive(double forwardSpeed, double turnSpeed, double throttle) {
		drive.arcadeDrive(forwardSpeed * throttle, turnSpeed * throttle);
	}
	
	public void stopMotors() {
	drive.arcadeDrive(0, 0);
	}

}
