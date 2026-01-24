package org.apache.pdfbox.debugger.ui.textsearcher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Color;
import java.awt.Component;
import java.awt.Component.BaselineResizeBehavior;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.event.AWTEventListener;
import java.awt.event.AWTEventListenerProxy;
import java.awt.event.ComponentListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.image.DirectColorModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeListenerProxy;
import java.util.Locale;
import java.util.MissingResourceException;
import javax.accessibility.AccessibleContext;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Box;
import javax.swing.Box.Filler;
import javax.swing.BoxLayout;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentListener;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.DefaultEditorKit.BeepAction;
import org.apache.pdfbox.debugger.PDFDebugger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SearchPanelDiffblueTest {
  @InjectMocks private SearchPanel searchPanel;

  /**
   * Test {@link SearchPanel#SearchPanel(DocumentListener, ChangeListener, ComponentListener,
   * Action, Action)}.
   *
   * <p>Method under test: {@link SearchPanel#SearchPanel(DocumentListener, ChangeListener,
   * ComponentListener, Action, Action)}
   */
  @Test
  @DisplayName(
      "Test new SearchPanel(DocumentListener, ChangeListener, ComponentListener, Action, Action)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SearchPanel.<init>(DocumentListener, ChangeListener, ComponentListener, Action, Action)"
  })
  void testNewSearchPanel() {
    // Arrange
    Searcher documentListener = new Searcher(new JEditorPane());
    ChangeListener changeListener = mock(ChangeListener.class);
    Searcher compListener = new Searcher(new JEditorPane());
    BeepAction nextAction = new BeepAction();

    // Act
    SearchPanel actualSearchPanel =
        new SearchPanel(
            documentListener, changeListener, compListener, nextAction, new BeepAction());

    // Assert
    assertEquals("", actualSearchPanel.getSearchWord());
    assertFalse(actualSearchPanel.isCaseSensitive());
  }

  /**
   * Test {@link SearchPanel#isCaseSensitive()}.
   *
   * <p>Method under test: {@link SearchPanel#isCaseSensitive()}
   */
  @Test
  @DisplayName("Test isCaseSensitive()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SearchPanel.isCaseSensitive()"})
  void testIsCaseSensitive() {
    // Arrange
    Searcher documentListener = new Searcher(new JEditorPane());
    ChangeListener changeListener = mock(ChangeListener.class);
    Searcher compListener = new Searcher(new JEditorPane());
    BeepAction nextAction = new BeepAction();

    SearchPanel searchPanel =
        new SearchPanel(
            documentListener, changeListener, compListener, nextAction, new BeepAction());

    // Act and Assert
    assertFalse(searchPanel.isCaseSensitive());
  }

  /**
   * Test {@link SearchPanel#getSearchWord()}.
   *
   * <p>Method under test: {@link SearchPanel#getSearchWord()}
   */
  @Test
  @DisplayName("Test getSearchWord()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String SearchPanel.getSearchWord()"})
  void testGetSearchWord() {
    // Arrange
    Searcher documentListener = new Searcher(new JEditorPane());
    ChangeListener changeListener = mock(ChangeListener.class);
    Searcher compListener = new Searcher(new JEditorPane());
    BeepAction nextAction = new BeepAction();

    SearchPanel searchPanel =
        new SearchPanel(
            documentListener, changeListener, compListener, nextAction, new BeepAction());

    // Act and Assert
    assertEquals("", searchPanel.getSearchWord());
  }

  /**
   * Test {@link SearchPanel#reset()}.
   *
   * <p>Method under test: {@link SearchPanel#reset()}
   */
  @Test
  @DisplayName("Test reset()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SearchPanel.reset()"})
  void testReset() {
    // Arrange and Act
    searchPanel.reset();

    // Assert
    JPanel panel = searchPanel.getPanel();
    Rectangle boundsResult = panel.bounds();
    Rectangle2D bounds2D = boundsResult.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle bounds = boundsResult.getBounds().getBounds();
    assertTrue(bounds.getBounds2D() instanceof Rectangle);
    Rectangle bounds2 = panel.getVisibleRect().getBounds();
    assertTrue(bounds2.getBounds2D() instanceof Rectangle);
    assertTrue(bounds2D.getBounds2D() instanceof Rectangle);
    Rectangle2D frame = boundsResult.getFrame();
    assertTrue(frame.getBounds2D() instanceof Double);
    assertTrue(frame instanceof Double);
    assertTrue(bounds.getFrame() instanceof Double);
    assertTrue(bounds2.getFrame() instanceof Double);
    assertTrue(bounds2D.getFrame() instanceof Double);
    assertTrue(frame.getFrame() instanceof Double);
  }

  /**
   * Test {@link SearchPanel#updateCounterLabel(int, int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then third element Text is {@code 3 of 3}.
   * </ul>
   *
   * <p>Method under test: {@link SearchPanel#updateCounterLabel(int, int)}
   */
  @Test
  @DisplayName("Test updateCounterLabel(int, int); when three; then third element Text is '3 of 3'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SearchPanel.updateCounterLabel(int, int)"})
  void testUpdateCounterLabel_whenThree_thenThirdElementTextIs3Of3() {
    // Arrange
    Searcher documentListener = new Searcher(new JEditorPane());
    ChangeListener changeListener = mock(ChangeListener.class);
    Searcher compListener = new Searcher(new JEditorPane());
    BeepAction nextAction = new BeepAction();

    SearchPanel searchPanel =
        new SearchPanel(
            documentListener, changeListener, compListener, nextAction, new BeepAction());

    // Act
    searchPanel.updateCounterLabel(3, 3);

    // Assert
    JPanel panel = searchPanel.getPanel();
    Component[] components = panel.getComponents();
    Component component = components[2];
    assertTrue(component instanceof JLabel);
    assertEquals(" 3 of 3 ", ((JLabel) component).getText());
    Dimension minimumSize = panel.getMinimumSize();
    Dimension size = minimumSize.getSize();
    assertEquals(393, size.getSize().width);
    assertEquals(393, size.width);
    assertEquals(393, minimumSize.width);
    assertEquals(393.0d, size.getWidth());
    assertEquals(393.0d, minimumSize.getWidth());
    assertEquals(46, component.getMaximumSize().width);
    assertEquals(8, components.length);
  }

  /**
   * Test {@link SearchPanel#updateCounterLabel(int, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then third element Text is {@code No match found}.
   * </ul>
   *
   * <p>Method under test: {@link SearchPanel#updateCounterLabel(int, int)}
   */
  @Test
  @DisplayName(
      "Test updateCounterLabel(int, int); when zero; then third element Text is 'No match found'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SearchPanel.updateCounterLabel(int, int)"})
  void testUpdateCounterLabel_whenZero_thenThirdElementTextIsNoMatchFound() {
    // Arrange
    Searcher documentListener = new Searcher(new JEditorPane());
    ChangeListener changeListener = mock(ChangeListener.class);
    Searcher compListener = new Searcher(new JEditorPane());
    BeepAction nextAction = new BeepAction();

    SearchPanel searchPanel =
        new SearchPanel(
            documentListener, changeListener, compListener, nextAction, new BeepAction());

    // Act
    searchPanel.updateCounterLabel(3, 0);

    // Assert
    JPanel panel = searchPanel.getPanel();
    Component[] components = panel.getComponents();
    Component component = components[2];
    assertTrue(component instanceof JLabel);
    assertEquals(" No match found ", ((JLabel) component).getText());
    assertEquals(119, component.getMaximumSize().width);
    Dimension minimumSize = panel.getMinimumSize();
    Dimension size = minimumSize.getSize();
    assertEquals(466, size.getSize().width);
    assertEquals(466, size.width);
    assertEquals(466, minimumSize.width);
    assertEquals(466.0d, size.getWidth());
    assertEquals(466.0d, minimumSize.getWidth());
    assertEquals(8, components.length);
  }

  /**
   * Test {@link SearchPanel#getPanel()}.
   *
   * <p>Method under test: {@link SearchPanel#getPanel()}
   */
  @Test
  @DisplayName("Test getPanel()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JPanel SearchPanel.getPanel()"})
  void testGetPanel() throws MissingResourceException {
    // Arrange
    Searcher documentListener = new Searcher(new JEditorPane());
    ChangeListener changeListener = mock(ChangeListener.class);
    Searcher compListener = new Searcher(new JEditorPane());
    BeepAction nextAction = new BeepAction();

    SearchPanel searchPanel =
        new SearchPanel(
            documentListener, changeListener, compListener, nextAction, new BeepAction());

    // Act
    JPanel actualPanel = searchPanel.getPanel();

    // Assert
    Rectangle boundsResult = actualPanel.bounds();
    Rectangle2D bounds2D = boundsResult.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Color background = actualPanel.getBackground();
    ColorSpace colorSpace = background.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    Toolkit toolkit = actualPanel.getToolkit();
    AWTEventListener[] aWTEventListeners = toolkit.getAWTEventListeners();
    assertTrue(aWTEventListeners[0] instanceof AWTEventListenerProxy);
    Rectangle2D frame = boundsResult.getFrame();
    assertTrue(frame instanceof Double);
    assertTrue(actualPanel.getColorModel() instanceof DirectColorModel);
    PropertyChangeListener[] propertyChangeListeners = toolkit.getPropertyChangeListeners();
    assertTrue(propertyChangeListeners[0] instanceof PropertyChangeListenerProxy);
    Component[] components = actualPanel.getComponents();
    assertTrue(components[0] instanceof Filler);
    assertTrue(components[6] instanceof Filler);
    assertTrue(actualPanel.getLayout() instanceof BoxLayout);
    assertTrue(components[3] instanceof JButton);
    assertTrue(components[4] instanceof JButton);
    assertTrue(components[7] instanceof JButton);
    assertTrue(components[5] instanceof JCheckBox);
    assertTrue(components[2] instanceof JLabel);
    assertTrue(components[1] instanceof JTextField);
    assertTrue(actualPanel.getBorder() instanceof MatteBorder);
    ComponentListener[] componentListeners = actualPanel.getComponentListeners();
    ComponentListener componentListener = componentListeners[0];
    assertTrue(componentListener instanceof Searcher);
    Locale locale = actualPanel.getLocale();
    assertEquals("", locale.getCountry());
    assertEquals("", locale.getDisplayCountry());
    assertEquals("", locale.getDisplayScript());
    assertEquals("", locale.getDisplayVariant());
    assertEquals("", locale.getISO3Country());
    assertEquals("", locale.getScript());
    assertEquals("", locale.getVariant());
    Cursor cursor = actualPanel.getCursor();
    assertEquals("Default Cursor", cursor.getName());
    Font font = actualPanel.getFont();
    assertEquals("Dialog", font.getFamily());
    assertEquals("Dialog", font.getName());
    assertEquals("Dialog.plain", font.getFontName());
    assertEquals("Dialog.plain", font.getPSName());
    assertEquals("English", locale.getDisplayLanguage());
    assertEquals("English", locale.getDisplayName());
    assertEquals("PanelUI", actualPanel.getUIClassID());
    assertEquals("en", locale.getLanguage());
    assertEquals("eng", locale.getISO3Language());
    assertNull(actualPanel.getNextFocusableComponent());
    assertNull(actualPanel.getFocusCycleRootAncestor());
    assertNull(actualPanel.getParent());
    assertNull(actualPanel.getTopLevelAncestor());
    assertNull(actualPanel.getFocusTraversalPolicy());
    assertNull(actualPanel.getGraphics());
    assertNull(actualPanel.getGraphicsConfiguration());
    assertNull(actualPanel.getDropTarget());
    assertNull(actualPanel.getInputContext());
    assertNull(actualPanel.getInputMethodRequests());
    ActionMap actionMap = actualPanel.getActionMap();
    assertNull(actionMap.keys());
    assertNull(actualPanel.getName());
    AccessibleContext accessibleContext = actualPanel.getAccessibleContext();
    assertNull(accessibleContext.getAccessibleDescription());
    assertNull(accessibleContext.getAccessibleName());
    assertNull(actualPanel.getToolTipText());
    assertNull(accessibleContext.getAccessibleParent());
    assertNull(accessibleContext.getAccessibleAction());
    assertNull(accessibleContext.getAccessibleEditableText());
    assertNull(accessibleContext.getAccessibleIcon());
    assertNull(accessibleContext.getAccessibleSelection());
    assertNull(accessibleContext.getAccessibleTable());
    assertNull(accessibleContext.getAccessibleText());
    assertNull(accessibleContext.getAccessibleValue());
    assertNull(actionMap.getParent());
    InputMap inputMap = actualPanel.getInputMap();
    assertNull(inputMap.getParent());
    assertNull(actualPanel.getInputVerifier());
    assertNull(actualPanel.getComponentPopupMenu());
    assertNull(actualPanel.getRootPane());
    assertNull(inputMap.keys());
    assertNull(actualPanel.getTransferHandler());
    Color brighterResult = background.brighter();
    assertEquals(-1, brighterResult.getRGB());
    Color foreground = actualPanel.getForeground();
    Color brighterResult2 = foreground.brighter();
    assertEquals(-12040120, brighterResult2.getRGB());
    assertEquals(-13421773, foreground.getRGB());
    Color darkerResult = foreground.darker();
    assertEquals(-14474461, darkerResult.getRGB());
    assertEquals(-1644826, background.getRGB());
    Color darkerResult2 = brighterResult.darker();
    assertEquals(-5066062, darkerResult2.getRGB());
    Color darkerResult3 = background.darker();
    assertEquals(-6184543, darkerResult3.getRGB());
    Color darkerResult4 = darkerResult3.darker();
    assertEquals(-9408400, darkerResult4.getRGB());
    assertEquals(0, cursor.getType());
    assertEquals(0, font.getMissingGlyphCode());
    assertEquals(0, font.getStyle());
    AffineTransform transform = font.getTransform();
    assertEquals(0, transform.getType());
    assertEquals(0, accessibleContext.getAccessibleRelationSet().size());
    assertEquals(0, actionMap.size());
    assertEquals(0, inputMap.size());
    assertEquals(0, actualPanel.getDebugGraphicsOptions());
    assertEquals(0, actualPanel.getHeight());
    assertEquals(0, actualPanel.getWidth());
    assertEquals(0, actualPanel.getX());
    assertEquals(0, actualPanel.getY());
    assertEquals(0, actualPanel.getFocusListeners().length);
    assertEquals(0, actualPanel.getHierarchyBoundsListeners().length);
    assertEquals(0, actualPanel.getHierarchyListeners().length);
    assertEquals(0, actualPanel.getInputMethodListeners().length);
    assertEquals(0, actualPanel.getKeyListeners().length);
    assertEquals(0, actualPanel.getMouseListeners().length);
    assertEquals(0, actualPanel.getMouseMotionListeners().length);
    assertEquals(0, actualPanel.getMouseWheelListeners().length);
    assertEquals(0, actualPanel.getPropertyChangeListeners().length);
    assertEquals(0, actualPanel.getContainerListeners().length);
    assertEquals(0, actualPanel.getAncestorListeners().length);
    assertEquals(0, actualPanel.getRegisteredKeyStrokes().length);
    assertEquals(0, actualPanel.getVetoableChangeListeners().length);
    Dimension size = actualPanel.getSize();
    assertEquals(0, size.height);
    assertEquals(0, size.width);
    Insets insets = actualPanel.getInsets();
    assertEquals(0, insets.bottom);
    assertEquals(0, insets.left);
    assertEquals(0, insets.right);
    Point location = actualPanel.getLocation();
    assertEquals(0, location.x);
    assertEquals(0, location.y);
    assertEquals(0, boundsResult.height);
    assertEquals(0, boundsResult.width);
    assertEquals(0, boundsResult.x);
    assertEquals(0, boundsResult.y);
    assertEquals(0.0d, size.getHeight());
    assertEquals(0.0d, size.getWidth());
    assertEquals(0.0d, location.getX());
    assertEquals(0.0d, location.getY());
    assertEquals(0.0d, boundsResult.getHeight());
    assertEquals(0.0d, boundsResult.getWidth());
    assertEquals(0.0d, boundsResult.getX());
    assertEquals(0.0d, boundsResult.getY());
    assertEquals(0.0d, transform.getShearX());
    assertEquals(0.0d, transform.getShearY());
    assertEquals(0.0d, transform.getTranslateX());
    assertEquals(0.0d, transform.getTranslateY());
    assertEquals(0.0d, boundsResult.getCenterX());
    assertEquals(0.0d, boundsResult.getCenterY());
    assertEquals(0.0d, boundsResult.getMaxX());
    assertEquals(0.0d, boundsResult.getMaxY());
    assertEquals(0.0d, boundsResult.getMinX());
    assertEquals(0.0d, boundsResult.getMinY());
    assertEquals(0.0f, font.getItalicAngle());
    assertEquals(0.48f, actualPanel.getAlignmentY());
    assertEquals(0.5f, actualPanel.getAlignmentX());
    assertEquals(1, brighterResult.getTransparency());
    assertEquals(1, brighterResult2.getTransparency());
    assertEquals(1, darkerResult2.getTransparency());
    assertEquals(1, darkerResult4.getTransparency());
    assertEquals(1, darkerResult3.getTransparency());
    assertEquals(1, darkerResult.getTransparency());
    assertEquals(1, background.getTransparency());
    assertEquals(1, foreground.getTransparency());
    assertEquals(1, componentListeners.length);
    assertEquals(1, aWTEventListeners.length);
    assertEquals(1, propertyChangeListeners.length);
    assertEquals(1, insets.top);
    assertEquals(1.0d, transform.getDeterminant());
    assertEquals(1.0d, transform.getScaleX());
    assertEquals(1.0d, transform.getScaleY());
    assertEquals(112, darkerResult4.getBlue());
    assertEquals(112, darkerResult4.getGreen());
    assertEquals(112, darkerResult4.getRed());
    assertEquals(12, font.getSize());
    assertEquals(12.0f, font.getSize2D());
    assertEquals(161, darkerResult3.getBlue());
    assertEquals(161, darkerResult3.getGreen());
    assertEquals(161, darkerResult3.getRed());
    assertEquals(178, darkerResult2.getBlue());
    assertEquals(178, darkerResult2.getGreen());
    assertEquals(178, darkerResult2.getRed());
    Dimension maximumSize = actualPanel.getMaximumSize();
    assertEquals(2.147483647E9d, maximumSize.getHeight());
    assertEquals(2.147483647E9d, maximumSize.getWidth());
    assertEquals(22, font.getAvailableAttributes().length);
    assertEquals(230, background.getBlue());
    assertEquals(230, background.getGreen());
    assertEquals(230, background.getRed());
    assertEquals(255, brighterResult.getAlpha());
    assertEquals(255, brighterResult2.getAlpha());
    assertEquals(255, darkerResult2.getAlpha());
    assertEquals(255, darkerResult4.getAlpha());
    assertEquals(255, darkerResult3.getAlpha());
    assertEquals(255, darkerResult.getAlpha());
    assertEquals(255, background.getAlpha());
    assertEquals(255, foreground.getAlpha());
    assertEquals(255, brighterResult.getBlue());
    assertEquals(255, brighterResult.getGreen());
    assertEquals(255, brighterResult.getRed());
    Dimension minimumSize = actualPanel.getMinimumSize();
    assertEquals(26, minimumSize.height);
    assertEquals(26.0d, minimumSize.getHeight());
    assertEquals(347, minimumSize.width);
    assertEquals(347.0d, minimumSize.getWidth());
    assertEquals(35, darkerResult.getBlue());
    assertEquals(35, darkerResult.getGreen());
    assertEquals(35, darkerResult.getRed());
    assertEquals(51, foreground.getBlue());
    assertEquals(51, foreground.getGreen());
    assertEquals(51, foreground.getRed());
    assertEquals(6253, font.getNumGlyphs());
    assertEquals(72, brighterResult2.getBlue());
    assertEquals(72, brighterResult2.getGreen());
    assertEquals(72, brighterResult2.getRed());
    assertEquals(8, actualPanel.getComponentCount());
    assertEquals(8, font.getAttributes().size());
    assertEquals(8, components.length);
    assertEquals(BaselineResizeBehavior.OTHER, actualPanel.getBaselineResizeBehavior());
    assertFalse(actualPanel.getIgnoreRepaint());
    assertFalse(actualPanel.hasFocus());
    assertFalse(actualPanel.isCursorSet());
    assertFalse(actualPanel.isDisplayable());
    assertFalse(actualPanel.isFocusOwner());
    assertFalse(actualPanel.isLightweight());
    assertFalse(actualPanel.isMaximumSizeSet());
    assertFalse(actualPanel.isMinimumSizeSet());
    assertFalse(actualPanel.isPreferredSizeSet());
    assertFalse(actualPanel.isShowing());
    assertFalse(actualPanel.isValid());
    assertFalse(actualPanel.isFocusCycleRoot());
    assertFalse(actualPanel.isFocusTraversalPolicyProvider());
    assertFalse(actualPanel.isFocusTraversalPolicySet());
    assertFalse(font.hasLayoutAttributes());
    assertFalse(font.hasUniformLineMetrics());
    assertFalse(font.isBold());
    assertFalse(font.isItalic());
    assertFalse(font.isTransformed());
    assertFalse(toolkit.isAlwaysOnTopSupported());
    assertFalse(locale.hasExtensions());
    assertFalse(actualPanel.getAutoscrolls());
    assertFalse(actualPanel.getInheritsPopupMenu());
    assertFalse(actualPanel.isManagingFocus());
    assertFalse(actualPanel.isPaintingForPrint());
    assertFalse(actualPanel.isPaintingTile());
    assertFalse(actualPanel.isValidateRoot());
    assertTrue(actualPanel.getFocusTraversalKeysEnabled());
    assertTrue(actualPanel.isBackgroundSet());
    assertTrue(actualPanel.isEnabled());
    assertTrue(actualPanel.isFocusable());
    assertTrue(actualPanel.isFontSet());
    assertTrue(actualPanel.isForegroundSet());
    assertTrue(actualPanel.isVisible());
    ComponentOrientation componentOrientation = actualPanel.getComponentOrientation();
    assertTrue(componentOrientation.isHorizontal());
    assertTrue(componentOrientation.isLeftToRight());
    assertTrue(font.isPlain());
    assertTrue(boundsResult.isEmpty());
    assertTrue(transform.isIdentity());
    assertTrue(locale.getExtensionKeys().isEmpty());
    assertTrue(actualPanel.getVerifyInputWhenFocusTarget());
    assertTrue(actualPanel.isDoubleBuffered());
    assertTrue(actualPanel.isOpaque());
    assertTrue(actualPanel.isOptimizedDrawingEnabled());
    assertTrue(actualPanel.isRequestFocusEnabled());
    assertEquals(boundsResult, bounds2D);
    assertEquals(boundsResult, frame);
    assertEquals(Integer.MAX_VALUE, maximumSize.height);
    assertEquals(Integer.MAX_VALUE, maximumSize.width);
    assertSame(compListener, componentListener);
    assertSame(colorSpace, brighterResult.getColorSpace());
    assertSame(colorSpace, brighterResult2.getColorSpace());
    assertSame(colorSpace, darkerResult2.getColorSpace());
    assertSame(colorSpace, darkerResult4.getColorSpace());
    assertSame(colorSpace, darkerResult3.getColorSpace());
    assertSame(colorSpace, darkerResult.getColorSpace());
    assertSame(colorSpace, foreground.getColorSpace());
  }

  /**
   * Test {@link SearchPanel#reFocus()}.
   *
   * <p>Method under test: {@link SearchPanel#reFocus()}
   */
  @Test
  @DisplayName("Test reFocus()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SearchPanel.reFocus()"})
  void testReFocus() {
    // Arrange
    Searcher documentListener = new Searcher(new JEditorPane());
    ChangeListener changeListener = mock(ChangeListener.class);
    Searcher compListener = new Searcher(new JEditorPane());
    BeepAction nextAction = new BeepAction();

    SearchPanel searchPanel =
        new SearchPanel(
            documentListener, changeListener, compListener, nextAction, new BeepAction());

    // Act
    searchPanel.reFocus();

    // Assert
    Component[] components = searchPanel.getPanel().getComponents();
    assertTrue(components[3] instanceof JButton);
    assertTrue(components[2] instanceof JLabel);
    assertTrue(components[1] instanceof JTextField);
    assertEquals(8, components.length);
  }

  /**
   * Test {@link SearchPanel#addMenuListeners(PDFDebugger)}.
   *
   * <ul>
   *   <li>Then calls {@link PDFDebugger#getFindMenu()}.
   * </ul>
   *
   * <p>Method under test: {@link SearchPanel#addMenuListeners(PDFDebugger)}
   */
  @Test
  @DisplayName("Test addMenuListeners(PDFDebugger); then calls getFindMenu()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SearchPanel.addMenuListeners(PDFDebugger)"})
  void testAddMenuListeners_thenCallsGetFindMenu() {
    // Arrange
    Searcher documentListener = new Searcher(new JEditorPane());
    ChangeListener changeListener = mock(ChangeListener.class);
    Searcher compListener = new Searcher(new JEditorPane());
    BeepAction nextAction = new BeepAction();

    SearchPanel searchPanel =
        new SearchPanel(
            documentListener, changeListener, compListener, nextAction, new BeepAction());

    PDFDebugger frame = mock(PDFDebugger.class);
    when(frame.getFindPreviousMenuItem()).thenReturn(new JMenuItem());
    when(frame.getFindNextMenuItem()).thenReturn(new JMenuItem());
    when(frame.getFindMenuItem()).thenReturn(new JMenuItem());
    when(frame.getFindMenu()).thenReturn(new JMenu());

    // Act
    searchPanel.addMenuListeners(frame);

    // Assert
    verify(frame).getFindMenu();
    verify(frame).getFindMenuItem();
    verify(frame).getFindNextMenuItem();
    verify(frame).getFindPreviousMenuItem();
  }

  /**
   * Test {@link SearchPanel#removeMenuListeners(PDFDebugger)}.
   *
   * <ul>
   *   <li>Then calls {@link PDFDebugger#getFindMenu()}.
   * </ul>
   *
   * <p>Method under test: {@link SearchPanel#removeMenuListeners(PDFDebugger)}
   */
  @Test
  @DisplayName("Test removeMenuListeners(PDFDebugger); then calls getFindMenu()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SearchPanel.removeMenuListeners(PDFDebugger)"})
  void testRemoveMenuListeners_thenCallsGetFindMenu() {
    // Arrange
    Searcher documentListener = new Searcher(new JEditorPane());
    ChangeListener changeListener = mock(ChangeListener.class);
    Searcher compListener = new Searcher(new JEditorPane());
    BeepAction nextAction = new BeepAction();

    SearchPanel searchPanel =
        new SearchPanel(
            documentListener, changeListener, compListener, nextAction, new BeepAction());

    PDFDebugger frame = mock(PDFDebugger.class);
    when(frame.getFindPreviousMenuItem()).thenReturn(new JMenuItem());
    when(frame.getFindNextMenuItem()).thenReturn(new JMenuItem());
    when(frame.getFindMenuItem()).thenReturn(new JMenuItem());
    when(frame.getFindMenu()).thenReturn(new JMenu());

    // Act
    searchPanel.removeMenuListeners(frame);

    // Assert
    verify(frame).getFindMenu();
    verify(frame).getFindMenuItem();
    verify(frame).getFindNextMenuItem();
    verify(frame).getFindPreviousMenuItem();
  }
}
