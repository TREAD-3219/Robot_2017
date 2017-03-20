package org.usfirst.frc3219.TREAD.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;

public class Wait extends Command {
	
	private double time;
	public Wait(double seconds) {
		time = seconds;
	}

	@Override
	protected void initialize() {
		this.setTimeout(time);
	}
	
	@Override
	protected boolean isFinished() {
		return this.isTimedOut();
	}
}
