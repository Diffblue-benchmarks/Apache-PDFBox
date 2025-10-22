package org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSNull;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.pdmodel.graphics.color.PDGamma;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFourColoursDiffblueTest {
  /**
   * Test {@link PDFourColours#PDFourColours(COSArray)}.
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.</li>
   *   <li>Then return AfterColour is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFourColours#PDFourColours(COSArray)}
   */
  @Test
  @DisplayName("Test new PDFourColours(COSArray); when COSArray(); then return AfterColour is 'null'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSArray#COSArray()}.</li>
   *   <li>Then return COSArray toList Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFourColours#getBeforeColour()}
   */
  @Test
  @DisplayName("Test getBeforeColour(); given COSArray() add COSArray(); then return COSArray toList Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDGamma PDFourColours.getBeforeColour()"})
  void testGetBeforeColour_givenCOSArrayAddCOSArray_thenReturnCOSArrayToListEmpty() {
    // Arrange
    COSArray array = new COSArray();
    COSArray object = new COSArray();
    array.add((COSBase) object);

    // Act
    PDGamma actualBeforeColour = (new PDFourColours(array)).getBeforeColour();

    // Assert
    COSArray cOSArray = actualBeforeColour.getCOSArray();
    assertTrue(cOSArray.toList().isEmpty());
    assertSame(object, cOSArray);
    assertSame(object, actualBeforeColour.getCOSObject());
  }

  /**
   * Test {@link PDFourColours#getBeforeColour()}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFourColours#getBeforeColour()}
   */
  @Test
  @DisplayName("Test getBeforeColour(); given COSArray() add FALSE; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDGamma PDFourColours.getBeforeColour()"})
  void testGetBeforeColour_givenCOSArrayAddFalse_thenReturnNull() {
    // Arrange
    COSArray array = new COSArray();
    array.add(COSBoolean.FALSE);

    // Act and Assert
    assertNull((new PDFourColours(array)).getBeforeColour());
  }

  /**
   * Test {@link PDFourColours#getBeforeColour()}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFourColours#getBeforeColour()}
   */
  @Test
  @DisplayName("Test getBeforeColour(); given COSObjectKey(long, int) with num is one and gen is one; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDGamma PDFourColours.getBeforeColour()"})
  void testGetBeforeColour_givenCOSObjectKeyWithNumIsOneAndGenIsOne_thenReturnNull() {
    // Arrange
    COSArray array = new COSArray();
    array.add((COSBase) new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Act and Assert
    assertNull((new PDFourColours(array)).getBeforeColour());
  }

  /**
   * Test {@link PDFourColours#getBeforeColour()}.
   * <ul>
   *   <li>Given {@link PDFourColours#PDFourColours()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFourColours#getBeforeColour()}
   */
  @Test
  @DisplayName("Test getBeforeColour(); given PDFourColours(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDGamma PDFourColours.getBeforeColour()"})
  void testGetBeforeColour_givenPDFourColours_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDFourColours()).getBeforeColour());
  }

  /**
   * Test {@link PDFourColours#setBeforeColour(PDGamma)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDFourColours#PDFourColours()} COSObject toList first {@link COSNull}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFourColours#setBeforeColour(PDGamma)}
   */
  @Test
  @DisplayName("Test setBeforeColour(PDGamma); when 'null'; then PDFourColours() COSObject toList first COSNull")
  @Tag("MaintainedByDiffblue")
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
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSNull);
    assertSame(getResult, toListResult.get(1));
    assertSame(getResult, toListResult.get(2));
    assertSame(getResult, toListResult.get(3));
  }

  /**
   * Test {@link PDFourColours#setBeforeColour(PDGamma)}.
   * <ul>
   *   <li>When {@link PDGamma#PDGamma()}.</li>
   *   <li>Then {@link PDFourColours#PDFourColours()} COSObject toList second {@link COSNull}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFourColours#setBeforeColour(PDGamma)}
   */
  @Test
  @DisplayName("Test setBeforeColour(PDGamma); when PDGamma(); then PDFourColours() COSObject toList second COSNull")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFourColours.setBeforeColour(PDGamma)"})
  void testSetBeforeColour_whenPDGamma_thenPDFourColoursCOSObjectToListSecondCOSNull() {
    // Arrange
    PDFourColours pdFourColours = new PDFourColours();

    // Act
    pdFourColours.setBeforeColour(new PDGamma());

    // Assert
    COSBase cOSObject = pdFourColours.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSNull);
    PDGamma beforeColour = pdFourColours.getBeforeColour();
    assertEquals(0.0f, beforeColour.getB());
    assertEquals(0.0f, beforeColour.getG());
    assertEquals(0.0f, beforeColour.getR());
    assertSame(getResult, toListResult.get(2));
    assertSame(getResult, toListResult.get(3));
  }

  /**
   * Test {@link PDFourColours#getAfterColour()}.
   * <p>
   * Method under test: {@link PDFourColours#getAfterColour()}
   */
  @Test
  @DisplayName("Test getAfterColour()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDGamma PDFourColours.getAfterColour()"})
  void testGetAfterColour() {
    // Arrange, Act and Assert
    assertNull((new PDFourColours()).getAfterColour());
  }

  /**
   * Test {@link PDFourColours#setAfterColour(PDGamma)}.
   * <p>
   * Method under test: {@link PDFourColours#setAfterColour(PDGamma)}
   */
  @Test
  @DisplayName("Test setAfterColour(PDGamma)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFourColours.setAfterColour(PDGamma)"})
  void testSetAfterColour() {
    // Arrange
    PDFourColours pdFourColours = new PDFourColours();

    // Act
    pdFourColours.setAfterColour(null);

    // Assert that nothing has changed
    COSBase cOSObject = pdFourColours.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    assertSame(toListResult.get(0), toListResult.get(1));
  }

  /**
   * Test {@link PDFourColours#setAfterColour(PDGamma)}.
   * <ul>
   *   <li>When {@link PDGamma#PDGamma()}.</li>
   *   <li>Then {@link PDFourColours#PDFourColours()} AfterColour B is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFourColours#setAfterColour(PDGamma)}
   */
  @Test
  @DisplayName("Test setAfterColour(PDGamma); when PDGamma(); then PDFourColours() AfterColour B is zero")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link PDFourColours#getStartColour()}
   */
  @Test
  @DisplayName("Test getStartColour()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDGamma PDFourColours.getStartColour()"})
  void testGetStartColour() {
    // Arrange, Act and Assert
    assertNull((new PDFourColours()).getStartColour());
  }

  /**
   * Test {@link PDFourColours#setStartColour(PDGamma)}.
   * <p>
   * Method under test: {@link PDFourColours#setStartColour(PDGamma)}
   */
  @Test
  @DisplayName("Test setStartColour(PDGamma)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFourColours.setStartColour(PDGamma)"})
  void testSetStartColour() {
    // Arrange
    PDFourColours pdFourColours = new PDFourColours();

    // Act
    pdFourColours.setStartColour(null);

    // Assert that nothing has changed
    COSBase cOSObject = pdFourColours.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    assertSame(toListResult.get(0), toListResult.get(2));
  }

  /**
   * Test {@link PDFourColours#setStartColour(PDGamma)}.
   * <ul>
   *   <li>When {@link PDGamma#PDGamma()}.</li>
   *   <li>Then {@link PDFourColours#PDFourColours()} StartColour B is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFourColours#setStartColour(PDGamma)}
   */
  @Test
  @DisplayName("Test setStartColour(PDGamma); when PDGamma(); then PDFourColours() StartColour B is zero")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link PDFourColours#getEndColour()}
   */
  @Test
  @DisplayName("Test getEndColour()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDGamma PDFourColours.getEndColour()"})
  void testGetEndColour() {
    // Arrange, Act and Assert
    assertNull((new PDFourColours()).getEndColour());
  }

  /**
   * Test {@link PDFourColours#setEndColour(PDGamma)}.
   * <p>
   * Method under test: {@link PDFourColours#setEndColour(PDGamma)}
   */
  @Test
  @DisplayName("Test setEndColour(PDGamma)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFourColours.setEndColour(PDGamma)"})
  void testSetEndColour() {
    // Arrange
    PDFourColours pdFourColours = new PDFourColours();

    // Act
    pdFourColours.setEndColour(null);

    // Assert that nothing has changed
    COSBase cOSObject = pdFourColours.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    assertSame(toListResult.get(0), toListResult.get(3));
  }

  /**
   * Test {@link PDFourColours#setEndColour(PDGamma)}.
   * <ul>
   *   <li>When {@link PDGamma#PDGamma()}.</li>
   *   <li>Then {@link PDFourColours#PDFourColours()} EndColour B is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFourColours#setEndColour(PDGamma)}
   */
  @Test
  @DisplayName("Test setEndColour(PDGamma); when PDGamma(); then PDFourColours() EndColour B is zero")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link PDFourColours#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSBase PDFourColours.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange, Act and Assert
    assertTrue((new PDFourColours()).getCOSObject() instanceof COSArray);
  }
}
