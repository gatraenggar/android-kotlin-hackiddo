package gatraenggar.hackiddo

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var nameEditText: EditText
    private lateinit var submitNameButton: Button
    private lateinit var welcomeNameTextView: TextView

    private fun initComponents() {
        nameEditText = findViewById(R.id.nameEditText)
        submitNameButton = findViewById(R.id.submitNameButton)
        welcomeNameTextView = findViewById(R.id.welcomeNameTextView)
    }

    private fun checkFingerPrint() {
        if (packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)) {
            Log.i("Feature", "Feature Fingerprint is ON")
        } else {
            Log.w("Feature", "Feature Fingerprint is OFF")
        }
    }

    private fun checkPlatformVersion() {
        Log.i("SDK", Build.VERSION.SDK_INT.toString())
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) {
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hackiddo)

        initComponents()

        checkFingerPrint()

        submitNameButton.setOnClickListener {
            Log.i("Listener", "button is clicked")

            resources.getStringArray(R.array.LogStringArray).forEach {
                Log.i("LogStringArray", it)
            }

            val json = assets.open("sample.json")
                .bufferedReader()
                .use { it.readText() }
            Log.i("AssetManager", json)

            val jsonRaw = resources.openRawResource(R.raw.sample)
                .bufferedReader()
                .use { it.readText() }
            Log.i("RawResource", jsonRaw)

            val name = nameEditText.text.toString()
            welcomeNameTextView.text = resources.getString(R.string.welcomeNameTextView, name)
            submitNameButton.setBackgroundColor(resources.getColor(R.color.black, theme))
        }
    }
}