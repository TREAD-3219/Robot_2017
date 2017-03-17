package org.usfirst.frc3219.TREAD.commands.autonomous;

import org.usfirst.frc3219.TREAD.Robot;
import org.usfirst.frc3219.TREAD.commands.shooter.AimAtTarget;
import org.usfirst.frc3219.TREAD.commands.shooter.AutoShoot;
import org.usfirst.frc3219.TREAD.commands.shooter.Spinup;
import org.usfirst.frc3219.TREAD.commands.vision.GearAim;

import edu.wpi.first.wpilibj.command.CommandGroup;
public class StandardAutonomous extends CommandGroup {
	public StandardAutonomous() {
		if (Robot.position.equals("Middle")) {
			this.addSequential(new Spinup(0.1));
			this.addSequential(new GearAim(90));
			this.addSequential(new DriveForward(45));
			this.addSequential(new GearAim(45));
			this.addSequential(new DriveForward(45));
			if (Robot.shootChooser.getSelected()) {
				shootCommands();
			}
			
		} else if (Robot.position.equals("Left")) {
			this.addSequential(new DriveForward(80));
			this.addSequential(new DriveTurn(-57));
			this.addSequential(new GearAim(95));
			this.addSequential(new DriveForward(95));
			if (!Robot.blueAlliance && Robot.shootChooser.getSelected()) {
				shootCommands();
			}
			
		} else if (Robot.position.equals("Right")) {
			this.addSequential(new Spinup(0.1));
			this.addSequential(new DriveForward(80));
			this.addSequential(new DriveTurn(57));
			this.addSequential(new GearAim(95));
			this.addSequential(new DriveForward(95));
			if (Robot.blueAlliance && Robot.shootChooser.getSelected()) {
				shootCommands();
			}
		}
	}
	
	public void shootCommands() {
		this.addSequential(new AimAtTarget());
		this.addSequential(new Spinup(4));
		this.addSequential(new AutoShoot());
	}
}
