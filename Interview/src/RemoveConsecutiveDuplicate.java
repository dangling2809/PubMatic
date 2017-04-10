
public class RemoveConsecutiveDuplicate {

    public int removeDuplicates(char input[]){
        int slow = 0;
        int fast = 0;
        int index = 0;
        while(fast < input.length){
            while(fast < input.length && input[slow] == input[fast]){
                fast++;
            }
            input[index++] = input[slow];
            slow = fast;
        }
        return index;
    }
    
    public static void main(String args[]){
        String str = "abcdeedcbfgf";
        char input[] = str.toCharArray();
        RemoveConsecutiveDuplicate rcd = new RemoveConsecutiveDuplicate();
        int len = rcd.removeDuplicates(input);
        for(int i=0; i < len; i++){
            System.out.print(input[i] + " ");
        }
    }
}