package src;
public abstract class Player {
    protected char mark;

    protected Player(char mark) {
        this.mark=mark;
    }

    public char getMark() {
        return mark;
    }

    public abstract Move makeMove(Board board);
}