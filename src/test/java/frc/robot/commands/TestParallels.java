package frc.robot.commands;

import org.junit.Test;

import frc.robot.commands.DBugCommandInfra.DBugCommandGroup;
import frc.robot.commands.commandGroups.BasicDeadlineParallel;
import frc.robot.commands.commandGroups.BasicRaceParallel;
import frc.robot.commands.commandGroups.BasicWaitParallel;

public class TestParallels {

    @Test
    public void testBasicWaitParallel() {
        DBugCommandGroup cmd = new BasicWaitParallel();
        TestCommands.runCommand(cmd, true);
    }
    
    @Test
    public void testBasicRaceParallel() {
        DBugCommandGroup cmd = new BasicRaceParallel();
        TestCommands.runCommand(cmd, true);
    }

    @Test
    public void testBasicDeadlineParallel() {
        DBugCommandGroup cmd = new BasicDeadlineParallel();
        TestCommands.runCommand(cmd, true);
    }

}