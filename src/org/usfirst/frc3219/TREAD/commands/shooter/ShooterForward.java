package org.usfirst.frc3219.TREAD.commands.shooter;

import org.usfirst.frc3219.TREAD.subsystems.Turntable;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ShooterForward extends CommandGroup {
	public ShooterForward() {
		this.addSequential(new SetTurntableZero());
		this.addSequential(new TurntableTurnTo(Turntable.FORWARD_POSITION));
	}
}
