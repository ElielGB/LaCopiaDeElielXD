package mx.tecnm.misantla.myrecyclev

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity()  {

    var lista:RecyclerView? = null
    var adaptador:AdaptadorCustom? = null
    var layoutManager:RecyclerView.LayoutManager? = null   //el diseño

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         val platillos = ArrayList<Platillo>()

        platillos.add(Platillo("Alitas" ,250.0,4.5F, R.drawable.platillo01))
        platillos.add(Platillo("Ensalada" ,250.0,3.5F, R.drawable.platillo02))
        platillos.add(Platillo("tiwis" ,250.0,2.5F, R.drawable.platillo03))
        platillos.add(Platillo("Carne" ,250.0,1.5F, R.drawable.platillo04))
        platillos.add(Platillo("Coctail" ,250.0,2.5F, R.drawable.platillo05))
        platillos.add(Platillo("Papas Fritas" ,250.0,3.0F, R.drawable.platillo06))
        platillos.add(Platillo("Pollo frito" ,250.0,2.5F, R.drawable.platillo07))
        platillos.add(Platillo("Espagueti" ,250.0,1.5F, R.drawable.platillo08))
        platillos.add(Platillo("Galletas" ,250.0,4.5F, R.drawable.platillo09))
        platillos.add(Platillo("Chile Relleno" ,250.0,5.0F, R.drawable.platillo10))


        lista = findViewById(R.id.Lista)
        lista?.setHasFixedSize(true)  //adaptador tamaño de la vista

        layoutManager = LinearLayoutManager(this)
        lista?.layoutManager = layoutManager  // donde se dibuje el layout

        adaptador = AdaptadorCustom(this,platillos, object: ClickListener{

            override fun onClick(vista: View, index: Int) {
                Toast.makeText(applicationContext, platillos.get(index).nombre, Toast.LENGTH_LONG).show()



                if(index == 0){

                        startActivity(Intent(applicationContext, Bateria::class.java))
                }

            }
        })

        lista?.adapter = adaptador


    }



}