package org.usfirst.frc3219.TREAD.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Sensors extends Subsystem {
	public I2C i2c;
	public AHRS NAVX;

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		i2c = new I2C(I2C.Port.kMXP, 0x62);
		NAVX = new AHRS(SPI.Port.kMXP);
	}

	public int getDistance() {
		byte[] buffer = new byte[2];
		i2c.write(0x00, 0x04);
		i2c.read(0x8f, 2, buffer);
		return (int) (Integer.toUnsignedLong(buffer[0] << 8)) + Byte.toUnsignedInt(buffer[1]);
	}

public double getAngle(){
return NAVX.getAngle();	
}
}
