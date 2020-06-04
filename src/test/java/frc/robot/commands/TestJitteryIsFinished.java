package frc.robot.commands;

import org.junit.Test;

import frc.robot.commands.DBugCommandInfra.DBugCommandGroup;
import frc.robot.commands.commandGroups.JitteryDeadlineParallel;
import frc.robot.commands.commandGroups.JitteryRaceParallel;
import frc.robot.commands.commandGroups.JitteryWaitParallel;

public class TestJitteryIsFinished {

    @Test
    public void testJitteryWaitParallel() {
        DBugCommandGroup cmd = new JitteryWaitParallel();
        TestCommands.runCommand(cmd, true);
    }
    
    @Test
    public void testBasicRaceParallel() {
        DBugCommandGroup cmd = new JitteryRaceParallel();
        TestCommands.runCommand(cmd, true);
    }

    @Test
    public void testBasicDeadlineParallel() {
        DBugCommandGroup cmd = new JitteryDeadlineParallel(true);
        TestCommands.runCommand(cmd, true);
    }

}