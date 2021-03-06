package org.usfirst.frc3219.TREAD.commands.autonomous;

/*
 * This is the main autonomous program, chooses what the robot does based on position and team.
 */

import org.usfirst.frc3219.TREAD.Robot;
import org.usfirst.frc3219.TREAD.commands.shooter.AimAtTarget;
import org.usfirst.frc3219.TREAD.commands.shooter.AutoShoot;
import org.usfirst.frc3219.TREAD.commands.shooter.Spinup;
import org.usfirst.frc3219.TREAD.commands.vision.GearAim;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class StandardAutonomous extends CommandGroup {
	
	public StandardAutonomous() {
		if (Robot.position.equals("Middle")) {
			//this.addSequential(new Spinup(0.1));
			//this.addSequential(new GearAim(90));
			//this.addSequential(new DriveForward(48));
			//this.addSequential(new GearAim(45));
			//this.addSequential(new DriveForward(45));
			this.addSequential(new DriveForward((int) SmartDashboard.getNumber("Auto Mid Dist", 93))); 
			if (Robot.shootChooser.getSelected()) {
				shootCommands();
			}
			
		} else if (Robot.position.equals("Left")) {
			this.addSequential(new DriveForward((int) SmartDashboard.getNumber("Auto Diag Dist 1", 80)));
			this.addSequential(new DriveTurn(-57));
			this.addSequential(new GearAim(95));
			this.addSequential(new DriveForward((int) SmartDashboard.getNumber("Auto Diag Dist 2", 95)));
			if (!Robot.blueAlliance && Robot.shootChooser.getSelected()) {
				shootCommands();
			}
			
		} else if (Robot.position.equals("Right")) {
			//this.addSequential(new Spinup(0.1));
			this.addSequential(new DriveForward((int) SmartDashboard.getNumber("Auto Diag Dist 1", 80)));
			this.addSequential(new DriveTurn(57));
			this.addSequential(new GearAim(95));
			this.addSequential(new DriveForward((int) SmartDashboard.getNumber("Auto Diag Dist 2", 95)));
			if (Robot.blueAlliance && Robot.shootChooser.getSelected()) {
				shootCommands();
			}
		}
		//this.addSequential(new Wiggle());
		//turnWait();
	}
	
	//turning commands to ensure the gear is removed porperly
	public void turnWait() {
		this.addSequential(new Wait(3));
		this.addSequential(new DriveTurn(-5));
		this.addSequential(new Wait(3));
		this.addSequential(new DriveTurn(10));
		this.addSequential(new Wait(3));
		this.addSequential(new DriveTurn(-5));
	}
	
	//commands for running the shooter
	public void shootCommands() {
		this.addParallel(new AimAtTarget());
		this.addParallel(new Spinup(4));
		this.addParallel(new AutoShoot());
	}
}
