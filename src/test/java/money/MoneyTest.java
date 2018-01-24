package money;

import org.javamoney.moneta.FastMoney;
import org.javamoney.moneta.Money;
import org.junit.Test;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;
import java.util.Locale;

/**
 * @author yaojiafeng
 * @create 2018-01-24 上午11:11
 */
public class MoneyTest {
    @Test
    public void testMoney() {
        CurrencyUnit currencyUnit = Monetary.getCurrency(Locale.US);

        //金额表示
        MonetaryAmount fstAmtUSD = Monetary.getDefaultAmountFactory().setCurrency(currencyUnit).setNumber(200).create();

        Money money = Money.of(12, currencyUnit);

        FastMoney fastMoney = FastMoney.of(2, currencyUnit);
        //货币计算
        MonetaryAmount oneDolar = Monetary.getDefaultAmountFactory().setCurrency(currencyUnit).setNumber(1).create();
        Money oneEuro = Money.of(1, "EUR");

        //"+"
        MonetaryAmount[] monetaryAmounts = new MonetaryAmount[]{
                Money.of(100, "CHF"),
                Money.of(10.20, "CHF"),
                Money.of(1.15, "CHF")};
        Money sumAmtCHF = Money.of(0, "CHF");
        for (MonetaryAmount monetaryAmount : monetaryAmounts) {
            sumAmtCHF = sumAmtCHF.add(monetaryAmount);
        }

        //"-"
        Money calcAmtUSD = Money.of(1, "USD").subtract(fstAmtUSD);

        //"*"
        MonetaryAmount multiplyAmount = oneDolar.multiply(0.25);

        //"\"
        MonetaryAmount divideAmount = oneDolar.divide(0.25);

        Money moneyOf = Money.of(12, currencyUnit);
        fstAmtUSD = Monetary.getDefaultAmountFactory().setCurrency(currencyUnit).setNumber(200.50).create();
        oneDolar = Monetary.getDefaultAmountFactory().setCurrency("USD").setNumber(1).create();
        Money subtractedAmount = Money.of(1, "USD").subtract(fstAmtUSD);
        multiplyAmount = oneDolar.multiply(0.25);
        divideAmount = oneDolar.divide(0.25);

        //四舍五入
        MonetaryAmount fstAmtEUR = Monetary.getDefaultAmountFactory().setCurrency("EUR").setNumber(1.30473908).create();
        MonetaryAmount roundEUR = fstAmtEUR.with(Monetary.getDefaultRounding());

        MonetaryAmount oneDollar = Monetary.getDefaultAmountFactory().setCurrency("USD").setNumber(1).create();

        //货币格式化以及解析
        MonetaryAmountFormat formatUSD = MonetaryFormats.getAmountFormat(Locale.US);
        String usFormatted = formatUSD.format(oneDollar);
        System.out.println(usFormatted);
    }
}
