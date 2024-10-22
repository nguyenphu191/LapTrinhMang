
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Phu Laptop
 */
public class Server3 {
    public static void main(String[] args) {
        try(ServerSocket ss=new ServerSocket(1606)){
            Socket server= ss.accept();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(server.getOutputStream()));
            BufferedReader reader =new BufferedReader(new InputStreamReader(server.getInputStream()));
            
            String datarevited = reader.readLine();
            System.out.println(datarevited);
            
            String s="safrtgyucvjbkoASEVHBJ";
            writer.write(s);
            writer.newLine();
            writer.flush();
            
            String xuli=reader.readLine();
            System.out.println(xuli);
            
            writer.close();
            reader.close();
            ss.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
