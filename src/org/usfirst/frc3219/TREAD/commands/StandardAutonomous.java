package org.usfirst.frc3219.TREAD.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
//TODO uncomment commands as they get finished
public class StandardAutonomous extends CommandGroup {
	public StandardAutonomous() {
		this.addSequential(new DriveForward(100));
		this.addSequential(new DriveTurn(45));
		//this.addSequential(new Aim());
		//this.addSequential(new Shoot());
		
	}
}
