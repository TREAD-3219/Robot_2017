package org.usfirst.frc3219.TREAD.commands.POV;

import org.usfirst.frc3219.TREAD.Robot;
import org.usfirst.frc3219.TREAD.RobotMap;
import org.usfirst.frc3219.TREAD.commands.shooter.AimLeft;
import org.usfirst.frc3219.TREAD.commands.shooter.AimRight;
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
			Robot.addCommand(new AimRight());
		} else if (pov == 270) {
			Robot.addCommand(new AimLeft());
		} else {
			Robot.turntable.turnDirection(Robot.oi.Gamecontroller.getX() * -0.3);
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
