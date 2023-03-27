package gatraenggar.hackiddo

import android.app.Application
import android.util.Log

class HackiddoApp: Application() {
    override fun onCreate() {
        super.onCreate()
        Log.i(
            "HackiddoApp",
            "Base class for maintaining global application state. " +
                    "You can provide your own implementation by creating " +
                    "a subclass and specifying the fully-qualified name of " +
                    "this subclass as the \"android:name\" attribute in your " +
                    "AndroidManifest.xml's <application> tag."
        )
    }
}