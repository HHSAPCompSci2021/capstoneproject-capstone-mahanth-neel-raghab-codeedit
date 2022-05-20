package codeedit.halideeditor.components.menus;

import java.awt.event.ActionListener;
import javax.swing.KeyStroke;

import static codeedit.halideeditor.utils.NativeOSUtils.ACTION_KEY;

/**
 * Represents the application {@code NavigateMenu}.
 * @author Neel Sudhakaran
 */
public class NavigateMenu extends Menu {

    /**
     * Symbolic constant for the action of switching to the first tab.
     */
    public static final String SWITCH_TO_FIRST_TAB = "First Tab";
    
    /**
     * Symbolic constant for the action of switching to the second tab.
     */
    public static final String SWITCH_TO_SECOND_TAB = "Second Tab";
    
    /**
     * Symbolic constant for the action of switching to the third tab.
     */
    public static final String SWITCH_TO_THIRD_TAB = "Third Tab";
    
    /**
     * Symbolic constant for the action of switching to the fourth tab.
     */
    public static final String SWITCH_TO_FOURTH_TAB = "Fourth Tab";
    
    /**
     * Symbolic constant for the action of switching to the fifth tab.
     */
    public static final String SWITCH_TO_FIFTH_TAB = "Fifth Tab";
    
    /**
     * Symbolic constant for the action of switching to the sixth tab.
     */
    public static final String SWITCH_TO_SIXTH_TAB = "Sixth Tab";
    
    /**
     * Symbolic constant for the action of switching to the seventh tab.
     */
    public static final String SWITCH_TO_SEVENTH_TAB = "Seventh Tab";
    
    /**
     * Symbolic constant for the action of switching to the eighth tab.
     */
    public static final String SWITCH_TO_EIGHTH_TAB = "Eighth Tab";
    
    /**
     * Symbolic constant for the action of switching to the last tab.
     */
    public static final String SWITCH_TO_LAST_TAB = "Last Tab";
    
    /**
     * Creates a new {@code NavigateMenu} with the specified handler.
     * @param handler the handler for all menu actions
     */
    public NavigateMenu(ActionListener handler) {
        super("Navigate", handler);
        addMenuItem(SWITCH_TO_FIRST_TAB, KeyStroke.getKeyStroke('1', ACTION_KEY));
        addMenuItem(SWITCH_TO_LAST_TAB, KeyStroke.getKeyStroke('9', ACTION_KEY));
        addSeparator();
        addMenuItem(SWITCH_TO_SECOND_TAB, KeyStroke.getKeyStroke('2', ACTION_KEY));
        addMenuItem(SWITCH_TO_THIRD_TAB, KeyStroke.getKeyStroke('3', ACTION_KEY));
        addMenuItem(SWITCH_TO_FOURTH_TAB, KeyStroke.getKeyStroke('4', ACTION_KEY));
        addMenuItem(SWITCH_TO_FIFTH_TAB, KeyStroke.getKeyStroke('5', ACTION_KEY));
        addMenuItem(SWITCH_TO_SIXTH_TAB, KeyStroke.getKeyStroke('6', ACTION_KEY));
        addMenuItem(SWITCH_TO_SEVENTH_TAB, KeyStroke.getKeyStroke('7', ACTION_KEY));
        addMenuItem(SWITCH_TO_EIGHTH_TAB, KeyStroke.getKeyStroke('8', ACTION_KEY));
    }

}
