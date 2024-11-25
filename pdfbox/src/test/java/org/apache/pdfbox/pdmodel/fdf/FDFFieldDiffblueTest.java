package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.github.jaiimageio.impl.plugins.tiff.TIFFFieldNode;
import com.github.jaiimageio.plugins.tiff.TIFFField;
import com.github.jaiimageio.plugins.tiff.TIFFTag;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.metadata.IIOMetadataNode;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.PDRange;
import org.apache.pdfbox.pdmodel.interactive.action.OpenMode;
import org.apache.pdfbox.pdmodel.interactive.action.PDAction;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionEmbeddedGoTo;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionGoTo;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionHide;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionImportData;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionJavaScript;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionLaunch;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionMovie;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionNamed;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionRemoteGoTo;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionResetForm;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionSound;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionSubmitForm;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionThread;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionURI;
import org.apache.pdfbox.pdmodel.interactive.action.PDAdditionalActions;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;

class FDFFieldDiffblueTest {
  /**
   * Test {@link FDFField#FDFField(COSDictionary)}.
   * <p>
   * Method under test: {@link FDFField#FDFField(COSDictionary)}
   */
  @Test
  @DisplayName("Test new FDFField(COSDictionary)")
  void testNewFDFField() {
    // Arrange
    COSDictionary f = new COSDictionary();

    // Act and Assert
    assertSame(f, (new FDFField(f)).getCOSObject());
  }

  /**
   * Test {@link FDFField#FDFField()}.
   * <p>
   * Method under test: {@link FDFField#FDFField()}
   */
  @Test
  @DisplayName("Test new FDFField()")
  void testNewFDFField2() throws IOException {
    // Arrange and Act
    FDFField actualFdfField = new FDFField();

    // Assert
    assertNull(actualFdfField.getClearFieldFlags());
    assertNull(actualFdfField.getClearWidgetFieldFlags());
    assertNull(actualFdfField.getFieldFlags());
    assertNull(actualFdfField.getSetFieldFlags());
    assertNull(actualFdfField.getSetWidgetFieldFlags());
    assertNull(actualFdfField.getWidgetFieldFlags());
    assertNull(actualFdfField.getValue());
    assertNull(actualFdfField.getPartialFieldName());
    assertNull(actualFdfField.getRichText());
    assertNull(actualFdfField.getOptions());
    assertNull(actualFdfField.getKids());
    assertNull(actualFdfField.getCOSValue());
    COSDictionary cOSObject = actualFdfField.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualFdfField.getIconFit());
    assertNull(actualFdfField.getAppearanceStreamReference());
    assertNull(actualFdfField.getAction());
    assertNull(actualFdfField.getAdditionalActions());
    assertNull(actualFdfField.getAppearanceDictionary());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link FDFField#FDFField(Element)}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#FDFField(Element)}
   */
  @Test
  @DisplayName("Test new FDFField(Element); given IIOMetadataNode(String) with 'name'")
  void testNewFDFField_givenIIOMetadataNodeWithName() throws IOException {
    // Arrange
    IIOMetadataNode fieldXML = new IIOMetadataNode("foo");
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("name");
    fieldXML.insertBefore(iioMetadataNode, new IIOMetadataNode("name"));

    // Act
    FDFField actualFdfField = new FDFField(fieldXML);

    // Assert
    assertEquals("", actualFdfField.getPartialFieldName());
    assertNull(actualFdfField.getClearFieldFlags());
    assertNull(actualFdfField.getClearWidgetFieldFlags());
    assertNull(actualFdfField.getFieldFlags());
    assertNull(actualFdfField.getSetFieldFlags());
    assertNull(actualFdfField.getSetWidgetFieldFlags());
    assertNull(actualFdfField.getWidgetFieldFlags());
    assertNull(actualFdfField.getValue());
    assertNull(actualFdfField.getRichText());
    assertNull(actualFdfField.getOptions());
    assertNull(actualFdfField.getKids());
    assertNull(actualFdfField.getCOSValue());
    COSDictionary cOSObject = actualFdfField.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualFdfField.getIconFit());
    assertNull(actualFdfField.getAppearanceStreamReference());
    assertNull(actualFdfField.getAction());
    assertNull(actualFdfField.getAdditionalActions());
    assertNull(actualFdfField.getAppearanceDictionary());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link FDFField#FDFField(Element)}.
   * <ul>
   *   <li>Then return PartialFieldName is {@code name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#FDFField(Element)}
   */
  @Test
  @DisplayName("Test new FDFField(Element); then return PartialFieldName is 'name'")
  void testNewFDFField_thenReturnPartialFieldNameIsName() throws IOException {
    // Arrange and Act
    FDFField actualFdfField = new FDFField(
        new TIFFFieldNode(new TIFFField(new TIFFTag("name", TIFFTag.TIFF_SRATIONAL, 1), 42)));

    // Assert
    assertEquals("name", actualFdfField.getPartialFieldName());
    assertNull(actualFdfField.getClearFieldFlags());
    assertNull(actualFdfField.getClearWidgetFieldFlags());
    assertNull(actualFdfField.getFieldFlags());
    assertNull(actualFdfField.getSetFieldFlags());
    assertNull(actualFdfField.getSetWidgetFieldFlags());
    assertNull(actualFdfField.getWidgetFieldFlags());
    assertNull(actualFdfField.getValue());
    assertNull(actualFdfField.getRichText());
    assertNull(actualFdfField.getOptions());
    assertNull(actualFdfField.getKids());
    assertNull(actualFdfField.getCOSValue());
    COSDictionary cOSObject = actualFdfField.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualFdfField.getIconFit());
    assertNull(actualFdfField.getAppearanceStreamReference());
    assertNull(actualFdfField.getAction());
    assertNull(actualFdfField.getAdditionalActions());
    assertNull(actualFdfField.getAppearanceDictionary());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link FDFField#FDFField(Element)}.
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#FDFField(Element)}
   */
  @Test
  @DisplayName("Test new FDFField(Element); when IIOMetadataNode(String) with 'foo'")
  void testNewFDFField_whenIIOMetadataNodeWithFoo() throws IOException {
    // Arrange and Act
    FDFField actualFdfField = new FDFField(new IIOMetadataNode("foo"));

    // Assert
    assertEquals("", actualFdfField.getPartialFieldName());
    assertNull(actualFdfField.getClearFieldFlags());
    assertNull(actualFdfField.getClearWidgetFieldFlags());
    assertNull(actualFdfField.getFieldFlags());
    assertNull(actualFdfField.getSetFieldFlags());
    assertNull(actualFdfField.getSetWidgetFieldFlags());
    assertNull(actualFdfField.getWidgetFieldFlags());
    assertNull(actualFdfField.getValue());
    assertNull(actualFdfField.getRichText());
    assertNull(actualFdfField.getOptions());
    assertNull(actualFdfField.getKids());
    assertNull(actualFdfField.getCOSValue());
    COSDictionary cOSObject = actualFdfField.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualFdfField.getIconFit());
    assertNull(actualFdfField.getAppearanceStreamReference());
    assertNull(actualFdfField.getAction());
    assertNull(actualFdfField.getAdditionalActions());
    assertNull(actualFdfField.getAppearanceDictionary());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link FDFField#writeXML(Writer)}.
   * <p>
   * Method under test: {@link FDFField#writeXML(Writer)}
   */
  @Test
  @DisplayName("Test writeXML(Writer)")
  void testWriteXML() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setRichText(new COSStream());
    StringWriter output = new StringWriter();

    // Act
    fdfField.writeXML(output);

    // Assert
    assertEquals("<field name=\"null\">\n<value-richtext></value-richtext>\n</field>\n", output.toString());
  }

  /**
   * Test {@link FDFField#writeXML(Writer)}.
   * <p>
   * Method under test: {@link FDFField#writeXML(Writer)}
   */
  @Test
  @DisplayName("Test writeXML(Writer)")
  void testWriteXML2() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setValue("<field name=\"");
    StringWriter output = new StringWriter();

    // Act
    fdfField.writeXML(output);

    // Assert
    assertEquals("<field name=\"null\">\n<value>&lt;field name=&quot;</value>\n</field>\n", output.toString());
  }

  /**
   * Test {@link FDFField#writeXML(Writer)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#writeXML(Writer)}
   */
  @Test
  @DisplayName("Test writeXML(Writer); given COSObjectKey(long, int) with num is one and gen is one; then throw IOException")
  void testWriteXML_givenCOSObjectKeyWithNumIsOneAndGenIsOne_thenThrowIOException() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setValue((Object) new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Act and Assert
    assertThrows(IOException.class, () -> fdfField.writeXML(new StringWriter()));
  }

  /**
   * Test {@link FDFField#writeXML(Writer)}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Value is
   * {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#writeXML(Writer)}
   */
  @Test
  @DisplayName("Test writeXML(Writer); given FDFField() Value is COSArray()")
  void testWriteXML_givenFDFFieldValueIsCOSArray() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setValue((Object) new COSArray());
    StringWriter output = new StringWriter();

    // Act
    fdfField.writeXML(output);

