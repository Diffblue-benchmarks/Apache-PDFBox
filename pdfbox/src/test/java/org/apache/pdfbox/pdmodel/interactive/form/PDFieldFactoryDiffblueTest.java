package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;

class PDFieldFactoryDiffblueTest {
  /**
   * Method under test:
   * {@link PDFieldFactory#createField(PDAcroForm, COSDictionary, PDNonTerminalField)}
   */
  @Test
  void testCreateField() {
    // Arrange
    PDAcroForm form = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertNull(PDFieldFactory.createField(form, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))));
  }

  /**
   * Method under test:
   * {@link PDFieldFactory#createField(PDAcroForm, COSDictionary, PDNonTerminalField)}
   */
  @Test
  void testCreateField2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDAcroForm form = new PDAcroForm(new PDDocument(streamCacheCreateFunction));
    COSDictionary field = new COSDictionary();

    // Act
    PDField actualCreateFieldResult = PDFieldFactory.createField(form, field,
        new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualCreateFieldResult);
  }
}
