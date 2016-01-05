package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.ftcrobotcontroller.opmodes.Robot;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Peter on 12/15/2015.
 */
public class TeleOp4086 extends OpMode {

    DcMotor leftMotor, rightMotor, conveyorMotor;
    Servo leftServo, rightServo, spongeServo;
    Robot robot;
    private boolean leftServoUp, rightServoUp;

    @Override
    public void init() {

        leftMotor = hardwareMap.dcMotor.get("left");
        rightMotor = hardwareMap.dcMotor.get("right");
        conveyorMotor = hardwareMap.dcMotor.get("conveyor");

        leftServo = hardwareMap.servo.get("leftServo");
        rightServo = hardwareMap.servo.get("rightServo");
        spongeServo = hardwareMap.servo.get("spongeServo");

        spongeServo.setDirection(Servo.Direction.REVERSE);


        robot = new Robot(Robot.TANK_DRIVE, leftMotor, rightMotor);
        robot.setSquareInputs(true);
    }

    @Override
    public void loop() {

        robot.drive(gamepad1);

        if(gamepad2.x) {
            toggleLeftServo();
        }

        if(gamepad2.y) {
            toggleRightServo();
        }

        if(gamepad2.a)
            spongeServo.setPosition(0);
        else
            spongeServo.setPosition(.5);

        if(gamepad2.b)
            conveyorMotor.setPower(1);
        else
            conveyorMotor.setPower(0);



        if(leftServoUp)
            leftServo.setPosition(0);
        else
            leftServo.setPosition(1);

        if(rightServoUp)
            rightServo.setPosition(0);
        else
            rightServo.setPosition(1);

    }

    private void toggleLeftServo() {
        leftServoUp = !leftServoUp;
    }

    private void toggleRightServo() {
        rightServoUp = !rightServoUp;
    }

}
