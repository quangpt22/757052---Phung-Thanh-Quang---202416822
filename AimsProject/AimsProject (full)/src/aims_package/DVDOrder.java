package aims_package;

public class DVDOrder {
    private DigitalVideoDisc disc;
    private int quantity;

    public DigitalVideoDisc getDisc() {
        return disc;
    }

    public int getQuantity() {
        return quantity;
    }

    public DVDOrder(DigitalVideoDisc disc, int quantity) {
        this.disc = disc;
        this.quantity = quantity;
    }
}