package org.usfirst.frc3219.TREAD.commands.shooter;

import org.usfirst.frc3219.TREAD.Robot;
import org.usfirst.frc3219.TREAD.subsystems.Turntable;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class SetDiag extends Command {
	boolean diag;
	public SetDiag(boolean diag) {
		this.diag = diag;
	}
	
	protected void initialize() {
		if (diag) {
			Robot.position = "Diag";
		} else {
			Robot.position = "Middle";
		}
		this.setTimeout(.1);
		Robot.addCommand(new AimAtTarget());
	}

	protected void execute() {
	}

	protected void end() {
	}

	protected void interrupted() {
		end();
	}

	protected boolean isFinished() {
		return this.isTimedOut();
	}
}
