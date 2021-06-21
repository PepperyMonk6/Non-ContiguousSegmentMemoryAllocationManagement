package a1a2_6604778;

import java.util.Arrays;
import java.util.LinkedList;

public class Memory {
	//this file works with files form package a1a2_6604778 only

    private int size;
    private LinkedList<Process> processes;

    public Memory(int size) {
        this.size = size;
        this.processes = new LinkedList<Process>();
    }

    //applying of a specific step(matrix)
    public void applyStep(int[][] step) {
        int process_id = step[0][0];
        int[][] segments = Arrays.copyOfRange(step, 1, step.length);

        if(processExists(process_id)) {
            Process process = updateProcess(process_id, segments);
        }
        else {
            Process process = this.createProcess(process_id, segments);
        }
    }

    //creating a process
    private Process createProcess(int process_id, int[][] segments) {
        Process process = new Process(this, process_id);
        for(int[] segment: segments) {
            process.addSegment(segment);
        }
        return process;
    }

    //updating process
    private Process updateProcess(int process_id, int[][] segments) {
        Process process = getProcessById(process_id);
        for(int i = 0; i < segments.length; i++) {
            int[] segment = segments[i];
            if(process.hasSegmentOnPosition(i)) {
                process.updateSegmentOnPosition(segment, i);
            }
            else {
                process.addSegment(segment);
            }
        }
        process.removeEmptySegments();
        this.dealWithOtherProcesses();
        return process;
    }

    //setting the state of all processes
    private void dealWithOtherProcesses() {
        for(int j = 0; j < processes.size(); j++) {
            Process process = processes.get(j);
            Integer process_id = process.getProcess_id();
            LinkedList<Segment> segments = process.getSegments();
            for(int i = 0; i < segments.size(); i++) {
                Segment segment = segments.get(i);
                LinkedList<Integer> belongs_to = segment.getBelongs_to();
                if(!belongs_to.contains(process_id)) {
                    process.getSegments().remove(i);
                    int size = process.recalculateSize();
                    if(size == 0) {
                        processes.remove(j);
                        j--;
                    }
                }
                else {
                    for(Integer p_id: belongs_to) {
                        if(!processExists(p_id)) {
                            Process new_process = new Process(this, p_id);
                            LinkedList<Segment> new_segments = new_process.getSegments();
                            new_segments.add(segment);
                            new_process.recalculateSize();
                        }
                    }
                }
            }
            process.recalculateSize();
        }
    }

    //gets or creates the process by specific id
    public Process getProcessById(int process_id) {
        for(Process process : processes) {
            if(process.getProcess_id() == process_id) {
                return process;
            }
        }
        return new Process(this, process_id);
    }

    //checks for existence of a specific process
    private boolean processExists(int process_id) {
        for(Process process : processes) {
            if(process.getProcess_id() == process_id) {
                return true;
            }
        }
        return false;
    }

    //adds the process
    public void addProcess(Process process) {
        this.processes.add(process);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        String result = "Memory with size=" + size;
        
        String processes_string = "";
        for(int i = 0; i < processes.toArray().length; i++) {
            processes_string += "\t" + processes.get(i).toString() + "\n";
        }
        result = result + "\n[\n" + processes_string + "\n]\n";
        return result;
    }
}
