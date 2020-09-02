public class Frog {
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 10;

    private int position;

    public Frog() { position = 5; }

    public boolean jump(int steps){
        int newPosition = position + steps;
        if (newPosition < MIN_POSITION || newPosition > MAX_POSITION)
            return false;
        position = newPosition;
        return true;
    }

    public int getPosition() {
        return position;
    }
}
