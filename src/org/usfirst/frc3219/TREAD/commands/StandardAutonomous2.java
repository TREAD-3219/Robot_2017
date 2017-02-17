package org.usfirst.frc3219.TREAD.commands;

import org.usfirst.frc3219.TREAD.commands.autonomous.DriveForward;
import org.usfirst.frc3219.TREAD.commands.autonomous.DriveTurn;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StandardAutonomous2 extends CommandGroup {
	public StandardAutonomous2 () {
		this.addSequential(new DriveTurn(90));
		this.addSequential(new DriveForward(100));
		this.addSequential(new DriveTurn(45));
		//this.addSequential(new Aim());
		//this.addSequential(new Shoot());
	
	}
}
