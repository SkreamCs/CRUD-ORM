package abdul.api.view;

import abdul.api.controller.PostController;
import abdul.api.model.Post;

import java.util.Date;

import static abdul.api.view.StaticView.*;

public class PostView {

    private final PostController postController;

    public PostView(PostController postController) {
        this.postController = postController;
    }


    public void viewStartPost() {
        System.out.println();
        System.out.println("Вы находитесь в среде разработки сущности Post");
        while (true) {
            System.out.println();
            System.out.println("1.Создать Post\n" +
                    "2.Удалить Post\n" +
                    "3.Изменить Post\n" +
                    "4.Выйти в меню ->");
            switch (getScanner().nextInt()) {
                case 1: {
                    createPost();
                    break;
                }
                case 2: {
                    deletePost();
                    break;
                }
                case 3: {
                    updatePost();
                    break;
                }
                case 4: {
                    return;
                }
            }
        }

    }

    private void createPost() {
        System.out.println();
        System.out.println("Введите content");
        String content = getScanner().next();
        System.out.println("Введите created в формате yyyy-mm-dd");
        Date created = java.sql.Date.valueOf(getScanner().next());
        System.out.println("Введите update в формате yyyy-mm-dd");
        Date updated = java.sql.Date.valueOf(getScanner().next());
        System.out.println("id для созданного обьекта: "
                + postController.createPost(content, created, updated, createLabels())
                .getId()
        );
    }

    private void deletePost() {
        System.out.println();
        System.out.println("Введите id обьекта для удаления");
        postController.deletePost(getScanner().nextInt());
    }

    private void updatePost() {
        System.out.println();
        System.out.println("Введите id обьекта для изменения");
        Post postUpdate = postController.getByIdPost(getScanner().nextInt());
        while (true) {
            System.out.println("Изменить:\n" +
                    "1.content\n" +
                    "2.created\n" +
                    "3.updated\n" +
                    "4.labels\n" +
                    "5.Выйти и сохранить изменения");
            switch (getScanner().nextInt()) {
                case 1: {
                    System.out.println("Введите новое значение для content");
                    postUpdate.setContent(getScanner().next());
                    break;
                }
                case 2: {
                    System.out.println("Введите новое значение для created (yyyy-mm-dd)");
                    postUpdate.setCreated(java.sql.Date.valueOf(getScanner().next()));
                    break;
                }
                case 3: {
                    System.out.println("Введите новое значение для updated (yyyy-mm-dd)");
                    postUpdate.setUpdated(java.sql.Date.valueOf(getScanner().next()));
                    break;
                }
                case 4: {
                    updateLabels(postUpdate);
                    break;
                }
                case 5: {
                    System.out.println("Выход из режима редактирования");
                    postController.updatePost(postUpdate);
                    return;
                }
            }
        }
    }
}
