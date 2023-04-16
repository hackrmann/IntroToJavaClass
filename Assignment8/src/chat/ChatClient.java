package chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class ChatClient extends JFrame implements Runnable {

    private static int WIDTH = 400;
    private static int HEIGHT = 300;

    DataOutputStream toServer = null;
    DataInputStream fromServer = null;
    JTextField textField;
    JTextArea textArea = null;
    JScrollPane scroll;

    Socket socket;

    public ChatClient() {
        super("Chat Client");

        textField = new JTextField(5);
        textArea = new JTextArea(30, 30);
        textArea.setEditable(false);
        this.setLayout(new BorderLayout());
        textField.addActionListener(new TextFieldListener());
        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        JPanel controlPanel = new JPanel();
        scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        //Add Textarea in to middle panel
        controlPanel.add(scroll);
        topPanel.add(controlPanel);
        topPanel.add(textField);
        this.add(textArea, BorderLayout.CENTER);
        this.add(topPanel, BorderLayout.SOUTH);
        createMenu();
        this.setSize(ChatClient.WIDTH, ChatClient.HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem connectItem = new JMenuItem("Connect");
        JMenuItem exitItem = new JMenuItem("Exit");
        connectItem.addActionListener((e) -> {
            try {
                socket = new Socket("localhost", 8000);
                textArea.append("----------\nConnected!\n----------\n");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        exitItem.addActionListener((e) -> System.exit(1));
        menu.add(connectItem);
        menu.add(exitItem);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);
    }

    public void run() {

    }

    class TextFieldListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(socket == null) {
                textArea.append("Chatroom not connected to Server. Please connect to server and try again\n");
            }
            try {
                // Create a socket to connect to the server
                // Create an input stream to receive data from the server
                fromServer = new DataInputStream(socket.getInputStream());
                // Create an output stream to send data to the server
                toServer = new DataOutputStream(socket.getOutputStream());
            } catch (IOException ex) {
                textArea.append("ERROR: " + ex.toString() + '\n');
            }

            try {
                String message = textField.getText().trim();
                toServer.writeUTF(message);
                toServer.flush();
                String getmessage = fromServer.readUTF();

                textArea.append(getmessage + "\n");
                textField.setText("");
                //socket.close();
            } catch (IOException ex) {
                System.err.println(ex);
            }

        }
    }


    public static void main(String[] args) {
        ChatClient chatClient = new ChatClient();
    }
}
