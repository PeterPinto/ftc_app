package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

public class testOpMode extends OpMode {


    DcMotorController motorController;
    DcMotor motor1, motor2, motor3, motor4;
    Servo servo1;
    DcMotorController.DeviceMode devMode;


    @Override
    public void init() {

        motorController = hardwareMap.dcMotorController.get("mc1");
        motor1 = hardwareMap.dcMotor.get("m1");
        motor2 = hardwareMap.dcMotor.get("m2");
        motor3 = hardwareMap.dcMotor.get("m3");
        motor4 = hardwareMap.dcMotor.get("m4");
        motor2.setDirection(DcMotor.Direction.REVERSE);

    }

    @Override
    public void loop() {

        motor1.setPower(gamepad1.left_stick_y);
        motor2.setPower(gamepad1.right_stick_y);

        if(gamepad1.a)
            motor3.setPower(1);
        else if(gamepad1.b)
            motor3.setPower(-1);
        else
            motor3.setPower(0);

        if(gamepad1.x)
            motor4.setPower(1);
        else if(gamepad1.y)
            motor4.setPower(-1);
        else
            motor4.setPower(0);

    }
}
