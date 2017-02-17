package org.usfirst.frc3219.TREAD.subsystems;

import org.usfirst.frc3219.TREAD.RobotMap;
import org.usfirst.frc3219.TREAD.commands.SensorWatch;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Sensors extends Subsystem {
	public I2C i2c;
	public AHRS NAVX;

	@Override
	protected void initDefaultCommand() {
		//i2c = new I2C(I2C.Port.kMXP, 0x62);
		NAVX = new AHRS(SPI.Port.kMXP);
		
		//Encode = RobotMap.driveEncoder;
		//Encode.setMaxPeriod(0.1);
		//Encode.setMinRate(10);
		RobotMap.rightDriveEncoder.setDistancePerPulse(Math.PI / 90);
		RobotMap.leftDriveEncoder.setDistancePerPulse(Math.PI / 90);
		this.setDefaultCommand(new SensorWatch());
	}

	public double getDriveDistance() {
		double total = RobotMap.rightDriveEncoder.getDistance() + RobotMap.leftDriveEncoder.getDistance();
		return total / 2;
	}
	
	public double rightDriveDistance() {
		return RobotMap.rightDriveEncoder.getDistance();
	}
	
	public double leftDriveDistance() {
		return RobotMap.leftDriveEncoder.getDistance();
	}

	public int getLidarDistance() {
		byte[] buffer = new byte[2];
		i2c.write(0x00, 0x04);
		i2c.read(0x8f, 2, buffer);
		return (int) (Integer.toUnsignedLong(buffer[0] << 8)) + Byte.toUnsignedInt(buffer[1]);
	}

	public double getAngle() {
		return NAVX.getYaw();
	}
	
	public static void initializeSensors() {
		RobotMap.rightDriveEncoder = new Encoder(RobotMap.RIGHT_DRIVE_ENCODER_A, RobotMap.RIGHT_DRIVE_ENCODER_B);
		RobotMap.leftDriveEncoder = new Encoder(RobotMap.LEFT_DRIVE_ENCODER_A, RobotMap.LEFT_DRIVE_ENCODER_B);
	}
}
