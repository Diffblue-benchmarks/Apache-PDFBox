package org.apache.pdfbox.pdfparser.xref;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AbstractXReferenceDiffblueTest {
  /**
   * Test {@link AbstractXReference#getType()}.
   * <p>
   * Method under test: {@link AbstractXReference#getType()}
   */
  @Test
  @DisplayName("Test getType()")
  void testGetType() {
    // Arrange, Act and Assert
    assertEquals(XReferenceType.FREE, FreeXReference.NULL_ENTRY.getType());
  }

  /**
   * Test {@link AbstractXReference#getFirstColumnValue()}.
   * <p>
   * Method under test: {@link AbstractXReference#getFirstColumnValue()}
   */
  @Test
  @DisplayName("Test getFirstColumnValue()")
  void testGetFirstColumnValue() {
    // Arrange, Act and Assert
    assertEquals(0L, FreeXReference.NULL_ENTRY.getFirstColumnValue());
  }

  /**
   * Test {@link AbstractXReference#compareTo(XReferenceEntry)} with
   * {@code XReferenceEntry}.
   * <p>
   * Method under test: {@link AbstractXReference#compareTo(XReferenceEntry)}
   */
  @Test
  @DisplayName("Test compareTo(XReferenceEntry) with 'XReferenceEntry'")
  void testCompareToWithXReferenceEntry() {
    // Arrange, Act and Assert
    assertEquals(1, FreeXReference.NULL_ENTRY.compareTo(new FreeXReference(null, 1L)));
  }

  /**
   * Test {@link AbstractXReference#compareTo(XReferenceEntry)} with
   * {@code XReferenceEntry}.
   * <ul>
   *   <li>Given {@link FreeXReference#NULL_ENTRY}.</li>
   *   <li>When {@link FreeXReference#NULL_ENTRY}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractXReference#compareTo(XReferenceEntry)}
   */
  @Test
  @DisplayName("Test compareTo(XReferenceEntry) with 'XReferenceEntry'; given NULL_ENTRY; when NULL_ENTRY; then return zero")
  void testCompareToWithXReferenceEntry_givenNull_entry_whenNull_entry_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, FreeXReference.NULL_ENTRY.compareTo(FreeXReference.NULL_ENTRY));
  }

  /**
   * Test {@link AbstractXReference#compareTo(XReferenceEntry)} with
   * {@code XReferenceEntry}.
   * <ul>
   *   <li>Given {@link FreeXReference#NULL_ENTRY}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractXReference#compareTo(XReferenceEntry)}
   */
  @Test
  @DisplayName("Test compareTo(XReferenceEntry) with 'XReferenceEntry'; given NULL_ENTRY; when 'null'; then return one")
  void testCompareToWithXReferenceEntry_givenNull_entry_whenNull_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, FreeXReference.NULL_ENTRY.compareTo(null));
  }

  /**
   * Test {@link AbstractXReference#compareTo(XReferenceEntry)} with
   * {@code XReferenceEntry}.
   * <ul>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractXReference#compareTo(XReferenceEntry)}
   */
  @Test
  @DisplayName("Test compareTo(XReferenceEntry) with 'XReferenceEntry'; then return minus one")
  void testCompareToWithXReferenceEntry_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, (new FreeXReference(null, 1L)).compareTo(FreeXReference.NULL_ENTRY));
  }
}
