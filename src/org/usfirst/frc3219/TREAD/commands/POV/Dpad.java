package org.usfirst.frc3219.TREAD.commands.POV;

import org.usfirst.frc3219.TREAD.Robot;
import org.usfirst.frc3219.TREAD.RobotMap;
import org.usfirst.frc3219.TREAD.subsystems.Turntable;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DPad extends Command {
	
	public DPad() {
		requires(Robot.turntable);
	}

	@Override
	protected void execute() {
		int pov = Robot.oi.Gamecontroller.getPOV();
		if (pov == 90) {
			Robot.turntable.turnDirection(Turntable.TURNTABLE_BACKWARD);
		} else if (pov == 270) {
			Robot.turntable.turnDirection(Turntable.TURNTABLE_FORWARD);
		} else {
			Robot.turntable.turnDirection(0);
		}
		
		if (pov == 180) {
			Robot.shooter.powerDown();
		} else if(pov == 0) {
			Robot.shooter.powerUp();
		}
	}

	@Override
	protected void end() {
		Robot.turntable.turnDirection(0);
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void interrupted() {
		end();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}
