package org.apache.pdfbox.pdmodel.fixup;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSUpdateInfo;
import org.apache.pdfbox.pdmodel.DefaultResourceCache;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AcroFormDefaultFixupDiffblueTest {
  /**
   * Test {@link AcroFormDefaultFixup#apply()}.
   * <p>
   * Method under test: {@link AcroFormDefaultFixup#apply()}
   */
  @Test
  @DisplayName("Test apply()")
  void testApply() {
    // Arrange
    PDDocument doc = new PDDocument();

    PDAcroForm pdAcroForm = new PDAcroForm(doc, new COSDictionary());
    pdAcroForm.setNeedAppearances(true);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);
    PDPageTree pdPageTree = mock(PDPageTree.class);

    ArrayList<PDPage> pdPageList = new ArrayList<>();
    when(pdPageTree.iterator()).thenReturn(pdPageList.iterator());
    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(pdPageTree);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    (new AcroFormDefaultFixup(document)).apply();

    // Assert
    verify(document, atLeast(1)).getDocumentCatalog();
    verify(document).getPages();
    verify(pdDocumentCatalog, atLeast(1)).getAcroForm(isNull());
    verify(pdPageTree).iterator();
  }

  /**
   * Test {@link AcroFormDefaultFixup#apply()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDPage#PDPage()}.</li>
   *   <li>Then calls {@link PDPageTree#iterator()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormDefaultFixup#apply()}
   */
  @Test
  @DisplayName("Test apply(); given ArrayList() add PDPage(); then calls iterator()")
  void testApply_givenArrayListAddPDPage_thenCallsIterator() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setNeedAppearances(true);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);

    ArrayList<PDPage> pdPageList = new ArrayList<>();
    pdPageList.add(new PDPage());
    PDPageTree pdPageTree = mock(PDPageTree.class);
    when(pdPageTree.iterator()).thenReturn(pdPageList.iterator());
    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(pdPageTree);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    (new AcroFormDefaultFixup(document)).apply();

    // Assert
    verify(document, atLeast(1)).getDocumentCatalog();
    verify(document).getPages();
    verify(pdDocumentCatalog, atLeast(1)).getAcroForm(isNull());
    verify(pdPageTree).iterator();
  }

  /**
   * Test {@link AcroFormDefaultFixup#apply()}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.</li>
   *   <li>Then calls {@link COSBase#getCOSObject()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormDefaultFixup#apply()}
   */
  @Test
  @DisplayName("Test apply(); given COSArray() add FALSE; then calls getCOSObject()")
  void testApply_givenCOSArrayAddFalse_thenCallsGetCOSObject() {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cosDictionary.getCOSObject()).thenReturn(COSBoolean.FALSE);
    when(cosDictionary.getString(Mockito.<COSName>any())).thenReturn("String");
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray2.isEmpty()).thenReturn(false);
    when(cosArray2.size()).thenReturn(3);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary2.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    COSArray cosArray3 = mock(COSArray.class);
    when(cosArray3.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray3.size()).thenReturn(3);
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray3);
    when(form.getBoolean(Mockito.<COSName>any(), anyBoolean())).thenReturn(true);
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(form.getString(Mockito.<COSName>any(), Mockito.<String>any())).thenReturn("String");
    doNothing().when(form).setBoolean(Mockito.<COSName>any(), anyBoolean());

    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);
    pdAcroForm.setNeedAppearances(true);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    (new AcroFormDefaultFixup(document)).apply();

    // Assert
    verify(cosArray3, atLeast(1)).getObject(anyInt());
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray2, atLeast(1)).isEmpty();
    verify(cosArray3, atLeast(1)).size();
    verify(cosArray2, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).getCOSObject();
    verify(cosDictionary2, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getBoolean(isA(COSName.class), eq(false));
    verify(form, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(form).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getString(isA(COSName.class));
    verify(form).getString(isA(COSName.class), eq(""));
    verify(form, atLeast(1)).setBoolean(isA(COSName.class), anyBoolean());
    verify(document, atLeast(1)).getDocumentCatalog();
    verify(pdDocumentCatalog, atLeast(1)).getAcroForm(isNull());
  }

  /**
   * Test {@link AcroFormDefaultFixup#apply()}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSBase)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormDefaultFixup#apply()}
   */
  @Test
  @DisplayName("Test apply(); given COSArray getObject(int) return COSDictionary(); then calls setItem(COSName, COSBase)")
  void testApply_givenCOSArrayGetObjectReturnCOSDictionary_thenCallsSetItem() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(new COSDictionary());
    when(cosArray.size()).thenReturn(3);
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    doNothing().when(form).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    when(form.getBoolean(Mockito.<COSName>any(), anyBoolean())).thenReturn(true);
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(form.getString(Mockito.<COSName>any(), Mockito.<String>any())).thenReturn("String");
    doNothing().when(form).setBoolean(Mockito.<COSName>any(), anyBoolean());

    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);
    pdAcroForm.setNeedAppearances(true);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);
    PDPageTree pdPageTree = mock(PDPageTree.class);

    ArrayList<PDPage> pdPageList = new ArrayList<>();
    when(pdPageTree.iterator()).thenReturn(pdPageList.iterator());
    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(pdPageTree);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    (new AcroFormDefaultFixup(document)).apply();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(form).getBoolean(isA(COSName.class), eq(false));
    verify(form, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(form).getString(isA(COSName.class), eq(""));
    verify(form, atLeast(1)).setBoolean(isA(COSName.class), anyBoolean());
    verify(form).setItem(isA(COSName.class), isA(COSBase.class));
    verify(document, atLeast(1)).getDocumentCatalog();
    verify(document).getPages();
    verify(pdDocumentCatalog, atLeast(1)).getAcroForm(isNull());
    verify(pdPageTree).iterator();
  }

  /**
   * Test {@link AcroFormDefaultFixup#apply()}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSBase)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormDefaultFixup#apply()}
   */
  @Test
  @DisplayName("Test apply(); given COSArray getObject(int) return COSDictionary(); then calls setItem(COSName, COSBase)")
  void testApply_givenCOSArrayGetObjectReturnCOSDictionary_thenCallsSetItem2() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(new COSDictionary());
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray2.size()).thenReturn(3);
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    doNothing().when(form).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    when(form.getBoolean(Mockito.<COSName>any(), anyBoolean())).thenReturn(true);
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(form.getString(Mockito.<COSName>any(), Mockito.<String>any())).thenReturn("String");
    doNothing().when(form).setBoolean(Mockito.<COSName>any(), anyBoolean());

    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);
    pdAcroForm.setNeedAppearances(true);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);
    PDPageTree pdPageTree = mock(PDPageTree.class);

    ArrayList<PDPage> pdPageList = new ArrayList<>();
    when(pdPageTree.iterator()).thenReturn(pdPageList.iterator());
    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(pdPageTree);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    (new AcroFormDefaultFixup(document)).apply();

    // Assert
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(cosArray2, atLeast(1)).size();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getBoolean(isA(COSName.class), eq(false));
    verify(form, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(form).getString(isA(COSName.class), eq(""));
    verify(form, atLeast(1)).setBoolean(isA(COSName.class), anyBoolean());
    verify(form).setItem(isA(COSName.class), isA(COSBase.class));
    verify(document, atLeast(1)).getDocumentCatalog();
    verify(document).getPages();
    verify(pdDocumentCatalog, atLeast(1)).getAcroForm(isNull());
    verify(pdPageTree).iterator();
  }

  /**
   * Test {@link AcroFormDefaultFixup#apply()}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSBoolean#FALSE}.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSBase)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormDefaultFixup#apply()}
   */
  @Test
  @DisplayName("Test apply(); given COSArray getObject(int) return FALSE; then calls setItem(COSName, COSBase)")
  void testApply_givenCOSArrayGetObjectReturnFalse_thenCallsSetItem() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray.size()).thenReturn(3);
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    doNothing().when(form).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    when(form.getBoolean(Mockito.<COSName>any(), anyBoolean())).thenReturn(true);
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(form.getString(Mockito.<COSName>any(), Mockito.<String>any())).thenReturn("String");
    doNothing().when(form).setBoolean(Mockito.<COSName>any(), anyBoolean());

    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);
    pdAcroForm.setNeedAppearances(true);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);
    PDPageTree pdPageTree = mock(PDPageTree.class);

    ArrayList<PDPage> pdPageList = new ArrayList<>();
    when(pdPageTree.iterator()).thenReturn(pdPageList.iterator());
    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(pdPageTree);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    (new AcroFormDefaultFixup(document)).apply();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(form).getBoolean(isA(COSName.class), eq(false));
    verify(form, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(form).getString(isA(COSName.class), eq(""));
    verify(form, atLeast(1)).setBoolean(isA(COSName.class), anyBoolean());
    verify(form).setItem(isA(COSName.class), isA(COSBase.class));
    verify(document, atLeast(1)).getDocumentCatalog();
    verify(document).getPages();
    verify(pdDocumentCatalog, atLeast(1)).getAcroForm(isNull());
    verify(pdPageTree).iterator();
  }

  /**
   * Test {@link AcroFormDefaultFixup#apply()}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSBoolean#FALSE}.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSBase)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormDefaultFixup#apply()}
   */
  @Test
  @DisplayName("Test apply(); given COSArray getObject(int) return FALSE; then calls setItem(COSName, COSBase)")
  void testApply_givenCOSArrayGetObjectReturnFalse_thenCallsSetItem2() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray2.size()).thenReturn(3);
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    doNothing().when(form).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    when(form.getBoolean(Mockito.<COSName>any(), anyBoolean())).thenReturn(true);
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(form.getString(Mockito.<COSName>any(), Mockito.<String>any())).thenReturn("String");
    doNothing().when(form).setBoolean(Mockito.<COSName>any(), anyBoolean());

    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);
    pdAcroForm.setNeedAppearances(true);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);
    PDPageTree pdPageTree = mock(PDPageTree.class);

    ArrayList<PDPage> pdPageList = new ArrayList<>();
    when(pdPageTree.iterator()).thenReturn(pdPageList.iterator());
    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(pdPageTree);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    (new AcroFormDefaultFixup(document)).apply();

    // Assert
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(cosArray2, atLeast(1)).size();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getBoolean(isA(COSName.class), eq(false));
    verify(form, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(form).getString(isA(COSName.class), eq(""));
    verify(form, atLeast(1)).setBoolean(isA(COSName.class), anyBoolean());
    verify(form).setItem(isA(COSName.class), isA(COSBase.class));
    verify(document, atLeast(1)).getDocumentCatalog();
    verify(document).getPages();
    verify(pdDocumentCatalog, atLeast(1)).getAcroForm(isNull());
    verify(pdPageTree).iterator();
  }

  /**
   * Test {@link AcroFormDefaultFixup#apply()}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#isEmpty()} return
   * {@code true}.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSBase)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormDefaultFixup#apply()}
   */
  @Test
  @DisplayName("Test apply(); given COSArray isEmpty() return 'true'; then calls setItem(COSName, COSBase)")
  void testApply_givenCOSArrayIsEmptyReturnTrue_thenCallsSetItem() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isEmpty()).thenReturn(true);
    when(cosArray.size()).thenReturn(3);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray2.size()).thenReturn(3);
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    doNothing().when(form).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    when(form.getBoolean(Mockito.<COSName>any(), anyBoolean())).thenReturn(true);
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(form.getString(Mockito.<COSName>any(), Mockito.<String>any())).thenReturn("String");
    doNothing().when(form).setBoolean(Mockito.<COSName>any(), anyBoolean());

    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);
    pdAcroForm.setNeedAppearances(true);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);
    PDPageTree pdPageTree = mock(PDPageTree.class);

    ArrayList<PDPage> pdPageList = new ArrayList<>();
    when(pdPageTree.iterator()).thenReturn(pdPageList.iterator());
    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(pdPageTree);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    (new AcroFormDefaultFixup(document)).apply();

    // Assert
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(cosArray2, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getBoolean(isA(COSName.class), eq(false));
    verify(form, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(form).getString(isA(COSName.class), eq(""));
    verify(form, atLeast(1)).setBoolean(isA(COSName.class), anyBoolean());
    verify(form).setItem(isA(COSName.class), isA(COSBase.class));
    verify(document, atLeast(1)).getDocumentCatalog();
    verify(document).getPages();
    verify(pdDocumentCatalog, atLeast(1)).getAcroForm(isNull());
    verify(pdPageTree).iterator();
  }

  /**
   * Test {@link AcroFormDefaultFixup#apply()}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)}
   * return {@code null}.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSBase)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormDefaultFixup#apply()}
   */
  @Test
  @DisplayName("Test apply(); given COSDictionary getCOSArray(COSName) return 'null'; then calls setItem(COSName, COSBase)")
  void testApply_givenCOSDictionaryGetCOSArrayReturnNull_thenCallsSetItem() {
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
    doNothing().when(form).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    when(form.getBoolean(Mockito.<COSName>any(), anyBoolean())).thenReturn(true);
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(form.getString(Mockito.<COSName>any(), Mockito.<String>any())).thenReturn("String");
    doNothing().when(form).setBoolean(Mockito.<COSName>any(), anyBoolean());

    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);
    pdAcroForm.setNeedAppearances(true);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);
    PDPageTree pdPageTree = mock(PDPageTree.class);

    ArrayList<PDPage> pdPageList = new ArrayList<>();
    when(pdPageTree.iterator()).thenReturn(pdPageList.iterator());
    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(pdPageTree);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    (new AcroFormDefaultFixup(document)).apply();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getBoolean(isA(COSName.class), eq(false));
    verify(form, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(form).getString(isA(COSName.class), eq(""));
    verify(form, atLeast(1)).setBoolean(isA(COSName.class), anyBoolean());
    verify(form).setItem(isA(COSName.class), isA(COSBase.class));
    verify(document, atLeast(1)).getDocumentCatalog();
    verify(document).getPages();
    verify(pdDocumentCatalog, atLeast(1)).getAcroForm(isNull());
    verify(pdPageTree).iterator();
  }

  /**
   * Test {@link AcroFormDefaultFixup#apply()}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#getCOSDictionary(COSName)} return
   * {@link COSDictionary}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormDefaultFixup#apply()}
   */
  @Test
  @DisplayName("Test apply(); given COSDictionary getCOSDictionary(COSName) return COSDictionary")
  void testApply_givenCOSDictionaryGetCOSDictionaryReturnCOSDictionary() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary3.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary3.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cosDictionary3.getCOSObject()).thenReturn(COSBoolean.FALSE);
    when(cosDictionary3.getString(Mockito.<COSName>any())).thenReturn("String");
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary3);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    COSDictionary cosDictionary4 = mock(COSDictionary.class);
    when(cosDictionary4.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary4.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary4.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary4);
    when(cosArray2.size()).thenReturn(3);
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    when(form.getBoolean(Mockito.<COSName>any(), anyBoolean())).thenReturn(true);
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    when(form.getString(Mockito.<COSName>any(), Mockito.<String>any())).thenReturn("String");
    doNothing().when(form).setBoolean(Mockito.<COSName>any(), anyBoolean());

    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);
    pdAcroForm.setNeedAppearances(true);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    (new AcroFormDefaultFixup(document)).apply();

    // Assert
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(cosArray2, atLeast(1)).size();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary3, atLeast(1)).getCOSObject();
    verify(cosDictionary, atLeast(1)).containsKey(Mockito.<COSName>any());
    verify(cosDictionary4, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary3, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getBoolean(isA(COSName.class), eq(false));
    verify(form, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary4, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary3, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(form).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary3, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary3, atLeast(1)).getString(isA(COSName.class));
    verify(form).getString(isA(COSName.class), eq(""));
    verify(form, atLeast(1)).setBoolean(isA(COSName.class), anyBoolean());
    verify(document, atLeast(1)).getDocumentCatalog();
    verify(pdDocumentCatalog, atLeast(1)).getAcroForm(isNull());
  }

  /**
   * Test {@link AcroFormDefaultFixup#apply()}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#getCOSDictionary(COSName)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormDefaultFixup#apply()}
   */
  @Test
  @DisplayName("Test apply(); given COSDictionary getCOSDictionary(COSName) return 'null'")
  void testApply_givenCOSDictionaryGetCOSDictionaryReturnNull() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    doNothing().when(cosDictionary).setNeedToBeUpdated(anyBoolean());
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(null);
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary2.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cosDictionary2.getCOSObject()).thenReturn(COSBoolean.FALSE);
    when(cosDictionary2.getString(Mockito.<COSName>any())).thenReturn("String");
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary3.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary3.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary3);
    when(cosArray2.size()).thenReturn(3);
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    doNothing().when(form).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    when(form.getBoolean(Mockito.<COSName>any(), anyBoolean())).thenReturn(true);
    doNothing().when(form).setNeedToBeUpdated(anyBoolean());
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(form.getString(Mockito.<COSName>any(), Mockito.<String>any())).thenReturn("String");
    doNothing().when(form).setBoolean(Mockito.<COSName>any(), anyBoolean());

    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);
    pdAcroForm.setNeedAppearances(true);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    (new AcroFormDefaultFixup(document)).apply();

    // Assert
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(cosArray2, atLeast(1)).size();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary2, atLeast(1)).getCOSObject();
    verify(cosDictionary3, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getBoolean(isA(COSName.class), eq(false));
    verify(form, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary3, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(form).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getString(isA(COSName.class));
    verify(form).getString(isA(COSName.class), eq(""));
    verify(form, atLeast(1)).setBoolean(isA(COSName.class), anyBoolean());
    verify(cosDictionary, atLeast(1)).setItem(isA(COSName.class), Mockito.<COSBase>any());
    verify(cosDictionary, atLeast(1)).setNeedToBeUpdated(eq(true));
    verify(document, atLeast(1)).getDocumentCatalog();
    verify(pdDocumentCatalog, atLeast(1)).getAcroForm(isNull());
  }

  /**
   * Test {@link AcroFormDefaultFixup#apply()}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#getCOSDictionary(COSName)} return {@code null}.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSObjectable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormDefaultFixup#apply()}
   */
  @Test
  @DisplayName("Test apply(); given COSDictionary getCOSDictionary(COSName) return 'null'; then calls setItem(COSName, COSObjectable)")
  void testApply_givenCOSDictionaryGetCOSDictionaryReturnNull_thenCallsSetItem() {
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
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary2.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray2.size()).thenReturn(3);
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    when(form.getBoolean(Mockito.<COSName>any(), anyBoolean())).thenReturn(true);
    doNothing().when(form).setNeedToBeUpdated(anyBoolean());
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(null);
    doNothing().when(form).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());
    when(form.getString(Mockito.<COSName>any(), Mockito.<String>any())).thenReturn("String");
    doNothing().when(form).setBoolean(Mockito.<COSName>any(), anyBoolean());

    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);
    pdAcroForm.setNeedAppearances(true);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    (new AcroFormDefaultFixup(document)).apply();

    // Assert
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(cosArray2, atLeast(1)).size();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).getCOSObject();
    verify(cosDictionary2, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getBoolean(isA(COSName.class), eq(false));
    verify(form, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(form).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getString(isA(COSName.class));
    verify(form).getString(isA(COSName.class), eq(""));
    verify(form, atLeast(1)).setBoolean(isA(COSName.class), anyBoolean());
    verify(form).setItem(isA(COSName.class), isA(COSObjectable.class));
    verify(form).setNeedToBeUpdated(eq(true));
    verify(document, atLeast(1)).getDocumentCatalog();
    verify(pdDocumentCatalog, atLeast(1)).getAcroForm(isNull());
  }

  /**
   * Test {@link AcroFormDefaultFixup#apply()}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSBase#getCOSObject()} return
   * {@link COSBoolean#FALSE}.</li>
   *   <li>Then calls {@link COSBase#getCOSObject()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormDefaultFixup#apply()}
   */
  @Test
  @DisplayName("Test apply(); given COSDictionary getCOSObject() return FALSE; then calls getCOSObject()")
  void testApply_givenCOSDictionaryGetCOSObjectReturnFalse_thenCallsGetCOSObject() {
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
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary2.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray2.size()).thenReturn(3);
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    when(form.getBoolean(Mockito.<COSName>any(), anyBoolean())).thenReturn(true);
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(form.getString(Mockito.<COSName>any(), Mockito.<String>any())).thenReturn("String");
    doNothing().when(form).setBoolean(Mockito.<COSName>any(), anyBoolean());

    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);
    pdAcroForm.setNeedAppearances(true);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    (new AcroFormDefaultFixup(document)).apply();

    // Assert
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(cosArray2, atLeast(1)).size();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).getCOSObject();
    verify(cosDictionary2, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getBoolean(isA(COSName.class), eq(false));
    verify(form, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(form).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getString(isA(COSName.class));
    verify(form).getString(isA(COSName.class), eq(""));
    verify(form, atLeast(1)).setBoolean(isA(COSName.class), anyBoolean());
    verify(document, atLeast(1)).getDocumentCatalog();
    verify(pdDocumentCatalog, atLeast(1)).getAcroForm(isNull());
  }

  /**
   * Test {@link AcroFormDefaultFixup#apply()}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getInt(COSName, int)}
   * return minus one.</li>
   *   <li>Then calls {@link COSDictionary#getDictionaryObject(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormDefaultFixup#apply()}
   */
  @Test
  @DisplayName("Test apply(); given COSDictionary getInt(COSName, int) return minus one; then calls getDictionaryObject(COSName)")
  void testApply_givenCOSDictionaryGetIntReturnMinusOne_thenCallsGetDictionaryObject() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(-1);
    when(cosDictionary3.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(cosDictionary3.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary3.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary3.getNameAsString(Mockito.<COSName>any())).thenReturn("Ch");
    when(cosDictionary3.getCOSObject()).thenReturn(COSBoolean.FALSE);
    when(cosDictionary3.getString(Mockito.<COSName>any())).thenReturn("String");
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary3);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    COSDictionary cosDictionary4 = mock(COSDictionary.class);
    when(cosDictionary4.getString(Mockito.<COSName>any())).thenReturn("String");
    when(cosDictionary4.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary4.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary4.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary4);
    when(cosArray2.size()).thenReturn(3);
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    when(form.getBoolean(Mockito.<COSName>any(), anyBoolean())).thenReturn(true);
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    when(form.getString(Mockito.<COSName>any(), Mockito.<String>any())).thenReturn("String");
    doNothing().when(form).setBoolean(Mockito.<COSName>any(), anyBoolean());

    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);
    pdAcroForm.setNeedAppearances(true);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    (new AcroFormDefaultFixup(document)).apply();

    // Assert
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(cosArray2, atLeast(1)).size();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary3, atLeast(1)).getCOSObject();
    verify(cosDictionary, atLeast(1)).containsKey(Mockito.<COSName>any());
    verify(cosDictionary4, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary3, atLeast(1)).containsKey(Mockito.<COSName>any());
    verify(form).getBoolean(isA(COSName.class), eq(false));
    verify(form, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary4, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary3, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary3).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary3, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary3, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary3, atLeast(1)).getString(isA(COSName.class));
    verify(cosDictionary4, atLeast(1)).getString(isA(COSName.class));
    verify(form).getString(isA(COSName.class), eq(""));
    verify(form).setBoolean(isA(COSName.class), eq(true));
    verify(document, atLeast(1)).getDocumentCatalog();
    verify(pdDocumentCatalog, atLeast(1)).getAcroForm(isNull());
  }

  /**
   * Test {@link AcroFormDefaultFixup#apply()}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getInt(COSName, int)}
   * return one.</li>
   *   <li>Then calls {@link COSDictionary#getDictionaryObject(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormDefaultFixup#apply()}
   */
  @Test
  @DisplayName("Test apply(); given COSDictionary getInt(COSName, int) return one; then calls getDictionaryObject(COSName)")
  void testApply_givenCOSDictionaryGetIntReturnOne_thenCallsGetDictionaryObject() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary3.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(cosDictionary3.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary3.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary3.getNameAsString(Mockito.<COSName>any())).thenReturn("Ch");
    when(cosDictionary3.getCOSObject()).thenReturn(COSBoolean.FALSE);
    when(cosDictionary3.getString(Mockito.<COSName>any())).thenReturn("String");
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary3);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    COSDictionary cosDictionary4 = mock(COSDictionary.class);
    when(cosDictionary4.getString(Mockito.<COSName>any())).thenReturn("String");
    when(cosDictionary4.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary4.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary4.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary4);
    when(cosArray2.size()).thenReturn(3);
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    when(form.getBoolean(Mockito.<COSName>any(), anyBoolean())).thenReturn(true);
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    when(form.getString(Mockito.<COSName>any(), Mockito.<String>any())).thenReturn("String");
    doNothing().when(form).setBoolean(Mockito.<COSName>any(), anyBoolean());

    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);
    pdAcroForm.setNeedAppearances(true);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    (new AcroFormDefaultFixup(document)).apply();

    // Assert
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(cosArray2, atLeast(1)).size();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary3, atLeast(1)).getCOSObject();
    verify(cosDictionary, atLeast(1)).containsKey(Mockito.<COSName>any());
    verify(cosDictionary4, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary3, atLeast(1)).containsKey(Mockito.<COSName>any());
    verify(form).getBoolean(isA(COSName.class), eq(false));
    verify(form, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary4, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary3, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary3).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary3, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary3, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary3, atLeast(1)).getString(isA(COSName.class));
    verify(cosDictionary4, atLeast(1)).getString(isA(COSName.class));
    verify(form).getString(isA(COSName.class), eq(""));
    verify(form).setBoolean(isA(COSName.class), eq(true));
    verify(document, atLeast(1)).getDocumentCatalog();
    verify(pdDocumentCatalog, atLeast(1)).getAcroForm(isNull());
  }

  /**
   * Test {@link AcroFormDefaultFixup#apply()}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#getNameAsString(COSName)} return {@code null}.</li>
   *   <li>Then calls {@link COSDictionary#getCOSDictionary(COSName, COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormDefaultFixup#apply()}
   */
  @Test
  @DisplayName("Test apply(); given COSDictionary getNameAsString(COSName) return 'null'; then calls getCOSDictionary(COSName, COSName)")
  void testApply_givenCOSDictionaryGetNameAsStringReturnNull_thenCallsGetCOSDictionary() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn(null);
    when(cosDictionary.getCOSObject()).thenReturn(COSBoolean.FALSE);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(new COSDictionary());
    when(cosDictionary.getString(Mockito.<COSName>any())).thenReturn("String");
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary2.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(new COSDictionary());
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray2.size()).thenReturn(3);
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    when(form.getBoolean(Mockito.<COSName>any(), anyBoolean())).thenReturn(true);
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(form.getString(Mockito.<COSName>any(), Mockito.<String>any())).thenReturn("String");
    doNothing().when(form).setBoolean(Mockito.<COSName>any(), anyBoolean());

    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);
    pdAcroForm.setNeedAppearances(true);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    (new AcroFormDefaultFixup(document)).apply();

    // Assert
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(cosArray2, atLeast(1)).size();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).getCOSObject();
    verify(cosDictionary2, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getBoolean(isA(COSName.class), eq(false));
    verify(form, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(form).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getString(isA(COSName.class));
    verify(form).getString(isA(COSName.class), eq(""));
    verify(form, atLeast(1)).setBoolean(isA(COSName.class), anyBoolean());
    verify(document, atLeast(1)).getDocumentCatalog();
    verify(pdDocumentCatalog, atLeast(1)).getAcroForm(isNull());
  }

  /**
   * Test {@link AcroFormDefaultFixup#apply()}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#setItem(COSName, COSBase)} does nothing.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSBase)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormDefaultFixup#apply()}
   */
  @Test
  @DisplayName("Test apply(); given COSDictionary setItem(COSName, COSBase) does nothing; then calls setItem(COSName, COSBase)")
  void testApply_givenCOSDictionarySetItemDoesNothing_thenCallsSetItem() {
    // Arrange
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    doNothing().when(form).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    when(form.getBoolean(Mockito.<COSName>any(), anyBoolean())).thenReturn(true);
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(form.getString(Mockito.<COSName>any(), Mockito.<String>any())).thenReturn("String");
    doNothing().when(form).setBoolean(Mockito.<COSName>any(), anyBoolean());

    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);
    pdAcroForm.setNeedAppearances(true);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);
    PDPageTree pdPageTree = mock(PDPageTree.class);

    ArrayList<PDPage> pdPageList = new ArrayList<>();
    when(pdPageTree.iterator()).thenReturn(pdPageList.iterator());
    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(pdPageTree);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    (new AcroFormDefaultFixup(document)).apply();

    // Assert
    verify(form).getBoolean(isA(COSName.class), eq(false));
    verify(form, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(form).getString(isA(COSName.class), eq(""));
    verify(form, atLeast(1)).setBoolean(isA(COSName.class), anyBoolean());
    verify(form).setItem(isA(COSName.class), isA(COSBase.class));
    verify(document, atLeast(1)).getDocumentCatalog();
    verify(document).getPages();
    verify(pdDocumentCatalog, atLeast(1)).getAcroForm(isNull());
    verify(pdPageTree).iterator();
  }

  /**
   * Test {@link AcroFormDefaultFixup#apply()}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#setItem(COSName, COSBase)} does nothing.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSBase)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormDefaultFixup#apply()}
   */
  @Test
  @DisplayName("Test apply(); given COSDictionary setItem(COSName, COSBase) does nothing; then calls setItem(COSName, COSBase)")
  void testApply_givenCOSDictionarySetItemDoesNothing_thenCallsSetItem2() {
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
    doNothing().when(form).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    when(form.getBoolean(Mockito.<COSName>any(), anyBoolean())).thenReturn(true);
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(form.getString(Mockito.<COSName>any(), Mockito.<String>any())).thenReturn("String");
    doNothing().when(form).setBoolean(Mockito.<COSName>any(), anyBoolean());

    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);
    pdAcroForm.setNeedAppearances(true);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);
    PDPageTree pdPageTree = mock(PDPageTree.class);

    ArrayList<PDPage> pdPageList = new ArrayList<>();
    when(pdPageTree.iterator()).thenReturn(pdPageList.iterator());
    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(pdPageTree);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    (new AcroFormDefaultFixup(document)).apply();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getBoolean(isA(COSName.class), eq(false));
    verify(form, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(form, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(form).getString(isA(COSName.class), eq(""));
    verify(form, atLeast(1)).setBoolean(isA(COSName.class), anyBoolean());
    verify(form).setItem(isA(COSName.class), isA(COSBase.class));
    verify(document, atLeast(1)).getDocumentCatalog();
    verify(document).getPages();
    verify(pdDocumentCatalog, atLeast(1)).getAcroForm(isNull());
    verify(pdPageTree).iterator();
  }

  /**
   * Test {@link AcroFormDefaultFixup#apply()}.
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is
   * {@link PDDocument#PDDocument()} DefaultAppearance is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormDefaultFixup#apply()}
   */
  @Test
  @DisplayName("Test apply(); given PDAcroForm(PDDocument) with doc is PDDocument() DefaultAppearance is '42'")
  void testApply_givenPDAcroFormWithDocIsPDDocumentDefaultAppearanceIs42() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setDefaultAppearance("42");
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    (new AcroFormDefaultFixup(document)).apply();

    // Assert
    verify(document, atLeast(1)).getDocumentCatalog();
    verify(pdDocumentCatalog, atLeast(1)).getAcroForm(isNull());
  }

  /**
   * Test {@link AcroFormDefaultFixup#apply()}.
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is
   * {@link PDDocument} DefaultResources is
   * {@link PDResources#PDResources()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormDefaultFixup#apply()}
   */
  @Test
  @DisplayName("Test apply(); given PDAcroForm(PDDocument) with doc is PDDocument DefaultResources is PDResources()")
  void testApply_givenPDAcroFormWithDocIsPDDocumentDefaultResourcesIsPDResources() {
    // Arrange
    PDDocument doc = mock(PDDocument.class);
    when(doc.getResourceCache()).thenReturn(new DefaultResourceCache());

    PDAcroForm pdAcroForm = new PDAcroForm(doc);
    pdAcroForm.setDefaultResources(new PDResources());
    pdAcroForm.setNeedAppearances(true);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);
    PDPageTree pdPageTree = mock(PDPageTree.class);

    ArrayList<PDPage> pdPageList = new ArrayList<>();
    when(pdPageTree.iterator()).thenReturn(pdPageList.iterator());
    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(pdPageTree);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    (new AcroFormDefaultFixup(document)).apply();

    // Assert
    verify(document, atLeast(1)).getDocumentCatalog();
    verify(document).getPages();
    verify(doc, atLeast(1)).getResourceCache();
    verify(pdDocumentCatalog, atLeast(1)).getAcroForm(isNull());
    verify(pdPageTree).iterator();
  }

  /**
   * Test {@link AcroFormDefaultFixup#apply()}.
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is
   * {@link PDDocument} NeedAppearances is {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormDefaultFixup#apply()}
   */
  @Test
  @DisplayName("Test apply(); given PDAcroForm(PDDocument) with doc is PDDocument NeedAppearances is 'false'")
  void testApply_givenPDAcroFormWithDocIsPDDocumentNeedAppearancesIsFalse() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(mock(PDDocument.class));
    pdAcroForm.setNeedAppearances(false);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    (new AcroFormDefaultFixup(document)).apply();

    // Assert
    verify(document, atLeast(1)).getDocumentCatalog();
    verify(pdDocumentCatalog, atLeast(1)).getAcroForm(isNull());
  }

  /**
   * Test {@link AcroFormDefaultFixup#apply()}.
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is
   * {@link PDDocument#PDDocument()} NeedAppearances is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormDefaultFixup#apply()}
   */
  @Test
  @DisplayName("Test apply(); given PDAcroForm(PDDocument) with doc is PDDocument() NeedAppearances is 'true'")
  void testApply_givenPDAcroFormWithDocIsPDDocumentNeedAppearancesIsTrue() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setNeedAppearances(true);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);
    PDPageTree pdPageTree = mock(PDPageTree.class);

    ArrayList<PDPage> pdPageList = new ArrayList<>();
    when(pdPageTree.iterator()).thenReturn(pdPageList.iterator());
    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(pdPageTree);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    (new AcroFormDefaultFixup(document)).apply();

    // Assert
    verify(document, atLeast(1)).getDocumentCatalog();
    verify(document).getPages();
    verify(pdDocumentCatalog, atLeast(1)).getAcroForm(isNull());
    verify(pdPageTree).iterator();
  }

  /**
   * Test {@link AcroFormDefaultFixup#apply()}.
   * <ul>
   *   <li>Given {@link PDDocumentCatalog}
   * {@link PDDocumentCatalog#getAcroForm(PDDocumentFixup)} return
   * {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is
   * {@link PDDocument#PDDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormDefaultFixup#apply()}
   */
  @Test
  @DisplayName("Test apply(); given PDDocumentCatalog getAcroForm(PDDocumentFixup) return PDAcroForm(PDDocument) with doc is PDDocument()")
  void testApply_givenPDDocumentCatalogGetAcroFormReturnPDAcroFormWithDocIsPDDocument() {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(new PDAcroForm(new PDDocument()));
    PDDocument document = mock(PDDocument.class);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    (new AcroFormDefaultFixup(document)).apply();

    // Assert
    verify(document, atLeast(1)).getDocumentCatalog();
    verify(pdDocumentCatalog, atLeast(1)).getAcroForm(isNull());
  }

  /**
   * Test {@link AcroFormDefaultFixup#apply()}.
   * <ul>
   *   <li>Given {@link PDDocument} {@link PDDocument#getPages()} return
   * {@link PDPageTree#PDPageTree(COSDictionary)} with root is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormDefaultFixup#apply()}
   */
  @Test
  @DisplayName("Test apply(); given PDDocument getPages() return PDPageTree(COSDictionary) with root is COSDictionary()")
  void testApply_givenPDDocumentGetPagesReturnPDPageTreeWithRootIsCOSDictionary() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setNeedAppearances(true);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);
    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(new PDPageTree(new COSDictionary()));
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    (new AcroFormDefaultFixup(document)).apply();

    // Assert
    verify(document, atLeast(1)).getDocumentCatalog();
    verify(document).getPages();
    verify(pdDocumentCatalog, atLeast(1)).getAcroForm(isNull());
  }

  /**
   * Test {@link AcroFormDefaultFixup#apply()}.
   * <ul>
   *   <li>Given {@link PDDocument} {@link PDDocument#getPages()} return
   * {@link PDPageTree#PDPageTree()}.</li>
   *   <li>Then calls {@link PDDocument#getPages()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormDefaultFixup#apply()}
   */
  @Test
  @DisplayName("Test apply(); given PDDocument getPages() return PDPageTree(); then calls getPages()")
  void testApply_givenPDDocumentGetPagesReturnPDPageTree_thenCallsGetPages() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setNeedAppearances(true);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);
    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(new PDPageTree());
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    (new AcroFormDefaultFixup(document)).apply();

    // Assert
    verify(document, atLeast(1)).getDocumentCatalog();
    verify(document).getPages();
    verify(pdDocumentCatalog, atLeast(1)).getAcroForm(isNull());
  }

  /**
   * Test {@link AcroFormDefaultFixup#apply()}.
   * <ul>
   *   <li>Given {@link PDPageTree#PDPageTree()} add {@link PDPage#PDPage()}.</li>
   *   <li>Then calls {@link PDDocument#getPages()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormDefaultFixup#apply()}
   */
  @Test
  @DisplayName("Test apply(); given PDPageTree() add PDPage(); then calls getPages()")
  void testApply_givenPDPageTreeAddPDPage_thenCallsGetPages() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setNeedAppearances(true);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);

    PDPageTree pdPageTree = new PDPageTree();
    pdPageTree.add(new PDPage());
    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(pdPageTree);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    (new AcroFormDefaultFixup(document)).apply();

    // Assert
    verify(document, atLeast(1)).getDocumentCatalog();
    verify(document).getPages();
    verify(pdDocumentCatalog, atLeast(1)).getAcroForm(isNull());
  }

  /**
   * Test {@link AcroFormDefaultFixup#apply()}.
   * <ul>
   *   <li>Then calls {@link PDDocument#getResourceCache()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormDefaultFixup#apply()}
   */
  @Test
  @DisplayName("Test apply(); then calls getResourceCache()")
  void testApply_thenCallsGetResourceCache() {
    // Arrange
    PDDocument doc = mock(PDDocument.class);
    when(doc.getResourceCache()).thenReturn(new DefaultResourceCache());

    PDAcroForm pdAcroForm = new PDAcroForm(doc);
    pdAcroForm.setNeedAppearances(true);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);
    PDPageTree pdPageTree = mock(PDPageTree.class);

    ArrayList<PDPage> pdPageList = new ArrayList<>();
    when(pdPageTree.iterator()).thenReturn(pdPageList.iterator());
    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(pdPageTree);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    (new AcroFormDefaultFixup(document)).apply();

    // Assert
    verify(document, atLeast(1)).getDocumentCatalog();
    verify(document).getPages();
    verify(doc).getResourceCache();
    verify(pdDocumentCatalog, atLeast(1)).getAcroForm(isNull());
    verify(pdPageTree).iterator();
  }

  /**
   * Test {@link AcroFormDefaultFixup#apply()}.
   * <ul>
   *   <li>Then calls {@link COSUpdateInfo#setNeedToBeUpdated(boolean)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormDefaultFixup#apply()}
   */
  @Test
  @DisplayName("Test apply(); then calls setNeedToBeUpdated(boolean)")
  void testApply_thenCallsSetNeedToBeUpdated() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    doNothing().when(cosDictionary).setNeedToBeUpdated(anyBoolean());
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary2.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cosDictionary2.getCOSObject()).thenReturn(COSBoolean.FALSE);
    when(cosDictionary2.getString(Mockito.<COSName>any())).thenReturn("String");
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary2);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary3.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary3.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary3);
    when(cosArray2.size()).thenReturn(3);
    COSDictionary form = mock(COSDictionary.class);
    when(form.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    when(form.getBoolean(Mockito.<COSName>any(), anyBoolean())).thenReturn(true);
    doNothing().when(form).setNeedToBeUpdated(anyBoolean());
    when(form.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(form.getString(Mockito.<COSName>any(), Mockito.<String>any())).thenReturn("String");
    doNothing().when(form).setBoolean(Mockito.<COSName>any(), anyBoolean());

    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument(), form);
    pdAcroForm.setNeedAppearances(true);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);

    // Act
    (new AcroFormDefaultFixup(document)).apply();

    // Assert
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).isEmpty();
    verify(cosArray2, atLeast(1)).size();
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary2, atLeast(1)).getCOSObject();
    verify(cosDictionary3, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).containsKey(isA(COSName.class));
    verify(form).getBoolean(isA(COSName.class), eq(false));
    verify(form, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary3, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(form).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getString(isA(COSName.class));
    verify(form).getString(isA(COSName.class), eq(""));
    verify(form, atLeast(1)).setBoolean(isA(COSName.class), anyBoolean());
    verify(cosDictionary, atLeast(1)).setNeedToBeUpdated(eq(true));
    verify(document, atLeast(1)).getDocumentCatalog();
    verify(pdDocumentCatalog, atLeast(1)).getAcroForm(isNull());
  }
}
