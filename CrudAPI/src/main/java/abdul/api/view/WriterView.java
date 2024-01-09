package abdul.api.view;

import abdul.api.controller.WriterController;
import abdul.api.model.Writer;

import static abdul.api.view.StaticView.*;

public class WriterView {
    private final WriterController writerController;

    public WriterView(WriterController writerController) {
        this.writerController = writerController;
    }

    public void viewStart() {
        System.out.println();
        System.out.println("Вы находитесь в среде разработки сущности Writer");
        while (true) {
            System.out.println();
            System.out.println("1.Создать Writer\n" +
                    "2.Удалить Writer\n" +
                    "3.Изменить Writer\n" +
                    "4.Выйти в меню ->");
            switch (getScanner().nextInt()) {
                case 1: {
                    createWriterView();
                    break;
                }
                case 2: {
                    deleteWriterView();
                    break;
                }
                case 3: {
                    updateWriterView();
                    break;
                }
                case 4: {
                    return;
                }
            }
        }

    }

    private void createWriterView() {
        System.out.println();
        System.out.println("Введите firstName");
        String firstName = getScanner().next();
        System.out.println("Введите lastName");
        String lastName = getScanner().next();
        System.out.println("id для созданного обьекта: "
                + writerController.createWriter(firstName, lastName, createPosts())
                .getId()
        );
    }

    private void deleteWriterView() {
        System.out.println();
        System.out.println("Введите id обьекта для удаления");
        writerController.deleteWriter(getScanner().nextInt());
    }

    private void updateWriterView() {
        System.out.println();
        System.out.println("Введите id обьекта для изменения");
        Writer writerUpdate = writerController.getByIdWriter(getScanner().nextInt());
        while (true) {
            System.out.println("Изменить:\n" +
                    "1.fistName\n" +
                    "2.lastName\n" +
                    "3.collect_posts\n" +
                    "4.Выйти и сохранить изменения");
            switch (getScanner().nextInt()) {
                case 1: {
                    System.out.println("Введите новое значение для firsName");
                    writerUpdate.setFirstName(getScanner().next());
                    break;
                }
                case 2: {
                    System.out.println("Введите новое значение для lastName");
                    writerUpdate.setLastName(getScanner().next());
                    break;
                }
                case 3: {
                    updatePosts(writerUpdate);
                }
                case 4: {
                    System.out.println("Выход из режима редактирования");
                    writerController.updateWriter(writerUpdate);
                    return;
                }
            }
        }
    }
}


