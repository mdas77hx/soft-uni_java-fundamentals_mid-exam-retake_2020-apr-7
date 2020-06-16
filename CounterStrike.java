import java.util.Scanner;

public class CounterStrike 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

		int energy = Integer.parseInt(sc.nextLine());

		int count = 0;
		
		while(sc.hasNextLine()){
			
			String command = sc.nextLine();
			
			if(!command.equals("End of battle")){
				int distance = Integer.parseInt(command);
				
				if(energy - distance < 0){
					System.out.println("Not enough energy! Game ends with " + count + " won battles and " + energy + " energy");
					return;
				}
				energy -= distance;
				count++;

				if(count%3 == 0){
					energy += count;
				} 	
			}else{
				System.out.println("Won battles: " + count + ". Energy left: " + energy);
				return;
			}		 
		}	
    }
}