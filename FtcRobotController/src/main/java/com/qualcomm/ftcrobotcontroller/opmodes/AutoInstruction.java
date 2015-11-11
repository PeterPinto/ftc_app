package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.util.Range;

/**
 * Created by Peter on 11/11/2015.
 */
public class AutoInstruction {

    private State state;
    private double power;
    private double distance;
    private double degrees;

    public AutoInstruction(State s, double pow, double dist, double deg)
    {
        state = s;
        power = pow;
        distance = dist;
        degrees = deg;

        initAutoInstruction();
    }

    private void initAutoInstruction()
    {
        power = Range.clip(power, -1, 1);

        if(state == State.drivingStraight)
        {
            degrees = 0;
        }

        if(state == State.turning)
        {
            distance = 0;
        }
    }

    public double getPower()
    {
        return power;
    }

    public double getDistance()
    {
        return distance;
    }

    public double getDegrees()
    {
        return degrees;
    }

    public State getState()
    {
        return state;
    }
}
