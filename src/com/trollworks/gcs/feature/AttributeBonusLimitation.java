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

package com.trollworks.gcs.feature;

import com.trollworks.toolkit.annotation.Localize;
import com.trollworks.toolkit.utility.Localization;

/** The limitations applicable to a {@link AttributeBonus}. */
public enum AttributeBonusLimitation {
	/** No limitation. */
	NONE {
		@Override
		public String toString() {
			return NONE_TITLE;
		}
	},
	/** Striking only. */
	STRIKING_ONLY {
		@Override
		public String toString() {
			return STRIKING_ONLY_TITLE;
		}
	},
	/** Lifting only */
	LIFTING_ONLY {
		@Override
		public String toString() {
			return LIFTING_ONLY_TITLE;
		}
	};

	@Localize(" ")
	static String	NONE_TITLE;
	@Localize("for striking only")
	static String	STRIKING_ONLY_TITLE;
	@Localize("for lifting only")
	static String	LIFTING_ONLY_TITLE;

	static {
		Localization.initialize();
	}
}
