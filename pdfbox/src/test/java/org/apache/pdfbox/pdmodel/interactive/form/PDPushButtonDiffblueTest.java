package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;

class PDPushButtonDiffblueTest {
  /**
   * Method under test: {@link PDPushButton#getExportValues()}
   */
  @Test
  void testGetExportValues() {
    // Arrange, Act and Assert
    assertTrue((new PDPushButton(new PDAcroForm(new PDDocument()))).getExportValues().isEmpty());
  }

  /**
   * Method under test: {@link PDPushButton#getExportValues()}
   */
  @Test
  void testGetExportValues2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    List<String> actualExportValues = (new PDPushButton(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .getExportValues();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualExportValues.isEmpty());
  }

  /**
   * Method under test: {@link PDPushButton#setExportValues(List)}
   */
  @Test
  void testSetExportValues() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDPushButton pdPushButton = new PDPushButton(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    pdPushButton.setExportValues(new ArrayList<>());

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDPushButton#setExportValues(List)}
   */
  @Test
  void testSetExportValues2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDPushButton pdPushButton = new PDPushButton(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    ArrayList<String> values = new ArrayList<>();
    values.add("foo");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPushButton.setExportValues(values));
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDPushButton#setExportValues(List)}
   */
  @Test
  void testSetExportValues3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDPushButton pdPushButton = new PDPushButton(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    ArrayList<String> values = new ArrayList<>();
    values.add("foo");
    values.add("foo");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPushButton.setExportValues(values));
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDPushButton#getValueAsString()}
   */
  @Test
  void testGetValueAsString() {
    // Arrange, Act and Assert
    assertEquals("", (new PDPushButton(new PDAcroForm(new PDDocument()))).getValueAsString());
  }

  /**
   * Method under test: {@link PDPushButton#getValueAsString()}
   */
  @Test
  void testGetValueAsString2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    String actualValueAsString = (new PDPushButton(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .getValueAsString();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("", actualValueAsString);
  }

  /**
   * Method under test: {@link PDPushButton#getOnValues()}
   */
  @Test
  void testGetOnValues() {
    // Arrange, Act and Assert
    assertTrue((new PDPushButton(new PDAcroForm(new PDDocument()))).getOnValues().isEmpty());
  }

  /**
   * Method under test: {@link PDPushButton#getOnValues()}
   */
  @Test
  void testGetOnValues2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    Set<String> actualOnValues = (new PDPushButton(new PDAcroForm(new PDDocument(streamCacheCreateFunction))))
        .getOnValues();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualOnValues.isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PDPushButton#PDPushButton(PDAcroForm, COSDictionary, PDNonTerminalField)}
   *   <li>{@link PDPushButton#constructAppearances()}
   *   <li>{@link PDPushButton#getDefaultValue()}
   *   <li>{@link PDPushButton#getValue()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    // Act
    PDPushButton actualPdPushButton = new PDPushButton(acroForm, field, parent);
    actualPdPushButton.constructAppearances();
    String actualDefaultValue = actualPdPushButton.getDefaultValue();

    // Assert that nothing has changed
    assertEquals("", actualDefaultValue);
    assertEquals("", actualPdPushButton.getValue());
    assertSame(field, actualPdPushButton.getCOSObject());
    assertSame(acroForm, actualPdPushButton.getAcroForm());
    assertSame(parent, actualPdPushButton.getParent());
  }
}
