package codegym.recurrent;

public class HanoiTower {

    public static void move(int n, char source, char target, char auxiliary) {
        if (n==1)
            System.out.println("move " + source + " to " + target);
        else {
            // Move n - 1 disks from source to auxiliary, so they are out of the way
            move(n-1,source,auxiliary,target);
            // Move the nth disk from source to target
            System.out.println("move " + source + " to " + target);
            // Move the n - 1 disks that we left on auxiliary onto target
            move(n-1,auxiliary,target,source);
        }
    }

    public static void main(String[] args) {
        move(3, 'A', 'C', 'B');
    }
}