import java.net.*;
import java.io.*;

public class Client_Sensor{
    public static void main(String[]args)throws Exception{
        Socket s1=new Socket("LocalHost", 5000);
        String received;
         DataInputStream data_input = new DataInputStream(s1.getInputStream());
         DataOutputStream data_output = new DataOutputStream(s1.getOutputStream());
         data_output.writeUTF( "hello from Client_sensor" );
         
         received= new String( data_input .readUTF());
         if(received.equals("turn on sensors and cameras")){
            System. out .println( "server: " + received );
            data_output .writeUTF( "sensor turned on" );
         }
         received= new String( data_input .readUTF());
         if(received.equals("need photos")){
            System. out .println( "server: " + received );
            data_output .writeUTF( "get photo of streets" );
            System. out .println( "All right" );
         }
        
         data_input.close();
         data_output.close();
         s1.close();
    }
}
