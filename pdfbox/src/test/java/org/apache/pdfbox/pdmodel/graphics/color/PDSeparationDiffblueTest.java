package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNull;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.function.PDFunction;
import org.apache.pdfbox.pdmodel.common.function.PDFunctionType0;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDSeparationDiffblueTest {
  /**
   * Test {@link PDSeparation#PDSeparation()}.
   *
   * <p>Method under test: {@link PDSeparation#PDSeparation()}
   */
  @Test
  @DisplayName("Test new PDSeparation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSeparation.<init>()"})
  void testNewPDSeparation() {
    // Arrange and Act
    PDSeparation actualPdSeparation = new PDSeparation();

    // Assert
    COSBase cOSObject = actualPdSeparation.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    assertEquals("", actualPdSeparation.getColorantName());
    assertEquals("Separation", actualPdSeparation.getName());
    PDColor initialColor = actualPdSeparation.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(actualPdSeparation.getAlternateColorSpace());
    assertEquals(1, actualPdSeparation.getNumberOfComponents());
    assertEquals(4, ((COSArray) cOSObject).toList().size());
    assertFalse(initialColor.isPattern());
    assertSame(actualPdSeparation, initialColor.getColorSpace());
    assertArrayEquals(new float[] {1.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDSeparation#PDSeparation(COSArray)}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDSeparation#PDSeparation(COSArray)}
   */
  @Test
  @DisplayName("Test new PDSeparation(COSArray); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSeparation.<init>(COSArray)"})
  void testNewPDSeparation_thenThrowIOException() throws IOException {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray separation = new COSArray();
    separation.add(COSBoolean.FALSE);
    separation.add(object);
    separation.add(2, COSBoolean.FALSE);

    // Act and Assert
    assertThrows(IOException.class, () -> new PDSeparation(separation));
    verify(object).getCOSObject();
  }

  /**
   * Test {@link PDSeparation#getName()}.
   *
   * <p>Method under test: {@link PDSeparation#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDSeparation.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("Separation", new PDSeparation().getName());
  }

  /**
   * Test {@link PDSeparation#getDefaultDecode(int)}.
   *
   * <p>Method under test: {@link PDSeparation#getDefaultDecode(int)}
   */
  @Test
  @DisplayName("Test getDefaultDecode(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDSeparation.getDefaultDecode(int)"})
  void testGetDefaultDecode() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[] {0.0f, 1.0f}, new PDSeparation().getDefaultDecode(1), 0.0f);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDSeparation#getAlternateColorSpace()}
   *   <li>{@link PDSeparation#getInitialColor()}
   *   <li>{@link PDSeparation#getNumberOfComponents()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDColorSpace PDSeparation.getAlternateColorSpace()",
    "PDColor PDSeparation.getInitialColor()",
    "int PDSeparation.getNumberOfComponents()",
    "String PDSeparation.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    PDSeparation pdSeparation = new PDSeparation();

    // Act
    PDColorSpace actualAlternateColorSpace = pdSeparation.getAlternateColorSpace();
    PDColor actualInitialColor = pdSeparation.getInitialColor();

    // Assert
    assertNull(actualInitialColor.getPatternName());
    assertNull(actualAlternateColorSpace);
    assertEquals(1, pdSeparation.getNumberOfComponents());
    assertFalse(actualInitialColor.isPattern());
    assertSame(pdSeparation, actualInitialColor.getColorSpace());
    assertArrayEquals(new float[] {1.0f}, actualInitialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDSeparation#getColorantName()}.
   *
   * <p>Method under test: {@link PDSeparation#getColorantName()}
   */
  @Test
  @DisplayName("Test getColorantName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDSeparation.getColorantName()"})
  void testGetColorantName() {
    // Arrange, Act and Assert
    assertEquals("", new PDSeparation().getColorantName());
  }

  /**
   * Test {@link PDSeparation#setColorantName(String)}.
   *
   * <p>Method under test: {@link PDSeparation#setColorantName(String)}
   */
  @Test
  @DisplayName("Test setColorantName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSeparation.setColorantName(String)"})
  void testSetColorantName() {
    // Arrange
    PDSeparation pdSeparation = new PDSeparation();

    // Act
    pdSeparation.setColorantName("Name");

    // Assert
    COSBase cOSObject = pdSeparation.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSName);
    assertEquals("Name", ((COSName) getResult).getName());
    assertEquals("Name", pdSeparation.getColorantName());
    assertFalse(((COSName) getResult).isEmpty());
  }

  /**
   * Test {@link PDSeparation#setAlternateColorSpace(PDColorSpace)}.
   *
   * <ul>
   *   <li>Then {@link PDSeparation#PDSeparation()} AlternateColorSpace is {@link
   *       PDDeviceGray#INSTANCE}.
   * </ul>
   *
   * <p>Method under test: {@link PDSeparation#setAlternateColorSpace(PDColorSpace)}
   */
  @Test
  @DisplayName(
      "Test setAlternateColorSpace(PDColorSpace); then PDSeparation() AlternateColorSpace is INSTANCE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSeparation.setAlternateColorSpace(PDColorSpace)"})
  void testSetAlternateColorSpace_thenPDSeparationAlternateColorSpaceIsInstance() {
    // Arrange
    PDSeparation pdSeparation = new PDSeparation();

    // Act
    pdSeparation.setAlternateColorSpace(PDDeviceGray.INSTANCE);

    // Assert
    COSBase cOSObject = pdSeparation.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(3);
    assertTrue(getResult instanceof COSNull);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertSame(PDDeviceGray.INSTANCE, pdSeparation.getAlternateColorSpace());
  }

  /**
   * Test {@link PDSeparation#setAlternateColorSpace(PDColorSpace)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDSeparation#PDSeparation()} COSObject toList third is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDSeparation#setAlternateColorSpace(PDColorSpace)}
   */
  @Test
  @DisplayName(
      "Test setAlternateColorSpace(PDColorSpace); when 'null'; then PDSeparation() COSObject toList third is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSeparation.setAlternateColorSpace(PDColorSpace)"})
  void testSetAlternateColorSpace_whenNull_thenPDSeparationCOSObjectToListThirdIsNull() {
    // Arrange
    PDSeparation pdSeparation = new PDSeparation();

    // Act
    pdSeparation.setAlternateColorSpace(null);

    // Assert
    COSBase cOSObject = pdSeparation.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(3);
    assertTrue(getResult instanceof COSNull);
    assertNull(toListResult.get(2));
    assertNull(getResult.getKey());
    assertNull(pdSeparation.getAlternateColorSpace());
    assertFalse(getResult.isDirect());
  }

  /**
   * Test {@link PDSeparation#setTintTransform(PDFunction)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDSeparation#setTintTransform(PDFunction)}
   */
  @Test
  @DisplayName("Test setTintTransform(PDFunction); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSeparation.setTintTransform(PDFunction)"})
  void testSetTintTransform_whenNull() {
    // Arrange
    PDSeparation pdSeparation = new PDSeparation();

    // Act
    pdSeparation.setTintTransform(null);

    // Assert
    COSBase cOSObject = pdSeparation.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    assertNull(toListResult.get(3));
  }

  /**
   * Test {@link PDSeparation#setTintTransform(PDFunction)}.
   *
   * <ul>
   *   <li>When {@link PDFunctionType0#PDFunctionType0(COSBase)} with function is {@link
   *       COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDSeparation#setTintTransform(PDFunction)}
   */
  @Test
  @DisplayName(
      "Test setTintTransform(PDFunction); when PDFunctionType0(COSBase) with function is FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSeparation.setTintTransform(PDFunction)"})
  void testSetTintTransform_whenPDFunctionType0WithFunctionIsFalse() {
    // Arrange
    PDSeparation pdSeparation = new PDSeparation();

    // Act
    pdSeparation.setTintTransform(new PDFunctionType0(COSBoolean.FALSE));

    // Assert
    COSBase cOSObject = pdSeparation.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    assertNull(toListResult.get(3));
  }
}
