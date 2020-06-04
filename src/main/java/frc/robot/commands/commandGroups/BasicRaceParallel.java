package frc.robot.commands.commandGroups;

import frc.robot.commands.TimerCommand;
import frc.robot.commands.DBugCommandInfra.DBugCommandGroup;
import frc.robot.subsystems.ExampleSubsystem;

/**
 * BasicWaitParallel
 */
public class BasicRaceParallel extends DBugCommandGroup {

    public BasicRaceParallel(boolean verbose) {
        addRaceParallel(() ->  new TimerCommand(new ExampleSubsystem(), 7, "7 times", verbose),
                        () ->  new TimerCommand(new ExampleSubsystem(), 3, "3 times", verbose));
    }

    public BasicRaceParallel() {
        this(false);
    }
}