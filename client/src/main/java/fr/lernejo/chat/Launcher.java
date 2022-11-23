package fr.lernejo.chat;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Scanner;
@SpringBootApplication
public class Launcher {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Launcher.class);
        RabbitTemplate rabittemplate = context.getBean(RabbitTemplate.class);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Input a message, we will sent it for you (q for quit)");
            String input = scanner.next();
            if (input.equals("q")){
                System.out.println("Bye");
                break;
            }
            else {
                rabittemplate.convertAndSend("chat_messages", input);
                System.out.println("Message sent, we will sent it for you");
            }
        }
    }
}
