package Compaction_6604778;

import java.util.LinkedList;

public class Process {
	//this file works with files form package Compaction_6604778 only
    private LinkedList<Integer> segments; // id - memory allocated

    public Process() {
        this.segments = new LinkedList<Integer>();
    }

    public Process(LinkedList<Integer> segments) {
        this.segments = segments;
    }

    //updates segments within the process
    public void update(LinkedList<Integer> segments) {
        for(int i = 0; i < this.segments.size(); i++) {
            Integer segment = this.segments.get(i);
            this.segments.set(i, segment + segments.get(i));
        }
    }

    @Override
    public String toString() {
        StringBuilder segments = new StringBuilder();
        for(int segment: this.segments) {
            segments.append("[A").append(segment).append("]");
        }
        return segments.toString();
    }
}
