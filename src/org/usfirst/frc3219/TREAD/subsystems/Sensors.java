package org.usfirst.frc3219.TREAD.subsystems;

/*
 * This class contains methods for getting data about the environment
 */

import org.usfirst.frc3219.TREAD.RobotMap;
import org.usfirst.frc3219.TREAD.commands.SensorWatch;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class Sensors extends Subsystem {
	
	//Constants for drive encoders
	private final static double OUTPUT_SHAFT_SCALE = 3.0;
	private final static double TICKS_PER_ROTATION = 360.0 * OUTPUT_SHAFT_SCALE;
	private final static double WHEEL_ROTATIONS_PER_ROTATION = 10.86;
	private final static double WHEEL_DIAMETER = 4 * Math.PI;
	private final static double INCHES_PER_TICK = (WHEEL_DIAMETER * WHEEL_ROTATIONS_PER_ROTATION) / TICKS_PER_ROTATION * 0.9;
	
	//Gyro declaration
	public AHRS NAVX;
	
	//network table declarations
	public NetworkTable visionTable;
	public NetworkTable gearVisionTable;
	
	//Camera settings
	public static final int CAMERA_WIDTH = 640;
	public static final int CAMERA_HEIGHT = 480;
	public static final int GEAR_CAMERA_HEIGHT = 720;
	public static final double DEGREES_PER_PIXEL = 60.0 / CAMERA_WIDTH;
	public static final double DEGREES_PER_PIXEL_Y = 60.0 / CAMERA_HEIGHT;
	public static final double GEAR_DEGREES_PER_PIXEL_Y = 50.0 / CAMERA_HEIGHT;
	private static final int CAMERA_FPS = 5;

	public Sensors() {
		NAVX = new AHRS(SPI.Port.kMXP);
		RobotMap.rightDriveEncoder.reset();
		RobotMap.leftDriveEncoder.reset();
		visionTable = NetworkTable.getTable("GRIP/myContoursReport");
		gearVisionTable = NetworkTable.getTable("GRIP/gearsContoursReport");

	}

	@Override
	protected void initDefaultCommand() {
		this.setDefaultCommand(new SensorWatch());
	}

	// sets up stuff for putting cameras onto smartdashboard
	public static void setupCamera() {
		CameraServer server = CameraServer.getInstance();
		UsbCamera gearCam = server.startAutomaticCapture();
		gearCam.setResolution(CAMERA_WIDTH, CAMERA_HEIGHT);
		gearCam.setFPS(CAMERA_FPS);
		gearCam.setExposureManual(33);
		
		server.addAxisCamera("Shooter", "10.32.19.52");
	}

	//returns the averaged drive distance of the two wheelbases
	public double getDriveDistance() {
		double total = RobotMap.rightDriveEncoder.getDistance() + RobotMap.leftDriveEncoder.getDistance();
		return total / 2;
	}

	//returns the x location in pixels of the shooting target
	public double getShooterTargetY() {
		double[] centerYs = visionTable.getNumberArray("centerY", new double[1]);
		double average = 0.0;
		for (double d : centerYs) {
			average += d;
		}
		average /= centerYs.length;
		return average;
	}
	
	//returns the x location in pixels of the gear target
	public double getGearTargetY() {
		double[] centerYs = gearVisionTable.getNumberArray("centerY", new double[1]);
		double average = 0.0;
		for (double d : centerYs) {
			average += d;
		}
		average /= centerYs.length;
		return average;
	}

	//returns true if the robot sees a target through the shooter camera
	public boolean shooterTargetIsVisible() {
		return visionTable.getNumberArray("centerX", new double[1]).length > 1;
	}
	
	//returns true if the robot sees a target through the gear camera
	public boolean gearTargetIsVisible() {
		return gearVisionTable.getNumberArray("centerX", new double[1]).length > 1;
	}

	//returns the distance the right wheels have driven
	public double rightDriveDistance() {
		return RobotMap.rightDriveEncoder.getDistance();
	}

	//returns the distance the left wheel have driven
	public double leftDriveDistance() {
		return RobotMap.leftDriveEncoder.getDistance();
	}

	//returns the current angle of the robot
	public double getAngle() {
		return NAVX.getYaw();
	}

	public static void initializeSensors() {
		RobotMap.rightDriveEncoder = new Encoder(RobotMap.RIGHT_DRIVE_ENCODER_A, RobotMap.RIGHT_DRIVE_ENCODER_B);
		RobotMap.leftDriveEncoder = new Encoder(RobotMap.LEFT_DRIVE_ENCODER_A, RobotMap.LEFT_DRIVE_ENCODER_B);
		RobotMap.rightDriveEncoder.setDistancePerPulse(-INCHES_PER_TICK);
		RobotMap.leftDriveEncoder.setDistancePerPulse(INCHES_PER_TICK);
	}

	//sets the encoder values to zero
	public void resetEncoders() {
		RobotMap.rightDriveEncoder.reset();
		RobotMap.leftDriveEncoder.reset();
	}
}
