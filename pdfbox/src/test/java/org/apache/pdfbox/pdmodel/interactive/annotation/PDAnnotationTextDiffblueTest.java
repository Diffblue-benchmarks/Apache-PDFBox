package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDAnnotationTextDiffblueTest {
  /**
   * Test {@link PDAnnotationText#PDAnnotationText()}.
   * <p>
   * Method under test: {@link PDAnnotationText#PDAnnotationText()}
   */
  @Test
  @DisplayName("Test new PDAnnotationText()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationText.<init>()"})
  void testNewPDAnnotationText() throws IOException {
    // Arrange and Act
    PDAnnotationText actualPdAnnotationText = new PDAnnotationText();

    // Assert
    assertNull(actualPdAnnotationText.getAnnotationName());
    assertNull(actualPdAnnotationText.getContents());
    assertNull(actualPdAnnotationText.getModifiedDate());
    assertNull(actualPdAnnotationText.getIntent());
    assertNull(actualPdAnnotationText.getRichContents());
    assertNull(actualPdAnnotationText.getSubject());
    assertNull(actualPdAnnotationText.getTitlePopup());
    assertNull(actualPdAnnotationText.getState());
    assertNull(actualPdAnnotationText.getStateModel());
    assertNull(actualPdAnnotationText.getCreationDate());
    assertNull(actualPdAnnotationText.getAppearanceState());
    assertNull(actualPdAnnotationText.getPage());
    assertNull(actualPdAnnotationText.getRectangle());
    assertNull(actualPdAnnotationText.getOptionalContent());
    assertNull(actualPdAnnotationText.getColor());
    assertNull(actualPdAnnotationText.getInReplyTo());
    assertNull(actualPdAnnotationText.getPopup());
    assertNull(actualPdAnnotationText.getAppearance());
    assertNull(actualPdAnnotationText.getNormalAppearanceStream());
    assertNull(actualPdAnnotationText.getBorderStyle());
    assertNull(actualPdAnnotationText.getExternalData());
    assertEquals(-1, actualPdAnnotationText.getStructParent());
    assertEquals(0, actualPdAnnotationText.getAnnotationFlags());
    assertEquals(1.0f, actualPdAnnotationText.getConstantOpacity());
    assertFalse(actualPdAnnotationText.isHidden());
    assertFalse(actualPdAnnotationText.isInvisible());
    assertFalse(actualPdAnnotationText.isLocked());
    assertFalse(actualPdAnnotationText.isLockedContents());
    assertFalse(actualPdAnnotationText.isNoRotate());
    assertFalse(actualPdAnnotationText.isNoView());
    assertFalse(actualPdAnnotationText.isNoZoom());
    assertFalse(actualPdAnnotationText.isPrinted());
    assertFalse(actualPdAnnotationText.isReadOnly());
    assertFalse(actualPdAnnotationText.isToggleNoView());
    assertFalse(actualPdAnnotationText.getOpen());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationText.getReplyType());
    assertEquals(PDAnnotationText.NAME_NOTE, actualPdAnnotationText.getName());
    assertEquals(PDAnnotationText.SUB_TYPE, actualPdAnnotationText.getSubtype());
  }

  /**
   * Test {@link PDAnnotationText#PDAnnotationText(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return AnnotationName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationText#PDAnnotationText(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAnnotationText(COSDictionary); when COSDictionary(); then return AnnotationName is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationText.<init>(COSDictionary)"})
  void testNewPDAnnotationText_whenCOSDictionary_thenReturnAnnotationNameIsNull() throws IOException {
    // Arrange
    COSDictionary field = new COSDictionary();

    // Act
    PDAnnotationText actualPdAnnotationText = new PDAnnotationText(field);

    // Assert
    assertNull(actualPdAnnotationText.getAnnotationName());
    assertNull(actualPdAnnotationText.getContents());
    assertNull(actualPdAnnotationText.getModifiedDate());
    assertNull(actualPdAnnotationText.getSubtype());
    assertNull(actualPdAnnotationText.getIntent());
    assertNull(actualPdAnnotationText.getRichContents());
    assertNull(actualPdAnnotationText.getSubject());
    assertNull(actualPdAnnotationText.getTitlePopup());
    assertNull(actualPdAnnotationText.getState());
    assertNull(actualPdAnnotationText.getStateModel());
    assertNull(actualPdAnnotationText.getCreationDate());
    assertNull(actualPdAnnotationText.getAppearanceState());
    assertNull(actualPdAnnotationText.getPage());
    assertNull(actualPdAnnotationText.getRectangle());
    assertNull(actualPdAnnotationText.getOptionalContent());
    assertNull(actualPdAnnotationText.getColor());
    assertNull(actualPdAnnotationText.getInReplyTo());
    assertNull(actualPdAnnotationText.getPopup());
    assertNull(actualPdAnnotationText.getAppearance());
    assertNull(actualPdAnnotationText.getNormalAppearanceStream());
    assertNull(actualPdAnnotationText.getBorderStyle());
    assertNull(actualPdAnnotationText.getExternalData());
    assertEquals(-1, actualPdAnnotationText.getStructParent());
    assertEquals(0, actualPdAnnotationText.getAnnotationFlags());
    assertEquals(1, field.size());
    assertEquals(1.0f, actualPdAnnotationText.getConstantOpacity());
    assertFalse(actualPdAnnotationText.isHidden());
    assertFalse(actualPdAnnotationText.isInvisible());
    assertFalse(actualPdAnnotationText.isLocked());
    assertFalse(actualPdAnnotationText.isLockedContents());
    assertFalse(actualPdAnnotationText.isNoRotate());
    assertFalse(actualPdAnnotationText.isNoView());
    assertFalse(actualPdAnnotationText.isNoZoom());
    assertFalse(actualPdAnnotationText.isPrinted());
    assertFalse(actualPdAnnotationText.isReadOnly());
    assertFalse(actualPdAnnotationText.isToggleNoView());
    assertFalse(actualPdAnnotationText.getOpen());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationText.getReplyType());
    assertEquals(PDAnnotationText.NAME_NOTE, actualPdAnnotationText.getName());
    assertSame(field, actualPdAnnotationText.getCOSObject());
  }

  /**
   * Test {@link PDAnnotationText#setOpen(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then not {@link PDAnnotationText#PDAnnotationText()} Open.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationText#setOpen(boolean)}
   */
  @Test
  @DisplayName("Test setOpen(boolean); when 'false'; then not PDAnnotationText() Open")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationText.setOpen(boolean)"})
  void testSetOpen_whenFalse_thenNotPDAnnotationTextOpen() {
    // Arrange
    PDAnnotationText pdAnnotationText = new PDAnnotationText();

    // Act
    pdAnnotationText.setOpen(false);

    // Assert
    COSDictionary cOSObject = pdAnnotationText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdAnnotationText.getOpen());
  }

  /**
   * Test {@link PDAnnotationText#setOpen(boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link PDAnnotationText#PDAnnotationText()} Open.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationText#setOpen(boolean)}
   */
  @Test
  @DisplayName("Test setOpen(boolean); when 'true'; then PDAnnotationText() Open")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationText.setOpen(boolean)"})
  void testSetOpen_whenTrue_thenPDAnnotationTextOpen() {
    // Arrange
    PDAnnotationText pdAnnotationText = new PDAnnotationText();

    // Act
    pdAnnotationText.setOpen(true);

    // Assert
    COSDictionary cOSObject = pdAnnotationText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdAnnotationText.getOpen());
  }

  /**
   * Test {@link PDAnnotationText#getOpen()}.
   * <ul>
   *   <li>Given {@link PDAnnotationText#PDAnnotationText()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationText#getOpen()}
   */
  @Test
  @DisplayName("Test getOpen(); given PDAnnotationText()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDAnnotationText.getOpen()"})
  void testGetOpen_givenPDAnnotationText() {
    // Arrange, Act and Assert
    assertFalse((new PDAnnotationText()).getOpen());
  }

  /**
   * Test {@link PDAnnotationText#getOpen()}.
   * <ul>
   *   <li>Given {@link PDAnnotationText#PDAnnotationText()} Contents is {@code PolygonValue}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationText#getOpen()}
   */
  @Test
  @DisplayName("Test getOpen(); given PDAnnotationText() Contents is 'PolygonValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDAnnotationText.getOpen()"})
  void testGetOpen_givenPDAnnotationTextContentsIsPolygonValue() {
    // Arrange
    PDAnnotationText pdAnnotationText = new PDAnnotationText();
    pdAnnotationText.setContents("PolygonValue");

    // Act and Assert
    assertFalse(pdAnnotationText.getOpen());
  }

  /**
   * Test {@link PDAnnotationText#setName(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then {@link PDAnnotationText#PDAnnotationText()} Name is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationText#setName(String)}
   */
  @Test
  @DisplayName("Test setName(String); when '42'; then PDAnnotationText() Name is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationText.setName(String)"})
  void testSetName_when42_thenPDAnnotationTextNameIs42() {
    // Arrange
    PDAnnotationText pdAnnotationText = new PDAnnotationText();

    // Act
    pdAnnotationText.setName("42");

    // Assert
    assertEquals("42", pdAnnotationText.getName());
    COSDictionary cOSObject = pdAnnotationText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationText#setName(String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then {@link PDAnnotationText#PDAnnotationText()} Name is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationText#setName(String)}
   */
  @Test
  @DisplayName("Test setName(String); when 'Name'; then PDAnnotationText() Name is 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationText.setName(String)"})
  void testSetName_whenName_thenPDAnnotationTextNameIsName() {
    // Arrange
    PDAnnotationText pdAnnotationText = new PDAnnotationText();

    // Act
    pdAnnotationText.setName("Name");

    // Assert
    assertEquals("Name", pdAnnotationText.getName());
    COSDictionary cOSObject = pdAnnotationText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationText#getName()}.
   * <p>
   * Method under test: {@link PDAnnotationText#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDAnnotationText.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals(PDAnnotationText.NAME_NOTE, (new PDAnnotationText()).getName());
  }

  /**
   * Test {@link PDAnnotationText#getState()}.
   * <p>
   * Method under test: {@link PDAnnotationText#getState()}
   */
  @Test
  @DisplayName("Test getState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDAnnotationText.getState()"})
  void testGetState() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationText()).getState());
  }

  /**
   * Test {@link PDAnnotationText#setState(String)}.
   * <p>
   * Method under test: {@link PDAnnotationText#setState(String)}
   */
  @Test
  @DisplayName("Test setState(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationText.setState(String)"})
  void testSetState() {
    // Arrange
    PDAnnotationText pdAnnotationText = new PDAnnotationText();

    // Act
    pdAnnotationText.setState("MD");

    // Assert
    assertEquals("MD", pdAnnotationText.getState());
    COSDictionary cOSObject = pdAnnotationText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationText#getStateModel()}.
   * <p>
   * Method under test: {@link PDAnnotationText#getStateModel()}
   */
  @Test
  @DisplayName("Test getStateModel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDAnnotationText.getStateModel()"})
  void testGetStateModel() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationText()).getStateModel());
  }

  /**
   * Test {@link PDAnnotationText#setStateModel(String)}.
   * <p>
   * Method under test: {@link PDAnnotationText#setStateModel(String)}
   */
  @Test
  @DisplayName("Test setStateModel(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationText.setStateModel(String)"})
  void testSetStateModel() {
    // Arrange
    PDAnnotationText pdAnnotationText = new PDAnnotationText();

    // Act
    pdAnnotationText.setStateModel("MD");

    // Assert
    assertEquals("MD", pdAnnotationText.getStateModel());
    COSDictionary cOSObject = pdAnnotationText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationText#constructAppearances(PDDocument)} with {@code PDDocument}.
   * <ul>
   *   <li>Then array length is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationText#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; then array length is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationText.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_thenArrayLengthIsThree() {
    // Arrange
    PDAnnotationText pdAnnotationText = new PDAnnotationText();
    pdAnnotationText.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationText.constructAppearances(new PDDocument());

    // Assert
    float[][] values = pdAnnotationText.getNormalAppearanceStream().getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDAnnotationText#constructAppearances(PDDocument)} with {@code PDDocument}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then array length is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationText#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; when 'null'; then array length is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationText.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_whenNull_thenArrayLengthIsThree() {
    // Arrange
    PDAnnotationText pdAnnotationText = new PDAnnotationText();
    pdAnnotationText.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationText.constructAppearances(null);

    // Assert
    float[][] values = pdAnnotationText.getNormalAppearanceStream().getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }
}
