package org.apache.pdfbox.pdmodel.graphics.state;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDSoftMaskDiffblueTest {
  /**
   * Test {@link PDSoftMask#create(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link COSName#A}.
   *   <li>When {@link COSArray#COSArray()} add {@link COSName#A}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDSoftMask#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase); given A; when COSArray() add A; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDSoftMask PDSoftMask.create(COSBase)"})
  void testCreate_givenA_whenCOSArrayAddA_thenReturnNull() {
    // Arrange
    COSArray dictionary = new COSArray();
    dictionary.add(COSName.A);

    // Act and Assert
    assertNull(PDSoftMask.create(dictionary));
  }

  /**
   * Test {@link PDSoftMask#create(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>When {@link COSArray#COSArray()} add {@link COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDSoftMask#create(COSBase)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase); given COSDictionary(); when COSArray() add COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDSoftMask PDSoftMask.create(COSBase)"})
  void testCreate_givenCOSDictionary_whenCOSArrayAddCOSDictionary_thenReturnNull() {
    // Arrange
    COSArray dictionary = new COSArray();
    dictionary.add((COSBase) new COSDictionary());

    // Act and Assert
    assertNull(PDSoftMask.create(dictionary));
  }

  /**
   * Test {@link PDSoftMask#create(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.
   *   <li>When {@link COSArray#COSArray()} add {@link COSStream#COSStream()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDSoftMask#create(COSBase)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase); given COSStream(); when COSArray() add COSStream(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDSoftMask PDSoftMask.create(COSBase)"})
  void testCreate_givenCOSStream_whenCOSArrayAddCOSStream_thenReturnNull() {
    // Arrange
    COSArray dictionary = new COSArray();
    dictionary.add((COSBase) new COSStream());

    // Act and Assert
    assertNull(PDSoftMask.create(dictionary));
  }

  /**
   * Test {@link PDSoftMask#create(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDSoftMask#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase); given FALSE; when COSArray() add FALSE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDSoftMask PDSoftMask.create(COSBase)"})
  void testCreate_givenFalse_whenCOSArrayAddFalse_thenReturnNull() {
    // Arrange
    COSArray dictionary = new COSArray();
    dictionary.add(COSBoolean.FALSE);

    // Act and Assert
    assertNull(PDSoftMask.create(dictionary));
  }

  /**
   * Test {@link PDSoftMask#create(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link COSInteger#ONE}.
   *   <li>When {@link COSArray#COSArray()} add {@link COSInteger#ONE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDSoftMask#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase); given ONE; when COSArray() add ONE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDSoftMask PDSoftMask.create(COSBase)"})
  void testCreate_givenOne_whenCOSArrayAddOne_thenReturnNull() {
    // Arrange
    COSArray dictionary = new COSArray();
    dictionary.add(COSInteger.ONE);

    // Act and Assert
    assertNull(PDSoftMask.create(dictionary));
  }

  /**
   * Test {@link PDSoftMask#create(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDSoftMask#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase); when A; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDSoftMask PDSoftMask.create(COSBase)"})
  void testCreate_whenA_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PDSoftMask.create(COSName.A));
  }

  /**
   * Test {@link PDSoftMask#create(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDSoftMask#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase); when COSArray(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDSoftMask PDSoftMask.create(COSBase)"})
  void testCreate_whenCOSArray_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PDSoftMask.create(new COSArray()));
  }

  /**
   * Test {@link PDSoftMask#create(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then return BackdropColor is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDSoftMask#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase); when COSDictionary(); then return BackdropColor is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDSoftMask PDSoftMask.create(COSBase)"})
  void testCreate_whenCOSDictionary_thenReturnBackdropColorIsNull() throws IOException {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act
    PDSoftMask actualCreateResult = PDSoftMask.create(dictionary);

    // Assert
    assertNull(actualCreateResult.getBackdropColor());
    assertNull(actualCreateResult.getSubType());
    assertNull(actualCreateResult.getTransferFunction());
    assertNull(actualCreateResult.getGroup());
    assertNull(actualCreateResult.getInitialTransformationMatrix());
    assertSame(dictionary, actualCreateResult.getCOSObject());
  }

  /**
   * Test {@link PDSoftMask#create(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDSoftMask#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase); when FALSE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDSoftMask PDSoftMask.create(COSBase)"})
  void testCreate_whenFalse_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PDSoftMask.create(COSBoolean.FALSE));
  }

  /**
   * Test {@link PDSoftMask#create(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSInteger#ONE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDSoftMask#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase); when ONE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDSoftMask PDSoftMask.create(COSBase)"})
  void testCreate_whenOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PDSoftMask.create(COSInteger.ONE));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDSoftMask#PDSoftMask(COSDictionary)}
   *   <li>{@link PDSoftMask#setInitialTransformationMatrix(Matrix)}
   *   <li>{@link PDSoftMask#getInitialTransformationMatrix()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDSoftMask.<init>(COSDictionary)",
    "Matrix PDSoftMask.getInitialTransformationMatrix()",
    "void PDSoftMask.setInitialTransformationMatrix(Matrix)"
  })
  void testGettersAndSetters() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act
    PDSoftMask actualPdSoftMask = new PDSoftMask(dictionary);
    Matrix ctm = new Matrix();
    actualPdSoftMask.setInitialTransformationMatrix(ctm);
    Matrix actualInitialTransformationMatrix = actualPdSoftMask.getInitialTransformationMatrix();

    // Assert
    assertSame(dictionary, actualPdSoftMask.getCOSObject());
    assertSame(ctm, actualInitialTransformationMatrix);
  }

  /**
   * Test {@link PDSoftMask#getCOSObject()}.
   *
   * <p>Method under test: {@link PDSoftMask#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDSoftMask.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act and Assert
    assertSame(dictionary, new PDSoftMask(dictionary).getCOSObject());
  }

  /**
   * Test {@link PDSoftMask#getSubType()}.
   *
   * <ul>
   *   <li>Given {@link PDSoftMask#PDSoftMask(COSDictionary)} with dictionary is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDSoftMask#getSubType()}
   */
  @Test
  @DisplayName(
      "Test getSubType(); given PDSoftMask(COSDictionary) with dictionary is COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDSoftMask.getSubType()"})
  void testGetSubType_givenPDSoftMaskWithDictionaryIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDSoftMask(new COSDictionary()).getSubType());
  }

  /**
   * Test {@link PDSoftMask#getGroup()}.
   *
   * <ul>
   *   <li>Given {@link PDSoftMask#PDSoftMask(COSDictionary)} with dictionary is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDSoftMask#getGroup()}
   */
  @Test
  @DisplayName(
      "Test getGroup(); given PDSoftMask(COSDictionary) with dictionary is COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.graphics.form.PDTransparencyGroup PDSoftMask.getGroup()"
  })
  void testGetGroup_givenPDSoftMaskWithDictionaryIsCOSDictionary_thenReturnNull()
      throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDSoftMask(new COSDictionary()).getGroup());
  }

  /**
   * Test {@link PDSoftMask#getBackdropColor()}.
   *
   * <ul>
   *   <li>Given {@link PDSoftMask#PDSoftMask(COSDictionary)} with dictionary is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDSoftMask#getBackdropColor()}
   */
  @Test
  @DisplayName(
      "Test getBackdropColor(); given PDSoftMask(COSDictionary) with dictionary is COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray PDSoftMask.getBackdropColor()"})
  void testGetBackdropColor_givenPDSoftMaskWithDictionaryIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDSoftMask(new COSDictionary()).getBackdropColor());
  }

  /**
   * Test {@link PDSoftMask#getTransferFunction()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDSoftMask#getTransferFunction()}
   */
  @Test
  @DisplayName("Test getTransferFunction(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.common.function.PDFunction PDSoftMask.getTransferFunction()"
  })
  void testGetTransferFunction_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDSoftMask(new COSDictionary()).getTransferFunction());
  }
}
