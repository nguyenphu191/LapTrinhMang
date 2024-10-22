
import java.io.IOException;
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
public class C1 {
    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket client=new DatagramSocket();
        String msv="B21DCCN592";
        String qc="2izB3igQ";
        String s=";"+msv+";"+qc;
        //a
        DatagramPacket Req=new DatagramPacket(s.getBytes(), s.length(), 
                InetAddress.getByName("203.162.10.109"), 2207);
        client.send(Req);
        
        //b
        byte[] buf=new byte[1024];
        DatagramPacket Res=new DatagramPacket(buf, buf.length);
        client.receive(Res);
        String sn=new String(Res.getData()).trim();
        System.out.println(sn);
        //c
        int vt=0;
        for(int i=0;i<sn.length();i++){
            if(sn.charAt(i)==';'){
                vt=i;
                break;
            }
        }
        String rqID=sn.substring(0,vt);
        String ss=sn.substring(vt+1);
        String[] sarr=ss.split("\\,");
        int[] arr=new int[sarr.length];
        for(int i=0;i<sarr.length;i++){
            arr[i]=Integer.parseInt(sarr[i]);
        }
        int max=arr[0];
        int min=arr[0];
        for(int i=0;i<sarr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
            if(arr[i]<min){
                min=arr[i];
            }
        }
        String sg=rqID+";"+max+","+min;
        System.out.println(sg);
        DatagramPacket Req2=new DatagramPacket(sg.getBytes(), sg.length(), 
                InetAddress.getByName("203.162.10.109"), 2207);
        client.send(Req2);
        //d
        client.close();
    }
}
