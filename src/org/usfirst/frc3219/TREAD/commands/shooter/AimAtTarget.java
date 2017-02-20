package org.usfirst.frc3219.TREAD.commands.shooter;

import org.usfirst.frc3219.TREAD.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AimAtTarget extends CommandGroup {
	public AimAtTarget() {
		this.addSequential(new SetTurntableZero());
			if (Robot.position.equals("Default")) {
				this.addSequential(new TurntableTurnTo(1500));
			} else {
				this.addSequential(new TurntableTurnTo(-1000));
			}
		} else {
			if (Robot.position.equals("Default")) {
				this.addSequential(new TurntableTurnTo(-1500));
			} else {
				this.addSequential(new TurntableTurnTo(1000));
			}
	}
}
