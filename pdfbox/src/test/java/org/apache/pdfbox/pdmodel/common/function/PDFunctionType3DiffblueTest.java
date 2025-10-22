package org.apache.pdfbox.pdmodel.common.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFunctionType3DiffblueTest {
  /**
   * Test {@link PDFunctionType3#PDFunctionType3(COSBase)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return RangeValues is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType3#PDFunctionType3(COSBase)}
   */
  @Test
  @DisplayName("Test new PDFunctionType3(COSBase); when COSDictionary(); then return RangeValues is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFunctionType3.<init>(COSBase)"})
  void testNewPDFunctionType3_whenCOSDictionary_thenReturnRangeValuesIsNull() {
    // Arrange
    COSDictionary functionStream = new COSDictionary();

    // Act
    PDFunctionType3 actualPdFunctionType3 = new PDFunctionType3(functionStream);

    // Assert
    assertNull(actualPdFunctionType3.getRangeValues());
    assertNull(actualPdFunctionType3.getBounds());
    assertNull(actualPdFunctionType3.getEncode());
    assertNull(actualPdFunctionType3.getFunctions());
    assertEquals(0, actualPdFunctionType3.getNumberOfOutputParameters());
    assertSame(functionStream, actualPdFunctionType3.getCOSObject());
  }

  /**
   * Test {@link PDFunctionType3#PDFunctionType3(COSBase)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then return PDStream DecodeParms is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType3#PDFunctionType3(COSBase)}
   */
  @Test
  @DisplayName("Test new PDFunctionType3(COSBase); when COSStream(); then return PDStream DecodeParms is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFunctionType3.<init>(COSBase)"})
  void testNewPDFunctionType3_whenCOSStream_thenReturnPDStreamDecodeParmsIsNull() throws IOException {
    // Arrange
    COSStream functionStream = new COSStream();

    // Act
    PDFunctionType3 actualPdFunctionType3 = new PDFunctionType3(functionStream);

    // Assert
    PDStream pDStream = actualPdFunctionType3.getPDStream();
    assertNull(pDStream.getDecodeParms());
    assertNull(pDStream.getFileDecodeParams());
    assertNull(pDStream.getMetadata());
    assertNull(pDStream.getFile());
    assertEquals(-1, pDStream.getDecodedStreamLength());
    assertEquals(0, pDStream.getLength());
    assertEquals(2, functionStream.size());
    List<String> fileFilters = pDStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(functionStream, pDStream.getCOSObject());
    assertSame(functionStream, actualPdFunctionType3.getCOSObject());
    assertSame(fileFilters, pDStream.getFilters());
  }

  /**
   * Test {@link PDFunctionType3#PDFunctionType3(COSBase)}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then return COSObject is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType3#PDFunctionType3(COSBase)}
   */
  @Test
  @DisplayName("Test new PDFunctionType3(COSBase); when FALSE; then return COSObject is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFunctionType3.<init>(COSBase)"})
  void testNewPDFunctionType3_whenFalse_thenReturnCOSObjectIsNull() {
    // Arrange and Act
    PDFunctionType3 actualPdFunctionType3 = new PDFunctionType3(COSBoolean.FALSE);

    // Assert
    assertNull(actualPdFunctionType3.getCOSObject());
    assertNull(actualPdFunctionType3.getPDStream());
    assertEquals(3, actualPdFunctionType3.getFunctionType());
  }

  /**
   * Test {@link PDFunctionType3#getFunctionType()}.
   * <p>
   * Method under test: {@link PDFunctionType3#getFunctionType()}
   */
  @Test
  @DisplayName("Test getFunctionType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDFunctionType3.getFunctionType()"})
  void testGetFunctionType() {
    // Arrange, Act and Assert
    assertEquals(3, (new PDFunctionType3(COSBoolean.FALSE)).getFunctionType());
  }

  /**
   * Test {@link PDFunctionType3#getFunctions()}.
   * <ul>
   *   <li>Given {@link PDFunctionType3#PDFunctionType3(COSBase)} with functionStream is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType3#getFunctions()}
   */
  @Test
  @DisplayName("Test getFunctions(); given PDFunctionType3(COSBase) with functionStream is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.pdfbox.cos.COSArray PDFunctionType3.getFunctions()"})
  void testGetFunctions_givenPDFunctionType3WithFunctionStreamIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDFunctionType3(new COSDictionary())).getFunctions());
  }

  /**
   * Test {@link PDFunctionType3#getFunctions()}.
   * <ul>
   *   <li>Given {@link PDFunctionType3#PDFunctionType3(COSBase)} with functionStream is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType3#getFunctions()}
   */
  @Test
  @DisplayName("Test getFunctions(); given PDFunctionType3(COSBase) with functionStream is COSStream()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.pdfbox.cos.COSArray PDFunctionType3.getFunctions()"})
  void testGetFunctions_givenPDFunctionType3WithFunctionStreamIsCOSStream() {
    // Arrange, Act and Assert
    assertNull((new PDFunctionType3(new COSStream())).getFunctions());
  }

  /**
   * Test {@link PDFunctionType3#getBounds()}.
   * <ul>
   *   <li>Given {@link PDFunctionType3#PDFunctionType3(COSBase)} with functionStream is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType3#getBounds()}
   */
  @Test
  @DisplayName("Test getBounds(); given PDFunctionType3(COSBase) with functionStream is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.pdfbox.cos.COSArray PDFunctionType3.getBounds()"})
  void testGetBounds_givenPDFunctionType3WithFunctionStreamIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDFunctionType3(new COSDictionary())).getBounds());
  }

  /**
   * Test {@link PDFunctionType3#getBounds()}.
   * <ul>
   *   <li>Given {@link PDFunctionType3#PDFunctionType3(COSBase)} with functionStream is {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType3#getBounds()}
   */
  @Test
  @DisplayName("Test getBounds(); given PDFunctionType3(COSBase) with functionStream is COSStream(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.pdfbox.cos.COSArray PDFunctionType3.getBounds()"})
  void testGetBounds_givenPDFunctionType3WithFunctionStreamIsCOSStream_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDFunctionType3(new COSStream())).getBounds());
  }

  /**
   * Test {@link PDFunctionType3#getEncode()}.
   * <ul>
   *   <li>Given {@link PDFunctionType3#PDFunctionType3(COSBase)} with functionStream is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType3#getEncode()}
   */
  @Test
  @DisplayName("Test getEncode(); given PDFunctionType3(COSBase) with functionStream is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.pdfbox.cos.COSArray PDFunctionType3.getEncode()"})
  void testGetEncode_givenPDFunctionType3WithFunctionStreamIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDFunctionType3(new COSDictionary())).getEncode());
  }

  /**
   * Test {@link PDFunctionType3#getEncode()}.
   * <ul>
   *   <li>Given {@link PDFunctionType3#PDFunctionType3(COSBase)} with functionStream is {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFunctionType3#getEncode()}
   */
  @Test
  @DisplayName("Test getEncode(); given PDFunctionType3(COSBase) with functionStream is COSStream(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.pdfbox.cos.COSArray PDFunctionType3.getEncode()"})
  void testGetEncode_givenPDFunctionType3WithFunctionStreamIsCOSStream_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDFunctionType3(new COSStream())).getEncode());
  }
}
