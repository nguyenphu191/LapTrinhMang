
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Phu Laptop
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 1604);
        System.out.println(client);
        //gui dl yeu cau
        DataOutputStream dos = new DataOutputStream(client.getOutputStream()) ;
        dos.writeUTF("B21DCCN592;M9xe9yl");
//        dos.writeInt(100);
//        dos.writeInt(200);
        //nhan dl tra
        DataInputStream dis = new DataInputStream(client.getInputStream());
        int a=dis.readInt();
        int b=dis.readInt();
        System.out.format("%d|%d",a,b);
        int sum=a+b;
        dos.writeInt(sum);
//        double sum=dis.readDouble();
//        System.out.println("sum: "+sum);
        //dong
        dos.close();
        dis.close();
    }
}
