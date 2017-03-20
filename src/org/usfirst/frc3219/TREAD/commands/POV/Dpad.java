package org.usfirst.frc3219.TREAD.commands.POV;

import org.usfirst.frc3219.TREAD.Robot;
import org.usfirst.frc3219.TREAD.RobotMap;
import org.usfirst.frc3219.TREAD.commands.shooter.AimLeft;
import org.usfirst.frc3219.TREAD.commands.shooter.AimRight;
import org.usfirst.frc3219.TREAD.subsystems.Turntable;

import edu.wpi.first.wpilibj.GenericHID.Hand;
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
			double value = Robot.oi.Gamecontroller.getRawAxis(0);
			Robot.turntable.turnDirection(value * -0.3);
		}
		
		if (pov == 180) {
			Robot.shooter.powerDown();
		} else if(pov == 0) {
			Robot.shooter.powerUp();
		}
		double value = Robot.oi.Gamecontroller.getRawAxis(5);
		if (Math.abs(value) < .3) {
			Robot.climber.setMotors(0);
		} else {
			Robot.climber.setMotors(Math.abs(value));
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
