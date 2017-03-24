package org.usfirst.frc3219.TREAD.commands.POV;

/*
 * This command continously takes input from the xbox controller and sets the turntable and climber based off of it
 */

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
		//move the turntable left or right
		int pov = Robot.oi.GameController.getPOV();
		if (pov == 90) {
			Robot.addCommand(new AimRight());
		} else if (pov == 270) {
			Robot.addCommand(new AimLeft());
		} else {
			double value = Robot.oi.GameController.getRawAxis(0); //Left x axis
			Robot.turntable.turnDirection(value * -0.3);
		}
		
		//changes the power of the shooter
		if (pov == 180) {
			Robot.shooter.powerDown();
		} else if(pov == 0) {
			Robot.shooter.powerUp();
		}
		
		//sets the power of the climber
		double value = Robot.oi.GameController.getRawAxis(5); //Right y axis
		if (Math.abs(value) < .3) {
			Robot.climber.runMotors(0);
		} else {
			Robot.climber.runMotors(Math.abs(value));
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
