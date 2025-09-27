package org.apache.pdfbox.pdfparser.xref;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AbstractXReferenceDiffblueTest {
  /**
   * Test {@link AbstractXReference#getType()}.
   *
   * <p>Method under test: {@link AbstractXReference#getType()}
   */
  @Test
  @DisplayName("Test getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"XReferenceType AbstractXReference.getType()"})
  void testGetType() {
    // Arrange, Act and Assert
    assertEquals(XReferenceType.FREE, FreeXReference.NULL_ENTRY.getType());
  }

  /**
   * Test {@link AbstractXReference#getFirstColumnValue()}.
   *
   * <p>Method under test: {@link AbstractXReference#getFirstColumnValue()}
   */
  @Test
  @DisplayName("Test getFirstColumnValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long AbstractXReference.getFirstColumnValue()"})
  void testGetFirstColumnValue() {
    // Arrange, Act and Assert
    assertEquals(0L, FreeXReference.NULL_ENTRY.getFirstColumnValue());
  }

  /**
   * Test {@link AbstractXReference#compareTo(XReferenceEntry)} with {@code XReferenceEntry}.
   *
   * <p>Method under test: {@link AbstractXReference#compareTo(XReferenceEntry)}
   */
  @Test
  @DisplayName("Test compareTo(XReferenceEntry) with 'XReferenceEntry'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AbstractXReference.compareTo(XReferenceEntry)"})
  void testCompareToWithXReferenceEntry() {
    // Arrange and Act
    int actualCompareToResult = FreeXReference.NULL_ENTRY.compareTo(new FreeXReference(null, 1L));

    // Assert
    assertEquals(1, actualCompareToResult);
  }

  /**
   * Test {@link AbstractXReference#compareTo(XReferenceEntry)} with {@code XReferenceEntry}.
   *
   * <ul>
   *   <li>Given {@link FreeXReference#NULL_ENTRY}.
   *   <li>When {@link FreeXReference#NULL_ENTRY}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AbstractXReference#compareTo(XReferenceEntry)}
   */
  @Test
  @DisplayName(
      "Test compareTo(XReferenceEntry) with 'XReferenceEntry'; given NULL_ENTRY; when NULL_ENTRY; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AbstractXReference.compareTo(XReferenceEntry)"})
  void testCompareToWithXReferenceEntry_givenNull_entry_whenNull_entry_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, FreeXReference.NULL_ENTRY.compareTo(FreeXReference.NULL_ENTRY));
  }

  /**
   * Test {@link AbstractXReference#compareTo(XReferenceEntry)} with {@code XReferenceEntry}.
   *
   * <ul>
   *   <li>Given {@link FreeXReference#NULL_ENTRY}.
   *   <li>When {@code null}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link AbstractXReference#compareTo(XReferenceEntry)}
   */
  @Test
  @DisplayName(
      "Test compareTo(XReferenceEntry) with 'XReferenceEntry'; given NULL_ENTRY; when 'null'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AbstractXReference.compareTo(XReferenceEntry)"})
  void testCompareToWithXReferenceEntry_givenNull_entry_whenNull_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, FreeXReference.NULL_ENTRY.compareTo(null));
  }

  /**
   * Test {@link AbstractXReference#compareTo(XReferenceEntry)} with {@code XReferenceEntry}.
   *
   * <ul>
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link AbstractXReference#compareTo(XReferenceEntry)}
   */
  @Test
  @DisplayName("Test compareTo(XReferenceEntry) with 'XReferenceEntry'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AbstractXReference.compareTo(XReferenceEntry)"})
  void testCompareToWithXReferenceEntry_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, new FreeXReference(null, 1L).compareTo(FreeXReference.NULL_ENTRY));
  }
}
