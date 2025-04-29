public class Sale extends Deal {

    protected String productName;
    protected int price;

    public Sale (String comment, int debitChange, int creditChange, String productName, int price) {
        super(comment, debitChange, creditChange);
        this.productName = productName;
        this.price = price;
        this.comment = String.format("Продажа %s на %d руб.",productName, price);
        this.debitChange = price;
        this.creditChange = 0;
    }
}
