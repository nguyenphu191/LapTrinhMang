import java.io.*;  
import java.net.*;  

public class Client2 {  
//    public static void main(String[] args) {  
//        String serverAddress = "localhost";  
//        int port = 1604;  
//
//        try {  
//            // Tạo socket kết nối tới server  
//            Socket socket = new Socket(serverAddress, port);  
////            socket.setSoTimeout(5000); // Thiết lập timeout cho kết nối  
//            
//            // Gửi dữ liệu tới server  
//            String studentCode = "B21DCCN592";  
//            String qCode = "ABCDEF"; // Mã bài tập  
//            String request = studentCode + ";" + qCode;  
//            
//           InputStream in=socket.getInputStream();
//           OutputStream out =socket.getOutputStream();
//           PrintWriter writer=new PrintWriter(out, true);
//           BufferedReader reader =new BufferedReader(new InputStreamReader(in));
//           
//           writer.println(request);
//           writer.flush();
//           
//           String mes=reader.readLine();
//           String[] mes2=mes.split("\\|");
//           int sum=0;
//           for(var x:mes2){
//               sum+=Integer.parseInt(x);
//           }
//           writer.println(sum);
//           
//           writer.close();
//           reader.close();
//           socket.close();
//        } catch (IOException e) {  
//            e.printStackTrace();  
//        }  
//    }  
//    public static void main(String[] args) {  
//        String serverAddress = "localhost";  
//        int port = 1604;  
//        String studentCode = "B21DCCN592";  
//        String qCode = "ABCDEF"; // Mã bài tập  
//        String request = studentCode + ";" + qCode;
//        try {  
//            // Tạo socket kết nối tới server  
//            Socket socket = new Socket(serverAddress, port);  
////            socket.setSoTimeout(5000); // Thiết lập timeout cho kết nối  
//            InputStream is=socket.getInputStream();
//            OutputStream os=socket.getOutputStream();
//            DataInputStream reader=new DataInputStream(is);
//            DataOutputStream writer=new DataOutputStream(os);
//            
//            writer.writeUTF(request);
//            writer.flush();
//            
//           String mes = reader.readUTF();
//            System.out.println(mes);
//           String mes1[]=mes.split("\\|");
//           int sum=0;
//           for(var x: mes1){
//               sum+=Integer.parseInt(x);
//           }
//           writer.writeInt(sum);
//           writer.flush();
//           
//           writer.close();
//           reader.close();
//           socket.close();
//        } catch (IOException e) {  
//            e.printStackTrace();  
//        }  
//    }  
    public static void main(String[] args) {  
        String serverAddress = "localhost";  
        int port = 1604;  
        String studentCode = "B21DCCN592";  
        String qCode = "ABCDEF"; // Mã bài tập  
        String request = studentCode + ";" + qCode;
        try {  
            // Tạo socket kết nối tới server  
            Socket socket = new Socket(serverAddress, port);  
//            socket.setSoTimeout(5000); // Thiết lập timeout cho kết nối  
          InputStream is=socket.getInputStream();
          OutputStream os=socket.getOutputStream();
          BufferedReader reader=new BufferedReader(new InputStreamReader(is));
          BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(os));
          writer.write(request);
          writer.newLine();
          writer.flush();
          
          String s=reader.readLine();
            System.out.println(s);
            String mes1[]=s.split("\\|");
           int sum=0;
           for(var x: mes1){
               sum+=Integer.parseInt(x);
           }
            System.out.println(sum);
           writer.write(sum);
           writer.newLine();
           writer.flush();
           
           writer.close();
           reader.close();
           socket.close();
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
}