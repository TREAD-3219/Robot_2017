package org.usfirst.frc3219.TREAD.commands.shooter;

/*
 * This command resets the shooter power
 */

import org.usfirst.frc3219.TREAD.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Reset extends Command {
	
	@Override
	protected void initialize() {
		this.setTimeout(.1);
	}
	
	@Override
	protected void execute() {
		Robot.shooter.resetPower();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return this.isTimedOut();
	}

}
