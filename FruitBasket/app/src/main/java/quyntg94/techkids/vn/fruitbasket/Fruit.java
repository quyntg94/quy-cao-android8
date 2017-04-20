package quyntg94.techkids.vn.fruitbasket;

/**
 * Created by quyntg94 on 20/04/2017.
 */

public class Fruit {
    private int id;
    private String name;
    private String image;
    private int price;
    private int number;

    public Fruit(int id, String name, String image, int price, int number) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", number=" + number +
                '}';
    }
}
