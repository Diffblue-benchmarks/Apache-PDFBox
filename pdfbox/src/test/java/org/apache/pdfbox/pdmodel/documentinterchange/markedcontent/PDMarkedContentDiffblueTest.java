package org.apache.pdfbox.pdmodel.documentinterchange.markedcontent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.text.TextPosition;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;

class PDMarkedContentDiffblueTest {
  /**
   * Method under test: {@link PDMarkedContent#create(COSName, COSDictionary)}
   */
  @Test
  void testCreate() {
    // Arrange
    COSDictionary properties = new COSDictionary();

    // Act
    PDMarkedContent actualCreateResult = PDMarkedContent.create(COSName.A, properties);

    // Assert
    assertEquals("A", actualCreateResult.getTag());
    assertNull(actualCreateResult.getActualText());
    assertNull(actualCreateResult.getAlternateDescription());
    assertNull(actualCreateResult.getExpandedForm());
    assertNull(actualCreateResult.getLanguage());
    assertEquals(-1, actualCreateResult.getMCID());
    assertTrue(actualCreateResult.getContents().isEmpty());
    assertSame(properties, actualCreateResult.getProperties());
  }

  /**
   * Method under test: {@link PDMarkedContent#create(COSName, COSDictionary)}
   */
  @Test
  void testCreate2() {
    // Arrange
    COSDictionary properties = new COSDictionary();

    // Act
    PDMarkedContent actualCreateResult = PDMarkedContent.create(null, properties);

    // Assert
    assertNull(actualCreateResult.getActualText());
    assertNull(actualCreateResult.getAlternateDescription());
    assertNull(actualCreateResult.getExpandedForm());
    assertNull(actualCreateResult.getLanguage());
    assertNull(actualCreateResult.getTag());
    assertEquals(-1, actualCreateResult.getMCID());
    assertTrue(actualCreateResult.getContents().isEmpty());
    assertSame(properties, actualCreateResult.getProperties());
  }

  /**
   * Method under test: {@link PDMarkedContent#getMCID()}
   */
  @Test
  void testGetMCID() {
    // Arrange, Act and Assert
    assertEquals(-1, PDMarkedContent.create(COSName.A, new COSDictionary()).getMCID());
    assertEquals(-1, PDMarkedContent.create(COSName.A, null).getMCID());
  }

  /**
   * Method under test: {@link PDMarkedContent#getLanguage()}
   */
  @Test
  void testGetLanguage() {
    // Arrange, Act and Assert
    assertNull(PDMarkedContent.create(COSName.A, new COSDictionary()).getLanguage());
    assertNull(PDMarkedContent.create(COSName.A, null).getLanguage());
  }

  /**
   * Method under test: {@link PDMarkedContent#getActualText()}
   */
  @Test
  void testGetActualText() {
    // Arrange, Act and Assert
    assertNull(PDMarkedContent.create(COSName.A, new COSDictionary()).getActualText());
    assertNull(PDMarkedContent.create(COSName.A, null).getActualText());
  }

  /**
   * Method under test: {@link PDMarkedContent#getAlternateDescription()}
   */
  @Test
  void testGetAlternateDescription() {
    // Arrange, Act and Assert
    assertNull(PDMarkedContent.create(COSName.A, new COSDictionary()).getAlternateDescription());
    assertNull(PDMarkedContent.create(COSName.A, null).getAlternateDescription());
  }

  /**
   * Method under test: {@link PDMarkedContent#getExpandedForm()}
   */
  @Test
  void testGetExpandedForm() {
    // Arrange, Act and Assert
    assertNull(PDMarkedContent.create(COSName.A, new COSDictionary()).getExpandedForm());
    assertNull(PDMarkedContent.create(COSName.A, null).getExpandedForm());
  }

  /**
   * Method under test: {@link PDMarkedContent#addText(TextPosition)}
   */
  @Test
  void testAddText() throws IOException {
    // Arrange
    PDMarkedContent createResult = PDMarkedContent.create(COSName.A, new COSDictionary());
    Matrix textMatrix = new Matrix();
    TextPosition text = new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, "Unicode",
        new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3);

