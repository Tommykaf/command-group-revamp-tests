package frc.robot.commands.DBugCommandInfra;

import java.util.List;
import java.util.function.Supplier;

/**
 * DBugCommandGroup
 */
public class DBugRaceParallel extends DBugParallel {

    public DBugRaceParallel(List<Supplier<DBugCommand>> cmds) {
        super(cmds);
    }

    @Override
    public void execute() {
        super.execute();

        if (!this.wasCancelled()) {
            for (DBugCommand cmd : commands) {
                if (cmd.isFinished()) {
                    isFinished = true;
                    break;
                }
            }
        }
    }
}