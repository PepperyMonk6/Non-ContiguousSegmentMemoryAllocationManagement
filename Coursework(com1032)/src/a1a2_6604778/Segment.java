package a1a2_6604778;

import java.util.LinkedList;

public class Segment {
	//this file works with files form package a1a2_6604778 only
    private int size;
    private LinkedList<Integer> belongs_to;

    public Segment(int size) {
        this.size = size;
        this.belongs_to = new LinkedList<>();
    }
    
    //adds segment to process
    public void addToProcess(Process process) {
        if(this.fitsIntoProcess(process)) {
            this.belongs_to.add(process.getProcess_id());
            process.setSize(process.getSize() + this.size);
            process.getSegments().add(this);
        }
    }

    //check is there enough space to add a process
    private boolean fitsIntoProcess(Process process) {
        if(process.getMemory().getSize() < process.getSize() + this.size) {
            System.out.println("Cannot add process");
            return false;
        }
        return true;
    }

    //segment update within the process using matrix(array)
    public Segment updateBy(int[] segment_matrix, Process process) {
        this.size += segment_matrix[0];
        process.setSize(process.getSize() + segment_matrix[0]);
        this.updateBelongsTo(segment_matrix, process.getProcess_id());
        return this;
    }

    //updates belongs_to value of a segment
    private void updateBelongsTo(int[] segment_matrix, int process_id) {
        if(segment_matrix.length > 1 && segment_matrix[1] == 0) {
            this.belongs_to.clear();
            this.belongs_to.add(process_id);
            for(int i = 2; i < segment_matrix.length; i++) {
                this.belongs_to.add(segment_matrix[i]);
            }
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public LinkedList<Integer> getBelongs_to() {
        return belongs_to;
    }

    @Override
    public String toString() {
        return "Segment{" +
                "size=" + size +
                ", belongs_to=" + belongs_to +
                '}';
    }
}
