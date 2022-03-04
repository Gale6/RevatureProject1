package bankingSystem

import java.io.File

class AccessListFile {

    companion object {

        fun writeToFile(filePath: String, myArray: ArrayList<String>) {
            val file = File(filePath)
            if (!file.exists())
            {
                file.createNewFile()
            }
            file.printWriter().use{ out ->
                for(it in myArray){
                    out.println(it)
                }
            }
        }

        fun readFromFile(filePath: String) :ArrayList<String>{
            val myArray = ArrayList<String>()
            val file = File(filePath)

            if (file.exists()) {
                file.forEachLine {
                    myArray.add(it)
                }
            }
            return myArray
            }
        }
    }
