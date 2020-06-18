package frc.robot.commands.DBugCommandInfra;

import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An abstract command class which logs info about the command to the logger.
 */
public abstract class DBugCommand extends CommandBase {

  protected boolean wasCancelled = false;
  protected boolean hasFinished = false;

  @Override
  public final void initialize() {
    wasCancelled = false;
    hasFinished = false;
    init();
  }

  public abstract void init ();

  @Override
  public abstract void execute();

  @Override
  public final boolean isFinished() {
    hasFinished = hasFinished || endCondition();
    return hasFinished;
  }

  public abstract boolean endCondition();

  
  @Override
  public void cancel() {
    wasCancelled = true;
    super.cancel();
  }
  
  public final boolean wasCancelled() {
    return wasCancelled;
  };
  
  @Override
  public void end(boolean interrupted) {
    fin(interrupted);
  }

  protected abstract void fin (boolean interrupted);
}
