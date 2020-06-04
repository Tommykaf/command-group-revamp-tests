package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.commands.DBugCommandInfra.DBugCommand;

public class JitteryTimerCommand extends DBugCommand {
    
    private String name;
    private int placeInCycle;
    private int cycles = 100;
    private boolean verbose;
    private Subsystem subsystem;


    public JitteryTimerCommand(Subsystem subsystem, int cycles, String name, boolean verbose) {
        this.cycles = cycles;
        this.name = name;
        this.verbose = verbose;
        this.subsystem = subsystem;
        addRequirements(this.subsystem);
    }

    public JitteryTimerCommand(Subsystem subsystem, int cycles, String name) {
        this(subsystem, cycles, name, false);
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
            placeInCycle = 0;
        } else {
            placeInCycle++;
        }
        
        if (verbose) {
            System.out.println(name + " said: Currently in cycle number " + placeInCycle);
        }
    }

    @Override
    public boolean endCondition() {
        boolean isFinished = placeInCycle == cycles;
        if (isFinished) {
            placeInCycle = 0;
        }
        return isFinished;
    }

    @Override
    protected void fin(boolean interrupted) {
        if (verbose) {
            System.out.println(name + " said: I AM DONE");
        }
    }
}