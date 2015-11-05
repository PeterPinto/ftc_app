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

        robot.driveForward(0.1, 5.0);
    }

}
