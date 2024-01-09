package abdul.api.view;

import abdul.api.controller.LabelController;
import abdul.api.controller.PostController;
import abdul.api.controller.WriterController;
import abdul.api.service.LabelService;
import abdul.api.service.PostService;
import abdul.api.service.WriterService;

import java.util.Scanner;

import static abdul.api.utils.HibernateUtils.closeSessionFactory;

public class GeneralView {
    private final Scanner scanner = new Scanner(System.in);
    private final LabelView labelView = new LabelView(new LabelController(new LabelService()));
    private final PostView postView = new PostView(new PostController(new PostService()));
    private final WriterView writerView = new WriterView(new WriterController(new WriterService()));

    public void generalStartView() {
        System.out.println();
        while (true) {
            System.out.println("CRUD приложени...");
            System.out.println("Выберите сущность");
            System.out.println("1.Writer\n" +
                    "2.Post\n" +
                    "3.Label\n" +
                    "4.Exit");
            switch (scanner.nextInt()) {
                case 1: {
                    writerView.viewStart();
                    break;
                }
                case 2: {
                    postView.viewStartPost();
                    break;
                }
                case 3: {
                    labelView.viewStartLabel();
                    break;
                }
                case 4: {
                    closeSessionFactory();
                    return;
                }
            }
        }
    }
}
