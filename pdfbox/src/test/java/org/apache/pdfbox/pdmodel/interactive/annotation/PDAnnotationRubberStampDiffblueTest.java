package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.Test;

class PDAnnotationRubberStampDiffblueTest {
  /**
   * Method under test: {@link PDAnnotationRubberStamp#setName(String)}
   */
  @Test
  void testSetName() {
    // Arrange
    PDAnnotationRubberStamp pdAnnotationRubberStamp = new PDAnnotationRubberStamp();

    // Act
    pdAnnotationRubberStamp.setName("Name");

    // Assert
    assertEquals("Name", pdAnnotationRubberStamp.getName());
    COSDictionary cOSObject = pdAnnotationRubberStamp.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotationRubberStamp#setName(String)}
   */
  @Test
  void testSetName2() {
    // Arrange
    PDAnnotationRubberStamp pdAnnotationRubberStamp = new PDAnnotationRubberStamp();

    // Act
    pdAnnotationRubberStamp.setName("42");

    // Assert
    assertEquals("42", pdAnnotationRubberStamp.getName());
    COSDictionary cOSObject = pdAnnotationRubberStamp.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotationRubberStamp#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals(PDAnnotationRubberStamp.NAME_DRAFT, (new PDAnnotationRubberStamp()).getName());
  }
}
