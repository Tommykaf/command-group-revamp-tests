package frc.robot.commands.commandGroups;

import frc.robot.commands.JitteryTimerCommand;
import frc.robot.commands.DBugCommandInfra.DBugCommandGroup;
import frc.robot.subsystems.ExampleSubsystem;

/**
 * BasicWaitParallel
 */
public class JitteryRaceParallel extends DBugCommandGroup {

    public JitteryRaceParallel(boolean verbose) {
        addRaceParallel(() ->  new JitteryTimerCommand(new ExampleSubsystem(), 50, "50 cycles", verbose),
                        () ->  new JitteryTimerCommand(new ExampleSubsystem(), 100, "100 cycles", verbose));
    }

    public JitteryRaceParallel() {
        this(false);
    }
}