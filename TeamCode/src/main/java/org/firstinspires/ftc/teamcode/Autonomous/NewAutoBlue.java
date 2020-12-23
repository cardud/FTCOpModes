package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.HardwareMap.HardwareMap_Example;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

@Autonomous(name="plz don't delete", group="Blue auto")

public class NewAutoBlue extends LinearOpMode {
    HardwareMap_Example robot = new HardwareMap_Example();
    private ElapsedTime runtime = new ElapsedTime();


    /*
        CHAWKS: All the values can be moved to HardwareMap? Are these common values?
     */
    static final double COUNTS_PER_MOTOR_REV = 1440;
    static final double DRIVE_GEAR_REDUCTION = 2.0;
    static final double WHEEL_DIAMETER_INCHES = 4.0;
    static final double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);
    static final double DRIVE_SPEED = 0.6;
    static final double TURN_SPEED = 0.5;

    @Override
    public void runOpMode() {
        robot.init(hardwareMap);

        waitForStart();

        encoderDrive(DRIVE_SPEED, 48, 48, 5.0); // speed,left,right,time

        }

    private void encoderDrive(double speed, int LeftInches, int RightInches, double Time) {

        int newLeftTarget;
        int newRightTarget;
        if (opModeIsActive()) {

            // Determine new target position, and pass to motor controller
            newLeftTarget = robot.leftBack.getCurrentPosition() + (int) (LeftInches * COUNTS_PER_INCH);
            newRightTarget = robot.rightBack.getCurrentPosition() + (int) (RightInches * COUNTS_PER_INCH);
            robot.leftBack.setTargetPosition(newLeftTarget);
            robot.rightBack.setTargetPosition(newRightTarget);

            // Turn On RUN_TO_POSITION
            robot.leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            // reset the timeout time and start motion.
            runtime.reset();
            robot.leftBack.setPower(Math.abs(speed));
            robot.rightBack.setPower(Math.abs(speed));


            while (opModeIsActive() &&
                    (runtime.seconds() < Time) &&
                    (robot.leftBack.isBusy() && robot.rightBack.isBusy())) {



            }


            robot.leftBack.setPower(0);
            robot.rightBack.setPower(0);


            robot.leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        }


    }
    }





