package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.DefaultResourceCache;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.ResourceCache;
import org.apache.pdfbox.pdmodel.fdf.FDFCatalog;
import org.apache.pdfbox.pdmodel.fdf.FDFDocument;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDAcroFormDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDAcroForm#PDAcroForm(PDDocument, COSDictionary)}
   *   <li>{@link PDAcroForm#setScriptingHandler(ScriptingHandler)}
   *   <li>{@link PDAcroForm#getDocument()}
   *   <li>{@link PDAcroForm#getScriptingHandler()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAcroForm.<init>(PDDocument, COSDictionary)",
    "PDDocument PDAcroForm.getDocument()",
    "ScriptingHandler PDAcroForm.getScriptingHandler()",
    "void PDAcroForm.setScriptingHandler(ScriptingHandler)"
  })
  void testGettersAndSetters() {
    // Arrange
    PDDocument doc = new PDDocument();
    COSDictionary form = new COSDictionary();

    // Act
    PDAcroForm actualPdAcroForm = new PDAcroForm(doc, form);
    ScriptingHandler scriptingHandler = mock(ScriptingHandler.class);
    actualPdAcroForm.setScriptingHandler(scriptingHandler);
    PDDocument actualDocument = actualPdAcroForm.getDocument();
    ScriptingHandler actualScriptingHandler = actualPdAcroForm.getScriptingHandler();

    // Assert
    assertSame(form, actualPdAcroForm.getCOSObject());
    assertSame(doc, actualDocument);
    assertSame(scriptingHandler, actualScriptingHandler);
  }

  /**
   * Test {@link PDAcroForm#PDAcroForm(PDDocument)}.
   *
   * <p>Method under test: {@link PDAcroForm#PDAcroForm(PDDocument)}
   */
  @Test
  @DisplayName("Test new PDAcroForm(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.<init>(PDDocument)"})
  void testNewPDAcroForm() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act
    PDAcroForm actualPdAcroForm = new PDAcroForm(doc);

    // Assert
    assertEquals("", actualPdAcroForm.getDefaultAppearance());
    assertNull(actualPdAcroForm.getDefaultResources());
    assertNull(actualPdAcroForm.getXFA());
    assertNull(actualPdAcroForm.getScriptingHandler());
    assertEquals(0, actualPdAcroForm.getQ());
    assertFalse(actualPdAcroForm.getFieldIterator().hasNext());
    assertFalse(actualPdAcroForm.getNeedAppearances());
    assertFalse(actualPdAcroForm.isAppendOnly());
    assertFalse(actualPdAcroForm.isCachingFields());
    assertFalse(actualPdAcroForm.isSignaturesExist());
    assertTrue(actualPdAcroForm.getCalcOrder().isEmpty());
    assertTrue(actualPdAcroForm.getFields().isEmpty());
    assertSame(doc, actualPdAcroForm.getDocument());
  }

  /**
   * Test {@link PDAcroForm#getCOSObject()}.
   *
   * <p>Method under test: {@link PDAcroForm#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDAcroForm.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = new PDAcroForm(new PDDocument()).getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(1, actualCOSObject.getValues().size());
    assertEquals(1, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDAcroForm#exportFDF()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#exportFDF()}
   */
  @Test
  @DisplayName("Test exportFDF(); given PDAcroForm(PDDocument) with doc is PDDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FDFDocument PDAcroForm.exportFDF()"})
  void testExportFDF_givenPDAcroFormWithDocIsPDDocument() throws IOException {
    // Arrange and Act
    FDFDocument actualExportFDFResult = new PDAcroForm(new PDDocument()).exportFDF();

    // Assert
    FDFCatalog catalog = actualExportFDFResult.getCatalog();
    COSDictionary cOSObject = catalog.getCOSObject();
    Iterator<COSBase> iteratorResult = cOSObject.toIncrement().iterator();
    COSBase actualNextResult = iteratorResult.next();
    COSBase actualNextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(cOSObject, actualNextResult);
    COSDictionary cOSObject2 = catalog.getFDF().getCOSObject();
    Iterator<COSBase> iteratorResult2 = cOSObject2.toIncrement().iterator();
    COSBase actualNextResult3 = iteratorResult2.next();
    assertFalse(iteratorResult2.hasNext());
    assertSame(cOSObject2, actualNextResult3);
    COSDictionary trailer = actualExportFDFResult.getDocument().getTrailer();
    Iterator<COSBase> iteratorResult3 = trailer.toIncrement().iterator();
    COSBase actualNextResult4 = iteratorResult3.next();
    COSBase actualNextResult5 = iteratorResult3.next();
    assertTrue(iteratorResult3.hasNext());
    assertSame(trailer, actualNextResult4);
    assertSame(cOSObject, actualNextResult5);
    assertSame(cOSObject2, actualNextResult2);
  }

  /**
   * Test {@link PDAcroForm#flatten(List, boolean)} with {@code List}, {@code boolean}.
   *
   * <p>Method under test: {@link PDAcroForm#flatten(List, boolean)}
   */
  @Test
  @DisplayName("Test flatten(List, boolean) with 'List', 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.flatten(List, boolean)"})
  void testFlattenWithListBoolean() throws IOException {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());

    ArrayList<PDField> fields = new ArrayList<>();
    fields.add(new PDCheckBox(new PDAcroForm(new PDDocument())));

    // Act
    pdAcroForm.flatten(fields, true);

    // Assert that nothing has changed
    assertEquals(
        1, pdAcroForm.getDocument().getPages().getCOSObject().toIncrement().getObjects().size());
  }

  /**
   * Test {@link PDAcroForm#flatten(List, boolean)} with {@code List}, {@code boolean}.
   *
   * <p>Method under test: {@link PDAcroForm#flatten(List, boolean)}
   */
  @Test
  @DisplayName("Test flatten(List, boolean) with 'List', 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.flatten(List, boolean)"})
  void testFlattenWithListBoolean2() throws IOException {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());

    ArrayList<PDField> fields = new ArrayList<>();
    fields.add(new PDCheckBox(new PDAcroForm(new PDDocument())));
    fields.add(new PDCheckBox(new PDAcroForm(new PDDocument())));

    // Act
    pdAcroForm.flatten(fields, true);

    // Assert that nothing has changed
    assertEquals(
        1, pdAcroForm.getDocument().getPages().getCOSObject().toIncrement().getObjects().size());
  }

  /**
   * Test {@link PDAcroForm#flatten(List, boolean)} with {@code List}, {@code boolean}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#flatten(List, boolean)}
   */
  @Test
  @DisplayName("Test flatten(List, boolean) with 'List', 'boolean'; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.flatten(List, boolean)"})
  void testFlattenWithListBoolean_whenArrayList() throws IOException {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());

    // Act
    pdAcroForm.flatten(new ArrayList<>(), true);

    // Assert that nothing has changed
    assertEquals(
        1, pdAcroForm.getDocument().getPages().getCOSObject().toIncrement().getObjects().size());
  }

  /**
   * Test {@link PDAcroForm#flatten()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDPage#PDPage()}.
   *   <li>Then calls {@link PDPageTree#add(PDPage)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#flatten()}
   */
  @Test
  @DisplayName("Test flatten(); given ArrayList() add PDPage(); then calls add(PDPage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.flatten()"})
  void testFlatten_givenArrayListAddPDPage_thenCallsAdd() throws IOException {
    // Arrange
    ArrayList<PDPage> pdPageList = new ArrayList<>();
    pdPageList.add(new PDPage());

    PDPageTree pdPageTree = mock(PDPageTree.class);
    when(pdPageTree.iterator()).thenReturn(pdPageList.iterator());
    doNothing().when(pdPageTree).add(Mockito.<PDPage>any());
    pdPageTree.add(new PDPage());

    PDDocument doc = mock(PDDocument.class);
    when(doc.getSignatureDictionaries()).thenReturn(new ArrayList<>());
    when(doc.getPages()).thenReturn(pdPageTree);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cosDictionary.getCOSObject()).thenReturn(COSBoolean.FALSE);
    when(cosDictionary.getString(Mockito.<COSName>any())).thenReturn("String");

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.removeObject(Mockito.<COSBase>any())).thenReturn(true);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray2.size()).thenReturn(3);
    doNothing().when(cosArray2).add(Mockito.<COSBase>any());
    cosArray2.add(COSBoolean.FALSE);

    COSDictionary form = mock(COSDictionary.class);
    when(form.getBoolean(Mockito.<COSName>any(), anyBoolean())).thenReturn(true);
    doNothing().when(form).removeItem(Mockito.<COSName>any());
    when(form.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);

    PDAcroForm pdAcroForm = new PDAcroForm(doc, form);

    // Act
    pdAcroForm.flatten();

    // Assert
    verify(cosArray2).add(isA(COSBase.class));
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(cosArray2, atLeast(1)).removeObject(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).size();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).getCOSObject();
    verify(form, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getBoolean(isA(COSName.class), eq(false));
    verify(form, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getString(isA(COSName.class));
    verify(form, atLeast(1)).removeItem(Mockito.<COSName>any());
    verify(doc).getPages();
    verify(doc).getSignatureDictionaries();
    verify(pdPageTree).add(isA(PDPage.class));
    verify(pdPageTree).iterator();
  }

  /**
   * Test {@link PDAcroForm#flatten()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDSignature#PDSignature()}.
   *   <li>Then calls {@link PDDocument#getPages()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#flatten()}
   */
  @Test
  @DisplayName("Test flatten(); given ArrayList() add PDSignature(); then calls getPages()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.flatten()"})
  void testFlatten_givenArrayListAddPDSignature_thenCallsGetPages() throws IOException {
    // Arrange
    ArrayList<PDSignature> pdSignatureList = new ArrayList<>();
    pdSignatureList.add(new PDSignature());

    PDDocument doc = mock(PDDocument.class);
    when(doc.getSignatureDictionaries()).thenReturn(pdSignatureList);
    when(doc.getPages()).thenReturn(new PDPageTree());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cosDictionary.getCOSObject()).thenReturn(COSBoolean.FALSE);
    when(cosDictionary.getString(Mockito.<COSName>any())).thenReturn("String");

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.removeObject(Mockito.<COSBase>any())).thenReturn(true);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray2.size()).thenReturn(3);
    doNothing().when(cosArray2).add(Mockito.<COSBase>any());
    cosArray2.add(COSBoolean.FALSE);

    COSDictionary form = mock(COSDictionary.class);
    when(form.getBoolean(Mockito.<COSName>any(), anyBoolean())).thenReturn(true);
    doNothing().when(form).removeItem(Mockito.<COSName>any());
    when(form.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);

    PDAcroForm pdAcroForm = new PDAcroForm(doc, form);

    // Act
    pdAcroForm.flatten();

    // Assert
    verify(cosArray2).add(isA(COSBase.class));
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(cosArray2, atLeast(1)).removeObject(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).size();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).getCOSObject();
    verify(form, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getBoolean(isA(COSName.class), eq(false));
    verify(form, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getString(isA(COSName.class));
    verify(form).removeItem(isA(COSName.class));
    verify(doc).getPages();
    verify(doc).getSignatureDictionaries();
  }

  /**
   * Test {@link PDAcroForm#flatten()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   *   <li>Then calls {@link COSDictionary#containsKey(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#flatten()}
   */
  @Test
  @DisplayName("Test flatten(); given COSArray() add FALSE; then calls containsKey(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.flatten()"})
  void testFlatten_givenCOSArrayAddFalse_thenCallsContainsKey() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);

    COSDictionary form = mock(COSDictionary.class);
    when(form.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);

    // Act
    pdAcroForm.flatten();

    // Assert
    verify(form).containsKey(isA(COSName.class));
    verify(form).getCOSArray(isA(COSName.class));
  }

  /**
   * Test {@link PDAcroForm#flatten()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   *   <li>Then calls {@link COSDictionary#getNameAsString(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#flatten()}
   */
  @Test
  @DisplayName("Test flatten(); given COSArray() add FALSE; then calls getNameAsString(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.flatten()"})
  void testFlatten_givenCOSArrayAddFalse_thenCallsGetNameAsString() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray2.size()).thenReturn(3);
    doNothing().when(cosArray2).add(Mockito.<COSBase>any());
    cosArray2.add(COSBoolean.FALSE);

    COSDictionary form = mock(COSDictionary.class);
    when(form.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);

    // Act
    pdAcroForm.flatten();

    // Assert
    verify(cosArray2).add(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray2, atLeast(1)).size();
    verify(form).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Test {@link PDAcroForm#flatten()}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then calls {@link COSArray#add(COSBase)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#flatten()}
   */
  @Test
  @DisplayName(
      "Test flatten(); given COSArray getObject(int) return COSDictionary(); then calls add(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.flatten()"})
  void testFlatten_givenCOSArrayGetObjectReturnCOSDictionary_thenCallsAdd() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(new COSDictionary());
    when(cosArray.size()).thenReturn(3);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary form = mock(COSDictionary.class);
    when(form.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);

    // Act
    pdAcroForm.flatten();

    // Assert
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(form).containsKey(isA(COSName.class));
    verify(form).getCOSArray(isA(COSName.class));
  }

  /**
   * Test {@link PDAcroForm#flatten()}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then calls {@link COSArray#isEmpty()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#flatten()}
   */
  @Test
  @DisplayName(
      "Test flatten(); given COSArray getObject(int) return COSDictionary(); then calls isEmpty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.flatten()"})
  void testFlatten_givenCOSArrayGetObjectReturnCOSDictionary_thenCallsIsEmpty() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(new COSDictionary());
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray2.size()).thenReturn(3);
    doNothing().when(cosArray2).add(Mockito.<COSBase>any());
    cosArray2.add(COSBoolean.FALSE);

    COSDictionary form = mock(COSDictionary.class);
    when(form.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);

    // Act
    pdAcroForm.flatten();

    // Assert
    verify(cosArray2).add(isA(COSBase.class));
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(cosArray2, atLeast(1)).size();
    verify(cosArray, atLeast(1)).size();
    verify(form).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Test {@link PDAcroForm#flatten()}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return {@link COSBoolean#FALSE}.
   *   <li>Then calls {@link COSArray#add(COSBase)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#flatten()}
   */
  @Test
  @DisplayName(
      "Test flatten(); given COSArray getObject(int) return FALSE; then calls add(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.flatten()"})
  void testFlatten_givenCOSArrayGetObjectReturnFalse_thenCallsAdd() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray.size()).thenReturn(3);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary form = mock(COSDictionary.class);
    when(form.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);

    // Act
    pdAcroForm.flatten();

    // Assert
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(form).containsKey(isA(COSName.class));
    verify(form).getCOSArray(isA(COSName.class));
  }

  /**
   * Test {@link PDAcroForm#flatten()}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return {@link COSBoolean#FALSE}.
   *   <li>Then calls {@link COSArray#isEmpty()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#flatten()}
   */
  @Test
  @DisplayName("Test flatten(); given COSArray getObject(int) return FALSE; then calls isEmpty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.flatten()"})
  void testFlatten_givenCOSArrayGetObjectReturnFalse_thenCallsIsEmpty() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray2.size()).thenReturn(3);
    doNothing().when(cosArray2).add(Mockito.<COSBase>any());
    cosArray2.add(COSBoolean.FALSE);

    COSDictionary form = mock(COSDictionary.class);
    when(form.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);

    // Act
    pdAcroForm.flatten();

    // Assert
    verify(cosArray2).add(isA(COSBase.class));
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(cosArray2, atLeast(1)).size();
    verify(cosArray, atLeast(1)).size();
    verify(form).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Test {@link PDAcroForm#flatten()}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#isEmpty()} return {@code true}.
   *   <li>Then calls {@link COSArray#isEmpty()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#flatten()}
   */
  @Test
  @DisplayName("Test flatten(); given COSArray isEmpty() return 'true'; then calls isEmpty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.flatten()"})
  void testFlatten_givenCOSArrayIsEmptyReturnTrue_thenCallsIsEmpty() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isEmpty()).thenReturn(true);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray2.size()).thenReturn(3);
    doNothing().when(cosArray2).add(Mockito.<COSBase>any());
    cosArray2.add(COSBoolean.FALSE);

    COSDictionary form = mock(COSDictionary.class);
    when(form.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);

    // Act
    pdAcroForm.flatten();

    // Assert
    verify(cosArray2).add(isA(COSBase.class));
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(cosArray2, atLeast(1)).size();
    verify(form).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Test {@link PDAcroForm#flatten()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getBoolean(COSName, boolean)} return
   *       {@code false}.
   *   <li>Then calls {@link PDPageTree#add(PDPage)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#flatten()}
   */
  @Test
  @DisplayName(
      "Test flatten(); given COSDictionary getBoolean(COSName, boolean) return 'false'; then calls add(PDPage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.flatten()"})
  void testFlatten_givenCOSDictionaryGetBooleanReturnFalse_thenCallsAdd() throws IOException {
    // Arrange
    PDPageTree pdPageTree = mock(PDPageTree.class);

    ArrayList<PDPage> pdPageList = new ArrayList<>();
    when(pdPageTree.iterator()).thenReturn(pdPageList.iterator());
    doNothing().when(pdPageTree).add(Mockito.<PDPage>any());
    pdPageTree.add(new PDPage());

    PDDocument doc = mock(PDDocument.class);
    when(doc.getSignatureDictionaries()).thenReturn(new ArrayList<>());
    when(doc.getPages()).thenReturn(pdPageTree);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cosDictionary.getCOSObject()).thenReturn(COSBoolean.FALSE);
    when(cosDictionary.getString(Mockito.<COSName>any())).thenReturn("String");

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.removeObject(Mockito.<COSBase>any())).thenReturn(true);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray2.size()).thenReturn(3);
    doNothing().when(cosArray2).add(Mockito.<COSBase>any());
    cosArray2.add(COSBoolean.FALSE);

    COSDictionary form = mock(COSDictionary.class);
    when(form.getBoolean(Mockito.<COSName>any(), anyBoolean())).thenReturn(false);
    doNothing().when(form).removeItem(Mockito.<COSName>any());
    when(form.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);

    PDAcroForm pdAcroForm = new PDAcroForm(doc, form);

    // Act
    pdAcroForm.flatten();

    // Assert
    verify(cosArray2).add(isA(COSBase.class));
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(cosArray2, atLeast(1)).removeObject(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).size();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).getCOSObject();
    verify(form, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getBoolean(isA(COSName.class), eq(false));
    verify(form, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getString(isA(COSName.class));
    verify(form, atLeast(1)).removeItem(Mockito.<COSName>any());
    verify(doc).getPages();
    verify(doc).getSignatureDictionaries();
    verify(pdPageTree).add(isA(PDPage.class));
    verify(pdPageTree).iterator();
  }

  /**
   * Test {@link PDAcroForm#flatten()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)} return {@link
   *       COSArray#COSArray()}.
   *   <li>Then calls {@link PDPageTree#add(PDPage)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#flatten()}
   */
  @Test
  @DisplayName(
      "Test flatten(); given COSDictionary getCOSArray(COSName) return COSArray(); then calls add(PDPage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.flatten()"})
  void testFlatten_givenCOSDictionaryGetCOSArrayReturnCOSArray_thenCallsAdd() throws IOException {
    // Arrange
    PDPageTree pdPageTree = mock(PDPageTree.class);

    ArrayList<PDPage> pdPageList = new ArrayList<>();
    when(pdPageTree.iterator()).thenReturn(pdPageList.iterator());
    doNothing().when(pdPageTree).add(Mockito.<PDPage>any());
    pdPageTree.add(new PDPage());

    PDDocument doc = mock(PDDocument.class);
    when(doc.getSignatureDictionaries()).thenReturn(new ArrayList<>());
    when(doc.getPages()).thenReturn(pdPageTree);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cosDictionary.getCOSObject()).thenReturn(COSBoolean.FALSE);
    when(cosDictionary.getString(Mockito.<COSName>any())).thenReturn("String");

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.removeObject(Mockito.<COSBase>any())).thenReturn(true);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray2.size()).thenReturn(3);
    doNothing().when(cosArray2).add(Mockito.<COSBase>any());
    cosArray2.add(COSBoolean.FALSE);

    COSDictionary form = mock(COSDictionary.class);
    when(form.getBoolean(Mockito.<COSName>any(), anyBoolean())).thenReturn(true);
    doNothing().when(form).removeItem(Mockito.<COSName>any());
    when(form.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);

    PDAcroForm pdAcroForm = new PDAcroForm(doc, form);

    // Act
    pdAcroForm.flatten();

    // Assert
    verify(cosArray2).add(isA(COSBase.class));
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(cosArray2, atLeast(1)).removeObject(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).size();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).getCOSObject();
    verify(form, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getBoolean(isA(COSName.class), eq(false));
    verify(form, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getString(isA(COSName.class));
    verify(form, atLeast(1)).removeItem(Mockito.<COSName>any());
    verify(doc).getPages();
    verify(doc).getSignatureDictionaries();
    verify(pdPageTree).add(isA(PDPage.class));
    verify(pdPageTree).iterator();
  }

  /**
   * Test {@link PDAcroForm#flatten()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)} return {@code
   *       null}.
   *   <li>Then calls {@link COSDictionary#containsKey(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#flatten()}
   */
  @Test
  @DisplayName(
      "Test flatten(); given COSDictionary getCOSArray(COSName) return 'null'; then calls containsKey(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.flatten()"})
  void testFlatten_givenCOSDictionaryGetCOSArrayReturnNull_thenCallsContainsKey()
      throws IOException {
    // Arrange
    COSDictionary form = mock(COSDictionary.class);
    when(form.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(null);
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);

    // Act
    pdAcroForm.flatten();

    // Assert
    verify(form).containsKey(isA(COSName.class));
    verify(form).getCOSArray(isA(COSName.class));
  }

  /**
   * Test {@link PDAcroForm#flatten()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)} return {@code
   *       null}.
   *   <li>Then calls {@link COSDictionary#getNameAsString(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#flatten()}
   */
  @Test
  @DisplayName(
      "Test flatten(); given COSDictionary getCOSArray(COSName) return 'null'; then calls getNameAsString(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.flatten()"})
  void testFlatten_givenCOSDictionaryGetCOSArrayReturnNull_thenCallsGetNameAsString()
      throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(null);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.size()).thenReturn(3);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary form = mock(COSDictionary.class);
    when(form.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);

    // Act
    pdAcroForm.flatten();

    // Assert
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(form).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Test {@link PDAcroForm#flatten()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return
   *       {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#flatten()}
   */
  @Test
  @DisplayName("Test flatten(); given COSDictionary getDictionaryObject(COSName) return A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.flatten()"})
  void testFlatten_givenCOSDictionaryGetDictionaryObjectReturnA() throws IOException {
    // Arrange
    PDPageTree pdPageTree = mock(PDPageTree.class);

    ArrayList<PDPage> pdPageList = new ArrayList<>();
    when(pdPageTree.iterator()).thenReturn(pdPageList.iterator());
    doNothing().when(pdPageTree).add(Mockito.<PDPage>any());
    pdPageTree.add(new PDPage());

    PDDocument doc = mock(PDDocument.class);
    when(doc.getSignatureDictionaries()).thenReturn(new ArrayList<>());
    when(doc.getPages()).thenReturn(pdPageTree);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSName.A);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(cosDictionary).setName(Mockito.<COSName>any(), Mockito.<String>any());
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(null);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Ch");
    when(cosDictionary.getCOSObject()).thenReturn(COSBoolean.FALSE);
    when(cosDictionary.getString(Mockito.<COSName>any())).thenReturn("String");

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.removeObject(Mockito.<COSBase>any())).thenReturn(true);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getString(Mockito.<COSName>any())).thenReturn("String");
    when(cosDictionary2.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.removeObject(Mockito.<COSBase>any())).thenReturn(true);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray2.size()).thenReturn(3);
    doNothing().when(cosArray2).add(Mockito.<COSBase>any());
    cosArray2.add(COSBoolean.FALSE);

    COSDictionary form = mock(COSDictionary.class);
    when(form.getBoolean(Mockito.<COSName>any(), anyBoolean())).thenReturn(true);
    doNothing().when(form).removeItem(Mockito.<COSName>any());
    when(form.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);

    PDAcroForm pdAcroForm = new PDAcroForm(doc, form);

    // Act
    pdAcroForm.flatten();

    // Assert
    verify(cosArray2).add(isA(COSBase.class));
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(cosArray).removeObject(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).removeObject(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).size();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).getCOSObject();
    verify(form, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getBoolean(isA(COSName.class), eq(false));
    verify(form, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getString(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getString(isA(COSName.class));
    verify(form, atLeast(1)).removeItem(Mockito.<COSName>any());
    verify(cosDictionary).setName(isA(COSName.class), eq("Widget"));
    verify(doc).getPages();
    verify(doc).getSignatureDictionaries();
    verify(pdPageTree).add(isA(PDPage.class));
    verify(pdPageTree).iterator();
  }

  /**
   * Test {@link PDAcroForm#flatten()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return
   *       {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#flatten()}
   */
  @Test
  @DisplayName(
      "Test flatten(); given COSDictionary getDictionaryObject(COSName) return COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.flatten()"})
  void testFlatten_givenCOSDictionaryGetDictionaryObjectReturnCOSDictionary() throws IOException {
    // Arrange
    PDPageTree pdPageTree = mock(PDPageTree.class);

    ArrayList<PDPage> pdPageList = new ArrayList<>();
    when(pdPageTree.iterator()).thenReturn(pdPageList.iterator());
    doNothing().when(pdPageTree).add(Mockito.<PDPage>any());
    pdPageTree.add(new PDPage());

    PDDocument doc = mock(PDDocument.class);
    when(doc.getSignatureDictionaries()).thenReturn(new ArrayList<>());
    when(doc.getPages()).thenReturn(pdPageTree);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(cosDictionary).setName(Mockito.<COSName>any(), Mockito.<String>any());
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(null);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Ch");
    when(cosDictionary.getCOSObject()).thenReturn(COSBoolean.FALSE);
    when(cosDictionary.getString(Mockito.<COSName>any())).thenReturn("String");

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.removeObject(Mockito.<COSBase>any())).thenReturn(true);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getString(Mockito.<COSName>any())).thenReturn("String");
    when(cosDictionary2.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.removeObject(Mockito.<COSBase>any())).thenReturn(true);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray2.size()).thenReturn(3);
    doNothing().when(cosArray2).add(Mockito.<COSBase>any());
    cosArray2.add(COSBoolean.FALSE);

    COSDictionary form = mock(COSDictionary.class);
    when(form.getBoolean(Mockito.<COSName>any(), anyBoolean())).thenReturn(true);
    doNothing().when(form).removeItem(Mockito.<COSName>any());
    when(form.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);

    PDAcroForm pdAcroForm = new PDAcroForm(doc, form);

    // Act
    pdAcroForm.flatten();

    // Assert
    verify(cosArray2).add(isA(COSBase.class));
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(cosArray).removeObject(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).removeObject(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).size();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).getCOSObject();
    verify(form, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getBoolean(isA(COSName.class), eq(false));
    verify(form, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getString(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getString(isA(COSName.class));
    verify(form, atLeast(1)).removeItem(Mockito.<COSName>any());
    verify(cosDictionary).setName(isA(COSName.class), eq("Widget"));
    verify(doc).getPages();
    verify(doc).getSignatureDictionaries();
    verify(pdPageTree).add(isA(PDPage.class));
    verify(pdPageTree).iterator();
  }

  /**
   * Test {@link PDAcroForm#flatten()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return
   *       {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#flatten()}
   */
  @Test
  @DisplayName(
      "Test flatten(); given COSDictionary getDictionaryObject(COSName) return COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.flatten()"})
  void testFlatten_givenCOSDictionaryGetDictionaryObjectReturnCOSStream() throws IOException {
    // Arrange
    PDPageTree pdPageTree = mock(PDPageTree.class);

    ArrayList<PDPage> pdPageList = new ArrayList<>();
    when(pdPageTree.iterator()).thenReturn(pdPageList.iterator());
    doNothing().when(pdPageTree).add(Mockito.<PDPage>any());
    pdPageTree.add(new PDPage());

    PDDocument doc = mock(PDDocument.class);
    when(doc.getSignatureDictionaries()).thenReturn(new ArrayList<>());
    when(doc.getPages()).thenReturn(pdPageTree);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSStream());
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(cosDictionary).setName(Mockito.<COSName>any(), Mockito.<String>any());
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(null);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Ch");
    when(cosDictionary.getCOSObject()).thenReturn(COSBoolean.FALSE);
    when(cosDictionary.getString(Mockito.<COSName>any())).thenReturn("String");

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.removeObject(Mockito.<COSBase>any())).thenReturn(true);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getString(Mockito.<COSName>any())).thenReturn("String");
    when(cosDictionary2.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.removeObject(Mockito.<COSBase>any())).thenReturn(true);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray2.size()).thenReturn(3);
    doNothing().when(cosArray2).add(Mockito.<COSBase>any());
    cosArray2.add(COSBoolean.FALSE);

    COSDictionary form = mock(COSDictionary.class);
    when(form.getBoolean(Mockito.<COSName>any(), anyBoolean())).thenReturn(true);
    doNothing().when(form).removeItem(Mockito.<COSName>any());
    when(form.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);

    PDAcroForm pdAcroForm = new PDAcroForm(doc, form);

    // Act
    pdAcroForm.flatten();

    // Assert
    verify(cosArray2).add(isA(COSBase.class));
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(cosArray).removeObject(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).removeObject(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).size();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).getCOSObject();
    verify(form, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getBoolean(isA(COSName.class), eq(false));
    verify(form, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getString(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getString(isA(COSName.class));
    verify(form, atLeast(1)).removeItem(Mockito.<COSName>any());
    verify(cosDictionary).setName(isA(COSName.class), eq("Widget"));
    verify(doc).getPages();
    verify(doc).getSignatureDictionaries();
    verify(pdPageTree).add(isA(PDPage.class));
    verify(pdPageTree).iterator();
  }

  /**
   * Test {@link PDAcroForm#flatten()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return
   *       {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#flatten()}
   */
  @Test
  @DisplayName("Test flatten(); given COSDictionary getDictionaryObject(COSName) return FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.flatten()"})
  void testFlatten_givenCOSDictionaryGetDictionaryObjectReturnFalse() throws IOException {
    // Arrange
    PDPageTree pdPageTree = mock(PDPageTree.class);

    ArrayList<PDPage> pdPageList = new ArrayList<>();
    when(pdPageTree.iterator()).thenReturn(pdPageList.iterator());
    doNothing().when(pdPageTree).add(Mockito.<PDPage>any());
    pdPageTree.add(new PDPage());

    PDDocument doc = mock(PDDocument.class);
    when(doc.getSignatureDictionaries()).thenReturn(new ArrayList<>());
    when(doc.getPages()).thenReturn(pdPageTree);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(cosDictionary).setName(Mockito.<COSName>any(), Mockito.<String>any());
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(null);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Ch");
    when(cosDictionary.getCOSObject()).thenReturn(COSBoolean.FALSE);
    when(cosDictionary.getString(Mockito.<COSName>any())).thenReturn("String");

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.removeObject(Mockito.<COSBase>any())).thenReturn(true);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getString(Mockito.<COSName>any())).thenReturn("String");
    when(cosDictionary2.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.removeObject(Mockito.<COSBase>any())).thenReturn(true);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray2.size()).thenReturn(3);
    doNothing().when(cosArray2).add(Mockito.<COSBase>any());
    cosArray2.add(COSBoolean.FALSE);

    COSDictionary form = mock(COSDictionary.class);
    when(form.getBoolean(Mockito.<COSName>any(), anyBoolean())).thenReturn(true);
    doNothing().when(form).removeItem(Mockito.<COSName>any());
    when(form.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);

    PDAcroForm pdAcroForm = new PDAcroForm(doc, form);

    // Act
    pdAcroForm.flatten();

    // Assert
    verify(cosArray2).add(isA(COSBase.class));
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(cosArray).removeObject(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).removeObject(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).size();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).getCOSObject();
    verify(form, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getBoolean(isA(COSName.class), eq(false));
    verify(form, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getString(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getString(isA(COSName.class));
    verify(form, atLeast(1)).removeItem(Mockito.<COSName>any());
    verify(cosDictionary).setName(isA(COSName.class), eq("Widget"));
    verify(doc).getPages();
    verify(doc).getSignatureDictionaries();
    verify(pdPageTree).add(isA(PDPage.class));
    verify(pdPageTree).iterator();
  }

  /**
   * Test {@link PDAcroForm#flatten()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return
   *       {@code null}.
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSBase)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#flatten()}
   */
  @Test
  @DisplayName(
      "Test flatten(); given COSDictionary getDictionaryObject(COSName) return 'null'; then calls setItem(COSName, COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.flatten()"})
  void testFlatten_givenCOSDictionaryGetDictionaryObjectReturnNull_thenCallsSetItem()
      throws IOException {
    // Arrange
    PDPageTree pdPageTree = mock(PDPageTree.class);

    ArrayList<PDPage> pdPageList = new ArrayList<>();
    when(pdPageTree.iterator()).thenReturn(pdPageList.iterator());
    doNothing().when(pdPageTree).add(Mockito.<PDPage>any());
    pdPageTree.add(new PDPage());

    PDDocument doc = mock(PDDocument.class);
    when(doc.getSignatureDictionaries()).thenReturn(new ArrayList<>());
    when(doc.getPages()).thenReturn(pdPageTree);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(null);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(cosDictionary).setName(Mockito.<COSName>any(), Mockito.<String>any());
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(null);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Ch");
    when(cosDictionary.getCOSObject()).thenReturn(COSBoolean.FALSE);
    when(cosDictionary.getString(Mockito.<COSName>any())).thenReturn("String");

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.removeObject(Mockito.<COSBase>any())).thenReturn(true);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getString(Mockito.<COSName>any())).thenReturn("String");
    when(cosDictionary2.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.removeObject(Mockito.<COSBase>any())).thenReturn(true);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray2.size()).thenReturn(3);
    doNothing().when(cosArray2).add(Mockito.<COSBase>any());
    cosArray2.add(COSBoolean.FALSE);

    COSDictionary form = mock(COSDictionary.class);
    when(form.getBoolean(Mockito.<COSName>any(), anyBoolean())).thenReturn(true);
    doNothing().when(form).removeItem(Mockito.<COSName>any());
    when(form.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);

    PDAcroForm pdAcroForm = new PDAcroForm(doc, form);

    // Act
    pdAcroForm.flatten();

    // Assert
    verify(cosArray2).add(isA(COSBase.class));
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(cosArray).removeObject(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).removeObject(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).size();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).getCOSObject();
    verify(form, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getBoolean(isA(COSName.class), eq(false));
    verify(form, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getString(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getString(isA(COSName.class));
    verify(form, atLeast(1)).removeItem(Mockito.<COSName>any());
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(cosDictionary).setName(isA(COSName.class), eq("Widget"));
    verify(doc).getPages();
    verify(doc).getSignatureDictionaries();
    verify(pdPageTree).add(isA(PDPage.class));
    verify(pdPageTree).iterator();
  }

  /**
   * Test {@link PDAcroForm#flatten()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return
   *       {@link COSInteger#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#flatten()}
   */
  @Test
  @DisplayName("Test flatten(); given COSDictionary getDictionaryObject(COSName) return ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.flatten()"})
  void testFlatten_givenCOSDictionaryGetDictionaryObjectReturnOne() throws IOException {
    // Arrange
    PDPageTree pdPageTree = mock(PDPageTree.class);

    ArrayList<PDPage> pdPageList = new ArrayList<>();
    when(pdPageTree.iterator()).thenReturn(pdPageList.iterator());
    doNothing().when(pdPageTree).add(Mockito.<PDPage>any());
    pdPageTree.add(new PDPage());

    PDDocument doc = mock(PDDocument.class);
    when(doc.getSignatureDictionaries()).thenReturn(new ArrayList<>());
    when(doc.getPages()).thenReturn(pdPageTree);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSInteger.ONE);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(cosDictionary).setName(Mockito.<COSName>any(), Mockito.<String>any());
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(null);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Ch");
    when(cosDictionary.getCOSObject()).thenReturn(COSBoolean.FALSE);
    when(cosDictionary.getString(Mockito.<COSName>any())).thenReturn("String");

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.removeObject(Mockito.<COSBase>any())).thenReturn(true);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getString(Mockito.<COSName>any())).thenReturn("String");
    when(cosDictionary2.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.removeObject(Mockito.<COSBase>any())).thenReturn(true);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray2.size()).thenReturn(3);
    doNothing().when(cosArray2).add(Mockito.<COSBase>any());
    cosArray2.add(COSBoolean.FALSE);

    COSDictionary form = mock(COSDictionary.class);
    when(form.getBoolean(Mockito.<COSName>any(), anyBoolean())).thenReturn(true);
    doNothing().when(form).removeItem(Mockito.<COSName>any());
    when(form.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);

    PDAcroForm pdAcroForm = new PDAcroForm(doc, form);

    // Act
    pdAcroForm.flatten();

    // Assert
    verify(cosArray2).add(isA(COSBase.class));
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(cosArray).removeObject(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).removeObject(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).size();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).getCOSObject();
    verify(form, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getBoolean(isA(COSName.class), eq(false));
    verify(form, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getString(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getString(isA(COSName.class));
    verify(form, atLeast(1)).removeItem(Mockito.<COSName>any());
    verify(cosDictionary).setName(isA(COSName.class), eq("Widget"));
    verify(doc).getPages();
    verify(doc).getSignatureDictionaries();
    verify(pdPageTree).add(isA(PDPage.class));
    verify(pdPageTree).iterator();
  }

  /**
   * Test {@link PDAcroForm#flatten()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getInt(COSName, int)} return one.
   *   <li>Then calls {@link COSDictionary#getInt(COSName, int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#flatten()}
   */
  @Test
  @DisplayName(
      "Test flatten(); given COSDictionary getInt(COSName, int) return one; then calls getInt(COSName, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.flatten()"})
  void testFlatten_givenCOSDictionaryGetIntReturnOne_thenCallsGetInt() throws IOException {
    // Arrange
    PDPageTree pdPageTree = mock(PDPageTree.class);

    ArrayList<PDPage> pdPageList = new ArrayList<>();
    when(pdPageTree.iterator()).thenReturn(pdPageList.iterator());
    doNothing().when(pdPageTree).add(Mockito.<PDPage>any());
    pdPageTree.add(new PDPage());

    PDDocument doc = mock(PDDocument.class);
    when(doc.getSignatureDictionaries()).thenReturn(new ArrayList<>());
    when(doc.getPages()).thenReturn(pdPageTree);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Ch");
    when(cosDictionary.getCOSObject()).thenReturn(COSBoolean.FALSE);
    when(cosDictionary.getString(Mockito.<COSName>any())).thenReturn("String");

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.removeObject(Mockito.<COSBase>any())).thenReturn(true);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getString(Mockito.<COSName>any())).thenReturn("String");
    when(cosDictionary2.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.removeObject(Mockito.<COSBase>any())).thenReturn(true);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray2.size()).thenReturn(3);
    doNothing().when(cosArray2).add(Mockito.<COSBase>any());
    cosArray2.add(COSBoolean.FALSE);

    COSDictionary form = mock(COSDictionary.class);
    when(form.getBoolean(Mockito.<COSName>any(), anyBoolean())).thenReturn(true);
    doNothing().when(form).removeItem(Mockito.<COSName>any());
    when(form.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);

    PDAcroForm pdAcroForm = new PDAcroForm(doc, form);

    // Act
    pdAcroForm.flatten();

    // Assert
    verify(cosArray2).add(isA(COSBase.class));
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(cosArray).removeObject(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).removeObject(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).size();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).getCOSObject();
    verify(form, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getBoolean(isA(COSName.class), eq(false));
    verify(form, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getString(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getString(isA(COSName.class));
    verify(form, atLeast(1)).removeItem(Mockito.<COSName>any());
    verify(doc).getPages();
    verify(doc).getSignatureDictionaries();
    verify(pdPageTree).add(isA(PDPage.class));
    verify(pdPageTree).iterator();
  }

  /**
   * Test {@link PDAcroForm#flatten()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument, COSDictionary)} with doc is {@link
   *       PDDocument#PDDocument()} and form is {@link COSDictionary}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#flatten()}
   */
  @Test
  @DisplayName(
      "Test flatten(); given PDAcroForm(PDDocument, COSDictionary) with doc is PDDocument() and form is COSDictionary")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.flatten()"})
  void testFlatten_givenPDAcroFormWithDocIsPDDocumentAndFormIsCOSDictionary() throws IOException {
    // Arrange
    COSDictionary form = mock(COSDictionary.class);
    when(form.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);

    // Act
    pdAcroForm.flatten();

    // Assert
    verify(form).containsKey(isA(COSName.class));
    verify(form).getCOSArray(isA(COSName.class));
  }

  /**
   * Test {@link PDAcroForm#flatten()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument, COSDictionary)} with doc is {@link
   *       PDDocument#PDDocument()} and form is {@link COSDictionary}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#flatten()}
   */
  @Test
  @DisplayName(
      "Test flatten(); given PDAcroForm(PDDocument, COSDictionary) with doc is PDDocument() and form is COSDictionary")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.flatten()"})
  void testFlatten_givenPDAcroFormWithDocIsPDDocumentAndFormIsCOSDictionary2() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.size()).thenReturn(3);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary form = mock(COSDictionary.class);
    when(form.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);

    // Act
    pdAcroForm.flatten();

    // Assert
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(form).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Test {@link PDAcroForm#flatten()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument, COSDictionary)} with doc is {@link
   *       PDDocument#PDDocument()} and form is {@link COSDictionary}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#flatten()}
   */
  @Test
  @DisplayName(
      "Test flatten(); given PDAcroForm(PDDocument, COSDictionary) with doc is PDDocument() and form is COSDictionary")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.flatten()"})
  void testFlatten_givenPDAcroFormWithDocIsPDDocumentAndFormIsCOSDictionary3() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cosDictionary.getCOSObject()).thenReturn(COSBoolean.FALSE);
    when(cosDictionary.getString(Mockito.<COSName>any())).thenReturn("String");

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.removeObject(Mockito.<COSBase>any())).thenReturn(true);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray2.size()).thenReturn(3);
    doNothing().when(cosArray2).add(Mockito.<COSBase>any());
    cosArray2.add(COSBoolean.FALSE);

    COSDictionary form = mock(COSDictionary.class);
    when(form.getBoolean(Mockito.<COSName>any(), anyBoolean())).thenReturn(true);
    doNothing().when(form).removeItem(Mockito.<COSName>any());
    when(form.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);

    // Act
    pdAcroForm.flatten();

    // Assert
    verify(cosArray2).add(isA(COSBase.class));
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(cosArray2, atLeast(1)).removeObject(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).size();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).getCOSObject();
    verify(form, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getBoolean(isA(COSName.class), eq(false));
    verify(form, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getString(isA(COSName.class));
    verify(form, atLeast(1)).removeItem(Mockito.<COSName>any());
  }

  /**
   * Test {@link PDAcroForm#flatten()}.
   *
   * <ul>
   *   <li>Given {@link PDDocument} {@link PDDocument#getPages()} return {@link
   *       PDPageTree#PDPageTree(COSDictionary)} with root is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#flatten()}
   */
  @Test
  @DisplayName(
      "Test flatten(); given PDDocument getPages() return PDPageTree(COSDictionary) with root is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.flatten()"})
  void testFlatten_givenPDDocumentGetPagesReturnPDPageTreeWithRootIsCOSDictionary()
      throws IOException {
    // Arrange
    PDDocument doc = mock(PDDocument.class);
    when(doc.getSignatureDictionaries()).thenReturn(new ArrayList<>());
    when(doc.getPages()).thenReturn(new PDPageTree(new COSDictionary()));

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cosDictionary.getCOSObject()).thenReturn(COSBoolean.FALSE);
    when(cosDictionary.getString(Mockito.<COSName>any())).thenReturn("String");

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.removeObject(Mockito.<COSBase>any())).thenReturn(true);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray2.size()).thenReturn(3);
    doNothing().when(cosArray2).add(Mockito.<COSBase>any());
    cosArray2.add(COSBoolean.FALSE);

    COSDictionary form = mock(COSDictionary.class);
    when(form.getBoolean(Mockito.<COSName>any(), anyBoolean())).thenReturn(true);
    doNothing().when(form).removeItem(Mockito.<COSName>any());
    when(form.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);

    PDAcroForm pdAcroForm = new PDAcroForm(doc, form);

    // Act
    pdAcroForm.flatten();

    // Assert
    verify(cosArray2).add(isA(COSBase.class));
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(cosArray2, atLeast(1)).removeObject(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).size();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).getCOSObject();
    verify(form, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getBoolean(isA(COSName.class), eq(false));
    verify(form, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getString(isA(COSName.class));
    verify(form, atLeast(1)).removeItem(Mockito.<COSName>any());
    verify(doc).getPages();
    verify(doc).getSignatureDictionaries();
  }

  /**
   * Test {@link PDAcroForm#flatten()}.
   *
   * <ul>
   *   <li>Given {@link PDDocument} {@link PDDocument#getPages()} return {@link
   *       PDPageTree#PDPageTree()}.
   *   <li>Then calls {@link PDDocument#getPages()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#flatten()}
   */
  @Test
  @DisplayName(
      "Test flatten(); given PDDocument getPages() return PDPageTree(); then calls getPages()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.flatten()"})
  void testFlatten_givenPDDocumentGetPagesReturnPDPageTree_thenCallsGetPages() throws IOException {
    // Arrange
    PDDocument doc = mock(PDDocument.class);
    when(doc.getSignatureDictionaries()).thenReturn(new ArrayList<>());
    when(doc.getPages()).thenReturn(new PDPageTree());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cosDictionary.getCOSObject()).thenReturn(COSBoolean.FALSE);
    when(cosDictionary.getString(Mockito.<COSName>any())).thenReturn("String");

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.removeObject(Mockito.<COSBase>any())).thenReturn(true);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray2.size()).thenReturn(3);
    doNothing().when(cosArray2).add(Mockito.<COSBase>any());
    cosArray2.add(COSBoolean.FALSE);

    COSDictionary form = mock(COSDictionary.class);
    when(form.getBoolean(Mockito.<COSName>any(), anyBoolean())).thenReturn(true);
    doNothing().when(form).removeItem(Mockito.<COSName>any());
    when(form.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);

    PDAcroForm pdAcroForm = new PDAcroForm(doc, form);

    // Act
    pdAcroForm.flatten();

    // Assert
    verify(cosArray2).add(isA(COSBase.class));
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(cosArray2, atLeast(1)).removeObject(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).size();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).getCOSObject();
    verify(form, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getBoolean(isA(COSName.class), eq(false));
    verify(form, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getString(isA(COSName.class));
    verify(form, atLeast(1)).removeItem(Mockito.<COSName>any());
    verify(doc).getPages();
    verify(doc).getSignatureDictionaries();
  }

  /**
   * Test {@link PDAcroForm#flatten()}.
   *
   * <ul>
   *   <li>Given {@link PDPageTree#PDPageTree()} add {@link PDPage#PDPage()}.
   *   <li>Then calls {@link PDDocument#getPages()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#flatten()}
   */
  @Test
  @DisplayName("Test flatten(); given PDPageTree() add PDPage(); then calls getPages()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.flatten()"})
  void testFlatten_givenPDPageTreeAddPDPage_thenCallsGetPages() throws IOException {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree();
    pdPageTree.add(new PDPage());

    PDDocument doc = mock(PDDocument.class);
    when(doc.getSignatureDictionaries()).thenReturn(new ArrayList<>());
    when(doc.getPages()).thenReturn(pdPageTree);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cosDictionary.getCOSObject()).thenReturn(COSBoolean.FALSE);
    when(cosDictionary.getString(Mockito.<COSName>any())).thenReturn("String");

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.removeObject(Mockito.<COSBase>any())).thenReturn(true);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray2.size()).thenReturn(3);
    doNothing().when(cosArray2).add(Mockito.<COSBase>any());
    cosArray2.add(COSBoolean.FALSE);

    COSDictionary form = mock(COSDictionary.class);
    when(form.getBoolean(Mockito.<COSName>any(), anyBoolean())).thenReturn(true);
    doNothing().when(form).removeItem(Mockito.<COSName>any());
    when(form.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);

    PDAcroForm pdAcroForm = new PDAcroForm(doc, form);

    // Act
    pdAcroForm.flatten();

    // Assert
    verify(cosArray2).add(isA(COSBase.class));
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(cosArray2, atLeast(1)).removeObject(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).size();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).getCOSObject();
    verify(form, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getBoolean(isA(COSName.class), eq(false));
    verify(form, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getString(isA(COSName.class));
    verify(form, atLeast(1)).removeItem(Mockito.<COSName>any());
    verify(doc).getPages();
    verify(doc).getSignatureDictionaries();
  }

  /**
   * Test {@link PDAcroForm#refreshAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   *   <li>Then calls {@link COSDictionary#containsKey(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#refreshAppearances()}
   */
  @Test
  @DisplayName(
      "Test refreshAppearances(); given COSArray() add FALSE; then calls containsKey(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.refreshAppearances()"})
  void testRefreshAppearances_givenCOSArrayAddFalse_thenCallsContainsKey() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray2.size()).thenReturn(3);

    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);

    // Act
    pdAcroForm.refreshAppearances();

    // Assert
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray2, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Test {@link PDAcroForm#refreshAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#refreshAppearances()}
   */
  @Test
  @DisplayName("Test refreshAppearances(); given COSArray getObject(int) return COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.refreshAppearances()"})
  void testRefreshAppearances_givenCOSArrayGetObjectReturnCOSDictionary() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(new COSDictionary());
    when(cosArray.size()).thenReturn(3);

    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);

    // Act
    pdAcroForm.refreshAppearances();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(form).getCOSArray(isA(COSName.class));
  }

  /**
   * Test {@link PDAcroForm#refreshAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then calls {@link COSArray#add(COSBase)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#refreshAppearances()}
   */
  @Test
  @DisplayName(
      "Test refreshAppearances(); given COSArray getObject(int) return COSDictionary(); then calls add(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.refreshAppearances()"})
  void testRefreshAppearances_givenCOSArrayGetObjectReturnCOSDictionary_thenCallsAdd()
      throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(new COSDictionary());
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray2.size()).thenReturn(3);

    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);

    // Act
    pdAcroForm.refreshAppearances();

    // Assert
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(cosArray2, atLeast(1)).size();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Test {@link PDAcroForm#refreshAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return {@link COSBoolean#FALSE}.
   *   <li>Then calls {@link COSArray#add(COSBase)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#refreshAppearances()}
   */
  @Test
  @DisplayName(
      "Test refreshAppearances(); given COSArray getObject(int) return FALSE; then calls add(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.refreshAppearances()"})
  void testRefreshAppearances_givenCOSArrayGetObjectReturnFalse_thenCallsAdd() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray2.size()).thenReturn(3);

    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);

    // Act
    pdAcroForm.refreshAppearances();

    // Assert
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(cosArray2, atLeast(1)).size();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Test {@link PDAcroForm#refreshAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return {@link COSBoolean#FALSE}.
   *   <li>Then calls {@link COSArray#getObject(int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#refreshAppearances()}
   */
  @Test
  @DisplayName(
      "Test refreshAppearances(); given COSArray getObject(int) return FALSE; then calls getObject(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.refreshAppearances()"})
  void testRefreshAppearances_givenCOSArrayGetObjectReturnFalse_thenCallsGetObject()
      throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray.size()).thenReturn(3);

    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);

    // Act
    pdAcroForm.refreshAppearances();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(form).getCOSArray(isA(COSName.class));
  }

  /**
   * Test {@link PDAcroForm#refreshAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#isEmpty()} return {@code true}.
   *   <li>Then calls {@link COSArray#add(COSBase)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#refreshAppearances()}
   */
  @Test
  @DisplayName(
      "Test refreshAppearances(); given COSArray isEmpty() return 'true'; then calls add(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.refreshAppearances()"})
  void testRefreshAppearances_givenCOSArrayIsEmptyReturnTrue_thenCallsAdd() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isEmpty()).thenReturn(true);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray2.size()).thenReturn(3);

    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);

    // Act
    pdAcroForm.refreshAppearances();

    // Assert
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(cosArray2, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Test {@link PDAcroForm#refreshAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)} return {@link
   *       COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#refreshAppearances()}
   */
  @Test
  @DisplayName(
      "Test refreshAppearances(); given COSDictionary getCOSArray(COSName) return COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.refreshAppearances()"})
  void testRefreshAppearances_givenCOSDictionaryGetCOSArrayReturnCOSArray() throws IOException {
    // Arrange
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);

    // Act
    pdAcroForm.refreshAppearances();

    // Assert
    verify(form).getCOSArray(isA(COSName.class));
  }

  /**
   * Test {@link PDAcroForm#refreshAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)} return {@link
   *       COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#refreshAppearances()}
   */
  @Test
  @DisplayName(
      "Test refreshAppearances(); given COSDictionary getCOSArray(COSName) return COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.refreshAppearances()"})
  void testRefreshAppearances_givenCOSDictionaryGetCOSArrayReturnCOSArray2() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.size()).thenReturn(3);

    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);

    // Act
    pdAcroForm.refreshAppearances();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Test {@link PDAcroForm#refreshAppearances()}.
   *
   * <ul>
   *   <li>Then calls {@link COSDictionary#containsKey(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#refreshAppearances()}
   */
  @Test
  @DisplayName("Test refreshAppearances(); then calls containsKey(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.refreshAppearances()"})
  void testRefreshAppearances_thenCallsContainsKey() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(null);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.size()).thenReturn(3);

    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);

    // Act
    pdAcroForm.refreshAppearances();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Test {@link PDAcroForm#refreshAppearances()}.
   *
   * <ul>
   *   <li>Then calls {@link COSDictionary#getCOSDictionary(COSName, COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#refreshAppearances()}
   */
  @Test
  @DisplayName("Test refreshAppearances(); then calls getCOSDictionary(COSName, COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.refreshAppearances()"})
  void testRefreshAppearances_thenCallsGetCOSDictionary() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(false);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn(null);
    when(cosDictionary.getCOSObject()).thenReturn(COSBoolean.FALSE);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(new COSDictionary());
    when(cosDictionary.getString(Mockito.<COSName>any())).thenReturn("String");

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray2.size()).thenReturn(3);

    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);

    // Act
    pdAcroForm.refreshAppearances();

    // Assert
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(cosArray2, atLeast(1)).size();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).getCOSObject();
    verify(cosDictionary2, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getCOSArray(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getString(isA(COSName.class));
  }

  /**
   * Test {@link PDAcroForm#refreshAppearances()}.
   *
   * <ul>
   *   <li>Then calls {@link COSDictionary#getCOSObject()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#refreshAppearances()}
   */
  @Test
  @DisplayName("Test refreshAppearances(); then calls getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.refreshAppearances()"})
  void testRefreshAppearances_thenCallsGetCOSObject() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cosDictionary.getCOSObject()).thenReturn(COSBoolean.FALSE);
    when(cosDictionary.getString(Mockito.<COSName>any())).thenReturn("String");

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    doNothing().when(cosArray).add(Mockito.<COSBase>any());
    cosArray.add(COSBoolean.FALSE);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray2.size()).thenReturn(3);

    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);

    // Act
    pdAcroForm.refreshAppearances();

    // Assert
    verify(cosArray).add(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(cosArray2, atLeast(1)).size();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).getCOSObject();
    verify(cosDictionary2, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getCOSArray(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getString(isA(COSName.class));
  }

  /**
   * Test {@link PDAcroForm#getFields()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument, COSDictionary)} with doc is {@link
   *       PDDocument#PDDocument()} and form is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#getFields()}
   */
  @Test
  @DisplayName(
      "Test getFields(); given PDAcroForm(PDDocument, COSDictionary) with doc is PDDocument() and form is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDAcroForm.getFields()"})
  void testGetFields_givenPDAcroFormWithDocIsPDDocumentAndFormIsCOSDictionary() {
    // Arrange
    PDDocument doc = new PDDocument();
    PDAcroForm pdAcroForm = new PDAcroForm(doc, new COSDictionary());

    // Act and Assert
    assertTrue(pdAcroForm.getFields().isEmpty());
  }

  /**
   * Test {@link PDAcroForm#getFields()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#getFields()}
   */
  @Test
  @DisplayName(
      "Test getFields(); given PDAcroForm(PDDocument) with doc is PDDocument(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDAcroForm.getFields()"})
  void testGetFields_givenPDAcroFormWithDocIsPDDocument_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new PDAcroForm(new PDDocument()).getFields().isEmpty());
  }

  /**
   * Test {@link PDAcroForm#setFields(List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#setFields(List)}
   */
  @Test
  @DisplayName("Test setFields(List); given 'null'; when ArrayList() add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.setFields(List)"})
  void testSetFields_givenNull_whenArrayListAddNull() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());

    ArrayList<PDField> fields = new ArrayList<>();
    fields.add(null);

    // Act
    pdAcroForm.setFields(fields);

    // Assert that nothing has changed
    assertFalse(pdAcroForm.getFieldIterator().hasNext());
    assertFalse(pdAcroForm.getFieldTree().iterator().hasNext());
    assertTrue(pdAcroForm.getFields().isEmpty());
  }

  /**
   * Test {@link PDAcroForm#setFields(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()} Fields Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#setFields(List)}
   */
  @Test
  @DisplayName(
      "Test setFields(List); when ArrayList(); then PDAcroForm(PDDocument) with doc is PDDocument() Fields Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.setFields(List)"})
  void testSetFields_whenArrayList_thenPDAcroFormWithDocIsPDDocumentFieldsEmpty() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());

    // Act
    pdAcroForm.setFields(new ArrayList<>());

    // Assert that nothing has changed
    assertFalse(pdAcroForm.getFieldIterator().hasNext());
    assertFalse(pdAcroForm.getFieldTree().iterator().hasNext());
    assertTrue(pdAcroForm.getFields().isEmpty());
  }

  /**
   * Test {@link PDAcroForm#getFieldIterator()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument, COSDictionary)} with doc is {@link
   *       PDDocument#PDDocument()} and form is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#getFieldIterator()}
   */
  @Test
  @DisplayName(
      "Test getFieldIterator(); given PDAcroForm(PDDocument, COSDictionary) with doc is PDDocument() and form is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator PDAcroForm.getFieldIterator()"})
  void testGetFieldIterator_givenPDAcroFormWithDocIsPDDocumentAndFormIsCOSDictionary() {
    // Arrange
    PDDocument doc = new PDDocument();
    PDAcroForm pdAcroForm = new PDAcroForm(doc, new COSDictionary());

    // Act and Assert
    assertFalse(pdAcroForm.getFieldIterator().hasNext());
  }

  /**
   * Test {@link PDAcroForm#getFieldIterator()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()}.
   *   <li>Then return not hasNext.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#getFieldIterator()}
   */
  @Test
  @DisplayName(
      "Test getFieldIterator(); given PDAcroForm(PDDocument) with doc is PDDocument(); then return not hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator PDAcroForm.getFieldIterator()"})
  void testGetFieldIterator_givenPDAcroFormWithDocIsPDDocument_thenReturnNotHasNext() {
    // Arrange, Act and Assert
    assertFalse(new PDAcroForm(new PDDocument()).getFieldIterator().hasNext());
  }

  /**
   * Test {@link PDAcroForm#getFieldTree()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument, COSDictionary)} with doc is {@link
   *       PDDocument#PDDocument()} and form is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#getFieldTree()}
   */
  @Test
  @DisplayName(
      "Test getFieldTree(); given PDAcroForm(PDDocument, COSDictionary) with doc is PDDocument() and form is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFieldTree PDAcroForm.getFieldTree()"})
  void testGetFieldTree_givenPDAcroFormWithDocIsPDDocumentAndFormIsCOSDictionary() {
    // Arrange
    PDDocument doc = new PDDocument();
    PDAcroForm pdAcroForm = new PDAcroForm(doc, new COSDictionary());

    // Act and Assert
    assertFalse(pdAcroForm.getFieldTree().iterator().hasNext());
  }

  /**
   * Test {@link PDAcroForm#getFieldTree()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()}.
   *   <li>Then return not iterator hasNext.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#getFieldTree()}
   */
  @Test
  @DisplayName(
      "Test getFieldTree(); given PDAcroForm(PDDocument) with doc is PDDocument(); then return not iterator hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFieldTree PDAcroForm.getFieldTree()"})
  void testGetFieldTree_givenPDAcroFormWithDocIsPDDocument_thenReturnNotIteratorHasNext() {
    // Arrange, Act and Assert
    assertFalse(new PDAcroForm(new PDDocument()).getFieldTree().iterator().hasNext());
  }

  /**
   * Test {@link PDAcroForm#setCacheFields(boolean)}.
   *
   * <p>Method under test: {@link PDAcroForm#setCacheFields(boolean)}
   */
  @Test
  @DisplayName("Test setCacheFields(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.setCacheFields(boolean)"})
  void testSetCacheFields() {
    // Arrange
    PDDocument doc = new PDDocument();
    PDAcroForm pdAcroForm = new PDAcroForm(doc, new COSDictionary());

    // Act
    pdAcroForm.setCacheFields(true);

    // Assert
    assertTrue(pdAcroForm.isCachingFields());
  }

  /**
   * Test {@link PDAcroForm#setCacheFields(boolean)}.
   *
   * <ul>
   *   <li>Then {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()} CachingFields.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#setCacheFields(boolean)}
   */
  @Test
  @DisplayName(
      "Test setCacheFields(boolean); then PDAcroForm(PDDocument) with doc is PDDocument() CachingFields")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.setCacheFields(boolean)"})
  void testSetCacheFields_thenPDAcroFormWithDocIsPDDocumentCachingFields() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());

    // Act
    pdAcroForm.setCacheFields(true);

    // Assert
    assertTrue(pdAcroForm.isCachingFields());
  }

  /**
   * Test {@link PDAcroForm#setCacheFields(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then not {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()} CachingFields.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#setCacheFields(boolean)}
   */
  @Test
  @DisplayName(
      "Test setCacheFields(boolean); when 'false'; then not PDAcroForm(PDDocument) with doc is PDDocument() CachingFields")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.setCacheFields(boolean)"})
  void testSetCacheFields_whenFalse_thenNotPDAcroFormWithDocIsPDDocumentCachingFields() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());

    // Act
    pdAcroForm.setCacheFields(false);

    // Assert that nothing has changed
    assertFalse(pdAcroForm.isCachingFields());
  }

  /**
   * Test {@link PDAcroForm#isCachingFields()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#isCachingFields()}
   */
  @Test
  @DisplayName(
      "Test isCachingFields(); given PDAcroForm(PDDocument) with doc is PDDocument(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAcroForm.isCachingFields()"})
  void testIsCachingFields_givenPDAcroFormWithDocIsPDDocument_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDAcroForm(new PDDocument()).isCachingFields());
  }

  /**
   * Test {@link PDAcroForm#isCachingFields()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#isCachingFields()}
   */
  @Test
  @DisplayName("Test isCachingFields(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAcroForm.isCachingFields()"})
  void testIsCachingFields_thenReturnTrue() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setCacheFields(true);

    // Act and Assert
    assertTrue(pdAcroForm.isCachingFields());
  }

  /**
   * Test {@link PDAcroForm#getField(String)}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument, COSDictionary)} with doc is {@link
   *       PDDocument#PDDocument()} and form is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#getField(String)}
   */
  @Test
  @DisplayName(
      "Test getField(String); given PDAcroForm(PDDocument, COSDictionary) with doc is PDDocument() and form is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDField PDAcroForm.getField(String)"})
  void testGetField_givenPDAcroFormWithDocIsPDDocumentAndFormIsCOSDictionary() {
    // Arrange
    PDDocument doc = new PDDocument();
    PDAcroForm pdAcroForm = new PDAcroForm(doc, new COSDictionary());

    // Act and Assert
    assertNull(pdAcroForm.getField("Dr Jane Doe"));
  }

  /**
   * Test {@link PDAcroForm#getField(String)}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()} CacheFields is {@code true}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#getField(String)}
   */
  @Test
  @DisplayName(
      "Test getField(String); given PDAcroForm(PDDocument) with doc is PDDocument() CacheFields is 'true'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDField PDAcroForm.getField(String)"})
  void testGetField_givenPDAcroFormWithDocIsPDDocumentCacheFieldsIsTrue_thenReturnNull() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setCacheFields(true);

    // Act and Assert
    assertNull(pdAcroForm.getField("Dr Jane Doe"));
  }

  /**
   * Test {@link PDAcroForm#getField(String)}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#getField(String)}
   */
  @Test
  @DisplayName(
      "Test getField(String); given PDAcroForm(PDDocument) with doc is PDDocument(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDField PDAcroForm.getField(String)"})
  void testGetField_givenPDAcroFormWithDocIsPDDocument_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDAcroForm(new PDDocument()).getField("Dr Jane Doe"));
  }

  /**
   * Test {@link PDAcroForm#getDefaultAppearance()}.
   *
   * <p>Method under test: {@link PDAcroForm#getDefaultAppearance()}
   */
  @Test
  @DisplayName("Test getDefaultAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAcroForm.getDefaultAppearance()"})
  void testGetDefaultAppearance() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setDefaultAppearance("");

    // Act and Assert
    assertEquals("", pdAcroForm.getDefaultAppearance());
  }

  /**
   * Test {@link PDAcroForm#getDefaultAppearance()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#getDefaultAppearance()}
   */
  @Test
  @DisplayName("Test getDefaultAppearance(); given PDAcroForm(PDDocument) with doc is PDDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAcroForm.getDefaultAppearance()"})
  void testGetDefaultAppearance_givenPDAcroFormWithDocIsPDDocument() {
    // Arrange, Act and Assert
    assertEquals("", new PDAcroForm(new PDDocument()).getDefaultAppearance());
  }

  /**
   * Test {@link PDAcroForm#getDefaultAppearance()}.
   *
   * <ul>
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#getDefaultAppearance()}
   */
  @Test
  @DisplayName("Test getDefaultAppearance(); then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAcroForm.getDefaultAppearance()"})
  void testGetDefaultAppearance_thenReturn42() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setDefaultAppearance("42");

    // Act and Assert
    assertEquals("42", pdAcroForm.getDefaultAppearance());
  }

  /**
   * Test {@link PDAcroForm#setDefaultAppearance(String)}.
   *
   * <p>Method under test: {@link PDAcroForm#setDefaultAppearance(String)}
   */
  @Test
  @DisplayName("Test setDefaultAppearance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.setDefaultAppearance(String)"})
  void testSetDefaultAppearance() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());

    // Act
    pdAcroForm.setDefaultAppearance(null);

    // Assert that nothing has changed
    assertEquals("", pdAcroForm.getDefaultAppearance());
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDAcroForm#setDefaultAppearance(String)}.
   *
   * <ul>
   *   <li>Then {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()} DefaultAppearance is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#setDefaultAppearance(String)}
   */
  @Test
  @DisplayName(
      "Test setDefaultAppearance(String); then PDAcroForm(PDDocument) with doc is PDDocument() DefaultAppearance is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.setDefaultAppearance(String)"})
  void testSetDefaultAppearance_thenPDAcroFormWithDocIsPDDocumentDefaultAppearanceIs42() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());

    // Act
    pdAcroForm.setDefaultAppearance("42");

    // Assert
    assertEquals("42", pdAcroForm.getDefaultAppearance());
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAcroForm#getNeedAppearances()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()} NeedAppearances is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#getNeedAppearances()}
   */
  @Test
  @DisplayName(
      "Test getNeedAppearances(); given PDAcroForm(PDDocument) with doc is PDDocument() NeedAppearances is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAcroForm.getNeedAppearances()"})
  void testGetNeedAppearances_givenPDAcroFormWithDocIsPDDocumentNeedAppearancesIsFalse() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setNeedAppearances(false);

    // Act and Assert
    assertFalse(pdAcroForm.getNeedAppearances());
  }

  /**
   * Test {@link PDAcroForm#getNeedAppearances()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#getNeedAppearances()}
   */
  @Test
  @DisplayName(
      "Test getNeedAppearances(); given PDAcroForm(PDDocument) with doc is PDDocument(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAcroForm.getNeedAppearances()"})
  void testGetNeedAppearances_givenPDAcroFormWithDocIsPDDocument_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDAcroForm(new PDDocument()).getNeedAppearances());
  }

  /**
   * Test {@link PDAcroForm#getNeedAppearances()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#getNeedAppearances()}
   */
  @Test
  @DisplayName("Test getNeedAppearances(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAcroForm.getNeedAppearances()"})
  void testGetNeedAppearances_thenReturnTrue() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setNeedAppearances(true);

    // Act and Assert
    assertTrue(pdAcroForm.getNeedAppearances());
  }

  /**
   * Test {@link PDAcroForm#setNeedAppearances(Boolean)}.
   *
   * <ul>
   *   <li>Then not {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()} NeedAppearances.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#setNeedAppearances(Boolean)}
   */
  @Test
  @DisplayName(
      "Test setNeedAppearances(Boolean); then not PDAcroForm(PDDocument) with doc is PDDocument() NeedAppearances")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.setNeedAppearances(Boolean)"})
  void testSetNeedAppearances_thenNotPDAcroFormWithDocIsPDDocumentNeedAppearances() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());

    // Act
    pdAcroForm.setNeedAppearances(false);

    // Assert
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdAcroForm.getNeedAppearances());
  }

  /**
   * Test {@link PDAcroForm#setNeedAppearances(Boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()} NeedAppearances.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#setNeedAppearances(Boolean)}
   */
  @Test
  @DisplayName(
      "Test setNeedAppearances(Boolean); when 'true'; then PDAcroForm(PDDocument) with doc is PDDocument() NeedAppearances")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.setNeedAppearances(Boolean)"})
  void testSetNeedAppearances_whenTrue_thenPDAcroFormWithDocIsPDDocumentNeedAppearances() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());

    // Act
    pdAcroForm.setNeedAppearances(true);

    // Assert
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdAcroForm.getNeedAppearances());
  }

  /**
   * Test {@link PDAcroForm#getDefaultResources()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#getDefaultResources()}
   */
  @Test
  @DisplayName(
      "Test getDefaultResources(); given PDAcroForm(PDDocument) with doc is PDDocument(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDResources PDAcroForm.getDefaultResources()"})
  void testGetDefaultResources_givenPDAcroFormWithDocIsPDDocument_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDAcroForm(new PDDocument()).getDefaultResources());
  }

  /**
   * Test {@link PDAcroForm#getDefaultResources()}.
   *
   * <ul>
   *   <li>Then ColorSpaceNames return {@link Set}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#getDefaultResources()}
   */
  @Test
  @DisplayName("Test getDefaultResources(); then ColorSpaceNames return Set")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDResources PDAcroForm.getDefaultResources()"})
  void testGetDefaultResources_thenColorSpaceNamesReturnSet() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setDefaultResources(new PDResources());

    // Act
    PDResources actualDefaultResources = pdAcroForm.getDefaultResources();

    // Assert
    Iterable<COSName> colorSpaceNames = actualDefaultResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    assertTrue(actualDefaultResources.getResourceCache() instanceof DefaultResourceCache);
    COSDictionary cOSObject = actualDefaultResources.getCOSObject();
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(colorSpaceNames, actualDefaultResources.getExtGStateNames());
    assertSame(colorSpaceNames, actualDefaultResources.getFontNames());
    assertSame(colorSpaceNames, actualDefaultResources.getPatternNames());
    assertSame(colorSpaceNames, actualDefaultResources.getPropertiesNames());
    assertSame(colorSpaceNames, actualDefaultResources.getShadingNames());
    assertSame(colorSpaceNames, actualDefaultResources.getXObjectNames());
  }

  /**
   * Test {@link PDAcroForm#setDefaultResources(PDResources)}.
   *
   * <p>Method under test: {@link PDAcroForm#setDefaultResources(PDResources)}
   */
  @Test
  @DisplayName("Test setDefaultResources(PDResources)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.setDefaultResources(PDResources)"})
  void testSetDefaultResources() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());

    // Act
    pdAcroForm.setDefaultResources(new PDResources());

    // Assert
    ResourceCache resourceCache = pdAcroForm.getDefaultResources().getResourceCache();
    assertTrue(resourceCache instanceof DefaultResourceCache);
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(resourceCache, pdAcroForm.getDocument().getResourceCache());
  }

  /**
   * Test {@link PDAcroForm#setDefaultResources(PDResources)}.
   *
   * <p>Method under test: {@link PDAcroForm#setDefaultResources(PDResources)}
   */
  @Test
  @DisplayName("Test setDefaultResources(PDResources)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.setDefaultResources(PDResources)"})
  void testSetDefaultResources2() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());

    // Act
    pdAcroForm.setDefaultResources(null);

    // Assert that nothing has changed
    assertTrue(pdAcroForm.getDocument().getResourceCache() instanceof DefaultResourceCache);
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDAcroForm#hasXFA()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#hasXFA()}
   */
  @Test
  @DisplayName(
      "Test hasXFA(); given PDAcroForm(PDDocument) with doc is PDDocument(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAcroForm.hasXFA()"})
  void testHasXFA_givenPDAcroFormWithDocIsPDDocument_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDAcroForm(new PDDocument()).hasXFA());
  }

  /**
   * Test {@link PDAcroForm#hasXFA()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#hasXFA()}
   */
  @Test
  @DisplayName("Test hasXFA(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAcroForm.hasXFA()"})
  void testHasXFA_thenReturnTrue() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setXFA(new PDXFAResource(COSBoolean.FALSE));

    // Act and Assert
    assertTrue(pdAcroForm.hasXFA());
  }

  /**
   * Test {@link PDAcroForm#xfaIsDynamic()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#xfaIsDynamic()}
   */
  @Test
  @DisplayName(
      "Test xfaIsDynamic(); given PDAcroForm(PDDocument) with doc is PDDocument(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAcroForm.xfaIsDynamic()"})
  void testXfaIsDynamic_givenPDAcroFormWithDocIsPDDocument_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDAcroForm(new PDDocument()).xfaIsDynamic());
  }

  /**
   * Test {@link PDAcroForm#xfaIsDynamic()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#xfaIsDynamic()}
   */
  @Test
  @DisplayName("Test xfaIsDynamic(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAcroForm.xfaIsDynamic()"})
  void testXfaIsDynamic_thenReturnTrue() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setXFA(new PDXFAResource(COSBoolean.FALSE));

    // Act and Assert
    assertTrue(pdAcroForm.xfaIsDynamic());
  }

  /**
   * Test {@link PDAcroForm#getXFA()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#getXFA()}
   */
  @Test
  @DisplayName(
      "Test getXFA(); given PDAcroForm(PDDocument) with doc is PDDocument(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDXFAResource PDAcroForm.getXFA()"})
  void testGetXFA_givenPDAcroFormWithDocIsPDDocument_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDAcroForm(new PDDocument()).getXFA());
  }

  /**
   * Test {@link PDAcroForm#setXFA(PDXFAResource)}.
   *
   * <ul>
   *   <li>Then {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()} XFA COSObject is {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#setXFA(PDXFAResource)}
   */
  @Test
  @DisplayName(
      "Test setXFA(PDXFAResource); then PDAcroForm(PDDocument) with doc is PDDocument() XFA COSObject is COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.setXFA(PDXFAResource)"})
  void testSetXFA_thenPDAcroFormWithDocIsPDDocumentXfaCOSObjectIsCOSArray() throws IOException {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    COSArray xfaBase = new COSArray();

    // Act
    pdAcroForm.setXFA(new PDXFAResource(xfaBase));

    // Assert
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    PDXFAResource xFA = pdAcroForm.getXFA();
    assertSame(xfaBase, xFA.getCOSObject());
    assertArrayEquals(new byte[] {}, xFA.getBytes());
  }

  /**
   * Test {@link PDAcroForm#setXFA(PDXFAResource)}.
   *
   * <ul>
   *   <li>Then {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()} XFA COSObject is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#setXFA(PDXFAResource)}
   */
  @Test
  @DisplayName(
      "Test setXFA(PDXFAResource); then PDAcroForm(PDDocument) with doc is PDDocument() XFA COSObject is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.setXFA(PDXFAResource)"})
  void testSetXFA_thenPDAcroFormWithDocIsPDDocumentXfaCOSObjectIsCOSDictionary()
      throws IOException {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    COSDictionary xfaBase = new COSDictionary();

    // Act
    pdAcroForm.setXFA(new PDXFAResource(xfaBase));

    // Assert
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    PDXFAResource xFA = pdAcroForm.getXFA();
    assertSame(xfaBase, xFA.getCOSObject());
    assertArrayEquals(new byte[] {}, xFA.getBytes());
  }

  /**
   * Test {@link PDAcroForm#setXFA(PDXFAResource)}.
   *
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#setXFA(PDXFAResource)}
   */
  @Test
  @DisplayName(
      "Test setXFA(PDXFAResource); when COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.setXFA(PDXFAResource)"})
  void testSetXFA_whenCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    COSObject xfaBase = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    pdAcroForm.setXFA(new PDXFAResource(xfaBase));

    // Assert
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertArrayEquals(new byte[] {}, pdAcroForm.getXFA().getBytes());
  }

  /**
   * Test {@link PDAcroForm#setXFA(PDXFAResource)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#setXFA(PDXFAResource)}
   */
  @Test
  @DisplayName(
      "Test setXFA(PDXFAResource); when 'null'; then PDAcroForm(PDDocument) with doc is PDDocument() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.setXFA(PDXFAResource)"})
  void testSetXFA_whenNull_thenPDAcroFormWithDocIsPDDocumentCOSObjectValuesSizeIsOne() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());

    // Act
    pdAcroForm.setXFA(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDAcroForm#setXFA(PDXFAResource)}.
   *
   * <ul>
   *   <li>When {@link PDXFAResource#PDXFAResource(COSBase)} with xfaBase is {@link
   *       COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#setXFA(PDXFAResource)}
   */
  @Test
  @DisplayName("Test setXFA(PDXFAResource); when PDXFAResource(COSBase) with xfaBase is FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.setXFA(PDXFAResource)"})
  void testSetXFA_whenPDXFAResourceWithXfaBaseIsFalse() throws IOException {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());

    // Act
    pdAcroForm.setXFA(new PDXFAResource(COSBoolean.FALSE));

    // Assert
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertArrayEquals(new byte[] {}, pdAcroForm.getXFA().getBytes());
  }

  /**
   * Test {@link PDAcroForm#getQ()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()} Q is one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#getQ()}
   */
  @Test
  @DisplayName(
      "Test getQ(); given PDAcroForm(PDDocument) with doc is PDDocument() Q is one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDAcroForm.getQ()"})
  void testGetQ_givenPDAcroFormWithDocIsPDDocumentQIsOne_thenReturnOne() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setQ(1);

    // Act and Assert
    assertEquals(1, pdAcroForm.getQ());
  }

  /**
   * Test {@link PDAcroForm#getQ()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#getQ()}
   */
  @Test
  @DisplayName(
      "Test getQ(); given PDAcroForm(PDDocument) with doc is PDDocument(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDAcroForm.getQ()"})
  void testGetQ_givenPDAcroFormWithDocIsPDDocument_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new PDAcroForm(new PDDocument()).getQ());
  }

  /**
   * Test {@link PDAcroForm#setQ(int)}.
   *
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.
   *   <li>Then {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()} Q is {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#setQ(int)}
   */
  @Test
  @DisplayName(
      "Test setQ(int); when MIN_VALUE; then PDAcroForm(PDDocument) with doc is PDDocument() Q is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.setQ(int)"})
  void testSetQ_whenMin_value_thenPDAcroFormWithDocIsPDDocumentQIsMin_value() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());

    // Act
    pdAcroForm.setQ(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdAcroForm.getQ());
  }

  /**
   * Test {@link PDAcroForm#setQ(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()} Q is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#setQ(int)}
   */
  @Test
  @DisplayName(
      "Test setQ(int); when one; then PDAcroForm(PDDocument) with doc is PDDocument() Q is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.setQ(int)"})
  void testSetQ_whenOne_thenPDAcroFormWithDocIsPDDocumentQIsOne() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());

    // Act
    pdAcroForm.setQ(1);

    // Assert
    assertEquals(1, pdAcroForm.getQ());
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAcroForm#isSignaturesExist()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#isSignaturesExist()}
   */
  @Test
  @DisplayName(
      "Test isSignaturesExist(); given PDAcroForm(PDDocument) with doc is PDDocument(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAcroForm.isSignaturesExist()"})
  void testIsSignaturesExist_givenPDAcroFormWithDocIsPDDocument_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDAcroForm(new PDDocument()).isSignaturesExist());
  }

  /**
   * Test {@link PDAcroForm#isSignaturesExist()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#isSignaturesExist()}
   */
  @Test
  @DisplayName("Test isSignaturesExist(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAcroForm.isSignaturesExist()"})
  void testIsSignaturesExist_thenReturnTrue() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setSignaturesExist(true);

    // Act and Assert
    assertTrue(pdAcroForm.isSignaturesExist());
  }

  /**
   * Test {@link PDAcroForm#setSignaturesExist(boolean)}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()} AppendOnly is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#setSignaturesExist(boolean)}
   */
  @Test
  @DisplayName(
      "Test setSignaturesExist(boolean); given PDAcroForm(PDDocument) with doc is PDDocument() AppendOnly is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.setSignaturesExist(boolean)"})
  void testSetSignaturesExist_givenPDAcroFormWithDocIsPDDocumentAppendOnlyIsTrue() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setAppendOnly(true);

    // Act
    pdAcroForm.setSignaturesExist(true);

    // Assert
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdAcroForm.isSignaturesExist());
  }

  /**
   * Test {@link PDAcroForm#setSignaturesExist(boolean)}.
   *
   * <ul>
   *   <li>Then not {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()} SignaturesExist.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#setSignaturesExist(boolean)}
   */
  @Test
  @DisplayName(
      "Test setSignaturesExist(boolean); then not PDAcroForm(PDDocument) with doc is PDDocument() SignaturesExist")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.setSignaturesExist(boolean)"})
  void testSetSignaturesExist_thenNotPDAcroFormWithDocIsPDDocumentSignaturesExist() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());

    // Act
    pdAcroForm.setSignaturesExist(false);

    // Assert
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdAcroForm.isSignaturesExist());
  }

  /**
   * Test {@link PDAcroForm#setSignaturesExist(boolean)}.
   *
   * <ul>
   *   <li>Then {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()} SignaturesExist.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#setSignaturesExist(boolean)}
   */
  @Test
  @DisplayName(
      "Test setSignaturesExist(boolean); then PDAcroForm(PDDocument) with doc is PDDocument() SignaturesExist")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.setSignaturesExist(boolean)"})
  void testSetSignaturesExist_thenPDAcroFormWithDocIsPDDocumentSignaturesExist() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());

    // Act
    pdAcroForm.setSignaturesExist(true);

    // Assert
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdAcroForm.isSignaturesExist());
  }

  /**
   * Test {@link PDAcroForm#isAppendOnly()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()} SignaturesExist is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#isAppendOnly()}
   */
  @Test
  @DisplayName(
      "Test isAppendOnly(); given PDAcroForm(PDDocument) with doc is PDDocument() SignaturesExist is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAcroForm.isAppendOnly()"})
  void testIsAppendOnly_givenPDAcroFormWithDocIsPDDocumentSignaturesExistIsTrue() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setSignaturesExist(true);

    // Act and Assert
    assertFalse(pdAcroForm.isAppendOnly());
  }

  /**
   * Test {@link PDAcroForm#isAppendOnly()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#isAppendOnly()}
   */
  @Test
  @DisplayName(
      "Test isAppendOnly(); given PDAcroForm(PDDocument) with doc is PDDocument(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAcroForm.isAppendOnly()"})
  void testIsAppendOnly_givenPDAcroFormWithDocIsPDDocument_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDAcroForm(new PDDocument()).isAppendOnly());
  }

  /**
   * Test {@link PDAcroForm#isAppendOnly()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#isAppendOnly()}
   */
  @Test
  @DisplayName("Test isAppendOnly(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAcroForm.isAppendOnly()"})
  void testIsAppendOnly_thenReturnTrue() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setAppendOnly(true);

    // Act and Assert
    assertTrue(pdAcroForm.isAppendOnly());
  }

  /**
   * Test {@link PDAcroForm#setAppendOnly(boolean)}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()} SignaturesExist is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#setAppendOnly(boolean)}
   */
  @Test
  @DisplayName(
      "Test setAppendOnly(boolean); given PDAcroForm(PDDocument) with doc is PDDocument() SignaturesExist is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.setAppendOnly(boolean)"})
  void testSetAppendOnly_givenPDAcroFormWithDocIsPDDocumentSignaturesExistIsTrue() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setSignaturesExist(true);

    // Act
    pdAcroForm.setAppendOnly(true);

    // Assert
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdAcroForm.isAppendOnly());
  }

  /**
   * Test {@link PDAcroForm#setAppendOnly(boolean)}.
   *
   * <ul>
   *   <li>Then {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()} AppendOnly.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#setAppendOnly(boolean)}
   */
  @Test
  @DisplayName(
      "Test setAppendOnly(boolean); then PDAcroForm(PDDocument) with doc is PDDocument() AppendOnly")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.setAppendOnly(boolean)"})
  void testSetAppendOnly_thenPDAcroFormWithDocIsPDDocumentAppendOnly() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());

    // Act
    pdAcroForm.setAppendOnly(true);

    // Assert
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdAcroForm.isAppendOnly());
  }

  /**
   * Test {@link PDAcroForm#setAppendOnly(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then not {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()} AppendOnly.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#setAppendOnly(boolean)}
   */
  @Test
  @DisplayName(
      "Test setAppendOnly(boolean); when 'false'; then not PDAcroForm(PDDocument) with doc is PDDocument() AppendOnly")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.setAppendOnly(boolean)"})
  void testSetAppendOnly_whenFalse_thenNotPDAcroFormWithDocIsPDDocumentAppendOnly() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());

    // Act
    pdAcroForm.setAppendOnly(false);

    // Assert
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdAcroForm.isAppendOnly());
  }

  /**
   * Test {@link PDAcroForm#getCalcOrder()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#getCalcOrder()}
   */
  @Test
  @DisplayName("Test getCalcOrder(); given PDAcroForm(PDDocument) with doc is PDDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDAcroForm.getCalcOrder()"})
  void testGetCalcOrder_givenPDAcroFormWithDocIsPDDocument() {
    // Arrange, Act and Assert
    assertTrue(new PDAcroForm(new PDDocument()).getCalcOrder().isEmpty());
  }

  /**
   * Test {@link PDAcroForm#getCalcOrder()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#getCalcOrder()}
   */
  @Test
  @DisplayName("Test getCalcOrder(); given PDAcroForm(PDDocument) with doc is PDDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDAcroForm.getCalcOrder()"})
  void testGetCalcOrder_givenPDAcroFormWithDocIsPDDocument2() {
    // Arrange
    ArrayList<PDField> fields = new ArrayList<>();
    fields.add(new PDCheckBox(new PDAcroForm(new PDDocument())));

    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setCalcOrder(fields);

    // Act and Assert
    assertTrue(pdAcroForm.getCalcOrder().isEmpty());
  }

  /**
   * Test {@link PDAcroForm#getCalcOrder()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()} CalcOrder is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#getCalcOrder()}
   */
  @Test
  @DisplayName(
      "Test getCalcOrder(); given PDAcroForm(PDDocument) with doc is PDDocument() CalcOrder is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDAcroForm.getCalcOrder()"})
  void testGetCalcOrder_givenPDAcroFormWithDocIsPDDocumentCalcOrderIsArrayList() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setCalcOrder(new ArrayList<>());

    // Act and Assert
    assertTrue(pdAcroForm.getCalcOrder().isEmpty());
  }

  /**
   * Test {@link PDAcroForm#setCalcOrder(List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#setCalcOrder(List)}
   */
  @Test
  @DisplayName("Test setCalcOrder(List); given 'null'; when ArrayList() add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.setCalcOrder(List)"})
  void testSetCalcOrder_givenNull_whenArrayListAddNull() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());

    ArrayList<PDField> fields = new ArrayList<>();
    fields.add(null);

    // Act
    pdAcroForm.setCalcOrder(fields);

    // Assert
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdAcroForm.getCalcOrder().isEmpty());
  }

  /**
   * Test {@link PDAcroForm#setCalcOrder(List)}.
   *
   * <ul>
   *   <li>Given {@link PDCheckBox#PDCheckBox(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#setCalcOrder(List)}
   */
  @Test
  @DisplayName(
      "Test setCalcOrder(List); given PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.setCalcOrder(List)"})
  void testSetCalcOrder_givenPDCheckBoxWithAcroFormIsPDAcroForm() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());

    ArrayList<PDField> fields = new ArrayList<>();
    fields.add(new PDCheckBox(new PDAcroForm(new PDDocument())));

    // Act
    pdAcroForm.setCalcOrder(fields);

    // Assert
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdAcroForm.getCalcOrder().isEmpty());
  }

  /**
   * Test {@link PDAcroForm#setCalcOrder(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAcroForm#setCalcOrder(List)}
   */
  @Test
  @DisplayName("Test setCalcOrder(List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAcroForm.setCalcOrder(List)"})
  void testSetCalcOrder_whenArrayList() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());

    // Act
    pdAcroForm.setCalcOrder(new ArrayList<>());

    // Assert
    COSDictionary cOSObject = pdAcroForm.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdAcroForm.getCalcOrder().isEmpty());
  }
}
