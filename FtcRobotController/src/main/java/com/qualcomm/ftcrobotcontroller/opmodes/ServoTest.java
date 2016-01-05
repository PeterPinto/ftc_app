package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Peter on 12/1/2015.
 */
public class ServoTest extends LinearOpMode{

    private Servo servo;

    @Override
    public void runOpMode() throws java.lang.InterruptedException
    {
        servo = hardwareMap.servo.get("servo");
        waitForStart();
        servo.setPosition(1);
        sleep(1000);
        servo.setPosition(0);
        sleep(1000);
        servo.setPosition(.5);

    }
}
