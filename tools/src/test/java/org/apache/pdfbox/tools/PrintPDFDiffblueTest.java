package org.apache.pdfbox.tools;

import static org.junit.jupiter.api.Assertions.assertSame;
import javax.print.attribute.standard.Sides;
import org.apache.pdfbox.tools.PrintPDF.Duplex;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrintPDFDiffblueTest {
  /**
   * Test Duplex {@link Duplex#toSides()}.
   * <p>
   * Method under test: {@link PrintPDF.Duplex#toSides()}
   */
  @Test
  @DisplayName("Test Duplex toSides()")
  void testDuplexToSides() {
    // Arrange and Act
    Sides actualToSidesResult = PrintPDF.Duplex.valueOf("SIMPLEX").toSides();

    // Assert
    assertSame(actualToSidesResult.ONE_SIDED, actualToSidesResult);
  }
}
