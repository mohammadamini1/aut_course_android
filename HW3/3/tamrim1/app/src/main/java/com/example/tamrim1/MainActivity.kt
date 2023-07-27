package com.example.tamrim1

//noinspection SuspiciousImport
//import android.R
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.tamrim1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView_activity_main2();

    }

    fun setContentView_activity_main() {
        setContentView(R.layout.activity_main);
        // id inits
        val myImage0: ImageButton = findViewById(R.id.imageBtn0)
        val myImage1: ImageButton = findViewById(R.id.imageBtn1)
        val myImage2: ImageButton = findViewById(R.id.imageBtn2)
        val myImage3: ImageButton = findViewById(R.id.imageBtn3)
        val myImage4: ImageButton = findViewById(R.id.imageBtn4)
        val myBookText0: TextView = findViewById(R.id.bookName0)
        val myBookText1: TextView = findViewById(R.id.bookName1)
        val myBookText2: TextView = findViewById(R.id.bookName2)
        val myBookText3: TextView = findViewById(R.id.bookName3)
        val myBookText4: TextView = findViewById(R.id.bookName4)
        val myAuthorText0: TextView = findViewById(R.id.authorName0)
        val myAuthorText1: TextView = findViewById(R.id.authorName1)
        val myAuthorText2: TextView = findViewById(R.id.authorName2)
        val myAuthorText3: TextView = findViewById(R.id.authorName3)
        val myAuthorText4: TextView = findViewById(R.id.authorName4)
        val myBookImages = listOf(myImage0, myImage1, myImage2, myImage3, myImage4)
        val myBookNames = listOf(myBookText0, myBookText1, myBookText2, myBookText3, myBookText4)
        val myBookAuthors = listOf(myAuthorText0, myAuthorText1, myAuthorText2, myAuthorText3, myAuthorText4)


        // lists
        val bookImages = listOf(R.drawable.harry0, R.drawable.harry1, R.drawable.harry2, R.drawable.harry3, R.drawable.harry4)
        val bookNames = listOf("book name 0", "book name 1", "book name 2", "book name 3", "book name 4")
        val bookAuthors = listOf("author 0", "author 1", "author 2", "author 3", "author 4")


        for (i in myBookImages.indices) {
            // set resources
            myBookImages[i].setImageResource(bookImages[i])
            myBookNames[i].text = bookNames[i]
            myBookAuthors[i].text = bookAuthors[i]
            // set button listener
            myBookImages[i].setOnClickListener {
                setContentView(R.layout.fragment_second)

                val infoPageImage: ImageView = findViewById(R.id.infoPageImage0)
                infoPageImage.setImageResource(bookImages[i])
                val infoPageName: TextView = findViewById(R.id.infoPageText0)
                infoPageName.text = bookNames[i]
                val infoPageAuthor: TextView = findViewById(R.id.infoPageText1)
                infoPageAuthor.text = bookAuthors[i]

                val backButton: Button = findViewById(R.id.backButton0)
                backButton.setOnClickListener {
                    setContentView_activity_main()
                }

            }


        }







    }

    fun setContentView_activity_main2() {
        setContentView(R.layout.activity_main2);
        // id inits
        val myImage0: ImageButton = findViewById(R.id.imageBtn0)
        val myImage1: ImageButton = findViewById(R.id.imageBtn1)
        val myImage2: ImageButton = findViewById(R.id.imageBtn2)
        val myImage3: ImageButton = findViewById(R.id.imageBtn3)
        val myImage4: ImageButton = findViewById(R.id.imageBtn4)
        val myBookImages = listOf(myImage0, myImage1, myImage2, myImage3, myImage4)

        // lists
        val bookImages = listOf(R.drawable.harry0, R.drawable.harry1, R.drawable.harry2, R.drawable.harry3, R.drawable.harry4)
        val bookNames = listOf("name0", "name1", "name2", "name3", "name4")
        val bookAuthors = listOf("author0", "author1", "author2", "author3", "author4")


        for (i in myBookImages.indices) {
            // set resources
            myBookImages[i].setImageResource(bookImages[i])
            // set button listener
            myBookImages[i].setOnClickListener {
                setContentView(R.layout.fragment_second)

                val infoPageImage: ImageView = findViewById(R.id.infoPageImage0)
                infoPageImage.setImageResource(bookImages[i])
                val infoPageName: TextView = findViewById(R.id.infoPageText0)
                infoPageName.text = bookNames[i]
                val infoPageAuthor: TextView = findViewById(R.id.infoPageText1)
                infoPageAuthor.text = bookAuthors[i]

                val backButton: Button = findViewById(R.id.backButton0)
                backButton.setOnClickListener {
                    setContentView_activity_main()
                }

            }


        }







    }


//    override fun onCreate(savedInstanceState: Bundle?) {
//
//        super.onCreate(savedInstanceState)
//
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        setSupportActionBar(binding.toolbar)
//
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)
//
//        binding.fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
//        }
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.menu_main, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        return when (item.itemId) {
//            R.id.action_settings -> true
//            else -> super.onOptionsItemSelected(item)
//        }
//    }
//
//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        return navController.navigateUp(appBarConfiguration)
//                || super.onSupportNavigateUp()
//    }
}