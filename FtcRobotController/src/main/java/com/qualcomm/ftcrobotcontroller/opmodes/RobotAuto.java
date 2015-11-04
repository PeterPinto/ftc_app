package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * Created by Peter on 11/2/2015.
 */

/*
 * This class is an extension of Robot for autonomous mode.  This is not an OpMode, but may
 * be implemented in one by creating an object of this class.
 */
public class RobotAuto extends Robot {

    private boolean hasEncoders;
    private final static double TURN_SPEED = .25;

    public RobotAuto(int driveType, DcMotor left, DcMotor right, boolean encoders)
    {
        super(driveType, left, right);

        hasEncoders = encoders;

        initRobotAuto();
    }

    private void initRobotAuto()
    {
        if(hasEncoders)
        {
            leftMotor.setChannelMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
            rightMotor.setChannelMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        }
    }

    public void runAutonomous()
    {

    }

    //Takes a power and distance and translates that to the Robot.drive method
    private void driveForward(double power, double distance)
    {
        if(hasEncoders) {
            driveForwardEncoders(power, distance);
            return;
        }
        //TODO: find rpm of motors at full power

        //TODO: multiply by abs value of power to get adjusted rpm

        //TODO: divide rpm by distance to get rotations
    }

    //TODO: Implement encoder support for driveForward
    private void driveForwardEncoders(double power, double distance)
    {

    }

    //TODO: Implement turning methods
    private void turnLeft(int degrees)
    {

    }

    private void turnRight(int degrees)
    {

    }
}
