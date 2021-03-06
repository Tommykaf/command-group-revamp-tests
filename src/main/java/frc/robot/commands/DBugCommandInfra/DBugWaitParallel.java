package frc.robot.commands.DBugCommandInfra;

import java.util.List;
import java.util.function.Supplier;

/**
 * DBugCommandGroup
 */
public class DBugWaitParallel extends DBugParallel {

    public DBugWaitParallel(List<Supplier<DBugCommand>> cmds) {
        super(cmds);
    }

    @Override
    public void execute() {
        super.execute();
        
        //Check if all command are done - if so make isFinished true
        if (!this.wasCancelled()) {
            boolean isDone = true;
            for (DBugCommand cmd : commands) {
                if (!cmd.isFinished()) {
                    isDone = false;
                }
            }
    
            isFinished = isDone;
        }
    }
}