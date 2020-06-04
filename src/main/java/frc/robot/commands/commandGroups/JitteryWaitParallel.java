package frc.robot.commands.commandGroups;

import frc.robot.commands.JitteryTimerCommand;
import frc.robot.commands.DBugCommandInfra.DBugCommandGroup;
import frc.robot.subsystems.ExampleSubsystem;

/**
 * BasicWaitParallel
 */
public class JitteryWaitParallel extends DBugCommandGroup {

    public JitteryWaitParallel(boolean verbose) {
        addWaitParallel(() ->  new JitteryTimerCommand(new ExampleSubsystem(), 50, "50 cycles", verbose),
                        () ->  new JitteryTimerCommand(new ExampleSubsystem(), 200, "200 cycles", verbose));
    }

    public JitteryWaitParallel() {
        this(false);
    }
    
}