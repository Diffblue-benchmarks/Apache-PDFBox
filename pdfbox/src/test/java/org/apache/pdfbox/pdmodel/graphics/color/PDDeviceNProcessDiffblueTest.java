package org.apache.pdfbox.pdmodel.graphics.color;

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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDDeviceNProcessDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDDeviceNProcess#PDDeviceNProcess(COSDictionary)}
   *   <li>{@link PDDeviceNProcess#getCOSDictionary()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDDeviceNProcess.<init>(COSDictionary)",
    "COSDictionary PDDeviceNProcess.getCOSDictionary()"
  })
  void testGettersAndSetters() {
    // Arrange
    COSDictionary attributes = new COSDictionary();

    // Act and Assert
    assertSame(attributes, new PDDeviceNProcess(attributes).getCOSDictionary());
  }

  /**
   * Test {@link PDDeviceNProcess#PDDeviceNProcess()}.
   *
   * <p>Method under test: {@link PDDeviceNProcess#PDDeviceNProcess()}
   */
  @Test
  @DisplayName("Test new PDDeviceNProcess()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDeviceNProcess.<init>()"})
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
   *
   * <ul>
   *   <li>Given {@link PDDeviceNProcess#PDDeviceNProcess()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDDeviceNProcess#getColorSpace()}
   */
  @Test
  @DisplayName("Test getColorSpace(); given PDDeviceNProcess(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace PDDeviceNProcess.getColorSpace()"
  })
  void testGetColorSpace_givenPDDeviceNProcess_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDDeviceNProcess().getColorSpace());
  }

  /**
   * Test {@link PDDeviceNProcess#getComponents()}.
   *
   * <ul>
   *   <li>Given {@link PDDeviceNProcess#PDDeviceNProcess()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDDeviceNProcess#getComponents()}
   */
  @Test
  @DisplayName("Test getComponents(); given PDDeviceNProcess(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List PDDeviceNProcess.getComponents()"})
  void testGetComponents_givenPDDeviceNProcess_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new PDDeviceNProcess().getComponents().isEmpty());
  }

  /**
   * Test {@link PDDeviceNProcess#toString()}.
   *
   * <ul>
   *   <li>Given {@link PDDeviceNProcess#PDDeviceNProcess()}.
   *   <li>Then return {@code Process{null}}.
   * </ul>
   *
   * <p>Method under test: {@link PDDeviceNProcess#toString()}
   */
  @Test
  @DisplayName("Test toString(); given PDDeviceNProcess(); then return 'Process{null}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDDeviceNProcess.toString()"})
  void testToString_givenPDDeviceNProcess_thenReturnProcessNull() {
    // Arrange, Act and Assert
    assertEquals("Process{null}", new PDDeviceNProcess().toString());
  }
}
