import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class permutations{
    static Scanner input = new Scanner(System.in);
    static Queue<String> queue = new LinkedList<>();
    public static void main(String[] args){
     int choice; 
        
     do {
        System.out.println("=====Permutations=====");
        System.out.println("[1] Add Elements to Queue");
        System.out.println("[2] Display Queue");
        System.out.println("[3] Generate Permutations");
        System.out.println("[4] Exit");
        System.out.println("Enter Choice: ");

        choice = input.nextInt();

        switch(choice) {
            case 1:
                addElements();
                break;
            case 2:
                displayQueue();
                break;
            case 3:
                generatePermutations();
                break;
            case 4:
                System.out.println("Program Terminated");
                break;
            default:
                System.out.println("Invalid Choice!");
        }
     } while(choice != 4);
    }

    static void addElements(){
        System.out.println("Enter number of elements to add: ");
        int count = input.nextInt();
        input.nextLine();

        for(int i = 0; i < count; i++){
            System.out.println("Element " + (i + 1) + ": ");
            String element = input.nextLine().trim();
            queue.add(element);
        }
        System.out.println("\nQueue: " + String.join(" ", queue));

        if (queue.size() >= 2){
            System.out.println("Dequeueing two elements...");
            queue.poll();
            queue.poll();

            System.out.println("queue: " + String.join(" ", queue));
        } else {
            System.out.println("Queue has fewer elements, cannot dequeue 2.");
        }
    }
    static void displayQueue(){
        if(queue.isEmpty()){
            System.out.println("Queue is empty!");
            return;
        }
        System.out.println("Queue: " + queue);
    }
    static void generatePermutations(){
        if (queue.isEmpty()){
            System.out.println("Queue is empty. Please add elements.");
            return;
        }

        System.out.println("Enter number of elements to arrange: ");
        int r = input.nextInt();

        if (r <= 0 || r > queue.size()){
            System.out.println("Invalid arrangements size. Output must be 1 and " + queue.size());
            return;
        }
        String[] elements = queue.toArray(new String[0]);
        Queue<String> permQueue = new LinkedList<>();

        for(String el: elements){
            permQueue.add(el);
        }

        int totalCount = 0;
        System.out.println("\nPermutations: \n");

        while(!permQueue.isEmpty()){
            String current = permQueue.poll();
            String[] currentArr = current.split(",");

            if (currentArr.length == r){
                System.out.println(String.join("", currentArr));
                totalCount++;
            } else {
                for (String el: elements){
                    boolean exists = false;

                    for(String used : currentArr){
                        if(used.equals(el)){
                            exists = true;
                            break;
                        }
                    }
                    if (!exists){
                        permQueue.add(current + "," + el);
                    }
                }
            }
        }
        System.out.println("Total Permutations: " + totalCount);
    }
}