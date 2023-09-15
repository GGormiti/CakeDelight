package my.CakeDelight.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint
import my.CakeDelight.R
import my.CakeDelight.databinding.FragmentStartBinding
import kotlin.system.exitProcess

@AndroidEntryPoint
class StartFragment : Fragment() {

    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStartBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recipeBtn.setOnClickListener {
            it.findNavController().navigate(R.id.action_startFragment_to_cakesListFragment)
        }

        binding.exitBtn.setOnClickListener {
            activity?.finish()
            exitProcess(0)
        }

        binding.historyBtn.setOnClickListener {
            it.findNavController().navigate(R.id.action_startFragment_to_historyFragment)
        }
    }

}