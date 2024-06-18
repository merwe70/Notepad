import java.io.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner inp = new Scanner(System.in);
    static String word, line;
    public static void main(String[] args) {
        int select;
        do {
            System.out.println("İşlem seçiniz: \n" +
                    "1 - Notları okuma\n" +
                    "2 - Not yaz\n" +
                    "3 - ÇIKIŞ\n\n");
            System.out.print("Seçim: "); select = inp.nextInt();
            inp.nextLine();
            if (select == 1){
                readPrint();
            }
            else if(select == 2){
                write();
            }

        }while (select != 3);


    }
    public static void read(){
        try {
            FileReader fileReader=new FileReader("notlar.txt");
            BufferedReader bufferedReader=new BufferedReader(fileReader);

            Scanner scanner=new Scanner(bufferedReader);
            
            line =  scanner.nextLine();
            scanner.close();

            bufferedReader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void readPrint(){
        read();
        System.out.println("son girdiğiniz metin : "+line);
    }
    public static void write(){
        read();

        System.out.print("Bir metin giriniz : ");
        word = inp.nextLine();
        creatNewFile(word);
        System.out.println();
        read();
    }

    public static void creatNewFile(String word){
        try {
            FileWriter fileWriter=new FileWriter("notlar.txt");
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            bufferedWriter.write(Main.word);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}