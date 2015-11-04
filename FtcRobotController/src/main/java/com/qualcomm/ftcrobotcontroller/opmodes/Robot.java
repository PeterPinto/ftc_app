package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by Peter on 11/2/2015.
 */

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.util.Range;

/*
 * This class was created so that code can be easily reused for new robots.  This is not an OpMode, but may
 * be implemented in one by creating an object of this class.
 *
 * The class contains support for Tank and Arcade drive modes, and is ready for Omni-wheel drive to be implemented.
 *
 * Currently, there is only support for one motor on the left and one on the right.  If more than one motor is desired, attach
 * both motors on the left side into the same channel, and attach both motors on the right side into a channel together.
 */


public class Robot {

    public final static int TANK_DRIVE = 1;
    public final static int ARCADE_DRIVE = 2;
    public final static int OMNI_DRIVE = 3;
    private int driveType;
    private boolean squareInputs = false;

    protected DcMotor leftMotor;
    protected DcMotor rightMotor;
    private DcMotor peripheral1;
    private DcMotor peripheral2;


    public Robot(int drive, DcMotor left, DcMotor right) {

        leftMotor = left;
        rightMotor = right;
        driveType = drive;

        initRobot();
    }

    //Call any important functions at initialization time.  Also set any fields that are unset by the constructor
    private void initRobot()
    {
        rightMotor.setDirection(DcMotor.Direction.REVERSE);
    }

    //Allow for the the robot to be passed the gamepad object instead of setting values directly.
    public void drive(Gamepad gamepad)
    {
        double leftX  = gamepad.left_stick_x;
        double leftY  = gamepad.left_stick_y;
        double rightX = gamepad.right_stick_x;
        double rightY = gamepad.right_stick_y;

        drive(leftX, leftY, rightX, rightY);
    }

    //Takes drive values and converts them into motor power values
    public void drive(double leftX, double leftY, double rightX, double rightY)
    {
        double leftPower, rightPower;

        //Execute different drive code based on the driveType field
        switch(driveType)
        {
            case TANK_DRIVE:
                if(squareInputs)
                {
                    //square the left motor power
                    if(leftY >= 0)
                        leftPower = leftY * leftY;
                    else
                        leftPower = -(leftY * leftY);

                    //square the right motor power
                    if(rightY >= 0)
                        rightPower = rightY * rightY;
                    else
                        rightPower = -(rightY * rightY);

                } else {
                    leftPower = leftY;
                    rightPower = rightY;
                }
                break;

            case ARCADE_DRIVE:
                leftPower = leftY + leftX;
                rightPower = leftY - leftX;
                break;

            //Omni drive not yet implemented

            default:
                leftPower  = 0;
                rightPower = 0;
        }

        //set the motor powers
        setMotorPower(leftPower, rightPower);
    }

    //Sets the power of the motors
    private void setMotorPower(double left, double right)
    {
        //Clip values to prevent errors
        left  = Range.clip(left , -1, 1);
        right = Range.clip(right, -1, 1);

        leftMotor.setPower(left);
        rightMotor.setPower(right);
    }

    //Public get / set methods ***************************

    //squareInputs
    public boolean getSquareInputs()
    {
        return squareInputs;
    }

    public void setSquareInputs(boolean square)
    {
        squareInputs = square;
    }

    //driveType
    public int getDriveType()
    {
        return driveType;
    }

    public void setDriveType(int drive)
    {
        driveType = drive;
    }


    //****************************************************
}
