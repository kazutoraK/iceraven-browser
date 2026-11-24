package org.mozilla.fenix

import android.app.Service
import android.content.Intent
import android.os.IBinder
import org.mozilla.fenix.ext.components

class ClearTabsOnTaskRemovedService : Service() {

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_NOT_STICKY
    }

    override fun onTaskRemoved(rootIntent: Intent?) {
        applicationContext.components.useCases.tabsUseCases.removeAllTabs()
        stopSelf()
        super.onTaskRemoved(rootIntent)
    }
}