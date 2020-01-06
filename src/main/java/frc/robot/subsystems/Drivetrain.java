/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  /**
   * Creates a new Drivetrain.
   */
  
  public final WPI_TalonSRX leftRearMotor;
  public final WPI_TalonSRX rightRearMotor;
  public final WPI_VictorSPX leftFrontMotor;
  public final WPI_VictorSPX rightFrontMotor;

  public DifferentialDrive differentialDrive;

  public Drivetrain() {
    leftRearMotor = new WPI_TalonSRX(31);
    rightRearMotor = new WPI_TalonSRX(11);
    leftFrontMotor = new WPI_VictorSPX(21);
    rightFrontMotor = new WPI_VictorSPX(01);

    leftRearMotor.configFactoryDefault();
    rightRearMotor.configFactoryDefault();
    leftFrontMotor.configFactoryDefault();
    rightFrontMotor.configFactoryDefault();

    leftRearMotor.setInverted(true);
    rightRearMotor.setInverted(false);
    
    int currentLimit = 65;
    leftRearMotor.configPeakCurrentLimit(currentLimit);
    rightRearMotor.configPeakCurrentLimit(currentLimit);

    leftFrontMotor.follow(leftRearMotor);
    rightFrontMotor.follow(rightRearMotor); 

    differentialDrive = new DifferentialDrive(leftRearMotor, rightRearMotor);

  }

  // Do we need a default command anymore? It doesn't seem like it.

  public void arcadeDrive(double moveSpeed, double rotateSpeed) {
    differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}