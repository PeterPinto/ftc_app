package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.ftcrobotcontroller.opmodes.Robot;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Peter on 12/15/2015.
 */
public class TeleOp5354 extends OpMode {

    DcMotor leftMotor, rightMotor, spinMotor;
    Servo servo1, servo2;
    Robot robot;

    @Override
    public void init() {

        leftMotor = hardwareMap.dcMotor.get("left");
        rightMotor = hardwareMap.dcMotor.get("right");
        spinMotor = hardwareMap.dcMotor.get("spin");

        servo1 = hardwareMap.servo.get("servo1");
        servo2 = hardwareMap.servo.get("servo2");


        robot = new Robot(Robot.TANK_DRIVE, leftMotor, rightMotor);
        robot.setSquareInputs(true);
    }

    @Override
    public void loop() {

        robot.drive(gamepad1);

        if(gamepad1.left_bumper)
            servo1.setPosition(0);
        if(gamepad1.left_trigger > 0)
            servo1.setPosition(1);

        if(gamepad1.right_bumper)
            servo2.setPosition(0);
        if(gamepad1.right_trigger > 0)
            servo2.setPosition(1);

        if(gamepad1.a)
            spinMotor.setPower(1);
        else if(gamepad1.b)
            spinMotor.setPower(-1);
        else
            spinMotor.setPower(0);


    }

}
