package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion;
@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "FirstTeleOp", group = "BlueTeleOp")



public class MechanumTeleOp<LeftDrive> extends LinearOpMode {
    //import HardwareMap here
    HardwareMap Samantha = new HardwareMap();
    //robot is now named samantha
    @Override
    public void runOpMode() throws InterruptedException{
        //declare variables before waitForStart();
        double Drive;
        double Strafe;
        double Rotate;
        //the three direction the robot sam can do

        double frontRightSpeed;
        double frontLeftSpeed;
        double backRightSpeed;
        double backLeftSpeed;

        //arm set at full speed
        double armSpeed = 1.0;




        waitForStart();
        while (opModeIsActive()){
            //taking info from game pad
            Drive = gamepad1.left_stick_y;
            Strafe = gamepad1.left_stick_x;
            Rotate = gamepad1.right_stick_x;

            //DriveSpeed

            frontRightSpeed = Drive + Strafe - Rotate;
            frontLeftSpeed = Drive - Strafe + Rotate;
            backRightSpeed = Drive - Strafe - Rotate;
            backLeftSpeed = Drive + Strafe + Rotate;

            //setting power/ samantha is the robot/
            Samantha.frontRightMotor.setPower(frontRightSpeed);
            Samantha.frontLeftMotor.setPower(frontLeftSpeed);
            Samantha.backRightMotor.setPower(backRightSpeed);
            Samantha.backLeftMotor.setPower(backLeftSpeed);


            //moves arm forward
            if (gamepad1.right_bumper){
                Samantha.armMotor.setPower(armSpeed);

            }
            //moves arm backwards
            else if (gamepad1.left_bumper){
                Samantha.armMotor.setPower(-armSpeed);

            }
            //telling it to do nothing while not pressed
            else
            {
                Samantha.armMotor.setPower(0);
            }


        }

    }
//log of buttons
    //right trig  ger to make arm go forward
    //left trigger to make arm go back
    //arm set at full speed /(1.0) is full speed







}
