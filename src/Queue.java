import java.io.*;

public class Queue {
    public static String[] Queue= new String[50];
    public static Integer HeadPointer = -1;
    public static Integer TailPointer = 0;

    public static void Enqueue(String Value){
        if(TailPointer < 50){
            Queue[TailPointer] = Value;
            TailPointer = TailPointer + 1;
            if(HeadPointer == -1){
                HeadPointer = 0;
            }
        } else {
            System.out.println("Queue if full");
        }
    }

    public static String Dequeue(){
        if(HeadPointer == -1){
            System.out.println("Queue is Empty");
            return "";
        } else{
            HeadPointer = HeadPointer + 1;
            return Queue[HeadPointer - 1];
        }
    }

    public static void ReadData(){
        File file = new File("QueueData.txt");
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = reader.readLine()) != null){
                Enqueue(line);
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        } catch (IOException e){
            System.out.println("IO Exception");
        }
    }
}
