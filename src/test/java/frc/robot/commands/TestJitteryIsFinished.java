package frc.robot.commands;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import frc.robot.Utils;
import frc.robot.commands.DBugCommandInfra.DBugCommandGroup;
import frc.robot.commands.commandGroups.JitteryDeadlineParallel;
import frc.robot.commands.commandGroups.JitteryRaceParallel;
import frc.robot.commands.commandGroups.JitteryWaitParallel;

public class TestJitteryIsFinished {
    private int defaultTolerance = 5;

    @Test
    public void testJitteryWaitParallel() {
        DBugCommandGroup cmd = new JitteryWaitParallel();
        int expected = 200;
        int iterations = 0;
        while (!cmd.isFinished()) {
            iterations++;
            TestCommands.runCommand(cmd, false);
        }

        assertTrue(Utils.inRange(iterations, expected, Math.max(expected / 20, defaultTolerance)));
    }
    
    @Test
    public void testJitteryRaceParallel() {
        DBugCommandGroup cmd = new JitteryRaceParallel();
        int expected = 50;
        int iterations = 0;
        while (!cmd.isFinished()) {
            iterations++;
            TestCommands.runCommand(cmd, false);
        }

        assertTrue(Utils.inRange(iterations, expected, Math.max(expected / 20, defaultTolerance)));
        
        
    }
    
    @Test
    public void testJitteryDeadlineParallel() {
        DBugCommandGroup cmd = new JitteryDeadlineParallel();
        int expected = 100;
        int iterations = 0;
        while (!cmd.isFinished()) {
            iterations++;
            TestCommands.runCommand(cmd, false);
        }

        assertTrue(Utils.inRange(iterations, expected, Math.max(expected / 20, defaultTolerance)));    
    }
    
}