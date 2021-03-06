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

package com.trollworks.gcs.character;

import com.trollworks.toolkit.annotation.Localize;
import com.trollworks.toolkit.ui.UIUtilities;
import com.trollworks.toolkit.ui.layout.ColumnLayout;
import com.trollworks.toolkit.ui.widget.Wrapper;
import com.trollworks.toolkit.utility.Localization;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.text.MessageFormat;

import javax.swing.SwingConstants;

/** The character hit location panel. */
public class HitLocationPanel extends DropPanel {
	@Localize("Hit Location")
	private static String			HIT_LOCATION;
	@Localize("Roll")
	private static String			ROLL;
	@Localize("<html><body>The random roll needed to hit the <b>{0}</b> hit location</body></html>")
	private static String			ROLL_TOOLTIP;
	@Localize("Where")
	private static String			LOCATION;
	@Localize("-")
	private static String			PENALTY;
	@Localize("The hit penalty for targeting a specific hit location")
	private static String			PENALTY_TITLE_TOOLTIP;
	@Localize("<html><body>The hit penalty for targeting the <b>{0}</b> hit location</body></html>")
	private static String			PENALTY_TOOLTIP;
	@Localize("DR")
	private static String			DR;
	@Localize("<html><body>The total DR protecting the <b>{0}</b> hit location</body></html>")
	private static String			DR_TOOLTIP;
	@Localize("Eye")
	private static String			EYE;
	@Localize("Skull")
	private static String			SKULL;
	@Localize("Face")
	private static String			FACE;
	@Localize("R. Leg")
	private static String			RIGHT_LEG;
	@Localize("R. Arm")
	private static String			RIGHT_ARM;
	@Localize("Torso")
	private static String			TORSO;
	@Localize("Groin")
	private static String			GROIN;
	@Localize("L. Arm")
	private static String			LEFT_ARM;
	@Localize("L. Leg")
	private static String			LEFT_LEG;
	@Localize("Hand")
	private static String			HAND;
	@Localize("Foot")
	private static String			FOOT;
	@Localize("Neck")
	private static String			NECK;
	@Localize("Vitals")
	private static String			VITALS;

	static {
		Localization.initialize();
	}

	/** The various hit locations. */
	public static final String[]	LOCATIONS	= new String[] { EYE, SKULL, FACE, RIGHT_LEG, RIGHT_ARM, TORSO, GROIN, LEFT_ARM, LEFT_LEG, HAND, FOOT, NECK, VITALS };
	/** The rolls needed for various hit locations. */
	public static final String[]	ROLLS		= new String[] { "-", "3-4", "5", "6-7", "8", "9-10", "11", "12", "13-14", "15", "16", "17-18", "-" };																																							//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
	/** The to hit penalties for various hit locations. */
	public static final String[]	PENALTIES	= new String[] { "-9", "-7", "-5", "-2", "-2", "0", "-3", "-2", "-2", "-4", "-4", "-5", "-3" };																																								//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
	/** The DR for various hit locations. */
	public static final String[]	DR_KEYS		= new String[] { Armor.ID_EYES_DR, Armor.ID_SKULL_DR, Armor.ID_FACE_DR, Armor.ID_LEG_DR, Armor.ID_ARM_DR, Armor.ID_TORSO_DR, Armor.ID_GROIN_DR, Armor.ID_ARM_DR, Armor.ID_LEG_DR, Armor.ID_HAND_DR, Armor.ID_FOOT_DR, Armor.ID_NECK_DR, Armor.ID_TORSO_DR };

	/**
	 * Creates a new hit location panel.
	 *
	 * @param character The character to display the data for.
	 */
	public HitLocationPanel(GURPSCharacter character) {
		super(new ColumnLayout(7, 2, 0), HIT_LOCATION);

		int i;

		Wrapper wrapper = new Wrapper(new ColumnLayout(1, 2, 0));
		PageHeader header = createHeader(wrapper, ROLL, null);
		addHorizontalBackground(header, Color.black);
		for (i = 0; i < LOCATIONS.length; i++) {
			createLabel(wrapper, ROLLS[i], MessageFormat.format(ROLL_TOOLTIP, LOCATIONS[i]), SwingConstants.CENTER);
		}
		wrapper.setAlignmentY(TOP_ALIGNMENT);
		add(wrapper);

		createDivider();

		wrapper = new Wrapper(new ColumnLayout(1, 2, 0));
		header = createHeader(wrapper, LOCATION, null);
		for (i = 0; i < LOCATIONS.length; i++) {
			wrapper.add(new PageLabel(LOCATIONS[i], header, SwingConstants.CENTER));
		}
		wrapper.setAlignmentY(TOP_ALIGNMENT);
		add(wrapper);

		createDivider();

		wrapper = new Wrapper(new ColumnLayout(1, 2, 0));
		header = createHeader(wrapper, PENALTY, PENALTY_TITLE_TOOLTIP);
		for (i = 0; i < LOCATIONS.length; i++) {
			createLabel(wrapper, PENALTIES[i], MessageFormat.format(PENALTY_TOOLTIP, LOCATIONS[i]), SwingConstants.RIGHT);
		}
		wrapper.setAlignmentY(TOP_ALIGNMENT);
		add(wrapper);

		createDivider();

		wrapper = new Wrapper(new ColumnLayout(1, 2, 0));
		header = createHeader(wrapper, DR, null);
		for (i = 0; i < LOCATIONS.length; i++) {
			createDisabledField(wrapper, character, DR_KEYS[i], MessageFormat.format(DR_TOOLTIP, LOCATIONS[i]), SwingConstants.RIGHT);
		}
		wrapper.setAlignmentY(TOP_ALIGNMENT);
		add(wrapper);
	}

	@Override
	public Dimension getMaximumSize() {
		Dimension size = super.getMaximumSize();
		size.width = getPreferredSize().width;
		return size;
	}

	private void createDivider() {
		Wrapper panel = new Wrapper();
		UIUtilities.setOnlySize(panel, new Dimension(1, 1));
		add(panel);
		addVerticalBackground(panel, Color.black);
	}

	private static void createLabel(Container panel, String title, String tooltip, int alignment) {
		PageLabel label = new PageLabel(title, null);
		label.setHorizontalAlignment(alignment);
		label.setToolTipText(tooltip);
		panel.add(label);
	}
}