    // Assert
    assertEquals("<field name=\"null\">\n</field>\n", output.toString());
  }

  /**
   * Test {@link FDFField#writeXML(Writer)}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Value is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#writeXML(Writer)}
   */
  @Test
  @DisplayName("Test writeXML(Writer); given FDFField() Value is COSDictionary(); then throw IOException")
  void testWriteXML_givenFDFFieldValueIsCOSDictionary_thenThrowIOException() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setValue((Object) new COSDictionary());

    // Act and Assert
    assertThrows(IOException.class, () -> fdfField.writeXML(new StringWriter()));
  }

  /**
   * Test {@link FDFField#writeXML(Writer)}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Value is
   * {@link COSDocument#COSDocument()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#writeXML(Writer)}
   */
  @Test
  @DisplayName("Test writeXML(Writer); given FDFField() Value is COSDocument(); then throw IOException")
  void testWriteXML_givenFDFFieldValueIsCOSDocument_thenThrowIOException() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setValue((Object) new COSDocument());

    // Act and Assert
    assertThrows(IOException.class, () -> fdfField.writeXML(new StringWriter()));
  }

  /**
   * Test {@link FDFField#writeXML(Writer)}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Value is
   * {@link COSFloat#COSFloat(float)} with aFloat is ten.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#writeXML(Writer)}
   */
  @Test
  @DisplayName("Test writeXML(Writer); given FDFField() Value is COSFloat(float) with aFloat is ten; then throw IOException")
  void testWriteXML_givenFDFFieldValueIsCOSFloatWithAFloatIsTen_thenThrowIOException() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setValue((Object) new COSFloat(10.0f));

    // Act and Assert
    assertThrows(IOException.class, () -> fdfField.writeXML(new StringWriter()));
  }

  /**
   * Test {@link FDFField#writeXML(Writer)}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Value is {@link COSBoolean#FALSE}.</li>
   *   <li>When {@link StringWriter#StringWriter()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#writeXML(Writer)}
   */
  @Test
  @DisplayName("Test writeXML(Writer); given FDFField() Value is FALSE; when StringWriter(); then throw IOException")
  void testWriteXML_givenFDFFieldValueIsFalse_whenStringWriter_thenThrowIOException() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setValue(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(IOException.class, () -> fdfField.writeXML(new StringWriter()));
  }

  /**
   * Test {@link FDFField#writeXML(Writer)}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Value is {@link COSFloat#ONE}.</li>
   *   <li>When {@link StringWriter#StringWriter()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#writeXML(Writer)}
   */
  @Test
  @DisplayName("Test writeXML(Writer); given FDFField() Value is ONE; when StringWriter(); then throw IOException")
  void testWriteXML_givenFDFFieldValueIsOne_whenStringWriter_thenThrowIOException() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setValue((Object) COSFloat.ONE);

    // Act and Assert
    assertThrows(IOException.class, () -> fdfField.writeXML(new StringWriter()));
  }

  /**
   * Test {@link FDFField#writeXML(Writer)}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Value is {@link COSInteger#ONE}.</li>
   *   <li>When {@link StringWriter#StringWriter()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#writeXML(Writer)}
   */
  @Test
  @DisplayName("Test writeXML(Writer); given FDFField() Value is ONE; when StringWriter(); then throw IOException")
  void testWriteXML_givenFDFFieldValueIsOne_whenStringWriter_thenThrowIOException2() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setValue((Object) COSInteger.ONE);

    // Act and Assert
    assertThrows(IOException.class, () -> fdfField.writeXML(new StringWriter()));
  }

  /**
   * Test {@link FDFField#writeXML(Writer)}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()}.</li>
   *   <li>Then {@link StringWriter#StringWriter()} toString is
   * {@code <field name="null"> </field>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#writeXML(Writer)}
   */
  @Test
  @DisplayName("Test writeXML(Writer); given FDFField(); then StringWriter() toString is '<field name=\"null\"> </field>'")
  void testWriteXML_givenFDFField_thenStringWriterToStringIsFieldNameNullField() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    StringWriter output = new StringWriter();

    // Act
    fdfField.writeXML(output);

    // Assert
    assertEquals("<field name=\"null\">\n</field>\n", output.toString());
  }

  /**
   * Test {@link FDFField#writeXML(Writer)}.
   * <ul>
   *   <li>Then {@link StringWriter#StringWriter()} toString is a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#writeXML(Writer)}
   */
  @Test
  @DisplayName("Test writeXML(Writer); then StringWriter() toString is a string")
  void testWriteXML_thenStringWriterToStringIsAString() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setRichText(COSString.parseHex("0123456789ABCDEF"));
    StringWriter output = new StringWriter();

    // Act
    fdfField.writeXML(output);

    // Assert
    assertEquals(
        "<field name=\"null\">\n<value-richtext>\u0001#Eg&#8250;&#171;&#205;&#239;</value-richtext>\n</field>\n",
        output.toString());
  }

  /**
   * Test {@link FDFField#writeXML(Writer)}.
   * <ul>
   *   <li>Then {@link StringWriter#StringWriter()} toString is
   * {@code <field name=""> </field>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#writeXML(Writer)}
   */
  @Test
  @DisplayName("Test writeXML(Writer); then StringWriter() toString is '<field name=\"\"> </field>'")
  void testWriteXML_thenStringWriterToStringIsFieldNameField() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField(new IIOMetadataNode("<field name=\""));
    StringWriter output = new StringWriter();

    // Act
    fdfField.writeXML(output);

    // Assert
    assertEquals("<field name=\"\">\n</field>\n", output.toString());
  }

  /**
   * Test {@link FDFField#writeXML(Writer)}.
   * <ul>
   *   <li>Then {@link StringWriter#StringWriter()} toString is
   * {@code <field name="<field name=""> </field>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#writeXML(Writer)}
   */
  @Test
  @DisplayName("Test writeXML(Writer); then StringWriter() toString is '<field name=\"<field name=\"\"> </field>'")
  void testWriteXML_thenStringWriterToStringIsFieldNameFieldNameField() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setPartialFieldName("<field name=\"");
    StringWriter output = new StringWriter();

    // Act
    fdfField.writeXML(output);

    // Assert
    assertEquals("<field name=\"<field name=\"\">\n</field>\n", output.toString());
  }

  /**
   * Test {@link FDFField#writeXML(Writer)}.
   * <ul>
   *   <li>Then {@link StringWriter#StringWriter()} toString is
   * {@code <field name="null"> </field>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#writeXML(Writer)}
   */
  @Test
  @DisplayName("Test writeXML(Writer); then StringWriter() toString is '<field name=\"null\"> </field>'")
  void testWriteXML_thenStringWriterToStringIsFieldNameNullField() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setKids(new ArrayList<>());
    StringWriter output = new StringWriter();

    // Act
    fdfField.writeXML(output);

    // Assert
    assertEquals("<field name=\"null\">\n</field>\n", output.toString());
  }

  /**
   * Test {@link FDFField#writeXML(Writer)}.
   * <ul>
   *   <li>Then {@link StringWriter#StringWriter()} toString is
   * {@code <field name="null"> <field name="null"> </field> </field>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#writeXML(Writer)}
   */
  @Test
  @DisplayName("Test writeXML(Writer); then StringWriter() toString is '<field name=\"null\"> <field name=\"null\"> </field> </field>'")
  void testWriteXML_thenStringWriterToStringIsFieldNameNullFieldNameNullFieldField() throws IOException {
    // Arrange
    ArrayList<FDFField> kids = new ArrayList<>();
    kids.add(new FDFField());

    FDFField fdfField = new FDFField();
    fdfField.setKids(kids);
    StringWriter output = new StringWriter();

    // Act
    fdfField.writeXML(output);

    // Assert
    assertEquals("<field name=\"null\">\n<field name=\"null\">\n</field>\n</field>\n", output.toString());
  }

  /**
   * Test {@link FDFField#writeXML(Writer)}.
   * <ul>
   *   <li>Then {@link StringWriter#StringWriter()} toString is
   * {@code <field name="null"> <value>A</value> </field>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#writeXML(Writer)}
   */
  @Test
  @DisplayName("Test writeXML(Writer); then StringWriter() toString is '<field name=\"null\"> <value>A</value> </field>'")
  void testWriteXML_thenStringWriterToStringIsFieldNameNullValueAValueField() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setValue(COSName.A);
    StringWriter output = new StringWriter();

    // Act
    fdfField.writeXML(output);

    // Assert
    assertEquals("<field name=\"null\">\n<value>A</value>\n</field>\n", output.toString());
  }

  /**
   * Test {@link FDFField#writeXML(Writer)}.
   * <ul>
   *   <li>Then {@link StringWriter#StringWriter()} toString is
   * {@code <field name="null"> <value>&quot;&gt; </value> </field>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#writeXML(Writer)}
   */
  @Test
  @DisplayName("Test writeXML(Writer); then StringWriter() toString is '<field name=\"null\"> <value>&quot;&gt; </value> </field>'")
  void testWriteXML_thenStringWriterToStringIsFieldNameNullValueQuotGtValueField() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setValue("\">\n");
    StringWriter output = new StringWriter();

    // Act
    fdfField.writeXML(output);

    // Assert
    assertEquals("<field name=\"null\">\n<value>&quot;&gt;\n</value>\n</field>\n", output.toString());
  }

  /**
   * Test {@link FDFField#writeXML(Writer)}.
   * <ul>
   *   <li>Then {@link StringWriter#StringWriter()} toString is
   * {@code <field name="null"> <value></value> </field>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#writeXML(Writer)}
   */
  @Test
  @DisplayName("Test writeXML(Writer); then StringWriter() toString is '<field name=\"null\"> <value></value> </field>'")
  void testWriteXML_thenStringWriterToStringIsFieldNameNullValueValueField() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setValue(new COSStream());
    StringWriter output = new StringWriter();

    // Act
    fdfField.writeXML(output);

    // Assert
    assertEquals("<field name=\"null\">\n<value></value>\n</field>\n", output.toString());
  }

  /**
   * Test {@link FDFField#writeXML(Writer)}.
   * <ul>
   *   <li>Then {@link StringWriter#StringWriter()} toString is
   * {@code <field name="null"> <value>Value</value> </field>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#writeXML(Writer)}
   */
  @Test
  @DisplayName("Test writeXML(Writer); then StringWriter() toString is '<field name=\"null\"> <value>Value</value> </field>'")
  void testWriteXML_thenStringWriterToStringIsFieldNameNullValueValueValueField() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setValue("Value");
    StringWriter output = new StringWriter();

    // Act
    fdfField.writeXML(output);

    // Assert
    assertEquals("<field name=\"null\">\n<value>Value</value>\n</field>\n", output.toString());
  }

  /**
   * Test {@link FDFField#getCOSObject()}.
   * <p>
   * Method under test: {@link FDFField#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new FDFField()).getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(0, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualCOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link FDFField#getKids()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FDFField#FDFField()}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getKids()}
   */
  @Test
  @DisplayName("Test getKids(); given ArrayList() add FDFField(); then return size is one")
  void testGetKids_givenArrayListAddFDFField_thenReturnSizeIsOne() throws IOException {
    // Arrange
    ArrayList<FDFField> kids = new ArrayList<>();
    kids.add(new FDFField());

    FDFField fdfField = new FDFField();
    fdfField.setKids(kids);

    // Act
    List<FDFField> actualKids = fdfField.getKids();

    // Assert
    assertEquals(1, actualKids.size());
    FDFField getResult = actualKids.get(0);
    assertNull(getResult.getClearFieldFlags());
    assertNull(getResult.getClearWidgetFieldFlags());
    assertNull(getResult.getFieldFlags());
    assertNull(getResult.getSetFieldFlags());
    assertNull(getResult.getSetWidgetFieldFlags());
    assertNull(getResult.getWidgetFieldFlags());
    assertNull(getResult.getValue());
    assertNull(getResult.getPartialFieldName());
    assertNull(getResult.getRichText());
    assertNull(getResult.getOptions());
    assertNull(getResult.getCOSValue());
    COSDictionary cOSObject = getResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(getResult.getIconFit());
    assertNull(getResult.getAppearanceStreamReference());
    assertNull(getResult.getAction());
    assertNull(getResult.getAdditionalActions());
    assertNull(getResult.getAppearanceDictionary());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link FDFField#getKids()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Kids is
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getKids()}
   */
  @Test
  @DisplayName("Test getKids(); given FDFField() Kids is ArrayList(); then return Empty")
  void testGetKids_givenFDFFieldKidsIsArrayList_thenReturnEmpty() {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setKids(new ArrayList<>());

    // Act and Assert
    assertTrue(fdfField.getKids().isEmpty());
  }

  /**
   * Test {@link FDFField#getKids()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getKids()}
   */
  @Test
  @DisplayName("Test getKids(); given FDFField(); then return 'null'")
  void testGetKids_givenFDFField_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFField()).getKids());
  }

  /**
   * Test {@link FDFField#getKids()}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getKids()}
   */
  @Test
  @DisplayName("Test getKids(); given IIOMetadataNode(String) with 'foo'; then return 'null'")
  void testGetKids_givenIIOMetadataNodeWithFoo_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new FDFField(new IIOMetadataNode("foo"))).getKids());
  }

  /**
   * Test {@link FDFField#setKids(List)}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link FDFField#FDFField()}.</li>
   *   <li>Then {@link FDFField#FDFField()} Kids size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given FDFField(); when ArrayList() add FDFField(); then FDFField() Kids size is two")
  void testSetKids_givenFDFField_whenArrayListAddFDFField_thenFDFFieldKidsSizeIsTwo() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();

    ArrayList<FDFField> kids = new ArrayList<>();
    kids.add(new FDFField());
    kids.add(new FDFField());

    // Act
    fdfField.setKids(kids);

    // Assert
    List<FDFField> kids2 = fdfField.getKids();
    assertEquals(2, kids2.size());
    FDFField getResult = kids2.get(1);
    assertNull(getResult.getClearFieldFlags());
    assertNull(getResult.getClearWidgetFieldFlags());
    assertNull(getResult.getFieldFlags());
    assertNull(getResult.getSetFieldFlags());
    assertNull(getResult.getSetWidgetFieldFlags());
    assertNull(getResult.getWidgetFieldFlags());
    assertNull(getResult.getValue());
    assertNull(getResult.getPartialFieldName());
    assertNull(getResult.getRichText());
    assertNull(getResult.getOptions());
    assertNull(getResult.getKids());
    assertNull(getResult.getCOSValue());
    assertNull(getResult.getIconFit());
    assertNull(getResult.getAppearanceStreamReference());
    assertNull(getResult.getAction());
    assertNull(getResult.getAdditionalActions());
    assertNull(getResult.getAppearanceDictionary());
  }

  /**
   * Test {@link FDFField#setKids(List)}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link FDFField#FDFField()} Kids Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given FDFField(); when ArrayList(); then FDFField() Kids Empty")
  void testSetKids_givenFDFField_whenArrayList_thenFDFFieldKidsEmpty() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setKids(new ArrayList<>());

    // Assert
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(fdfField.getKids().isEmpty());
  }

  /**
   * Test {@link FDFField#setKids(List)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then {@link FDFField#FDFField()} Kids first COSObject is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given 'null'; when ArrayList() add 'null'; then FDFField() Kids first COSObject is 'null'")
  void testSetKids_givenNull_whenArrayListAddNull_thenFDFFieldKidsFirstCOSObjectIsNull() {
    // Arrange
    FDFField fdfField = new FDFField();

    ArrayList<FDFField> kids = new ArrayList<>();
    kids.add(null);

    // Act
    fdfField.setKids(kids);

    // Assert
    List<FDFField> kids2 = fdfField.getKids();
    assertEquals(1, kids2.size());
    assertNull(kids2.get(0).getCOSObject());
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#setKids(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@link FDFField#FDFField()}.</li>
   *   <li>Then {@link FDFField#FDFField()} Kids first ClearFieldFlags is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); when ArrayList() add FDFField(); then FDFField() Kids first ClearFieldFlags is 'null'")
  void testSetKids_whenArrayListAddFDFField_thenFDFFieldKidsFirstClearFieldFlagsIsNull() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();

    ArrayList<FDFField> kids = new ArrayList<>();
    kids.add(new FDFField());

    // Act
    fdfField.setKids(kids);

    // Assert
    List<FDFField> kids2 = fdfField.getKids();
    assertEquals(1, kids2.size());
    FDFField getResult = kids2.get(0);
    assertNull(getResult.getClearFieldFlags());
    assertNull(getResult.getClearWidgetFieldFlags());
    assertNull(getResult.getFieldFlags());
    assertNull(getResult.getSetFieldFlags());
    assertNull(getResult.getSetWidgetFieldFlags());
    assertNull(getResult.getWidgetFieldFlags());
    assertNull(getResult.getValue());
    assertNull(getResult.getPartialFieldName());
    assertNull(getResult.getRichText());
    assertNull(getResult.getOptions());
    assertNull(getResult.getKids());
    assertNull(getResult.getCOSValue());
    assertNull(getResult.getIconFit());
    assertNull(getResult.getAppearanceStreamReference());
    assertNull(getResult.getAction());
    assertNull(getResult.getAdditionalActions());
    assertNull(getResult.getAppearanceDictionary());
  }

  /**
   * Test {@link FDFField#getPartialFieldName()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} PartialFieldName is
   * {@code Partial}.</li>
   *   <li>Then return {@code Partial}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getPartialFieldName()}
   */
  @Test
  @DisplayName("Test getPartialFieldName(); given FDFField() PartialFieldName is 'Partial'; then return 'Partial'")
  void testGetPartialFieldName_givenFDFFieldPartialFieldNameIsPartial_thenReturnPartial() {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setPartialFieldName("Partial");

    // Act and Assert
    assertEquals("Partial", fdfField.getPartialFieldName());
  }

  /**
   * Test {@link FDFField#getPartialFieldName()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getPartialFieldName()}
   */
  @Test
  @DisplayName("Test getPartialFieldName(); given FDFField(); then return 'null'")
  void testGetPartialFieldName_givenFDFField_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFField()).getPartialFieldName());
  }

  /**
   * Test {@link FDFField#getPartialFieldName()}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getPartialFieldName()}
   */
  @Test
  @DisplayName("Test getPartialFieldName(); given IIOMetadataNode(String) with 'foo'; then return empty string")
  void testGetPartialFieldName_givenIIOMetadataNodeWithFoo_thenReturnEmptyString() throws IOException {
    // Arrange, Act and Assert
    assertEquals("", (new FDFField(new IIOMetadataNode("foo"))).getPartialFieldName());
  }

  /**
   * Test {@link FDFField#setPartialFieldName(String)}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()}.</li>
   *   <li>Then {@link FDFField#FDFField()} PartialFieldName is
   * {@code Partial}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setPartialFieldName(String)}
   */
  @Test
  @DisplayName("Test setPartialFieldName(String); given FDFField(); then FDFField() PartialFieldName is 'Partial'")
  void testSetPartialFieldName_givenFDFField_thenFDFFieldPartialFieldNameIsPartial() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setPartialFieldName("Partial");

    // Assert
    assertEquals("Partial", fdfField.getPartialFieldName());
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#getValue()}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); given COSObjectKey(long, int) with num is one and gen is one; then throw IOException")
  void testGetValue_givenCOSObjectKeyWithNumIsOneAndGenIsOne_thenThrowIOException() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setValue((Object) new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Act and Assert
    assertThrows(IOException.class, () -> fdfField.getValue());
  }

  /**
   * Test {@link FDFField#getValue()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Value is {@link COSName#A}.</li>
   *   <li>Then return {@link FDFIconFit#SCALE_OPTION_ALWAYS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); given FDFField() Value is A; then return SCALE_OPTION_ALWAYS")
  void testGetValue_givenFDFFieldValueIsA_thenReturnScale_option_always() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setValue(COSName.A);

    // Act and Assert
    assertEquals(FDFIconFit.SCALE_OPTION_ALWAYS, fdfField.getValue());
  }

  /**
   * Test {@link FDFField#getValue()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Value is
   * {@link COSArray#COSArray()}.</li>
   *   <li>Then return {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); given FDFField() Value is COSArray(); then return List")
  void testGetValue_givenFDFFieldValueIsCOSArray_thenReturnList() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setValue((Object) new COSArray());

    // Act
    Object actualValue = fdfField.getValue();

    // Assert
    assertTrue(actualValue instanceof List);
    assertTrue(((List<Object>) actualValue).isEmpty());
  }

  /**
   * Test {@link FDFField#getValue()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Value is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); given FDFField() Value is COSDictionary(); then throw IOException")
  void testGetValue_givenFDFFieldValueIsCOSDictionary_thenThrowIOException() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setValue((Object) new COSDictionary());

    // Act and Assert
    assertThrows(IOException.class, () -> fdfField.getValue());
  }

  /**
   * Test {@link FDFField#getValue()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Value is
   * {@link COSDocument#COSDocument()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); given FDFField() Value is COSDocument(); then throw IOException")
  void testGetValue_givenFDFFieldValueIsCOSDocument_thenThrowIOException() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setValue((Object) new COSDocument());

    // Act and Assert
    assertThrows(IOException.class, () -> fdfField.getValue());
  }

  /**
   * Test {@link FDFField#getValue()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Value is
   * {@link COSFloat#COSFloat(float)} with aFloat is ten.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); given FDFField() Value is COSFloat(float) with aFloat is ten; then throw IOException")
  void testGetValue_givenFDFFieldValueIsCOSFloatWithAFloatIsTen_thenThrowIOException() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setValue((Object) new COSFloat(10.0f));

    // Act and Assert
    assertThrows(IOException.class, () -> fdfField.getValue());
  }

  /**
   * Test {@link FDFField#getValue()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Value is
   * {@link COSStream#COSStream()}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); given FDFField() Value is COSStream(); then return empty string")
  void testGetValue_givenFDFFieldValueIsCOSStream_thenReturnEmptyString() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setValue(new COSStream());

    // Act and Assert
    assertEquals("", fdfField.getValue());
  }

  /**
   * Test {@link FDFField#getValue()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Value is empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); given FDFField() Value is empty string; then return empty string")
  void testGetValue_givenFDFFieldValueIsEmptyString_thenReturnEmptyString() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setValue("");

    // Act and Assert
    assertEquals("", fdfField.getValue());
  }

  /**
   * Test {@link FDFField#getValue()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Value is {@link COSBoolean#FALSE}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); given FDFField() Value is FALSE; then throw IOException")
  void testGetValue_givenFDFFieldValueIsFalse_thenThrowIOException() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setValue(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(IOException.class, () -> fdfField.getValue());
  }

  /**
   * Test {@link FDFField#getValue()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Value is {@link COSFloat#ONE}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); given FDFField() Value is ONE; then throw IOException")
  void testGetValue_givenFDFFieldValueIsOne_thenThrowIOException() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setValue((Object) COSFloat.ONE);

    // Act and Assert
    assertThrows(IOException.class, () -> fdfField.getValue());
  }

  /**
   * Test {@link FDFField#getValue()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Value is {@link COSInteger#ONE}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); given FDFField() Value is ONE; then throw IOException")
  void testGetValue_givenFDFFieldValueIsOne_thenThrowIOException2() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setValue((Object) COSInteger.ONE);

    // Act and Assert
    assertThrows(IOException.class, () -> fdfField.getValue());
  }

  /**
   * Test {@link FDFField#getValue()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Value is {@code Value}.</li>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); given FDFField() Value is 'Value'; then return 'Value'")
  void testGetValue_givenFDFFieldValueIsValue_thenReturnValue() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setValue("Value");

    // Act and Assert
    assertEquals("Value", fdfField.getValue());
  }

  /**
   * Test {@link FDFField#getValue()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); given FDFField(); then return 'null'")
  void testGetValue_givenFDFField_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new FDFField()).getValue());
  }

  /**
   * Test {@link FDFField#getValue()}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); given IIOMetadataNode(String) with 'foo'; then return 'null'")
  void testGetValue_givenIIOMetadataNodeWithFoo_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new FDFField(new IIOMetadataNode("foo"))).getValue());
  }

  /**
   * Test {@link FDFField#getCOSValue()}.
   * <p>
   * Method under test: {@link FDFField#getCOSValue()}
   */
  @Test
  @DisplayName("Test getCOSValue()")
  void testGetCOSValue() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setValue((Object) new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Act and Assert
    assertThrows(IOException.class, () -> fdfField.getCOSValue());
  }

  /**
   * Test {@link FDFField#getCOSValue()}.
   * <ul>
   *   <li>Given {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is
   * {@link COSBoolean#FALSE} and objectKey is
   * {@link COSObjectKey#COSObjectKey(long, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getCOSValue()}
   */
  @Test
  @DisplayName("Test getCOSValue(); given COSObject(COSBase, COSObjectKey) with object is FALSE and objectKey is COSObjectKey(long, int)")
  void testGetCOSValue_givenCOSObjectWithObjectIsFalseAndObjectKeyIsCOSObjectKey() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    fdfField.setValue((Object) new COSObject(object, new COSObjectKey(1L, 1)));

    // Act and Assert
    assertThrows(IOException.class, () -> fdfField.getCOSValue());
  }

  /**
   * Test {@link FDFField#getCOSValue()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Value is {@link COSName#A}.</li>
   *   <li>Then return {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getCOSValue()}
   */
  @Test
  @DisplayName("Test getCOSValue(); given FDFField() Value is A; then return A")
  void testGetCOSValue_givenFDFFieldValueIsA_thenReturnA() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setValue(COSName.A);

    // Act
    COSBase actualCOSValue = fdfField.getCOSValue();

    // Assert
    assertSame(((COSName) actualCOSValue).A, actualCOSValue);
  }

  /**
   * Test {@link FDFField#getCOSValue()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Value is
   * {@link COSArray#COSArray()}.</li>
   *   <li>Then return {@link COSArray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getCOSValue()}
   */
  @Test
  @DisplayName("Test getCOSValue(); given FDFField() Value is COSArray(); then return COSArray")
  void testGetCOSValue_givenFDFFieldValueIsCOSArray_thenReturnCOSArray() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    COSArray cosArray = new COSArray();
    fdfField.setValue((Object) cosArray);

    // Act
    COSBase actualCOSValue = fdfField.getCOSValue();

    // Assert
    assertTrue(actualCOSValue instanceof COSArray);
    assertTrue(((COSArray) actualCOSValue).toList().isEmpty());
    assertSame(cosArray, actualCOSValue);
  }

  /**
   * Test {@link FDFField#getCOSValue()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Value is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getCOSValue()}
   */
  @Test
  @DisplayName("Test getCOSValue(); given FDFField() Value is COSDictionary(); then throw IOException")
  void testGetCOSValue_givenFDFFieldValueIsCOSDictionary_thenThrowIOException() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setValue((Object) new COSDictionary());

    // Act and Assert
    assertThrows(IOException.class, () -> fdfField.getCOSValue());
  }

  /**
   * Test {@link FDFField#getCOSValue()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Value is
   * {@link COSDocument#COSDocument()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getCOSValue()}
   */
  @Test
  @DisplayName("Test getCOSValue(); given FDFField() Value is COSDocument(); then throw IOException")
  void testGetCOSValue_givenFDFFieldValueIsCOSDocument_thenThrowIOException() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setValue((Object) new COSDocument());

    // Act and Assert
    assertThrows(IOException.class, () -> fdfField.getCOSValue());
  }

  /**
   * Test {@link FDFField#getCOSValue()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Value is
   * {@link COSFloat#COSFloat(float)} with aFloat is {@code -3.4028235E38}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getCOSValue()}
   */
  @Test
  @DisplayName("Test getCOSValue(); given FDFField() Value is COSFloat(float) with aFloat is '-3.4028235E38'")
  void testGetCOSValue_givenFDFFieldValueIsCOSFloatWithAFloatIs34028235e38() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setValue((Object) new COSFloat(-3.4028235E38f));

    // Act and Assert
    assertThrows(IOException.class, () -> fdfField.getCOSValue());
  }

  /**
   * Test {@link FDFField#getCOSValue()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Value is
   * {@link COSFloat#COSFloat(float)} with aFloat is ten.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getCOSValue()}
   */
  @Test
  @DisplayName("Test getCOSValue(); given FDFField() Value is COSFloat(float) with aFloat is ten; then throw IOException")
  void testGetCOSValue_givenFDFFieldValueIsCOSFloatWithAFloatIsTen_thenThrowIOException() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setValue((Object) new COSFloat(10.0f));

    // Act and Assert
    assertThrows(IOException.class, () -> fdfField.getCOSValue());
  }

  /**
   * Test {@link FDFField#getCOSValue()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Value is
   * {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getCOSValue()}
   */
  @Test
  @DisplayName("Test getCOSValue(); given FDFField() Value is COSStream(); then return COSStream()")
  void testGetCOSValue_givenFDFFieldValueIsCOSStream_thenReturnCOSStream() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    COSStream value = new COSStream();
    fdfField.setValue(value);

    // Act and Assert
    assertSame(value, fdfField.getCOSValue());
  }

  /**
   * Test {@link FDFField#getCOSValue()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Value is {@link COSBoolean#FALSE}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getCOSValue()}
   */
  @Test
  @DisplayName("Test getCOSValue(); given FDFField() Value is FALSE; then throw IOException")
  void testGetCOSValue_givenFDFFieldValueIsFalse_thenThrowIOException() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setValue(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(IOException.class, () -> fdfField.getCOSValue());
  }

  /**
   * Test {@link FDFField#getCOSValue()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Value is {@link COSFloat#ONE}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getCOSValue()}
   */
  @Test
  @DisplayName("Test getCOSValue(); given FDFField() Value is ONE; then throw IOException")
  void testGetCOSValue_givenFDFFieldValueIsOne_thenThrowIOException() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setValue((Object) COSFloat.ONE);

    // Act and Assert
    assertThrows(IOException.class, () -> fdfField.getCOSValue());
  }

  /**
   * Test {@link FDFField#getCOSValue()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Value is {@link COSInteger#ONE}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getCOSValue()}
   */
  @Test
  @DisplayName("Test getCOSValue(); given FDFField() Value is ONE; then throw IOException")
  void testGetCOSValue_givenFDFFieldValueIsOne_thenThrowIOException2() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setValue((Object) COSInteger.ONE);

    // Act and Assert
    assertThrows(IOException.class, () -> fdfField.getCOSValue());
  }

  /**
   * Test {@link FDFField#getCOSValue()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Value is {@code Value}.</li>
   *   <li>Then return {@link COSString}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getCOSValue()}
   */
  @Test
  @DisplayName("Test getCOSValue(); given FDFField() Value is 'Value'; then return COSString")
  void testGetCOSValue_givenFDFFieldValueIsValue_thenReturnCOSString() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setValue("Value");

    // Act
    COSBase actualCOSValue = fdfField.getCOSValue();

    // Assert
    assertTrue(actualCOSValue instanceof COSString);
    assertEquals("56616C7565", ((COSString) actualCOSValue).toHexString());
    assertEquals("Value", ((COSString) actualCOSValue).getASCII());
    assertEquals("Value", ((COSString) actualCOSValue).getString());
    assertFalse(((COSString) actualCOSValue).getForceHexForm());
    byte[] expectedBytes = "Value".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((COSString) actualCOSValue).getBytes());
  }

  /**
   * Test {@link FDFField#getCOSValue()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getCOSValue()}
   */
  @Test
  @DisplayName("Test getCOSValue(); given FDFField(); then return 'null'")
  void testGetCOSValue_givenFDFField_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new FDFField()).getCOSValue());
  }

  /**
   * Test {@link FDFField#getCOSValue()}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getCOSValue()}
   */
  @Test
  @DisplayName("Test getCOSValue(); given IIOMetadataNode(String) with 'foo'; then return 'null'")
  void testGetCOSValue_givenIIOMetadataNodeWithFoo_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new FDFField(new IIOMetadataNode("foo"))).getCOSValue());
  }

  /**
   * Test {@link FDFField#setValue(COSBase)} with {@code COSBase}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setValue(COSBase)}
   */
  @Test
  @DisplayName("Test setValue(COSBase) with 'COSBase'; given COSObjectKey(long, int) with num is one and gen is one")
  void testSetValueWithCOSBase_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    FDFField fdfField = new FDFField();

    COSDictionary value = new COSDictionary();
    value.setKey(new COSObjectKey(1L, 1));

    // Act
    fdfField.setValue(value);

    // Assert
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#setValue(COSBase)} with {@code COSBase}.
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.</li>
   *   <li>Then {@link FDFField#FDFField()} Value {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setValue(COSBase)}
   */
  @Test
  @DisplayName("Test setValue(COSBase) with 'COSBase'; when COSArray(); then FDFField() Value List")
  void testSetValueWithCOSBase_whenCOSArray_thenFDFFieldValueList() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    COSArray value = new COSArray();

    // Act
    fdfField.setValue(value);

    // Assert
    Object value2 = fdfField.getValue();
    assertTrue(value2 instanceof List);
    assertTrue(((List<Object>) value2).isEmpty());
    assertSame(value, fdfField.getCOSValue());
  }

  /**
   * Test {@link FDFField#setValue(COSBase)} with {@code COSBase}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link FDFField#FDFField()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setValue(COSBase)}
   */
  @Test
  @DisplayName("Test setValue(COSBase) with 'COSBase'; when COSDictionary(); then FDFField() COSObject Values size is one")
  void testSetValueWithCOSBase_whenCOSDictionary_thenFDFFieldCOSObjectValuesSizeIsOne() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setValue(new COSDictionary());

    // Assert
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#setValue(COSBase)} with {@code COSBase}.
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen
   * is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setValue(COSBase)}
   */
  @Test
  @DisplayName("Test setValue(COSBase) with 'COSBase'; when COSObjectKey(long, int) with num is one and gen is one")
  void testSetValueWithCOSBase_whenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setValue(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Assert
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#setValue(COSBase)} with {@code COSBase}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then {@link FDFField#FDFField()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setValue(COSBase)}
   */
  @Test
  @DisplayName("Test setValue(COSBase) with 'COSBase'; when FALSE; then FDFField() COSObject Values size is one")
  void testSetValueWithCOSBase_whenFalse_thenFDFFieldCOSObjectValuesSizeIsOne() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setValue(COSBoolean.FALSE);

    // Assert
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#setValue(COSBase)} with {@code COSBase}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link FDFField#FDFField()} Value is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setValue(COSBase)}
   */
  @Test
  @DisplayName("Test setValue(COSBase) with 'COSBase'; when 'null'; then FDFField() Value is 'null'")
  void testSetValueWithCOSBase_whenNull_thenFDFFieldValueIsNull() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setValue((COSBase) null);

    // Assert
    assertNull(fdfField.getValue());
    assertNull(fdfField.getCOSValue());
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link FDFField#setValue(Object)} with {@code Object}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then {@link FDFField#FDFField()} COSValue toList size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setValue(Object)}
   */
  @Test
  @DisplayName("Test setValue(Object) with 'Object'; given '42'; then FDFField() COSValue toList size is one")
  void testSetValueWithObject_given42_thenFDFFieldCOSValueToListSizeIsOne() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");

    // Act
    fdfField.setValue(objectList);

    // Assert
    Object value = fdfField.getValue();
    assertTrue(value instanceof List);
    COSBase cOSValue = fdfField.getCOSValue();
    assertTrue(cOSValue instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSValue).toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSString);
    assertEquals("3432", ((COSString) getResult).toHexString());
    assertEquals(1, ((List<String>) value).size());
    assertEquals("42", ((List<String>) value).get(0));
    assertEquals("42", ((COSString) getResult).getASCII());
    assertEquals("42", ((COSString) getResult).getString());
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertFalse(((COSString) getResult).getForceHexForm());
    assertArrayEquals(new byte[]{'4', '2'}, ((COSString) getResult).getBytes());
  }

  /**
   * Test {@link FDFField#setValue(Object)} with {@code Object}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then {@link FDFField#FDFField()} COSValue toList size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setValue(Object)}
   */
  @Test
  @DisplayName("Test setValue(Object) with 'Object'; given '42'; then FDFField() COSValue toList size is two")
  void testSetValueWithObject_given42_thenFDFFieldCOSValueToListSizeIsTwo() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    objectList.add("42");

    // Act
    fdfField.setValue(objectList);

    // Assert
    Object value = fdfField.getValue();
    assertTrue(value instanceof List);
    COSBase cOSValue = fdfField.getCOSValue();
    assertTrue(cOSValue instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSValue).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSString);
    assertEquals(2, ((List<String>) value).size());
    assertEquals("42", ((List<String>) value).get(1));
    assertEquals(toListResult.get(0), getResult);
  }

  /**
   * Test {@link FDFField#setValue(Object)} with {@code Object}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link FDFField#FDFField()} COSValue toList Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setValue(Object)}
   */
  @Test
  @DisplayName("Test setValue(Object) with 'Object'; when ArrayList(); then FDFField() COSValue toList Empty")
  void testSetValueWithObject_whenArrayList_thenFDFFieldCOSValueToListEmpty() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    ArrayList<Object> objectList = new ArrayList<>();

    // Act
    fdfField.setValue(objectList);

    // Assert
    COSBase cOSValue = fdfField.getCOSValue();
    assertTrue(cOSValue instanceof COSArray);
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(((COSArray) cOSValue).toList().isEmpty());
    assertEquals(objectList, fdfField.getValue());
  }

  /**
   * Test {@link FDFField#setValue(Object)} with {@code Object}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link FDFField#FDFField()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setValue(Object)}
   */
  @Test
  @DisplayName("Test setValue(Object) with 'Object'; when COSDictionary(); then FDFField() COSObject Values size is one")
  void testSetValueWithObject_whenCOSDictionary_thenFDFFieldCOSObjectValuesSizeIsOne() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setValue((Object) new COSDictionary());

    // Assert
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#setValue(Object)} with {@code Object}.
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen
   * is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setValue(Object)}
   */
  @Test
  @DisplayName("Test setValue(Object) with 'Object'; when COSObjectKey(long, int) with num is one and gen is one")
  void testSetValueWithObject_whenCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setValue((Object) new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Assert
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#setValue(Object)} with {@code Object}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setValue(Object)}
   */
  @Test
  @DisplayName("Test setValue(Object) with 'Object'; when forty-two; then throw IOException")
  void testSetValueWithObject_whenFortyTwo_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new FDFField()).setValue(42));
  }

  /**
   * Test {@link FDFField#setValue(Object)} with {@code Object}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link FDFField#FDFField()} Value is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setValue(Object)}
   */
  @Test
  @DisplayName("Test setValue(Object) with 'Object'; when 'null'; then FDFField() Value is 'null'")
  void testSetValueWithObject_whenNull_thenFDFFieldValueIsNull() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setValue((Object) null);

    // Assert
    assertNull(fdfField.getValue());
    assertNull(fdfField.getCOSValue());
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link FDFField#setValue(Object)} with {@code Object}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then {@link FDFField#FDFField()} COSValue {@link COSString}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setValue(Object)}
   */
  @Test
  @DisplayName("Test setValue(Object) with 'Object'; when 'Value'; then FDFField() COSValue COSString")
  void testSetValueWithObject_whenValue_thenFDFFieldCOSValueCOSString() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setValue("Value");

    // Assert
    COSBase cOSValue = fdfField.getCOSValue();
    assertTrue(cOSValue instanceof COSString);
    assertEquals("56616C7565", ((COSString) cOSValue).toHexString());
    assertEquals("Value", ((COSString) cOSValue).getASCII());
    assertEquals("Value", ((COSString) cOSValue).getString());
    assertEquals("Value", fdfField.getValue());
    assertNull(cOSValue.getKey());
    assertFalse(cOSValue.isDirect());
    assertFalse(((COSString) cOSValue).getForceHexForm());
    byte[] expectedBytes = "Value".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((COSString) cOSValue).getBytes());
  }

  /**
   * Test {@link FDFField#getFieldFlags()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} FieldFlags is one.</li>
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getFieldFlags()}
   */
  @Test
  @DisplayName("Test getFieldFlags(); given FDFField() FieldFlags is one; then return intValue is one")
  void testGetFieldFlags_givenFDFFieldFieldFlagsIsOne_thenReturnIntValueIsOne() {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setFieldFlags((Integer) 1);

    // Act and Assert
    assertEquals(1, fdfField.getFieldFlags().intValue());
  }

  /**
   * Test {@link FDFField#getFieldFlags()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getFieldFlags()}
   */
  @Test
  @DisplayName("Test getFieldFlags(); given FDFField(); then return 'null'")
  void testGetFieldFlags_givenFDFField_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFField()).getFieldFlags());
  }

  /**
   * Test {@link FDFField#getFieldFlags()}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getFieldFlags()}
   */
  @Test
  @DisplayName("Test getFieldFlags(); given IIOMetadataNode(String) with 'foo'; then return 'null'")
  void testGetFieldFlags_givenIIOMetadataNodeWithFoo_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new FDFField(new IIOMetadataNode("foo"))).getFieldFlags());
  }

  /**
   * Test {@link FDFField#setFieldFlags(int)} with {@code int}.
   * <ul>
   *   <li>When {@code 97427706}.</li>
   *   <li>Then {@link FDFField#FDFField()} FieldFlags intValue is
   * {@code 97427706}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setFieldFlags(int)}
   */
  @Test
  @DisplayName("Test setFieldFlags(int) with 'int'; when '97427706'; then FDFField() FieldFlags intValue is '97427706'")
  void testSetFieldFlagsWithInt_when97427706_thenFDFFieldFieldFlagsIntValueIs97427706() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setFieldFlags(97427706);

    // Assert
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(97427706, fdfField.getFieldFlags().intValue());
  }

  /**
   * Test {@link FDFField#setFieldFlags(int)} with {@code int}.
   * <ul>
   *   <li>When {@code -605232923}.</li>
   *   <li>Then {@link FDFField#FDFField()} FieldFlags intValue is
   * {@code -605232923}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setFieldFlags(int)}
   */
  @Test
  @DisplayName("Test setFieldFlags(int) with 'int'; when '-605232923'; then FDFField() FieldFlags intValue is '-605232923'")
  void testSetFieldFlagsWithInt_when605232923_thenFDFFieldFieldFlagsIntValueIs605232923() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setFieldFlags(-605232923);

    // Assert
    assertEquals(-605232923, fdfField.getFieldFlags().intValue());
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#setFieldFlags(int)} with {@code int}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then {@link FDFField#FDFField()} FieldFlags intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setFieldFlags(int)}
   */
  @Test
  @DisplayName("Test setFieldFlags(int) with 'int'; when one; then FDFField() FieldFlags intValue is one")
  void testSetFieldFlagsWithInt_whenOne_thenFDFFieldFieldFlagsIntValueIsOne() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setFieldFlags(1);

    // Assert
    assertEquals(1, fdfField.getFieldFlags().intValue());
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#setFieldFlags(Integer)} with {@code Integer}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link FDFField#FDFField()} FieldFlags is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setFieldFlags(Integer)}
   */
  @Test
  @DisplayName("Test setFieldFlags(Integer) with 'Integer'; given FDFField(); when 'null'; then FDFField() FieldFlags is 'null'")
  void testSetFieldFlagsWithInteger_givenFDFField_whenNull_thenFDFFieldFieldFlagsIsNull() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setFieldFlags(null);

    // Assert
    assertNull(fdfField.getFieldFlags());
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link FDFField#setFieldFlags(Integer)} with {@code Integer}.
   * <ul>
   *   <li>Then {@link FDFField#FDFField()} FieldFlags intValue is
   * {@code 97427706}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setFieldFlags(Integer)}
   */
  @Test
  @DisplayName("Test setFieldFlags(Integer) with 'Integer'; then FDFField() FieldFlags intValue is '97427706'")
  void testSetFieldFlagsWithInteger_thenFDFFieldFieldFlagsIntValueIs97427706() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setFieldFlags((Integer) 97427706);

    // Assert
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(97427706, fdfField.getFieldFlags().intValue());
  }

  /**
   * Test {@link FDFField#setFieldFlags(Integer)} with {@code Integer}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then {@link FDFField#FDFField()} FieldFlags intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setFieldFlags(Integer)}
   */
  @Test
  @DisplayName("Test setFieldFlags(Integer) with 'Integer'; when one; then FDFField() FieldFlags intValue is one")
  void testSetFieldFlagsWithInteger_whenOne_thenFDFFieldFieldFlagsIntValueIsOne() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setFieldFlags((Integer) 1);

    // Assert
    assertEquals(1, fdfField.getFieldFlags().intValue());
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#getSetFieldFlags()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} SetFieldFlags is one.</li>
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getSetFieldFlags()}
   */
  @Test
  @DisplayName("Test getSetFieldFlags(); given FDFField() SetFieldFlags is one; then return intValue is one")
  void testGetSetFieldFlags_givenFDFFieldSetFieldFlagsIsOne_thenReturnIntValueIsOne() {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setSetFieldFlags((Integer) 1);

    // Act and Assert
    assertEquals(1, fdfField.getSetFieldFlags().intValue());
  }

  /**
   * Test {@link FDFField#getSetFieldFlags()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getSetFieldFlags()}
   */
  @Test
  @DisplayName("Test getSetFieldFlags(); given FDFField(); then return 'null'")
  void testGetSetFieldFlags_givenFDFField_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFField()).getSetFieldFlags());
  }

  /**
   * Test {@link FDFField#getSetFieldFlags()}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getSetFieldFlags()}
   */
  @Test
  @DisplayName("Test getSetFieldFlags(); given IIOMetadataNode(String) with 'foo'; then return 'null'")
  void testGetSetFieldFlags_givenIIOMetadataNodeWithFoo_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new FDFField(new IIOMetadataNode("foo"))).getSetFieldFlags());
  }

  /**
   * Test {@link FDFField#setSetFieldFlags(int)} with {@code int}.
   * <ul>
   *   <li>Then {@link FDFField#FDFField()} SetFieldFlags intValue is
   * {@code 97427706}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setSetFieldFlags(int)}
   */
  @Test
  @DisplayName("Test setSetFieldFlags(int) with 'int'; then FDFField() SetFieldFlags intValue is '97427706'")
  void testSetSetFieldFlagsWithInt_thenFDFFieldSetFieldFlagsIntValueIs97427706() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setSetFieldFlags(97427706);

    // Assert
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(97427706, fdfField.getSetFieldFlags().intValue());
  }

  /**
   * Test {@link FDFField#setSetFieldFlags(int)} with {@code int}.
   * <ul>
   *   <li>Then {@link FDFField#FDFField()} SetFieldFlags intValue is
   * {@code -605232923}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setSetFieldFlags(int)}
   */
  @Test
  @DisplayName("Test setSetFieldFlags(int) with 'int'; then FDFField() SetFieldFlags intValue is '-605232923'")
  void testSetSetFieldFlagsWithInt_thenFDFFieldSetFieldFlagsIntValueIs605232923() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setSetFieldFlags(-605232923);

    // Assert
    assertEquals(-605232923, fdfField.getSetFieldFlags().intValue());
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#setSetFieldFlags(int)} with {@code int}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then {@link FDFField#FDFField()} SetFieldFlags intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setSetFieldFlags(int)}
   */
  @Test
  @DisplayName("Test setSetFieldFlags(int) with 'int'; when one; then FDFField() SetFieldFlags intValue is one")
  void testSetSetFieldFlagsWithInt_whenOne_thenFDFFieldSetFieldFlagsIntValueIsOne() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setSetFieldFlags(1);

    // Assert
    assertEquals(1, fdfField.getSetFieldFlags().intValue());
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#setSetFieldFlags(Integer)} with {@code Integer}.
   * <ul>
   *   <li>Then {@link FDFField#FDFField()} SetFieldFlags intValue is
   * {@code 97427706}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setSetFieldFlags(Integer)}
   */
  @Test
  @DisplayName("Test setSetFieldFlags(Integer) with 'Integer'; then FDFField() SetFieldFlags intValue is '97427706'")
  void testSetSetFieldFlagsWithInteger_thenFDFFieldSetFieldFlagsIntValueIs97427706() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setSetFieldFlags((Integer) 97427706);

    // Assert
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(97427706, fdfField.getSetFieldFlags().intValue());
  }

  /**
   * Test {@link FDFField#setSetFieldFlags(Integer)} with {@code Integer}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link FDFField#FDFField()} SetFieldFlags is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setSetFieldFlags(Integer)}
   */
  @Test
  @DisplayName("Test setSetFieldFlags(Integer) with 'Integer'; when 'null'; then FDFField() SetFieldFlags is 'null'")
  void testSetSetFieldFlagsWithInteger_whenNull_thenFDFFieldSetFieldFlagsIsNull() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setSetFieldFlags(null);

    // Assert
    assertNull(fdfField.getSetFieldFlags());
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link FDFField#setSetFieldFlags(Integer)} with {@code Integer}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then {@link FDFField#FDFField()} SetFieldFlags intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setSetFieldFlags(Integer)}
   */
  @Test
  @DisplayName("Test setSetFieldFlags(Integer) with 'Integer'; when one; then FDFField() SetFieldFlags intValue is one")
  void testSetSetFieldFlagsWithInteger_whenOne_thenFDFFieldSetFieldFlagsIntValueIsOne() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setSetFieldFlags((Integer) 1);

    // Assert
    assertEquals(1, fdfField.getSetFieldFlags().intValue());
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#getClearFieldFlags()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} ClearFieldFlags is one.</li>
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getClearFieldFlags()}
   */
  @Test
  @DisplayName("Test getClearFieldFlags(); given FDFField() ClearFieldFlags is one; then return intValue is one")
  void testGetClearFieldFlags_givenFDFFieldClearFieldFlagsIsOne_thenReturnIntValueIsOne() {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setClearFieldFlags((Integer) 1);

    // Act and Assert
    assertEquals(1, fdfField.getClearFieldFlags().intValue());
  }

  /**
   * Test {@link FDFField#getClearFieldFlags()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getClearFieldFlags()}
   */
  @Test
  @DisplayName("Test getClearFieldFlags(); given FDFField(); then return 'null'")
  void testGetClearFieldFlags_givenFDFField_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFField()).getClearFieldFlags());
  }

  /**
   * Test {@link FDFField#getClearFieldFlags()}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getClearFieldFlags()}
   */
  @Test
  @DisplayName("Test getClearFieldFlags(); given IIOMetadataNode(String) with 'foo'; then return 'null'")
  void testGetClearFieldFlags_givenIIOMetadataNodeWithFoo_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new FDFField(new IIOMetadataNode("foo"))).getClearFieldFlags());
  }

  /**
   * Test {@link FDFField#setClearFieldFlags(int)} with {@code int}.
   * <p>
   * Method under test: {@link FDFField#setClearFieldFlags(int)}
   */
  @Test
  @DisplayName("Test setClearFieldFlags(int) with 'int'")
  void testSetClearFieldFlagsWithInt() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setClearFieldFlags(-100);

    // Assert
    assertEquals(-100, fdfField.getClearFieldFlags().intValue());
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#setClearFieldFlags(int)} with {@code int}.
   * <ul>
   *   <li>Then {@link FDFField#FDFField()} ClearFieldFlags intValue is
   * {@code 97427706}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setClearFieldFlags(int)}
   */
  @Test
  @DisplayName("Test setClearFieldFlags(int) with 'int'; then FDFField() ClearFieldFlags intValue is '97427706'")
  void testSetClearFieldFlagsWithInt_thenFDFFieldClearFieldFlagsIntValueIs97427706() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setClearFieldFlags(97427706);

    // Assert
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(97427706, fdfField.getClearFieldFlags().intValue());
  }

  /**
   * Test {@link FDFField#setClearFieldFlags(int)} with {@code int}.
   * <ul>
   *   <li>Then {@link FDFField#FDFField()} ClearFieldFlags intValue is
   * {@code -605232923}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setClearFieldFlags(int)}
   */
  @Test
  @DisplayName("Test setClearFieldFlags(int) with 'int'; then FDFField() ClearFieldFlags intValue is '-605232923'")
  void testSetClearFieldFlagsWithInt_thenFDFFieldClearFieldFlagsIntValueIs605232923() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setClearFieldFlags(-605232923);

    // Assert
    assertEquals(-605232923, fdfField.getClearFieldFlags().intValue());
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#setClearFieldFlags(int)} with {@code int}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then {@link FDFField#FDFField()} ClearFieldFlags intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setClearFieldFlags(int)}
   */
  @Test
  @DisplayName("Test setClearFieldFlags(int) with 'int'; when one; then FDFField() ClearFieldFlags intValue is one")
  void testSetClearFieldFlagsWithInt_whenOne_thenFDFFieldClearFieldFlagsIntValueIsOne() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setClearFieldFlags(1);

    // Assert
    assertEquals(1, fdfField.getClearFieldFlags().intValue());
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#setClearFieldFlags(Integer)} with {@code Integer}.
   * <ul>
   *   <li>Then {@link FDFField#FDFField()} ClearFieldFlags intValue is
   * {@code 97427706}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setClearFieldFlags(Integer)}
   */
  @Test
  @DisplayName("Test setClearFieldFlags(Integer) with 'Integer'; then FDFField() ClearFieldFlags intValue is '97427706'")
  void testSetClearFieldFlagsWithInteger_thenFDFFieldClearFieldFlagsIntValueIs97427706() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setClearFieldFlags((Integer) 97427706);

    // Assert
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(97427706, fdfField.getClearFieldFlags().intValue());
  }

  /**
   * Test {@link FDFField#setClearFieldFlags(Integer)} with {@code Integer}.
   * <ul>
   *   <li>Then {@link FDFField#FDFField()} ClearFieldFlags intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setClearFieldFlags(Integer)}
   */
  @Test
  @DisplayName("Test setClearFieldFlags(Integer) with 'Integer'; then FDFField() ClearFieldFlags intValue is one")
  void testSetClearFieldFlagsWithInteger_thenFDFFieldClearFieldFlagsIntValueIsOne() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setClearFieldFlags((Integer) 1);

    // Assert
    assertEquals(1, fdfField.getClearFieldFlags().intValue());
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#setClearFieldFlags(Integer)} with {@code Integer}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link FDFField#FDFField()} ClearFieldFlags is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setClearFieldFlags(Integer)}
   */
  @Test
  @DisplayName("Test setClearFieldFlags(Integer) with 'Integer'; when 'null'; then FDFField() ClearFieldFlags is 'null'")
  void testSetClearFieldFlagsWithInteger_whenNull_thenFDFFieldClearFieldFlagsIsNull() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setClearFieldFlags(null);

    // Assert
    assertNull(fdfField.getClearFieldFlags());
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link FDFField#getWidgetFieldFlags()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getWidgetFieldFlags()}
   */
  @Test
  @DisplayName("Test getWidgetFieldFlags(); given FDFField(); then return 'null'")
  void testGetWidgetFieldFlags_givenFDFField_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFField()).getWidgetFieldFlags());
  }

  /**
   * Test {@link FDFField#getWidgetFieldFlags()}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getWidgetFieldFlags()}
   */
  @Test
  @DisplayName("Test getWidgetFieldFlags(); given IIOMetadataNode(String) with 'foo'; then return 'null'")
  void testGetWidgetFieldFlags_givenIIOMetadataNodeWithFoo_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new FDFField(new IIOMetadataNode("foo"))).getWidgetFieldFlags());
  }

  /**
   * Test {@link FDFField#getWidgetFieldFlags()}.
   * <ul>
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getWidgetFieldFlags()}
   */
  @Test
  @DisplayName("Test getWidgetFieldFlags(); then return intValue is one")
  void testGetWidgetFieldFlags_thenReturnIntValueIsOne() {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setWidgetFieldFlags((Integer) 1);

    // Act and Assert
    assertEquals(1, fdfField.getWidgetFieldFlags().intValue());
  }

  /**
   * Test {@link FDFField#setWidgetFieldFlags(int)} with {@code int}.
   * <ul>
   *   <li>Then {@link FDFField#FDFField()} WidgetFieldFlags intValue is
   * {@code 97427706}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setWidgetFieldFlags(int)}
   */
  @Test
  @DisplayName("Test setWidgetFieldFlags(int) with 'int'; then FDFField() WidgetFieldFlags intValue is '97427706'")
  void testSetWidgetFieldFlagsWithInt_thenFDFFieldWidgetFieldFlagsIntValueIs97427706() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setWidgetFieldFlags(97427706);

    // Assert
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(97427706, fdfField.getWidgetFieldFlags().intValue());
  }

  /**
   * Test {@link FDFField#setWidgetFieldFlags(int)} with {@code int}.
   * <ul>
   *   <li>Then {@link FDFField#FDFField()} WidgetFieldFlags intValue is
   * {@code -605232923}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setWidgetFieldFlags(int)}
   */
  @Test
  @DisplayName("Test setWidgetFieldFlags(int) with 'int'; then FDFField() WidgetFieldFlags intValue is '-605232923'")
  void testSetWidgetFieldFlagsWithInt_thenFDFFieldWidgetFieldFlagsIntValueIs605232923() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setWidgetFieldFlags(-605232923);

    // Assert
    assertEquals(-605232923, fdfField.getWidgetFieldFlags().intValue());
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#setWidgetFieldFlags(int)} with {@code int}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then {@link FDFField#FDFField()} WidgetFieldFlags intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setWidgetFieldFlags(int)}
   */
  @Test
  @DisplayName("Test setWidgetFieldFlags(int) with 'int'; when one; then FDFField() WidgetFieldFlags intValue is one")
  void testSetWidgetFieldFlagsWithInt_whenOne_thenFDFFieldWidgetFieldFlagsIntValueIsOne() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setWidgetFieldFlags(1);

    // Assert
    assertEquals(1, fdfField.getWidgetFieldFlags().intValue());
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#setWidgetFieldFlags(Integer)} with {@code Integer}.
   * <p>
   * Method under test: {@link FDFField#setWidgetFieldFlags(Integer)}
   */
  @Test
  @DisplayName("Test setWidgetFieldFlags(Integer) with 'Integer'")
  void testSetWidgetFieldFlagsWithInteger() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setWidgetFieldFlags((Integer) 97427706);

    // Assert
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(97427706, fdfField.getWidgetFieldFlags().intValue());
  }

  /**
   * Test {@link FDFField#setWidgetFieldFlags(Integer)} with {@code Integer}.
   * <ul>
   *   <li>Then {@link FDFField#FDFField()} WidgetFieldFlags intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setWidgetFieldFlags(Integer)}
   */
  @Test
  @DisplayName("Test setWidgetFieldFlags(Integer) with 'Integer'; then FDFField() WidgetFieldFlags intValue is one")
  void testSetWidgetFieldFlagsWithInteger_thenFDFFieldWidgetFieldFlagsIntValueIsOne() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setWidgetFieldFlags((Integer) 1);

    // Assert
    assertEquals(1, fdfField.getWidgetFieldFlags().intValue());
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#setWidgetFieldFlags(Integer)} with {@code Integer}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link FDFField#FDFField()} WidgetFieldFlags is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setWidgetFieldFlags(Integer)}
   */
  @Test
  @DisplayName("Test setWidgetFieldFlags(Integer) with 'Integer'; when 'null'; then FDFField() WidgetFieldFlags is 'null'")
  void testSetWidgetFieldFlagsWithInteger_whenNull_thenFDFFieldWidgetFieldFlagsIsNull() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setWidgetFieldFlags(null);

    // Assert
    assertNull(fdfField.getWidgetFieldFlags());
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link FDFField#getSetWidgetFieldFlags()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getSetWidgetFieldFlags()}
   */
  @Test
  @DisplayName("Test getSetWidgetFieldFlags(); given FDFField(); then return 'null'")
  void testGetSetWidgetFieldFlags_givenFDFField_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFField()).getSetWidgetFieldFlags());
  }

  /**
   * Test {@link FDFField#getSetWidgetFieldFlags()}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getSetWidgetFieldFlags()}
   */
  @Test
  @DisplayName("Test getSetWidgetFieldFlags(); given IIOMetadataNode(String) with 'foo'; then return 'null'")
  void testGetSetWidgetFieldFlags_givenIIOMetadataNodeWithFoo_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new FDFField(new IIOMetadataNode("foo"))).getSetWidgetFieldFlags());
  }

  /**
   * Test {@link FDFField#getSetWidgetFieldFlags()}.
   * <ul>
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getSetWidgetFieldFlags()}
   */
  @Test
  @DisplayName("Test getSetWidgetFieldFlags(); then return intValue is one")
  void testGetSetWidgetFieldFlags_thenReturnIntValueIsOne() {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setSetWidgetFieldFlags((Integer) 1);

    // Act and Assert
    assertEquals(1, fdfField.getSetWidgetFieldFlags().intValue());
  }

  /**
   * Test {@link FDFField#setSetWidgetFieldFlags(int)} with {@code int}.
   * <p>
   * Method under test: {@link FDFField#setSetWidgetFieldFlags(int)}
   */
  @Test
  @DisplayName("Test setSetWidgetFieldFlags(int) with 'int'")
  void testSetSetWidgetFieldFlagsWithInt() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setSetWidgetFieldFlags(-605232923);

    // Assert
    assertEquals(-605232923, fdfField.getSetWidgetFieldFlags().intValue());
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#setSetWidgetFieldFlags(int)} with {@code int}.
   * <p>
   * Method under test: {@link FDFField#setSetWidgetFieldFlags(int)}
   */
  @Test
  @DisplayName("Test setSetWidgetFieldFlags(int) with 'int'")
  void testSetSetWidgetFieldFlagsWithInt2() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setSetWidgetFieldFlags(97427706);

    // Assert
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(97427706, fdfField.getSetWidgetFieldFlags().intValue());
  }

  /**
   * Test {@link FDFField#setSetWidgetFieldFlags(int)} with {@code int}.
   * <ul>
   *   <li>Then {@link FDFField#FDFField()} SetWidgetFieldFlags intValue is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setSetWidgetFieldFlags(int)}
   */
  @Test
  @DisplayName("Test setSetWidgetFieldFlags(int) with 'int'; then FDFField() SetWidgetFieldFlags intValue is one")
  void testSetSetWidgetFieldFlagsWithInt_thenFDFFieldSetWidgetFieldFlagsIntValueIsOne() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setSetWidgetFieldFlags(1);

    // Assert
    assertEquals(1, fdfField.getSetWidgetFieldFlags().intValue());
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#setSetWidgetFieldFlags(Integer)} with {@code Integer}.
   * <p>
   * Method under test: {@link FDFField#setSetWidgetFieldFlags(Integer)}
   */
  @Test
  @DisplayName("Test setSetWidgetFieldFlags(Integer) with 'Integer'")
  void testSetSetWidgetFieldFlagsWithInteger() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setSetWidgetFieldFlags((Integer) 1);

    // Assert
    assertEquals(1, fdfField.getSetWidgetFieldFlags().intValue());
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#setSetWidgetFieldFlags(Integer)} with {@code Integer}.
   * <p>
   * Method under test: {@link FDFField#setSetWidgetFieldFlags(Integer)}
   */
  @Test
  @DisplayName("Test setSetWidgetFieldFlags(Integer) with 'Integer'")
  void testSetSetWidgetFieldFlagsWithInteger2() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setSetWidgetFieldFlags((Integer) 97427706);

    // Assert
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(97427706, fdfField.getSetWidgetFieldFlags().intValue());
  }

  /**
   * Test {@link FDFField#setSetWidgetFieldFlags(Integer)} with {@code Integer}.
   * <ul>
   *   <li>Then {@link FDFField#FDFField()} SetWidgetFieldFlags is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setSetWidgetFieldFlags(Integer)}
   */
  @Test
  @DisplayName("Test setSetWidgetFieldFlags(Integer) with 'Integer'; then FDFField() SetWidgetFieldFlags is 'null'")
  void testSetSetWidgetFieldFlagsWithInteger_thenFDFFieldSetWidgetFieldFlagsIsNull() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setSetWidgetFieldFlags(null);

    // Assert
    assertNull(fdfField.getSetWidgetFieldFlags());
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link FDFField#getClearWidgetFieldFlags()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getClearWidgetFieldFlags()}
   */
  @Test
  @DisplayName("Test getClearWidgetFieldFlags(); given FDFField(); then return 'null'")
  void testGetClearWidgetFieldFlags_givenFDFField_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFField()).getClearWidgetFieldFlags());
  }

  /**
   * Test {@link FDFField#getClearWidgetFieldFlags()}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getClearWidgetFieldFlags()}
   */
  @Test
  @DisplayName("Test getClearWidgetFieldFlags(); given IIOMetadataNode(String) with 'foo'; then return 'null'")
  void testGetClearWidgetFieldFlags_givenIIOMetadataNodeWithFoo_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new FDFField(new IIOMetadataNode("foo"))).getClearWidgetFieldFlags());
  }

  /**
   * Test {@link FDFField#getClearWidgetFieldFlags()}.
   * <ul>
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getClearWidgetFieldFlags()}
   */
  @Test
  @DisplayName("Test getClearWidgetFieldFlags(); then return intValue is one")
  void testGetClearWidgetFieldFlags_thenReturnIntValueIsOne() {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setClearWidgetFieldFlags((Integer) 1);

    // Act and Assert
    assertEquals(1, fdfField.getClearWidgetFieldFlags().intValue());
  }

  /**
   * Test {@link FDFField#setClearWidgetFieldFlags(int)} with {@code int}.
   * <p>
   * Method under test: {@link FDFField#setClearWidgetFieldFlags(int)}
   */
  @Test
  @DisplayName("Test setClearWidgetFieldFlags(int) with 'int'")
  void testSetClearWidgetFieldFlagsWithInt() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setClearWidgetFieldFlags(1);

    // Assert
    assertEquals(1, fdfField.getClearWidgetFieldFlags().intValue());
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#setClearWidgetFieldFlags(int)} with {@code int}.
   * <p>
   * Method under test: {@link FDFField#setClearWidgetFieldFlags(int)}
   */
  @Test
  @DisplayName("Test setClearWidgetFieldFlags(int) with 'int'")
  void testSetClearWidgetFieldFlagsWithInt2() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setClearWidgetFieldFlags(-605232923);

    // Assert
    assertEquals(-605232923, fdfField.getClearWidgetFieldFlags().intValue());
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#setClearWidgetFieldFlags(int)} with {@code int}.
   * <p>
   * Method under test: {@link FDFField#setClearWidgetFieldFlags(int)}
   */
  @Test
  @DisplayName("Test setClearWidgetFieldFlags(int) with 'int'")
  void testSetClearWidgetFieldFlagsWithInt3() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setClearWidgetFieldFlags(97427706);

    // Assert
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(97427706, fdfField.getClearWidgetFieldFlags().intValue());
  }

  /**
   * Test {@link FDFField#setClearWidgetFieldFlags(Integer)} with {@code Integer}.
   * <p>
   * Method under test: {@link FDFField#setClearWidgetFieldFlags(Integer)}
   */
  @Test
  @DisplayName("Test setClearWidgetFieldFlags(Integer) with 'Integer'")
  void testSetClearWidgetFieldFlagsWithInteger() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setClearWidgetFieldFlags((Integer) 1);

    // Assert
    assertEquals(1, fdfField.getClearWidgetFieldFlags().intValue());
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#setClearWidgetFieldFlags(Integer)} with {@code Integer}.
   * <p>
   * Method under test: {@link FDFField#setClearWidgetFieldFlags(Integer)}
   */
  @Test
  @DisplayName("Test setClearWidgetFieldFlags(Integer) with 'Integer'")
  void testSetClearWidgetFieldFlagsWithInteger2() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setClearWidgetFieldFlags((Integer) 97427706);

    // Assert
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(97427706, fdfField.getClearWidgetFieldFlags().intValue());
  }

  /**
   * Test {@link FDFField#setClearWidgetFieldFlags(Integer)} with {@code Integer}.
   * <ul>
   *   <li>Then {@link FDFField#FDFField()} ClearWidgetFieldFlags is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setClearWidgetFieldFlags(Integer)}
   */
  @Test
  @DisplayName("Test setClearWidgetFieldFlags(Integer) with 'Integer'; then FDFField() ClearWidgetFieldFlags is 'null'")
  void testSetClearWidgetFieldFlagsWithInteger_thenFDFFieldClearWidgetFieldFlagsIsNull() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setClearWidgetFieldFlags(null);

    // Assert
    assertNull(fdfField.getClearWidgetFieldFlags());
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link FDFField#getAppearanceDictionary()}.
   * <p>
   * Method under test: {@link FDFField#getAppearanceDictionary()}
   */
  @Test
  @DisplayName("Test getAppearanceDictionary()")
  void testGetAppearanceDictionary() {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setAppearanceDictionary(new PDAppearanceDictionary());

    // Act
    PDAppearanceDictionary actualAppearanceDictionary = fdfField.getAppearanceDictionary();

    // Assert
    COSDictionary cOSObject = actualAppearanceDictionary.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    PDAppearanceEntry downAppearance = actualAppearanceDictionary.getDownAppearance();
    COSDictionary cOSObject2 = downAppearance.getCOSObject();
    COSUpdateState updateState2 = cOSObject2.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(cOSObject2.getKey());
    assertEquals(0, cOSObject2.size());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject2.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertFalse(downAppearance.isStream());
    PDAppearanceEntry normalAppearance = actualAppearanceDictionary.getNormalAppearance();
    assertFalse(normalAppearance.isStream());
    PDAppearanceEntry rolloverAppearance = actualAppearanceDictionary.getRolloverAppearance();
    assertFalse(rolloverAppearance.isStream());
    assertTrue(cOSObject2.getValues().isEmpty());
    assertTrue(downAppearance.getSubDictionary().isEmpty());
    assertTrue(normalAppearance.getSubDictionary().isEmpty());
    assertTrue(rolloverAppearance.getSubDictionary().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(downAppearance.isSubDictionary());
    assertTrue(normalAppearance.isSubDictionary());
    assertTrue(rolloverAppearance.isSubDictionary());
    assertSame(cOSObject2, normalAppearance.getCOSObject());
    assertSame(cOSObject2, rolloverAppearance.getCOSObject());
  }

  /**
   * Test {@link FDFField#getAppearanceDictionary()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getAppearanceDictionary()}
   */
  @Test
  @DisplayName("Test getAppearanceDictionary(); given FDFField(); then return 'null'")
  void testGetAppearanceDictionary_givenFDFField_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFField()).getAppearanceDictionary());
  }

  /**
   * Test {@link FDFField#getAppearanceDictionary()}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getAppearanceDictionary()}
   */
  @Test
  @DisplayName("Test getAppearanceDictionary(); given IIOMetadataNode(String) with 'foo'; then return 'null'")
  void testGetAppearanceDictionary_givenIIOMetadataNodeWithFoo_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new FDFField(new IIOMetadataNode("foo"))).getAppearanceDictionary());
  }

  /**
   * Test {@link FDFField#setAppearanceDictionary(PDAppearanceDictionary)}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()}.</li>
   *   <li>Then {@link FDFField#FDFField()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FDFField#setAppearanceDictionary(PDAppearanceDictionary)}
   */
  @Test
  @DisplayName("Test setAppearanceDictionary(PDAppearanceDictionary); given FDFField(); then FDFField() COSObject Values size is one")
  void testSetAppearanceDictionary_givenFDFField_thenFDFFieldCOSObjectValuesSizeIsOne() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setAppearanceDictionary(new PDAppearanceDictionary());

    // Assert
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    PDAppearanceDictionary appearanceDictionary = fdfField.getAppearanceDictionary();
    PDAppearanceEntry downAppearance = appearanceDictionary.getDownAppearance();
    assertFalse(downAppearance.isStream());
    PDAppearanceEntry normalAppearance = appearanceDictionary.getNormalAppearance();
    assertFalse(normalAppearance.isStream());
    PDAppearanceEntry rolloverAppearance = appearanceDictionary.getRolloverAppearance();
    assertFalse(rolloverAppearance.isStream());
    assertTrue(downAppearance.getSubDictionary().isEmpty());
    assertTrue(normalAppearance.getSubDictionary().isEmpty());
    assertTrue(rolloverAppearance.getSubDictionary().isEmpty());
    assertTrue(downAppearance.isSubDictionary());
    assertTrue(normalAppearance.isSubDictionary());
    assertTrue(rolloverAppearance.isSubDictionary());
  }

  /**
   * Test {@link FDFField#setAppearanceDictionary(PDAppearanceDictionary)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link FDFField#FDFField()} COSObject size is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FDFField#setAppearanceDictionary(PDAppearanceDictionary)}
   */
  @Test
  @DisplayName("Test setAppearanceDictionary(PDAppearanceDictionary); when 'null'; then FDFField() COSObject size is zero")
  void testSetAppearanceDictionary_whenNull_thenFDFFieldCOSObjectSizeIsZero() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setAppearanceDictionary(null);

    // Assert
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link FDFField#getAppearanceStreamReference()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getAppearanceStreamReference()}
   */
  @Test
  @DisplayName("Test getAppearanceStreamReference(); given FDFField(); then return 'null'")
  void testGetAppearanceStreamReference_givenFDFField_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFField()).getAppearanceStreamReference());
  }

  /**
   * Test {@link FDFField#getAppearanceStreamReference()}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getAppearanceStreamReference()}
   */
  @Test
  @DisplayName("Test getAppearanceStreamReference(); given IIOMetadataNode(String) with 'foo'; then return 'null'")
  void testGetAppearanceStreamReference_givenIIOMetadataNodeWithFoo_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new FDFField(new IIOMetadataNode("foo"))).getAppearanceStreamReference());
  }

  /**
   * Test {@link FDFField#getAppearanceStreamReference()}.
   * <ul>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getAppearanceStreamReference()}
   */
  @Test
  @DisplayName("Test getAppearanceStreamReference(); then return Name is 'null'")
  void testGetAppearanceStreamReference_thenReturnNameIsNull() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setAppearanceStreamReference(new FDFNamedPageReference());

    // Act
    FDFNamedPageReference actualAppearanceStreamReference = fdfField.getAppearanceStreamReference();

    // Assert
    assertNull(actualAppearanceStreamReference.getName());
    COSDictionary cOSObject = actualAppearanceStreamReference.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualAppearanceStreamReference.getFileSpecification());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link FDFField#setAppearanceStreamReference(FDFNamedPageReference)}.
   * <ul>
   *   <li>Then {@link FDFField#FDFField()} AppearanceStreamReference Name is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FDFField#setAppearanceStreamReference(FDFNamedPageReference)}
   */
  @Test
  @DisplayName("Test setAppearanceStreamReference(FDFNamedPageReference); then FDFField() AppearanceStreamReference Name is 'null'")
  void testSetAppearanceStreamReference_thenFDFFieldAppearanceStreamReferenceNameIsNull() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setAppearanceStreamReference(new FDFNamedPageReference());

    // Assert
    FDFNamedPageReference appearanceStreamReference = fdfField.getAppearanceStreamReference();
    assertNull(appearanceStreamReference.getName());
    assertNull(appearanceStreamReference.getFileSpecification());
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#setAppearanceStreamReference(FDFNamedPageReference)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link FDFField#FDFField()} COSObject size is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FDFField#setAppearanceStreamReference(FDFNamedPageReference)}
   */
  @Test
  @DisplayName("Test setAppearanceStreamReference(FDFNamedPageReference); when 'null'; then FDFField() COSObject size is zero")
  void testSetAppearanceStreamReference_whenNull_thenFDFFieldCOSObjectSizeIsZero() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setAppearanceStreamReference(null);

    // Assert
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link FDFField#getIconFit()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getIconFit()}
   */
  @Test
  @DisplayName("Test getIconFit(); given FDFField(); then return 'null'")
  void testGetIconFit_givenFDFField_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFField()).getIconFit());
  }

  /**
   * Test {@link FDFField#getIconFit()}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getIconFit()}
   */
  @Test
  @DisplayName("Test getIconFit(); given IIOMetadataNode(String) with 'foo'; then return 'null'")
  void testGetIconFit_givenIIOMetadataNodeWithFoo_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new FDFField(new IIOMetadataNode("foo"))).getIconFit());
  }

  /**
   * Test {@link FDFField#getIconFit()}.
   * <ul>
   *   <li>Then return FractionalSpaceToAllocate COSArray toList size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getIconFit()}
   */
  @Test
  @DisplayName("Test getIconFit(); then return FractionalSpaceToAllocate COSArray toList size is two")
  void testGetIconFit_thenReturnFractionalSpaceToAllocateCOSArrayToListSizeIsTwo() {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setIconFit(new FDFIconFit());

    // Act
    FDFIconFit actualIconFit = fdfField.getIconFit();

    // Assert
    PDRange fractionalSpaceToAllocate = actualIconFit.getFractionalSpaceToAllocate();
    COSArray cOSArray = fractionalSpaceToAllocate.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSDictionary cOSObject = actualIconFit.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(getResult.getKey());
    assertNull(cOSObject.getKey());
    assertEquals(0.5f, fractionalSpaceToAllocate.getMax());
    assertEquals(0.5f, fractionalSpaceToAllocate.getMin());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(FDFIconFit.SCALE_OPTION_ALWAYS, actualIconFit.getScaleOption());
    assertEquals(FDFIconFit.SCALE_TYPE_PROPORTIONAL, actualIconFit.getScaleType());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, fractionalSpaceToAllocate.getCOSObject());
  }

  /**
   * Test {@link FDFField#setIconFit(FDFIconFit)}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()}.</li>
   *   <li>Then {@link FDFField#FDFField()} IconFit FractionalSpaceToAllocate Max is
   * {@code 0.5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setIconFit(FDFIconFit)}
   */
  @Test
  @DisplayName("Test setIconFit(FDFIconFit); given FDFField(); then FDFField() IconFit FractionalSpaceToAllocate Max is '0.5'")
  void testSetIconFit_givenFDFField_thenFDFFieldIconFitFractionalSpaceToAllocateMaxIs05() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setIconFit(new FDFIconFit());

    // Assert
    FDFIconFit iconFit = fdfField.getIconFit();
    PDRange fractionalSpaceToAllocate = iconFit.getFractionalSpaceToAllocate();
    assertEquals(0.5f, fractionalSpaceToAllocate.getMax());
    assertEquals(0.5f, fractionalSpaceToAllocate.getMin());
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(FDFIconFit.SCALE_OPTION_ALWAYS, iconFit.getScaleOption());
    assertEquals(FDFIconFit.SCALE_TYPE_PROPORTIONAL, iconFit.getScaleType());
  }

  /**
   * Test {@link FDFField#setIconFit(FDFIconFit)}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link FDFField#FDFField()} COSObject size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setIconFit(FDFIconFit)}
   */
  @Test
  @DisplayName("Test setIconFit(FDFIconFit); given FDFField(); when 'null'; then FDFField() COSObject size is zero")
  void testSetIconFit_givenFDFField_whenNull_thenFDFFieldCOSObjectSizeIsZero() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setIconFit(null);

    // Assert
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link FDFField#getOptions()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return first is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getOptions()}
   */
  @Test
  @DisplayName("Test getOptions(); given ArrayList() add '42'; then return first is '42'")
  void testGetOptions_givenArrayListAdd42_thenReturnFirstIs42() {
    // Arrange
    ArrayList<Object> options = new ArrayList<>();
    options.add("42");

    FDFField fdfField = new FDFField();
    fdfField.setOptions(options);

    // Act
    List<Object> actualOptions = fdfField.getOptions();

    // Assert
    assertEquals(1, actualOptions.size());
    assertEquals("42", actualOptions.get(0));
  }

  /**
   * Test {@link FDFField#getOptions()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link COSArray#COSArray()}.</li>
   *   <li>Then return first COSArray toList Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getOptions()}
   */
  @Test
  @DisplayName("Test getOptions(); given ArrayList() add COSArray(); then return first COSArray toList Empty")
  void testGetOptions_givenArrayListAddCOSArray_thenReturnFirstCOSArrayToListEmpty() {
    // Arrange
    ArrayList<Object> options = new ArrayList<>();
    COSArray cosArray = new COSArray();
    options.add(cosArray);

    FDFField fdfField = new FDFField();
    fdfField.setOptions(options);

    // Act
    List<Object> actualOptions = fdfField.getOptions();

    // Assert
    assertEquals(1, actualOptions.size());
    Object getResult = actualOptions.get(0);
    assertTrue(getResult instanceof FDFOptionElement);
    COSArray cOSArray = ((FDFOptionElement) getResult).getCOSArray();
    assertTrue(cOSArray.toList().isEmpty());
    assertSame(cosArray, cOSArray);
    assertSame(cosArray, ((FDFOptionElement) getResult).getCOSObject());
  }

  /**
   * Test {@link FDFField#getOptions()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then return first COSArray is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getOptions()}
   */
  @Test
  @DisplayName("Test getOptions(); given ArrayList() add 'null'; then return first COSArray is 'null'")
  void testGetOptions_givenArrayListAddNull_thenReturnFirstCOSArrayIsNull() {
    // Arrange
    ArrayList<Object> options = new ArrayList<>();
    options.add(null);

    FDFField fdfField = new FDFField();
    fdfField.setOptions(options);

    // Act
    List<Object> actualOptions = fdfField.getOptions();

    // Assert
    assertEquals(1, actualOptions.size());
    Object getResult = actualOptions.get(0);
    assertTrue(getResult instanceof FDFOptionElement);
    assertNull(((FDFOptionElement) getResult).getCOSArray());
    assertNull(((FDFOptionElement) getResult).getCOSObject());
  }

  /**
   * Test {@link FDFField#getOptions()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Options is
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getOptions()}
   */
  @Test
  @DisplayName("Test getOptions(); given FDFField() Options is ArrayList(); then return Empty")
  void testGetOptions_givenFDFFieldOptionsIsArrayList_thenReturnEmpty() {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setOptions(new ArrayList<>());

    // Act and Assert
    assertTrue(fdfField.getOptions().isEmpty());
  }

  /**
   * Test {@link FDFField#getOptions()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getOptions()}
   */
  @Test
  @DisplayName("Test getOptions(); given FDFField(); then return 'null'")
  void testGetOptions_givenFDFField_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFField()).getOptions());
  }

  /**
   * Test {@link FDFField#getOptions()}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getOptions()}
   */
  @Test
  @DisplayName("Test getOptions(); given IIOMetadataNode(String) with 'foo'; then return 'null'")
  void testGetOptions_givenIIOMetadataNodeWithFoo_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new FDFField(new IIOMetadataNode("foo"))).getOptions());
  }

  /**
   * Test {@link FDFField#setOptions(List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then {@link FDFField#FDFField()} Options is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setOptions(List)}
   */
  @Test
  @DisplayName("Test setOptions(List); given '42'; when ArrayList() add '42'; then FDFField() Options is ArrayList()")
  void testSetOptions_given42_whenArrayListAdd42_thenFDFFieldOptionsIsArrayList() {
    // Arrange
    FDFField fdfField = new FDFField();

    ArrayList<Object> options = new ArrayList<>();
    options.add("42");

    // Act
    fdfField.setOptions(options);

    // Assert
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(options, fdfField.getOptions());
  }

  /**
   * Test {@link FDFField#setOptions(List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then {@link FDFField#FDFField()} Options is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setOptions(List)}
   */
  @Test
  @DisplayName("Test setOptions(List); given '42'; when ArrayList() add '42'; then FDFField() Options is ArrayList()")
  void testSetOptions_given42_whenArrayListAdd42_thenFDFFieldOptionsIsArrayList2() {
    // Arrange
    FDFField fdfField = new FDFField();

    ArrayList<Object> options = new ArrayList<>();
    options.add("42");
    options.add("42");

    // Act
    fdfField.setOptions(options);

    // Assert
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(options, fdfField.getOptions());
  }

  /**
   * Test {@link FDFField#setOptions(List)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.</li>
   *   <li>Then {@link FDFField#FDFField()} Options first COSArray is
   * {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setOptions(List)}
   */
  @Test
  @DisplayName("Test setOptions(List); given COSArray(); then FDFField() Options first COSArray is COSArray()")
  void testSetOptions_givenCOSArray_thenFDFFieldOptionsFirstCOSArrayIsCOSArray() {
    // Arrange
    FDFField fdfField = new FDFField();

    ArrayList<Object> options = new ArrayList<>();
    COSArray cosArray = new COSArray();
    options.add(cosArray);

    // Act
    fdfField.setOptions(options);

    // Assert
    List<Object> options2 = fdfField.getOptions();
    assertEquals(1, options2.size());
    Object getResult = options2.get(0);
    assertTrue(getResult instanceof FDFOptionElement);
    assertSame(cosArray, ((FDFOptionElement) getResult).getCOSArray());
    assertSame(cosArray, ((FDFOptionElement) getResult).getCOSObject());
  }

  /**
   * Test {@link FDFField#setOptions(List)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setOptions(List)}
   */
  @Test
  @DisplayName("Test setOptions(List); given COSDictionary(); when ArrayList() add COSDictionary()")
  void testSetOptions_givenCOSDictionary_whenArrayListAddCOSDictionary() {
    // Arrange
    FDFField fdfField = new FDFField();

    ArrayList<Object> options = new ArrayList<>();
    options.add(new COSDictionary());

    // Act
    fdfField.setOptions(options);

    // Assert
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#setOptions(List)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setOptions(List)}
   */
  @Test
  @DisplayName("Test setOptions(List); given COSObjectKey(long, int) with num is one and gen is one")
  void testSetOptions_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    FDFField fdfField = new FDFField();

    ArrayList<Object> options = new ArrayList<>();
    options.add(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Act
    fdfField.setOptions(options);

    // Assert
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#setOptions(List)}.
   * <ul>
   *   <li>Given five.</li>
   *   <li>When {@link ArrayList#ArrayList()} add five.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setOptions(List)}
   */
  @Test
  @DisplayName("Test setOptions(List); given five; when ArrayList() add five")
  void testSetOptions_givenFive_whenArrayListAddFive() {
    // Arrange
    FDFField fdfField = new FDFField();

    ArrayList<Object> options = new ArrayList<>();
    options.add(5);

    // Act
    fdfField.setOptions(options);

    // Assert
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#setOptions(List)}.
   * <ul>
   *   <li>Given {@link Long#MAX_VALUE}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link Long#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setOptions(List)}
   */
  @Test
  @DisplayName("Test setOptions(List); given MAX_VALUE; when ArrayList() add MAX_VALUE")
  void testSetOptions_givenMax_value_whenArrayListAddMax_value() {
    // Arrange
    FDFField fdfField = new FDFField();

    ArrayList<Object> options = new ArrayList<>();
    options.add(Long.MAX_VALUE);

    // Act
    fdfField.setOptions(options);

    // Assert
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#setOptions(List)}.
   * <ul>
   *   <li>Given {@link Integer#MIN_VALUE}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setOptions(List)}
   */
  @Test
  @DisplayName("Test setOptions(List); given MIN_VALUE; when ArrayList() add MIN_VALUE")
  void testSetOptions_givenMin_value_whenArrayListAddMin_value() {
    // Arrange
    FDFField fdfField = new FDFField();

    ArrayList<Object> options = new ArrayList<>();
    options.add(Integer.MIN_VALUE);

    // Act
    fdfField.setOptions(options);

    // Assert
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#setOptions(List)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then {@link FDFField#FDFField()} Options first COSArray is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setOptions(List)}
   */
  @Test
  @DisplayName("Test setOptions(List); given 'null'; then FDFField() Options first COSArray is 'null'")
  void testSetOptions_givenNull_thenFDFFieldOptionsFirstCOSArrayIsNull() {
    // Arrange
    FDFField fdfField = new FDFField();

    ArrayList<Object> options = new ArrayList<>();
    options.add(null);

    // Act
    fdfField.setOptions(options);

    // Assert
    List<Object> options2 = fdfField.getOptions();
    assertEquals(1, options2.size());
    Object getResult = options2.get(0);
    assertTrue(getResult instanceof FDFOptionElement);
    assertNull(((FDFOptionElement) getResult).getCOSArray());
    assertNull(((FDFOptionElement) getResult).getCOSObject());
  }

  /**
   * Test {@link FDFField#setOptions(List)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link ArrayList#ArrayList()} add one.</li>
   *   <li>Then {@link FDFField#FDFField()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setOptions(List)}
   */
  @Test
  @DisplayName("Test setOptions(List); given one; when ArrayList() add one; then FDFField() COSObject Values size is one")
  void testSetOptions_givenOne_whenArrayListAddOne_thenFDFFieldCOSObjectValuesSizeIsOne() {
    // Arrange
    FDFField fdfField = new FDFField();

    ArrayList<Object> options = new ArrayList<>();
    options.add(1L);

    // Act
    fdfField.setOptions(options);

    // Assert
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#setOptions(List)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>When {@link ArrayList#ArrayList()} add ten.</li>
   *   <li>Then {@link FDFField#FDFField()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setOptions(List)}
   */
  @Test
  @DisplayName("Test setOptions(List); given ten; when ArrayList() add ten; then FDFField() COSObject Values size is one")
  void testSetOptions_givenTen_whenArrayListAddTen_thenFDFFieldCOSObjectValuesSizeIsOne() {
    // Arrange
    FDFField fdfField = new FDFField();

    ArrayList<Object> options = new ArrayList<>();
    options.add(10.0d);

    // Act
    fdfField.setOptions(options);

    // Assert
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#setOptions(List)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>When {@link ArrayList#ArrayList()} add ten.</li>
   *   <li>Then {@link FDFField#FDFField()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setOptions(List)}
   */
  @Test
  @DisplayName("Test setOptions(List); given ten; when ArrayList() add ten; then FDFField() COSObject Values size is one")
  void testSetOptions_givenTen_whenArrayListAddTen_thenFDFFieldCOSObjectValuesSizeIsOne2() {
    // Arrange
    FDFField fdfField = new FDFField();

    ArrayList<Object> options = new ArrayList<>();
    options.add(10.0f);

    // Act
    fdfField.setOptions(options);

    // Assert
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#setOptions(List)}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>When {@link ArrayList#ArrayList()} add two.</li>
   *   <li>Then {@link FDFField#FDFField()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setOptions(List)}
   */
  @Test
  @DisplayName("Test setOptions(List); given two; when ArrayList() add two; then FDFField() COSObject Values size is one")
  void testSetOptions_givenTwo_whenArrayListAddTwo_thenFDFFieldCOSObjectValuesSizeIsOne() {
    // Arrange
    FDFField fdfField = new FDFField();

    ArrayList<Object> options = new ArrayList<>();
    options.add(2);

    // Act
    fdfField.setOptions(options);

    // Assert
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#setOptions(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link FDFField#FDFField()} Options Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setOptions(List)}
   */
  @Test
  @DisplayName("Test setOptions(List); when ArrayList(); then FDFField() Options Empty")
  void testSetOptions_whenArrayList_thenFDFFieldOptionsEmpty() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setOptions(new ArrayList<>());

    // Assert
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(fdfField.getOptions().isEmpty());
  }

  /**
   * Test {@link FDFField#getAction()}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is
   * {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getAction()}
   */
  @Test
  @DisplayName("Test getAction(); given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  void testGetAction_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSDictionary a = new COSDictionary();
    a.setKey(new COSObjectKey(1L, 1));
    PDActionEmbeddedGoTo a2 = new PDActionEmbeddedGoTo(a);

    FDFField fdfField = new FDFField();
    fdfField.setAction(a2);

    // Act and Assert
    assertNull(fdfField.getAction());
  }

  /**
   * Test {@link FDFField#getAction()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Action is
   * {@link PDActionEmbeddedGoTo#PDActionEmbeddedGoTo(COSDictionary)} with a is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getAction()}
   */
  @Test
  @DisplayName("Test getAction(); given FDFField() Action is PDActionEmbeddedGoTo(COSDictionary) with a is COSDictionary()")
  void testGetAction_givenFDFFieldActionIsPDActionEmbeddedGoToWithAIsCOSDictionary() {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setAction(new PDActionEmbeddedGoTo(new COSDictionary()));

    // Act and Assert
    assertNull(fdfField.getAction());
  }

  /**
   * Test {@link FDFField#getAction()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Action is
   * {@link PDActionGoTo#PDActionGoTo()}.</li>
   *   <li>Then return {@link PDActionGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getAction()}
   */
  @Test
  @DisplayName("Test getAction(); given FDFField() Action is PDActionGoTo(); then return PDActionGoTo")
  void testGetAction_givenFDFFieldActionIsPDActionGoTo_thenReturnPDActionGoTo() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setAction(new PDActionGoTo());

    // Act
    PDAction actualAction = fdfField.getAction();

    // Assert
    assertTrue(actualAction instanceof PDActionGoTo);
    assertEquals("Action", actualAction.getType());
    assertEquals("GoTo", actualAction.getSubType());
    assertNull(actualAction.getNext());
    COSDictionary cOSObject = actualAction.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionGoTo) actualAction).getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link FDFField#getAction()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Action is
   * {@link PDActionHide#PDActionHide()}.</li>
   *   <li>Then return {@link PDActionHide}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getAction()}
   */
  @Test
  @DisplayName("Test getAction(); given FDFField() Action is PDActionHide(); then return PDActionHide")
  void testGetAction_givenFDFFieldActionIsPDActionHide_thenReturnPDActionHide() {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setAction(new PDActionHide());

    // Act
    PDAction actualAction = fdfField.getAction();

    // Assert
    assertTrue(actualAction instanceof PDActionHide);
    assertEquals("Hide", actualAction.getSubType());
    assertNull(((PDActionHide) actualAction).getT());
    assertTrue(((PDActionHide) actualAction).getH());
  }

  /**
   * Test {@link FDFField#getAction()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Action is
   * {@link PDActionLaunch#PDActionLaunch()}.</li>
   *   <li>Then return {@link PDActionLaunch}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getAction()}
   */
  @Test
  @DisplayName("Test getAction(); given FDFField() Action is PDActionLaunch(); then return PDActionLaunch")
  void testGetAction_givenFDFFieldActionIsPDActionLaunch_thenReturnPDActionLaunch() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setAction(new PDActionLaunch());

    // Act
    PDAction actualAction = fdfField.getAction();

    // Assert
    assertTrue(actualAction instanceof PDActionLaunch);
    assertEquals("Launch", actualAction.getSubType());
    assertNull(((PDActionLaunch) actualAction).getD());
    assertNull(((PDActionLaunch) actualAction).getF());
    assertNull(((PDActionLaunch) actualAction).getO());
    assertNull(((PDActionLaunch) actualAction).getP());
    assertNull(((PDActionLaunch) actualAction).getFile());
    assertNull(((PDActionLaunch) actualAction).getWinLaunchParams());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionLaunch) actualAction).getOpenInNewWindow());
  }

  /**
   * Test {@link FDFField#getAction()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Action is
   * {@link PDActionMovie#PDActionMovie()}.</li>
   *   <li>Then return {@link PDActionMovie}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getAction()}
   */
  @Test
  @DisplayName("Test getAction(); given FDFField() Action is PDActionMovie(); then return PDActionMovie")
  void testGetAction_givenFDFFieldActionIsPDActionMovie_thenReturnPDActionMovie() {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setAction(new PDActionMovie());

    // Act
    PDAction actualAction = fdfField.getAction();

    // Assert
    assertTrue(actualAction instanceof PDActionMovie);
    assertEquals("Action", actualAction.getType());
    assertEquals("Movie", actualAction.getSubType());
    assertNull(actualAction.getNext());
    COSDictionary cOSObject = actualAction.getCOSObject();
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
  }

  /**
   * Test {@link FDFField#getAction()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Action is
   * {@link PDActionNamed#PDActionNamed()}.</li>
   *   <li>Then return {@link PDActionNamed}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getAction()}
   */
  @Test
  @DisplayName("Test getAction(); given FDFField() Action is PDActionNamed(); then return PDActionNamed")
  void testGetAction_givenFDFFieldActionIsPDActionNamed_thenReturnPDActionNamed() {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setAction(new PDActionNamed());

    // Act
    PDAction actualAction = fdfField.getAction();

    // Assert
    assertTrue(actualAction instanceof PDActionNamed);
    assertEquals("Action", actualAction.getType());
    assertEquals("Named", actualAction.getSubType());
    assertNull(((PDActionNamed) actualAction).getN());
    assertNull(actualAction.getNext());
    COSDictionary cOSObject = actualAction.getCOSObject();
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
  }

  /**
   * Test {@link FDFField#getAction()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Action is
   * {@link PDActionResetForm#PDActionResetForm()}.</li>
   *   <li>Then return {@link PDActionResetForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getAction()}
   */
  @Test
  @DisplayName("Test getAction(); given FDFField() Action is PDActionResetForm(); then return PDActionResetForm")
  void testGetAction_givenFDFFieldActionIsPDActionResetForm_thenReturnPDActionResetForm() {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setAction(new PDActionResetForm());

    // Act
    PDAction actualAction = fdfField.getAction();

    // Assert
    assertTrue(actualAction instanceof PDActionResetForm);
    assertEquals("ResetForm", actualAction.getSubType());
    assertNull(((PDActionResetForm) actualAction).getFields());
    assertEquals(0, ((PDActionResetForm) actualAction).getFlags());
  }

  /**
   * Test {@link FDFField#getAction()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Action is
   * {@link PDActionSound#PDActionSound()}.</li>
   *   <li>Then return {@link PDActionSound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getAction()}
   */
  @Test
  @DisplayName("Test getAction(); given FDFField() Action is PDActionSound(); then return PDActionSound")
  void testGetAction_givenFDFFieldActionIsPDActionSound_thenReturnPDActionSound() {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setAction(new PDActionSound());

    // Act
    PDAction actualAction = fdfField.getAction();

    // Assert
    assertTrue(actualAction instanceof PDActionSound);
    assertNull(((PDActionSound) actualAction).getSound());
    assertEquals(1.0f, ((PDActionSound) actualAction).getVolume());
    assertFalse(((PDActionSound) actualAction).getMix());
    assertFalse(((PDActionSound) actualAction).getRepeat());
    assertFalse(((PDActionSound) actualAction).getSynchronous());
    assertEquals(FDFAnnotationSound.SUBTYPE, actualAction.getSubType());
  }

  /**
   * Test {@link FDFField#getAction()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Action is
   * {@link PDActionThread#PDActionThread()}.</li>
   *   <li>Then return {@link PDActionThread}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getAction()}
   */
  @Test
  @DisplayName("Test getAction(); given FDFField() Action is PDActionThread(); then return PDActionThread")
  void testGetAction_givenFDFFieldActionIsPDActionThread_thenReturnPDActionThread() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setAction(new PDActionThread());

    // Act
    PDAction actualAction = fdfField.getAction();

    // Assert
    assertTrue(actualAction instanceof PDActionThread);
    assertEquals("Thread", actualAction.getSubType());
    assertNull(((PDActionThread) actualAction).getB());
    assertNull(((PDActionThread) actualAction).getD());
    assertNull(((PDActionThread) actualAction).getFile());
  }

  /**
   * Test {@link FDFField#getAction()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} Action is
   * {@link PDActionURI#PDActionURI()}.</li>
   *   <li>Then return {@link PDActionURI}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getAction()}
   */
  @Test
  @DisplayName("Test getAction(); given FDFField() Action is PDActionURI(); then return PDActionURI")
  void testGetAction_givenFDFFieldActionIsPDActionURI_thenReturnPDActionURI() {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setAction(new PDActionURI());

    // Act
    PDAction actualAction = fdfField.getAction();

    // Assert
    assertTrue(actualAction instanceof PDActionURI);
    assertEquals("Action", actualAction.getType());
    assertEquals("URI", actualAction.getSubType());
    assertNull(((PDActionURI) actualAction).getURI());
    assertNull(actualAction.getNext());
    COSDictionary cOSObject = actualAction.getCOSObject();
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
  }

  /**
   * Test {@link FDFField#getAction()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getAction()}
   */
  @Test
  @DisplayName("Test getAction(); given FDFField(); then return 'null'")
  void testGetAction_givenFDFField_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFField()).getAction());
  }

  /**
   * Test {@link FDFField#getAction()}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getAction()}
   */
  @Test
  @DisplayName("Test getAction(); given IIOMetadataNode(String) with 'foo'; then return 'null'")
  void testGetAction_givenIIOMetadataNodeWithFoo_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new FDFField(new IIOMetadataNode("foo"))).getAction());
  }

  /**
   * Test {@link FDFField#getAction()}.
   * <ul>
   *   <li>Then return {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getAction()}
   */
  @Test
  @DisplayName("Test getAction(); then return PDActionEmbeddedGoTo")
  void testGetAction_thenReturnPDActionEmbeddedGoTo() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setAction(new PDActionEmbeddedGoTo());

    // Act
    PDAction actualAction = fdfField.getAction();

    // Assert
    assertTrue(actualAction instanceof PDActionEmbeddedGoTo);
    assertEquals("GoToE", actualAction.getSubType());
    assertNull(((PDActionEmbeddedGoTo) actualAction).getFile());
    assertNull(((PDActionEmbeddedGoTo) actualAction).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) actualAction).getDestination());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) actualAction).getOpenInNewWindow());
  }

  /**
   * Test {@link FDFField#getAction()}.
   * <ul>
   *   <li>Then return {@link PDActionImportData}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getAction()}
   */
  @Test
  @DisplayName("Test getAction(); then return PDActionImportData")
  void testGetAction_thenReturnPDActionImportData() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setAction(new PDActionImportData());

    // Act
    PDAction actualAction = fdfField.getAction();

    // Assert
    assertTrue(actualAction instanceof PDActionImportData);
    assertEquals("Action", actualAction.getType());
    assertEquals("ImportData", actualAction.getSubType());
    assertNull(actualAction.getNext());
    COSDictionary cOSObject = actualAction.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDActionImportData) actualAction).getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link FDFField#getAction()}.
   * <ul>
   *   <li>Then return {@link PDActionJavaScript}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getAction()}
   */
  @Test
  @DisplayName("Test getAction(); then return PDActionJavaScript")
  void testGetAction_thenReturnPDActionJavaScript() {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setAction(new PDActionJavaScript());

    // Act
    PDAction actualAction = fdfField.getAction();

    // Assert
    assertTrue(actualAction instanceof PDActionJavaScript);
    assertEquals("Action", actualAction.getType());
    assertEquals("JavaScript", actualAction.getSubType());
    assertNull(((PDActionJavaScript) actualAction).getAction());
    assertNull(actualAction.getNext());
    COSDictionary cOSObject = actualAction.getCOSObject();
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
  }

  /**
   * Test {@link FDFField#getAction()}.
   * <ul>
   *   <li>Then return {@link PDActionRemoteGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getAction()}
   */
  @Test
  @DisplayName("Test getAction(); then return PDActionRemoteGoTo")
  void testGetAction_thenReturnPDActionRemoteGoTo() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setAction(new PDActionRemoteGoTo());

    // Act
    PDAction actualAction = fdfField.getAction();

    // Assert
    assertTrue(actualAction instanceof PDActionRemoteGoTo);
    assertEquals("GoToR", actualAction.getSubType());
    assertNull(((PDActionRemoteGoTo) actualAction).getD());
    assertNull(((PDActionRemoteGoTo) actualAction).getFile());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionRemoteGoTo) actualAction).getOpenInNewWindow());
  }

  /**
   * Test {@link FDFField#getAction()}.
   * <ul>
   *   <li>Then return {@link PDActionSubmitForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getAction()}
   */
  @Test
  @DisplayName("Test getAction(); then return PDActionSubmitForm")
  void testGetAction_thenReturnPDActionSubmitForm() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setAction(new PDActionSubmitForm());

    // Act
    PDAction actualAction = fdfField.getAction();

    // Assert
    assertTrue(actualAction instanceof PDActionSubmitForm);
    assertEquals("SubmitForm", actualAction.getSubType());
    assertNull(((PDActionSubmitForm) actualAction).getFields());
    assertNull(((PDActionSubmitForm) actualAction).getFile());
    assertEquals(0, ((PDActionSubmitForm) actualAction).getFlags());
  }

  /**
   * Test {@link FDFField#setAction(PDAction)}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()}.</li>
   *   <li>Then {@link FDFField#FDFField()} Action
   * {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setAction(PDAction)}
   */
  @Test
  @DisplayName("Test setAction(PDAction); given FDFField(); then FDFField() Action PDActionEmbeddedGoTo")
  void testSetAction_givenFDFField_thenFDFFieldActionPDActionEmbeddedGoTo() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setAction(new PDActionEmbeddedGoTo());

    // Assert
    PDAction action = fdfField.getAction();
    assertTrue(action instanceof PDActionEmbeddedGoTo);
    assertEquals("Action", action.getType());
    assertEquals("GoToE", action.getSubType());
    assertNull(action.getNext());
    assertNull(((PDActionEmbeddedGoTo) action).getFile());
    assertNull(((PDActionEmbeddedGoTo) action).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) action).getDestination());
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) action).getOpenInNewWindow());
  }

  /**
   * Test {@link FDFField#setAction(PDAction)}.
   * <ul>
   *   <li>Then {@link FDFField#FDFField(COSDictionary)} with f is
   * {@link COSDictionary#COSDictionary()} Action is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setAction(PDAction)}
   */
  @Test
  @DisplayName("Test setAction(PDAction); then FDFField(COSDictionary) with f is COSDictionary() Action is 'null'")
  void testSetAction_thenFDFFieldWithFIsCOSDictionaryActionIsNull() {
    // Arrange
    FDFField fdfField = new FDFField(new COSDictionary());

    // Act
    fdfField.setAction(null);

    // Assert
    assertNull(fdfField.getAction());
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link FDFField#getAdditionalActions()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getAdditionalActions()}
   */
  @Test
  @DisplayName("Test getAdditionalActions(); given FDFField(); then return 'null'")
  void testGetAdditionalActions_givenFDFField_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFField()).getAdditionalActions());
  }

  /**
   * Test {@link FDFField#getAdditionalActions()}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getAdditionalActions()}
   */
  @Test
  @DisplayName("Test getAdditionalActions(); given IIOMetadataNode(String) with 'foo'; then return 'null'")
  void testGetAdditionalActions_givenIIOMetadataNodeWithFoo_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new FDFField(new IIOMetadataNode("foo"))).getAdditionalActions());
  }

  /**
   * Test {@link FDFField#getAdditionalActions()}.
   * <ul>
   *   <li>Then return COSObject UpdateState OriginDocumentState is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getAdditionalActions()}
   */
  @Test
  @DisplayName("Test getAdditionalActions(); then return COSObject UpdateState OriginDocumentState is 'null'")
  void testGetAdditionalActions_thenReturnCOSObjectUpdateStateOriginDocumentStateIsNull() {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setAdditionalActions(new PDAdditionalActions());

    // Act
    PDAdditionalActions actualAdditionalActions = fdfField.getAdditionalActions();

    // Assert
    COSDictionary cOSObject = actualAdditionalActions.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualAdditionalActions.getF());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link FDFField#setAdditionalActions(PDAdditionalActions)}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()}.</li>
   *   <li>Then {@link FDFField#FDFField()} AdditionalActions F is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setAdditionalActions(PDAdditionalActions)}
   */
  @Test
  @DisplayName("Test setAdditionalActions(PDAdditionalActions); given FDFField(); then FDFField() AdditionalActions F is 'null'")
  void testSetAdditionalActions_givenFDFField_thenFDFFieldAdditionalActionsFIsNull() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setAdditionalActions(new PDAdditionalActions());

    // Assert
    assertNull(fdfField.getAdditionalActions().getF());
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#setAdditionalActions(PDAdditionalActions)}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link FDFField#FDFField()} COSObject size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setAdditionalActions(PDAdditionalActions)}
   */
  @Test
  @DisplayName("Test setAdditionalActions(PDAdditionalActions); given FDFField(); when 'null'; then FDFField() COSObject size is zero")
  void testSetAdditionalActions_givenFDFField_whenNull_thenFDFFieldCOSObjectSizeIsZero() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setAdditionalActions(null);

    // Assert
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link FDFField#getRichText()}.
   * <p>
   * Method under test: {@link FDFField#getRichText()}
   */
  @Test
  @DisplayName("Test getRichText()")
  void testGetRichText() {
    // Arrange
    COSStream rv = new COSStream();
    rv.setKey(new COSObjectKey(500L, 500));

    FDFField fdfField = new FDFField();
    fdfField.setRichText(rv);

    // Act and Assert
    assertEquals("", fdfField.getRichText());
  }

  /**
   * Test {@link FDFField#getRichText()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()} RichText is
   * {@link COSStream#COSStream()}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getRichText()}
   */
  @Test
  @DisplayName("Test getRichText(); given FDFField() RichText is COSStream(); then return empty string")
  void testGetRichText_givenFDFFieldRichTextIsCOSStream_thenReturnEmptyString() {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setRichText(new COSStream());

    // Act and Assert
    assertEquals("", fdfField.getRichText());
  }

  /**
   * Test {@link FDFField#getRichText()}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getRichText()}
   */
  @Test
  @DisplayName("Test getRichText(); given FDFField(); then return 'null'")
  void testGetRichText_givenFDFField_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFField()).getRichText());
  }

  /**
   * Test {@link FDFField#getRichText()}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getRichText()}
   */
  @Test
  @DisplayName("Test getRichText(); given IIOMetadataNode(String) with 'foo'; then return 'null'")
  void testGetRichText_givenIIOMetadataNodeWithFoo_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new FDFField(new IIOMetadataNode("foo"))).getRichText());
  }

  /**
   * Test {@link FDFField#getRichText()}.
   * <ul>
   *   <li>Then return
   * {@link FDFIconFit#SCALE_OPTION_ONLY_WHEN_ICON_IS_BIGGER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#getRichText()}
   */
  @Test
  @DisplayName("Test getRichText(); then return SCALE_OPTION_ONLY_WHEN_ICON_IS_BIGGER")
  void testGetRichText_thenReturnScale_option_only_when_icon_is_bigger() throws IOException {
    // Arrange
    FDFField fdfField = new FDFField();
    fdfField.setRichText(COSString.parseHex("42"));

    // Act and Assert
    assertEquals(FDFIconFit.SCALE_OPTION_ONLY_WHEN_ICON_IS_BIGGER, fdfField.getRichText());
  }

  /**
   * Test {@link FDFField#setRichText(COSStream)} with {@code COSStream}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setRichText(COSStream)}
   */
  @Test
  @DisplayName("Test setRichText(COSStream) with 'COSStream'; given COSObjectKey(long, int) with num is one and gen is one")
  void testSetRichTextWithCOSStream_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    FDFField fdfField = new FDFField();

    COSStream rv = new COSStream();
    rv.setKey(new COSObjectKey(1L, 1));

    // Act
    fdfField.setRichText(rv);

    // Assert
    assertEquals("", fdfField.getRichText());
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#setRichText(COSStream)} with {@code COSStream}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link FDFField#FDFField()} RichText is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setRichText(COSStream)}
   */
  @Test
  @DisplayName("Test setRichText(COSStream) with 'COSStream'; given FDFField(); when 'null'; then FDFField() RichText is 'null'")
  void testSetRichTextWithCOSStream_givenFDFField_whenNull_thenFDFFieldRichTextIsNull() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setRichText((COSStream) null);

    // Assert
    assertNull(fdfField.getRichText());
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link FDFField#setRichText(COSStream)} with {@code COSStream}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSStream#COSStream()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setRichText(COSStream)}
   */
  @Test
  @DisplayName("Test setRichText(COSStream) with 'COSStream'; given 'true'; when COSStream() Direct is 'true'")
  void testSetRichTextWithCOSStream_givenTrue_whenCOSStreamDirectIsTrue() {
    // Arrange
    FDFField fdfField = new FDFField();

    COSStream rv = new COSStream();
    rv.setDirect(true);

    // Act
    fdfField.setRichText(rv);

    // Assert
    assertEquals("", fdfField.getRichText());
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#setRichText(COSStream)} with {@code COSStream}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then {@link FDFField#FDFField()} RichText is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setRichText(COSStream)}
   */
  @Test
  @DisplayName("Test setRichText(COSStream) with 'COSStream'; when COSStream(); then FDFField() RichText is empty string")
  void testSetRichTextWithCOSStream_whenCOSStream_thenFDFFieldRichTextIsEmptyString() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setRichText(new COSStream());

    // Assert
    assertEquals("", fdfField.getRichText());
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link FDFField#setRichText(COSString)} with {@code COSString}.
   * <ul>
   *   <li>Given {@link FDFField#FDFField()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link FDFField#FDFField()} RichText is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFField#setRichText(COSString)}
   */
  @Test
  @DisplayName("Test setRichText(COSString) with 'COSString'; given FDFField(); when 'null'; then FDFField() RichText is 'null'")
  void testSetRichTextWithCOSString_givenFDFField_whenNull_thenFDFFieldRichTextIsNull() {
    // Arrange
    FDFField fdfField = new FDFField();

    // Act
    fdfField.setRichText((COSString) null);

    // Assert
    assertNull(fdfField.getRichText());
    COSDictionary cOSObject = fdfField.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }
}
