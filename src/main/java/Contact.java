import java.util.Objects;

public class Contact {
    private String name;
    private String phone;
    private String email;
    private String group;

    public Contact(String name, String phone, String email, String group){
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.group = group;
    }

    public String getName(){
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail(){
        return email;
    }

    public String getGroup(){
        return group;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setGroup(String group){
        this.group = group;
    }

    @Override
    public String toString(){
        return "Имя контакта: "+getName()+" | Номер: "+getPhone()+" | Email: "+getEmail()+" | Группа: "+getGroup();
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name) && Objects.equals(phone, contact.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone);
    }
}
