package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class testOpMode extends OpMode {

    DcMotor motor1, motor2;
    Robot robot;

    @Override
    public void init() {

        motor1 = hardwareMap.dcMotor.get("m1");
        motor2 = hardwareMap.dcMotor.get("m2");

        robot = new Robot(Robot.TANK_DRIVE, motor1, motor2);
    }

    @Override
    public void loop() {
        robot.drive(gamepad1);
    }
}
