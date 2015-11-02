package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * Created by Peter on 11/2/2015.
 */
public class RobotAuto extends Robot {


    public RobotAuto(DcMotor left, DcMotor right, int driveType, boolean hasEncoders)
    {
        super(left, right, driveType);
    }

    public void runAutonomous()
    {

    }

    private void driveForward(double power, double distance)
    {
        //find rpm of motors at full power

        //multiply by abs value of power to get adjusted rpm

        //divide rpm by distance to get rotations
    }

    private void turnLeft(int degrees)
    {

    }

    private void turnRight(int degrees)
    {

    }
}
