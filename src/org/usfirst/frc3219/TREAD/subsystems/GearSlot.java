package org.usfirst.frc3219.TREAD.subsystems;

import org.usfirst.frc3219.TREAD.RobotMap;
import org.usfirst.frc3219.TREAD.commands.GearPiston;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearSlot extends Subsystem {
	private Solenoid piston;
	private boolean out;
	
	@Override
	protected void initDefaultCommand() {
		piston = RobotMap.gearPiston;
		out = true;
		setPosition(out);
		//this.setDefaultCommand(new GearPiston(false));
	}
	
	public void changePosition() {
		out = !out;
		piston.set(out);
	}
	
	public void setPosition(boolean pos) {
		if (out != pos) {
			piston.set(pos);
			out = pos;
		}
	}

}
