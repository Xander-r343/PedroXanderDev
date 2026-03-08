
package org.firstinspires.ftc.teamcode.pedroPathing;

import android.media.tv.AitInfo;

import com.pedropathing.paths.Path;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.bylazar.configurables.annotations.Configurable;
import com.bylazar.telemetry.TelemetryManager;
import com.bylazar.telemetry.PanelsTelemetry;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;
import com.pedropathing.geometry.BezierCurve;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.follower.Follower;
import com.pedropathing.paths.PathChain;
import com.pedropathing.geometry.Pose;


@Autonomous(name = "Pedro Pathing Autonomous", group = "Autonomous")
@Configurable // Panels
public class FunAuto extends OpMode {
    private TelemetryManager panelsTelemetry; // Panels Telemetry instance
    public Follower follower; // Pedro Pathing follower instance
    private int pathState; // Current autonomous path state (state machine)
    private int AutoState = 0;


    @Override
    public void init() {
        panelsTelemetry = PanelsTelemetry.INSTANCE.getTelemetry();

        follower = Constants.createFollower(hardwareMap);
        buildPaths(); // Build paths

        follower.setStartingPose(new Pose(88, 8, Math.toRadians(90)));
        panelsTelemetry.debug("Status", "Initialized");
        panelsTelemetry.update(telemetry);
    }

    @Override
    public void loop() {
        follower.update(); // Update Pedro Pathing
        pathState = autonomousPathUpdate(); // Update autonomous state machine
        // Log values to Panels and Driver Station
        autonomousPathUpdate();
        panelsTelemetry.debug("Path State", pathState);
        panelsTelemetry.debug("X", follower.getPose().getX());
        panelsTelemetry.debug("Y", follower.getPose().getY());
        panelsTelemetry.debug("Heading", follower.getPose().getHeading());
        panelsTelemetry.update(telemetry);
        switch (AutoState){
            case 0:
                follower.followPath(Path1);
                AutoState = 1;
                break;
            case 1:
                if(!follower.isBusy() ) {
                    follower.followPath(Path2);
                    AutoState = 2;
                    break;
                }
                else{
                    break;
                }
            case 2:
                if(!follower.isBusy()) {
                    follower.followPath(Path3);
                    AutoState = 3;
                    break;
                }
                else{
                    break;
                }
            case 3:
                if(!follower.isBusy()) {
                    follower.followPath(Path4);
                    AutoState = 4;
                    break;
                }
                else{
                    break;
                }
            case 4:
                if(!follower.isBusy()) {
                    follower.followPath(Path5);
                    AutoState = 5;
                    break;
                }
                else{
                    break;
                }
            case 5:
                if(!follower.isBusy()) {
                    follower.followPath(Path6);
                    AutoState = 6;
                    break;
                }
                else{
                    break;
                }
            case 6:
                if(!follower.isBusy()) {
                    follower.followPath(Path7);
                    AutoState = 7;
                    break;
                }
                else{
                    break;
                }
            case 7:
                if(!follower.isBusy()) {
                    follower.followPath(Path8);
                    AutoState = 8;
                    break;
                }
                else{
                    break;
                }
            case 8:
                if(!follower.isBusy()) {
                    follower.followPath(Path9);
                    AutoState = 9;
                    break;
                }
                else{
                    break;
                }
            case 9:
                if(!follower.isBusy()) {
                   requestOpModeStop();
                }
                else{
                    break;
                }





        }
    }
    public PathChain Path1;
    public PathChain Path2;
    public PathChain Path3;
    public PathChain Path4;
    public PathChain Path5;
    public PathChain Path6;
    public PathChain Path7;
    public PathChain Path8;
    public PathChain Path9;

    public void buildPaths() {
        /* This is our scorePreload path. We are using a BezierLine, which is a straight line. */
    /* Here is an example for Constant Interpolation
    scorePreload.setConstantInterpolation(startPose.getHeading()); */
            Path1 = follower.pathBuilder().addPath(
                            new BezierCurve(
                                    new Pose(88.000, 8.000),
                                    new Pose(84.000, 36.000),
                                    new Pose(109.000, 35.500)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(90), Math.toRadians(0))

                    .build();

            Path2 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(109.000, 35.500),

                                    new Pose(135.000, 35.500)
                            )
                    ).setTangentHeadingInterpolation()

                    .build();

            Path3 = follower.pathBuilder().addPath(
                            new BezierCurve(
                                    new Pose(135.000, 35.500),
                                    new Pose(84.790, 36.957),
                                    new Pose(88.000, 8.000)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(90))

                    .build();
        Path4 = follower.pathBuilder().addPath(
                        new BezierCurve(
                                new Pose(88.000, 8.000),
                                new Pose(84.902, 54.407),
                                new Pose(109.000, 60.000)
                        )
                ).setLinearHeadingInterpolation(Math.toRadians(90), Math.toRadians(0))

                .build();

        Path5 = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(109.000, 60.000),

                                new Pose(135.000, 60.000)
                        )
                ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0))

                .build();

        Path6 = follower.pathBuilder().addPath(
                        new BezierCurve(
                                new Pose(135.000, 60.000),
                                new Pose(81.660, 63.127),
                                new Pose(88.000, 8.000)
                        )
                ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(90))

                .build();

        Path7 = follower.pathBuilder().addPath(
                        new BezierCurve(
                                new Pose(88.000, 8.000),
                                new Pose(84.490, 77.693),
                                new Pose(109.000, 84.000)
                        )
                ).setLinearHeadingInterpolation(Math.toRadians(90), Math.toRadians(0))

                .build();

        Path8 = follower.pathBuilder().addPath(
                        new BezierLine(
                                new Pose(109.000, 84.000),

                                new Pose(130.000, 84.000)
                        )
                ).setTangentHeadingInterpolation()

                .build();
        Path9 = follower.pathBuilder().addPath(
                        new BezierCurve(
                                new Pose(130.000, 84.000),
                                new Pose(83.160, 62.215),
                                new Pose(88.000, 8.000)
                        )
                ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(90))

                .build();
    }











    public int autonomousPathUpdate() {
        // Event markers will automatically trigger at their positions
        // Make sure to register NamedCommands in your RobotContainer
        return pathState;
    }


}
    