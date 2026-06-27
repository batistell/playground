package playground.challenges.mystery;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaxCalculatorTest {

    @Test
    public void testTax_Brazil() {
        TaxCalculator.Invoice invoice = new TaxCalculator.Invoice();
        invoice.setTaxRule(new TaxCalculator.BrazilTaxRule());
        
        double tax = invoice.calculateTotal(100.0);
        assertEquals(15.0, tax, 0.001);
    }

    @Test
    public void testTax_USA() {
        TaxCalculator.Invoice invoice = new TaxCalculator.Invoice();
        invoice.setTaxRule(new TaxCalculator.UsaTaxRule());
        
        double tax = invoice.calculateTotal(200.0);
        assertEquals(16.0, tax, 0.001);
    }

    @Test
    public void testTax_Europe() {
        TaxCalculator.Invoice invoice = new TaxCalculator.Invoice();
        invoice.setTaxRule(new TaxCalculator.EuropeTaxRule());
        
        double tax = invoice.calculateTotal(50.0);
        assertEquals(10.0, tax, 0.001);
    }

    @Test
    public void testTax_NoRuleException() {
        TaxCalculator.Invoice invoice = new TaxCalculator.Invoice();
        assertThrows(IllegalStateException.class, () -> {
            invoice.calculateTotal(100.0);
        });
    }
}
