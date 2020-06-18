package frc.robot.commands;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import frc.robot.commands.DBugCommandInfra.DBugCommandGroup;
import frc.robot.commands.commandGroups.BasicDeadlineParallel;
import frc.robot.commands.commandGroups.BasicRaceParallel;
import frc.robot.commands.commandGroups.BasicWaitParallel;
import frc.robot.subsystems.ExampleSubsystem;

public class TestCancelParallels {
    private int defaultTolerance = 5;

    @Test
    public void testCancelWaitParallel() {
        DBugCommandGroup cmd = new BasicWaitParallel();
        int expected = 700;
        int iterations = 0;
        while (iterations < expected / 2) {
            iterations++;
            TestCommands.runCommand(cmd, false);
        }
        cmd.cancel();
        for (int i = 0 ; i < defaultTolerance ; i++) {
            iterations++;
            TestCommands.runCommand(cmd, false);
        }
        
        assertTrue(cmd.wasCancelled());
    }

    @Test
    public void testCancelWaitParallelSubCommand() {
        TimerCommand cmd1 = new TimerCommand(new ExampleSubsystem(), 7, "7 times");
        TimerCommand cmd2 = new TimerCommand(new ExampleSubsystem(), 3, "3 times");
        DBugCommandGroup cmd = new BasicWaitParallel(cmd1,cmd2);
        int expected = 700;
        int iterations = 0;
        while (iterations < expected / 2) {
            iterations++;
            TestCommands.runCommand(cmd, false);
        }
        cmd1.cancel();
        for (int i = 0 ; i < defaultTolerance ; i++) {
            iterations++;
            TestCommands.runCommand(cmd, false);
        }
        
        assertTrue(cmd.wasCancelled());
    }
    
    @Test
    public void testCancelRaceParallel() {
        DBugCommandGroup cmd = new BasicWaitParallel();
        int expected = 300;
        int iterations = 0;
        while (iterations < expected / 2) {
            iterations++;
            TestCommands.runCommand(cmd, false);
        }
        cmd.cancel();
        for (int i = 0 ; i < defaultTolerance ; i++) {
            iterations++;
            TestCommands.runCommand(cmd, false);
        }
        
        assertTrue(cmd.wasCancelled());
    }

    @Test
    public void testCancelRaceParallelSubCommand() {
        TimerCommand cmd1 = new TimerCommand(new ExampleSubsystem(), 7, "7 times");
        TimerCommand cmd2 = new TimerCommand(new ExampleSubsystem(), 3, "3 times");
        DBugCommandGroup cmd = new BasicWaitParallel(cmd1,cmd2);
        int expected = 300;
        int iterations = 0;
        while (iterations < expected / 2) {
            iterations++;
            TestCommands.runCommand(cmd, false);
        }
        cmd1.cancel();
        for (int i = 0 ; i < defaultTolerance ; i++) {
            iterations++;
            TestCommands.runCommand(cmd, false);
        }
        
        assertTrue(cmd.wasCancelled());
    }
    
    @Test
    public void testCancelDeadlineParallel() {
        DBugCommandGroup cmd = new BasicDeadlineParallel();
        int expected = 400;
        int iterations = 0;
        while (iterations < expected / 2) {
            iterations++;
            TestCommands.runCommand(cmd, false);
        }
        cmd.cancel();
        for (int i = 0 ; i < defaultTolerance ; i++) {
            iterations++;
            TestCommands.runCommand(cmd, false);
        }
        
        assertTrue(cmd.wasCancelled());
    }

    @Test
    public void testCancelDeadlineParallelSubcommand() {
        TimerCommand cmd1 = new TimerCommand(new ExampleSubsystem(), 4, "DEADLINE - 4 times");
        TimerCommand cmd2 = new TimerCommand(new ExampleSubsystem(), 2, "2 times");
        TimerCommand cmd3 = new TimerCommand(new ExampleSubsystem(), 4, "6 times");
        DBugCommandGroup cmd = new BasicDeadlineParallel(cmd1,cmd2, cmd3);
        int expected = 400;
        int iterations = 0;
        while (iterations < expected / 2) {
            iterations++;
            TestCommands.runCommand(cmd, false);
        }
        cmd3.cancel();
        for (int i = 0 ; i < defaultTolerance ; i++) {
            iterations++;
            TestCommands.runCommand(cmd, false);
        }
        
        assertTrue(cmd.wasCancelled());
    }
    
}