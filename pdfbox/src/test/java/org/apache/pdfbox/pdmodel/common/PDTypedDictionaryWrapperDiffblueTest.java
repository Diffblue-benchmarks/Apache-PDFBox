package org.apache.pdfbox.pdmodel.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDTypedDictionaryWrapperDiffblueTest {
  /**
   * Test {@link PDTypedDictionaryWrapper#PDTypedDictionaryWrapper(COSDictionary)}.
   *
   * <p>Method under test: {@link PDTypedDictionaryWrapper#PDTypedDictionaryWrapper(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDTypedDictionaryWrapper(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTypedDictionaryWrapper.<init>(COSDictionary)"})
  void testNewPDTypedDictionaryWrapper() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act and Assert
    assertSame(dictionary, new PDTypedDictionaryWrapper(dictionary).getCOSObject());
  }

  /**
   * Test {@link PDTypedDictionaryWrapper#PDTypedDictionaryWrapper(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return Type is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PDTypedDictionaryWrapper#PDTypedDictionaryWrapper(String)}
   */
  @Test
  @DisplayName("Test new PDTypedDictionaryWrapper(String); when '42'; then return Type is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTypedDictionaryWrapper.<init>(String)"})
  void testNewPDTypedDictionaryWrapper_when42_thenReturnTypeIs42() {
    // Arrange and Act
    PDTypedDictionaryWrapper actualPdTypedDictionaryWrapper = new PDTypedDictionaryWrapper("42");

    // Assert
    assertEquals("42", actualPdTypedDictionaryWrapper.getType());
    COSDictionary cOSObject = actualPdTypedDictionaryWrapper.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDTypedDictionaryWrapper#PDTypedDictionaryWrapper(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Type is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDTypedDictionaryWrapper#PDTypedDictionaryWrapper(String)}
   */
  @Test
  @DisplayName("Test new PDTypedDictionaryWrapper(String); when 'null'; then return Type is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTypedDictionaryWrapper.<init>(String)"})
  void testNewPDTypedDictionaryWrapper_whenNull_thenReturnTypeIsNull() {
    // Arrange and Act
    PDTypedDictionaryWrapper actualPdTypedDictionaryWrapper =
        new PDTypedDictionaryWrapper((String) null);

    // Assert
    assertNull(actualPdTypedDictionaryWrapper.getType());
    COSDictionary cOSObject = actualPdTypedDictionaryWrapper.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDTypedDictionaryWrapper#PDTypedDictionaryWrapper(String)}.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link PDTypedDictionaryWrapper#PDTypedDictionaryWrapper(String)}
   */
  @Test
  @DisplayName("Test new PDTypedDictionaryWrapper(String); when 'Type'; then return 'Type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTypedDictionaryWrapper.<init>(String)"})
  void testNewPDTypedDictionaryWrapper_whenType_thenReturnType() {
    // Arrange and Act
    PDTypedDictionaryWrapper actualPdTypedDictionaryWrapper = new PDTypedDictionaryWrapper("Type");

    // Assert
    assertEquals("Type", actualPdTypedDictionaryWrapper.getType());
    COSDictionary cOSObject = actualPdTypedDictionaryWrapper.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDTypedDictionaryWrapper#getType()}.
   *
   * <ul>
   *   <li>Given {@link PDTypedDictionaryWrapper#PDTypedDictionaryWrapper(String)} with {@code
   *       Type}.
   *   <li>Then return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link PDTypedDictionaryWrapper#getType()}
   */
  @Test
  @DisplayName(
      "Test getType(); given PDTypedDictionaryWrapper(String) with 'Type'; then return 'Type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDTypedDictionaryWrapper.getType()"})
  void testGetType_givenPDTypedDictionaryWrapperWithType_thenReturnType() {
    // Arrange, Act and Assert
    assertEquals("Type", new PDTypedDictionaryWrapper("Type").getType());
  }

  /**
   * Test {@link PDTypedDictionaryWrapper#getType()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDTypedDictionaryWrapper#getType()}
   */
  @Test
  @DisplayName("Test getType(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDTypedDictionaryWrapper.getType()"})
  void testGetType_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDTypedDictionaryWrapper(new COSDictionary()).getType());
  }
}
