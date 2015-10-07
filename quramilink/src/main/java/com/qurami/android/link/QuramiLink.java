package com.qurami.android.link;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

/**
 * Created by vfede on 06/10/2015.
 * 
 * Copyright © 2015 Qurami. All rights reserved.
 */
public class QuramiLink {

	private static final String ACTION_LAUNCH_OFFICEPAGE = "com.qurami.android.action.LAUNCH_OFFICEPAGE";

	/**
	 * This static method lets you open an Office directly in the Qurami app. If the Qurami app is missing on the user
	 * device, the Play Store is opened to the download page.
	 * 
	 * @param context
	 *            A context
	 * @param officeLink
	 *            The OfficeLink code of the desired office. It is provided by Qurami Srl.
	 * @return true if an activity was launched, false otherwise
	 */
	public static boolean openQuramiOfficeWithOfficeLink(Context context, String officeLink) {
		PackageManager packageManager = context.getPackageManager();

		if (officeLink == null)
			throw new NullPointerException("officeLink can't be null");
		if (officeLink.length() != 39)
			throw new IllegalArgumentException("officeLink must be 39 chars long");

		Intent openQuramiOfficeIntent = new Intent();
		openQuramiOfficeIntent.setAction(ACTION_LAUNCH_OFFICEPAGE);
		openQuramiOfficeIntent.setData(Uri.parse("quramiapp://?officeLink=" + officeLink));

		// Verify that the intent will resolve to an activity or it will throw an exception
		if (openQuramiOfficeIntent.resolveActivity(packageManager) != null) {
			context.startActivity(openQuramiOfficeIntent);
			return true;
		}
		else {
			Intent openQuramiAppInPlayStore = new Intent(Intent.ACTION_VIEW);
			openQuramiAppInPlayStore.setData(Uri.parse("market://details?id=com.qqs.androidapp"));

			if (openQuramiAppInPlayStore.resolveActivity(packageManager) != null) {
				context.startActivity(openQuramiAppInPlayStore);
				return true;

			} else {
				openQuramiAppInPlayStore.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.qqs.androidapp"));

				if (openQuramiAppInPlayStore.resolveActivity(packageManager) != null) {
					context.startActivity(openQuramiAppInPlayStore);
					return true;
				}
			}
		}
		return false;
	}
}
