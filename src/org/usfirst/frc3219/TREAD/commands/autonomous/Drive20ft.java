package org.usfirst.frc3219.TREAD.commands.autonomous;

import org.usfirst.frc3219.TREAD.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Drive20ft extends Command {
@Override
protected void initialize() {
	Robot.drive.setMotors(60);
	this.setTimeout(12);
}
@Override
protected void execute() {
	Robot.drive.setMotors(60);
}
@Override
protected void end(){
	Robot.drive.setMotors(0);
}
@Override 
protected void interrupted() {
	end();
	
}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return this.isTimedOut();
	}
}
