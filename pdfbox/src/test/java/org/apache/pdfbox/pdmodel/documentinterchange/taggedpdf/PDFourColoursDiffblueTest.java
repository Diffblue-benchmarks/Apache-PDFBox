package org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSNull;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.pdfparser.COSParser;
import org.apache.pdfbox.pdmodel.graphics.color.PDGamma;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFourColoursDiffblueTest {
  /**
   * Test {@link PDFourColours#PDFourColours()}.
   *
   * <p>Method under test: {@link PDFourColours#PDFourColours()}
   */
  @Test
  @DisplayName("Test new PDFourColours()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFourColours.<init>()"})
  void testNewPDFourColours() {
    // Arrange and Act
    PDFourColours actualPdFourColours = new PDFourColours();

    // Assert
    COSBase cOSObject = actualPdFourColours.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSNull);
    assertNull(getResult.getKey());
    assertNull(actualPdFourColours.getAfterColour());
    assertNull(actualPdFourColours.getBeforeColour());
    assertNull(actualPdFourColours.getEndColour());
    assertNull(actualPdFourColours.getStartColour());
    assertFalse(getResult.isDirect());
    assertSame(getResult, toListResult.get(1));
    assertSame(getResult, toListResult.get(2));
    assertSame(getResult, toListResult.get(3));
  }

  /**
   * Test {@link PDFourColours#PDFourColours(COSArray)}.
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.
   *   <li>Then return AfterColour is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFourColours#PDFourColours(COSArray)}
   */
  @Test
  @DisplayName(
      "Test new PDFourColours(COSArray); when COSArray(); then return AfterColour is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFourColours.<init>(COSArray)"})
  void testNewPDFourColours_whenCOSArray_thenReturnAfterColourIsNull() {
    // Arrange
    COSArray array = new COSArray();

    // Act
    PDFourColours actualPdFourColours = new PDFourColours(array);

    // Assert
    assertNull(actualPdFourColours.getAfterColour());
    assertNull(actualPdFourColours.getBeforeColour());
    assertNull(actualPdFourColours.getEndColour());
    assertNull(actualPdFourColours.getStartColour());
    assertEquals(5, array.toList().size());
    assertSame(array, actualPdFourColours.getCOSObject());
  }

  /**
   * Test {@link PDFourColours#getBeforeColour()}.
   *
   * <p>Method under test: {@link PDFourColours#getBeforeColour()}
   */
  @Test
  @DisplayName("Test getBeforeColour()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDGamma PDFourColours.getBeforeColour()"})
  void testGetBeforeColour() {
    // Arrange
    COSArray array = new COSArray();
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    array.add((COSBase) object);

    // Act and Assert
    assertNull(new PDFourColours(array).getBeforeColour());
  }

  /**
   * Test {@link PDFourColours#getBeforeColour()}.
   *
   * <p>Method under test: {@link PDFourColours#getBeforeColour()}
   */
  @Test
  @DisplayName("Test getBeforeColour()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDGamma PDFourColours.getBeforeColour()"})
  void testGetBeforeColour2() throws IOException {
    // Arrange
    COSArray array = new COSArray();
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObject object = new COSObject(key, new COSParser(new RandomAccessReadWriteBuffer()));
    array.add((COSBase) object);

    // Act and Assert
    assertNull(new PDFourColours(array).getBeforeColour());
  }

  /**
   * Test {@link PDFourColours#getBeforeColour()}.
   *
   * <p>Method under test: {@link PDFourColours#getBeforeColour()}
   */
  @Test
  @DisplayName("Test getBeforeColour()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDGamma PDFourColours.getBeforeColour()"})
  void testGetBeforeColour3() {
    // Arrange
    COSArray array = new COSArray();
    COSObject object = new COSObject(new COSObjectKey(1L, 1), null);
    array.add((COSBase) object);

    // Act and Assert
    assertNull(new PDFourColours(array).getBeforeColour());
  }

  /**
   * Test {@link PDFourColours#getBeforeColour()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSArray#COSArray()}.
   *   <li>Then return COSArray toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDFourColours#getBeforeColour()}
   */
  @Test
  @DisplayName(
      "Test getBeforeColour(); given COSArray() add COSArray(); then return COSArray toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDGamma PDFourColours.getBeforeColour()"})
  void testGetBeforeColour_givenCOSArrayAddCOSArray_thenReturnCOSArrayToListEmpty() {
    // Arrange
    COSArray array = new COSArray();
    COSArray object = new COSArray();
    array.add((COSBase) object);

    // Act
    PDGamma actualBeforeColour = new PDFourColours(array).getBeforeColour();

    // Assert
    COSArray cOSArray = actualBeforeColour.getCOSArray();
    assertTrue(cOSArray.toList().isEmpty());
    assertSame(object, cOSArray);
    assertSame(object, actualBeforeColour.getCOSObject());
  }

  /**
   * Test {@link PDFourColours#getBeforeColour()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFourColours#getBeforeColour()}
   */
  @Test
  @DisplayName("Test getBeforeColour(); given COSArray() add FALSE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDGamma PDFourColours.getBeforeColour()"})
  void testGetBeforeColour_givenCOSArrayAddFalse_thenReturnNull() {
    // Arrange
    COSArray array = new COSArray();
    array.add(COSBoolean.FALSE);

    // Act and Assert
    assertNull(new PDFourColours(array).getBeforeColour());
  }

  /**
   * Test {@link PDFourColours#getBeforeColour()}.
   *
   * <ul>
   *   <li>Given {@link PDFourColours#PDFourColours()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFourColours#getBeforeColour()}
   */
  @Test
  @DisplayName("Test getBeforeColour(); given PDFourColours(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDGamma PDFourColours.getBeforeColour()"})
  void testGetBeforeColour_givenPDFourColours_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDFourColours().getBeforeColour());
  }

  /**
   * Test {@link PDFourColours#setBeforeColour(PDGamma)}.
   *
   * <p>Method under test: {@link PDFourColours#setBeforeColour(PDGamma)}
   */
  @Test
  @DisplayName("Test setBeforeColour(PDGamma)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFourColours.setBeforeColour(PDGamma)"})
  void testSetBeforeColour() {
    // Arrange
    PDFourColours pdFourColours = new PDFourColours();

    COSArray array = new COSArray(new ArrayList<>());
    array.setDirect(false);
    array.setKey(null);

    // Act
    pdFourColours.setBeforeColour(new PDGamma(array));

    // Assert
    COSBase cOSObject = pdFourColours.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    assertSame(array, toListResult.get(0));
    PDGamma beforeColour = pdFourColours.getBeforeColour();
    assertSame(array, beforeColour.getCOSArray());
    assertSame(array, beforeColour.getCOSObject());
  }

  /**
   * Test {@link PDFourColours#setBeforeColour(PDGamma)}.
   *
   * <ul>
   *   <li>Then {@link PDFourColours#PDFourColours()} COSObject toList first {@link COSObject}.
   * </ul>
   *
   * <p>Method under test: {@link PDFourColours#setBeforeColour(PDGamma)}
   */
  @Test
  @DisplayName(
      "Test setBeforeColour(PDGamma); then PDFourColours() COSObject toList first COSObject")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFourColours.setBeforeColour(PDGamma)"})
  void testSetBeforeColour_thenPDFourColoursCOSObjectToListFirstCOSObject() {
    // Arrange
    PDFourColours pdFourColours = new PDFourColours();

    COSArray array = new COSArray(new ArrayList<>());
    array.setDirect(false);
    COSObjectKey key = new COSObjectKey(1L, 1);
    array.setKey(key);

    // Act
    pdFourColours.setBeforeColour(new PDGamma(array));

    // Assert
    COSBase cOSObject = pdFourColours.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSObject);
    assertFalse(((COSObject) getResult).isObjectNull());
    assertFalse(((COSObject) getResult).isNeedToBeUpdated());
    assertTrue(((COSObject) getResult).isDereferenced());
    assertSame(array, ((COSObject) getResult).getObject());
    assertSame(key, getResult.getKey());
  }

  /**
   * Test {@link PDFourColours#setBeforeColour(PDGamma)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDFourColours#PDFourColours()} COSObject toList first {@link COSNull}.
   * </ul>
   *
   * <p>Method under test: {@link PDFourColours#setBeforeColour(PDGamma)}
   */
  @Test
  @DisplayName(
      "Test setBeforeColour(PDGamma); when 'null'; then PDFourColours() COSObject toList first COSNull")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFourColours.setBeforeColour(PDGamma)"})
  void testSetBeforeColour_whenNull_thenPDFourColoursCOSObjectToListFirstCOSNull() {
    // Arrange
    PDFourColours pdFourColours = new PDFourColours();

    // Act
    pdFourColours.setBeforeColour(null);

    // Assert that nothing has changed
    COSBase cOSObject = pdFourColours.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSNull);
  }

  /**
   * Test {@link PDFourColours#setBeforeColour(PDGamma)}.
   *
   * <ul>
   *   <li>When {@link PDGamma#PDGamma()}.
   *   <li>Then {@link PDFourColours#PDFourColours()} BeforeColour B is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFourColours#setBeforeColour(PDGamma)}
   */
  @Test
  @DisplayName(
      "Test setBeforeColour(PDGamma); when PDGamma(); then PDFourColours() BeforeColour B is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFourColours.setBeforeColour(PDGamma)"})
  void testSetBeforeColour_whenPDGamma_thenPDFourColoursBeforeColourBIsZero() {
    // Arrange
    PDFourColours pdFourColours = new PDFourColours();

    // Act
    pdFourColours.setBeforeColour(new PDGamma());

    // Assert
    COSBase cOSObject = pdFourColours.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    PDGamma beforeColour = pdFourColours.getBeforeColour();
    assertEquals(0.0f, beforeColour.getB());
    assertEquals(0.0f, beforeColour.getG());
    assertEquals(0.0f, beforeColour.getR());
    assertEquals(4, ((COSArray) cOSObject).toList().size());
  }

  /**
   * Test {@link PDFourColours#getAfterColour()}.
   *
   * <p>Method under test: {@link PDFourColours#getAfterColour()}
   */
  @Test
  @DisplayName("Test getAfterColour()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDGamma PDFourColours.getAfterColour()"})
  void testGetAfterColour() {
    // Arrange
    COSArray array = new COSArray(new ArrayList<>());
    array.add(COSBoolean.FALSE);
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    array.add((COSBase) object);

    // Act and Assert
    assertNull(new PDFourColours(array).getAfterColour());
  }

  /**
   * Test {@link PDFourColours#getAfterColour()}.
   *
   * <p>Method under test: {@link PDFourColours#getAfterColour()}
   */
  @Test
  @DisplayName("Test getAfterColour()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDGamma PDFourColours.getAfterColour()"})
  void testGetAfterColour2() throws IOException {
    // Arrange
    COSArray array = new COSArray(new ArrayList<>());
    array.add(COSBoolean.FALSE);
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObject object = new COSObject(key, new COSParser(new RandomAccessReadWriteBuffer()));
    array.add((COSBase) object);

    // Act and Assert
    assertNull(new PDFourColours(array).getAfterColour());
  }

  /**
   * Test {@link PDFourColours#getAfterColour()}.
   *
   * <p>Method under test: {@link PDFourColours#getAfterColour()}
   */
  @Test
  @DisplayName("Test getAfterColour()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDGamma PDFourColours.getAfterColour()"})
  void testGetAfterColour3() {
    // Arrange
    COSArray array = new COSArray(new ArrayList<>());
    array.add(COSBoolean.FALSE);
    COSObject object = new COSObject(new COSObjectKey(1L, 1), null);
    array.add((COSBase) object);

    // Act and Assert
    assertNull(new PDFourColours(array).getAfterColour());
  }

  /**
   * Test {@link PDFourColours#getAfterColour()}.
   *
   * <ul>
   *   <li>Given {@link PDFourColours#PDFourColours()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFourColours#getAfterColour()}
   */
  @Test
  @DisplayName("Test getAfterColour(); given PDFourColours(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDGamma PDFourColours.getAfterColour()"})
  void testGetAfterColour_givenPDFourColours_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDFourColours().getAfterColour());
  }

  /**
   * Test {@link PDFourColours#getAfterColour()}.
   *
   * <ul>
   *   <li>Then return COSArray toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDFourColours#getAfterColour()}
   */
  @Test
  @DisplayName("Test getAfterColour(); then return COSArray toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDGamma PDFourColours.getAfterColour()"})
  void testGetAfterColour_thenReturnCOSArrayToListEmpty() {
    // Arrange
    COSArray array = new COSArray(new ArrayList<>());
    array.add(COSBoolean.FALSE);
    COSArray object = new COSArray();
    array.add((COSBase) object);

    // Act
    PDGamma actualAfterColour = new PDFourColours(array).getAfterColour();

    // Assert
    COSArray cOSArray = actualAfterColour.getCOSArray();
    assertTrue(cOSArray.toList().isEmpty());
    assertSame(object, cOSArray);
    assertSame(object, actualAfterColour.getCOSObject());
  }

  /**
   * Test {@link PDFourColours#getAfterColour()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFourColours#getAfterColour()}
   */
  @Test
  @DisplayName("Test getAfterColour(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDGamma PDFourColours.getAfterColour()"})
  void testGetAfterColour_thenReturnNull() {
    // Arrange
    COSArray array = new COSArray(new ArrayList<>());
    array.add(COSBoolean.FALSE);
    array.add(COSBoolean.FALSE);

    // Act and Assert
    assertNull(new PDFourColours(array).getAfterColour());
  }

  /**
   * Test {@link PDFourColours#setAfterColour(PDGamma)}.
   *
   * <p>Method under test: {@link PDFourColours#setAfterColour(PDGamma)}
   */
  @Test
  @DisplayName("Test setAfterColour(PDGamma)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFourColours.setAfterColour(PDGamma)"})
  void testSetAfterColour() {
    // Arrange
    PDFourColours pdFourColours = new PDFourColours();

    COSArray array = new COSArray(new ArrayList<>());
    array.setDirect(false);
    array.setKey(null);

    // Act
    pdFourColours.setAfterColour(new PDGamma(array));

    // Assert
    COSBase cOSObject = pdFourColours.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    assertSame(array, toListResult.get(1));
    PDGamma afterColour = pdFourColours.getAfterColour();
    assertSame(array, afterColour.getCOSArray());
    assertSame(array, afterColour.getCOSObject());
  }

  /**
   * Test {@link PDFourColours#setAfterColour(PDGamma)}.
   *
   * <p>Method under test: {@link PDFourColours#setAfterColour(PDGamma)}
   */
  @Test
  @DisplayName("Test setAfterColour(PDGamma)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFourColours.setAfterColour(PDGamma)"})
  void testSetAfterColour2() {
    // Arrange
    PDFourColours pdFourColours = new PDFourColours();

    // Act
    pdFourColours.setAfterColour(null);

    // Assert that nothing has changed
    COSBase cOSObject = pdFourColours.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    COSBase expectedGetResult = toListResult.get(0);
    assertSame(expectedGetResult, toListResult.get(1));
  }

  /**
   * Test {@link PDFourColours#setAfterColour(PDGamma)}.
   *
   * <ul>
   *   <li>Then {@link PDFourColours#PDFourColours()} COSObject toList second {@link COSObject}.
   * </ul>
   *
   * <p>Method under test: {@link PDFourColours#setAfterColour(PDGamma)}
   */
  @Test
  @DisplayName(
      "Test setAfterColour(PDGamma); then PDFourColours() COSObject toList second COSObject")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFourColours.setAfterColour(PDGamma)"})
  void testSetAfterColour_thenPDFourColoursCOSObjectToListSecondCOSObject() {
    // Arrange
    PDFourColours pdFourColours = new PDFourColours();

    COSArray array = new COSArray(new ArrayList<>());
    array.setDirect(false);
    COSObjectKey key = new COSObjectKey(1L, 1);
    array.setKey(key);

    // Act
    pdFourColours.setAfterColour(new PDGamma(array));

    // Assert
    COSBase cOSObject = pdFourColours.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSObject);
    assertFalse(getResult.isDirect());
    assertFalse(((COSObject) getResult).isObjectNull());
    assertFalse(((COSObject) getResult).isNeedToBeUpdated());
    assertTrue(((COSObject) getResult).isDereferenced());
    assertSame(array, ((COSObject) getResult).getObject());
    assertSame(key, getResult.getKey());
  }

  /**
   * Test {@link PDFourColours#setAfterColour(PDGamma)}.
   *
   * <ul>
   *   <li>When {@link PDGamma#PDGamma()}.
   *   <li>Then {@link PDFourColours#PDFourColours()} AfterColour B is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFourColours#setAfterColour(PDGamma)}
   */
  @Test
  @DisplayName(
      "Test setAfterColour(PDGamma); when PDGamma(); then PDFourColours() AfterColour B is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFourColours.setAfterColour(PDGamma)"})
  void testSetAfterColour_whenPDGamma_thenPDFourColoursAfterColourBIsZero() {
    // Arrange
    PDFourColours pdFourColours = new PDFourColours();

    // Act
    pdFourColours.setAfterColour(new PDGamma());

    // Assert
    COSBase cOSObject = pdFourColours.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    PDGamma afterColour = pdFourColours.getAfterColour();
    assertEquals(0.0f, afterColour.getB());
    assertEquals(0.0f, afterColour.getG());
    assertEquals(0.0f, afterColour.getR());
    assertEquals(4, ((COSArray) cOSObject).toList().size());
  }

  /**
   * Test {@link PDFourColours#getStartColour()}.
   *
   * <p>Method under test: {@link PDFourColours#getStartColour()}
   */
  @Test
  @DisplayName("Test getStartColour()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDGamma PDFourColours.getStartColour()"})
  void testGetStartColour() {
    // Arrange
    COSArray array = new COSArray(new ArrayList<>());
    array.add(COSBoolean.FALSE);
    array.add(COSBoolean.FALSE);
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(2L, 2));
    array.add((COSBase) object);

    // Act and Assert
    assertNull(new PDFourColours(array).getStartColour());
  }

  /**
   * Test {@link PDFourColours#getStartColour()}.
   *
   * <p>Method under test: {@link PDFourColours#getStartColour()}
   */
  @Test
  @DisplayName("Test getStartColour()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDGamma PDFourColours.getStartColour()"})
  void testGetStartColour2() throws IOException {
    // Arrange
    COSArray array = new COSArray(new ArrayList<>());
    array.add(COSBoolean.FALSE);
    array.add(COSBoolean.FALSE);
    COSObjectKey key = new COSObjectKey(2L, 2);
    COSObject object = new COSObject(key, new COSParser(new RandomAccessReadWriteBuffer()));
    array.add((COSBase) object);

    // Act and Assert
    assertNull(new PDFourColours(array).getStartColour());
  }

  /**
   * Test {@link PDFourColours#getStartColour()}.
   *
   * <p>Method under test: {@link PDFourColours#getStartColour()}
   */
  @Test
  @DisplayName("Test getStartColour()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDGamma PDFourColours.getStartColour()"})
  void testGetStartColour3() {
    // Arrange
    COSArray array = new COSArray(new ArrayList<>());
    array.add(COSBoolean.FALSE);
    array.add(COSBoolean.FALSE);
    COSObject object = new COSObject(new COSObjectKey(2L, 2), null);
    array.add((COSBase) object);

    // Act and Assert
    assertNull(new PDFourColours(array).getStartColour());
  }

  /**
   * Test {@link PDFourColours#getStartColour()}.
   *
   * <ul>
   *   <li>Given {@link PDFourColours#PDFourColours()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFourColours#getStartColour()}
   */
  @Test
  @DisplayName("Test getStartColour(); given PDFourColours(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDGamma PDFourColours.getStartColour()"})
  void testGetStartColour_givenPDFourColours_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDFourColours().getStartColour());
  }

  /**
   * Test {@link PDFourColours#getStartColour()}.
   *
   * <ul>
   *   <li>Then return COSArray toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDFourColours#getStartColour()}
   */
  @Test
  @DisplayName("Test getStartColour(); then return COSArray toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDGamma PDFourColours.getStartColour()"})
  void testGetStartColour_thenReturnCOSArrayToListEmpty() {
    // Arrange
    COSArray array = new COSArray(new ArrayList<>());
    array.add(COSBoolean.FALSE);
    array.add(COSBoolean.FALSE);
    COSArray object = new COSArray();
    array.add((COSBase) object);

    // Act
    PDGamma actualStartColour = new PDFourColours(array).getStartColour();

    // Assert
    COSArray cOSArray = actualStartColour.getCOSArray();
    assertTrue(cOSArray.toList().isEmpty());
    assertSame(object, cOSArray);
    assertSame(object, actualStartColour.getCOSObject());
  }

  /**
   * Test {@link PDFourColours#getStartColour()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFourColours#getStartColour()}
   */
  @Test
  @DisplayName("Test getStartColour(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDGamma PDFourColours.getStartColour()"})
  void testGetStartColour_thenReturnNull() {
    // Arrange
    COSArray array = new COSArray(new ArrayList<>());
    array.add(COSBoolean.FALSE);
    array.add(COSBoolean.FALSE);
    array.add(COSBoolean.FALSE);

    // Act and Assert
    assertNull(new PDFourColours(array).getStartColour());
  }

  /**
   * Test {@link PDFourColours#setStartColour(PDGamma)}.
   *
   * <p>Method under test: {@link PDFourColours#setStartColour(PDGamma)}
   */
  @Test
  @DisplayName("Test setStartColour(PDGamma)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFourColours.setStartColour(PDGamma)"})
  void testSetStartColour() {
    // Arrange
    PDFourColours pdFourColours = new PDFourColours();

    COSArray array = new COSArray(new ArrayList<>());
    array.setDirect(false);
    array.setKey(null);

    // Act
    pdFourColours.setStartColour(new PDGamma(array));

    // Assert
    COSBase cOSObject = pdFourColours.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    assertSame(array, toListResult.get(2));
    PDGamma startColour = pdFourColours.getStartColour();
    assertSame(array, startColour.getCOSArray());
    assertSame(array, startColour.getCOSObject());
  }

  /**
   * Test {@link PDFourColours#setStartColour(PDGamma)}.
   *
   * <p>Method under test: {@link PDFourColours#setStartColour(PDGamma)}
   */
  @Test
  @DisplayName("Test setStartColour(PDGamma)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFourColours.setStartColour(PDGamma)"})
  void testSetStartColour2() {
    // Arrange
    PDFourColours pdFourColours = new PDFourColours();

    // Act
    pdFourColours.setStartColour(null);

    // Assert that nothing has changed
    COSBase cOSObject = pdFourColours.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    COSBase expectedGetResult = toListResult.get(0);
    assertSame(expectedGetResult, toListResult.get(2));
  }

  /**
   * Test {@link PDFourColours#setStartColour(PDGamma)}.
   *
   * <ul>
   *   <li>Then {@link PDFourColours#PDFourColours()} COSObject toList third {@link COSObject}.
   * </ul>
   *
   * <p>Method under test: {@link PDFourColours#setStartColour(PDGamma)}
   */
  @Test
  @DisplayName(
      "Test setStartColour(PDGamma); then PDFourColours() COSObject toList third COSObject")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFourColours.setStartColour(PDGamma)"})
  void testSetStartColour_thenPDFourColoursCOSObjectToListThirdCOSObject() {
    // Arrange
    PDFourColours pdFourColours = new PDFourColours();

    COSArray array = new COSArray(new ArrayList<>());
    array.setDirect(false);
    COSObjectKey key = new COSObjectKey(1L, 1);
    array.setKey(key);

    // Act
    pdFourColours.setStartColour(new PDGamma(array));

    // Assert
    COSBase cOSObject = pdFourColours.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSObject);
    assertFalse(getResult.isDirect());
    assertFalse(((COSObject) getResult).isObjectNull());
    assertFalse(((COSObject) getResult).isNeedToBeUpdated());
    assertTrue(((COSObject) getResult).isDereferenced());
    assertSame(array, ((COSObject) getResult).getObject());
    assertSame(key, getResult.getKey());
  }

  /**
   * Test {@link PDFourColours#setStartColour(PDGamma)}.
   *
   * <ul>
   *   <li>When {@link PDGamma#PDGamma()}.
   *   <li>Then {@link PDFourColours#PDFourColours()} StartColour B is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFourColours#setStartColour(PDGamma)}
   */
  @Test
  @DisplayName(
      "Test setStartColour(PDGamma); when PDGamma(); then PDFourColours() StartColour B is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFourColours.setStartColour(PDGamma)"})
  void testSetStartColour_whenPDGamma_thenPDFourColoursStartColourBIsZero() {
    // Arrange
    PDFourColours pdFourColours = new PDFourColours();

    // Act
    pdFourColours.setStartColour(new PDGamma());

    // Assert
    COSBase cOSObject = pdFourColours.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    PDGamma startColour = pdFourColours.getStartColour();
    assertEquals(0.0f, startColour.getB());
    assertEquals(0.0f, startColour.getG());
    assertEquals(0.0f, startColour.getR());
    assertEquals(4, ((COSArray) cOSObject).toList().size());
  }

  /**
   * Test {@link PDFourColours#getEndColour()}.
   *
   * <p>Method under test: {@link PDFourColours#getEndColour()}
   */
  @Test
  @DisplayName("Test getEndColour()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDGamma PDFourColours.getEndColour()"})
  void testGetEndColour() {
    // Arrange
    COSArray array = new COSArray(new ArrayList<>());
    array.add(COSBoolean.FALSE);
    array.add(COSBoolean.FALSE);
    array.add(COSBoolean.FALSE);
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(3L, 3));
    array.add((COSBase) object);

    // Act and Assert
    assertNull(new PDFourColours(array).getEndColour());
  }

  /**
   * Test {@link PDFourColours#getEndColour()}.
   *
   * <p>Method under test: {@link PDFourColours#getEndColour()}
   */
  @Test
  @DisplayName("Test getEndColour()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDGamma PDFourColours.getEndColour()"})
  void testGetEndColour2() throws IOException {
    // Arrange
    COSArray array = new COSArray(new ArrayList<>());
    array.add(COSBoolean.FALSE);
    array.add(COSBoolean.FALSE);
    array.add(COSBoolean.FALSE);
    COSObjectKey key = new COSObjectKey(3L, 3);
    COSObject object = new COSObject(key, new COSParser(new RandomAccessReadWriteBuffer()));
    array.add((COSBase) object);

    // Act and Assert
    assertNull(new PDFourColours(array).getEndColour());
  }

  /**
   * Test {@link PDFourColours#getEndColour()}.
   *
   * <p>Method under test: {@link PDFourColours#getEndColour()}
   */
  @Test
  @DisplayName("Test getEndColour()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDGamma PDFourColours.getEndColour()"})
  void testGetEndColour3() {
    // Arrange
    COSArray array = new COSArray(new ArrayList<>());
    array.add(COSBoolean.FALSE);
    array.add(COSBoolean.FALSE);
    array.add(COSBoolean.FALSE);
    COSObject object = new COSObject(new COSObjectKey(3L, 3), null);
    array.add((COSBase) object);

    // Act and Assert
    assertNull(new PDFourColours(array).getEndColour());
  }

  /**
   * Test {@link PDFourColours#getEndColour()}.
   *
   * <ul>
   *   <li>Given {@link PDFourColours#PDFourColours()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFourColours#getEndColour()}
   */
  @Test
  @DisplayName("Test getEndColour(); given PDFourColours(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDGamma PDFourColours.getEndColour()"})
  void testGetEndColour_givenPDFourColours_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDFourColours().getEndColour());
  }

  /**
   * Test {@link PDFourColours#getEndColour()}.
   *
   * <ul>
   *   <li>Then return COSArray toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDFourColours#getEndColour()}
   */
  @Test
  @DisplayName("Test getEndColour(); then return COSArray toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDGamma PDFourColours.getEndColour()"})
  void testGetEndColour_thenReturnCOSArrayToListEmpty() {
    // Arrange
    COSArray array = new COSArray(new ArrayList<>());
    array.add(COSBoolean.FALSE);
    array.add(COSBoolean.FALSE);
    array.add(COSBoolean.FALSE);
    COSArray object = new COSArray();
    array.add((COSBase) object);

    // Act
    PDGamma actualEndColour = new PDFourColours(array).getEndColour();

    // Assert
    COSArray cOSArray = actualEndColour.getCOSArray();
    assertTrue(cOSArray.toList().isEmpty());
    assertSame(object, cOSArray);
    assertSame(object, actualEndColour.getCOSObject());
  }

  /**
   * Test {@link PDFourColours#getEndColour()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFourColours#getEndColour()}
   */
  @Test
  @DisplayName("Test getEndColour(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDGamma PDFourColours.getEndColour()"})
  void testGetEndColour_thenReturnNull() {
    // Arrange
    COSArray array = new COSArray(new ArrayList<>());
    array.add(COSBoolean.FALSE);
    array.add(COSBoolean.FALSE);
    array.add(COSBoolean.FALSE);
    array.add(COSBoolean.FALSE);

    // Act and Assert
    assertNull(new PDFourColours(array).getEndColour());
  }

  /**
   * Test {@link PDFourColours#setEndColour(PDGamma)}.
   *
   * <p>Method under test: {@link PDFourColours#setEndColour(PDGamma)}
   */
  @Test
  @DisplayName("Test setEndColour(PDGamma)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFourColours.setEndColour(PDGamma)"})
  void testSetEndColour() {
    // Arrange
    PDFourColours pdFourColours = new PDFourColours();

    COSArray array = new COSArray(new ArrayList<>());
    array.setDirect(false);
    array.setKey(null);

    // Act
    pdFourColours.setEndColour(new PDGamma(array));

    // Assert
    COSBase cOSObject = pdFourColours.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    assertSame(array, toListResult.get(3));
    PDGamma endColour = pdFourColours.getEndColour();
    assertSame(array, endColour.getCOSArray());
    assertSame(array, endColour.getCOSObject());
  }

  /**
   * Test {@link PDFourColours#setEndColour(PDGamma)}.
   *
   * <p>Method under test: {@link PDFourColours#setEndColour(PDGamma)}
   */
  @Test
  @DisplayName("Test setEndColour(PDGamma)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFourColours.setEndColour(PDGamma)"})
  void testSetEndColour2() {
    // Arrange
    PDFourColours pdFourColours = new PDFourColours();

    // Act
    pdFourColours.setEndColour(null);

    // Assert that nothing has changed
    COSBase cOSObject = pdFourColours.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    COSBase expectedGetResult = toListResult.get(0);
    assertSame(expectedGetResult, toListResult.get(3));
  }

  /**
   * Test {@link PDFourColours#setEndColour(PDGamma)}.
   *
   * <ul>
   *   <li>Then {@link PDFourColours#PDFourColours()} COSObject toList fourth {@link COSObject}.
   * </ul>
   *
   * <p>Method under test: {@link PDFourColours#setEndColour(PDGamma)}
   */
  @Test
  @DisplayName("Test setEndColour(PDGamma); then PDFourColours() COSObject toList fourth COSObject")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFourColours.setEndColour(PDGamma)"})
  void testSetEndColour_thenPDFourColoursCOSObjectToListFourthCOSObject() {
    // Arrange
    PDFourColours pdFourColours = new PDFourColours();

    COSArray array = new COSArray(new ArrayList<>());
    array.setDirect(false);
    COSObjectKey key = new COSObjectKey(1L, 1);
    array.setKey(key);

    // Act
    pdFourColours.setEndColour(new PDGamma(array));

    // Assert
    COSBase cOSObject = pdFourColours.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(3);
    assertTrue(getResult instanceof COSObject);
    assertFalse(getResult.isDirect());
    assertFalse(((COSObject) getResult).isObjectNull());
    assertFalse(((COSObject) getResult).isNeedToBeUpdated());
    assertTrue(((COSObject) getResult).isDereferenced());
    assertSame(array, ((COSObject) getResult).getObject());
    assertSame(key, getResult.getKey());
  }

  /**
   * Test {@link PDFourColours#setEndColour(PDGamma)}.
   *
   * <ul>
   *   <li>When {@link PDGamma#PDGamma()}.
   *   <li>Then {@link PDFourColours#PDFourColours()} EndColour B is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFourColours#setEndColour(PDGamma)}
   */
  @Test
  @DisplayName(
      "Test setEndColour(PDGamma); when PDGamma(); then PDFourColours() EndColour B is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFourColours.setEndColour(PDGamma)"})
  void testSetEndColour_whenPDGamma_thenPDFourColoursEndColourBIsZero() {
    // Arrange
    PDFourColours pdFourColours = new PDFourColours();

    // Act
    pdFourColours.setEndColour(new PDGamma());

    // Assert
    COSBase cOSObject = pdFourColours.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    PDGamma endColour = pdFourColours.getEndColour();
    assertEquals(0.0f, endColour.getB());
    assertEquals(0.0f, endColour.getG());
    assertEquals(0.0f, endColour.getR());
    assertEquals(4, ((COSArray) cOSObject).toList().size());
  }

  /**
   * Test {@link PDFourColours#getCOSObject()}.
   *
   * <p>Method under test: {@link PDFourColours#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDFourColours.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange, Act and Assert
    assertTrue(new PDFourColours().getCOSObject() instanceof COSArray);
  }
}