    // Act
    createResult.addText(text);

    // Assert
    List<Object> contents = createResult.getContents();
    assertEquals(1, contents.size());
    assertSame(text, contents.get(0));
  }

  /**
   * Method under test: {@link PDMarkedContent#addMarkedContent(PDMarkedContent)}
   */
  @Test
  void testAddMarkedContent() {
    // Arrange
    PDMarkedContent createResult = PDMarkedContent.create(COSName.A, mock(COSDictionary.class));
    PDMarkedContent markedContent = PDMarkedContent.create(COSName.A, new COSDictionary());

    // Act
    createResult.addMarkedContent(markedContent);

    // Assert
    List<Object> contents = createResult.getContents();
    assertEquals(1, contents.size());
    assertSame(markedContent, contents.get(0));
  }

  /**
   * Method under test: {@link PDMarkedContent#addXObject(PDXObject)}
   */
  @Test
  void testAddXObject() {
    // Arrange
    PDMarkedContent createResult = PDMarkedContent.create(COSName.A, new COSDictionary());
    PDXObject xobject = mock(PDXObject.class);

    // Act
    createResult.addXObject(xobject);

    // Assert
    List<Object> contents = createResult.getContents();
    assertEquals(1, contents.size());
    assertSame(xobject, contents.get(0));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDMarkedContent#toString()}
   *   <li>{@link PDMarkedContent#getContents()}
   *   <li>{@link PDMarkedContent#getProperties()}
   *   <li>{@link PDMarkedContent#getTag()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    COSDictionary properties = new COSDictionary();
    PDMarkedContent createResult = PDMarkedContent.create(COSName.A, properties);

    // Act
    String actualToStringResult = createResult.toString();
    List<Object> actualContents = createResult.getContents();
    COSDictionary actualProperties = createResult.getProperties();

    // Assert
    assertEquals("A", createResult.getTag());
    assertEquals("tag=A, properties=COSDictionary{}, contents=[]", actualToStringResult);
    assertTrue(actualContents.isEmpty());
    assertSame(properties, actualProperties);
  }

  /**
   * Method under test:
   * {@link PDMarkedContent#PDMarkedContent(COSName, COSDictionary)}
   */
  @Test
  void testNewPDMarkedContent() {
    // Arrange
    COSDictionary properties = new COSDictionary();

    // Act
    PDMarkedContent actualPdMarkedContent = new PDMarkedContent(COSName.A, properties);

    // Assert
    assertEquals("A", actualPdMarkedContent.getTag());
    assertNull(actualPdMarkedContent.getActualText());
    assertNull(actualPdMarkedContent.getAlternateDescription());
    assertNull(actualPdMarkedContent.getExpandedForm());
    assertNull(actualPdMarkedContent.getLanguage());
    assertEquals(-1, actualPdMarkedContent.getMCID());
    assertTrue(actualPdMarkedContent.getContents().isEmpty());
    assertSame(properties, actualPdMarkedContent.getProperties());
  }

  /**
   * Method under test:
   * {@link PDMarkedContent#PDMarkedContent(COSName, COSDictionary)}
   */
  @Test
  void testNewPDMarkedContent2() {
    // Arrange
    COSDictionary properties = new COSDictionary();

    // Act
    PDMarkedContent actualPdMarkedContent = new PDMarkedContent(null, properties);

    // Assert
    assertNull(actualPdMarkedContent.getActualText());
    assertNull(actualPdMarkedContent.getAlternateDescription());
    assertNull(actualPdMarkedContent.getExpandedForm());
    assertNull(actualPdMarkedContent.getLanguage());
    assertNull(actualPdMarkedContent.getTag());
    assertEquals(-1, actualPdMarkedContent.getMCID());
    assertTrue(actualPdMarkedContent.getContents().isEmpty());
    assertSame(properties, actualPdMarkedContent.getProperties());
  }
}
