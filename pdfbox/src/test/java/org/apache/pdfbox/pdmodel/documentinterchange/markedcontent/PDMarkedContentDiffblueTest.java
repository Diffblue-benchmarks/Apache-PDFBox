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
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.text.TextPosition;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDMarkedContentDiffblueTest {
  /**
   * Test {@link PDMarkedContent#create(COSName, COSDictionary)}.
   * <ul>
   *   <li>When {@link COSName#A}.</li>
   *   <li>Then return Tag is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMarkedContent#create(COSName, COSDictionary)}
   */
  @Test
  @DisplayName("Test create(COSName, COSDictionary); when A; then return Tag is 'A'")
  void testCreate_whenA_thenReturnTagIsA() {
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
   * Test {@link PDMarkedContent#create(COSName, COSDictionary)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Tag is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMarkedContent#create(COSName, COSDictionary)}
   */
  @Test
  @DisplayName("Test create(COSName, COSDictionary); when 'null'; then return Tag is 'null'")
  void testCreate_whenNull_thenReturnTagIsNull() {
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
   * Test {@link PDMarkedContent#PDMarkedContent(COSName, COSDictionary)}.
   * <ul>
   *   <li>When {@link COSName#A}.</li>
   *   <li>Then return Tag is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDMarkedContent#PDMarkedContent(COSName, COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDMarkedContent(COSName, COSDictionary); when A; then return Tag is 'A'")
  void testNewPDMarkedContent_whenA_thenReturnTagIsA() {
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
   * Test {@link PDMarkedContent#PDMarkedContent(COSName, COSDictionary)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Tag is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDMarkedContent#PDMarkedContent(COSName, COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDMarkedContent(COSName, COSDictionary); when 'null'; then return Tag is 'null'")
  void testNewPDMarkedContent_whenNull_thenReturnTagIsNull() {
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

  /**
   * Test {@link PDMarkedContent#getMCID()}.
   * <ul>
   *   <li>Given create {@link COSName#A} and
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMarkedContent#getMCID()}
   */
  @Test
  @DisplayName("Test getMCID(); given create A and COSDictionary()")
  void testGetMCID_givenCreateAAndCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(-1, PDMarkedContent.create(COSName.A, new COSDictionary()).getMCID());
  }

  /**
   * Test {@link PDMarkedContent#getMCID()}.
   * <ul>
   *   <li>Given create {@link COSName#A} and {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMarkedContent#getMCID()}
   */
  @Test
  @DisplayName("Test getMCID(); given create A and COSStream()")
  void testGetMCID_givenCreateAAndCOSStream() {
    // Arrange, Act and Assert
    assertEquals(-1, PDMarkedContent.create(COSName.A, new COSStream()).getMCID());
  }

  /**
   * Test {@link PDMarkedContent#getMCID()}.
   * <ul>
   *   <li>Given create {@link COSName#A} and {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMarkedContent#getMCID()}
   */
  @Test
  @DisplayName("Test getMCID(); given create A and 'null'")
  void testGetMCID_givenCreateAAndNull() {
    // Arrange, Act and Assert
    assertEquals(-1, PDMarkedContent.create(COSName.A, null).getMCID());
  }

  /**
   * Test {@link PDMarkedContent#getLanguage()}.
   * <ul>
   *   <li>Given create {@link COSName#A} and
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMarkedContent#getLanguage()}
   */
  @Test
  @DisplayName("Test getLanguage(); given create A and COSDictionary()")
  void testGetLanguage_givenCreateAAndCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(PDMarkedContent.create(COSName.A, new COSDictionary()).getLanguage());
  }

  /**
   * Test {@link PDMarkedContent#getLanguage()}.
   * <ul>
   *   <li>Given create {@link COSName#A} and {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMarkedContent#getLanguage()}
   */
  @Test
  @DisplayName("Test getLanguage(); given create A and COSStream()")
  void testGetLanguage_givenCreateAAndCOSStream() {
    // Arrange, Act and Assert
    assertNull(PDMarkedContent.create(COSName.A, new COSStream()).getLanguage());
  }

  /**
   * Test {@link PDMarkedContent#getLanguage()}.
   * <ul>
   *   <li>Given create {@link COSName#A} and {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMarkedContent#getLanguage()}
   */
  @Test
  @DisplayName("Test getLanguage(); given create A and 'null'")
  void testGetLanguage_givenCreateAAndNull() {
    // Arrange, Act and Assert
    assertNull(PDMarkedContent.create(COSName.A, null).getLanguage());
  }

  /**
   * Test {@link PDMarkedContent#getActualText()}.
   * <ul>
   *   <li>Given create {@link COSName#A} and
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMarkedContent#getActualText()}
   */
  @Test
  @DisplayName("Test getActualText(); given create A and COSDictionary()")
  void testGetActualText_givenCreateAAndCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(PDMarkedContent.create(COSName.A, new COSDictionary()).getActualText());
  }

  /**
   * Test {@link PDMarkedContent#getActualText()}.
   * <ul>
   *   <li>Given create {@link COSName#A} and {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMarkedContent#getActualText()}
   */
  @Test
  @DisplayName("Test getActualText(); given create A and COSStream()")
  void testGetActualText_givenCreateAAndCOSStream() {
    // Arrange, Act and Assert
    assertNull(PDMarkedContent.create(COSName.A, new COSStream()).getActualText());
  }

  /**
   * Test {@link PDMarkedContent#getActualText()}.
   * <ul>
   *   <li>Given create {@link COSName#A} and {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMarkedContent#getActualText()}
   */
  @Test
  @DisplayName("Test getActualText(); given create A and 'null'")
  void testGetActualText_givenCreateAAndNull() {
    // Arrange, Act and Assert
    assertNull(PDMarkedContent.create(COSName.A, null).getActualText());
  }

  /**
   * Test {@link PDMarkedContent#getAlternateDescription()}.
   * <ul>
   *   <li>Given create {@link COSName#A} and
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMarkedContent#getAlternateDescription()}
   */
  @Test
  @DisplayName("Test getAlternateDescription(); given create A and COSDictionary()")
  void testGetAlternateDescription_givenCreateAAndCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(PDMarkedContent.create(COSName.A, new COSDictionary()).getAlternateDescription());
  }

  /**
   * Test {@link PDMarkedContent#getAlternateDescription()}.
   * <ul>
   *   <li>Given create {@link COSName#A} and {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMarkedContent#getAlternateDescription()}
   */
  @Test
  @DisplayName("Test getAlternateDescription(); given create A and COSStream()")
  void testGetAlternateDescription_givenCreateAAndCOSStream() {
    // Arrange, Act and Assert
    assertNull(PDMarkedContent.create(COSName.A, new COSStream()).getAlternateDescription());
  }

  /**
   * Test {@link PDMarkedContent#getAlternateDescription()}.
   * <ul>
   *   <li>Given create {@link COSName#A} and {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMarkedContent#getAlternateDescription()}
   */
  @Test
  @DisplayName("Test getAlternateDescription(); given create A and 'null'")
  void testGetAlternateDescription_givenCreateAAndNull() {
    // Arrange, Act and Assert
    assertNull(PDMarkedContent.create(COSName.A, null).getAlternateDescription());
  }

  /**
   * Test {@link PDMarkedContent#getExpandedForm()}.
   * <ul>
   *   <li>Given create {@link COSName#A} and
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMarkedContent#getExpandedForm()}
   */
  @Test
  @DisplayName("Test getExpandedForm(); given create A and COSDictionary()")
  void testGetExpandedForm_givenCreateAAndCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(PDMarkedContent.create(COSName.A, new COSDictionary()).getExpandedForm());
  }

  /**
   * Test {@link PDMarkedContent#getExpandedForm()}.
   * <ul>
   *   <li>Given create {@link COSName#A} and {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMarkedContent#getExpandedForm()}
   */
  @Test
  @DisplayName("Test getExpandedForm(); given create A and COSStream()")
  void testGetExpandedForm_givenCreateAAndCOSStream() {
    // Arrange, Act and Assert
    assertNull(PDMarkedContent.create(COSName.A, new COSStream()).getExpandedForm());
  }

  /**
   * Test {@link PDMarkedContent#getExpandedForm()}.
   * <ul>
   *   <li>Given create {@link COSName#A} and {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMarkedContent#getExpandedForm()}
   */
  @Test
  @DisplayName("Test getExpandedForm(); given create A and 'null'")
  void testGetExpandedForm_givenCreateAAndNull() {
    // Arrange, Act and Assert
    assertNull(PDMarkedContent.create(COSName.A, null).getExpandedForm());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDMarkedContent#toString()}
   *   <li>{@link PDMarkedContent#getContents()}
   *   <li>{@link PDMarkedContent#getProperties()}
   *   <li>{@link PDMarkedContent#getTag()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
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
   * Test {@link PDMarkedContent#addText(TextPosition)}.
   * <p>
   * Method under test: {@link PDMarkedContent#addText(TextPosition)}
   */
  @Test
  @DisplayName("Test addText(TextPosition)")
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
   * Test {@link PDMarkedContent#addXObject(PDXObject)}.
   * <p>
   * Method under test: {@link PDMarkedContent#addXObject(PDXObject)}
   */
  @Test
  @DisplayName("Test addXObject(PDXObject)")
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
}
