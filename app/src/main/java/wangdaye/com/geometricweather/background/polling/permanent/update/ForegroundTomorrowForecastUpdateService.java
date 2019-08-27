package wangdaye.com.geometricweather.background.polling.permanent.update;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import wangdaye.com.geometricweather.GeometricWeather;
import wangdaye.com.geometricweather.R;
import wangdaye.com.geometricweather.background.polling.basic.ForegroundUpdateService;
import wangdaye.com.geometricweather.basic.model.History;
import wangdaye.com.geometricweather.basic.model.Location;
import wangdaye.com.geometricweather.basic.model.weather.Weather;
import wangdaye.com.geometricweather.remoteviews.presenter.notification.ForecastNotificationIMP;

/**
 * Foreground Today forecast update service.
 * */

public class ForegroundTomorrowForecastUpdateService extends ForegroundUpdateService {

    @Override
    public void updateView(Context context, Location location, @Nullable Weather weather, @Nullable History history) {
        if (ForecastNotificationIMP.isEnable(this, false)) {
            ForecastNotificationIMP.buildForecastAndSendIt(context, weather, false);
        }
    }

    @Override
    public void handlePollingResult(boolean failed) {
        // do nothing.
    }

    @Override
    public NotificationCompat.Builder getForegroundNotification(int index, int total) {
        return super.getForegroundNotification(index, total)
                .setContentTitle(getString(R.string.geometric_weather) + " " + getString(R.string.forecast));
    }

    @Override
    public int getForegroundNotificationId() {
        return GeometricWeather.NOTIFICATION_ID_UPDATING_TOMORROW_FORECAST;
    }
}