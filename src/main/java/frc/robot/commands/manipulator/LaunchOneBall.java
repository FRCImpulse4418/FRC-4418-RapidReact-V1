package frc.robot.commands.manipulator;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.commands.autonomous.WaitFor;
import frc.robot.subsystems.Autonomous;
import frc.robot.subsystems.Manipulator;


public class LaunchOneBall extends SequentialCommandGroup {
	public LaunchOneBall(Manipulator manipulator) {
		super(
			new RunLauncher(manipulator, Autonomous.getLauncherAutoRPM()),
			new WaitFor(Autonomous.getOneBallFiringDurationSeconds()),
			new IdleLauncher(manipulator)
		);
	}
}