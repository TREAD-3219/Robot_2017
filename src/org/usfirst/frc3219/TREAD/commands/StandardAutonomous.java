package org.usfirst.frc3219.TREAD.commands;

import org.usfirst.frc3219.TREAD.commands.autonomous.DriveForward;
import org.usfirst.frc3219.TREAD.commands.autonomous.DriveTurn;
import org.usfirst.frc3219.TREAD.commands.shooter.AimAtTarget;
import org.usfirst.frc3219.TREAD.commands.shooter.TurntableTurnTo;

import edu.wpi.first.wpilibj.command.CommandGroup;
//TODO uncomment commands as they get finished
public class StandardAutonomous extends CommandGroup {
	public StandardAutonomous() {
		this.addSequential(new DriveForward(100));
		//this.addSequential(new DriveTurn(-45));
		this.addSequential(new AimAtTarget());
		//this.addSequential(new Aim());
		//this.addSequential(new Shoot());
		
	}
}
