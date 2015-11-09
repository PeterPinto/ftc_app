package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Gamepad;

import java.util.Timer;

/**
 * Created by Peter on 11/2/2015.
 */

/*
 * This class is an extension of Robot for autonomous mode.  This is not an OpMode, but may
 * be implemented in one by creating an object of this class.
 *
 * This is intended to be used with LinearOpMode, not OpMode
 * To implement this class, create a LinearOpMode and use the method runOpMode and throw an InterruptedException
 *      ex. public void runOpMode() throws InterruptedException { //Robot code }
 * This method will not loop.  If looping function is desired use a while loop as follows,
 *      while(opModeIsActive()) { //code to loop }
 *
 */
public class RobotAuto extends Robot {

    private final static double TURN_SPEED = .25;
    private final static int DRIVE_TYPE = Robot.TANK_DRIVE;

    private boolean hasEncoders;
    private double wheelRadius = 5.25;//centimeters TODO: measure wheel radius in centimeters
    private int fullPowerRPS = 2; //This depends on the battery level.  Use a best guess TODO: find rpm of motors at full power
    private double wheelCircumference;

    public RobotAuto(DcMotor left, DcMotor right, boolean encoders)
    {
        super(DRIVE_TYPE, left, right);

        hasEncoders = encoders;

        initRobotAuto();
    }

    private void initRobotAuto()
    {
        setSquareInputs(false);
        wheelCircumference = 2 * Math.PI * wheelRadius;
        if(hasEncoders)
        {
            getLeftMotor().setChannelMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
            getRightMotor().setChannelMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        }
    }

    public void runAutonomous()
    {

    }

    //Takes a power and distance and translates that to the Robot.drive method
    public void driveForward(double power, double distance) throws InterruptedException
    {
        if(hasEncoders) {
            driveForwardEncoders(power, distance);
            return;
        }

        //This method will always be inaccurate.  It is better to use encoders, one per each side.
        int adjustedRPS = (int) power * fullPowerRPS;

        double rotations = distance / wheelCircumference;

        double timeSeconds = rotations / adjustedRPS;
        int timeMilliSeconds = (int) (1000 * timeSeconds);

        drive( 0 , power, 0 , power );

        long startTime = System.currentTimeMillis();
        long endTime = startTime + timeMilliSeconds;

        while(System.currentTimeMillis() < endTime)
            continue;
        //Stop the robot
        drive(0,0,0,0);


    }

    //TODO: Implement encoder support for driveForward
    private void driveForwardEncoders(double power, double distance)
    {

    }

    //2TODO: Implement turning methods
    private void turnLeft(int degrees)
    {

    }

    private void turnRight(int degrees)
    {

    }
}
