package com.azhar.sortnfilter.main

import android.os.Bundle
import android.widget.CompoundButton
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.azhar.sortnfilter.R
import com.azhar.sortnfilter.adapter.MainAdapter
import com.azhar.sortnfilter.model.ModelMain
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var modelMainList: MutableList<ModelMain> = ArrayList()
    lateinit var modelMain: ModelMain
    lateinit var mainAdapter: MainAdapter
    lateinit var bottomSheetDialog: BottomSheetDialog
    lateinit var cbAZ: RadioButton
    lateinit var cbZA: RadioButton
    lateinit var cbTerdekat: RadioButton
    lateinit var cbTerjauh: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvListData.setHasFixedSize(true)
        rvListData.setLayoutManager(LinearLayoutManager(this))

        getListData()
        setFilterData()
    }

    private fun getListData() {
            modelMain = ModelMain("7", "Ariel Tatum", "Testing data buat penugasan")
            modelMainList.add(modelMain)
            modelMain = ModelMain("1", "Cinta Laura", "Testing data buat penugasan")
            modelMainList.add(modelMain)
            modelMain = ModelMain("5", "Anya Geraldine", "Testing data buat penugasan")
            modelMainList.add(modelMain)
            modelMain = ModelMain("9", "Maudy Ayunda", "Testing data buat penugasan")
            modelMainList.add(modelMain)
            modelMain = ModelMain("4", "Nabilah JKT48", "Testing data buat penugasan")
            modelMainList.add(modelMain)
            modelMain = ModelMain("8", "Jessica Jane", "Testing data buat penugasan")
            modelMainList.add(modelMain)
            modelMain = ModelMain("10", "Vivi Novika", "Testing data buat penugasan")
            modelMainList.add(modelMain)
            modelMain = ModelMain("2", "N Lidyawati", "Testing data buat penugasan")
            modelMainList.add(modelMain)
            modelMain = ModelMain("3", "Cindy Yuvia", "Testing data buat penugasan")
            modelMainList.add(modelMain)
            modelMain = ModelMain("6", "Babyla", "Testing data buat penugasan")
            modelMainList.add(modelMain)

            mainAdapter = MainAdapter(modelMainList)
            rvListData.adapter = mainAdapter
        }

    private fun setFilterData() {
        fabFilter.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.bottom_sheet_filter, null)

            cbAZ = dialogView.findViewById(R.id.cbAZ)
            cbZA = dialogView.findViewById(R.id.cbZA)
            cbTerdekat = dialogView.findViewById(R.id.cbTerdekat)
            cbTerjauh = dialogView.findViewById(R.id.cbTerjauh)

            bottomSheetDialog = BottomSheetDialog(this@MainActivity)
            bottomSheetDialog.setContentView(dialogView)
            bottomSheetDialog.show()

            cbAZ.setOnCheckedChangeListener { _: CompoundButton?, isChecked: Boolean ->
                if (isChecked) {
                    Collections.sort(modelMainList, ModelMain.sortByNameAZ)
                    mainAdapter.notifyDataSetChanged()
                }
            }

            cbZA.setOnCheckedChangeListener { _: CompoundButton?, isChecked: Boolean ->
                if (isChecked) {
                    Collections.sort(modelMainList, ModelMain.sortByNameZA)
                    mainAdapter.notifyDataSetChanged()
                }
            }

            cbTerdekat.setOnCheckedChangeListener { _: CompoundButton?, isChecked: Boolean ->
                if (isChecked) {
                    Collections.sort(modelMainList, ModelMain.sortByAscRadius)
                    mainAdapter.notifyDataSetChanged()
                }
            }

            cbTerjauh.setOnCheckedChangeListener { _: CompoundButton?, isChecked: Boolean ->
                if (isChecked) {
                    Collections.sort(modelMainList, ModelMain.sortByDescRadius)
                    mainAdapter.notifyDataSetChanged()
                }
            }

        }
    }

}