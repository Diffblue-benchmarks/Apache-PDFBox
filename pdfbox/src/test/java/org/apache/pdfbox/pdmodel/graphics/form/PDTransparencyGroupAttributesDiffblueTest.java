package org.apache.pdfbox.pdmodel.graphics.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDResources;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDTransparencyGroupAttributesDiffblueTest {
  /**
   * Test {@link PDTransparencyGroupAttributes#PDTransparencyGroupAttributes(COSDictionary)}.
   *
   * <p>Method under test: {@link
   * PDTransparencyGroupAttributes#PDTransparencyGroupAttributes(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDTransparencyGroupAttributes(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTransparencyGroupAttributes.<init>(COSDictionary)"})
  void testNewPDTransparencyGroupAttributes() {
    // Arrange
    COSDictionary dic = new COSDictionary();

    // Act and Assert
    assertSame(dic, new PDTransparencyGroupAttributes(dic).getCOSObject());
  }

  /**
   * Test {@link PDTransparencyGroupAttributes#PDTransparencyGroupAttributes()}.
   *
   * <p>Method under test: {@link PDTransparencyGroupAttributes#PDTransparencyGroupAttributes()}
   */
  @Test
  @DisplayName("Test new PDTransparencyGroupAttributes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTransparencyGroupAttributes.<init>()"})
  void testNewPDTransparencyGroupAttributes2() throws IOException {
    // Arrange and Act
    PDTransparencyGroupAttributes actualPdTransparencyGroupAttributes =
        new PDTransparencyGroupAttributes();

    // Assert
    COSDictionary cOSObject = actualPdTransparencyGroupAttributes.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdTransparencyGroupAttributes.getColorSpace());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPdTransparencyGroupAttributes.isIsolated());
    assertFalse(actualPdTransparencyGroupAttributes.isKnockout());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDTransparencyGroupAttributes#getCOSObject()}.
   *
   * <p>Method under test: {@link PDTransparencyGroupAttributes#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDTransparencyGroupAttributes.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = new PDTransparencyGroupAttributes().getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(1, actualCOSObject.getValues().size());
    assertEquals(1, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDTransparencyGroupAttributes#getColorSpace(PDResources)} with {@code PDResources}.
   *
   * <p>Method under test: {@link PDTransparencyGroupAttributes#getColorSpace(PDResources)}
   */
  @Test
  @DisplayName("Test getColorSpace(PDResources) with 'PDResources'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace PDTransparencyGroupAttributes.getColorSpace(PDResources)"
  })
  void testGetColorSpaceWithPDResources() throws IOException {
    // Arrange
    PDTransparencyGroupAttributes pdTransparencyGroupAttributes =
        new PDTransparencyGroupAttributes(new COSDictionary());

    // Act and Assert
    assertNull(pdTransparencyGroupAttributes.getColorSpace(new PDResources()));
  }

  /**
   * Test {@link PDTransparencyGroupAttributes#getColorSpace(PDResources)} with {@code PDResources}.
   *
   * <ul>
   *   <li>Given {@link PDTransparencyGroupAttributes#PDTransparencyGroupAttributes()}.
   * </ul>
   *
   * <p>Method under test: {@link PDTransparencyGroupAttributes#getColorSpace(PDResources)}
   */
  @Test
  @DisplayName(
      "Test getColorSpace(PDResources) with 'PDResources'; given PDTransparencyGroupAttributes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace PDTransparencyGroupAttributes.getColorSpace(PDResources)"
  })
  void testGetColorSpaceWithPDResources_givenPDTransparencyGroupAttributes() throws IOException {
    // Arrange
    PDTransparencyGroupAttributes pdTransparencyGroupAttributes =
        new PDTransparencyGroupAttributes();

    // Act and Assert
    assertNull(pdTransparencyGroupAttributes.getColorSpace(new PDResources()));
  }

  /**
   * Test {@link PDTransparencyGroupAttributes#getColorSpace()}.
   *
   * <ul>
   *   <li>Given {@link PDTransparencyGroupAttributes#PDTransparencyGroupAttributes(COSDictionary)}
   *       with dic is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDTransparencyGroupAttributes#getColorSpace()}
   */
  @Test
  @DisplayName(
      "Test getColorSpace(); given PDTransparencyGroupAttributes(COSDictionary) with dic is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace PDTransparencyGroupAttributes.getColorSpace()"
  })
  void testGetColorSpace_givenPDTransparencyGroupAttributesWithDicIsCOSDictionary()
      throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDTransparencyGroupAttributes(new COSDictionary()).getColorSpace());
  }

  /**
   * Test {@link PDTransparencyGroupAttributes#getColorSpace()}.
   *
   * <ul>
   *   <li>Given {@link PDTransparencyGroupAttributes#PDTransparencyGroupAttributes()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDTransparencyGroupAttributes#getColorSpace()}
   */
  @Test
  @DisplayName("Test getColorSpace(); given PDTransparencyGroupAttributes(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace PDTransparencyGroupAttributes.getColorSpace()"
  })
  void testGetColorSpace_givenPDTransparencyGroupAttributes_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDTransparencyGroupAttributes().getColorSpace());
  }

  /**
   * Test {@link PDTransparencyGroupAttributes#isIsolated()}.
   *
   * <ul>
   *   <li>Given {@link PDTransparencyGroupAttributes#PDTransparencyGroupAttributes(COSDictionary)}
   *       with dic is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDTransparencyGroupAttributes#isIsolated()}
   */
  @Test
  @DisplayName(
      "Test isIsolated(); given PDTransparencyGroupAttributes(COSDictionary) with dic is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDTransparencyGroupAttributes.isIsolated()"})
  void testIsIsolated_givenPDTransparencyGroupAttributesWithDicIsCOSDictionary() {
    // Arrange, Act and Assert
    assertFalse(new PDTransparencyGroupAttributes(new COSDictionary()).isIsolated());
  }

  /**
   * Test {@link PDTransparencyGroupAttributes#isIsolated()}.
   *
   * <ul>
   *   <li>Given {@link PDTransparencyGroupAttributes#PDTransparencyGroupAttributes()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDTransparencyGroupAttributes#isIsolated()}
   */
  @Test
  @DisplayName("Test isIsolated(); given PDTransparencyGroupAttributes(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDTransparencyGroupAttributes.isIsolated()"})
  void testIsIsolated_givenPDTransparencyGroupAttributes_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDTransparencyGroupAttributes().isIsolated());
  }

  /**
   * Test {@link PDTransparencyGroupAttributes#isKnockout()}.
   *
   * <ul>
   *   <li>Given {@link PDTransparencyGroupAttributes#PDTransparencyGroupAttributes(COSDictionary)}
   *       with dic is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDTransparencyGroupAttributes#isKnockout()}
   */
  @Test
  @DisplayName(
      "Test isKnockout(); given PDTransparencyGroupAttributes(COSDictionary) with dic is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDTransparencyGroupAttributes.isKnockout()"})
  void testIsKnockout_givenPDTransparencyGroupAttributesWithDicIsCOSDictionary() {
    // Arrange, Act and Assert
    assertFalse(new PDTransparencyGroupAttributes(new COSDictionary()).isKnockout());
  }

  /**
   * Test {@link PDTransparencyGroupAttributes#isKnockout()}.
   *
   * <ul>
   *   <li>Given {@link PDTransparencyGroupAttributes#PDTransparencyGroupAttributes()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDTransparencyGroupAttributes#isKnockout()}
   */
  @Test
  @DisplayName("Test isKnockout(); given PDTransparencyGroupAttributes(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDTransparencyGroupAttributes.isKnockout()"})
  void testIsKnockout_givenPDTransparencyGroupAttributes_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDTransparencyGroupAttributes().isKnockout());
  }
}
