package bankingSystem

import java.io.File

class AddDeleteFromSystem {

    companion object{

        fun add(myAccount: Account){

            val objectPath:String = myAccount.username + ".ser"

            var listPath:String = if (!myAccount.Approved){
                "registrationList.txt"
            }else{
                "accountList.txt"
            }
            //update list file
            var myArray = AccessListFile.readFromFile(listPath)
            myArray.add(myAccount.username)
            AccessListFile.writeToFile(listPath,myArray)
            //write to file
            AccessObjectFile.writeToFile(objectPath,myAccount)
        }

        fun approve(myAccount: Account){

            myAccount.Approved = true
            //update list file
            var myArray = AccessListFile.readFromFile("registrationList.txt")
            myArray.remove(myAccount.username)
            AccessListFile.writeToFile("registrationList.txt",myArray)
            add(myAccount)
        }

        fun delete(myAccount: Account){

            var objectPath:String = myAccount.username + ".ser"

            var listPath:String = if (!myAccount.Approved){
                "registrationList.txt"
            }else{
                "accountList.txt"
            }
            //update list file
            var myArray = AccessListFile.readFromFile(listPath)
            myArray.remove(myAccount.username)
            AccessListFile.writeToFile(listPath,myArray)

            //delete object file
            val file = File(objectPath)
            val result = file.delete()
            if (result){
                println("File deleted")
            }else{
                println("File Deletion Unsuccessful")
            }
        }
    }
}
