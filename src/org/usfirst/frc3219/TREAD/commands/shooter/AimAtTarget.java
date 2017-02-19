package org.usfirst.frc3219.TREAD.commands.shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AimAtTarget extends CommandGroup {
	public AimAtTarget() {
		this.addSequential(new SetTurntableZero());
		this.addSequential(new TurntableTurnTo(1500));
		this.addSequential(new Spinup());
		this.addSequential(new AutoShoot());
	}
}
