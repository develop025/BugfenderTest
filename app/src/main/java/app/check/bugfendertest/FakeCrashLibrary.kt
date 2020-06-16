package app.check.bugfendertest

class FakeCrashLibrary {

    fun log(priority: Int, tag: String?, message: String?) {
        // TODO add log entry to circular buffer.
    }

    fun logWarning(t: Throwable?) {
        // TODO report non-fatal warning.
    }

    fun logError(t: Throwable?) {
        // TODO report non-fatal error.
    }

    init {
        throw AssertionError("No instances.")
    }
}