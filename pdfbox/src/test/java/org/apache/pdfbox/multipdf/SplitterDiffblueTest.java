package org.apache.pdfbox.multipdf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.apache.pdfbox.pdmodel.DefaultResourceCache;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SplitterDiffblueTest {
  /**
   * Test {@link Splitter#split(PDDocument)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)} with {@code foo}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName("Test split(PDDocument); given IllegalArgumentException(String) with 'foo'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit_givenIllegalArgumentExceptionWithFoo_thenReturnSizeIsOne() throws IOException {
    // Arrange
    Splitter splitter = new Splitter();
    new IllegalArgumentException("foo");

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());

    // Act
    List<PDDocument> actualSplitResult = splitter.split(document);

    // Assert
    assertEquals(1, actualSplitResult.size());
    Iterator<PDPage> iteratorResult = actualSplitResult.get(0).getPages().iterator();
    float[][] values = iteratorResult.next().getMatrix().getValues();
    assertEquals(3, values.length);
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link Splitter#split(PDDocument)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)} with {@code foo}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName("Test split(PDDocument); given IllegalArgumentException(String) with 'foo'; then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit_givenIllegalArgumentExceptionWithFoo_thenReturnSizeIsTwo() throws IOException {
    // Arrange
    Splitter splitter = new Splitter();
    new IllegalArgumentException("foo");

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(new PDPage());

    // Act
    List<PDDocument> actualSplitResult = splitter.split(document);

    // Assert
    assertEquals(2, actualSplitResult.size());
    PDDocument getResult = actualSplitResult.get(1);
    assertTrue(getResult.getResourceCache() instanceof DefaultResourceCache);
    assertNull(getResult.getDocumentId());
    assertNull(getResult.getEncryption());
    assertNull(getResult.getLastSignatureDictionary());
    assertEquals(1, getResult.getNumberOfPages());
    assertEquals(1.4f, getResult.getVersion());
    assertFalse(getResult.isAllSecurityToBeRemoved());
    assertFalse(getResult.isEncrypted());
    assertTrue(getResult.getSignatureDictionaries().isEmpty());
    assertTrue(getResult.getSignatureFields().isEmpty());
  }

  /**
   * Test {@link Splitter#split(PDDocument)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName("Test split(PDDocument); when PDDocument(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Splitter.split(PDDocument)"})
  void testSplit_whenPDDocument_thenReturnEmpty() throws IOException {
    // Arrange
    Splitter splitter = new Splitter();
    PDDocument document = new PDDocument();

    // Act and Assert
    assertTrue(splitter.split(document).isEmpty());
    assertSame(document, splitter.getSourceDocument());
  }

  /**
   * Test {@link Splitter#setSplitAtPage(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Splitter#setSplitAtPage(int)}
   */
  @Test
  @DisplayName("Test setSplitAtPage(int); when zero; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Splitter.setSplitAtPage(int)"})
  void testSetSplitAtPage_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Splitter()).setSplitAtPage(0));
  }

  /**
   * Test {@link Splitter#setStartPage(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Splitter#setStartPage(int)}
   */
  @Test
  @DisplayName("Test setStartPage(int); when zero; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Splitter.setStartPage(int)"})
  void testSetStartPage_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Splitter()).setStartPage(0));
  }

  /**
   * Test {@link Splitter#setEndPage(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Splitter#setEndPage(int)}
   */
  @Test
  @DisplayName("Test setEndPage(int); when zero; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Splitter.setEndPage(int)"})
  void testSetEndPage_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Splitter()).setEndPage(0));
  }

  /**
   * Test {@link Splitter#splitAtPage(int)}.
   * <p>
   * Method under test: {@link Splitter#splitAtPage(int)}
   */
  @Test
  @DisplayName("Test splitAtPage(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Splitter.splitAtPage(int)"})
  void testSplitAtPage() {
    // Arrange, Act and Assert
    assertTrue((new Splitter()).splitAtPage(10));
  }
}
