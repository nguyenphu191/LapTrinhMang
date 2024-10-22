
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Phu Laptop
 */
public class Server22 {
//    public static void main(String[] args) {
//        try{
//            ServerSocket ss= new ServerSocket(1604);
//            Socket socket = ss.accept();
//            OutputStream os=socket.getOutputStream();
//            InputStream is=socket.getInputStream();
//            
//            PrintWriter writer= new PrintWriter(os, true);
//            BufferedReader reader= new BufferedReader(new InputStreamReader(is));
//            
//            String mes=reader.readLine();
//            System.out.println(mes);
//            
//            Scanner sc=new Scanner(System.in);
//            String s=sc.nextLine();
//            writer.println(s);
//            writer.flush();
//            
//            String mes2=reader.readLine();
//            System.out.println(mes2);
//            
//            writer.close();
//            reader.close();
////            ss.close();
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//    }
//    public static void main(String[] args) {
//        try{
//            ServerSocket ss= new ServerSocket(1604);
//            Socket socket = ss.accept();
//            InputStream is=socket.getInputStream();
//            OutputStream os=socket.getOutputStream();
//            DataInputStream reader=new DataInputStream(is);
//            DataOutputStream writer=new DataOutputStream(os);
//            
//            String s=reader.readUTF();
//            System.out.println(s);
//            
//            Scanner sc=new Scanner(System.in);
//            String mes= sc.nextLine();
//            
//            writer.writeUTF(mes);
//            writer.flush();
//            
//            int mes2=reader.readInt();
//            System.out.println(mes2);
//            
//            
//            
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//    }
    public static void main(String[] args) {
        try{
            ServerSocket ss= new ServerSocket(1604);
            Socket socket = ss.accept();
            InputStream is=socket.getInputStream();
            OutputStream os=socket.getOutputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(is));
            BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(os));
            
            String mes=reader.readLine();
            System.out.println(mes);
            
            Scanner sc=new Scanner(System.in);
            String s=sc.nextLine();
            writer.write(s);
            writer.newLine();
            writer.flush();
            
            int sum=reader.read();
            System.out.println(sum);
            
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
