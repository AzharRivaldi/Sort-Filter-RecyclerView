package com.azhar.sortnfilter.model

/**
 * Created by Azhar Rivaldi on 04-02-2022
 * Youtube Channel : https://bit.ly/2PJMowZ
 * Github : https://github.com/AzharRivaldi
 * Twitter : https://twitter.com/azharrvldi_
 * Instagram : https://www.instagram.com/azhardvls_
 * LinkedIn : https://www.linkedin.com/in/azhar-rivaldi
 */

class ModelMain(var strRadius: String, var strNama: String, var strDetail: String) {

    companion object {

        var sortByAscRadius = Comparator<ModelMain> { o1, o2 -> o1.strRadius.toInt() - o2.strRadius.toInt() }

        var sortByDescRadius = Comparator<ModelMain> { o1, o2 -> o2.strRadius.toInt() - o1.strRadius.toInt() }

        var sortByNameAZ = Comparator<ModelMain> { o1, o2 -> o1.strNama.compareTo(o2.strNama) }

        var sortByNameZA = Comparator<ModelMain> { o1, o2 -> o2.strNama.compareTo(o1.strNama) }
    }

}