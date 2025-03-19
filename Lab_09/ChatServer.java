
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatServer
{
    ServerSocket serverSocket;
        public ChatServer() {
            try {
                serverSocket = new ServerSocket(5005);
            } catch (IOException ex) {
                Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        while(true) {
        Socket s = null;
                try {
                    s = serverSocket.accept();
                } catch (IOException ex) {
                    Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
                }
        new ChatHandler(s);
        }
    }

    public static void main(String[] args) {
        new ChatServer();
    }
}

class ChatHandler extends Thread {
    DataInputStream dis;
    PrintStream ps;
    static Vector<ChatHandler> clientsVector = new Vector<ChatHandler>();
    public ChatHandler(Socket cs) {
        try {
            dis = new DataInputStream(cs.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ps = new PrintStream(cs.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        ChatHandler.clientsVector.add(this);
        start();
    }

    public void run() {
        while(true)
        {
        String str = null;
            try {
                str = dis.readLine();
            } catch (IOException ex) {
                Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        sendMessageToAll(str);
        }
    }
    
    void sendMessageToAll(String msg) {
        // for(ChatHandler ch : clientsVector)
        for(int i=0 ; i<clientsVector.size() ; i++) {
            clientsVector.get(i).ps.println(msg);
        }
    }
}