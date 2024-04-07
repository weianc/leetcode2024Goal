
import java.util.prefs.PreferenceChangeEvent;class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<int[]> callStack = new Stack<>();
        Stack<int[]> tmp = new Stack<>();
        for(int i = 0; i < logs.size(); i++){
            String s = logs.get(i);
            String[] arr = s.split(":");
            int id = Integer.parseInt(arr[0]);
            int operation = arr[1].equals("start") ? 0 : 1;
            int timestamp = Integer.parseInt(arr[2]);
        
            if(operation == 0){
                callStack.add(new int[]{id, timestamp});
            }
            else {
                int endTime = timestamp;
                int prev_id = -1;
                int prev_timestamp = -1;
                int count = 0;
                while(!callStack.isEmpty()){
                    int[] cur = callStack.pop();
                    int curId = cur[0];
                    int curT = cur[1];

                    if(curT != -1){
                        int duration = count == 0 ? endTime + 1 - curT : prev_timestamp - curT;
                        res[curId] += duration;
                    }

                    if(count == 1){ // mean the next element after top element
                        // reset cur[1] as endTime;
                        tmp.add(new int[]{curId, endTime + 1});
                    }
                    else if(count > 1) {
                        tmp.add(new int[]{curId, -1}); // timestamp no meaning
                    }
                    
                    prev_id = cur[0];
                    prev_timestamp = cur[1];
                    count++;
                }

                // add back the element in tmp Stack
                while(!tmp.isEmpty()){
                    callStack.add(tmp.pop());
                }
            }
        }
        return res;
    }
}