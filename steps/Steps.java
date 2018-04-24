import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Steps {
    private static void calculate(int steps, int sum) {
        if(steps < 1) return;
        if(sum == 0) sum = steps;

        int step = steps / steps;
        List<List> sequences = new ArrayList<>();
        sequences.add(new ArrayList(Collections.nCopies(steps, step)));

        for(int i = 0; i < sequences.size(); i++) {
            List<List> buf = sequences.stream().map(elem -> new ArrayList(elem)).collect(Collectors.toList());
            List<Integer> current = buf.get(i);

            for(int j = 0; j < current.size(); j++) {
                if(current.get(j) != step * 2) {
                    current.set(j, step * 2);
                    if(!sequences.contains(current)) sequences.add(new ArrayList(current));
                    current.set(j, step);
                }
            }
            if(!sequences.get(sequences.size() - 1).contains(step)) break;
        }
        final int sequenceSum = sum;
        sequences.stream().map(e -> new ArrayList<Integer>(e)).filter(e -> e.stream().reduce(0, Integer::sum) == sequenceSum).forEach(System.out::println);
        calculate(steps - 1, sum);
    }

    private static void process(int steps) {
        calculate(steps, 0);
    }

    public static void main(String[] args) {
        if(args.length > 0) {
            int steps = Integer.valueOf(args[0]);
            process(steps);
        }
    }
}