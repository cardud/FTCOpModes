package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;



@TeleOp
public class TeleOpBlue extends LinearOpMode {




    private DcMotor BR = null;
    private DcMotor BL = null;
    private DcMotor FR = null;
    private DcMotor FL = null;

    @Override
    public void runOpMode() throws InterruptedException {

        BR = hardwareMap.dcMotor.get("BR");
        BL = hardwareMap.dcMotor.get("BL");
        FR = hardwareMap.dcMotor.get("FR");
        FL = hardwareMap.dcMotor.get("FL");


        BL.setDirection(DcMotorSimple.Direction.REVERSE);
        FL.setDirection(DcMotorSimple.Direction.REVERSE);
        BR.setDirection(DcMotorSimple.Direction.FORWARD);
        FR.setDirection(DcMotorSimple.Direction.FORWARD);


        waitForStart();

        while (opModeIsActive()) {
            double y = gamepad1.left_stick_y;
            double x = -gamepad1.left_stick_x*1.5;
            double rx = gamepad1.right_stick_x;

            wDrive(y, x, rx);

            double y1 = 0;
            double x1 = 0;
            double rx1 = 0;
        }
    }

    private void wDrive(double y, double x, double rx) {
        y = Math.abs(y) > 0.01 ? y : 0;
        x = Math.abs(x) > 0.01 ? x : 0;
        rx = Math.abs(rx) > 0.01 ? rx : 0;

        FL.setPower(y + x + rx) ;
        BL.setPower(y - x + rx) ;
        FR.setPower(y - x - rx) ;
        BR.setPower(y + x - rx) ;

    }
}
