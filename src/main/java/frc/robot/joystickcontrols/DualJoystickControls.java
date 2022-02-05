package frc.robot.joystickcontrols;


import edu.wpi.first.wpilibj.Joystick;

import frc.robot.commands.DriveStraightWhileHeld;
import frc.robot.commands.RunIndexer;
import frc.robot.commands.RunLauncher;
import frc.robot.commands.RunReverseFeeder;
import frc.robot.commands.RunFeeder;
import frc.robot.commands.ToggleFeeder;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Manipulator;


public abstract class DualJoystickControls extends JoystickControls {
    // ----------------------------------------------------------
    // Joysticks

    protected final Joystick m_primaryJoystick;
    protected final Joystick m_secondaryJoystick;

    // ----------------------------------------------------------
    // Constructor

    public DualJoystickControls(Joystick primaryJoystick, Joystick secondaryJoystick, Drivetrain drivetrain, Intake intake, Manipulator manipulator) {
        super(primaryJoystick, drivetrain, intake, manipulator);

        m_primaryJoystick = primaryJoystick;
        m_secondaryJoystick = secondaryJoystick;

        driveStraightPOVButton = driveStraightPOVButton(primaryJoystick);
        if (driveStraightPOVButton != null) driveStraightPOVButton.whenHeld(new DriveStraightWhileHeld(drivetrain));
        driveStraightJoystickButton = driveStraightJoystickButton(primaryJoystick);
        if (driveStraightJoystickButton != null) driveStraightJoystickButton.whenHeld(new DriveStraightWhileHeld(drivetrain));

        runFeederDisposalButton = runFeederDisposalButton(secondaryJoystick);
        if (runFeederDisposalButton != null) runFeederDisposalButton.whenHeld(new RunReverseFeeder(intake));
        runFeederIntakebutton = runFeederButton(secondaryJoystick);
        if (runFeederIntakebutton != null) runFeederIntakebutton.whenHeld(new RunFeeder(intake));
        toggleFeederButton = toggleFeederButton(secondaryJoystick);
        if (toggleFeederButton != null) toggleFeederButton.toggleWhenPressed(new ToggleFeeder(intake));

        runIndexerButton = runIndexerButton(primaryJoystick);
        if (runIndexerButton != null) runIndexerButton.whenHeld(new RunIndexer(manipulator));
        runLauncherButton = runLauncherButton(primaryJoystick);
        if (runLauncherButton != null) runLauncherButton.whenHeld(new RunLauncher(manipulator));
    }
}
