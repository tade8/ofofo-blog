package africa.semicolon.ofofo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Scanner;

@SpringBootApplication
@EnableMongoRepositories
public class Main {
//    private static final Scanner keyboardInput = new Scanner(System.in);
//    private static final PostController postController =
//            new PostController();

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
//        displayMainMenu();
    }

//    public static void displayMainMenu() {
//        String mainMenu = """
//                press 1 for create post
//                press 2 for view post
//                press 3 to exit
//                """;
//
//        String userInput = input(mainMenu);
//        switch(Integer.parseInt(String.valueOf(userInput.charAt(0)))) {
//            case 1 -> createPost();
//            case 2 -> viewPost();
//            case 3 -> exitFromApp();
//        }
//    }
//
//    private static void exitFromApp() {
//        System.out.print("Thank you for using our app");
//        System.exit(0);
//    }
//
//    private static void viewPost() {
//         String userInput = input("ENTER POST ID:");
//         System.out.print(postController.viewPost((userInput)).toString());
//         displayMainMenu();
//    }
//
//    private static void createPost() {
//        String title = input("ENTER POST TITLE:");
//        String body = input("ENTER POST BODY:");
//        CreatePostRequest createPostRequest = new CreatePostRequest();
//        createPostRequest.setTitle(title);
//        createPostRequest.setBody(body);
//        System.out.print(postController.createPost(createPostRequest));
//
//    }
//
//    private static String input(String prompt) {
//        return keyboardInput.nextLine();
//    }

}

