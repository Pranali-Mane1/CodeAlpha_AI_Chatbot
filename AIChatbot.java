
import javax.swing.*;
import java.awt.*;

public class AIChatbot extends JFrame {

    private JTextArea chatArea;
    private JTextField inputField;

    public AIChatbot() {
        setTitle("JavaBot - AI Chatbot");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 15));

        JScrollPane scrollPane = new JScrollPane(chatArea);

        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 15));

        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(e -> sendMessage());

        inputField.addActionListener(e -> sendMessage());

        JPanel bottomPanel = new JPanel(new BorderLayout(8, 8));
        bottomPanel.setBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10));
        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        chatArea.setText(
                "JavaBot: Hello! Welcome to JavaBot.\n"
                + "Ask me about Java, AI, or greetings.\n\n");
    }

    private String getResponse(String message) {
        String input = message.toLowerCase().trim();

        if (input.contains("hello") || input.equals("hi")
                || input.contains("hey")) {
            return "Hello! How can I help you?";
        } else if (input.contains("your name")) {
            return "I am JavaBot, your virtual assistant.";
        } else if (input.contains("how are you")) {
            return "I am doing great! Thanks for asking.";
        } else if (input.contains("java")) {
            return "Java is an object-oriented programming language.";
        } else if (input.contains("artificial intelligence")
                || input.equals("ai") || input.startsWith("what is ai")) {
            return "AI helps computers perform tasks that normally "
                    + "require human intelligence.";
        } else if (input.contains("help")) {
            return "You can ask me about Java, AI, or greetings.";
        } else if (input.contains("bye")) {
            return "Goodbye! Thanks for chatting with me.";
        } else {
            return "Sorry, I don't know that yet. Try asking about Java or AI.";
        }
    }

    private void sendMessage() {
        String message = inputField.getText().trim();

        if (message.isEmpty()) {
            return;
        }

        chatArea.append("You: " + message + "\n");
        chatArea.append("JavaBot: " + getResponse(message) + "\n\n");

        inputField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AIChatbot chatbot = new AIChatbot();
            chatbot.setVisible(true);
        });
    }
}
