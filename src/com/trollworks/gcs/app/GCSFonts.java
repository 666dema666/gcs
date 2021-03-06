/*
 * Copyright (c) 1998-2014 by Richard A. Wilkes. All rights reserved.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * version 2.0. If a copy of the MPL was not distributed with this file, You
 * can obtain one at http://mozilla.org/MPL/2.0/.
 *
 * This Source Code Form is "Incompatible With Secondary Licenses", as defined
 * by the Mozilla Public License, version 2.0.
 */

package com.trollworks.gcs.app;

import com.trollworks.toolkit.annotation.Localize;
import com.trollworks.toolkit.ui.Fonts;
import com.trollworks.toolkit.utility.Localization;

import java.awt.Font;

/** GCS-specific fonts. */
public class GCSFonts {
	@Localize("Labels")
	private static String		LABELS_FONT;
	@Localize("Fields")
	private static String		FIELDS_FONT;
	@Localize("Field Notes")
	private static String		FIELD_NOTES_FONT;
	@Localize("Technique Fields")
	private static String		TECHNIQUE_FIELDS_FONT;
	@Localize("Primary Footer")
	private static String		PRIMARY_FOOTER_FONT;
	@Localize("Secondary Footer")
	private static String		SECONDARY_FOOTER_FONT;
	@Localize("Notes")
	private static String		NOTES_FONT;

	static {
		Localization.initialize();
	}

	/** The label font. */
	public static final String	KEY_LABEL				= "trollworks.label";				//$NON-NLS-1$
	/** The field font. */
	public static final String	KEY_FIELD				= "trollworks.field";				//$NON-NLS-1$
	/** The field notes font. */
	public static final String	KEY_FIELD_NOTES			= "trollworks.field.notes";		//$NON-NLS-1$
	/** The technique field font. */
	public static final String	KEY_TECHNIQUE_FIELD		= "trollworks.field.technique";	//$NON-NLS-1$
	/** The primary footer font. */
	public static final String	KEY_PRIMARY_FOOTER		= "trollworks.footer.primary";		//$NON-NLS-1$
	/** The secondary footer font. */
	public static final String	KEY_SECONDARY_FOOTER	= "trollworks.footer.secondary";	//$NON-NLS-1$
	/** The notes font. */
	public static final String	KEY_NOTES				= "trollworks.notes";				//$NON-NLS-1$

	/** Register our fonts. */
	public static final void register() {
		String name = Fonts.getDefaultFontName();
		Fonts.register(KEY_LABEL, LABELS_FONT, new Font(name, Font.PLAIN, 9));
		Fonts.register(KEY_FIELD, FIELDS_FONT, new Font(name, Font.BOLD, 9));
		Fonts.register(KEY_FIELD_NOTES, FIELD_NOTES_FONT, new Font(name, Font.PLAIN, 8));
		Fonts.register(KEY_TECHNIQUE_FIELD, TECHNIQUE_FIELDS_FONT, new Font(name, Font.BOLD + Font.ITALIC, 9));
		Fonts.register(KEY_PRIMARY_FOOTER, PRIMARY_FOOTER_FONT, new Font(name, Font.BOLD, 8));
		Fonts.register(KEY_SECONDARY_FOOTER, SECONDARY_FOOTER_FONT, new Font(name, Font.PLAIN, 6));
		Fonts.register(KEY_NOTES, NOTES_FONT, new Font(name, Font.PLAIN, 9));
	}
}
