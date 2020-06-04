package frc.robot.commands.commandGroups;

import frc.robot.commands.TimerCommand;
import frc.robot.commands.DBugCommandInfra.DBugCommandGroup;
import frc.robot.subsystems.ExampleSubsystem;

/**
 * BasicWaitParallel
 */
public class BasicWaitParallel extends DBugCommandGroup {

    public BasicWaitParallel(boolean verbose) {
        addWaitParallel(() ->  new TimerCommand(new ExampleSubsystem(), 7, "7 times", verbose),
                        () ->  new TimerCommand(new ExampleSubsystem(), 3, "3 times", verbose));
    }

    public BasicWaitParallel() {
        this(false);
    }
    
}