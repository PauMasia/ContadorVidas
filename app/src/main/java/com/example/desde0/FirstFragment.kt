package com.example.desde0

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.desde0.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private lateinit var vidaP1sumar: ImageButton
    private lateinit var vidaP1donar: ImageButton
    private lateinit var venomP1sumar: Button
    private lateinit var venomP1quitar: Button

    private lateinit var vidaP2sumar: ImageButton
    private lateinit var vidaP2donar: ImageButton
    private lateinit var venomP2sumar: Button
    private lateinit var venomP2quitar: Button

    private lateinit var upArrow: ImageButton
    private lateinit var downArrow: ImageButton

    private lateinit var text1: TextView
    private lateinit var text2: TextView

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vidaP1sumar= binding.vidaRellena1
        vidaP2sumar= binding.vidaRellena2

        vidaP1donar= binding.vidaVacia1
        vidaP2donar= binding.vidaVacia2

        venomP1sumar= binding.venenoP1sum
        venomP2sumar= binding.venenoP2sum

        venomP1quitar= binding.venenoP1res
        venomP2quitar= binding.venenoP2res

        vidaP1donar= binding.vidaVacia1
        vidaP2donar= binding.vidaVacia2

        upArrow=binding.upArrow
        downArrow=binding.downArrow

        text1=binding.vidaP1
        text2=binding.vidaP2

        vidaP1sumar.setOnClickListener{ponerVida(text1)}
        vidaP2sumar.setOnClickListener{ponerVida(text2)}

        vidaP1donar.setOnClickListener{pasarVida(text1,text2)}
        vidaP2donar.setOnClickListener{pasarVida(text2,text1)}

        venomP1sumar.setOnClickListener{sumarVeneno(text1)}
        venomP2sumar.setOnClickListener{ sumarVeneno(text2)}

        venomP1quitar.setOnClickListener {restarVeneno(text2)}
        venomP2quitar.setOnClickListener {restarVeneno(text1)}

        upArrow.setOnClickListener{escupirVeneno(text2,text1)}
        downArrow.setOnClickListener{escupirVeneno(text1,text2)}

        super.onViewCreated(view, savedInstanceState)

    }
    fun ponerVida(txtVw: TextView){
        txtVw.text= (txtVw.text.split("/")[0].toString().toInt()+1).toString()+"/"+
                    (txtVw.text.split("/")[1].toString().toInt()).toString()
    }
    fun pasarVida(stat1: TextView,stat2: TextView){
        if ((stat1.text.split("/")[0].toString().toInt())>0){
            stat1.text= (stat1.text.split("/")[0].toString().toInt()-1).toString()+"/"+
                    (stat1.text.split("/")[1].toString().toInt()).toString()
            stat2.text= (stat2.text.split("/")[0].toString().toInt()+1).toString()+"/"+
                    (stat2.text.split("/")[1].toString().toInt()).toString()

        }
    }
    fun sumarVeneno(txtVw: TextView){
        txtVw.text= (txtVw.text.split("/")[0].toString().toInt()).toString()+"/"+
                    (txtVw.text.split("/")[1].toString().toInt()+1).toString()
    }
    fun restarVeneno(txtVw: TextView){
        if ((txtVw.text.split("/")[1].toString().toInt())>0) {
            txtVw.text = (txtVw.text.split("/")[0].toString().toInt()).toString() + "/" +
                    (txtVw.text.split("/")[1].toString().toInt() -1).toString()
        }
    }
    fun escupirVeneno(stat1: TextView,stat2: TextView){
        var venenoAtac=stat1.text.split("/")[1].toString().toInt()
        var vidaDef= stat2.text.split("/")[0].toString().toInt()

        stat1.text= (stat1.text.split("/")[0].toString()+"/"+"0")
        if (venenoAtac>=vidaDef){
            stat2.text="0"+"/"+stat2.text.split("/")[1].toString()
        }else {
            stat2.text =(vidaDef - venenoAtac).toString() + "/" + stat2.text.split("/")[1].toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}