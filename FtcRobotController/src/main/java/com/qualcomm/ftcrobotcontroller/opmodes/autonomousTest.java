package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Peter on 11/5/2015.
 */
public class autonomousTest extends LinearOpMode {

    DcMotor motor1, motor2;
    RobotAuto robot;

    @Override
    public void runOpMode() throws InterruptedException {

        motor1 = hardwareMap.dcMotor.get("m1");
        motor2 = hardwareMap.dcMotor.get("m2");
        robot = new RobotAuto(motor1, motor2, false);

        double drivePowerForward = .5;
        double drivePowerReverse = -.5;
        double drivePowerTurning = .05;

        //Add the instructions for autonomous here
        //ex.  robot.addInstruction(new AutoInstruction(State, drivePower, DistanceInCentimenters, DegreesToTurn));
        robot.addInstruction(new AutoInstruction(State.drivingStraight, drivePowerForward, 100, 0));
        robot.addInstruction(new AutoInstruction(State.drivingStraight, drivePowerReverse, 100, 0));

        waitForStart();

        while(opModeIsActive())
            robot.runAutonomous();
    }

}
