package my.CakeDelight.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import my.CakeDelight.R
import my.CakeDelight.data.Cake
import my.CakeDelight.databinding.FragmentCakesInfoBinding

@AndroidEntryPoint
class CakesInfoFragment(private val cake: Cake) : Fragment() {

    private var _binding: FragmentCakesInfoBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCakesInfoBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(binding.photoCake).load(cake.photo).into(binding.photoCake)

        binding.name.text = cake.name
        binding.instruction.text = cake.instruction

        cake

        val listIngredient = mutableListOf<String>()
        listIngredient.add(cake.ingredient1)
        listIngredient.add(cake.ingredient2)
        listIngredient.add(cake.ingredient3)
        listIngredient.add(cake.ingredient4)
        listIngredient.add(cake.ingredient5)
        listIngredient.add(cake.ingredient6)
        listIngredient.add(cake.ingredient7)
        listIngredient.add(cake.ingredient8)
        listIngredient.add(cake.ingredient9)
        listIngredient.add(cake.ingredient10)
        listIngredient.add(cake.ingredient11)
        listIngredient.add(cake.ingredient12)
        listIngredient.add(cake.ingredient13)
        listIngredient.add(cake.ingredient14)
        listIngredient.add(cake.ingredient15)
        listIngredient.add(cake.ingredient16)
        listIngredient.add(cake.ingredient17)
        listIngredient.add(cake.ingredient18)
        listIngredient.add(cake.ingredient19)
        listIngredient.add(cake.ingredient20)

        for (n in 0 until listIngredient.size){
            if (listIngredient[n].isNotEmpty()){
                binding.ingredients.append("\n ${listIngredient[n]}")
            }
        }

        val listMeasure = mutableListOf<String>()

        listMeasure.add(cake.measure1)
        listMeasure.add(cake.measure2)
        listMeasure.add(cake.measure3)
        listMeasure.add(cake.measure4)
        listMeasure.add(cake.measure5)
        listMeasure.add(cake.measure6)
        listMeasure.add(cake.measure7)
        listMeasure.add(cake.measure8)
        listMeasure.add(cake.measure9)
        listMeasure.add(cake.measure10)
        listMeasure.add(cake.measure11)
        listMeasure.add(cake.measure12)
        listMeasure.add(cake.measure13)
        listMeasure.add(cake.measure14)
        listMeasure.add(cake.measure15)
        listMeasure.add(cake.measure16)
        listMeasure.add(cake.measure17)
        listMeasure.add(cake.measure18)
        listMeasure.add(cake.measure19)
        listMeasure.add(cake.measure20)

        for (n in 0 until listMeasure.size){
            if (listMeasure[n].isNotEmpty()){
                binding.measure.append("\n ${listMeasure[n]}")
            }
        }

        binding.backButtonToList.setOnClickListener {
            findNavController().navigate(R.id.cakesListFragment)
        }

    }

}