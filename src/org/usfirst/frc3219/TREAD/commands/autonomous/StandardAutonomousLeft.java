package org.usfirst.frc3219.TREAD.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StandardAutonomousLeft extends CommandGroup {
	public StandardAutonomousLeft () {
		this.addSequential(new DriveForward(90));
		this.addSequential(new DriveTurn(-55));
		this.addSequential(new DriveForward(90));
		//this.addSequential(new Aim());
		//this.addSequential(new Shoot());
	}
}
