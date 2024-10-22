
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Phu Laptop
 */
public class C3 {
    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket client=new DatagramSocket();
        String msv="B21DCCN592";
        String qc="xeYTnp5C";
        String s=";"+msv+";"+qc;
        //a
        DatagramPacket Req=new DatagramPacket(s.getBytes(), s.length(), 
                InetAddress.getByName("203.162.10.109"), 2208);
        client.send(Req);
        
        byte[] buf=new byte[1024];
        DatagramPacket Res=new DatagramPacket(buf, buf.length);
        client.receive(Res);
        String sn=new String(Res.getData()).trim();
        System.out.println(sn);
        String[] sn2=sn.split("\\;");
        String data=sn2[1].toLowerCase();
        System.out.println(data);
        String[]dt=data.split("\\ ");
        String res="";
        for(var x:dt){
            res+=x.substring(0,1).toUpperCase()+x.substring(1)+" ";
        }
        res=sn2[0]+";"+res;
        System.out.println(res);
        DatagramPacket Req2=new DatagramPacket(res.getBytes(), res.length(), 
                InetAddress.getByName("203.162.10.109"), 2208);
        client.send(Req2);
        client.close();
    }
}
