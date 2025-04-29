public class Expenditure extends Deal {

    protected String productName;
    protected int price;

    public Expenditure (String comment, int debitChange,
                        int creditChange, String productName, int price) {
        super(comment, debitChange, creditChange);
        this.productName = productName;
        this.price = price;
        this.comment = String.format("Покупка %s на %d руб.",productName, price);
        this.debitChange = 0;
        this.creditChange = price;
    }
}
