package subsystems;

import org.usfirst.frc3219.TREAD.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeFlipper extends Subsystem {

	@Override
	protected void initDefaultCommand() {
		
	}
	
	public void flipperSpeed(double speed) {
		// Goes from 0-1
		RobotMap.intakeTalon.set(speed);
	}

}
