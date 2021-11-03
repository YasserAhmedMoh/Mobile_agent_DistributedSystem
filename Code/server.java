import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class server{
    public static void main(String[] args)throws Exception{
        try{
        ServerSocket server_socket = new ServerSocket (4000);
        System.out.println("Server started");
        System.out.println("Waiting for a client ...");
        ArrayList<clienthandler>Thread_For_Client = new ArrayList<>();
        while(true){
            Socket client = server_socket.accept();
            DataInputStream data_input = new DataInputStream(client.getInputStream());
            DataOutputStream data_output = new DataOutputStream(client.getOutputStream());
            System.out.println("Assigning new thread for this client");
            clienthandler thread = new clienthandler(client, data_input, data_output,Thread_For_Client);
            Thread_For_Client.add(thread);
            thread.start();
        }
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class clienthandler extends Thread{
    final DataInputStream data_input;
    final DataOutputStream data_output;
    final Socket client;
    private ArrayList<clienthandler> thread_List;
    public clienthandler(Socket client, DataInputStream data_input, DataOutputStream data_output,ArrayList<clienthandler>Thread_For_Client) 
    {
        this.client = client;
        this.data_input = data_input;
        this.data_output = data_output;
        this.thread_List=Thread_For_Client;
    }
    @Override
    public synchronized void run(){
        String received;
        
        while(true)
        {
            try{
            
            received = new String ( data_input .readUTF());
            if(received.equals("hello from Client_sensor"))
            {
                System. out .println( "Client_Sensor: " + received );
              //  send_to_all_clients("turn on sensors and cameras");
                data_output.writeUTF( "turn on sensors and cameras" );
                
            }
            
            else if(received.equals("sensor turned on"))
            {
                System. out .println( "Client_Sensor: " + received );
                data_output.writeUTF( "need photos" );
               
            }
            
            else if(received.equals("get photo of streets"))
            {
                System. out .println( "Client_Sensor: " + received );
              //  System. out .println( "All right" );
             
               
            }
            
            else if(received.equals("hello from Client_driver"))
            {
                System. out .println( "Client_Driver: " + received );
                data_output.writeUTF( "ready" );
              //  send_to_all_clients("ready");
            }
            
            else if(received.equals("request recommendation for best way"))
            {
                System. out .println( "Client_Driver: " + received );
               // System. out .println( "All right" );
                data_output.writeUTF( "provide guidline for best way for driver" );
                System. out .println( "All right" );
            }



            } 
        
            catch(EOFException e) {
                //This isn't problem
                break;
            }
             catch (IOException e) {
             e.printStackTrace();
}
        }
        {
            try
           {
               // closing resources
               client.close();
               this.data_input.close();
               this.data_output.close();
           }
           catch(EOFException e){
               e.printStackTrace();
           }
           catch(IOException e){
               e.printStackTrace();
           }
       }
    }


    private void send_to_all_clients(String outputString)
     {
         for(clienthandler Ch:thread_List)
         {
             try {
                Ch.data_output.writeUTF(outputString);
             } catch (Exception e) {
                 //TODO: handle exception
             }
         }
     }
}