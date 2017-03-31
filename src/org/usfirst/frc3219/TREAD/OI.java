// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc3219.TREAD;

import org.usfirst.frc3219.TREAD.commands.*;
import org.usfirst.frc3219.TREAD.commands.autonomous.DriveForward;
import org.usfirst.frc3219.TREAD.commands.ballTransport.Ballfeed;
import org.usfirst.frc3219.TREAD.commands.ballTransport.IntakeBalls;
import org.usfirst.frc3219.TREAD.commands.drive.Shift;
import org.usfirst.frc3219.TREAD.commands.drive.ShiftHigh;
import org.usfirst.frc3219.TREAD.commands.drive.ShiftLow;
import org.usfirst.frc3219.TREAD.commands.shooter.Reset;
import org.usfirst.frc3219.TREAD.commands.shooter.SetDiag;
import org.usfirst.frc3219.TREAD.commands.shooter.SetTurntableZero;
import org.usfirst.frc3219.TREAD.commands.shooter.Shoot;
import org.usfirst.frc3219.TREAD.commands.shooter.ShooterForward;
import org.usfirst.frc3219.TREAD.commands.shooter.TurntableTurnTo;
import org.usfirst.frc3219.TREAD.commands.vision.VisionAimSingle;
import org.usfirst.frc3219.TREAD.subsystems.Drive;
import org.usfirst.frc3219.TREAD.subsystems.GearSlot;
import org.usfirst.frc3219.TREAD.subsystems.Turntable;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	//// CREATING BUTTONS
	/*
	 * One type of button is a joystick button which is any button on a
	 * joystick. You create one by telling it which joystick it's on and which
	 * button number it is. Joystick stick = new Joystick(port); Button button =
	 * new JoystickButton(stick, buttonNumber);
	 *
	 * There are a few additional built in buttons you can use. Additionally, by
	 * subclassing Button you can create custom triggers and bind those to
	 * commands the same as any other Button.
	 *
	 **** TRIGGERING COMMANDS WITH BUTTONS Once you have a button, it's trivial to
	 * bind it to a button in one of three ways:
	 *
	 * Start the command when the button is pressed and let it run the command
	 * until it is finished as determined by it's isFinished method.
	 * button.whenPressed(new ExampleCommand());
	 *
	 * Run the command while the button is being held down and interrupt it once
	 * the button is released. button.whileHeld(new ExampleCommand());
	 *
	 * Start the command when the button is released and let it run the command
	 * until it is finished as determined by it's isFinished method.
	 * button.whenReleased(new ExampleCommand());
	 */

	// Joystick Declarations
	public Joystick leftStick;
	public Joystick rightStick;
	public Joystick GameController;

	public OI() {
		// joystick initialization
		leftStick = new Joystick(0);
		rightStick = new Joystick(1);
		GameController = new Joystick(2);
		// Button Declarations

		// DRIVE COMMANDS
		JoystickButton shift = new JoystickButton(leftStick, 2);
		shift.whenPressed(new ShiftLow());

		JoystickButton shift2 = new JoystickButton(rightStick, 2);
		shift2.whenPressed(new ShiftHigh());
		
		JoystickButton moveToPosition = new JoystickButton(rightStick, 3);
		moveToPosition.whenPressed(new DriveForward(-Drive.SHOOTING_POSITION));

		// Ball Pickup
		JoystickButton ballPickup = new JoystickButton(GameController, 1);
		ballPickup.whileHeld(new IntakeBalls());

		JoystickButton ballPickup2 = new JoystickButton(GameController, 3);
		ballPickup2.whileHeld(new IntakeBalls(-1));

		// SHOOTING COMMANDS
		JoystickButton turnTest2 = new JoystickButton(GameController, 8);
		turnTest2.whenPressed(new VisionAimSingle());

		JoystickButton turntableForward = new JoystickButton(GameController, 9);
		turntableForward.whenPressed(new ShooterForward());

		JoystickButton shoot1 = new JoystickButton(GameController, 2);
		shoot1.whileHeld(new Shoot());

		JoystickButton resetShooter = new JoystickButton(GameController, 7);
		resetShooter.whenPressed(new Reset());
		
		//BALL FEED
		JoystickButton ballfeed1 = new JoystickButton(GameController, 4);
		ballfeed1.whileHeld(new Ballfeed());

		//GEARS
		JoystickButton openGear = new JoystickButton(rightStick, 1);
		openGear.whenPressed(new GearPiston(GearSlot.GEAR_OPEN));

		JoystickButton closeGear = new JoystickButton(leftStick, 1);
		closeGear.whenPressed(new GearPiston(!GearSlot.GEAR_OPEN));
		
		JoystickButton openBlock = new JoystickButton(GameController, 5);
		openBlock.whenPressed(new BlockerPiston(false));

		JoystickButton closeBlock = new JoystickButton(GameController, 6);
		closeBlock.whenPressed(new BlockerPiston(true));

		//CLIMBING
		JoystickButton climb1 = new JoystickButton(GameController, 10);
		climb1.whileHeld(new Climb());
	}

}
