package com.example.tamrin4

//import android.R
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.tamrin4.databinding.ActivityMainBinding
//import android.widget.Button
//import android.widget.ImageButton
//import android.widget.ImageView
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import kotlinx.coroutines.handleCoroutineException


class MainActivity : AppCompatActivity() {

    private lateinit var prices : List<Double>;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // init
        setContentView(R.layout.activity_main)
        prices = listOf(
            1.0,     // ir 0
            35500.0, // us 1
            26820.0, // ca 2
            43800.0, // uk 3
            37470.0, // eu 4
            9740.0,  // em 5
        )

        // set prices
        val irPrice: TextView = findViewById(R.id.irPrice);irPrice.text = prices[0].toString();
        val usPrice: TextView = findViewById(R.id.usPrice);usPrice.text = prices[1].toString();
        val caPrice: TextView = findViewById(R.id.caPrice);caPrice.text = prices[2].toString();
        val ukPrice: TextView = findViewById(R.id.ukPrice);ukPrice.text = prices[3].toString();
        val euPrice: TextView = findViewById(R.id.euPrice);euPrice.text = prices[4].toString();
        val emPrice: TextView = findViewById(R.id.emPrice);emPrice.text = prices[5].toString();

        // add TextWatcher to calculate changes
        val irInput: EditText = findViewById(R.id.irInput);irInput.addTextChangedListener(irTextWatcher)
        val usInput: EditText = findViewById(R.id.usInput);usInput.addTextChangedListener(usTextWatcher)
        val caInput: EditText = findViewById(R.id.caInput);caInput.addTextChangedListener(caTextWatcher)
        val ukInput: EditText = findViewById(R.id.ukInput);ukInput.addTextChangedListener(ukTextWatcher)
        val euInput: EditText = findViewById(R.id.euInput);euInput.addTextChangedListener(euTextWatcher)
        val emInput: EditText = findViewById(R.id.emInput);emInput.addTextChangedListener(emTextWatcher)


    }



    val irTextWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            var userInput: Int = 0;
            try{userInput = s.toString().toInt()
            } catch (e: NumberFormatException){}

            val currentCur: Double = prices[0]
            val irInput: TextView = findViewById(R.id.irPrice);
            val usInput: TextView = findViewById(R.id.usPrice);
            val caInput: TextView = findViewById(R.id.caPrice);
            val ukInput: TextView = findViewById(R.id.ukPrice);
            val euInput: TextView = findViewById(R.id.euPrice);
            val emInput: TextView = findViewById(R.id.emPrice);
            val usInputText: Double = ((userInput * currentCur) / prices[1] * 100).toInt() / 100.0
            val caInputText: Double = ((userInput * currentCur) / prices[2] * 100).toInt() / 100.0
            val ukInputText: Double = ((userInput * currentCur) / prices[3] * 100).toInt() / 100.0
            val euInputText: Double = ((userInput * currentCur) / prices[4] * 100).toInt() / 100.0
            val emInputText: Double = ((userInput * currentCur) / prices[5] * 100).toInt() / 100.0
            irInput.text = Editable.Factory.getInstance().newEditable(userInput.toString())
            usInput.text = Editable.Factory.getInstance().newEditable(usInputText.toString())
            caInput.text = Editable.Factory.getInstance().newEditable(caInputText.toString())
            ukInput.text = Editable.Factory.getInstance().newEditable(ukInputText.toString())
            euInput.text = Editable.Factory.getInstance().newEditable(euInputText.toString())
            emInput.text = Editable.Factory.getInstance().newEditable(emInputText.toString())
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    }

    val usTextWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            var userInput: Int = 0;
            try{userInput = s.toString().toInt()
            } catch (e: NumberFormatException){}
            val currentCur: Double = prices[1]
            val irInput: TextView = findViewById(R.id.irPrice);
            val usInput: TextView = findViewById(R.id.usPrice);
            val caInput: TextView = findViewById(R.id.caPrice);
            val ukInput: TextView = findViewById(R.id.ukPrice);
            val euInput: TextView = findViewById(R.id.euPrice);
            val emInput: TextView = findViewById(R.id.emPrice);
            val irInputText: Double = ((userInput * currentCur) / prices[0] * 100).toInt() / 100.0
            val caInputText: Double = ((userInput * currentCur) / prices[2] * 100).toInt() / 100.0
            val ukInputText: Double = ((userInput * currentCur) / prices[3] * 100).toInt() / 100.0
            val euInputText: Double = ((userInput * currentCur) / prices[4] * 100).toInt() / 100.0
            val emInputText: Double = ((userInput * currentCur) / prices[5] * 100).toInt() / 100.0
            irInput.text = Editable.Factory.getInstance().newEditable(irInputText.toString())
            usInput.text = Editable.Factory.getInstance().newEditable(userInput.toString())
            caInput.text = Editable.Factory.getInstance().newEditable(caInputText.toString())
            ukInput.text = Editable.Factory.getInstance().newEditable(ukInputText.toString())
            euInput.text = Editable.Factory.getInstance().newEditable(euInputText.toString())
            emInput.text = Editable.Factory.getInstance().newEditable(emInputText.toString())
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    }

    val caTextWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            var userInput: Int = 0;
            try{userInput = s.toString().toInt()
            } catch (e: NumberFormatException){}
            val currentCur: Double = prices[2]
            val irInput: TextView = findViewById(R.id.irPrice);
            val usInput: TextView = findViewById(R.id.usPrice);
            val caInput: TextView = findViewById(R.id.caPrice);
            val ukInput: TextView = findViewById(R.id.ukPrice);
            val euInput: TextView = findViewById(R.id.euPrice);
            val emInput: TextView = findViewById(R.id.emPrice);
            val irInputText: Double = ((userInput * currentCur) / prices[0] * 100).toInt() / 100.0
            val usInputText: Double = ((userInput * currentCur) / prices[1] * 100).toInt() / 100.0
            val ukInputText: Double = ((userInput * currentCur) / prices[3] * 100).toInt() / 100.0
            val euInputText: Double = ((userInput * currentCur) / prices[4] * 100).toInt() / 100.0
            val emInputText: Double = ((userInput * currentCur) / prices[5] * 100).toInt() / 100.0
            irInput.text = Editable.Factory.getInstance().newEditable(irInputText.toString())
            usInput.text = Editable.Factory.getInstance().newEditable(usInputText.toString())
            caInput.text = Editable.Factory.getInstance().newEditable(userInput.toString())
            ukInput.text = Editable.Factory.getInstance().newEditable(ukInputText.toString())
            euInput.text = Editable.Factory.getInstance().newEditable(euInputText.toString())
            emInput.text = Editable.Factory.getInstance().newEditable(emInputText.toString())
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    }

    val ukTextWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            var userInput: Int = 0;
            try{userInput = s.toString().toInt()
            } catch (e: NumberFormatException){}
            val currentCur: Double = prices[3]
            val irInput: TextView = findViewById(R.id.irPrice);
            val usInput: TextView = findViewById(R.id.usPrice);
            val caInput: TextView = findViewById(R.id.caPrice);
            val ukInput: TextView = findViewById(R.id.ukPrice);
            val euInput: TextView = findViewById(R.id.euPrice);
            val emInput: TextView = findViewById(R.id.emPrice);
            val irInputText: Double = ((userInput * currentCur) / prices[0] * 100).toInt() / 100.0
            val usInputText: Double = ((userInput * currentCur) / prices[1] * 100).toInt() / 100.0
            val caInputText: Double = ((userInput * currentCur) / prices[2] * 100).toInt() / 100.0
            val euInputText: Double = ((userInput * currentCur) / prices[4] * 100).toInt() / 100.0
            val emInputText: Double = ((userInput * currentCur) / prices[5] * 100).toInt() / 100.0
            irInput.text = Editable.Factory.getInstance().newEditable(irInputText.toString())
            usInput.text = Editable.Factory.getInstance().newEditable(usInputText.toString())
            caInput.text = Editable.Factory.getInstance().newEditable(caInputText.toString())
            ukInput.text = Editable.Factory.getInstance().newEditable(userInput.toString())
            euInput.text = Editable.Factory.getInstance().newEditable(euInputText.toString())
            emInput.text = Editable.Factory.getInstance().newEditable(emInputText.toString())
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    }

    val euTextWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            var userInput: Int = 0;
            try{userInput = s.toString().toInt()
            } catch (e: NumberFormatException){}
            val currentCur: Double = prices[4]
            val irInput: TextView = findViewById(R.id.irPrice);
            val usInput: TextView = findViewById(R.id.usPrice);
            val caInput: TextView = findViewById(R.id.caPrice);
            val ukInput: TextView = findViewById(R.id.ukPrice);
            val euInput: TextView = findViewById(R.id.euPrice);
            val emInput: TextView = findViewById(R.id.emPrice);
            val irInputText: Double = ((userInput * currentCur) / prices[0] * 100).toInt() / 100.0
            val usInputText: Double = ((userInput * currentCur) / prices[1] * 100).toInt() / 100.0
            val caInputText: Double = ((userInput * currentCur) / prices[2] * 100).toInt() / 100.0
            val ukInputText: Double = ((userInput * currentCur) / prices[3] * 100).toInt() / 100.0
            val emInputText: Double = ((userInput * currentCur) / prices[5] * 100).toInt() / 100.0
            irInput.text = Editable.Factory.getInstance().newEditable(irInputText.toString())
            usInput.text = Editable.Factory.getInstance().newEditable(usInputText.toString())
            caInput.text = Editable.Factory.getInstance().newEditable(caInputText.toString())
            ukInput.text = Editable.Factory.getInstance().newEditable(ukInputText.toString())
            euInput.text = Editable.Factory.getInstance().newEditable(userInput.toString())
            emInput.text = Editable.Factory.getInstance().newEditable(emInputText.toString())
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    }

    val emTextWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            var userInput: Int = 0;
            try{userInput = s.toString().toInt()
            } catch (e: NumberFormatException){}
            val currentCur: Double = prices[5]
            val irInput: TextView = findViewById(R.id.irPrice);
            val usInput: TextView = findViewById(R.id.usPrice);
            val caInput: TextView = findViewById(R.id.caPrice);
            val ukInput: TextView = findViewById(R.id.ukPrice);
            val euInput: TextView = findViewById(R.id.euPrice);
            val emInput: TextView = findViewById(R.id.emPrice);
            val irInputText: Double = ((userInput * currentCur) / prices[0] * 100).toInt() / 100.0
            val usInputText: Double = ((userInput * currentCur) / prices[1] * 100).toInt() / 100.0
            val caInputText: Double = ((userInput * currentCur) / prices[2] * 100).toInt() / 100.0
            val ukInputText: Double = ((userInput * currentCur) / prices[3] * 100).toInt() / 100.0
            val euInputText: Double = ((userInput * currentCur) / prices[4] * 100).toInt() / 100.0
            irInput.text = Editable.Factory.getInstance().newEditable(irInputText.toString())
            usInput.text = Editable.Factory.getInstance().newEditable(usInputText.toString())
            caInput.text = Editable.Factory.getInstance().newEditable(caInputText.toString())
            ukInput.text = Editable.Factory.getInstance().newEditable(ukInputText.toString())
            euInput.text = Editable.Factory.getInstance().newEditable(euInputText.toString())
            emInput.text = Editable.Factory.getInstance().newEditable(userInput.toString())
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    }



}