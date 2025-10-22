package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDAppearanceEntryDiffblueTest {
  /**
   * Test {@link PDAppearanceEntry#PDAppearanceEntry(COSDictionary)}.
   * <p>
   * Method under test: {@link PDAppearanceEntry#PDAppearanceEntry(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAppearanceEntry(COSDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAppearanceEntry.<init>(COSDictionary)"})
  void testNewPDAppearanceEntry() {
    // Arrange
    COSDictionary entry = new COSDictionary();

    // Act and Assert
    assertSame(entry, (new PDAppearanceEntry(entry)).getCOSObject());
  }

  /**
   * Test {@link PDAppearanceEntry#getCOSObject()}.
   * <p>
   * Method under test: {@link PDAppearanceEntry#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSDictionary PDAppearanceEntry.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange
    COSDictionary entry = new COSDictionary();

    // Act and Assert
    assertSame(entry, (new PDAppearanceEntry(entry)).getCOSObject());
  }

  /**
   * Test {@link PDAppearanceEntry#isSubDictionary()}.
   * <ul>
   *   <li>Given {@link PDAppearanceEntry#PDAppearanceEntry(COSDictionary)} with entry is {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAppearanceEntry#isSubDictionary()}
   */
  @Test
  @DisplayName("Test isSubDictionary(); given PDAppearanceEntry(COSDictionary) with entry is COSStream(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDAppearanceEntry.isSubDictionary()"})
  void testIsSubDictionary_givenPDAppearanceEntryWithEntryIsCOSStream_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDAppearanceEntry(new COSStream())).isSubDictionary());
  }

  /**
   * Test {@link PDAppearanceEntry#isSubDictionary()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAppearanceEntry#isSubDictionary()}
   */
  @Test
  @DisplayName("Test isSubDictionary(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDAppearanceEntry.isSubDictionary()"})
  void testIsSubDictionary_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new PDAppearanceEntry(new COSDictionary())).isSubDictionary());
  }

  /**
   * Test {@link PDAppearanceEntry#isStream()}.
   * <ul>
   *   <li>Given {@link PDAppearanceEntry#PDAppearanceEntry(COSDictionary)} with entry is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAppearanceEntry#isStream()}
   */
  @Test
  @DisplayName("Test isStream(); given PDAppearanceEntry(COSDictionary) with entry is COSDictionary(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDAppearanceEntry.isStream()"})
  void testIsStream_givenPDAppearanceEntryWithEntryIsCOSDictionary_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDAppearanceEntry(new COSDictionary())).isStream());
  }

  /**
   * Test {@link PDAppearanceEntry#isStream()}.
   * <ul>
   *   <li>Given {@link PDAppearanceEntry#PDAppearanceEntry(COSDictionary)} with entry is {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAppearanceEntry#isStream()}
   */
  @Test
  @DisplayName("Test isStream(); given PDAppearanceEntry(COSDictionary) with entry is COSStream(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDAppearanceEntry.isStream()"})
  void testIsStream_givenPDAppearanceEntryWithEntryIsCOSStream_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new PDAppearanceEntry(new COSStream())).isStream());
  }

  /**
   * Test {@link PDAppearanceEntry#getAppearanceStream()}.
   * <ul>
   *   <li>Then return Resources is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAppearanceEntry#getAppearanceStream()}
   */
  @Test
  @DisplayName("Test getAppearanceStream(); then return Resources is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAppearanceStream PDAppearanceEntry.getAppearanceStream()"})
  void testGetAppearanceStream_thenReturnResourcesIsNull() {
    // Arrange
    COSStream entry = new COSStream();

    // Act
    PDAppearanceStream actualAppearanceStream = (new PDAppearanceEntry(entry)).getAppearanceStream();

    // Assert
    assertNull(actualAppearanceStream.getResources());
    assertNull(actualAppearanceStream.getBBox());
    assertNull(actualAppearanceStream.getOptionalContent());
    assertNull(actualAppearanceStream.getGroup());
    assertEquals(-1, actualAppearanceStream.getStructParents());
    assertEquals(1, actualAppearanceStream.getFormType());
    assertSame(entry, actualAppearanceStream.getCOSObject());
  }

  /**
   * Test {@link PDAppearanceEntry#getAppearanceStream()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAppearanceEntry#getAppearanceStream()}
   */
  @Test
  @DisplayName("Test getAppearanceStream(); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAppearanceStream PDAppearanceEntry.getAppearanceStream()"})
  void testGetAppearanceStream_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new PDAppearanceEntry(new COSDictionary())).getAppearanceStream());
  }

  /**
   * Test {@link PDAppearanceEntry#getSubDictionary()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAppearanceEntry#getSubDictionary()}
   */
  @Test
  @DisplayName("Test getSubDictionary(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map PDAppearanceEntry.getSubDictionary()"})
  void testGetSubDictionary_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new PDAppearanceEntry(new COSDictionary())).getSubDictionary().isEmpty());
  }

  /**
   * Test {@link PDAppearanceEntry#getSubDictionary()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAppearanceEntry#getSubDictionary()}
   */
  @Test
  @DisplayName("Test getSubDictionary(); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map PDAppearanceEntry.getSubDictionary()"})
  void testGetSubDictionary_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new PDAppearanceEntry(new COSStream())).getSubDictionary());
  }
}
