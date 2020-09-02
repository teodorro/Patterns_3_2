public class JumpLeftCommand implements FrogCommand {
    private int steps;
    private Frog frog;

    public JumpLeftCommand(Frog frog, int steps) {
        this.steps = steps;
        this.frog = frog;
    }

    @Override
    public boolean doIt() {
        return frog.jump(-steps);
    }

    @Override
    public boolean undo() {
        return frog.jump(steps);
    }
}
