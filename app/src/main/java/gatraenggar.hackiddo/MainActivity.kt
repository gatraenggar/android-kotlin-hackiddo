package gatraenggar.hackiddo

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hackiddo)

        initComponents()

        submitNameButton.setOnClickListener {
            Log.i("HCKD", "button is clicked")

            resources.getStringArray(R.array.LogStringArray).forEach {
                Log.i("LogStringArray", it)
            }

            val json = assets.open("sample.json")
                .bufferedReader()
                .use { it.readText() }

            Log.i("AssetManager", json)

            val name = nameEditText.text.toString()
            welcomeNameTextView.text = resources.getString(R.string.welcomeNameTextView, name)
            submitNameButton.setBackgroundColor(resources.getColor(R.color.black, theme))
        }
    }
}