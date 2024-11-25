package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDDeviceNProcessDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDDeviceNProcess#PDDeviceNProcess(COSDictionary)}
   *   <li>{@link PDDeviceNProcess#getCOSDictionary()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    COSDictionary attributes = new COSDictionary();

    // Act and Assert
    assertSame(attributes, (new PDDeviceNProcess(attributes)).getCOSDictionary());
  }

  /**
   * Test {@link PDDeviceNProcess#PDDeviceNProcess()}.
   * <p>
   * Method under test: {@link PDDeviceNProcess#PDDeviceNProcess()}
   */
  @Test
  @DisplayName("Test new PDDeviceNProcess()")
  void testNewPDDeviceNProcess() throws IOException {
    // Arrange and Act
    PDDeviceNProcess actualPdDeviceNProcess = new PDDeviceNProcess();

    // Assert
    COSDictionary cOSDictionary = actualPdDeviceNProcess.getCOSDictionary();
    COSUpdateState updateState = cOSDictionary.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSDictionary.getKey());
    assertNull(actualPdDeviceNProcess.getColorSpace());
    assertEquals(0, cOSDictionary.size());
    COSIncrement toIncrementResult = cOSDictionary.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSDictionary.isDirect());
    assertFalse(cOSDictionary.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSDictionary.getValues().isEmpty());
    assertTrue(actualPdDeviceNProcess.getComponents().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDDeviceNProcess#getColorSpace()}.
   * <ul>
   *   <li>Given {@link PDDeviceNProcess#PDDeviceNProcess(COSDictionary)} with
   * attributes is {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDeviceNProcess#getColorSpace()}
   */
  @Test
  @DisplayName("Test getColorSpace(); given PDDeviceNProcess(COSDictionary) with attributes is COSStream(); then return 'null'")
  void testGetColorSpace_givenPDDeviceNProcessWithAttributesIsCOSStream_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDDeviceNProcess(new COSStream())).getColorSpace());
  }

  /**
   * Test {@link PDDeviceNProcess#getColorSpace()}.
   * <ul>
   *   <li>Given {@link PDDeviceNProcess#PDDeviceNProcess()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDeviceNProcess#getColorSpace()}
   */
  @Test
  @DisplayName("Test getColorSpace(); given PDDeviceNProcess(); then return 'null'")
  void testGetColorSpace_givenPDDeviceNProcess_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDDeviceNProcess()).getColorSpace());
  }

  /**
   * Test {@link PDDeviceNProcess#getComponents()}.
   * <ul>
   *   <li>Given {@link PDDeviceNProcess#PDDeviceNProcess(COSDictionary)} with
   * attributes is {@link COSStream#COSStream()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDeviceNProcess#getComponents()}
   */
  @Test
  @DisplayName("Test getComponents(); given PDDeviceNProcess(COSDictionary) with attributes is COSStream(); then return Empty")
  void testGetComponents_givenPDDeviceNProcessWithAttributesIsCOSStream_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new PDDeviceNProcess(new COSStream())).getComponents().isEmpty());
  }

  /**
   * Test {@link PDDeviceNProcess#getComponents()}.
   * <ul>
   *   <li>Given {@link PDDeviceNProcess#PDDeviceNProcess()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDeviceNProcess#getComponents()}
   */
  @Test
  @DisplayName("Test getComponents(); given PDDeviceNProcess(); then return Empty")
  void testGetComponents_givenPDDeviceNProcess_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new PDDeviceNProcess()).getComponents().isEmpty());
  }

  /**
   * Test {@link PDDeviceNProcess#toString()}.
   * <ul>
   *   <li>Given {@link PDDeviceNProcess#PDDeviceNProcess(COSDictionary)} with
   * attributes is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDeviceNProcess#toString()}
   */
  @Test
  @DisplayName("Test toString(); given PDDeviceNProcess(COSDictionary) with attributes is COSStream()")
  void testToString_givenPDDeviceNProcessWithAttributesIsCOSStream() {
    // Arrange, Act and Assert
    assertEquals("Process{null}", (new PDDeviceNProcess(new COSStream())).toString());
  }

  /**
   * Test {@link PDDeviceNProcess#toString()}.
   * <ul>
   *   <li>Given {@link PDDeviceNProcess#PDDeviceNProcess()}.</li>
   *   <li>Then return {@code Process{null}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDeviceNProcess#toString()}
   */
  @Test
  @DisplayName("Test toString(); given PDDeviceNProcess(); then return 'Process{null}'")
  void testToString_givenPDDeviceNProcess_thenReturnProcessNull() {
    // Arrange, Act and Assert
    assertEquals("Process{null}", (new PDDeviceNProcess()).toString());
  }
}
