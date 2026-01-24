package org.apache.pdfbox.pdmodel.graphics.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.common.function.PDFunction;
import org.apache.pdfbox.pdmodel.common.function.PDFunctionTypeIdentity;
import org.apache.pdfbox.pdmodel.graphics.form.PDTransparencyGroup;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PDSoftMaskDiffblueTest {
  @Mock private COSArray cOSArray;

  @Mock private COSDictionary cOSDictionary;

  @InjectMocks private PDSoftMask pDSoftMask;

  /**
   * Test {@link PDSoftMask#create(COSBase)}.
   *
   * <p>Method under test: {@link PDSoftMask#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDSoftMask PDSoftMask.create(COSBase)"})
  void testCreate() throws IOException {
    // Arrange
    COSArray dictionary = new COSArray();
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream object =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 300L, 3L));
    dictionary.add((COSBase) object);

    // Act and Assert
    assertNull(PDSoftMask.create(dictionary));
  }

  /**
   * Test {@link PDSoftMask#create(COSBase)}.
   *
   * <p>Method under test: {@link PDSoftMask#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDSoftMask PDSoftMask.create(COSBase)"})
  void testCreate2() throws IOException {
    // Arrange
    COSArray dictionary = new COSArray();
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream object =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), -1L, 3L));
    dictionary.add((COSBase) object);

    // Act and Assert
    assertNull(PDSoftMask.create(dictionary));
  }

  /**
   * Test {@link PDSoftMask#create(COSBase)}.
   *
   * <p>Method under test: {@link PDSoftMask#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDSoftMask PDSoftMask.create(COSBase)"})
  void testCreate3() throws IOException {
    // Arrange
    COSArray dictionary = new COSArray();
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream object =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 300L, 0L));
    dictionary.add((COSBase) object);

    // Act and Assert
    assertNull(PDSoftMask.create(dictionary));
  }

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
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>When {@link COSArray#COSArray()} add {@link COSArray#COSArray()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDSoftMask#create(COSBase)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase); given COSArray(); when COSArray() add COSArray(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDSoftMask PDSoftMask.create(COSBase)"})
  void testCreate_givenCOSArray_whenCOSArrayAddCOSArray_thenReturnNull() {
    // Arrange
    COSArray dictionary = new COSArray();
    dictionary.add((COSBase) new COSArray());

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
  void testCreate_givenCOSDictionary_whenCOSArrayAddCOSDictionary_thenReturnNull2() {
    // Arrange
    COSArray dictionary = new COSArray();
    dictionary.add(COSBoolean.FALSE);
    dictionary.add((COSBase) new COSDictionary());

    // Act and Assert
    assertNull(PDSoftMask.create(dictionary));
  }

  /**
   * Test {@link PDSoftMask#create(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is three hundred and gen is
   *       three hundred.
   * </ul>
   *
   * <p>Method under test: {@link PDSoftMask#create(COSBase)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase); given COSObjectKey(long, int) with num is three hundred and gen is three hundred")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDSoftMask PDSoftMask.create(COSBase)"})
  void testCreate_givenCOSObjectKeyWithNumIsThreeHundredAndGenIsThreeHundred() {
    // Arrange
    COSArray dictionary = new COSArray();
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(300L, 300));
    dictionary.add((COSBase) object);

    // Act and Assert
    assertNull(PDSoftMask.create(dictionary));
  }

  /**
   * Test {@link PDSoftMask#create(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is three hundred and gen is
   *       three hundred.
   * </ul>
   *
   * <p>Method under test: {@link PDSoftMask#create(COSBase)}
   */
  @Test
  @DisplayName(
      "Test create(COSBase); given COSObjectKey(long, int) with num is three hundred and gen is three hundred")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDSoftMask PDSoftMask.create(COSBase)"})
  void testCreate_givenCOSObjectKeyWithNumIsThreeHundredAndGenIsThreeHundred2() {
    // Arrange
    COSArray dictionary = new COSArray();
    dictionary.add(COSBoolean.FALSE);
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(300L, 300));
    dictionary.add((COSBase) object);

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
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSName(COSName)} return {@link
   *       COSName#A}.
   *   <li>Then return {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link PDSoftMask#getSubType()}
   */
  @Test
  @DisplayName("Test getSubType(); given COSDictionary getCOSName(COSName) return A; then return A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDSoftMask.getSubType()"})
  void testGetSubType_givenCOSDictionaryGetCOSNameReturnA_thenReturnA() {
    // Arrange
    when(cOSDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);

    // Act
    COSName actualSubType = pDSoftMask.getSubType();

    // Assert
    verify(cOSDictionary).getCOSName(isA(COSName.class));
    assertSame(COSName.A, actualSubType);
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
  @MethodsUnderTest({"PDTransparencyGroup PDSoftMask.getGroup()"})
  void testGetGroup_givenPDSoftMaskWithDictionaryIsCOSDictionary_thenReturnNull()
      throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDSoftMask(new COSDictionary()).getGroup());
  }

  /**
   * Test {@link PDSoftMask#getGroup()}.
   *
   * <ul>
   *   <li>Then calls {@link COSDictionary#getDictionaryObject(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDSoftMask#getGroup()}
   */
  @Test
  @DisplayName("Test getGroup(); then calls getDictionaryObject(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDTransparencyGroup PDSoftMask.getGroup()"})
  void testGetGroup_thenCallsGetDictionaryObject() throws IOException {
    // Arrange
    when(cOSDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(null);

    // Act
    PDTransparencyGroup actualGroup = pDSoftMask.getGroup();

    // Assert
    verify(cOSDictionary).getDictionaryObject(isA(COSName.class));
    assertNull(actualGroup);
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
   * Test {@link PDSoftMask#getBackdropColor()}.
   *
   * <ul>
   *   <li>Then calls {@link COSDictionary#getDictionaryObject(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDSoftMask#getBackdropColor()}
   */
  @Test
  @DisplayName("Test getBackdropColor(); then calls getDictionaryObject(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray PDSoftMask.getBackdropColor()"})
  void testGetBackdropColor_thenCallsGetDictionaryObject() {
    // Arrange
    when(cOSDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cOSArray);

    // Act
    pDSoftMask.getBackdropColor();

    // Assert
    verify(cOSDictionary).getDictionaryObject(isA(COSName.class));
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
  @MethodsUnderTest({"PDFunction PDSoftMask.getTransferFunction()"})
  void testGetTransferFunction_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDSoftMask(new COSDictionary()).getTransferFunction());
  }

  /**
   * Test {@link PDSoftMask#getTransferFunction()}.
   *
   * <ul>
   *   <li>Then return {@link PDFunctionTypeIdentity}.
   * </ul>
   *
   * <p>Method under test: {@link PDSoftMask#getTransferFunction()}
   */
  @Test
  @DisplayName("Test getTransferFunction(); then return PDFunctionTypeIdentity")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFunction PDSoftMask.getTransferFunction()"})
  void testGetTransferFunction_thenReturnPDFunctionTypeIdentity() throws IOException {
    // Arrange
    when(cOSDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSName.IDENTITY);

    // Act
    PDFunction actualTransferFunction = pDSoftMask.getTransferFunction();

    // Assert
    verify(cOSDictionary).getDictionaryObject(isA(COSName.class));
    assertTrue(actualTransferFunction instanceof PDFunctionTypeIdentity);
    assertNull(actualTransferFunction.getCOSObject());
    assertEquals(0, actualTransferFunction.getNumberOfOutputParameters());
  }
}
