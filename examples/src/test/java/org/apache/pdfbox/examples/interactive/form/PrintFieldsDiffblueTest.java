package org.apache.pdfbox.examples.interactive.form;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCache.StreamCacheCreateFunction;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PrintFieldsDiffblueTest {
  /**
   * Test {@link PrintFields#printFields(PDDocument)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>Then calls {@link RandomAccessStreamCache.StreamCacheCreateFunction#create()}.
   * </ul>
   *
   * <p>Method under test: {@link PrintFields#printFields(PDDocument)}
   */
  @Test
  @DisplayName("Test printFields(PDDocument); given PDPage(); then calls create()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PrintFields.printFields(PDDocument)"})
  void testPrintFields_givenPDPage_thenCallsCreate() throws IOException {
    // Arrange
    PrintFields printFields = new PrintFields();

    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument pdfDocument = new PDDocument(streamCacheCreateFunction);
    pdfDocument.addPage(new PDPage());
    pdfDocument.addSignature(new PDSignature());

    // Act
    printFields.printFields(pdfDocument);

    // Assert
    verify(streamCacheCreateFunction).create();
  }
}
