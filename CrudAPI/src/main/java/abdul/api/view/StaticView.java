package abdul.api.view;

import abdul.api.model.*;

import java.util.*;

class StaticView {
    private static final Scanner SCANNER = new Scanner(System.in);

    static Scanner getScanner() {
        return SCANNER;
    }

    static List<Label> createLabels() {
        System.out.println("Введите количество создания обьектов Label:");
        List<Label> collectLabel = new ArrayList<>();
        int size = SCANNER.nextInt();
        for (int j = 1; j <= size; j++) {
            System.out.println();
            System.out.println("Создание обьекта номер " + j);
            System.out.println("Введите name для Label");
            Label label = new Label(SCANNER.next());
            label.setStatus(Status.ACTIVE);
            collectLabel.add(label);
        }
        return collectLabel;
    }

    static List<Post> createPosts() {
        List<Post> collectPost = new ArrayList<>();
        System.out.println("Введите колчиество создания элементов Post:");
        int size = SCANNER.nextInt();
        for (int i = 1; i <= size; i++) {
            System.out.println("Создание обьекта Post " + i);
            System.out.println("Введите значение для свойства content:");
            String content = SCANNER.next();
            System.out.println("Введите значение для свойства created в формате yyyy-mm-dd hh:mm:ss");
            Date created = java.sql.Date.valueOf(SCANNER.next());
            System.out.println("Введите значение для свойства updated в формате yyyy-mm-dd hh:mm:ss");
            Date updated = java.sql.Date.valueOf(SCANNER.next());
            List<Label> collectLabel = createLabels();
            System.out.println("Обьект post успешно создан");
            Post post = new Post(content, created, updated, collectLabel);
            post.setPostStatus(PostStatus.ACTIVE);
            collectPost.add(post);
        }
        return collectPost;
    }

    static void updateLabels(Post postUpdate) {
        System.out.println(postUpdate.getLabels());
        System.out.println(postUpdate.getLabels());
        System.out.println("Введить id обьекта для изменения");
        Label labelUpdate = postUpdate.getLabels().get(SCANNER.nextInt() - 1);
        System.out.println("Введите name");
        labelUpdate.setName(SCANNER.next());
    }

    static void updatePosts(Writer writerUpdate) {
        Collections.sort(writerUpdate.getPosts(), Comparator.comparingInt(Post::getId));
        System.out.println(writerUpdate.getPosts());
        System.out.println("Введить id обьекта для изменения");
        Post postUpdate = writerUpdate.getPosts().get(getScanner().nextInt() - 1);
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
                System.out.println("Выход из режима редактирования Post");
                postUpdate.setPostStatus(PostStatus.UNDER_REVIEW);

            }
        }
    }
}
