package org.usfirst.frc3219.TREAD.commands.shooter;

import org.usfirst.frc3219.TREAD.Robot;
import org.usfirst.frc3219.TREAD.subsystems.Turntable;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AimAtTarget extends CommandGroup {
	public AimAtTarget() {
		this.addSequential(new SetTurntableZero());
		if (Robot.blueAlliance) {
			if (Robot.position.equals("Middle")) {
				this.addSequential(new TurntableTurnTo(Turntable.BLUE_MID_POSITION));
			} else {
				this.addSequential(new TurntableTurnTo(Turntable.BLUE_RIGHT_POSITION));
			}
		} else {
			if (Robot.position.equals("Middle")) {
				this.addSequential(new TurntableTurnTo(Turntable.RED_MID_POSITION));
			} else {
				this.addSequential(new TurntableTurnTo(Turntable.RED_LEFT_POSITION));
			}
		}
	}
}