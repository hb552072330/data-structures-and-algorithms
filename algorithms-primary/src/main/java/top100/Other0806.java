package top100;

import java.util.ArrayList;
import java.util.List;

public class Other0806 {
    public static void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {

        dp(A.size(), A, C, B);
    }

    private static void dp(int N, List<Integer> from, List<Integer> to, List<Integer> other) {

        if (N == 1) {
            //N -> from 到 to
            // ans.add(from.get(0));
            to.add(0,from.get(0));
            from.remove(0);
            return;
        }
        System.out.println( "from: " + from);
        //N-1 位置需要 from -> other
        dp(N-1, from, other, to);
        to.add(0, from.get(0));
        from.remove(0);
        //N-2 位置需要 other -> to
        dp(N-1, other, to, from);
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        for (int i = 5; i >=0; i--) {
            A.add(i);
        }
        System.out.println(A);
        ArrayList<Integer> c = new ArrayList<>();
        hanota(A, new ArrayList<>(), c);
        System.out.println(c);
    }

}
