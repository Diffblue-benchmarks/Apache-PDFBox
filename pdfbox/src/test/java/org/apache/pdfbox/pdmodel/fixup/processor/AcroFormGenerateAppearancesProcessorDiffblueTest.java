package org.apache.pdfbox.pdmodel.fixup.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AcroFormGenerateAppearancesProcessorDiffblueTest {
  /**
   * Test {@link AcroFormGenerateAppearancesProcessor#process()}.
   *
   * <p>Method under test: {@link AcroFormGenerateAppearancesProcessor#process()}
   */
  @Test
  @DisplayName("Test process()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AcroFormGenerateAppearancesProcessor.process()"})
  void testProcess() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addSignature(new PDSignature());
    document.addPage(new PDPage());
    AcroFormGenerateAppearancesProcessor acroFormGenerateAppearancesProcessor =
        new AcroFormGenerateAppearancesProcessor(document);

    // Act
    acroFormGenerateAppearancesProcessor.process();

    // Assert
    COSDictionary cOSObject =
        acroFormGenerateAppearancesProcessor
            .document
            .getDocumentCatalog()
            .getAcroForm()
            .getCOSObject();
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
  }
}
