package gatraenggar.hackiddo

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
//    # 1st method
//    lateinit var mainActivityScenario: ActivityScenario<MainActivity>

//    @Before
//    fun setUp() {
//        mainActivityScenario = ActivityScenario.launch(MainActivity::class.java)
//    }
//
//    @Test
//    fun testBlank() {
//
//    }
//
//    @After
//    fun tearDown() {
//        mainActivityScenario.close()
//    }

//  # 2nd method
    @get:Rule
    var mainActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testSubmitName() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val name = "hackiddo"

        onView(withId(R.id.nameEditText))
            .perform(typeText(name))

        onView(withId(R.id.submitNameButton))
            .perform(click())

        val expected = context.getString(R.string.welcomeNameTextView,name)
        onView(withId(R.id.welcomeNameTextView))
            .check(matches(withText(expected)))

        Thread.sleep(2000)
    }
}