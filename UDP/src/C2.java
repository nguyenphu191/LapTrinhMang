
import UDP.Product;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Phu Laptop
 */
public class C2 {
    public static void main(String[] args) throws SocketException, IOException, ClassNotFoundException {
        DatagramSocket client=new DatagramSocket();
        String msv="B21DCCN592";
        String qc="OQJo0mNZ";
        String s=";"+msv+";"+qc;
        //a
        //b
        DatagramPacket Req=new DatagramPacket(s.getBytes(), s.length(), 
                InetAddress.getByName("localhost"), 2209);
        client.send(Req);
        
        byte[] buf1=new byte[1024];
        DatagramPacket Res1=new DatagramPacket(buf1, buf1.length);
        client.receive(Res1);
               
        String rqID=new String(buf1,0,8);
        System.out.println(rqID);
        ByteArrayInputStream bis=new ByteArrayInputStream(buf1,8,buf1.length-8);
        ObjectInputStream is=new ObjectInputStream(bis);
        
        Product p= (Product) is.readObject();
        System.out.println(p);
        //sửa thông tin
        String[] Nm=p.getName().split("\\ ");
        String newN=Nm[Nm.length-1];        
        for(int i=1;i<Nm.length-1;i++){
            newN+=" "+Nm[i];
        }
        newN+=" "+Nm[0];
        p.setName(newN);
        String sl=Integer.toString(p.getQuatity());
        int newSL=Integer.parseInt(new StringBuilder(sl).reverse().toString());
        p.setQuatity(newSL);
        System.out.println(p);
        ByteArrayOutputStream bous=new ByteArrayOutputStream();
        ObjectOutputStream ous=new ObjectOutputStream(bous);
        ous.writeObject(p);
        ous.flush();
        byte[] data=new byte[1024];
        System.arraycopy(rqID.getBytes(), 0, data, 0, 8);
        System.arraycopy(bous.toByteArray(), 0, data, 8, bous.toByteArray().length);
        DatagramPacket Req2=new DatagramPacket(data, data.length, InetAddress.getByName("localhost"), 2209);
        client.send(Req2);
        client.close();
    }
}
