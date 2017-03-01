package org.usfirst.frc3219.TREAD.commands.shooter;

import org.usfirst.frc3219.TREAD.Robot;
import org.usfirst.frc3219.TREAD.subsystems.Sensors;
import org.usfirst.frc3219.TREAD.subsystems.Turntable;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class VisionAimSingle extends Command{
	private double goalAngle;
	
	public VisionAimSingle() {
    	requires(Robot.sensors);
    	requires(Robot.shooter);
    	goalAngle = 0;
    }

    protected void initialize() {
    	this.setTimeout(10);
    	double temp = (Robot.sensors.getTargetX() - Sensors.CAMERA_WIDTH/2.0) * Sensors.DEGREES_PER_PIXEL;
    	goalAngle = Robot.turntable.getAngle() + temp;
    }

    protected void execute() {
    	SmartDashboard.putNumber("dist left", Robot.turntable.getAngle() - goalAngle);
    	if (Robot.turntable.getAngle() - goalAngle < 0) {
    		Robot.turntable.turnDirection(Turntable.TURNTABLE_BACKWARD);
    	} else {
    		Robot.turntable.turnDirection(Turntable.TURNTABLE_FORWARD);
    	}
    }

    protected boolean isFinished() {
        return this.isTimedOut() || Math.abs(Robot.turntable.getAngle() - goalAngle) < 10;
    }

    protected void end() {
    	Robot.turntable.turnDirection(0.0);
    }

    protected void interrupted() {
    	end();
    }
}
