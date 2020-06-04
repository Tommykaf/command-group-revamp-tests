package frc.robot.commands.commandGroups;

import frc.robot.commands.JitteryTimerCommand;
import frc.robot.commands.DBugCommandInfra.DBugCommandGroup;
import frc.robot.subsystems.ExampleSubsystem;

/**
 * BasicWaitParallel
 */
public class JitteryDeadlineParallel extends DBugCommandGroup {

    public JitteryDeadlineParallel(boolean verbose) {
        addDeadlineParallel(() ->  new JitteryTimerCommand(new ExampleSubsystem(), 100, "DEADLINE - 100 cycles", verbose),
                        () ->  new JitteryTimerCommand(new ExampleSubsystem(), 50, "50 cycles", verbose),
                        () ->  new JitteryTimerCommand(new ExampleSubsystem(), 200, "200 cycles", verbose));
    }

    public JitteryDeadlineParallel() {
        this(false);
    }
}