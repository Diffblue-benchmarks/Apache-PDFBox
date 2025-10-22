package org.apache.pdfbox.pdmodel.common;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.Map;
import java.util.NavigableSet;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDPageLabelsDiffblueTest {
  /**
   * Test {@link PDPageLabels#PDPageLabels(PDDocument)}.
   * <p>
   * Method under test: {@link PDPageLabels#PDPageLabels(PDDocument)}
   */
  @Test
  @DisplayName("Test new PDPageLabels(PDDocument)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPageLabels.<init>(PDDocument)"})
  void testNewPDPageLabels() {
    // Arrange and Act
    PDPageLabels actualPdPageLabels = new PDPageLabels(new PDDocument());

    // Assert
    COSBase cOSObject = actualPdPageLabels.getCOSObject();
    assertTrue(cOSObject instanceof COSDictionary);
    assertNull(cOSObject.getKey());
    assertEquals(0, actualPdPageLabels.getLabelsByPageIndices().length);
    assertEquals(1, ((COSDictionary) cOSObject).getValues().size());
    NavigableSet<Integer> pageIndices = actualPdPageLabels.getPageIndices();
    assertEquals(1, pageIndices.size());
    assertEquals(1, ((COSDictionary) cOSObject).size());
    assertEquals(1, actualPdPageLabels.getPageRangeCount());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSDictionary) cOSObject).isNeedToBeUpdated());
    assertTrue(actualPdPageLabels.getPageIndicesByLabels().isEmpty());
    assertTrue(pageIndices.contains(0));
  }

  /**
   * Test {@link PDPageLabels#PDPageLabels(PDDocument, COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageLabels#PDPageLabels(PDDocument, COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDPageLabels(PDDocument, COSDictionary); when COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPageLabels.<init>(PDDocument, COSDictionary)"})
  void testNewPDPageLabels_whenCOSDictionary() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    PDPageLabels actualPdPageLabels = new PDPageLabels(document, new COSDictionary());

    // Assert
    COSBase cOSObject = actualPdPageLabels.getCOSObject();
    assertTrue(cOSObject instanceof COSDictionary);
    assertNull(cOSObject.getKey());
    assertEquals(0, actualPdPageLabels.getLabelsByPageIndices().length);
    assertEquals(1, ((COSDictionary) cOSObject).getValues().size());
    NavigableSet<Integer> pageIndices = actualPdPageLabels.getPageIndices();
    assertEquals(1, pageIndices.size());
    assertEquals(1, ((COSDictionary) cOSObject).size());
    assertEquals(1, actualPdPageLabels.getPageRangeCount());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSDictionary) cOSObject).isNeedToBeUpdated());
    assertTrue(actualPdPageLabels.getPageIndicesByLabels().isEmpty());
    assertTrue(pageIndices.contains(0));
  }

  /**
   * Test {@link PDPageLabels#PDPageLabels(PDDocument, COSDictionary)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageLabels#PDPageLabels(PDDocument, COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDPageLabels(PDDocument, COSDictionary); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPageLabels.<init>(PDDocument, COSDictionary)"})
  void testNewPDPageLabels_whenNull() throws IOException {
    // Arrange and Act
    PDPageLabels actualPdPageLabels = new PDPageLabels(new PDDocument(), null);

    // Assert
    COSBase cOSObject = actualPdPageLabels.getCOSObject();
    assertTrue(cOSObject instanceof COSDictionary);
    assertNull(cOSObject.getKey());
    assertEquals(0, actualPdPageLabels.getLabelsByPageIndices().length);
    assertEquals(1, ((COSDictionary) cOSObject).getValues().size());
    NavigableSet<Integer> pageIndices = actualPdPageLabels.getPageIndices();
    assertEquals(1, pageIndices.size());
    assertEquals(1, ((COSDictionary) cOSObject).size());
    assertEquals(1, actualPdPageLabels.getPageRangeCount());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSDictionary) cOSObject).isNeedToBeUpdated());
    assertTrue(actualPdPageLabels.getPageIndicesByLabels().isEmpty());
    assertTrue(pageIndices.contains(0));
  }

  /**
   * Test {@link PDPageLabels#getPageRangeCount()}.
   * <p>
   * Method under test: {@link PDPageLabels#getPageRangeCount()}
   */
  @Test
  @DisplayName("Test getPageRangeCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDPageLabels.getPageRangeCount()"})
  void testGetPageRangeCount() {
    // Arrange, Act and Assert
    assertEquals(1, (new PDPageLabels(new PDDocument())).getPageRangeCount());
  }

  /**
   * Test {@link PDPageLabels#getPageLabelRange(int)}.
   * <p>
   * Method under test: {@link PDPageLabels#getPageLabelRange(int)}
   */
  @Test
  @DisplayName("Test getPageLabelRange(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPageLabelRange PDPageLabels.getPageLabelRange(int)"})
  void testGetPageLabelRange() {
    // Arrange, Act and Assert
    assertNull((new PDPageLabels(new PDDocument())).getPageLabelRange(1));
  }

  /**
   * Test {@link PDPageLabels#setLabelItem(int, PDPageLabelRange)}.
   * <p>
   * Method under test: {@link PDPageLabels#setLabelItem(int, PDPageLabelRange)}
   */
  @Test
  @DisplayName("Test setLabelItem(int, PDPageLabelRange)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPageLabels.setLabelItem(int, PDPageLabelRange)"})
  void testSetLabelItem() {
    // Arrange
    PDPageLabels pdPageLabels = new PDPageLabels(new PDDocument());

    // Act
    pdPageLabels.setLabelItem(1, new PDPageLabelRange());

    // Assert
    Map<String, Integer> pageIndicesByLabels = pdPageLabels.getPageIndicesByLabels();
    assertEquals(1, pageIndicesByLabels.size());
    assertEquals(0, pageIndicesByLabels.get("1").intValue());
    NavigableSet<Integer> pageIndices = pdPageLabels.getPageIndices();
    assertEquals(2, pageIndices.size());
    assertEquals(2, pdPageLabels.getPageRangeCount());
    assertTrue(pageIndices.contains(1));
  }

  /**
   * Test {@link PDPageLabels#setLabelItem(int, PDPageLabelRange)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageLabels#setLabelItem(int, PDPageLabelRange)}
   */
  @Test
  @DisplayName("Test setLabelItem(int, PDPageLabelRange); when minus one; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPageLabels.setLabelItem(int, PDPageLabelRange)"})
  void testSetLabelItem_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange
    PDPageLabels pdPageLabels = new PDPageLabels(new PDDocument());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPageLabels.setLabelItem(-1, new PDPageLabelRange()));
  }

  /**
   * Test {@link PDPageLabels#getCOSObject()}.
   * <p>
   * Method under test: {@link PDPageLabels#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSBase PDPageLabels.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSBase actualCOSObject = (new PDPageLabels(new PDDocument())).getCOSObject();

    // Assert
    assertTrue(actualCOSObject instanceof COSDictionary);
    COSUpdateState updateState = ((COSDictionary) actualCOSObject).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(1, ((COSDictionary) actualCOSObject).getValues().size());
    assertEquals(1, ((COSDictionary) actualCOSObject).size());
    COSIncrement toIncrementResult = ((COSDictionary) actualCOSObject).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(((COSDictionary) actualCOSObject).isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDPageLabels#getPageIndicesByLabels()}.
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()} addPage {@link PDPage#PDPage()}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageLabels#getPageIndicesByLabels()}
   */
  @Test
  @DisplayName("Test getPageIndicesByLabels(); given PDDocument() addPage PDPage(); then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map PDPageLabels.getPageIndicesByLabels()"})
  void testGetPageIndicesByLabels_givenPDDocumentAddPagePDPage_thenReturnSizeIsOne() {
    // Arrange
    PDDocument document = new PDDocument();
    document.addPage(new PDPage());

    // Act
    Map<String, Integer> actualPageIndicesByLabels = (new PDPageLabels(document)).getPageIndicesByLabels();

    // Assert
    assertEquals(1, actualPageIndicesByLabels.size());
    assertEquals(0, actualPageIndicesByLabels.get("1").intValue());
  }

  /**
   * Test {@link PDPageLabels#getPageIndicesByLabels()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageLabels#getPageIndicesByLabels()}
   */
  @Test
  @DisplayName("Test getPageIndicesByLabels(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map PDPageLabels.getPageIndicesByLabels()"})
  void testGetPageIndicesByLabels_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new PDPageLabels(new PDDocument())).getPageIndicesByLabels().isEmpty());
  }

  /**
   * Test {@link PDPageLabels#getLabelsByPageIndices()}.
   * <ul>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageLabels#getLabelsByPageIndices()}
   */
  @Test
  @DisplayName("Test getLabelsByPageIndices(); then return array length is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String[] PDPageLabels.getLabelsByPageIndices()"})
  void testGetLabelsByPageIndices_thenReturnArrayLengthIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDPageLabels(new PDDocument())).getLabelsByPageIndices().length);
  }

  /**
   * Test {@link PDPageLabels#getLabelsByPageIndices()}.
   * <ul>
   *   <li>Then return array of {@link String} with {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageLabels#getLabelsByPageIndices()}
   */
  @Test
  @DisplayName("Test getLabelsByPageIndices(); then return array of String with '1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String[] PDPageLabels.getLabelsByPageIndices()"})
  void testGetLabelsByPageIndices_thenReturnArrayOfStringWith1() {
    // Arrange
    PDDocument document = new PDDocument();
    document.addPage(new PDPage());

    // Act and Assert
    assertArrayEquals(new String[]{"1"}, (new PDPageLabels(document)).getLabelsByPageIndices());
  }

  /**
   * Test {@link PDPageLabels#getPageIndices()}.
   * <p>
   * Method under test: {@link PDPageLabels#getPageIndices()}
   */
  @Test
  @DisplayName("Test getPageIndices()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"NavigableSet PDPageLabels.getPageIndices()"})
  void testGetPageIndices() {
    // Arrange and Act
    NavigableSet<Integer> actualPageIndices = (new PDPageLabels(new PDDocument())).getPageIndices();

    // Assert
    assertEquals(1, actualPageIndices.size());
    assertTrue(actualPageIndices.contains(0));
  }
}
