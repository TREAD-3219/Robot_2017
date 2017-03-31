package org.usfirst.frc3219.TREAD.commands.vision;

/*
 * This command aims the turntable at the shooting target based off of vision tracking continuously
 */

import org.usfirst.frc3219.TREAD.Robot;
import org.usfirst.frc3219.TREAD.subsystems.Sensors;
import org.usfirst.frc3219.TREAD.subsystems.Turntable;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class VisionAim extends PIDCommand {
	public static final double P = 0.02;
	public static final double I = 0.0;
	public static final double D = 0.06;
	
	private double turnRate;
	private double goalAngle;
	
	public VisionAim() {
		super(P, I, D);
    	requires(Robot.sensors);
    	requires(Robot.shooter);
    	turnRate = 0;
    	goalAngle = 0;
    }

    protected void initialize() {
    	this.setTimeout(10);
    	turnRate = 0;
    	goalAngle = 0;
    }

    protected void execute() {
    	SmartDashboard.putData("PID", this.getPIDController());
    	Robot.turntable.turnDirection(turnRate);
    }

    protected boolean isFinished() {
        return this.isTimedOut();
    }

    protected void end() {
    	Robot.turntable.turnDirection(0.0);
    }

    protected void interrupted() {
    	end();
    }
    
    private double previous = 0;
    private void checkAngle() {
    	double temp = (Robot.sensors.getShooterTargetY() - Sensors.CAMERA_HEIGHT/2.0) * Sensors.DEGREES_PER_PIXEL_Y;
    	if (previous != temp) {
    		goalAngle = Robot.turntable.getAngle() + temp;
    		previous = temp;
    	}
    }

	@Override
	protected double returnPIDInput() {
		checkAngle();
		SmartDashboard.putNumber("PID VALUE", Robot.turntable.getAngle() - goalAngle);
		return -(Robot.turntable.getAngle() - goalAngle);
	}

	@Override
	protected void usePIDOutput(double output) {
		if (output > Turntable.TURNTABLE_CLOCKWISE) {
			output = Turntable.TURNTABLE_CLOCKWISE;
		} else if (output < Turntable.TURNTABLE_COUNTER_CLOCKWISE) {
			output = Turntable.TURNTABLE_COUNTER_CLOCKWISE;
		}
		turnRate = output;
	}
}
