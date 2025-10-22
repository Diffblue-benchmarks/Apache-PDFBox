package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDCIDSystemInfoDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDCIDSystemInfo#PDCIDSystemInfo(COSDictionary)}
   *   <li>{@link PDCIDSystemInfo#toString()}
   *   <li>{@link PDCIDSystemInfo#getCOSObject()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDCIDSystemInfo.<init>(COSDictionary)", "COSBase PDCIDSystemInfo.getCOSObject()",
      "String PDCIDSystemInfo.toString()"})
  void testGettersAndSetters() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act
    PDCIDSystemInfo actualPdcidSystemInfo = new PDCIDSystemInfo(dictionary);
    String actualToStringResult = actualPdcidSystemInfo.toString();

    // Assert
    assertEquals("null-null--1", actualToStringResult);
    assertSame(dictionary, actualPdcidSystemInfo.getCOSObject());
  }

  /**
   * Test {@link PDCIDSystemInfo#PDCIDSystemInfo(String, String, int)}.
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   *   <li>Then return Supplement is {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDSystemInfo#PDCIDSystemInfo(String, String, int)}
   */
  @Test
  @DisplayName("Test new PDCIDSystemInfo(String, String, int); when MIN_VALUE; then return Supplement is MIN_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDCIDSystemInfo.<init>(String, String, int)"})
  void testNewPDCIDSystemInfo_whenMin_value_thenReturnSupplementIsMin_value() {
    // Arrange and Act
    PDCIDSystemInfo actualPdcidSystemInfo = new PDCIDSystemInfo("Registry", "Ordering", Integer.MIN_VALUE);

    // Assert
    COSBase cOSObject = actualPdcidSystemInfo.getCOSObject();
    assertTrue(cOSObject instanceof COSDictionary);
    assertEquals("Ordering", actualPdcidSystemInfo.getOrdering());
    assertEquals("Registry", actualPdcidSystemInfo.getRegistry());
    assertEquals(3, ((COSDictionary) cOSObject).getValues().size());
    assertEquals(3, ((COSDictionary) cOSObject).size());
    assertEquals(Integer.MIN_VALUE, actualPdcidSystemInfo.getSupplement());
  }

  /**
   * Test {@link PDCIDSystemInfo#PDCIDSystemInfo(String, String, int)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Ordering is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDSystemInfo#PDCIDSystemInfo(String, String, int)}
   */
  @Test
  @DisplayName("Test new PDCIDSystemInfo(String, String, int); when 'null'; then return Ordering is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDCIDSystemInfo.<init>(String, String, int)"})
  void testNewPDCIDSystemInfo_whenNull_thenReturnOrderingIsNull() {
    // Arrange and Act
    PDCIDSystemInfo actualPdcidSystemInfo = new PDCIDSystemInfo(null, null, 1);

    // Assert
    COSBase cOSObject = actualPdcidSystemInfo.getCOSObject();
    assertTrue(cOSObject instanceof COSDictionary);
    assertNull(actualPdcidSystemInfo.getOrdering());
    assertNull(actualPdcidSystemInfo.getRegistry());
    assertEquals(1, ((COSDictionary) cOSObject).getValues().size());
    assertEquals(1, ((COSDictionary) cOSObject).size());
  }

  /**
   * Test {@link PDCIDSystemInfo#PDCIDSystemInfo(String, String, int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return Supplement is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDSystemInfo#PDCIDSystemInfo(String, String, int)}
   */
  @Test
  @DisplayName("Test new PDCIDSystemInfo(String, String, int); when one; then return Supplement is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDCIDSystemInfo.<init>(String, String, int)"})
  void testNewPDCIDSystemInfo_whenOne_thenReturnSupplementIsOne() {
    // Arrange and Act
    PDCIDSystemInfo actualPdcidSystemInfo = new PDCIDSystemInfo("Registry", "Ordering", 1);

    // Assert
    COSBase cOSObject = actualPdcidSystemInfo.getCOSObject();
    assertTrue(cOSObject instanceof COSDictionary);
    assertEquals("Ordering", actualPdcidSystemInfo.getOrdering());
    assertEquals("Registry", actualPdcidSystemInfo.getRegistry());
    assertEquals(1, actualPdcidSystemInfo.getSupplement());
    assertEquals(3, ((COSDictionary) cOSObject).getValues().size());
    assertEquals(3, ((COSDictionary) cOSObject).size());
  }

  /**
   * Test {@link PDCIDSystemInfo#PDCIDSystemInfo(String, String, int)}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return Supplement is six.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDSystemInfo#PDCIDSystemInfo(String, String, int)}
   */
  @Test
  @DisplayName("Test new PDCIDSystemInfo(String, String, int); when six; then return Supplement is six")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDCIDSystemInfo.<init>(String, String, int)"})
  void testNewPDCIDSystemInfo_whenSix_thenReturnSupplementIsSix() {
    // Arrange and Act
    PDCIDSystemInfo actualPdcidSystemInfo = new PDCIDSystemInfo("Registry", "Ordering", 6);

    // Assert
    COSBase cOSObject = actualPdcidSystemInfo.getCOSObject();
    assertTrue(cOSObject instanceof COSDictionary);
    assertEquals("Ordering", actualPdcidSystemInfo.getOrdering());
    assertEquals("Registry", actualPdcidSystemInfo.getRegistry());
    assertEquals(3, ((COSDictionary) cOSObject).getValues().size());
    assertEquals(3, ((COSDictionary) cOSObject).size());
    assertEquals(6, actualPdcidSystemInfo.getSupplement());
  }

  /**
   * Test {@link PDCIDSystemInfo#getRegistry()}.
   * <ul>
   *   <li>Given {@link PDCIDSystemInfo#PDCIDSystemInfo(COSDictionary)} with dictionary is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDSystemInfo#getRegistry()}
   */
  @Test
  @DisplayName("Test getRegistry(); given PDCIDSystemInfo(COSDictionary) with dictionary is COSDictionary(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDCIDSystemInfo.getRegistry()"})
  void testGetRegistry_givenPDCIDSystemInfoWithDictionaryIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDCIDSystemInfo(new COSDictionary())).getRegistry());
  }

  /**
   * Test {@link PDCIDSystemInfo#getRegistry()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDSystemInfo#getRegistry()}
   */
  @Test
  @DisplayName("Test getRegistry(); then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDCIDSystemInfo.getRegistry()"})
  void testGetRegistry_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new PDCIDSystemInfo("", "Ordering", 1)).getRegistry());
  }

  /**
   * Test {@link PDCIDSystemInfo#getRegistry()}.
   * <ul>
   *   <li>Then return {@code Registry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDSystemInfo#getRegistry()}
   */
  @Test
  @DisplayName("Test getRegistry(); then return 'Registry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDCIDSystemInfo.getRegistry()"})
  void testGetRegistry_thenReturnRegistry() {
    // Arrange, Act and Assert
    assertEquals("Registry", (new PDCIDSystemInfo("Registry", "Ordering", 1)).getRegistry());
  }

  /**
   * Test {@link PDCIDSystemInfo#getOrdering()}.
   * <ul>
   *   <li>Given {@link PDCIDSystemInfo#PDCIDSystemInfo(COSDictionary)} with dictionary is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDSystemInfo#getOrdering()}
   */
  @Test
  @DisplayName("Test getOrdering(); given PDCIDSystemInfo(COSDictionary) with dictionary is COSDictionary(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDCIDSystemInfo.getOrdering()"})
  void testGetOrdering_givenPDCIDSystemInfoWithDictionaryIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDCIDSystemInfo(new COSDictionary())).getOrdering());
  }

  /**
   * Test {@link PDCIDSystemInfo#getOrdering()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDSystemInfo#getOrdering()}
   */
  @Test
  @DisplayName("Test getOrdering(); then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDCIDSystemInfo.getOrdering()"})
  void testGetOrdering_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new PDCIDSystemInfo("Registry", "", 1)).getOrdering());
  }

  /**
   * Test {@link PDCIDSystemInfo#getOrdering()}.
   * <ul>
   *   <li>Then return {@code Ordering}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDSystemInfo#getOrdering()}
   */
  @Test
  @DisplayName("Test getOrdering(); then return 'Ordering'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDCIDSystemInfo.getOrdering()"})
  void testGetOrdering_thenReturnOrdering() {
    // Arrange, Act and Assert
    assertEquals("Ordering", (new PDCIDSystemInfo("Registry", "Ordering", 1)).getOrdering());
  }

  /**
   * Test {@link PDCIDSystemInfo#getSupplement()}.
   * <ul>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDSystemInfo#getSupplement()}
   */
  @Test
  @DisplayName("Test getSupplement(); then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDCIDSystemInfo.getSupplement()"})
  void testGetSupplement_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDCIDSystemInfo(new COSDictionary())).getSupplement());
  }

  /**
   * Test {@link PDCIDSystemInfo#getSupplement()}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDSystemInfo#getSupplement()}
   */
  @Test
  @DisplayName("Test getSupplement(); then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDCIDSystemInfo.getSupplement()"})
  void testGetSupplement_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, (new PDCIDSystemInfo("Registry", "Ordering", 1)).getSupplement());
  }
}
