import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovingTarget 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

		String[] inputStrings = sc.nextLine().split(" ");
		
		List<Integer> targets = new ArrayList<>();
		
		for(String inputString: inputStrings){
			int target = Integer.parseInt(inputString);
			targets.add(target);
		}

		String command = sc.nextLine();
		
		while( !command.equals("End") ){
			String[] commandParts = command.split(" ");
			
			switch(commandParts[0]){
				
					case "Shoot":
					int index1 = Integer.parseInt(commandParts[1]);
					int power = Integer.parseInt(commandParts[2]);
					if(index1 >= 0 && index1 < targets.size()){
						int shotTarget = targets.get(index1);
						shotTarget -= power;
						targets.set(index1, shotTarget);
						if(shotTarget <= 0){
							targets.remove(index1);	
						}
					}
					break;
					
					case "Add":
					int index2 = Integer.parseInt(commandParts[1]);
					int value = Integer.parseInt(commandParts[2]);
					if(index2 >= 0 && index2 < targets.size()){
						targets.add(index2, value);
					}else{
						System.out.println("Invalid placement!");
					}
					 
					break;
					
					case "Strike":
					int index3 = Integer.parseInt(commandParts[1]);
					int radius = Integer.parseInt(commandParts[2]);
					if(index3 >= 0 && index3 < targets.size()){
						if(index3 >= radius && index3 + radius < targets.size()){
						for(int i = index3+radius; i >= index3-radius; i--){
							targets.remove(i);
						}
						}else{
							System.out.println("Strike missed!");
						}
					}else{
						System.out.println("Invalid placement!");
					}
					
					break;		 
			}
			if(sc.hasNextLine()){
				 command = sc.nextLine();
			}
		}
		for(int i = 0; i < targets.size() - 1; i++){
			System.out.print(targets.get(i) + "|");
		}
		 System.out.print(targets.get(targets.size()-1));
    }
}