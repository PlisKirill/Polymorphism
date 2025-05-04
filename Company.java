import taxes.TaxDebit;
import taxes.TaxDebitMinusCredit;
import taxes.TaxSystem;


public class Company {

    protected String title;
    private int debit;
    private int credit;
    protected TaxSystem taxSystem;


    public Company(String title, int debit, int credit, TaxSystem taxSystem) {
        this.title = title;
        this.debit = debit;
        this.credit = credit;
        this.taxSystem = taxSystem;
    }

    public void shiftMoney(int amount) {
        if (amount > 0) {
            debit += amount;
        } else if (amount < 0) {
            credit += Math.abs(amount);
        } else if (amount == 0) {
            return;
        }
    }

    public void setTaxSystem(TaxSystem taxSystem) {
        this.taxSystem = taxSystem;
    }

    public void payTaxes() {
        int result = 0;
        if (taxSystem instanceof TaxDebit) {
            TaxSystem taxSystem1 = new TaxDebit();
            result = taxSystem1.calcTaxFor(debit, credit);
        } else if (taxSystem instanceof TaxDebitMinusCredit) {
            TaxSystem taxSystem1 = new TaxDebitMinusCredit();
            result = taxSystem1.calcTaxFor(debit, credit);
        }
        System.out.printf("Компания %s уплатила налог в размере: %d руб.%n", title, result);
        debit = 0;
        credit = 0;
        System.out.println();
    }

    public int applyDeals(Deal[] deals) {
        for (int i = 0; i < deals.length; i++) {
           Deal deal = deals[i];
           debit += deal.debitChange;
           credit += deal.creditChange;
        }
        int difference = debit - credit;
        payTaxes();
        return difference;
    }
}
