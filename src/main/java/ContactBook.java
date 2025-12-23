import java.util.*;

public class ContactBook {
    List<Contact> contactList = new ArrayList<>();
    Set<Contact> contactSet = new HashSet<>();
    Map<String, List<Contact>> contactMap = new HashMap<>();
    List<Contact> familyList = new ArrayList<>();
    List<Contact> friendsList = new ArrayList<>();
    List<Contact> workList = new ArrayList<>();
    List<Contact> otherList = new ArrayList<>();

    public void addContact(String name, String phone, String email, String group){
        if(name == null || name.trim().isEmpty() || phone == null||phone.trim().isEmpty()){
            System.out.println(ErrorMessages.INVALID_INPUT.getMessage());
            return;
        }

        String normalName = name.trim();
        String normalPhone = phone.trim();
        String normalEmail = (email == null || email.trim().isEmpty() ? "Без группы" : email.trim());
        String normalGroup = (group == null || group.trim().isEmpty() ? "Без email" : group.trim());

        for(Contact contact : contactSet){
            if(contact.getName().equalsIgnoreCase(normalName) && contact.getPhone().equals(normalPhone)){
                System.out.println("Данный контакт уже существует!");
                return;
            }
        }

        Contact contact = new Contact(normalName, normalPhone, normalEmail, normalGroup);

        contactSet.add(contact);
        contactList.add(contact);

        contactMap.put("Семья", familyList);
        contactMap.put("Друзья", friendsList);
        contactMap.put("Работа", workList);
        contactMap.put("Другое", otherList);

        switch (contact.getGroup()){
            case "Семья":
                familyList.add(contact);
                break;
            case "Друзья":
                friendsList.add(contact);
                break;
            case "Работа":
                workList.add(contact);
                break;
            case "Другое":
                otherList.add(contact);
                break;
        }

        System.out.println("Контакт успешно добавлен!");
    }

    public void deleteContact(String deleteName){
        if(deleteName == null || deleteName.trim().isEmpty()){
            System.out.println(ErrorMessages.INVALID_INPUT.getMessage());
            return;
        }

        String normalDeleteName = deleteName.trim();
        boolean deleteFound = false;

        Iterator<Contact> iterator = contactSet.iterator();
        while (iterator.hasNext()){
            Contact contact = iterator.next();
            if(contact.getName().equalsIgnoreCase(normalDeleteName)){
                iterator.remove();
                contactList.remove(contact);

                switch (contact.getGroup()){
                    case "Семья":
                        familyList.remove(contact);
                        break;
                    case "Друзья":
                        friendsList.remove(contact);
                    case "Работа":
                        workList.remove(contact);
                    case "Другое":
                        otherList.remove(contact);
                        break;
                }

                System.out.println("Контакт удален.");
                deleteFound = true;
                break;
            }
        }
        if(!deleteFound){
            System.out.println("Контакт с именем: "+deleteName+" не найден.");
        }
    }

    public void showContacts(){
        System.out.println("Список всех контактов: ");
        for (Contact contact : contactList){
            System.out.println(contact.toString());
        }
    }

    public void findContact(String findName){
        if(findName == null || findName.trim().isEmpty()){
            System.out.println(ErrorMessages.INVALID_INPUT.getMessage());
            return;
        }

        String normalFindName = findName.trim();
        boolean findFound = false;

        Iterator<Contact> iterator = contactSet.iterator();
        while (iterator.hasNext()){
            Contact contact = iterator.next();
            if(contact.getName().equalsIgnoreCase(normalFindName)){
                System.out.println("Найденный контакт: ");
                System.out.println(contact);
                findFound = true;
                break;
            }
        }
        if(!findFound){
            System.out.println("Контакт с именем: "+findName+" не найден.");
        }
    }

    public void showGroup(String showGroup){
        for(Map.Entry<String, List <Contact>> entry : contactMap.entrySet()){
           if(entry.getKey().equalsIgnoreCase(showGroup)){
               if(entry.getValue().isEmpty()){
                   System.out.println("В группе "+showGroup+" нет контактов.");
                   return;
               }
               System.out.println("Список контактов группы: "+showGroup);
               for(Contact contact : entry.getValue()){
                   System.out.println(contact.toString());
               }
           }
        }
    }
}
