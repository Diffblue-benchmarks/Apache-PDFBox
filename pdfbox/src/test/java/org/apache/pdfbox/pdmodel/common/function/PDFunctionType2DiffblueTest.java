package org.apache.pdfbox.pdmodel.common.function;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.junit.jupiter.api.Test;

class PDFunctionType2DiffblueTest {
  /**
   * Method under test: {@link PDFunctionType2#eval(float[])}
   */
  @Test
  void testEval() throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{0.1f},
        (new PDFunctionType2(new COSDictionary())).eval(new float[]{10.0f, 0.5f, 10.0f, 0.5f}), 0.0f);
    assertArrayEquals(new float[]{0.1f},
        (new PDFunctionType2(new COSStream())).eval(new float[]{10.0f, 0.5f, 10.0f, 0.5f}), 0.0f);
  }
}
