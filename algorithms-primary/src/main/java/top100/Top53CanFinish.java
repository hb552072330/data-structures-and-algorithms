package top100;

import java.util.*;

public class Top53CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        List<List<Integer>> nexts = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            nexts.add(new ArrayList<>());
        }
        int[] inArr = new int[numCourses];
        for (int[] arr : prerequisites) {
            nexts.get(arr[1]).add(arr[0]);
            inArr[arr[0]]++;
        }
        int[] queue = new int[numCourses];
        int l = 0, r = 0;
        for (int i = 0; i < numCourses; i++) {
            if (inArr[i] == 0) {
                queue[r++] = i;
            }
        }
        int count = 0;
        while (l != r) {
            count++;
            for (Integer next : nexts.get(queue[l++])) {
                if (--inArr[next] == 0) {
                    queue[r++] = next;
                }
            }

        }
        return count == nexts.size();
    }

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        HashMap<Integer, Course> nodes = new HashMap<>();
        for (int[] arr : prerequisites) {
            int to = arr[0];
            int from = arr[1];
            Course t = nodes.getOrDefault(to, new Course(to));
            Course f = nodes.getOrDefault(from, new Course(from));
            f.nexts.add(t);
            t.in++;
            nodes.put(to, t);
            nodes.put(from, f);
        }
        int needPreNums = nodes.size();
        Queue<Course> zeroInQueue = new LinkedList<>();
        for (Course course : nodes.values()) {
            if (course.in == 0) {
                zeroInQueue.add(course);
            }
        }
        int count = 0;
        while (!zeroInQueue.isEmpty()) {
            Course cur = zeroInQueue.poll();
            count++;
            for (Course next : cur.nexts) {
                if (--next.in == 0) {
                    zeroInQueue.offer(next);
                }
            }
        }
        return count == needPreNums;
    }

    public static class Course {
        int name;
        int in;
        List<Course> nexts;

        public Course(int name) {
            this.name = name;
            this.in = 0;
            this.nexts = new ArrayList<>();
        }
    }


    public static void main(String[] args) {

        HashMap<Integer, Course> nodes = new HashMap<>();
    }
}
