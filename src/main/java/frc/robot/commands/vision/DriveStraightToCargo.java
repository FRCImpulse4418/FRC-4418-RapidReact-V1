package frc.robot.commands.vision;


import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Vision;


// TODO: P2 Implement DriveStraightToCargo command
public class DriveStraightToCargo extends CommandBase {
	private final Drivetrain m_drivetrain;
	private final Vision m_vision;

	public DriveStraightToCargo(Drivetrain drivetrain, Vision vision) {
		m_drivetrain = drivetrain;
		m_vision = vision;
	}

	@Override
	public void initialize() {}

	@Override
	public void execute() {}

	@Override
	public void end(boolean interrupted) {}

	@Override
	public boolean isFinished() {
		return false;
	}
}
