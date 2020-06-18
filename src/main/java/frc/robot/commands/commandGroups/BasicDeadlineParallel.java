package frc.robot.commands.commandGroups;

import frc.robot.commands.TimerCommand;
import frc.robot.commands.DBugCommandInfra.DBugCommand;
import frc.robot.commands.DBugCommandInfra.DBugCommandGroup;
import frc.robot.subsystems.ExampleSubsystem;

/**
 * BasicWaitParallel
 */
public class BasicDeadlineParallel extends DBugCommandGroup {

    public BasicDeadlineParallel(boolean verbose) {
        addDeadlineParallel(() ->  new TimerCommand(new ExampleSubsystem(), 4, "DEADLINE - 4 times", verbose),
                        () ->  new TimerCommand(new ExampleSubsystem(), 2, "2 times", verbose),
                        () ->  new TimerCommand(new ExampleSubsystem(), 6, "6 times", verbose));
    }

    public BasicDeadlineParallel() {
        this(false);
    }

    public BasicDeadlineParallel(DBugCommand cmd1, DBugCommand cmd2, DBugCommand cmd3) {
        addDeadlineParallel(() ->  cmd1,
                        () ->  cmd2,
                        () -> cmd3);
    }
}