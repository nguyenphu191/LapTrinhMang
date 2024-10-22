
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Phu Laptop
 */
public class SV4 {
    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket server=new DatagramSocket(2207);
        
        byte[] buf=new byte[1024];
        DatagramPacket Res=new DatagramPacket(buf, buf.length);
        server.receive(Res);
        String sn=new String(Res.getData()).trim();
        System.out.println(sn);
        
        String sg="sxdbnf;5,4,1,54,8,44";
         DatagramPacket Req=new DatagramPacket(sg.getBytes(), sg.length(), 
                Res.getAddress(), Res.getPort());
        server.send(Req);
        
        byte[] buf2=new byte[1024];
        DatagramPacket Res2=new DatagramPacket(buf2, buf2.length);
        server.receive(Res2);
        String sn2=new String(Res2.getData()).trim();
        System.out.println(sn2);
    }
}
