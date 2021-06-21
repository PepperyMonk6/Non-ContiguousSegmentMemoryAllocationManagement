package a1a2_6604778;

import java.util.LinkedList;

public class Process {
	//this file works with files form package a1a2_6604778 only
    private int size;
    private int process_id;
    private Memory memory;
    private LinkedList<Segment> segments;

    public Process(Memory memory, int process_id) {
        this.size = 0;
        this.process_id = process_id;
        if(memory.getSize() >= this.size) {
            this.memory = memory;
            this.segments = new LinkedList<Segment>();
            memory.addProcess(this);
        }
        else {
            System.out.println("Process cannot be added to memory");
        }
    }

    //segment addition to process
    public void addSegment(int[] segment_matrix) {
        int segment_size = segment_matrix[0];
        Segment segment = new Segment(segment_size);
        segment.addToProcess(this);
        if(segment_matrix.length > 1  && segment_matrix[1] == 0) {
            for(int i = 2; i < segment_matrix.length; i++) {
                segment.addToProcess(memory.getProcessById(i));
            }
        }
    }

    //if segment already exists within the segments list
    public boolean hasSegmentOnPosition(int position) {
        return this.segments.size() > position;
    }

    //update of the segment using matrix(array) on a specific position
    public Segment updateSegmentOnPosition(int[] segment_matrix, int position) {
        Segment segment = segments.get(position);
        return segment.updateBy(segment_matrix, this);
    }

    //removal of empty segments
    public void removeEmptySegments() {
        for(int i = 0; i < segments.size(); i++) {
            if(segments.get(i).getSize() == 0) {
                segments.remove(i);
            }
        }
    }

    //recalculating the size of a process
    public int recalculateSize(){
        this.size = 0;
        for(Segment segment: this.segments) {
            this.size += segment.getSize();
        }
        return this.size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getProcess_id() {
        return process_id;
    }

    public void setProcess_id(int process_id) {
        this.process_id = process_id;
    }

    public Memory getMemory() {
        return memory;
    }

    public LinkedList<Segment> getSegments() {
        return segments;
    }

    @Override
    public String toString() {
        String segments_string = "[\n";
        for(int i = 0; i < this.segments.size(); i++) {
            segments_string += "\t\t\t" + segments.get(i) + "\n";
        }
        segments_string += "\t\t]";
        return "Process{" +
                "size=" + size +
                ", process_id=" + process_id +
                '}' +
                "\n\t\tsegments=" + segments_string;
    }
}
