package bankingSystem

import java.io.*


class AccessObjectFile {

    companion object {

        fun writeToFile(filePath: String, obj:Account){
            val fileExist =  File(filePath)
            val file = FileOutputStream(filePath)
            if (!fileExist.exists())
            {
                fileExist.createNewFile()
            }
            val outStream = ObjectOutputStream(file)


            // Method for serialization of object
            outStream.writeObject(obj)

            outStream.close()
            file.close()
        }

        fun readFromFile(filePath: String):Account{
            val file = FileInputStream(filePath)
            val inStream = ObjectInputStream(file)

            // Method for deserialization of object
            val myAccount = inStream.readObject() as Account

            inStream.close()
            file.close()
            return myAccount
        }

    }
}


