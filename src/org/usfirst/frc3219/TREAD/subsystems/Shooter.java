package org.usfirst.frc3219.TREAD.subsystems;

import org.usfirst.frc3219.TREAD.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem{

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
public void startShooter(){
	RobotMap.talon.set(1);
}

public void stopShooter(){
	RobotMap.talon.set(0);
	}

public void shooter(double speed){RobotMap.talon.set(speed);

}
}