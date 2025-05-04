import taxes.TaxDebit;
import taxes.TaxDebitMinusCredit;

public class Main {

    public static void main(String[] args) {

        Deal[] deals = {
            new Sale("Продажа", 10000, 0,
                    "Алюминий", 10000),
            new Expenditure("Покупка", 0 , 5000,
                    "Железо", 5000),
            new Sale("Продажа", 10000, 0,
                    "Заклепки", 10000)
        };

        Company company = new Company("KDV-Групп", 0, 0, new TaxDebitMinusCredit());
//        company.shiftMoney(20000);
//        company.shiftMoney(-5000);
        company.setTaxSystem(new TaxDebit());
//        company.payTaxes();
        System.out.printf("Разница доходов и расходов на момент старта уплаты налогов: %d руб.",
                company.applyDeals(deals));
    }
}
