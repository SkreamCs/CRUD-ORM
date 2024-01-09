package abdul.api.view;

import abdul.api.controller.LabelController;
import abdul.api.model.Label;

import static abdul.api.view.StaticView.getScanner;


public class LabelView {

    private final LabelController labelController;

    public LabelView(LabelController labelController) {
        this.labelController = labelController;
    }

    public void viewStartLabel() {
        System.out.println();
        System.out.println("Вы находитесь в среде разработки сущности Label");
        while (true) {
            System.out.println();
            System.out.println("1.Создать Label\n" +
                    "2.Удалить Label\n" +
                    "3.Изменить Label\n" +
                    "4.Выйти в меню ->");
            switch (getScanner().nextInt()) {
                case 1: {
                    createLabel();
                    break;
                }
                case 2: {
                    deleteLabel();
                    break;
                }
                case 3: {
                    updateLabel();
                    break;
                }
                case 4: {
                    return;
                }
            }
        }

    }

    private void createLabel() {
        System.out.println();
        System.out.println("Введите name");
        System.out.println("id для созданного обьекта: " + labelController.createLabel(getScanner().next()).getId());
    }

    private void deleteLabel() {
        System.out.println();
        System.out.println("Введите id обьекта для удаления");
        labelController.deleteLabel(getScanner().nextInt());
    }

    private void updateLabel() {
        System.out.println();
        System.out.println("Введите id обьекта для изменения");
        Label labelUpdate = labelController.getByIdLabel(getScanner().nextInt());
        while (true) {
            System.out.println("1.Изменить name");
            System.out.println("2.Выйти и сохранить изменения");
            switch (getScanner().nextInt()) {
                case 1: {
                    System.out.println("Введите новое значение для name");
                    labelUpdate.setName(getScanner().next());
                    break;
                }
                case 2: {
                    System.out.println("Выход из режима редактирования");
                    labelController.updateLabel(labelUpdate);
                    return;
                }
            }
        }
    }
}
