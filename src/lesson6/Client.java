package lesson6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Cl cl = new Cl();
        System.out.println("Client started. Connecting to localhost: 1111");

        new Thread(){
            public void run(){
                try{
                    cl.readMessage();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            public void run (){
                try {
                    cl.sendMessage();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }.start();
    }

    static class Cl{
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        BufferedReader console = null;
        String userMessage, serverMessage;

        public Cl() throws IOException {
            socket = new Socket("localhost", 1111);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
            console = new BufferedReader(new InputStreamReader(System.in));
        }

        void sendMessage() throws IOException{
            while (true){
                if ((userMessage = console.readLine()) != null){
                    out.println(userMessage);
                    if (userMessage.equalsIgnoreCase("Выход") || userMessage.equalsIgnoreCase("Закрыть")) break;
                }
            }
        }

        void readMessage() throws IOException{
            while (true){
                if ((serverMessage = in.readLine()) != null){
                    System.out.println(serverMessage);
                }
            }
        }

    }
}
