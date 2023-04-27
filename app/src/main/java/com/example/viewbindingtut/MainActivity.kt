package com.example.viewbindingtut

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.viewbindingtut.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

   private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.supportActionBar?.hide()

        binding.time.setOnClickListener {

            val intent=Intent(this,Time_Date_Dialog::class.java)
            startActivity(
                intent
            )
            finish()
        }

        binding.prog.setOnClickListener {
//            val intent = Intent(this,)
        }

        binding.btn1.setOnClickListener {

            //alert dialogue

            val builder1 = AlertDialog.Builder(this)

            builder1.setTitle("Are You Sure?")
            builder1.setMessage("Do You want to close the app")
            builder1.setIcon(R.drawable.baseline_exit_to_app_24)
            //actions

            builder1.setPositiveButton("YES",DialogInterface.OnClickListener { dialogInterface, i ->

                //what action to be performed if yes in clicked
                finish() }
            )
            //negative actions
            builder1.setNegativeButton("NO",DialogInterface.OnClickListener { dialogInterface, i ->

                val intent =Intent(this,MainActivity::class.java)
                startActivity(intent)

                //or dismiss()
            })

            builder1.show()

        }
        binding.btn2.setOnClickListener {

            //
            
            val options = arrayOf("Gulab Jamun","Rasugulla","rasmalai","shahi tukda")
            val builder2 = AlertDialog.Builder(this)

            builder2.setTitle("Favorite sweet")

            builder2.setSingleChoiceItems(options,0,DialogInterface.OnClickListener { dialog, which ->

                //actions to perform when the user clicks ona any items

                Toast.makeText(this,"You clicked on ${options[which]}",Toast.LENGTH_SHORT).show()

            }

            )
            builder2.setPositiveButton("YES",DialogInterface.OnClickListener { dialogInterface, i ->

                //what action to be performed if yes in clicked
                 })
            //nefative actions
            builder2.setNegativeButton("NO",DialogInterface.OnClickListener { dialogInterface, i ->

                val intent =Intent(this,MainActivity::class.java)
                startActivity(intent)
            })

            builder2.show()

        }
        binding.btn3.setOnClickListener {
            //selecting mutliple options in dialoge box


            val options = arrayOf("Gulab Jamun","Rasugulla","rasmalai","shahi tukda")
            val builder3= AlertDialog.Builder(this)

            builder3.setMultiChoiceItems(options,null,DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->

            })

        }



    }
}