package app.check.bugfendertest

import android.app.Application
import com.bugfender.android.BuildConfig
import com.bugfender.sdk.Bugfender
import timber.log.Timber


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Bugfender.init(this, "csXRYEkE4To4vSxckW8zPr2tJqf2KmMQ", BuildConfig.DEBUG)
        Bugfender.enableCrashReporting()
        Bugfender.enableUIEventLogging(this)
        Bugfender.enableLogcatLogging()


        if (BuildConfig.DEBUG) {
            Timber.plant(new DebugTree ());
        } else {
            Timber.plant(new CrashReportingTree ());
        }
    }

    private class CrashReportingTree : Timber.Tree() {
        override fun log(
            priority: Int,
            tag: String?,
            message: String,
            t: Throwable?
        ) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                return
            }
            FakeCrashLibrary.log(priority, tag, message)
            if (t != null) {
                if (priority == Log.ERROR) {
                    FakeCrashLibrary.logError(t)
                } else if (priority == Log.WARN) {
                    FakeCrashLibrary.logWarning(t)
                }
            }
        }
    }
}