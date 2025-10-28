package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.Test;

class PDDeviceNProcessDiffblueTest {
  /**
   * Method under test: {@link PDDeviceNProcess#getColorSpace()}
   */
  @Test
  void testGetColorSpace() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDDeviceNProcess()).getColorSpace());
  }

  /**
   * Method under test: {@link PDDeviceNProcess#getComponents()}
   */
  @Test
  void testGetComponents() {
    // Arrange, Act and Assert
    assertTrue((new PDDeviceNProcess()).getComponents().isEmpty());
  }

  /**
   * Method under test: {@link PDDeviceNProcess#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("Process{null}", (new PDDeviceNProcess()).toString());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDDeviceNProcess#PDDeviceNProcess(COSDictionary)}
   *   <li>{@link PDDeviceNProcess#getCOSDictionary()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    COSDictionary attributes = new COSDictionary();

    // Act and Assert
    assertSame(attributes, (new PDDeviceNProcess(attributes)).getCOSDictionary());
  }

  /**
   * Method under test: {@link PDDeviceNProcess#PDDeviceNProcess()}
   */
  @Test
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
}
