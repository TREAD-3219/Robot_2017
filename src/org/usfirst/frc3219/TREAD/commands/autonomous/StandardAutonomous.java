package org.usfirst.frc3219.TREAD.commands.autonomous;

import org.usfirst.frc3219.TREAD.commands.shooter.AimAtTarget;
import org.usfirst.frc3219.TREAD.commands.shooter.AutoShoot;
import org.usfirst.frc3219.TREAD.commands.shooter.Spinup;

import edu.wpi.first.wpilibj.command.CommandGroup;
public class StandardAutonomous extends CommandGroup {
	public StandardAutonomous() {
		this.addSequential(new DriveForward(100));
		this.addSequential(new AimAtTarget());
		this.addSequential(new Spinup());
		this.addSequential(new AutoShoot());
		
	}
}
