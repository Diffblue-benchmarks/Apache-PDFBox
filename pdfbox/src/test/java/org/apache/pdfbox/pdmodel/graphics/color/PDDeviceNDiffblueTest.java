package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNull;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.function.PDFunction;
import org.apache.pdfbox.pdmodel.common.function.PDFunctionType0;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDDeviceNDiffblueTest {
  /**
   * Test {@link PDDeviceN#PDDeviceN()}.
   *
   * <p>Method under test: {@link PDDeviceN#PDDeviceN()}
   */
  @Test
  @DisplayName("Test new PDDeviceN()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDeviceN.<init>()"})
  void testNewPDDeviceN() {
    // Arrange and Act
    PDDeviceN actualPdDeviceN = new PDDeviceN();

    // Assert
    COSBase cOSObject = actualPdDeviceN.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSName);
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSNull);
    assertEquals("DeviceN", actualPdDeviceN.getName());
    assertNull(actualPdDeviceN.getInitialColor());
    assertNull(actualPdDeviceN.getAttributes());
    assertFalse(actualPdDeviceN.isNChannel());
    assertSame(getResult, toListResult.get(2));
    assertSame(getResult, toListResult.get(3));
  }

  /**
   * Test {@link PDDeviceN#PDDeviceN(COSArray)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link
   *       COSBoolean#FALSE}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDDeviceN#PDDeviceN(COSArray)}
   */
  @Test
  @DisplayName(
      "Test new PDDeviceN(COSArray); given COSObjectable getCOSObject() return FALSE; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDeviceN.<init>(COSArray)"})
  void testNewPDDeviceN_givenCOSObjectableGetCOSObjectReturnFalse_thenThrowIOException()
      throws IOException {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray deviceN = new COSArray();
    deviceN.add(COSBoolean.FALSE);
    deviceN.add(object);
    deviceN.add(2, COSBoolean.FALSE);

    // Act and Assert
    assertThrows(IOException.class, () -> new PDDeviceN(deviceN));
    verify(object).getCOSObject();
  }

  /**
   * Test {@link PDDeviceN#toRawImage(WritableRaster)} with {@code raster}.
   *
   * <p>Method under test: {@link PDDeviceN#toRawImage(WritableRaster)}
   */
  @Test
  @DisplayName("Test toRawImage(WritableRaster) with 'raster'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.awt.image.BufferedImage PDDeviceN.toRawImage(WritableRaster)"})
  void testToRawImageWithRaster() {
    // Arrange, Act and Assert
    assertNull(new PDDeviceN().toRawImage(null));
  }

  /**
   * Test {@link PDDeviceN#isNChannel()}.
   *
   * <p>Method under test: {@link PDDeviceN#isNChannel()}
   */
  @Test
  @DisplayName("Test isNChannel()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDDeviceN.isNChannel()"})
  void testIsNChannel() {
    // Arrange, Act and Assert
    assertFalse(new PDDeviceN().isNChannel());
  }

  /**
   * Test {@link PDDeviceN#getName()}.
   *
   * <p>Method under test: {@link PDDeviceN#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDDeviceN.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("DeviceN", new PDDeviceN().getName());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDDeviceN#getAttributes()}
   *   <li>{@link PDDeviceN#getInitialColor()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDDeviceNAttributes PDDeviceN.getAttributes()",
    "org.apache.pdfbox.pdmodel.graphics.color.PDColor PDDeviceN.getInitialColor()"
  })
  void testGettersAndSetters() {
    // Arrange
    PDDeviceN pdDeviceN = new PDDeviceN();

    // Act
    PDDeviceNAttributes actualAttributes = pdDeviceN.getAttributes();

    // Assert
    assertNull(pdDeviceN.getInitialColor());
    assertNull(actualAttributes);
  }

  /**
   * Test {@link PDDeviceN#setColorantNames(List)}.
   *
   * <p>Method under test: {@link PDDeviceN#setColorantNames(List)}
   */
  @Test
  @DisplayName("Test setColorantNames(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDeviceN.setColorantNames(List)"})
  void testSetColorantNames() {
    // Arrange
    PDDeviceN pdDeviceN = new PDDeviceN();

    // Act
    pdDeviceN.setColorantNames(new ArrayList<>());

    // Assert
    COSBase cOSObject = pdDeviceN.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSNull);
    assertNull(getResult2.getKey());
    assertEquals(0, pdDeviceN.getNumberOfComponents());
    assertFalse(getResult2.isDirect());
    assertTrue(((COSArray) getResult).toList().isEmpty());
    assertTrue(pdDeviceN.getColorantNames().isEmpty());
    assertSame(getResult2, toListResult.get(3));
  }

  /**
   * Test {@link PDDeviceN#setAttributes(PDDeviceNAttributes)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then {@link PDDeviceN#PDDeviceN()} COSObject toList fifth {@link COSObject}.
   * </ul>
   *
   * <p>Method under test: {@link PDDeviceN#setAttributes(PDDeviceNAttributes)}
   */
  @Test
  @DisplayName(
      "Test setAttributes(PDDeviceNAttributes); given 'false'; then PDDeviceN() COSObject toList fifth COSObject")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDeviceN.setAttributes(PDDeviceNAttributes)"})
  void testSetAttributes_givenFalse_thenPDDeviceNCOSObjectToListFifthCOSObject() {
    // Arrange
    PDDeviceN pdDeviceN = new PDDeviceN();

    COSDictionary attributes = new COSDictionary(new COSDictionary());
    attributes.setDirect(false);
    COSObjectKey key = new COSObjectKey(1L, 1);
    attributes.setKey(key);
    PDDeviceNAttributes attributes2 = new PDDeviceNAttributes(attributes);

    // Act
    pdDeviceN.setAttributes(attributes2);

    // Assert
    COSBase cOSObject = pdDeviceN.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(5, toListResult.size());
    COSBase getResult = toListResult.get(4);
    assertTrue(getResult instanceof COSObject);
    assertFalse(getResult.isDirect());
    assertFalse(((COSObject) getResult).isObjectNull());
    assertFalse(((COSObject) getResult).isNeedToBeUpdated());
    assertTrue(((COSObject) getResult).isDereferenced());
    assertSame(attributes, ((COSObject) getResult).getObject());
    assertSame(key, getResult.getKey());
    assertSame(attributes2, pdDeviceN.getAttributes());
  }

  /**
   * Test {@link PDDeviceN#setAttributes(PDDeviceNAttributes)}.
   *
   * <ul>
   *   <li>Then {@link PDDeviceN#PDDeviceN()} Attributes is {@link
   *       PDDeviceNAttributes#PDDeviceNAttributes()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDeviceN#setAttributes(PDDeviceNAttributes)}
   */
  @Test
  @DisplayName(
      "Test setAttributes(PDDeviceNAttributes); then PDDeviceN() Attributes is PDDeviceNAttributes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDeviceN.setAttributes(PDDeviceNAttributes)"})
  void testSetAttributes_thenPDDeviceNAttributesIsPDDeviceNAttributes() {
    // Arrange
    PDDeviceN pdDeviceN = new PDDeviceN();
    PDDeviceNAttributes attributes = new PDDeviceNAttributes();

    // Act
    pdDeviceN.setAttributes(attributes);

    // Assert
    COSBase cOSObject = pdDeviceN.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    assertEquals(5, ((COSArray) cOSObject).toList().size());
    assertSame(attributes, pdDeviceN.getAttributes());
  }

  /**
   * Test {@link PDDeviceN#getAlternateColorSpace()}.
   *
   * <p>Method under test: {@link PDDeviceN#getAlternateColorSpace()}
   */
  @Test
  @DisplayName("Test getAlternateColorSpace()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDDeviceN.getAlternateColorSpace()"})
  void testGetAlternateColorSpace() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new PDDeviceN().getAlternateColorSpace());
  }

  /**
   * Test {@link PDDeviceN#setAlternateColorSpace(PDColorSpace)}.
   *
   * <ul>
   *   <li>Then {@link PDDeviceN#PDDeviceN()} AlternateColorSpace is {@link PDDeviceGray#INSTANCE}.
   * </ul>
   *
   * <p>Method under test: {@link PDDeviceN#setAlternateColorSpace(PDColorSpace)}
   */
  @Test
  @DisplayName(
      "Test setAlternateColorSpace(PDColorSpace); then PDDeviceN() AlternateColorSpace is INSTANCE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDeviceN.setAlternateColorSpace(PDColorSpace)"})
  void testSetAlternateColorSpace_thenPDDeviceNAlternateColorSpaceIsInstance() throws IOException {
    // Arrange
    PDDeviceN pdDeviceN = new PDDeviceN();

    // Act
    pdDeviceN.setAlternateColorSpace(PDDeviceGray.INSTANCE);

    // Assert
    COSBase cOSObject = pdDeviceN.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    assertEquals(4, ((COSArray) cOSObject).toList().size());
    assertSame(PDDeviceGray.INSTANCE, pdDeviceN.getAlternateColorSpace());
  }

  /**
   * Test {@link PDDeviceN#setAlternateColorSpace(PDColorSpace)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDDeviceN#PDDeviceN()} COSObject toList third is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDDeviceN#setAlternateColorSpace(PDColorSpace)}
   */
  @Test
  @DisplayName(
      "Test setAlternateColorSpace(PDColorSpace); when 'null'; then PDDeviceN() COSObject toList third is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDeviceN.setAlternateColorSpace(PDColorSpace)"})
  void testSetAlternateColorSpace_whenNull_thenPDDeviceNCOSObjectToListThirdIsNull() {
    // Arrange
    PDDeviceN pdDeviceN = new PDDeviceN();

    // Act
    pdDeviceN.setAlternateColorSpace(null);

    // Assert
    COSBase cOSObject = pdDeviceN.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    assertNull(toListResult.get(2));
  }

  /**
   * Test {@link PDDeviceN#setTintTransform(PDFunction)}.
   *
   * <p>Method under test: {@link PDDeviceN#setTintTransform(PDFunction)}
   */
  @Test
  @DisplayName("Test setTintTransform(PDFunction)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDeviceN.setTintTransform(PDFunction)"})
  void testSetTintTransform() throws IOException {
    // Arrange
    PDDeviceN pdDeviceN = new PDDeviceN();
    PDFunctionType0 tint = new PDFunctionType0(COSBoolean.FALSE);

    // Act
    pdDeviceN.setTintTransform(tint);

    // Assert
    COSBase cOSObject = pdDeviceN.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    assertNull(toListResult.get(3));
    assertSame(tint, pdDeviceN.getTintTransform());
  }

  /**
   * Test {@link PDDeviceN#setTintTransform(PDFunction)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDDeviceN#setTintTransform(PDFunction)}
   */
  @Test
  @DisplayName("Test setTintTransform(PDFunction); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDeviceN.setTintTransform(PDFunction)"})
  void testSetTintTransform_whenNull() {
    // Arrange
    PDDeviceN pdDeviceN = new PDDeviceN();

    // Act
    pdDeviceN.setTintTransform(null);

    // Assert
    COSBase cOSObject = pdDeviceN.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    assertNull(toListResult.get(3));
  }
}
