import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<FrogCommand> commands = new ArrayList<>();
        Frog frog = new Frog();
        int curCommand = -1;

        drawField(frog);

        while (true) {
            String cmdStr = getValidCommand();

            if ("0".equals(cmdStr))
                return;
            else if ("<<".equals(cmdStr)) {
                if (curCommand < 0) {
                    System.out.println("Нечего отменять!");
                } else {
                    commands.get(curCommand).undo();
                    curCommand--;
                }
            } else if ("!!".equals(cmdStr)) {
                if (curCommand < 0) {
                    System.out.println("Нечего повторять!");
                } else {
                    commands.get(curCommand).doIt();
                    curCommand++;
                }
            } else if (">>".equals(cmdStr)) {
                if (curCommand == commands.size() - 1) {
                    System.out.println("Нет отмененной команды!");
                } else {
                    curCommand++;
                    commands.get(curCommand).doIt();
                }
            } else {
                if (curCommand != commands.size() - 1) {
                    int length = commands.size() - 1;
                    for (int i = length; i >= curCommand; i--) {
                        commands.remove(i);
                    }
                }
                FrogCommand cmd = createCommand(cmdStr, frog);
                if (cmd.doIt()){
                    curCommand++;
                    commands.add(cmd);
                }
                else{
                    System.out.println("too far");
                }
            }

            drawField(frog);
        }
    }

    private static void drawField(Frog frog) {
        StringBuilder sb = new StringBuilder("-----------");
        sb.setCharAt(frog.getPosition(), '8');
        System.out.println(sb);
    }

    private static FrogCommand createCommand(String cmd, Frog frog) {
        int steps = Integer.parseInt(cmd.substring(1));
        if (cmd.toCharArray()[0] == '+')
            return new JumpLeftCommand(frog, steps);
        else if (cmd.toCharArray()[0] == '-')
            return new JumpRightCommand(frog, steps);
        else
            return null;
    }

    private static String getValidCommand() {
        while (true) {
            System.out.println("\nВведите команду:");
            System.out.println("+N - прыгни на N шагов направо");
            System.out.println("-N - прыгни на N шагов налево");
            System.out.println("<< - Undo (отмени последнюю команду)");
            System.out.println(">> - Redo (повтори отменённую команду)");
            System.out.println("!! - повтори последнюю команду");
            System.out.println("0 - выход");
            String cmd = scanner.nextLine();
            if (validateCommand(cmd))
                return cmd;
            System.out.println("Недопустимая команда");
        }
    }

    public static boolean validateCommand(String cmd) {
        if ("0".equals(cmd) || "!!".equals(cmd) || "<<".equals(cmd) || ">>".equals(cmd))
            return true;
        if ((cmd.toCharArray()[0] == '+' || cmd.toCharArray()[0] == '-')
                && (cmd.substring(1).matches("[0-9]")
                && Integer.parseInt(cmd.substring(1)) > 0 && Integer.parseInt(cmd.substring(1)) < Frog.MAX_POSITION))
            return true;
        return false;
    }


}
