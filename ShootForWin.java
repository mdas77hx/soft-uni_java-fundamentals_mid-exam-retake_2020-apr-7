import java.util.*;

public class ShootForWin 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

		String firstLine = sc.nextLine();

		String[] strNums = firstLine.split(" ");
		
		int[] targets = new int[strNums.length];
		
		for(int i = 0; i < strNums.length; i++){
			
			targets[i] = Integer.parseInt(strNums[i]);
		}
		int counter = 0;
		String command = sc.nextLine();
		
		while( !command.equals("End") ){
			int index = Integer.parseInt(command);
			
			if(index < targets.length && targets[index] != -1){
				int temp = targets[index];
				targets[index] = -1;
				
				for(int i = 0; i < targets.length; i++){
					if(targets[i] != -1){
						if(targets[i] <= temp){
							targets[i] += temp;
						}else{
							targets[i] -= temp;
						} 
					} 			 
				}
				counter++;
			}
			
			if(sc.hasNextLine()){
				 command = sc.nextLine();
			}
		}
		System.out.print("Shot targets: " + counter + " -> ");
		for(int i = 0; i < targets.length; i++){
			System.out.print(targets[i] + " ");	
		}
    }
}