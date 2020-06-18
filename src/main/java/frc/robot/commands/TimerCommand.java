package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.commands.DBugCommandInfra.DBugCommand;

public class TimerCommand extends DBugCommand {
    public static int cycles = 100;

    private String name;
    private int iterations;
    private int currentIteration;
    private int placeInCycle;
    private boolean verbose;
    private Subsystem subsystem;


    public TimerCommand(Subsystem subsystem, int iterations, String name, boolean verbose) {
        this.iterations = iterations;
        this.name = name;
        this.currentIteration = 0;
        this.verbose = verbose;
        this.subsystem = subsystem;
        addRequirements(this.subsystem);
    }

    public TimerCommand(Subsystem subsystem, int iterations, String name) {
        this(subsystem, iterations, name, false);
    }
    
    @Override
    public void init() {
        if (verbose) {
            System.out.println(name + " said: TIME TO START");
        }
    }
    
    @Override
    public void execute() {
        if (placeInCycle >= cycles) {
            placeInCycle = 1;
            currentIteration++;
        } else {
            placeInCycle++;
        }
        
        if (verbose) {
            System.out.println(name + " said: Currently in iteration number " + currentIteration);
        }
    }

    @Override
    public boolean endCondition() {
        return currentIteration >= iterations;
    }

    @Override
    protected void fin(boolean interrupted) {
        if (verbose) {
            System.out.println(name + " said: I AM DONE");
        }
    }
}