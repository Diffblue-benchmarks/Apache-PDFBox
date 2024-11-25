package org.apache.pdfbox.pdmodel.interactive.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDActionMovieDiffblueTest {
  /**
   * Test {@link PDActionMovie#PDActionMovie(COSDictionary)}.
   * <p>
   * Method under test: {@link PDActionMovie#PDActionMovie(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDActionMovie(COSDictionary)")
  void testNewPDActionMovie() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new PDActionMovie(a)).getCOSObject());
  }

  /**
   * Test {@link PDActionMovie#PDActionMovie()}.
   * <p>
   * Method under test: {@link PDActionMovie#PDActionMovie()}
   */
  @Test
  @DisplayName("Test new PDActionMovie()")
  void testNewPDActionMovie2() {
    // Arrange and Act
    PDActionMovie actualPdActionMovie = new PDActionMovie();

    // Assert
    assertNull(actualPdActionMovie.getNext());
    COSDictionary cOSObject = actualPdActionMovie.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPdActionMovie.getType());
    assertEquals(PDActionMovie.SUB_TYPE, actualPdActionMovie.getSubType());
  }
}
