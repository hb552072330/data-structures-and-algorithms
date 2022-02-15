package cn.baymax.example.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhanghongbing
 * @data 2021/12/21
 */
public class CompareTest {

    public static void main(String[] args) {

        List<P> list = new ArrayList<P>(){{
            add(new P(new BigDecimal(12)));
            add(new P(new BigDecimal(81)));
            add(new P(new BigDecimal(22)));
            add(new P(new BigDecimal(62)));
        }};

        System.out.println("unsort: " + list);
        Collections.sort(list, new Comparator<P>() {
            @Override
            public int compare(P o1, P o2) {
                return o2.getQty().compareTo(o1.getQty());
            }
        });
        System.out.println("sort desc: " + list);
        Collections.sort(list, new Comparator<P>() {
            @Override
            public int compare(P o1, P o2) {
                return o1.getQty().compareTo(o2.getQty());
            }
        });
        System.out.println("sort  asc: " + list);

    }

    static class P{
        public P(BigDecimal qty) {
            this.qty = qty;
        }

        public P() {
        }

        private BigDecimal qty;

        public BigDecimal getQty() {
            return qty;
        }

        public void setQty(BigDecimal qty) {
            this.qty = qty;
        }

        @Override
        public String toString() {
            return "P{" +
                    "qty=" + qty +
                    '}';
        }
    }
}
