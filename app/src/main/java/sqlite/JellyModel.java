package sqlite;

/**
 * Created by hyunji on 16. 7. 6..
 */

public class JellyModel {
    private String name;
    private String taste;
    private int price;
    private String  dateAdded;

    public String  getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "JellyModel{" +
                "name='" + name + '\'' +
                ", taste='" + taste + '\'' +
                ", price=" + price +
                ", dateAdded='" + dateAdded + '\'' +
                ", id=" + id +
                '}';
    }
}
