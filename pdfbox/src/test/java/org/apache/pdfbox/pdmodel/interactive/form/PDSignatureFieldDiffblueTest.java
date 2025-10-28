package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSeedValue;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.junit.jupiter.api.Test;

class PDSignatureFieldDiffblueTest {
  /**
   * Method under test: {@link PDSignatureField#getSignature()}
   */
  @Test
  void testGetSignature() {
    // Arrange, Act and Assert
    assertNull((new PDSignatureField(new PDAcroForm(new PDDocument()))).getSignature());
  }

  /**
   * Method under test: {@link PDSignatureField#getSignature()}
   */
  @Test
  void testGetSignature2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDSignature actualSignature = (new PDSignatureField(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .getSignature();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualSignature);
  }

  /**
   * Method under test: {@link PDSignatureField#setValue(String)}
   */
  @Test
  void testSetValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new PDSignatureField(new PDAcroForm(new PDDocument()))).setValue("42"));
  }

  /**
   * Method under test: {@link PDSignatureField#setValue(PDSignature)}
   */
  @Test
  void testSetValue2() throws IOException {
    // Arrange
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    // Act
    pdSignatureField.setValue(new PDSignature());

    // Assert
    PDSignature signature = pdSignatureField.getSignature();
    assertNull(signature.getContactInfo());
    PDSignature value = pdSignatureField.getValue();
    assertNull(value.getContactInfo());
    assertNull(signature.getFilter());
    assertNull(value.getFilter());
    assertNull(signature.getLocation());
    assertNull(value.getLocation());
    assertNull(signature.getName());
    assertNull(value.getName());
    assertNull(signature.getReason());
    assertNull(value.getReason());
    assertNull(signature.getSubFilter());
    assertNull(value.getSubFilter());
    assertNull(signature.getSignDate());
    assertNull(value.getSignDate());
    assertNull(signature.getPropBuild());
    assertNull(value.getPropBuild());
    assertEquals(0, signature.getByteRange().length);
    assertEquals(0, value.getByteRange().length);
    assertEquals(0, signature.getContents().length);
    assertEquals(0, value.getContents().length);
    COSDictionary cOSObject = pdSignatureField.getCOSObject();
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
  }

  /**
   * Method under test: {@link PDSignatureField#setValue(PDSignature)}
   */
  @Test
  void testSetValue3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    pdSignatureField.setValue(new PDSignature());

    // Assert
    verify(streamCacheCreateFunction).create();
    PDSignature signature = pdSignatureField.getSignature();
    assertNull(signature.getContactInfo());
    PDSignature value = pdSignatureField.getValue();
    assertNull(value.getContactInfo());
    assertNull(signature.getFilter());
    assertNull(value.getFilter());
    assertNull(signature.getLocation());
    assertNull(value.getLocation());
    assertNull(signature.getName());
    assertNull(value.getName());
    assertNull(signature.getReason());
    assertNull(value.getReason());
    assertNull(signature.getSubFilter());
    assertNull(value.getSubFilter());
    assertNull(signature.getSignDate());
    assertNull(value.getSignDate());
    assertNull(signature.getPropBuild());
    assertNull(value.getPropBuild());
    assertEquals(0, signature.getByteRange().length);
    assertEquals(0, value.getByteRange().length);
    assertEquals(0, signature.getContents().length);
    assertEquals(0, value.getContents().length);
    COSDictionary cOSObject = pdSignatureField.getCOSObject();
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
  }

  /**
   * Method under test: {@link PDSignatureField#setValue(PDSignature)}
   */
  @Test
  void testSetValue4() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDSignatureField pdSignatureField = new PDSignatureField(acroForm, field,
        new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdSignatureField.setValue(new PDSignature());

    // Assert
    PDSignature signature = pdSignatureField.getSignature();
    assertNull(signature.getContactInfo());
    PDSignature value = pdSignatureField.getValue();
    assertNull(value.getContactInfo());
    assertNull(signature.getFilter());
    assertNull(value.getFilter());
    assertNull(signature.getLocation());
    assertNull(value.getLocation());
    assertNull(signature.getName());
    assertNull(value.getName());
    assertNull(signature.getReason());
    assertNull(value.getReason());
    assertNull(signature.getSubFilter());
    assertNull(value.getSubFilter());
    assertNull(signature.getSignDate());
    assertNull(value.getSignDate());
    assertNull(signature.getPropBuild());
    assertNull(value.getPropBuild());
    assertEquals(0, signature.getByteRange().length);
    assertEquals(0, value.getByteRange().length);
    assertEquals(0, signature.getContents().length);
    assertEquals(0, value.getContents().length);
    assertSame(field, pdSignatureField.getCOSObject());
  }

  /**
   * Method under test: {@link PDSignatureField#setValue(PDSignature)}
   */
  @Test
  void testSetValue5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    pdSignatureField.setValue((PDSignature) null);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(pdSignatureField.getSignature());
    assertNull(pdSignatureField.getValue());
    COSDictionary cOSObject = pdSignatureField.getCOSObject();
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
  }

  /**
   * Method under test: {@link PDSignatureField#setDefaultValue(PDSignature)}
   */
  @Test
  void testSetDefaultValue() {
    // Arrange
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    // Act
    pdSignatureField.setDefaultValue(new PDSignature());

    // Assert
    PDSignature defaultValue = pdSignatureField.getDefaultValue();
    assertNull(defaultValue.getContactInfo());
    assertNull(defaultValue.getFilter());
    assertNull(defaultValue.getLocation());
    assertNull(defaultValue.getName());
    assertNull(defaultValue.getReason());
    assertNull(defaultValue.getSubFilter());
    assertNull(defaultValue.getSignDate());
    assertNull(defaultValue.getPropBuild());
    assertEquals(0, defaultValue.getByteRange().length);
    assertEquals(0, defaultValue.getContents().length);
    COSDictionary cOSObject = pdSignatureField.getCOSObject();
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
  }

  /**
   * Method under test: {@link PDSignatureField#setDefaultValue(PDSignature)}
   */
  @Test
  void testSetDefaultValue2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    pdSignatureField.setDefaultValue(new PDSignature());

    // Assert
    verify(streamCacheCreateFunction).create();
    PDSignature defaultValue = pdSignatureField.getDefaultValue();
    assertNull(defaultValue.getContactInfo());
    assertNull(defaultValue.getFilter());
    assertNull(defaultValue.getLocation());
    assertNull(defaultValue.getName());
    assertNull(defaultValue.getReason());
    assertNull(defaultValue.getSubFilter());
    assertNull(defaultValue.getSignDate());
    assertNull(defaultValue.getPropBuild());
    assertEquals(0, defaultValue.getByteRange().length);
    assertEquals(0, defaultValue.getContents().length);
    COSDictionary cOSObject = pdSignatureField.getCOSObject();
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
  }

  /**
   * Method under test: {@link PDSignatureField#setDefaultValue(PDSignature)}
   */
  @Test
  void testSetDefaultValue3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    pdSignatureField.setDefaultValue(null);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(pdSignatureField.getDefaultValue());
    COSDictionary cOSObject = pdSignatureField.getCOSObject();
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
  }

  /**
   * Method under test: {@link PDSignatureField#getValue()}
   */
  @Test
  void testGetValue() {
    // Arrange, Act and Assert
    assertNull((new PDSignatureField(new PDAcroForm(new PDDocument()))).getValue());
  }

  /**
   * Method under test: {@link PDSignatureField#getValue()}
   */
  @Test
  void testGetValue2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDSignature actualValue = (new PDSignatureField(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .getValue();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualValue);
  }

  /**
   * Method under test: {@link PDSignatureField#getDefaultValue()}
   */
  @Test
  void testGetDefaultValue() {
    // Arrange, Act and Assert
    assertNull((new PDSignatureField(new PDAcroForm(new PDDocument()))).getDefaultValue());
  }

  /**
   * Method under test: {@link PDSignatureField#getDefaultValue()}
   */
  @Test
  void testGetDefaultValue2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDSignature actualDefaultValue = (new PDSignatureField(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .getDefaultValue();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualDefaultValue);
  }

  /**
   * Method under test: {@link PDSignatureField#getValueAsString()}
   */
  @Test
  void testGetValueAsString() {
    // Arrange, Act and Assert
    assertEquals("", (new PDSignatureField(new PDAcroForm(new PDDocument()))).getValueAsString());
  }

  /**
   * Method under test: {@link PDSignatureField#getValueAsString()}
   */
  @Test
  void testGetValueAsString2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    String actualValueAsString = (new PDSignatureField(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .getValueAsString();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("", actualValueAsString);
  }

  /**
   * Method under test: {@link PDSignatureField#getSeedValue()}
   */
  @Test
  void testGetSeedValue() {
    // Arrange, Act and Assert
    assertNull((new PDSignatureField(new PDAcroForm(new PDDocument()))).getSeedValue());
  }

  /**
   * Method under test: {@link PDSignatureField#getSeedValue()}
   */
  @Test
  void testGetSeedValue2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDSeedValue actualSeedValue = (new PDSignatureField(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .getSeedValue();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualSeedValue);
  }

  /**
   * Method under test: {@link PDSignatureField#setSeedValue(PDSeedValue)}
   */
  @Test
  void testSetSeedValue() {
    // Arrange
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    // Act
    pdSignatureField.setSeedValue(new PDSeedValue());

    // Assert
    PDSeedValue seedValue = pdSignatureField.getSeedValue();
    assertNull(seedValue.getFilter());
    assertNull(seedValue.getSeedValueCertificate());
    assertNull(seedValue.getMDP());
    assertNull(seedValue.getTimeStamp());
    assertEquals(-1.0f, seedValue.getV());
    COSDictionary cOSObject = pdSignatureField.getCOSObject();
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertFalse(seedValue.isAddRevInfoRequired());
    assertFalse(seedValue.isDigestMethodRequired());
    assertFalse(seedValue.isFilterRequired());
    assertFalse(seedValue.isLegalAttestationRequired());
    assertFalse(seedValue.isReasonRequired());
    assertFalse(seedValue.isSubFilterRequired());
    assertFalse(seedValue.isVRequired());
  }

  /**
   * Method under test: {@link PDSignatureField#setSeedValue(PDSeedValue)}
   */
  @Test
  void testSetSeedValue2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    pdSignatureField.setSeedValue(new PDSeedValue());

    // Assert
    verify(streamCacheCreateFunction).create();
    PDSeedValue seedValue = pdSignatureField.getSeedValue();
    assertNull(seedValue.getFilter());
    assertNull(seedValue.getSeedValueCertificate());
    assertNull(seedValue.getMDP());
    assertNull(seedValue.getTimeStamp());
    assertEquals(-1.0f, seedValue.getV());
    COSDictionary cOSObject = pdSignatureField.getCOSObject();
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertFalse(seedValue.isAddRevInfoRequired());
    assertFalse(seedValue.isDigestMethodRequired());
    assertFalse(seedValue.isFilterRequired());
    assertFalse(seedValue.isLegalAttestationRequired());
    assertFalse(seedValue.isReasonRequired());
    assertFalse(seedValue.isSubFilterRequired());
    assertFalse(seedValue.isVRequired());
  }

  /**
   * Method under test: {@link PDSignatureField#setSeedValue(PDSeedValue)}
   */
  @Test
  void testSetSeedValue3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    pdSignatureField.setSeedValue(null);

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = pdSignatureField.getCOSObject();
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
  }

  /**
   * Method under test: {@link PDSignatureField#constructAppearances()}
   */
  @Test
  void testConstructAppearances() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    (new PDSignatureField(new PDAcroForm(new PDDocument(streamCacheCreateFunction)))).constructAppearances();

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link PDSignatureField#PDSignatureField(PDAcroForm, COSDictionary, PDNonTerminalField)}
   */
  @Test
  void testNewPDSignatureField() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    // Act
    PDSignatureField actualPdSignatureField = new PDSignatureField(acroForm, field, parent);

    // Assert
    assertSame(field, actualPdSignatureField.getCOSObject());
    assertSame(acroForm, actualPdSignatureField.getAcroForm());
    assertSame(parent, actualPdSignatureField.getParent());
  }
}
