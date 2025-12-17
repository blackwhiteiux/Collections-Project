import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactBook contactBook = new ContactBook();
        boolean running = true;

        while (running){
            System.out.println("Главное меню: ");
            System.out.println("«1»: Добавить контакт");
            System.out.println("«2»: Удалить контакт");
            System.out.println("«3»: Посмотреть все контакты");
            System.out.println("«4»: Найти контакт");
            System.out.println("«5»: Посмотреть контакты по группе");
            System.out.println("«0»: Выход");
            System.out.println();
            System.out.println("Ваш выбор: ");

            int choice = validInt(scanner);
            System.out.println(choice);

            switch (choice){
                case 1:
                    System.out.println("Введите имя: ");
                    String name = scanner.nextLine();
                    System.out.println("Введите номер: ");
                    String phone = scanner.nextLine();
                    System.out.println("Введите email: ");
                    String email = scanner.nextLine();

                    boolean groupCorrectChoose = true;
                    String group = null;

                    while (groupCorrectChoose){
                        System.out.println("Выберите группу: ");
                        System.out.println("1. Семья");
                        System.out.println("2. Друзья");
                        System.out.println("3. Работа");
                        System.out.println("4. Другое");

                        int groupChoose = validInt(scanner);

                        switch (groupChoose){
                            case 1:
                                group = "Семья";
                                groupCorrectChoose = false;
                                break;
                            case 2:
                                group = "Друзья";
                                groupCorrectChoose = false;
                                break;
                            case 3:
                                group = "Работа";
                                groupCorrectChoose = false;
                                break;
                            case 4:
                                group = "Другое";
                                groupCorrectChoose = false;
                                break;
                            default:
                                System.out.println(ErrorMessages.INVALID_INPUT.getMessage());
                                break;
                        }
                    }
                    contactBook.addContact(name, phone, email, group);
                    break;
                case 2:
                    if(contactBook.contactSet.isEmpty()){
                        System.out.println(ErrorMessages.EMPTY_CONTACT_BOOK.getMessage());
                        break;
                    }
                    System.out.println("Введите имя контакта: ");
                    String deleteName = scanner.nextLine();
                    contactBook.deleteContact(deleteName);
                    break;
                case 3:
                    if(contactBook.contactList.isEmpty()){
                        System.out.println(ErrorMessages.EMPTY_CONTACT_BOOK.getMessage());
                        break;
                    }
                    contactBook.showContacts();
                    break;
                case 4:
                    if(contactBook.contactSet.isEmpty()){
                        System.out.println(ErrorMessages.EMPTY_CONTACT_BOOK.getMessage());
                        break;
                    }
                    System.out.println("Введите имя контакта: ");
                    String findName = scanner.nextLine();
                    contactBook.findContact(findName);
                    break;
                case 5:
                    if (contactBook.contactMap.isEmpty()){
                        System.out.println(ErrorMessages.EMPTY_CONTACT_BOOK.getMessage());
                        break;
                    }
                    System.out.println("Введите номер группы для вывода: ");

                    boolean showGroupCorrectChoose = true;
                    String showGroup = null;
                    while (showGroupCorrectChoose){
                        System.out.println("1. Семья");
                        System.out.println("2. Друзья");
                        System.out.println("3. Работа");
                        System.out.println("4. Другое");

                        int caseShowGroup = validInt(scanner);
                        switch (caseShowGroup){
                            case 1:
                                showGroup = "Семья";
                                showGroupCorrectChoose = false;
                                break;
                            case 2:
                                showGroup = "Друзья";
                                showGroupCorrectChoose = false;
                                break;
                            case 3:
                                showGroup = "Работа";
                                showGroupCorrectChoose = false;
                                break;
                            case 4:
                                showGroup = "Другое";
                                showGroupCorrectChoose = false;
                                break;
                            default:
                                System.out.println(ErrorMessages.INVALID_INPUT.getMessage());
                                break;
                        }
                    }
                    contactBook.showGroup(showGroup);
                    break;
                case 0:
                    System.out.println("Спасибо за использование программы!");
                    scanner.close();
                    running = false;
                    break;
                default:
                    System.out.println(ErrorMessages.INVALID_INPUT.getMessage());
            }
        }
    }

    private static int validInt(Scanner scanner){
        while (true){
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e){
                System.out.println(ErrorMessages.INVALID_INPUT.getMessage());
            }
        }
    }
}
