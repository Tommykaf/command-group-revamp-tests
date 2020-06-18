package frc.robot.commands;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import frc.robot.Utils;
import frc.robot.commands.DBugCommandInfra.DBugCommandGroup;
import frc.robot.commands.commandGroups.BasicDeadlineParallel;
import frc.robot.commands.commandGroups.BasicRaceParallel;
import frc.robot.commands.commandGroups.BasicWaitParallel;

public class TestParallels {
    private int defaultTolerance = 5;

    @Test
    public void testBasicWaitParallel() {
        DBugCommandGroup cmd = new BasicWaitParallel();
        int expected = 700;
        int iterations = 0;
        while (!cmd.isFinished()) {
            iterations++;
            TestCommands.runCommand(cmd, false);
        }

        assertTrue(Utils.inRange(iterations, expected, Math.max(expected / 20, defaultTolerance)));
    }
    
    @Test
    public void testBasicRaceParallel() {
        DBugCommandGroup cmd = new BasicRaceParallel();
        int expected = 300;
        int iterations = 0;
        while (!cmd.isFinished()) {
            iterations++;
            TestCommands.runCommand(cmd, false);
        }

        assertTrue(Utils.inRange(iterations, expected, Math.max(expected / 20, defaultTolerance)));
    }
    
    @Test
    public void testBasicDeadlineParallel() {
        DBugCommandGroup cmd = new BasicDeadlineParallel();
        int expected = 400;
        int iterations = 0;
        while (!cmd.isFinished()) {
            TestCommands.runCommand(cmd, false);
            iterations++;
        }

        assertTrue(Utils.inRange(iterations, expected, Math.max(expected / 20, defaultTolerance)));
    }
    
}