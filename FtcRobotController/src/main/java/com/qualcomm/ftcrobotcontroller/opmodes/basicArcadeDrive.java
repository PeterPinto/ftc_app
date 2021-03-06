package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Peter on 11/3/2015.
 */
public class basicArcadeDrive extends OpMode{

    DcMotor motor1, motor2;
    Robot robot;

    @Override
    public void init() {

        motor1 = hardwareMap.dcMotor.get("m1");
        motor2 = hardwareMap.dcMotor.get("m2");

        robot = new Robot(Robot.ARCADE_DRIVE, motor1, motor2);
    }

    @Override
    public void loop() {
        robot.drive(gamepad1);
    }
}
