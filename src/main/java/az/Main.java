package az;


import az.Processing.Process;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        while (true){
            Thread.sleep(2000);
            System.out.println("\n1-Register\n2-Login\n3-Logout\n4-Exit");
            System.out.println("Choose an option:");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 1:
                    System.out.println("Enter Username:");
                    String newusername = scanner.nextLine();
                    System.out.println("Enter password:");
                    String newpassword = scanner.nextLine();
                    Process.register(newusername,newpassword);
                    break;
                case 2:
                    System.out.println("Enter username:");
                    String username = scanner.nextLine();
                    System.out.println("Enter password:");
                    String password = scanner.nextLine();
                    Process.login(username,password);
                case 3:
                    Process.logout();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("INVALID ERROR!");
                    return;
            }
        }
    }
}