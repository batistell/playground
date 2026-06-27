package playground.challenges.mystery;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReportGeneratorTest {

    private final ReportGenerator generator = new ReportGenerator();

    @Test
    public void testReport_Pdf() {
        ReportGenerator.Report report = generator.createReport(ReportGenerator.Format.PDF);
        assertNotNull(report);
        assertTrue(report instanceof ReportGenerator.PdfReport);
        assertEquals("[PDF Report] Title: Vendas | Content: Total R$ 100", report.generate("Vendas", "Total R$ 100"));
    }

    @Test
    public void testReport_Csv() {
        ReportGenerator.Report report = generator.createReport(ReportGenerator.Format.CSV);
        assertNotNull(report);
        assertTrue(report instanceof ReportGenerator.CsvReport);
        assertEquals("[CSV Report] Title: Vendas | Content: Total R$ 100", report.generate("Vendas", "Total R$ 100"));
    }

    @Test
    public void testReport_Html() {
        ReportGenerator.Report report = generator.createReport(ReportGenerator.Format.HTML);
        assertNotNull(report);
        assertTrue(report instanceof ReportGenerator.HtmlReport);
        assertEquals("[HTML Report] Title: Vendas | Content: Total R$ 100", report.generate("Vendas", "Total R$ 100"));
    }

    @Test
    public void testReport_NullException() {
        assertThrows(IllegalArgumentException.class, () -> {
            generator.createReport(null);
        });
    }
}
