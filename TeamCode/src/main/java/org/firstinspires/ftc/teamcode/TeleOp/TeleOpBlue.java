package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;



@TeleOp
public class TeleOpBlue extends LinearOpMode {


    // maybe chnage the names casue FR also is used ofr File Reader i dont think we will need it but
// the ide keeps inporting it

    private DcMotor BR = null;
    private DcMotor BL = null;
    private DcMotor FR = null;
    private DcMotor FL = null;
    // please chcek the spelling of the motor names in the config file
    @Override
    public void runOpMode() throws InterruptedException {

        BR = hardwareMap.dcMotor.get("back_right_motor");
        BL = hardwareMap.dcMotor.get("back_left_motor");
        FR = hardwareMap.dcMotor.get("front_right_motor");
        FL = hardwareMap.dcMotor.get("front_left_motor");


        BL.setDirection(DcMotorSimple.Direction.REVERSE);
        FL.setDirection(DcMotorSimple.Direction.REVERSE);
        BR.setDirection(DcMotorSimple.Direction.FORWARD);
        FR.setDirection(DcMotorSimple.Direction.FORWARD);


        waitForStart();

        /*

         */

        //double x1 = 0;
        // double y1 = 0;


        while (opModeIsActive()) {

            // x1.setPower(gamepad1.left_stick_x);
            //  y1.setPower(-gamepad1.left_stick_y);

            double y = -gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x*1.5;
            double rx = gamepad1.right_stick_x;

            wDrive(y, x, rx);


            idle();

        }


    }

    private void wDrive(double y, double x, double rx) {
        y = Math.abs(y) > 0.01 ? y : 0;
        x = Math.abs(y) > 0.01 ? x : 0;
        rx = Math.abs(y) > 0.01 ? rx : 0;

        FL.setPower(y + x + rx) ;
        BL.setPower(y - x + rx) ;
        FR.setPower(y - x - rx) ;
        BR.setPower(y + x - rx) ;
    }


}
