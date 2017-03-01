package org.usfirst.frc3219.TREAD.commands.shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoAim extends CommandGroup {
	public AutoAim() {
		this.addSequential(new SetTurntableZero());
		this.addSequential(new VisionAim());
	}
}
