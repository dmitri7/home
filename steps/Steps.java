public class Steps {
    private static void calculate(int steps) {
        System.out.println(steps);
    }

    private static void process(int steps) {
        while(steps > 0) {
            calculate(steps);
            steps--;
        }
    }

    public static void main(String[] args) {
        if(args.length > 0) {
            int steps = Integer.valueOf(args[0]);
            process(steps);
        }
        else System.out.println("This ladder has no steps");
    }
}