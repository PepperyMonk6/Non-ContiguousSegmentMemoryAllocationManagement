package a1a2_6604778;

public class Test {
	//this file works with files form package a1a2_6604778 only
    public static void main(String[] args) {
        System.out.println("Example 1_1");
    	test1_1();
    	System.out.println("Example 1_2");
        test1_2();
        System.out.println("Example 1_3");
        test1_3();
        System.out.println("Example 2_1");
        test2_1();
        System.out.println("Example 2_2");
        test2_2();
        System.out.println("Example 2_3");
        test2_3();
    }

    public static void test1_1() {
        Memory memory = new Memory(1000);
        int[][] step_1 = {
                {1}, // Process id
                {100}, // Segment 1
                {200}, // Segment 2
                {10}
        };
        int[][] step_2 = {
                {1}, // Process id
                {100}, // Segment 1
                {200}, // Segment 2
                {10}
        };
        System.out.println(memory);
        memory.applyStep(step_1);
        System.out.println(memory);
        memory.applyStep(step_2);
        System.out.println(memory);
    }

    public static void test1_2() {
        Memory memory = new Memory(1000);
        int[][] step_1 = {
                {1}, // Process id
                {100}, // Segment 1
                {200}, // Segment 2
                {10}
        };
        int[][] step_2 = {
                {1}, // Process id
                {-40}, // Segment 1
                {200}, // Segment 2
                {-10}
        };
        System.out.println(memory);
        memory.applyStep(step_1);
        System.out.println(memory);
        memory.applyStep(step_2);
        System.out.println(memory);
    }

    public static void test1_3() {
        Memory memory = new Memory(1000);
        int[][] step_1 = {
                {1}, // Process id
                {100}, // Segment 1
                {200}, // Segment 2
                {10}
        };
        int[][] step_2 = {
                {1}, // Process id
                {-40}, // Segment 1
                {-200}, // Segment 2
                {10}
        };
        int[][] step_3 = {
                {1}, // Process id
                {-40}, // Segment 1
                {200}, // Segment 2
        };
        System.out.println(memory);
        memory.applyStep(step_1);
        System.out.println(memory);
        memory.applyStep(step_2);
        System.out.println(memory);
        memory.applyStep(step_3);
        System.out.println(memory);
    }

    public static void test2_1() {
        Memory memory = new Memory(1000);
        int[][] step_1 = {
                {1}, // Process id
                {100, 0}, // Segment 1
                {200, 0, 2, 3, 4}, // Segment 2
                {10}
        };
        System.out.println(memory);
        memory.applyStep(step_1);
        System.out.println(memory);
    }

    public static void test2_2() {
        Memory memory = new Memory(1000);
        int[][] step_1 = {
                {1}, // Process id
                {100, 0}, // Segment 1
                {200, 0, 2, 3, 4}, // Segment 2
                {10}
        };
        int[][] step_2 = {
                {1}, // Process id
                {-10, 1}, // Segment 1
                {100, 0, 2, 5},
                {10}
        };
        System.out.println(memory);
        memory.applyStep(step_1);
        System.out.println(memory);
        memory.applyStep(step_2);
        System.out.println(memory);
    }

    public static void test2_3() {
        Memory memory = new Memory(1000);
        int[][] step_1 = {
                {1}, // Process id
                {100, 0}, // Segment 1
                {200, 0, 2, 3}, // Segment 2
        };
        int[][] step_2 = {
                {2}, // Process id
                {200, 0, 1, 3}, // Segment 1
        };
        System.out.println(memory);
        memory.applyStep(step_1);
        System.out.println(memory);
        memory.applyStep(step_2);
        System.out.println(memory);
    }
}
