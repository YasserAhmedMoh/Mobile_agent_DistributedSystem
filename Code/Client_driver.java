import java.net.*;
import java.io.*;

public class Client_driver{
    public static void main(String[]args)throws Exception{
        Socket s2=new Socket("LocalHost", 5000);
        String received;
         DataInputStream data_input = new DataInputStream(s2.getInputStream());
         DataOutputStream data_output = new DataOutputStream(s2.getOutputStream());
         data_output.writeUTF( "hello from Client_driver" );
         received= new String( data_input .readUTF());
         if(received.equals("ready")){
            System. out .println( "server: " + received );
            data_output .writeUTF( "request recommendation for best way" );
            
         }
         received= new String( data_input .readUTF());
         if(received.equals("provide guidline for best way for driver")){
            System. out .println( "server: " + received );
            System. out .println( "All right" );
         }
         data_input.close();
         data_output.close();
         s2.close();
    }
}
