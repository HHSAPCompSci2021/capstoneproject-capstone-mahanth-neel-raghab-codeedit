package codeedit.halideeditor.components.menus;

import java.awt.event.ActionListener;

public class SettingsMenu extends Menu{
	
	public static final String CONTROLS = "Controls";
	
	public static final String AUTOCOMPLETES = "Autocompletes";

	public SettingsMenu(ActionListener handler) {
		super("Settings", handler);
		addMenuItem(CONTROLS);
		addMenuItem(AUTOCOMPLETES);
	}

}
