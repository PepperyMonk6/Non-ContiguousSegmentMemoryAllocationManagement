package Compaction_6604778;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Memory {
	//this file works with files form package Compaction_6604778 only
    private Map<Integer, Process> processes; // id - memory allocated
    int hole_available;

    public Memory(int hole_available) {
        this.hole_available = hole_available;
        this.processes = new HashMap<Integer, Process>();
    }

    //applying of a specific step(matrix)
    public void applyStep(int[] step) {
        int process_id = step[0];
        LinkedList<Integer> segments = new LinkedList<Integer>();
        int process_size = 0;
        for(int i = 1; i < step.length; i++) {
            segments.add(step[i]);
            process_size += step[i];
        }
        if(process_size <= hole_available) {
            if(this.processExists(process_id)) {
                Process process = processes.get(process_id);
                process.update(segments);
            }
            else {
                Process process = new Process(segments);
                processes.put(process_id, process);
            }

            this.updateHoleAvailable(process_size);
        }
    }

    //updates empty spaces within the memory
    private void updateHoleAvailable(int process_size) {
        this.hole_available -= process_size;
    }

    
    //checks for existence of a specific process
    private boolean processExists(int process_id) {
        for(Integer id: this.processes.keySet()) {
            if(id == process_id) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder processes = new StringBuilder();
        for(Process process: this.processes.values()) {
            processes.append(process);
        }
        return  processes.toString() + " [H" + hole_available + "]";
    }
}
