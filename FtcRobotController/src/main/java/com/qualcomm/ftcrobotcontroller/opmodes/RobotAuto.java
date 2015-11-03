package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * Created by Peter on 11/2/2015.
 */
public class RobotAuto extends Robot {

    private boolean hasEncoders;
    private final static double TURN_SPEED = .25;

    public RobotAuto(int driveType, DcMotor left, DcMotor right, boolean encoders)
    {
        super(driveType, left, right);

        hasEncoders = encoders;
    }

    public void runAutonomous()
    {

    }

    private void driveForward(double power, double distance)
    {
        if(hasEncoders) {
            driveForwardEncoders(power, distance);
            return;
        }
        //find rpm of motors at full power

        //multiply by abs value of power to get adjusted rpm

        //divide rpm by distance to get rotations
    }

    private void driveForwardEncoders(double power, double distance)
    {

    }

    private void turnLeft(int degrees)
    {

    }

    private void turnRight(int degrees)
    {

    }
}
