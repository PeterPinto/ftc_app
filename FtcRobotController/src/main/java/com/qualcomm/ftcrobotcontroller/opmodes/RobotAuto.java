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
    enum State {drivingStraight, turning, done};


public class RobotAuto extends Robot {

    private final static double TURN_SPEED = .25;
    private final static int DRIVE_TYPE = Robot.TANK_DRIVE;

    private boolean hasEncoders;
    private double wheelRadius = 5.25;//centimeters TODO: measure wheel radius in centimeters
    private double fullPowerRPS = 11.3; //This depends on the battery level.  Use a best guess TODO: find rpm of motors at full power
    private double wheelCircumference;
    private long millisRemaining;
    private long previousMillis;
    private double drivePower = 0;

    private State state;

    public RobotAuto(DcMotor left, DcMotor right, boolean encoders)
    {
        super(DRIVE_TYPE, left, right);

        hasEncoders = encoders;

        initRobotAuto();
    }

    private void initRobotAuto()
    {
        state = State.done;
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
        switch(state)
        {
            case drivingStraight:
                millisRemaining -= (System.currentTimeMillis() - previousMillis);
                previousMillis = System.currentTimeMillis();
                if(millisRemaining >= 0) {
                    drive(0, drivePower, 0, drivePower);
                } else {
                    state = State.done;
                }

                break;
            case turning:
                break;
            case done:
                drivePower = 0;
                millisRemaining = 0;
                drive(0,0,0,0);
                break;
        }
    }

    //Takes a power and distance and translates that to the Robot.drive method
    public void driveForward(double power, double distance)
    {
        state = State.drivingStraight;
        drivePower = power;
        //This method will always be inaccurate.  It is better to use encoders, one per each side.
        double adjustedRPS = power * fullPowerRPS;

        double rotations = distance / wheelCircumference;
        double timeSeconds = rotations * (1 / adjustedRPS);
        double timeMilliSeconds = 1000 * timeSeconds;

        millisRemaining = (int) timeMilliSeconds;
        previousMillis = System.currentTimeMillis();

    }

    //TODO: Implement turning methods
    private void turnLeft(int degrees)
    {

    }

    private void turnRight(int degrees)
    {

    }

    public State getState() {
        return state;
    }
}
