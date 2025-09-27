package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FilterFactoryDiffblueTest {
  /**
   * Test {@link FilterFactory#getFilter(COSName)} with {@code COSName}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link FilterFactory#getFilter(COSName)}
   */
  @Test
  @DisplayName("Test getFilter(COSName) with 'COSName'; when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.filter.Filter FilterFactory.getFilter(COSName)"})
  void testGetFilterWithCOSName_whenA() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> FilterFactory.INSTANCE.getFilter(COSName.A));
  }

  /**
   * Test {@link FilterFactory#getFilter(COSName)} with {@code COSName}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FilterFactory#getFilter(COSName)}
   */
  @Test
  @DisplayName("Test getFilter(COSName) with 'COSName'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.filter.Filter FilterFactory.getFilter(COSName)"})
  void testGetFilterWithCOSName_whenNull() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> FilterFactory.INSTANCE.getFilter((COSName) null));
  }

  /**
   * Test {@link FilterFactory#getFilter(String)} with {@code String}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link FilterFactory#getFilter(String)}
   */
  @Test
  @DisplayName("Test getFilter(String) with 'String'; when empty string; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.filter.Filter FilterFactory.getFilter(String)"})
  void testGetFilterWithString_whenEmptyString_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> FilterFactory.INSTANCE.getFilter(""));
  }

  /**
   * Test {@link FilterFactory#getFilter(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code Filter Name}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link FilterFactory#getFilter(String)}
   */
  @Test
  @DisplayName("Test getFilter(String) with 'String'; when 'Filter Name'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.filter.Filter FilterFactory.getFilter(String)"})
  void testGetFilterWithString_whenFilterName_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> FilterFactory.INSTANCE.getFilter("Filter Name"));
  }

  /**
   * Test {@link FilterFactory#getAllFilters()}.
   *
   * <p>Method under test: {@link FilterFactory#getAllFilters()}
   */
  @Test
  @DisplayName("Test getAllFilters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Collection FilterFactory.getAllFilters()"})
  void testGetAllFilters() {
    // Arrange, Act and Assert
    assertEquals(17, FilterFactory.INSTANCE.getAllFilters().size());
  }
}
