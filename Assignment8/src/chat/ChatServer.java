package chat;


import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class ChatServer extends JFrame implements Runnable {

    private static int WIDTH = 400;
    private static int HEIGHT = 300;

    JTextArea textArea;
    private int clientNo;

    String currentMessage;

    ArrayList<DataOutputStream> clients;

    public ChatServer() {
        super("Chat Server");
        clients = new ArrayList<>();
        textArea = new JTextArea(30, 30);
        textArea.setEditable(false);
        this.setLayout(new BorderLayout());
        this.add(textArea, BorderLayout.CENTER);
        this.setSize(ChatServer.WIDTH, ChatServer.HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createMenu();
        this.setVisible(true);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        textArea.append("Started Chat Server on " + dtf.format(now) + "\n");

        Thread t = new Thread(this);
        t.start();
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener((e) -> System.exit(0));
        menu.add(exitItem);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);
    }


    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            while (true) {
                Socket socket = serverSocket.accept();
                InetAddress inetAddress = socket.getInetAddress();
                textArea.append("Client " + clientNo + "'s host name is "
                        + inetAddress.getHostName() + "\n");
                textArea.append("Client " + clientNo + "'s IP Address is "
                        + inetAddress.getHostAddress() + "\n");
                clients.add(new DataOutputStream(socket.getOutputStream()));
                new Thread(new HandleAClient(socket, ++clientNo)).start();
                Thread.sleep(1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    class HandleAClient implements Runnable {
        private Socket socket; // A connected socket
        private int clientNum;

        /**
         * Construct a thread
         */
        public HandleAClient(Socket socket, int clientNum) {
            this.socket = socket;
            this.clientNum = clientNum;
        }

        /**
         * Run a thread
         */
        public void run() {
            try {
                // Create data input and output streams
                DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
                while (true) {
                    // Create data input and output streams
                    // Listen for a connection request

                    String message = inputFromClient.readUTF();
                    currentMessage = message;
                    try {
                        for (int i = 0; i < clients.size(); i++) {
                            if (i != clientNum - 1)
                                clients.get(i).writeUTF(this.clientNum + ": " + message);
                            else
                                clients.get(i).writeUTF(message);
                        }
                    } catch (IOException ioe) {
                        textArea.append("Connection lost with client " + (clientNo-1) + "\n");
                        break;
                    }

                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        public String currentMessage() {
            return currentMessage;
        }
    }
}


