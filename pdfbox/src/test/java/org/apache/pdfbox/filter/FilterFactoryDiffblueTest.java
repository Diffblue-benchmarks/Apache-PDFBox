package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.IOException;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;

class FilterFactoryDiffblueTest {
  /**
   * Method under test: {@link FilterFactory#getFilter(String)}
   */
  @Test
  void testGetFilter() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> FilterFactory.INSTANCE.getFilter("Filter Name"));
    assertThrows(IOException.class, () -> FilterFactory.INSTANCE.getFilter(""));
    assertThrows(IOException.class, () -> FilterFactory.INSTANCE.getFilter(COSName.A));
    assertThrows(IOException.class, () -> FilterFactory.INSTANCE.getFilter((COSName) null));
  }

  /**
   * Method under test: {@link FilterFactory#getAllFilters()}
   */
  @Test
  void testGetAllFilters() {
    // Arrange, Act and Assert
    assertEquals(17, FilterFactory.INSTANCE.getAllFilters().size());
  }
}
