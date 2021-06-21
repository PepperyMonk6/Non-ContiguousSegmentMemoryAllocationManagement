package Compaction_6604778;

public class Test {
	//this file works with files form package Compaction_6604778 only
    public static void main(String[] args) {
        int[] step_1 = {1, 100, 100, 10};
        int[] step_2 = {2, 200};
        int[] step_3 = {1, -40, 0, 0};
        int[] step_4 = {2, -10, 300};
        int[] step_5 = {3, 180, 60};

        Memory memory = new Memory(900);
        memory.applyStep(step_1);
        System.out.println(memory);
        memory.applyStep(step_2);
        System.out.println(memory);
        memory.applyStep(step_3);
        System.out.println(memory);
        memory.applyStep(step_4);
        System.out.println(memory);
        memory.applyStep(step_5);
        System.out.println(memory);
    }
}
