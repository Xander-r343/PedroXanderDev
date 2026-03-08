package org.firstinspires.ftc.teamcode.pedroPathing;

import com.pedropathing.follower.Follower;

public class TuningReal {
    public static void stopRobot(Follower dt) {
        dt.startTeleopDrive(true);
        dt.setTeleOpDrive(0,0,0,true);
    }
}
