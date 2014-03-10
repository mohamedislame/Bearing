package net.atomcode.bearing;

import android.content.Context;

import net.atomcode.bearing.geocoding.GeocodingTask;
import net.atomcode.bearing.geocoding.GeocodingTaskListener;
import net.atomcode.bearing.geocoding.ReverseGeocodingTask;
import net.atomcode.bearing.location.Accuracy;
import net.atomcode.bearing.location.CurrentLocationListener;
import net.atomcode.bearing.location.CurrentLocationTask;

/**
 * Entry class for Bearing library. Has functions for all major actions
 */
public class Bearing
{
	/**
	 * Geocode query into latitude and longitude
	 * @param context The context of the request
	 * @param query The string queried
	 * @param listener The listener to call back to
	 */
	public static void getAddressListForQuery(Context context, String query, GeocodingTaskListener listener)
	{
		GeocodingTask geocodingTask = new GeocodingTask(context);
		geocodingTask.setGeocodingTaskListener(listener);
		geocodingTask.execute(query);
	}

	/**
	 * Reverse geocode the location into an address
	 * @param context The context of the request
	 * @param latitude The latitude to lookup
	 * @param longitude The longitude to check
	 * @param listener The listener to call back to
	 */
	public static void getAddressListForLocation(Context context, Double latitude, Double longitude, GeocodingTaskListener listener)
	{
		ReverseGeocodingTask geocodingTask = new ReverseGeocodingTask(context);
		geocodingTask.setGeocodingTaskListener(listener);
		geocodingTask.execute(latitude, longitude);
	}

	/**
	 * Get the current location of the user to the given accuracy
	 * @param context The context of the request
	 * @param accuracy The accuracy to which the users location should match.
	 * @param listener The listener to call back to
	 */
	public static void getCurrentLocation(Context context, Accuracy accuracy, CurrentLocationListener listener)
	{
		CurrentLocationTask currentLocationTask = new CurrentLocationTask(context);
		currentLocationTask.setCurrentLocationListener(listener);
		currentLocationTask.execute(accuracy);
	}

	/**
	 * Get the current location of the user to the closest 50 metres.
	 * @param context The context of the request
	 * @param listener The listener to call back to
	 */
	public static void getCurrentLocation(Context context, CurrentLocationListener listener)
	{
		getCurrentLocation(context, Accuracy.MEDIUM, listener);
	}
}
