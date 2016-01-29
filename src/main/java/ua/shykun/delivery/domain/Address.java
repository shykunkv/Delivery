package ua.shykun.delivery.domain;


public class Address {

    private Integer id;

    private String building;
    private String street;
    private String city;

    public Address(String building, String street, String city) {
        this.building = building;
        this.street = street;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", building='" + building + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
