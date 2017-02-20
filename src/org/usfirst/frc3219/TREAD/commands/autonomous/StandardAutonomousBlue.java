package org.usfirst.frc3219.TREAD.commands.autonomous;

import org.usfirst.frc3219.TREAD.Robot;
import org.usfirst.frc3219.TREAD.commands.shooter.AimAtTarget;
import org.usfirst.frc3219.TREAD.commands.shooter.AutoShoot;
import org.usfirst.frc3219.TREAD.commands.shooter.Spinup;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StandardAutonomousBlue extends CommandGroup {
	public StandardAutonomousBlue() {
		
		if (Robot.position.equals("Default")) {
			this.addSequential(new DriveForward(100));
			this.addSequential(new AimAtTarget());
			this.addSequential(new Spinup());
			this.addSequential(new AutoShoot());
			
		} else if (Robot.position.equals("Left")) {
			this.addSequential(new DriveForward(90));
			this.addSequential(new DriveTurn(-55));
			this.addSequential(new DriveForward(90));
			
		} else if (Robot.position.equals("Right")) {
			this.addSequential(new DriveForward(90));
			this.addSequential(new DriveTurn(55));
			this.addSequential(new DriveForward(90));
			this.addSequential(new AimAtTarget());
			this.addSequential(new Spinup());
			this.addSequential(new AutoShoot());
		}
	}
}
