
import UDP.Product;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Phu Laptop
 */

public class SV2 {
    public static void main(String[] args) throws SocketException, IOException, ClassNotFoundException {
        DatagramSocket server=new DatagramSocket(2209);
        System.out.println("SV running");
         byte[] buf=new byte[1024];
        DatagramPacket Res=new DatagramPacket(buf, buf.length);
        server.receive(Res);
        String sn=new String(Res.getData()).trim();
        System.out.println(sn);
        
        byte[] data=new byte[1024];
        String rqid="scsauhu16";
        Product p=new Product("id1", "code1", "the product is number one", 1558);
        ByteArrayOutputStream bous=new ByteArrayOutputStream();
        ObjectOutputStream ous=new ObjectOutputStream(bous);
        ous.writeObject(p);
        ous.flush();
        System.arraycopy(rqid.getBytes(), 0, data, 0, 8);
        System.arraycopy(bous.toByteArray(), 0, data, 8, bous.toByteArray().length);
        
        DatagramPacket Req1=new DatagramPacket(data, data.length, Res.getAddress(), Res.getPort());
        server.send(Req1);
        
        byte[] buf2=new byte[1024];
        DatagramPacket Res2=new DatagramPacket(buf2, buf2.length);
        server.receive(Res2);
        
        String id=new String(buf2,0,8);
        
       
        ByteArrayInputStream bis=new ByteArrayInputStream(buf2,8,buf2.length-8);
        ObjectInputStream is=new ObjectInputStream(bis);
        Product p2=(Product)is.readObject();
        System.out.println(p2);
    }
}
