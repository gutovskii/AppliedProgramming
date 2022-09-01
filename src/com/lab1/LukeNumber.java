package com.lab1;

public class LukeNumber {
    private final int number;
    private final int position;

    /** Constructor
     *
     * @param position luke number position
     */
    public LukeNumber(int position) {
        this.position = position;
        this.number = getLukeNumber(position);
    }

    /** Getter
     *
     * @return luke number
     */
    public int getNumber() {
        return number;
    }

    /** Getter
     *
     * @return luke number position
     */
    public int getPosition() {
        return position;
    }

    /** Gets luke number by its position
     *
     * @param position luke number position
     * @return luke number by position
     */
    private int getLukeNumber(int position) {
        int a = 2;
        int b = 1;
        int c = 0;
        if (position == 1) return a;
        if (position == 2) return b;
        for (int i = 0; i < position - 2; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
