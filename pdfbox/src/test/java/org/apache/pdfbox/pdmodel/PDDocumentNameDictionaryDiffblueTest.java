package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.filespecification.PDComplexFileSpecification;
import org.apache.pdfbox.pdmodel.common.filespecification.PDEmbeddedFile;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageFitDestination;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDDocumentNameDictionaryDiffblueTest {
  /**
   * Test {@link PDDocumentNameDictionary#PDDocumentNameDictionary(PDDocumentCatalog, COSDictionary)}.
   * <p>
   * Method under test: {@link PDDocumentNameDictionary#PDDocumentNameDictionary(PDDocumentCatalog, COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDDocumentNameDictionary(PDDocumentCatalog, COSDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentNameDictionary.<init>(PDDocumentCatalog, COSDictionary)"})
  void testNewPDDocumentNameDictionary() {
    // Arrange
    PDDocumentCatalog cat = new PDDocumentCatalog(new PDDocument());
    COSDictionary names = new COSDictionary();

    // Act and Assert
    assertSame(names, (new PDDocumentNameDictionary(cat, names)).getCOSObject());
  }

  /**
   * Test {@link PDDocumentNameDictionary#PDDocumentNameDictionary(PDDocumentCatalog)}.
   * <p>
   * Method under test: {@link PDDocumentNameDictionary#PDDocumentNameDictionary(PDDocumentCatalog)}
   */
  @Test
  @DisplayName("Test new PDDocumentNameDictionary(PDDocumentCatalog)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentNameDictionary.<init>(PDDocumentCatalog)"})
  void testNewPDDocumentNameDictionary2() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(null);
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDDocumentCatalog cat = mock(PDDocumentCatalog.class);
    when(cat.getCOSObject()).thenReturn(cosDictionary);

    // Act
    PDDocumentNameDictionary actualPdDocumentNameDictionary = new PDDocumentNameDictionary(cat);

    // Assert
    verify(cosDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(cat, atLeast(1)).getCOSObject();
    COSDictionary cOSObject = actualPdDocumentNameDictionary.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualPdDocumentNameDictionary.getDests());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDDocumentNameDictionary#PDDocumentNameDictionary(PDDocumentCatalog)}.
   * <ul>
   *   <li>Then return Dests LowerLimit is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentNameDictionary#PDDocumentNameDictionary(PDDocumentCatalog)}
   */
  @Test
  @DisplayName("Test new PDDocumentNameDictionary(PDDocumentCatalog); then return Dests LowerLimit is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentNameDictionary.<init>(PDDocumentCatalog)"})
  void testNewPDDocumentNameDictionary_thenReturnDestsLowerLimitIsNull() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    COSDictionary cosDictionary2 = new COSDictionary();
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    PDDocumentCatalog cat = mock(PDDocumentCatalog.class);
    when(cat.getCOSObject()).thenReturn(cosDictionary);

    // Act
    PDDocumentNameDictionary actualPdDocumentNameDictionary = new PDDocumentNameDictionary(cat);

    // Assert
    verify(cosDictionary).getCOSDictionary(isA(COSName.class));
    verify(cat).getCOSObject();
    PDDestinationNameTreeNode dests = actualPdDocumentNameDictionary.getDests();
    assertNull(dests.getLowerLimit());
    assertNull(dests.getUpperLimit());
    assertNull(dests.getKids());
    assertNull(dests.getNames());
    assertNull(dests.getParent());
    assertTrue(dests.isRootNode());
    assertSame(cosDictionary2, actualPdDocumentNameDictionary.getCOSObject());
    assertSame(cosDictionary2, dests.getCOSObject());
  }

  /**
   * Test {@link PDDocumentNameDictionary#getDests()}.
   * <ul>
   *   <li>Then return LowerLimit is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentNameDictionary#getDests()}
   */
  @Test
  @DisplayName("Test getDests(); then return LowerLimit is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDDestinationNameTreeNode PDDocumentNameDictionary.getDests()"})
  void testGetDests_thenReturnLowerLimitIsNull() throws IOException {
    // Arrange
    PDDocumentNameDictionary pdDocumentNameDictionary = new PDDocumentNameDictionary(
        new PDDocumentCatalog(new PDDocument()));
    pdDocumentNameDictionary.setDests(new PDDestinationNameTreeNode());

    // Act
    PDDestinationNameTreeNode actualDests = pdDocumentNameDictionary.getDests();

    // Assert
    assertNull(actualDests.getLowerLimit());
    assertNull(actualDests.getUpperLimit());
    assertNull(actualDests.getKids());
    assertNull(actualDests.getNames());
    COSDictionary cOSObject = actualDests.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(actualDests.getParent());
    assertEquals(0, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(cOSObject.isNeedToBeUpdated());
    assertTrue(actualDests.isRootNode());
  }

  /**
   * Test {@link PDDocumentNameDictionary#getDests()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentNameDictionary#getDests()}
   */
  @Test
  @DisplayName("Test getDests(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDDestinationNameTreeNode PDDocumentNameDictionary.getDests()"})
  void testGetDests_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentNameDictionary(new PDDocumentCatalog(new PDDocument()))).getDests());
  }

  /**
   * Test {@link PDDocumentNameDictionary#setDests(PDDestinationNameTreeNode)}.
   * <p>
   * Method under test: {@link PDDocumentNameDictionary#setDests(PDDestinationNameTreeNode)}
   */
  @Test
  @DisplayName("Test setDests(PDDestinationNameTreeNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentNameDictionary.setDests(PDDestinationNameTreeNode)"})
  void testSetDests() {
    // Arrange
    PDDocument doc = new PDDocument();
    PDDocumentNameDictionary pdDocumentNameDictionary = new PDDocumentNameDictionary(
        new PDDocumentCatalog(doc, new COSDictionary()));
    PDDestinationNameTreeNode dests = new PDDestinationNameTreeNode();

    // Act
    pdDocumentNameDictionary.setDests(dests);

    // Assert that nothing has changed
    COSIncrement toIncrementResult = dests.getCOSObject().toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(pdDocumentNameDictionary.getCOSObject().toIncrement().getObjects().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDDocumentNameDictionary#setDests(PDDestinationNameTreeNode)}.
   * <p>
   * Method under test: {@link PDDocumentNameDictionary#setDests(PDDestinationNameTreeNode)}
   */
  @Test
  @DisplayName("Test setDests(PDDestinationNameTreeNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentNameDictionary.setDests(PDDestinationNameTreeNode)"})
  void testSetDests2() throws IOException {
    // Arrange
    PDDocumentNameDictionary pdDocumentNameDictionary = new PDDocumentNameDictionary(
        new PDDocumentCatalog(new PDDocument()));

    HashMap<String, PDPageDestination> names = new HashMap<>();
    names.put("foo", new PDPageFitDestination());

    PDDestinationNameTreeNode dests = new PDDestinationNameTreeNode();
    dests.setNames(names);

    // Act
    pdDocumentNameDictionary.setDests(dests);

    // Assert
    Map<String, PDPageDestination> names2 = pdDocumentNameDictionary.getDests().getNames();
    assertEquals(1, names2.size());
    PDPageDestination getResult = names2.get("foo");
    assertTrue(getResult instanceof PDPageFitDestination);
    assertNull(getResult.getPage());
    assertEquals(-1, getResult.getPageNumber());
  }

  /**
   * Test {@link PDDocumentNameDictionary#getEmbeddedFiles()}.
   * <ul>
   *   <li>Then return LowerLimit is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentNameDictionary#getEmbeddedFiles()}
   */
  @Test
  @DisplayName("Test getEmbeddedFiles(); then return LowerLimit is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDEmbeddedFilesNameTreeNode PDDocumentNameDictionary.getEmbeddedFiles()"})
  void testGetEmbeddedFiles_thenReturnLowerLimitIsNull() throws IOException {
    // Arrange
    PDDocumentNameDictionary pdDocumentNameDictionary = new PDDocumentNameDictionary(
        new PDDocumentCatalog(new PDDocument()));
    pdDocumentNameDictionary.setEmbeddedFiles(new PDEmbeddedFilesNameTreeNode());

    // Act
    PDEmbeddedFilesNameTreeNode actualEmbeddedFiles = pdDocumentNameDictionary.getEmbeddedFiles();

    // Assert
    assertNull(actualEmbeddedFiles.getLowerLimit());
    assertNull(actualEmbeddedFiles.getUpperLimit());
    assertNull(actualEmbeddedFiles.getKids());
    assertNull(actualEmbeddedFiles.getNames());
    COSDictionary cOSObject = actualEmbeddedFiles.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(actualEmbeddedFiles.getParent());
    assertEquals(0, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(cOSObject.isNeedToBeUpdated());
    assertTrue(actualEmbeddedFiles.isRootNode());
  }

  /**
   * Test {@link PDDocumentNameDictionary#getEmbeddedFiles()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentNameDictionary#getEmbeddedFiles()}
   */
  @Test
  @DisplayName("Test getEmbeddedFiles(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDEmbeddedFilesNameTreeNode PDDocumentNameDictionary.getEmbeddedFiles()"})
  void testGetEmbeddedFiles_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentNameDictionary(new PDDocumentCatalog(new PDDocument()))).getEmbeddedFiles());
  }

  /**
   * Test {@link PDDocumentNameDictionary#setEmbeddedFiles(PDEmbeddedFilesNameTreeNode)}.
   * <p>
   * Method under test: {@link PDDocumentNameDictionary#setEmbeddedFiles(PDEmbeddedFilesNameTreeNode)}
   */
  @Test
  @DisplayName("Test setEmbeddedFiles(PDEmbeddedFilesNameTreeNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentNameDictionary.setEmbeddedFiles(PDEmbeddedFilesNameTreeNode)"})
  void testSetEmbeddedFiles() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    PDDocumentNameDictionary pdDocumentNameDictionary = new PDDocumentNameDictionary(
        new PDDocumentCatalog(doc, new COSDictionary()));
    PDEmbeddedFilesNameTreeNode ef = new PDEmbeddedFilesNameTreeNode();

    // Act
    pdDocumentNameDictionary.setEmbeddedFiles(ef);

    // Assert
    assertNull(pdDocumentNameDictionary.getEmbeddedFiles().getNames());
    COSIncrement toIncrementResult = ef.getCOSObject().toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(pdDocumentNameDictionary.getCOSObject().toIncrement().getObjects().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDDocumentNameDictionary#setEmbeddedFiles(PDEmbeddedFilesNameTreeNode)}.
   * <p>
   * Method under test: {@link PDDocumentNameDictionary#setEmbeddedFiles(PDEmbeddedFilesNameTreeNode)}
   */
  @Test
  @DisplayName("Test setEmbeddedFiles(PDEmbeddedFilesNameTreeNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentNameDictionary.setEmbeddedFiles(PDEmbeddedFilesNameTreeNode)"})
  void testSetEmbeddedFiles2() {
    // Arrange
    PDDocumentNameDictionary pdDocumentNameDictionary = new PDDocumentNameDictionary(
        new PDDocumentCatalog(new PDDocument()));

    // Act
    pdDocumentNameDictionary.setEmbeddedFiles(null);

    // Assert that nothing has changed
    assertEquals(1, pdDocumentNameDictionary.getCOSObject().toIncrement().getObjects().size());
  }

  /**
   * Test {@link PDDocumentNameDictionary#setEmbeddedFiles(PDEmbeddedFilesNameTreeNode)}.
   * <p>
   * Method under test: {@link PDDocumentNameDictionary#setEmbeddedFiles(PDEmbeddedFilesNameTreeNode)}
   */
  @Test
  @DisplayName("Test setEmbeddedFiles(PDEmbeddedFilesNameTreeNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentNameDictionary.setEmbeddedFiles(PDEmbeddedFilesNameTreeNode)"})
  void testSetEmbeddedFiles3() throws IOException {
    // Arrange
    PDDocumentNameDictionary pdDocumentNameDictionary = new PDDocumentNameDictionary(
        new PDDocumentCatalog(new PDDocument()));

    HashMap<String, PDComplexFileSpecification> names = new HashMap<>();
    names.put("foo", new PDComplexFileSpecification());

    PDEmbeddedFilesNameTreeNode ef = new PDEmbeddedFilesNameTreeNode();
    ef.setNames(names);

    // Act
    pdDocumentNameDictionary.setEmbeddedFiles(ef);

    // Assert
    Map<String, PDComplexFileSpecification> names2 = pdDocumentNameDictionary.getEmbeddedFiles().getNames();
    assertEquals(1, names2.size());
    assertNull(names2.get("foo").getEmbeddedFile());
    Map<String, PDComplexFileSpecification> names3 = ef.getNames();
    assertEquals(1, names3.size());
    assertEquals(1, names3.get("foo").getCOSObject().toIncrement().getObjects().size());
    assertEquals(2, ef.getCOSObject().toIncrement().getObjects().size());
    assertEquals(3, pdDocumentNameDictionary.getCOSObject().toIncrement().getObjects().size());
  }

  /**
   * Test {@link PDDocumentNameDictionary#setEmbeddedFiles(PDEmbeddedFilesNameTreeNode)}.
   * <p>
   * Method under test: {@link PDDocumentNameDictionary#setEmbeddedFiles(PDEmbeddedFilesNameTreeNode)}
   */
  @Test
  @DisplayName("Test setEmbeddedFiles(PDEmbeddedFilesNameTreeNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentNameDictionary.setEmbeddedFiles(PDEmbeddedFilesNameTreeNode)"})
  void testSetEmbeddedFiles4() throws IOException {
    // Arrange
    PDDocumentNameDictionary pdDocumentNameDictionary = new PDDocumentNameDictionary(
        new PDDocumentCatalog(new PDDocument()));

    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(new COSStream()));

    HashMap<String, PDComplexFileSpecification> names = new HashMap<>();
    names.put("foo", pdComplexFileSpecification);

    PDEmbeddedFilesNameTreeNode ef = new PDEmbeddedFilesNameTreeNode();
    ef.setNames(names);

    // Act
    pdDocumentNameDictionary.setEmbeddedFiles(ef);

    // Assert
    Map<String, PDComplexFileSpecification> names2 = pdDocumentNameDictionary.getEmbeddedFiles().getNames();
    assertEquals(1, names2.size());
    assertEquals(4, ef.getCOSObject().toIncrement().getObjects().size());
    assertEquals(5, pdDocumentNameDictionary.getCOSObject().toIncrement().getObjects().size());
    assertTrue(names2.containsKey("foo"));
  }

  /**
   * Test {@link PDDocumentNameDictionary#setEmbeddedFiles(PDEmbeddedFilesNameTreeNode)}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()} Key is {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentNameDictionary#setEmbeddedFiles(PDEmbeddedFilesNameTreeNode)}
   */
  @Test
  @DisplayName("Test setEmbeddedFiles(PDEmbeddedFilesNameTreeNode); given COSStream() Key is COSObjectKey(long, int) with num is one and gen is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentNameDictionary.setEmbeddedFiles(PDEmbeddedFilesNameTreeNode)"})
  void testSetEmbeddedFiles_givenCOSStreamKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    PDDocumentNameDictionary pdDocumentNameDictionary = new PDDocumentNameDictionary(
        new PDDocumentCatalog(new PDDocument()));

    COSStream str = new COSStream();
    str.setKey(new COSObjectKey(1L, 1));
    PDEmbeddedFile file = new PDEmbeddedFile(str);

    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFile(file);

    HashMap<String, PDComplexFileSpecification> names = new HashMap<>();
    names.put("foo", pdComplexFileSpecification);

    PDEmbeddedFilesNameTreeNode ef = new PDEmbeddedFilesNameTreeNode();
    ef.setNames(names);

    // Act
    pdDocumentNameDictionary.setEmbeddedFiles(ef);

    // Assert
    Map<String, PDComplexFileSpecification> names2 = pdDocumentNameDictionary.getEmbeddedFiles().getNames();
    assertEquals(1, names2.size());
    assertEquals(4, ef.getCOSObject().toIncrement().getObjects().size());
    assertEquals(5, pdDocumentNameDictionary.getCOSObject().toIncrement().getObjects().size());
    assertTrue(names2.containsKey("foo"));
  }

  /**
   * Test {@link PDDocumentNameDictionary#getJavaScript()}.
   * <ul>
   *   <li>Then return LowerLimit is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentNameDictionary#getJavaScript()}
   */
  @Test
  @DisplayName("Test getJavaScript(); then return LowerLimit is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDJavascriptNameTreeNode PDDocumentNameDictionary.getJavaScript()"})
  void testGetJavaScript_thenReturnLowerLimitIsNull() throws IOException {
    // Arrange
    PDDocumentNameDictionary pdDocumentNameDictionary = new PDDocumentNameDictionary(
        new PDDocumentCatalog(new PDDocument()));
    pdDocumentNameDictionary.setJavascript(new PDJavascriptNameTreeNode());

    // Act
    PDJavascriptNameTreeNode actualJavaScript = pdDocumentNameDictionary.getJavaScript();

    // Assert
    assertNull(actualJavaScript.getLowerLimit());
    assertNull(actualJavaScript.getUpperLimit());
    assertNull(actualJavaScript.getKids());
    assertNull(actualJavaScript.getNames());
    COSDictionary cOSObject = actualJavaScript.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(actualJavaScript.getParent());
    assertEquals(0, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(cOSObject.isNeedToBeUpdated());
    assertTrue(actualJavaScript.isRootNode());
  }

  /**
   * Test {@link PDDocumentNameDictionary#getJavaScript()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDocumentNameDictionary#getJavaScript()}
   */
  @Test
  @DisplayName("Test getJavaScript(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDJavascriptNameTreeNode PDDocumentNameDictionary.getJavaScript()"})
  void testGetJavaScript_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentNameDictionary(new PDDocumentCatalog(new PDDocument()))).getJavaScript());
  }

  /**
   * Test {@link PDDocumentNameDictionary#setJavascript(PDJavascriptNameTreeNode)}.
   * <p>
   * Method under test: {@link PDDocumentNameDictionary#setJavascript(PDJavascriptNameTreeNode)}
   */
  @Test
  @DisplayName("Test setJavascript(PDJavascriptNameTreeNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentNameDictionary.setJavascript(PDJavascriptNameTreeNode)"})
  void testSetJavascript() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    PDDocumentNameDictionary pdDocumentNameDictionary = new PDDocumentNameDictionary(
        new PDDocumentCatalog(doc, new COSDictionary()));
    PDJavascriptNameTreeNode js = new PDJavascriptNameTreeNode();

    // Act
    pdDocumentNameDictionary.setJavascript(js);

    // Assert
    assertNull(pdDocumentNameDictionary.getJavaScript().getNames());
    COSIncrement toIncrementResult = js.getCOSObject().toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(pdDocumentNameDictionary.getCOSObject().toIncrement().getObjects().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDDocumentNameDictionary#setJavascript(PDJavascriptNameTreeNode)}.
   * <p>
   * Method under test: {@link PDDocumentNameDictionary#setJavascript(PDJavascriptNameTreeNode)}
   */
  @Test
  @DisplayName("Test setJavascript(PDJavascriptNameTreeNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDocumentNameDictionary.setJavascript(PDJavascriptNameTreeNode)"})
  void testSetJavascript2() {
    // Arrange
    PDDocumentNameDictionary pdDocumentNameDictionary = new PDDocumentNameDictionary(
        new PDDocumentCatalog(new PDDocument()));

    // Act
    pdDocumentNameDictionary.setJavascript(null);

    // Assert that nothing has changed
    assertEquals(1, pdDocumentNameDictionary.getCOSObject().toIncrement().getObjects().size());
  }
}
