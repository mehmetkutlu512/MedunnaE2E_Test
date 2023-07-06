package pojos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RoomPojo {

    private Integer roomNumber;
    private String roomType;
    private Boolean status;
    private Double price;
    private String description;

    public RoomPojo() {
    }

    public RoomPojo(Integer roomNumber, String roomType, Boolean status, Double price, String description) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.status = status;
        this.price = price;
        this.description = description;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public Boolean getStatus() {
        return status;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "RoomPojo{" +
                "roomNumber=" + roomNumber +
                ", roomType='" + roomType + '\'' +
                ", status=" + status +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
