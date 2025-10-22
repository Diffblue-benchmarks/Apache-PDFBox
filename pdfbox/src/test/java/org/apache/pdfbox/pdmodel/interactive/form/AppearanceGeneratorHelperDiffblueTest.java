package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.interactive.action.PDFormFieldAdditionalActions;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AppearanceGeneratorHelperDiffblueTest {
  /**
   * Test {@link AppearanceGeneratorHelper#AppearanceGeneratorHelper(PDVariableText)}.
   * <p>
   * Method under test: {@link AppearanceGeneratorHelper#AppearanceGeneratorHelper(PDVariableText)}
   */
  @Test
  @DisplayName("Test new AppearanceGeneratorHelper(PDVariableText)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AppearanceGeneratorHelper.<init>(PDVariableText)"})
  void testNewAppearanceGeneratorHelper() throws IOException {
    // Arrange
    PDVariableText field = mock(PDVariableText.class);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");
    when(field.getDefaultAppearanceString())
        .thenReturn(new PDDefaultAppearanceString(defaultAppearance, new PDResources()));
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act
    new AppearanceGeneratorHelper(field);

    // Assert
    verify(field).getAcroForm();
    verify(field).getDefaultAppearanceString();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#AppearanceGeneratorHelper(PDVariableText)}.
   * <p>
   * Method under test: {@link AppearanceGeneratorHelper#AppearanceGeneratorHelper(PDVariableText)}
   */
  @Test
  @DisplayName("Test new AppearanceGeneratorHelper(PDVariableText)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AppearanceGeneratorHelper.<init>(PDVariableText)"})
  void testNewAppearanceGeneratorHelper2() throws IOException {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setDefaultResources(new PDResources());
    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);
    PDVariableText field = mock(PDVariableText.class);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getFullyQualifiedName()).thenReturn("Dr Jane Doe");
    when(field.getDefaultAppearance()).thenReturn("Default Appearance");
    when(field.getDefaultAppearanceString()).thenThrow(new IOException("foo"));
    when(field.getAcroForm()).thenReturn(pdAcroForm);

    // Act and Assert
    assertThrows(IOException.class, () -> new AppearanceGeneratorHelper(field));
    verify(pdAnnotationWidget).getNormalAppearanceStream();
    verify(field).getAcroForm();
    verify(field).getFullyQualifiedName();
    verify(field).getWidgets();
    verify(field).getDefaultAppearance();
    verify(field).getDefaultAppearanceString();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#AppearanceGeneratorHelper(PDVariableText)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDAnnotationWidget#PDAnnotationWidget()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppearanceGeneratorHelper#AppearanceGeneratorHelper(PDVariableText)}
   */
  @Test
  @DisplayName("Test new AppearanceGeneratorHelper(PDVariableText); given ArrayList() add PDAnnotationWidget()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AppearanceGeneratorHelper.<init>(PDVariableText)"})
  void testNewAppearanceGeneratorHelper_givenArrayListAddPDAnnotationWidget() throws IOException {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setDefaultResources(new PDResources());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(new PDAnnotationWidget());
    PDVariableText field = mock(PDVariableText.class);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getFullyQualifiedName()).thenReturn("Dr Jane Doe");
    when(field.getDefaultAppearance()).thenReturn("Default Appearance");
    when(field.getDefaultAppearanceString()).thenThrow(new IOException("foo"));
    when(field.getAcroForm()).thenReturn(pdAcroForm);

    // Act and Assert
    assertThrows(IOException.class, () -> new AppearanceGeneratorHelper(field));
    verify(field).getAcroForm();
    verify(field).getFullyQualifiedName();
    verify(field).getWidgets();
    verify(field).getDefaultAppearance();
    verify(field).getDefaultAppearanceString();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#AppearanceGeneratorHelper(PDVariableText)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link PDTerminalField#getWidgets()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppearanceGeneratorHelper#AppearanceGeneratorHelper(PDVariableText)}
   */
  @Test
  @DisplayName("Test new AppearanceGeneratorHelper(PDVariableText); given ArrayList(); then calls getWidgets()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AppearanceGeneratorHelper.<init>(PDVariableText)"})
  void testNewAppearanceGeneratorHelper_givenArrayList_thenCallsGetWidgets() throws IOException {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setDefaultResources(new PDResources());
    PDVariableText field = mock(PDVariableText.class);
    when(field.getWidgets()).thenReturn(new ArrayList<>());
    when(field.getFullyQualifiedName()).thenReturn("Dr Jane Doe");
    when(field.getDefaultAppearance()).thenReturn("Default Appearance");
    when(field.getDefaultAppearanceString()).thenThrow(new IOException("foo"));
    when(field.getAcroForm()).thenReturn(pdAcroForm);

    // Act and Assert
    assertThrows(IOException.class, () -> new AppearanceGeneratorHelper(field));
    verify(field).getAcroForm();
    verify(field).getFullyQualifiedName();
    verify(field).getWidgets();
    verify(field).getDefaultAppearance();
    verify(field).getDefaultAppearanceString();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#AppearanceGeneratorHelper(PDVariableText)}.
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link PDDocument#PDDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppearanceGeneratorHelper#AppearanceGeneratorHelper(PDVariableText)}
   */
  @Test
  @DisplayName("Test new AppearanceGeneratorHelper(PDVariableText); given PDAcroForm(PDDocument) with doc is PDDocument()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AppearanceGeneratorHelper.<init>(PDVariableText)"})
  void testNewAppearanceGeneratorHelper_givenPDAcroFormWithDocIsPDDocument() throws IOException {
    // Arrange
    PDVariableText field = mock(PDVariableText.class);
    when(field.getFullyQualifiedName()).thenReturn("Dr Jane Doe");
    when(field.getDefaultAppearance()).thenReturn("Default Appearance");
    when(field.getDefaultAppearanceString()).thenThrow(new IOException("foo"));
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act and Assert
    assertThrows(IOException.class, () -> new AppearanceGeneratorHelper(field));
    verify(field).getAcroForm();
    verify(field).getFullyQualifiedName();
    verify(field).getDefaultAppearance();
    verify(field).getDefaultAppearanceString();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#AppearanceGeneratorHelper(PDVariableText)}.
   * <ul>
   *   <li>Then calls {@link PDFormXObject#getResources()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppearanceGeneratorHelper#AppearanceGeneratorHelper(PDVariableText)}
   */
  @Test
  @DisplayName("Test new AppearanceGeneratorHelper(PDVariableText); then calls getResources()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AppearanceGeneratorHelper.<init>(PDVariableText)"})
  void testNewAppearanceGeneratorHelper_thenCallsGetResources() throws IOException {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setDefaultResources(new PDResources());
    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    when(pdAppearanceStream.getResources()).thenReturn(new PDResources());
    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);
    PDVariableText field = mock(PDVariableText.class);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getFullyQualifiedName()).thenReturn("Dr Jane Doe");
    when(field.getDefaultAppearance()).thenReturn("Default Appearance");
    when(field.getDefaultAppearanceString()).thenThrow(new IOException("foo"));
    when(field.getAcroForm()).thenReturn(pdAcroForm);

    // Act and Assert
    assertThrows(IOException.class, () -> new AppearanceGeneratorHelper(field));
    verify(pdAppearanceStream).getResources();
    verify(pdAnnotationWidget).getNormalAppearanceStream();
    verify(field).getAcroForm();
    verify(field).getFullyQualifiedName();
    verify(field).getWidgets();
    verify(field).getDefaultAppearance();
    verify(field).getDefaultAppearanceString();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#AppearanceGeneratorHelper(PDVariableText)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppearanceGeneratorHelper#AppearanceGeneratorHelper(PDVariableText)}
   */
  @Test
  @DisplayName("Test new AppearanceGeneratorHelper(PDVariableText); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AppearanceGeneratorHelper.<init>(PDVariableText)"})
  void testNewAppearanceGeneratorHelper_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    PDVariableText field = mock(PDVariableText.class);
    when(field.getDefaultAppearance()).thenThrow(new IllegalArgumentException("foo"));
    when(field.getDefaultAppearanceString()).thenThrow(new IOException("foo"));
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new AppearanceGeneratorHelper(field));
    verify(field).getAcroForm();
    verify(field).getDefaultAppearance();
    verify(field).getDefaultAppearanceString();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   * <p>
   * Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName("Test setAppearanceValue(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue() throws IOException {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearanceCharacteristics())
        .thenReturn(new PDAppearanceCharacteristicsDictionary(new COSDictionary()));
    when(pdAnnotationWidget.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(pdAnnotationWidget.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(pdAnnotationWidget.getRectangle()).thenReturn(PDRectangle.A0);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);
    PDVariableText field = mock(PDVariableText.class);
    COSString defaultAppearance = COSString.parseHex("");
    when(field.getDefaultAppearanceString())
        .thenReturn(new PDDefaultAppearanceString(defaultAppearance, new PDResources()));
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new AppearanceGeneratorHelper(field)).setAppearanceValue("42"));
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget, atLeast(1)).getRectangle();
    verify(pdAnnotationWidget, atLeast(1)).getAppearanceCharacteristics();
    verify(pdAnnotationWidget, atLeast(1)).getBorderStyle();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   * <p>
   * Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName("Test setAppearanceValue(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue2() throws IOException {
    // Arrange
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenThrow(new IllegalArgumentException("PMD"));
    when(fontDictionary.isDirect()).thenReturn(true);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(fontDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.A);
    pdDefaultAppearanceString.setFont(font);
    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearanceCharacteristics())
        .thenReturn(new PDAppearanceCharacteristicsDictionary(new COSDictionary()));
    when(pdAnnotationWidget.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(pdAnnotationWidget.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(pdAnnotationWidget.getRectangle()).thenReturn(PDRectangle.A0);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);
    PDVariableText field = mock(PDVariableText.class);
    when(field.getQ()).thenReturn(1);
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new AppearanceGeneratorHelper(field)).setAppearanceValue("42"));
    verify(fontDictionary).isDirect();
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary).getInt(isA(COSName.class), eq(-1));
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary).getUpdateState();
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget, atLeast(1)).getRectangle();
    verify(pdAnnotationWidget, atLeast(1)).getAppearanceCharacteristics();
    verify(pdAnnotationWidget, atLeast(1)).getBorderStyle();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
    verify(field).getQ();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   * <ul>
   *   <li>Given {@link PDVariableText} {@link PDVariableText#getQ()} return five.</li>
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName("Test setAppearanceValue(String); given PDVariableText getQ() return five; then calls getCOSArray(COSName)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue_givenPDVariableTextGetQReturnFive_thenCallsGetCOSArray() throws IOException {
    // Arrange
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(fontDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(fontDictionary.isDirect()).thenReturn(true);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(fontDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.A);
    pdDefaultAppearanceString.setFont(font);
    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearanceCharacteristics())
        .thenReturn(new PDAppearanceCharacteristicsDictionary(new COSDictionary()));
    when(pdAnnotationWidget.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(pdAnnotationWidget.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(pdAnnotationWidget.getRectangle()).thenReturn(PDRectangle.A0);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);
    PDVariableText field = mock(PDVariableText.class);
    when(field.getQ()).thenReturn(5);
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act
    (new AppearanceGeneratorHelper(field)).setAppearanceValue("42");

    // Assert
    verify(fontDictionary).isDirect();
    verify(fontDictionary).getCOSArray(isA(COSName.class));
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary).getUpdateState();
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget, atLeast(1)).getRectangle();
    verify(pdAnnotationWidget, atLeast(1)).getAppearanceCharacteristics();
    verify(pdAnnotationWidget, atLeast(1)).getBorderStyle();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
    verify(field).getQ();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   * <ul>
   *   <li>Then calls {@link PDField#getAcroForm()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName("Test setAppearanceValue(String); then calls getAcroForm()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue_thenCallsGetAcroForm() throws IOException {
    // Arrange
    PDVariableText field = mock(PDVariableText.class);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");
    when(field.getDefaultAppearanceString())
        .thenReturn(new PDDefaultAppearanceString(defaultAppearance, new PDResources()));
    when(field.getWidgets()).thenReturn(new ArrayList<>());
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act
    (new AppearanceGeneratorHelper(field)).setAppearanceValue("42");

    // Assert
    verify(field).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   * <ul>
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName("Test setAppearanceValue(String); then calls getCOSArray(COSName)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue_thenCallsGetCOSArray() throws IOException {
    // Arrange
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(fontDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(fontDictionary.isDirect()).thenReturn(true);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(fontDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.A);
    pdDefaultAppearanceString.setFont(font);
    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearanceCharacteristics())
        .thenReturn(new PDAppearanceCharacteristicsDictionary(new COSDictionary()));
    when(pdAnnotationWidget.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(pdAnnotationWidget.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(pdAnnotationWidget.getRectangle()).thenReturn(PDRectangle.A0);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);
    PDVariableText field = mock(PDVariableText.class);
    when(field.getQ()).thenReturn(1);
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act
    (new AppearanceGeneratorHelper(field)).setAppearanceValue("42");

    // Assert
    verify(fontDictionary).isDirect();
    verify(fontDictionary).getCOSArray(isA(COSName.class));
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary).getUpdateState();
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget, atLeast(1)).getRectangle();
    verify(pdAnnotationWidget, atLeast(1)).getAppearanceCharacteristics();
    verify(pdAnnotationWidget, atLeast(1)).getBorderStyle();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
    verify(field).getQ();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   * <ul>
   *   <li>Then calls {@link PDField#getFullyQualifiedName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName("Test setAppearanceValue(String); then calls getFullyQualifiedName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue_thenCallsGetFullyQualifiedName() throws IOException {
    // Arrange
    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(new PDAnnotationWidget());
    PDVariableText field = mock(PDVariableText.class);
    when(field.getFullyQualifiedName()).thenReturn("Dr Jane Doe");
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");
    when(field.getDefaultAppearanceString())
        .thenReturn(new PDDefaultAppearanceString(defaultAppearance, new PDResources()));
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act
    (new AppearanceGeneratorHelper(field)).setAppearanceValue("42");

    // Assert
    verify(field).getAcroForm();
    verify(field).getActions();
    verify(field).getFullyQualifiedName();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName("Test setAppearanceValue(String); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearanceCharacteristics())
        .thenReturn(new PDAppearanceCharacteristicsDictionary(new COSDictionary()));
    when(pdAnnotationWidget.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(pdAnnotationWidget.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(pdAnnotationWidget.getRectangle()).thenReturn(PDRectangle.A0);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);
    PDVariableText field = mock(PDVariableText.class);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");
    when(field.getDefaultAppearanceString())
        .thenReturn(new PDDefaultAppearanceString(defaultAppearance, new PDResources()));
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new AppearanceGeneratorHelper(field)).setAppearanceValue("42"));
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget, atLeast(1)).getRectangle();
    verify(pdAnnotationWidget, atLeast(1)).getAppearanceCharacteristics();
    verify(pdAnnotationWidget, atLeast(1)).getBorderStyle();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName("Test setAppearanceValue(String); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue_thenThrowIllegalArgumentException2() throws IOException {
    // Arrange
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString = new PDDefaultAppearanceString(defaultAppearance,
        new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.A);
    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearanceCharacteristics())
        .thenReturn(new PDAppearanceCharacteristicsDictionary(new COSDictionary()));
    when(pdAnnotationWidget.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(pdAnnotationWidget.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(pdAnnotationWidget.getRectangle()).thenReturn(PDRectangle.A0);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);
    PDVariableText field = mock(PDVariableText.class);
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new AppearanceGeneratorHelper(field)).setAppearanceValue("42"));
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget, atLeast(1)).getRectangle();
    verify(pdAnnotationWidget, atLeast(1)).getAppearanceCharacteristics();
    verify(pdAnnotationWidget, atLeast(1)).getBorderStyle();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
  }
}
