package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


/*
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvInternalCamera;
import org.openftc.easyopencv.OpenCvPipeline;
*/



@TeleOp(name = "TeleOpBlue!!!", group = "Carina")
public class TeleOpBlue extends LinearOpMode {


    // maybe chnage the names casue FR also is used ofr File Reader i dont think we will need it but
// the ide keeps inporting it
/*
    private DcMotor BR = null;
    private DcMotor BL = null;
    private DcMotor FR = null;
    private DcMotor FL = null;
    //private DcMotor Arm = null;
    //private DcMotor Shooter = null;
//    public Servo servo   = null;
*/
    private DcMotor BR= null;

  /*  public static final double MID_SERVO       =  0.5 ;
  //  public static final double ARM_UP_POWER    =  0.45 ;
    //public static final double ARM_DOWN_POWER  = -0.45 ;



    public static final double ARM_UP_POWER    =  0.45 ;
    public static final double ARM_DOWN_POWER  = -0.45 ;
*/

    // please chcek the spelling of the motor names in the config file
    //@Override
    public void runOpMode() throws InterruptedException {
/*
        BR = hardwareMap.dcMotor.get("BR");
        BL = hardwareMap.dcMotor.get("BL");
        FR = hardwareMap.dcMotor.get("FR");
        FL = hardwareMap.dcMotor.get("FL");*/
        BR = hardwareMap.dcMotor.get("BR");
       // Arm = hardwareMap.dcMotor.get("arm");
        //Shooter= hardwareMap.dcMotor.get("shooter");

        //servo = hardwareMap.get(Servo.class, "Servo");
        //servo.setPosition(MID_SERVO);



/*
        BL.setDirection(DcMotorSimple.Direction.REVERSE);
        FL.setDirection(DcMotorSimple.Direction.REVERSE);
        BR.setDirection(DcMotorSimple.Direction.FORWARD);
        FR.setDirection(DcMotorSimple.Direction.FORWARD);
        */
        BR.setDirection(DcMotorSimple.Direction.FORWARD);

      //  Shooter.setDirection(DcMotorSimple.Direction.FORWARD);


        waitForStart();




        while (opModeIsActive()) {

            // x1.setPower(gamepad1.left_stick_x);
            //  y1.setPower(-gamepad1.left_stick_y);
            /*
            Arm.setPower(.25);
            if(gamepad1.left_bumper == true){
                Arm.setDirection(DcMotorSimple.Direction.FORWARD);
            } else{
                Arm.setDirection(DcMotorSimple.Direction.REVERSE);
            }

            boolean shoot = gamepad1.b;
*/

            System.out.println("ran");

            double y = -gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x*1.5;
            double rx = gamepad1.right_stick_x;

            //wDrive(y, x, rx);

            double y1 = 0;
            double x1 = 0;
            double rx1 = 0;
            wDrive(y1, x1, rx1);





        }



    }

    private void wDrive(double y, double x, double rx) {
        y = Math.abs(y) > 0.01 ? y : 0;
        x = Math.abs(y) > 0.01 ? x : 0;
        rx = Math.abs(y) > 0.01 ? rx : 0;

        /*FL.setPower(y + x + rx) ;
        BL.setPower(y - x + rx) ;
        FR.setPower(y - x - rx) ;

         */
        BR.setPower(y + x - rx) ;
    }



}
