package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by Peter on 11/2/2015.
 */

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.util.Range;

public class Robot {

    public final static int TANK_DRIVE = 1;
    public final static int ARCADE_DRIVE = 2;
    public final static int OMNI_DRIVE = 3;
    private int DRIVE_TYPE;
    private boolean squareInputs = false;

    private DcMotor leftMotor;
    private DcMotor rightMotor;


    public Robot(DcMotor left, DcMotor right, int driveType) {

        leftMotor = left;
        rightMotor = right;

        DRIVE_TYPE = driveType;

        initRobot();
    }

    private void initRobot()
    {
        rightMotor.setDirection(DcMotor.Direction.REVERSE);
    }

    public void drive(Gamepad gamepad)
    {
        double leftX  = gamepad.left_stick_x;
        double leftY  = gamepad.left_stick_y;
        double rightX = gamepad.right_stick_x;
        double rightY = gamepad.right_stick_y;

        drive(leftX, leftY, rightX, rightY);
    }

    public void drive(double leftX, double leftY, double rightX, double rightY)
    {
        double leftPower, rightPower;

        switch(DRIVE_TYPE)
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

            default:
                leftPower  = 0;
                rightPower = 0;
        }

        //set the motor powers
        setMotorPower(leftPower, rightPower);
    }

    private void setMotorPower(double left, double right)
    {
        //Clip values to prevent errors
        left  = Range.clip(left , -1, 1);
        right = Range.clip(right, -1, 1);

        leftMotor.setPower(left);
        rightMotor.setPower(right);
    }


}
