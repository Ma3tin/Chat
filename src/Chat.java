import java.io.*;
import java.util.Scanner;

public class Chat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            //
            BufferedReader br = new BufferedReader(new FileReader("chat.txt"));
            System.out.println("Zadej jmémo:");
            String name = sc.nextLine();
            String line = br.readLine();
            int lines = 0;
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
                lines++;
            }
            br.close();
            if (lines == 0) {
                System.out.println("-- Žádné předchozí zprávy --");
            }
            System.out.println("Pro ukončení zadej '!konec'");
            BufferedWriter bw = new BufferedWriter(new FileWriter("chat.txt"));
            String messages = sc.nextLine();
            while (!messages.equals("!konec")) {
                bw.write(name + ": " + messages);
                bw.newLine();
                messages = sc.nextLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}