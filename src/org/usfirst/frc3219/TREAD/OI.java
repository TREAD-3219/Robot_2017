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
import org.usfirst.frc3219.TREAD.commands.ballTransport.Ballfeed;
import org.usfirst.frc3219.TREAD.commands.ballTransport.IntakeBalls;
import org.usfirst.frc3219.TREAD.commands.drive.Shift;
import org.usfirst.frc3219.TREAD.commands.shooter.SetDiag;
import org.usfirst.frc3219.TREAD.commands.shooter.SetTurntableZero;
import org.usfirst.frc3219.TREAD.commands.shooter.Shoot;
import org.usfirst.frc3219.TREAD.commands.shooter.TurntableTurnTo;
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

	public Joystick stick;
	public Joystick Gamecontroller;

	public OI() {
		// joystick initialization
		stick = new Joystick(0);
		Gamecontroller = new Joystick(1);
		// Button Declarations
		JoystickButton shift = new JoystickButton(stick, 2);
		shift.whenPressed(new Shift());

		// JoystickButton Drive20ft= new JoystickButton(stick, 3);
		// Drive20ft.whenPressed(new Drive20ft());
		
		JoystickButton turnTest = new JoystickButton(stick, 3);
		turnTest.whenPressed(new SetTurntableZero());
		
		JoystickButton turnTest2 = new JoystickButton(stick, 4);
		turnTest2.whenPressed(new TurntableTurnTo(90));

		JoystickButton ballPickup = new JoystickButton(stick, 1);
		ballPickup.whileHeld(new IntakeBalls());

		JoystickButton ballfeed1 = new JoystickButton(Gamecontroller, 2);
		ballfeed1.whileHeld(new Ballfeed());

		JoystickButton openGear1 = new JoystickButton(Gamecontroller, 3);
		openGear1.whenPressed(new GearPiston(false));

		JoystickButton closeGear1 = new JoystickButton(Gamecontroller, 1);
		closeGear1.whenPressed(new GearPiston(true));

		JoystickButton climb1 = new JoystickButton(Gamecontroller, 5);
		climb1.whileHeld(new Climb());

		JoystickButton shoot1 = new JoystickButton(Gamecontroller, 4);
		shoot1.whileHeld(new Shoot());
		// JoystickButton turntableZero = new JoystickButton(stick, 2);
		// turntableZero.whenPressed(new SetTurntableZero());
		
		JoystickButton turnDiag = new JoystickButton(stick, 12);
		turnDiag.whenPressed(new SetDiag(true));
		JoystickButton turnMid = new JoystickButton(stick, 11);
		turnMid.whenPressed(new SetDiag(false));
	}

}
