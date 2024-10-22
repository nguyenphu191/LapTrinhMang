
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
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
public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server =new ServerSocket(1604);
        while(true){
            Socket conn=server.accept();
            System.out.println(conn);
            //Nhan dl
            DataInputStream dis = new DataInputStream(conn.getInputStream());
                String s= dis.readUTF();
                System.out.println(s);
//            int a= dis.readInt();
//            int b= dis.readInt();
//            System.out.format("%d %d \n",a,b);
            //gui dl
            DataOutputStream dos=new DataOutputStream(conn.getOutputStream());
            dos.writeUTF("12|2");
//            dos.writeDouble(a+b);
//              dos.writeInt(100);
//              dos.writeInt(200);
//             int sum=dis.readInt();
//             System.out.println(sum);
            //dong ket noi
            dis.close();
            dos.close();
            conn.close();
        }
    }
}
