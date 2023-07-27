package com.example.tamrin5

import android.content.Context
import android.content.pm.PackageManager
import android.content.res.Resources
import android.location.Location
import android.location.LocationManager
import android.os.AsyncTask
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.ui.AppBarConfiguration
import com.example.tamrin5.databinding.ActivityMainBinding

import org.json.JSONObject
import java.net.URL
import java.util.jar.Manifest


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private val API_KEY: String = "c748842b5d05950bf51a13eafa7de8ab";
    private var userLat: Double = 0.0
    private var userLon: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            getLastKnownLocation(this)
        } catch (e: Exception) {
            println("cant get user location!")
        }

        showActivityMain()

    }

    fun showActivityMain(){
        setContentView(R.layout.activity_main);

        val city_lat   = listOf(32.65246, 35.83266, 36.31559, 38.08, 35.69439, 34.05223, 25.77427, 40.71427, 47.60621, 38.89511, 35.52056, 34.6913, 35.02107, 35.18147, 34.69374, -27.46794, -35.28346, -37.814, -31.95224, -33.86785, -30.03283, -8.05389, -22.90642, -12.97111, -23.5475);
        val city_lon   = listOf(51.67462, 50.99155, 59.56796, 46.2919, 51.42151, -118.24368, -80.19366, -74.00597, -122.33207, -77.03637, 139.71722, 135.183, 135.75385, 136.90641, 135.50218, 153.02809, 149.12807, 144.96332, 115.8614, 151.20732, -51.23019, -34.88111, -43.18223, -38.51083, -46.63611);
        val city_names = listOf("Iran, Isfahan", "Iran, Karaj", "Iran, Mashhad", "Iran, Tabriz", "Iran, Tehran", "United States, Los Angeles", "United States, Miami", "United States, New York", "United States, Seattle", "United States, Washington", "Japan, Kawasaki", "Japan, Kobe", "Japan, Kyoto", "Japan, Nagoya", "Japan, Osaka", "Australia, Brisbane", "Australia, Canberra", "Australia, Melbourne", "Australia, Perth", "Australia, Sydney", "Brazil, Porto Alegre", "Brazil, Recife", "Brazil, Rio de Janeiro", "Brazil, Salvador", "Brazil, Sao Paulo")
        val city_buttons = listOf(R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9, R.id.button10, R.id.button11, R.id.button12, R.id.button13, R.id.button14, R.id.button15, R.id.button16, R.id.button17, R.id.button18, R.id.button19, R.id.button20, R.id.button21, R.id.button22, R.id.button23, R.id.button24, R.id.button25)

        val button: Button = findViewById(R.id.button0);
        if (userLat == 0.0 || userLon == 0.0) {
            button.text = "Error: cant get location!"
        } else {
            button.text = "Your Location: ${userLat}  ${userLon}"
            button.setOnClickListener {
                weatherTask().execute(userLat.toString(), userLon.toString())
            }
        }


        for (i in 0..city_buttons.size - 1){
            val button: Button = findViewById(city_buttons[i]);
            button.text = city_names[i]
            button.setOnClickListener {
                weatherTask().execute(city_lat[i].toString(), city_lon[i].toString())
            }
        }



    }

    inner class weatherTask() : AsyncTask<String, Void, String>() {
        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun doInBackground(vararg latlon: String?): String? {
            var response:String?
            try{
                val lat = latlon[0]
                val lon = latlon[1];
                response = URL("https://api.openweathermap.org/data/2.5/forecast?lat=$lat&lon=$lon&appid=$API_KEY").readText(Charsets.UTF_8)
            }catch (e: Exception){
                response = null
                println("failed to use api! " + e.toString())
            }
            return response
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            setContentView(R.layout.content_main)
            val forcastImages = listOf(R.id.forcastImage1, R.id.forcastImage2, R.id.forcastImage3, R.id.forcastImage4, R.id.forcastImage5)
            val forcast_texts = listOf(R.id.forcast1, R.id.forcast2, R.id.forcast3, R.id.forcast4, R.id.forcast5)
            val forcast_dates = listOf(R.id.forcastDate1, R.id.forcastDate2, R.id.forcastDate3, R.id.forcastDate4, R.id.forcastDate5)
            try {
                val jsonObj = JSONObject(result)

                // show city info
                val city = jsonObj.getJSONObject("city")
                val coord = city.getJSONObject("coord")
                val city_info0: TextView = findViewById(R.id.cityname0)
                city_info0.text = "${city.getString("name")} (${city.getString("country")})"
                val city_info1: TextView = findViewById(R.id.cityname1)
                city_info1.text = "Lat: ${coord.getString("lat")}     Lon: ${coord.getString("lon")}"
                val city_info2: TextView = findViewById(R.id.cityname2)
                city_info2.text = "Time: ${jsonObj.getJSONArray("list").getJSONObject(0).getString("dt_txt").split(" ")[0]}"



                // get 5 days forcast
                val list = jsonObj.getJSONArray("list")
                for (i in 0..forcast_texts.size-1) {
                    val forcast = list.getJSONObject(i*8)
                    val dt_txt = forcast.getString("dt_txt").split(" ")[0]
                    val weather = forcast.getJSONArray("weather").getJSONObject(0).getString("main")
                    val forcastImage: ImageView = findViewById(forcastImages[i])
                    val forcast_text: TextView = findViewById(forcast_texts[i])
                    val forcastDate: TextView = findViewById(forcast_dates[i])

                    forcastDate.text = dt_txt
                    forcast_text.text = weather
                    when (weather.lowercase()) {
                        "clouds" -> forcastImage.setImageResource(R.drawable.clouds0)
                        "clear" -> forcastImage.setImageResource(R.drawable.clear0)
                        "rain" -> forcastImage.setImageResource(R.drawable.rain0)
                        "snow" -> forcastImage.setImageResource(R.drawable.snow0)
                        "thunderstorm" -> forcastImage.setImageResource(R.drawable.thunderstorm0)
                        else -> forcastImage.setImageResource(R.drawable.mist0)

                    }

                }


            } catch (e: Exception) {
                println("failed to show result! " + e.toString())
                val city_info0: TextView = findViewById(R.id.cityname0)
                city_info0.text = "Error!"
                val city_info1: TextView = findViewById(R.id.cityname1)
                city_info1.text = "No internet connection!"
                val city_info2: TextView = findViewById(R.id.cityname2)
                city_info2.text = ""
                for (i in 0..forcast_texts.size-1) {
                    val forcastImage: ImageView = findViewById(forcastImages[i])
                    val forcast_text: TextView = findViewById(forcast_texts[i])
                    val forcastDate: TextView = findViewById(forcast_dates[i])

                    forcastDate.text = ""
                    forcast_text.text = ""
                    forcastImage.setImageResource(0)
                }



            }
            // set back button
            val backBtn: Button = findViewById(R.id.buttonBack)
            backBtn.setOnClickListener{
                showActivityMain()
            }

        }
    }


    private fun getLastKnownLocation(context: Context) {
        println("gps ........................... ")
        val locationManager: LocationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val providers: List<String> = locationManager.getProviders(true)
        println("providers size: " + providers.size.toString())
        var location: Location? = null
        for (i in providers.size - 1 downTo 0) {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                println("!! no location permission !!")
//                   return
            } else {
                location = locationManager.getLastKnownLocation(providers[i])
                if (location != null)
                    break
            }
        }


        val gps = DoubleArray(2)
        if (location != null) {
            gps[0] = location.getLatitude()
            gps[1] = location.getLongitude()
            println("gpsLat " + gps[0].toString())
            println("gpsLong " + gps[1].toString())
            userLat = gps[0]
            userLon = gps[1]
        } else {
            println("!! location is null !!")

        }
    }




}





