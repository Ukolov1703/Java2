package lesson6;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        Serv serv = new Serv();
        serv.start();
        serv.catchClient();
        new Thread() {
            public  void run(){
                while (true){
                    String txt = null;
                    try {
                        txt = serv.in.readLine();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    if (txt != null) {
                        try {
                            serv.sendMessage(txt);
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();

        new Thread() {
            public void run(){
                try {
                    serv.writeToConsole();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }.start();

    }

    static class Serv {
        BufferedReader in = null;
        PrintWriter out = null;
        ServerSocket serverSocket = null;
        Socket socket = null;
        String input;
        BufferedReader console = null;

        void start() {
            try {
                serverSocket = new ServerSocket(1111);
            }catch (IOException e){
                e.printStackTrace();
            }
            System.out.println("Сервер запустился");
        }

        void catchClient() throws IOException {
            try {
                socket = serverSocket.accept();
                System.out.println("Клиент подключился");
            }catch (IOException e){
                e.printStackTrace();
            }

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);

        }

        void sendMessage(String message) throws IOException {
            if (message.equalsIgnoreCase("Выход"))allClose();
            out.println("S: " + message);
            System.out.println(message);
        }

        void writeToConsole() throws IOException{
            while (true) {
                console = new BufferedReader(new InputStreamReader(System.in));
                String txt = console.readLine();
                sendMessage(txt);
            }
        }

        void allClose() throws IOException {
            out.close();
            in.close();
            socket.close();
            serverSocket.close();
        }
    }
}